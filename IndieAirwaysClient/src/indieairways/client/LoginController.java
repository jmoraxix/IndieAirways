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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author jmora
 */
public class LoginController extends BaseController {

    @FXML
    private TextField txtUser;
    @FXML
    private Button btnCreateUser;
    @FXML
    private Button btnLogin;
    @FXML
    private PasswordField txtPasswd;
    @FXML
    private Label labelAlert;

    private boolean loginCorrect;

     /**
     * It validates that the info introduced is correct
     *
     * @param event: not used
     */
    @FXML
    private void handleLogin(ActionEvent event) {
        loginCorrect = true;

        if (!txtUser.getText().equals("Carlos") && !txtPasswd.getText().equals("23")) {
            labelAlert.setText("Wrong User or Password.");
            labelAlert.setTextFill(Color.rgb(210, 39, 30));
            loginCorrect = false;
        }

    }

    @FXML
    private void handleNewUser(ActionEvent event) {
    }

     /**
     * It is the initialize of the scene. It is a method that has to be implemented.   
     * In the case the "create User" button is clicked, it goes to such window.
     * In the case the house is clicked, it logins correctly, it goes to the Menu window
     *
     * @param url: not used, ResourceBoundle: not used
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnCreateUser.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
            application.gotoCreateUser();
        });

        btnLogin.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
            application.gotoMenu();
        });

        labelAlert.setText("");

    }

}
