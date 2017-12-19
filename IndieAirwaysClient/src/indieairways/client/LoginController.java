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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author jmora
 */
public class LoginController implements Initializable {

    @FXML private TextField txtUser;
    @FXML private TextField txtPasswd;
//    @FXML
//    private ImageView btnComida;
//    @FXML
//    private ImageView btnReservaciones;

    private IndieAirwaysClient application;

    /**
     * Define la aplicacion principal para manejo de ventanas
     *
     * @param application
     */
    public void setApp(IndieAirwaysClient application) {
        this.application = application;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        btnPeliculas.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)
//                -> {
//            System.out.println("btnPeliculas");
//            application.gotoVerPeliculas();
//        });
//        btnComida.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)
//                -> {
//            System.out.println("btnComida");
//        });
//        btnReservaciones.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)
//                -> {
//            System.out.println("btnReservaciones");
//        });
    }

}
