/*
 * Programacion Concurrente Cliente Servidor
 * 
 * Emilio Evans Rodriguez
 * Jose David Mora Loria
 * Carlos Oreamuno Alfaro
 * 
 * Tercer cuatrimestre, 2017
 * Ulacit
 */
package indieairways.client;

//import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class FXMLDatosReservaController implements Initializable{

    @FXML private Button bn2; //Boton de ok
    @FXML private ComboBox cBF; //ComboBox From
    @FXML private ComboBox cBTO; //ComboBoz To
    @FXML private DatePicker dPF; //DatePicker From
    @FXML private DatePicker dPTO; //DatePicker To
    @FXML private RadioButton rBOW; //RadioButton One-Way
    @FXML private RadioButton rBRT; //RadioButton Round Trip
    @FXML private ComboBox cBLugg; //Combo Box for quantity of luggage
    @FXML private ComboBox cBPassang;  //Cambo Box for quantity of passangers
    @FXML private RadioButton rBEconomy; //Radio Button for Economy Class
    @FXML private RadioButton rBBuis; //Radio Button for Buisness Class
    @FXML private RadioButton rBFirClass; //Radio Button for First Class
    @FXML private ImageView btnHome;
    @FXML private Label labelAlert;
    @FXML private Label labelTimer;
    @FXML private Button btnPrueba;

    private IndieAirwaysClient application;

    private final ToggleGroup tipoVueloTG = new ToggleGroup();
    private final ToggleGroup tipoClaseTG = new ToggleGroup();

    private DateCell fromCell, toCell = null; //verificar la fecha
    private LocalDate fromDate, toDate = null;
    //private String pattern1 = "dd-MM";

    private int tipoVuelo; //0 si es One-Way, 1 si es Round Trip 
    private String ciudadOrigen, ciudadDestino;
    private int ddF, ffF, ddT, ffT; //dias y mes de ida, dia y mes de venida.
    private int tipoClase;
    private int numPasajeros;
    private int numMaletas;
    private boolean datosCorrectos;
    
    private Service<Void> thread; //= new Service<Void>;

    ObservableList<String> ciudades = FXCollections.observableArrayList("San Jose", "Tokyo", "Milan", "Barcelona", "Cairo");
    ObservableList<String> maletas = FXCollections.observableArrayList("1", "2", "3");
    ObservableList<String> pasajeros = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6");

    @FXML
    private void handleOneWay(ActionEvent event) {
        //dPTO.disableProperty();
        dPTO.setEditable(false);
    }
    
    public ComboBox getcBF() {
        return cBF;
    }

    public void setcBF(ComboBox cBF) {
        this.cBF = cBF;
    }

    public ComboBox getcBTO() {
        return cBTO;
    }

    public void setcBTO(ComboBox cBTO) {
        this.cBTO = cBTO;
    }

    public DatePicker getdPF() {
        return dPF;
    }

    public void setdPF(DatePicker dPF) {
        this.dPF = dPF;
    }

    public DatePicker getdPTO() {
        return dPTO;
    }

    public void setdPTO(DatePicker dPTO) {
        this.dPTO = dPTO;
    }

    public int getNumPasajeros() {
        return numPasajeros;
    }

    public void setNumPasajeros(int numPasajeros) {
        this.numPasajeros = numPasajeros;
    }

    public int getNumMaletas() {
        return numMaletas;
    }

    public void setNumMaletas(int numMaletas) {
        this.numMaletas = numMaletas;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }
    
    @FXML
    private void handleBn2Action(ActionEvent event) throws IOException {

        datosCorrectos = true;
                
        //Valida los radio button del tipo vuelo
        if (rBOW.isSelected()) {
            tipoVuelo = 0;
        } else if (rBRT.isSelected()) {
            tipoVuelo = 1;
        } else{
            labelAlert.setText("You have to enter a type of flight");
            datosCorrectos = false;
        }

        //Validaciones para los comboBox
        if (cBTO.getSelectionModel().isEmpty() || cBF.getSelectionModel().isEmpty()) {
            labelAlert.setText("You have to put a departure and a destination city."); /*"  + "\n" + "*/
            labelAlert.setTextFill(Color.rgb(210, 39, 30));
            datosCorrectos = false;
        } else if (cBF.getValue().equals(cBTO.getValue()) ){
            labelAlert.setText("You can't put the same city as departure and destination.");
            labelAlert.setTextFill(Color.rgb(210, 39, 30));
            datosCorrectos = false; 
        }else {
            ciudadOrigen = (String) cBF.getValue();
            ciudadDestino = (String) cBTO.getValue();
        }

        fromDate = dPF.getValue();
        toDate = dPTO.getValue();
        if (fromDate.equals(toDate)) {
            labelAlert.setText("Invalid date, they are the same date.");
            labelAlert.setTextFill(Color.rgb(210, 39, 30));
            datosCorrectos = false;
        }

        if (A_menor(fromDate, toDate)) {
            labelAlert.setText("Invalid date, returning date is before the departure one.");
            labelAlert.setTextFill(Color.rgb(210, 39, 30));
            datosCorrectos = false;
        }
            
        if(cBPassang.getSelectionModel().isEmpty()){
            labelAlert.setText("You have to enter a number of Passangers.");
            labelAlert.setTextFill(Color.rgb(210, 39, 30));
            datosCorrectos = false;
        }else{
            numPasajeros = Integer.parseInt((String)(cBPassang.getValue()));
        }
        
        if(cBLugg.getSelectionModel().isEmpty()){
            labelAlert.setText("You have to enter a number of Luggage.");
            labelAlert.setTextFill(Color.rgb(210, 39, 30));
            datosCorrectos = false;
        }else{
            numMaletas =  Integer.parseInt((String)(cBLugg.getValue()));
        }
        

        if (rBEconomy.isSelected()) {
            tipoClase = 0;
        } else if (rBFirClass.isSelected()) {
            tipoClase = 1;
        } else if (rBBuis.isSelected()) {
            tipoClase = 2;
        } else {
            labelAlert.setText("You have to enter a type of Class.");
            labelAlert.setTextFill(Color.rgb(210, 39, 30));
            datosCorrectos = false;
        }
        
        application.setCiudadO(ciudadOrigen);
        application.setCityD(ciudadDestino);
        application.setDepDate(fromDate);
        
        if(tipoVuelo == 1){
            application.setCiudadO(ciudadOrigen);
            application.setCityD(ciudadDestino);
            application.setDepDate(fromDate);
            application.setDepDate2(toDate);
        }
            
        System.out.println("Tipo de vuelo es " + tipoVuelo + "\nCiudad Origen: " + ciudadOrigen
                + "\nCiudad Destino: " + ciudadDestino + "\nFecha Salida: " + fromDate
                + "\nFecha de Regreso: " + toDate + "\nNumero de pasajeros: " + numPasajeros
                + "\nNumero de maletas: " + numMaletas + "\nTipo de Clase: " + tipoClase);

    }
    
    @FXML
    private void handleTimer(ActionEvent event) {
        runTimer();
    }
    
    public void runTimer(){
        //System.out.println("Entra al metodo runTimer");
        //Timer timer = new Timer(1);
        ///timer.start();
        thread = new Service<Void>(){

            @Override
            protected Task<Void> createTask() {
                return new Task<Void>(){

                    @Override
                    protected Void call() throws Exception {
                        for(int i = 1000000000; i >= 0; i--){
                            //setLabelTimer(i);
                            updateMessage(String.valueOf(i));
                            
                        }
                        return null;
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                };
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            } 
        };
        
        labelTimer.textProperty().bind(thread.messageProperty());
        //labelTimer.textProperty().unbind();
        thread.restart();
        
    }
    
    public void setLabelTimer(int n){
        labelTimer.setText(String.valueOf(n));
        //labelTimer.setText("60");
    }
   
    public boolean A_menor(LocalDate l1, LocalDate l2) { //Revisa si la fecha es menor
        boolean esMenor = false;

        if (l1.getYear() > l2.getYear()) {
            esMenor = true;
        } else if ((l1.getYear() == l2.getYear()) && (l1.getMonthValue() > l2.getMonthValue())) {
            esMenor = true;
        } else if ((l1.getYear() == l2.getYear()) && (l1.getMonthValue() == l2.getMonthValue()) && (l1.getDayOfMonth() > l2.getDayOfMonth())) {
            esMenor = true;
        }

        return esMenor;
    }

    public void setApp(IndieAirwaysClient application) {
        this.application = application;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cBF.getItems().addAll(ciudades);
        cBTO.getItems().addAll(ciudades);
        cBLugg.getItems().addAll(maletas);
        cBPassang.getItems().addAll(pasajeros);
        
        rBOW.setToggleGroup(tipoVueloTG);
        rBRT.setToggleGroup(tipoVueloTG);

        rBEconomy.setToggleGroup(tipoClaseTG);
        rBBuis.setToggleGroup(tipoClaseTG);
        rBFirClass.setToggleGroup(tipoClaseTG);

        bn2.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
            if(tipoVuelo == 0 && datosCorrectos)
                application.gotoReservaOneWay(); 
            else if(tipoVuelo == 1 && datosCorrectos)
                application.gotoReservaRoundTrip();
        });
        
        btnHome.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
            application.gotoMenu();
        });

        //runTimer();
        labelTimer.setText("-");
    }
    
}//Fin de la clase FXMLDatosReservaController
