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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Carlos
 */
public class FXMLMyFlightsController extends BaseController {
    
    @FXML private Label labelUser;
    @FXML private Accordion accordionMyFlights;
    @FXML private ImageView btnHome;
    

    protected void setApp(IndieAirwaysClient application) {
        this.application = application;
    }
    
    private void handleGoHome(ActionEvent event) throws IOException {
    }
    
    /**
     * It is the initialize of the scene. It is a method that has to be implemented.
     * It initializes the home button so you are able to go back to the menu
     * 
     * @param url: not used, ResourceBoundle: not used
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnHome.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
            application.gotoMenu();
        });
    }    
    
}
