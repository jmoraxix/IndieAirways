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

import indieairways.util.Util;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Carlos
 */
public class FXMLPantallaReservaFinalController implements Initializable {

    @FXML private Label labelConfiCode;
    @FXML private ImageView bntHome;
    
    private IndieAirwaysClient application;
    
    private Util util; //Para llamar al numero de confirmacion
    
    public void setApp(IndieAirwaysClient application) {
        this.application = application;
        //application.setConfirmCode(generateConCode(util.contadorConfirmCode));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bntHome.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)-> {
            application.gotoMenu();
        });

    }    
    
    public void setText(){
        util.aumentaContador();
        labelConfiCode.setText(generateConCode(util.contadorConfirmCode));
    }
    
    public String generateConCode(int x){
        String code = "IA";
        String num = String.valueOf(x);
        code = code + num;
        
        return code;
    }
    
    
}//End of class FXMLPantallaReservaFinalController
