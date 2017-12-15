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

import java.net.URL;
import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.List;
import java.util.ResourceBundle;
//import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
//import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
//import javafx.scene.text.Text;
//import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class FXMLDatosReservaController implements Initializable {
    
    @FXML private Label label;
    @FXML private Button bn2;
    @FXML private ComboBox cBF;
    @FXML private ComboBox cBTO;
    @FXML private DatePicker dPF;
    @FXML private DatePicker dPTO;
    @FXML private RadioButton rBOW;
    @FXML private RadioButton rBRT;
    
    private IndieAirwaysClient application;
    
    private final ToggleGroup tipoVueloB = new ToggleGroup();
    private DateCell fromCell, toCell = null;
    private LocalDate fromDate, toDate = null;
    //private String pattern1 = "dd-MM";
    
    private int tipoVuelo; //0 si es One-Way, 1 si es Round Trip 
    private String ciudadOrigen, ciudadDestino;
    private int ddF, ffF, ddT, ffT; //dias y mes de ida, dia y mes de venida.
    
    
    ObservableList<String> ciudades = FXCollections.observableArrayList("San Jose", "Tokyo", "Milan", "Barcelona", "Cairo");
    
    @FXML
    private void habdleBn2Action(ActionEvent event){

        try{ //Errores que pueden ocurrir con las Check Boxes
            if(rBOW.isSelected())
                tipoVuelo = 0;
            else if(rBRT.isSelected())
                tipoVuelo = 1;
        } catch (Exception e){
            //System.out.println("Escoga solamente una caja");
            JOptionPane.showMessageDialog(null, "Mensaje");
        } 
        
        try{ //Errores que pueden ocurrir con las Choice Boxes
            if(cBF.getValue().equals(cBTO.getValue())) {
                System.out.println("No puede ingresar ambos lugares iguales");
            } else {
                ciudadOrigen = (String) cBF.getValue();
                ciudadDestino = (String) cBTO.getValue();
            }
                
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Mensaje");
        }
        
        try{
            fromDate = dPF.getValue();
            toDate = dPTO.getValue();
            if(fromDate.equals(toDate)){
                JOptionPane.showMessageDialog(null, "Fecha invalida");
            }
            
            if(A_menor(fromDate, toDate))
                JOptionPane.showMessageDialog(null, "Fecha invalida");
            
        }catch(Exception e){
            
        }
       
        System.out.println("Tipo de vuelo es " + tipoVuelo + "\nCiudad Origen: " + ciudadOrigen + 
                "\nCiudad Destino: " + ciudadDestino + "\nFecha Salida: " + fromDate 
                + "\nFecha de Regreso: " + toDate);
        
        
    }
    
    public boolean A_menor(LocalDate l1, LocalDate l2){ //Revisa si la fecha es menor
        boolean esMenor = false;
        
        if(l1.getYear() > l2.getYear())
            esMenor = true;
        else if( (l1.getYear() == l2.getYear() ) && (l1.getMonthValue() > l2.getMonthValue() ) )
            esMenor = true;
        else if( (l1.getYear() == l2.getYear() ) && (l1.getMonthValue() == l2.getMonthValue() ) && (l1.getDayOfMonth() > l2.getDayOfMonth()) )
            esMenor = true;
        
        return esMenor;
    }
    

    public void setApp(IndieAirwaysClient application) {
        this.application = application;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cBF.getItems().addAll(ciudades);
        cBTO.getItems().addAll(ciudades);
        
        rBOW.setToggleGroup(tipoVueloB);
        rBRT.setToggleGroup(tipoVueloB);
    }    
    
}
