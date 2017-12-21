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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author jmora
 */
public class MenuClienteController extends BaseController {

    @FXML
    private ImageView ivBookFli;
    @FXML
    private ImageView ivMyFli;
    @FXML
    private ImageView ivMyInfo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ivBookFli.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
            System.out.println("ivBookFli");
            application.gotoVerReserva();
        });

        ivMyFli.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
            System.out.println("ivMyFli");
        });

        ivMyInfo.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
            System.out.println("ivMyInfo");
        });
    }

}//Fin de la clase MenuCliente.fxml
