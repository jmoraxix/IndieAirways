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
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author jmora
 */
public class FXMLReservaOneWayController extends BaseController {

    @FXML
    private ImageView btnBack;
    @FXML
    private Label lPrice;
    @FXML
    private Label lDepDate;
    @FXML
    private Label lDepTime;
    @FXML
    private Label lArriTime;
    @FXML
    private Label lFliTime;
    @FXML
    private Label lDepCity; //cBF
    @FXML
    private Label lArriCity; //cBTO
    @FXML
    private Label lFliNum;
    @FXML
    private Button bntCreateReserv;

    /**
     * It is the initialize of the scene. It is a method that has to be
     * implemented. Sets the actions to do when the button of the red arrow is
     * clicked (go back) or the one for the confirmation code is clicked in
     * which case it goes to the next window.
     *
     * @param url: not used, ResourceBoundle: not used
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO        
        btnBack.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> { //Ir a la pantalla anterior
            application.gotoVerReserva();
        });

        bntCreateReserv.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> { //Ir a la pantalla anterior
            application.gotoConfirmCode();
        });

    }

    /**
     * It sets the text labels, this info is given already by the user.
     *
     * @param depCity: departure city, arriCity: arrival city, depDate: the date
     * of the flight
     */
    public void setText(String depCity, String arriCity, LocalDate depDate) {
        lDepCity.setText(depCity);
        lArriCity.setText(arriCity);
        lDepDate.setText(depDate.toString());
    }

    /**
     * Calculates the total price of the flight based on the info given by the
     * user.
     *
     */
    public int precio() {
        int costo = 0;

        return costo;
    }

} //End of class
