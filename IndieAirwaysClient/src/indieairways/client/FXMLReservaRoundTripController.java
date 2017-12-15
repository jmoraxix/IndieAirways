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
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FXMLReservaRoundTripController implements Initializable {
    
    @FXML private Button bBack;
    @FXML private Button bNext;
    @FXML private Label lPrice;
    @FXML private Label lDepDate;
    @FXML private Label lDepTime;
    @FXML private Label lArriTime;
    @FXML private Label lFliTime;
    @FXML private Label lRetDate;
    @FXML private Label lDepTimeRe;
    @FXML private Label lArriTimeRe;
    @FXML private Label lFliTimeRe;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
