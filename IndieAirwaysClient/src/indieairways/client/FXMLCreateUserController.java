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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author Carlos
 */
public class FXMLCreateUserController extends BaseController {

    @FXML
    private Label labelName;
    @FXML
    private Label labelLastName;
    @FXML
    private DatePicker datePBirth;
    @FXML
    private Label labelEmail;
    @FXML
    private PasswordField passField;
    @FXML
    private Button btnCreate;
    @FXML
    private Label labelAlert;
    @FXML
    private Label labelUserName;
    @FXML
    private ImageView btnReturnLogin;

    private String name, lastName, email, password, user;
    private LocalDate birth;

    private boolean correctData;

    
     /**
     * It handles de event when the "create account" button is clicked
     * It verifies that the info given is not null and in the case of 
     * the e-mail that it contains a "@", and in the case of the password
     * it has to be al least 6 characters long.All the date collected it's 
     * stored in variables.
     *
     * @param event: not used
     */
    @FXML
    private void handleCreateUser(ActionEvent event) {
        correctData = true;

        if (labelName.getText().equals("")) {
            labelAlert.setText("You have to enter a Name.");
            labelAlert.setTextFill(Color.rgb(210, 39, 30));
            correctData = false;
        } else {
            name = labelName.getText();
        }

        if (labelLastName.getText().equals("")) {
            labelAlert.setText("You have to enter a Last Name.");
            labelAlert.setTextFill(Color.rgb(210, 39, 30));
            correctData = false;
        } else {
            lastName = labelLastName.getText();
        }

        birth = datePBirth.getValue(); //Validar que no sea un día en el futuro
//        if (fromDate.equals(toDate)) {
//            labelAlert.setText("Invalid date, they are the same date.");
//            labelAlert.setTextFill(Color.rgb(210, 39, 30));
//            correctData = false;
//        }

        if (labelUserName.getText().equals("")) { //Falta validar que no este siendo utilizado por alguien mas
            labelAlert.setText("You have to enter a Last Name.");
            labelAlert.setTextFill(Color.rgb(210, 39, 30));
            correctData = false;
        } else {
            user = labelUserName.getText();
        }

        if (labelEmail.getText().equals("")) {
            labelAlert.setText("You have to enter a Email.");
            labelAlert.setTextFill(Color.rgb(210, 39, 30));
            correctData = false;
        } else if (!(labelEmail.getText().contains("@"))) {
            labelAlert.setText("You have to enter a correct Email.");
            labelAlert.setTextFill(Color.rgb(210, 39, 30));
            correctData = false;
        } else {
            email = labelEmail.getText();
        }

        if (passField.getText().length() < 6) {
            labelAlert.setText("You have to enter a longer password.");
            labelAlert.setTextFill(Color.rgb(210, 39, 30));
            correctData = false;
        } else {
            password = passField.getText();
        }

    }

    
     /**
     * It is the initialize of the scene. It is a method that has to be implemented.
     * It contains the events in the cause either the imageview of the arrow is clicked 
     * when the button is cliked. In the last case it let the application move to another
     * scene only if the info providate is correct.
     *
     * @param url: not used, ResourceBoundle: not used
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        btnCreate.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
            if (correctData) {
                application.gotoMenu();
            }
        });

        btnReturnLogin.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> { //Ir a la pantalla anterior
            application.gotoLogin();
        });

        labelAlert.setText("");

    }

}
