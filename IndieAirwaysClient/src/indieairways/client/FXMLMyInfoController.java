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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Carlos
 */
public class FXMLMyInfoController extends BaseController {
    
    @FXML private TextField textFUser;
    @FXML private TextField textFName;
    @FXML private TextField textFLastName;
    @FXML private TextField textFLastEmail;
    @FXML private DatePicker datePickerBirth;
    @FXML private Label labelPass;
    @FXML private Button btnSave;
    @FXML private Label labelSavedMessage;
    @FXML private ImageView btnHome;

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
