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
public class FXMLReservaRoundTripController extends BaseController {

    @FXML
    private ImageView btnBack;
    @FXML
    private Button bNext;
    @FXML
    private Label lPrice;
    @FXML
    private Label lFromC1; //Ciudades de partida
    @FXML
    private Label lFromC2;
    @FXML
    private Label lToC1; //Ciudades de llegada
    @FXML
    private Label lToC2;
    @FXML
    private Label lFliNum1; //Numeros de vuelo
    @FXML
    private Label lFliNum2;
    @FXML
    private Label lDepDate1; //Fechas de Salida
    @FXML
    private Label lDepDate2;
    @FXML
    private Label lDepTime1; //Horas de salida
    @FXML
    private Label lDepTime2;
    @FXML
    private Label lFliTime1; //Duracion de los vuelos
    @FXML
    private Label lFliTime2;
    @FXML
    private Button bntCreateReserv;

     /**
     * It is the initialize of the scene. It is a method that has to be implemented.
     * Sets the actions to do when the button of the red arrow is clicked (go back)
     * or the one for the confirmation code is clicked in which case it goes to the next
     * window.
     *
     * @param url: not used, ResourceBoundle: not used
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnBack.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
            application.gotoVerReserva();
        });

        bntCreateReserv.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> { //Ir a la pantalla anterior
            application.gotoConfirmCode();
        });
    }

    /**
     * It sets the text labels, this info is given already by the user.
     *
     * @param depCity: departure city, arriCity: arrival city, depDate: the date of the departure, depDate2: date of the return flight
     */
    public void setText(String depCity, String arriCity, LocalDate depDate, LocalDate depDate2) {
        lFromC1.setText(depCity);
        lToC1.setText(arriCity);
        lDepDate1.setText(depDate.toString());

        lFromC2.setText(arriCity);
        lToC2.setText(depCity);
        lDepDate2.setText(depDate2.toString());
    }

    /**
     * Calculates the total price of the flight based on the info given by the user.
     *
     * @param none
     */
    public int precio() { //Este metodo debe de calcular el precio del boleto tomando en cuenta la cantidad de pasajeros y las maletas
        int costo = 0;

        return costo;
    }

}//Fin de la clase FXMLReservaRoundTrip
