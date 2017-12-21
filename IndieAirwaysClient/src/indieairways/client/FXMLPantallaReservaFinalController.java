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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Carlos
 */
public class FXMLPantallaReservaFinalController extends BaseController {

    @FXML
    private Label labelConfiCode;
    @FXML
    private ImageView bntHome;

    private Util util; //Para llamar al numero de confirmacion

    /**
     * It is the initialize of the scene. It is a method that has to be
     * implemented. Only the button to go back to the menu is initialized.
     *
     * @param url: not used, ResourceBoundle: not used
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bntHome.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
            application.gotoMenu();
        });

    }

    /**
     * Method to set the label's info.
     *
     */
    public void setText() {
        util.aumentaContador();
        labelConfiCode.setText(generateConCode(util.contadorConfirmCode));
    }

    /**
     * It generates the confirmation code
     *
     * @param x, the numbe attatched to the string.
     */
    public String generateConCode(int x) {
        String code = "IA";
        String num = String.valueOf(x);
        code = code + num;

        return code;
    }

}//End of class FXMLPantallaReservaFinalController
