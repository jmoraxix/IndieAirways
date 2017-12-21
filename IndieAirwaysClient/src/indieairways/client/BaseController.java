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
import javafx.fxml.Initializable;

/**
 *
 * @author jmora
 */
public abstract class BaseController implements Initializable {

    protected IndieAirwaysClient application;

    /**
     * Define la aplicacion principal para manejo de ventanas
     *
     * @param application
     */
    protected void setApp(IndieAirwaysClient application) {
        this.application = application;
    }

    @Override
    public abstract void initialize(URL location, ResourceBundle resources);
}
