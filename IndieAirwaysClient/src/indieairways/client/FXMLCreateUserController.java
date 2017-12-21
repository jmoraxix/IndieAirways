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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author Carlos
 */
public class FXMLCreateUserController implements Initializable {

    @FXML private Label labelName;
    @FXML private Label labelLastName;
    @FXML private DatePicker datePBirth;
    @FXML private Label labelEmail;
    @FXML private PasswordField passField;
    @FXML private Button btnCreate;
    @FXML private Label labelAlert;
    
    private IndieAirwaysClient application;
    
    private String name, lastName, email, password;
    private LocalDate birth;

    private boolean correctData;
    /**
     * Define la aplicacion principal para manejo de ventanas
     *
     * @param application
     */
    public void setApp(IndieAirwaysClient application) {
        this.application = application;
    }
    
    @FXML
    private void handleCreateUser(ActionEvent event){        
        correctData = true;
        
        if(labelName.getText().equals("")){
            labelAlert.setText("You have to enter a Name.");
            labelAlert.setTextFill(Color.rgb(210, 39, 30));
            correctData = false;
        }else{
            name = labelName.getText();
        }
        
        if(labelLastName.getText().equals("")){
            labelAlert.setText("You have to enter a Last Name.");
            labelAlert.setTextFill(Color.rgb(210, 39, 30));
            correctData = false;
        }else{
            lastName = labelLastName.getText();
        }
        
       birth = datePBirth.getValue(); //Validar que no sea un día en el futuro
//        if (fromDate.equals(toDate)) {
//            labelAlert.setText("Invalid date, they are the same date.");
//            labelAlert.setTextFill(Color.rgb(210, 39, 30));
//            correctData = false;
//        }
        
        
        if(labelEmail.getText().equals("")){
            labelAlert.setText("You have to enter a Email.");
            labelAlert.setTextFill(Color.rgb(210, 39, 30));
            correctData = false;
        }else if(!(labelEmail.getText().contains("@"))){
            labelAlert.setText("You have to enter a correct Email.");
            labelAlert.setTextFill(Color.rgb(210, 39, 30));
            correctData = false;
        }else{
            email = labelEmail.getText();
        }
        
        if(passField.getText().length() < 6 ){
            labelAlert.setText("You have to enter a longer password.");
            labelAlert.setTextFill(Color.rgb(210, 39, 30));
            correctData = false;
        }else{
            password = passField.getText();
        }
        
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        btnCreate.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
            if(correctData)
                application.gotoMenu();
        });
        
    }    
    
}
