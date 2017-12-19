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
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;



public class FXMLReservaOneWayController implements Initializable {

    @FXML private ImageView btnBack;
    @FXML private Button bNext;
    @FXML private Label lPrice;
    @FXML private Label lDepDate;
    @FXML private Label lDepTime;
    @FXML private Label lArriTime;
    @FXML private Label lFliTime;
    @FXML private Label lDepCity; //cBF
    @FXML private Label lArriCity; //cBTO
    @FXML private Label lFliNum;
    
    
    public FXMLDatosReservaController datosReserva; 
    
    private IndieAirwaysClient application;
    
    public void setApp(IndieAirwaysClient application) {
        this.application = application;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO        
        btnBack.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)-> { //Ir a la pantalla anterior
            //System.out.println("Paso");
            application.gotoVerReserva();
        });
        
    }   
    
    public void setText(String depCity, String arriCity, LocalDate depDate){
        lDepCity.setText(depCity); 
        lArriCity.setText(arriCity);
        lDepDate.setText(depDate.toString());
        
    }
    
}
