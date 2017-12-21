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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author jmora
 */
public class LoginController implements Initializable {

    @FXML private TextField txtUser;
    @FXML private Button btnCreateUser;
    @FXML private Button btnLogin;
    @FXML private PasswordField txtPasswd;
    @FXML private Label labelAlert;

    private IndieAirwaysClient application;

    private boolean loginCorrect;
    /**
     * Define la aplicacion principal para manejo de ventanas
     *
     * @param application
     */
    public void setApp(IndieAirwaysClient application) {
        this.application = application;
    }
    
    @FXML 
    private void handleLogin(ActionEvent event) {
        //Validar el user
        //Validar que le corresponde la pass
        loginCorrect = true;
        
        if(! txtUser.getText().equals("Carlos") && ! txtPasswd.getText().equals("23")){
            labelAlert.setText("Wrong User or Password.");
            labelAlert.setTextFill(Color.rgb(210, 39, 30));
            loginCorrect = false;
        }
        
    }
    
    @FXML
    private void handleNewUser(ActionEvent event){
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnCreateUser.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
            application.gotoCreateUser();
        });
        
        btnLogin.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
            application.gotoMenu();
        });

    }

}
