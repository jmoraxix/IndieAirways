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
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author jmora
 */
public class IndieAirwaysClient extends Application {

    private Stage stage;
    private final double WINDOW_WIDTH = Util.WIDTH;
    private final double WINDOW_HEIGHT = Util.HEIGHT;

    //Variables del cliente TCP
//    private Cliente cliente;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(IndieAirwaysClient.class, (java.lang.String[]) null);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            stage = primaryStage;
            stage.setTitle("Indie Airways");
            stage.setMinWidth(WINDOW_WIDTH);
            stage.setMinHeight(WINDOW_HEIGHT);
            //gotoLogin();
            gotoVerReserva();
            primaryStage.show();
        } catch (Exception ex) {
            Logger.getLogger(IndieAirwaysClient.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Iniciando cliente TCP
//        this.cliente = new Cliente(this);
//        this.cliente.start();
    }

    /**
     * Cambia el contenido de la ventana al menu principal
     */
    public void gotoLogin() {
        try {
            LoginController login = (LoginController) replaceSceneContent("Login.fxml");
            login.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(IndieAirwaysClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Cambia el contenido de la ventana al menu principal
     */
    public void gotoMenu() {
        try {
            MenuClienteController menu = (MenuClienteController) replaceSceneContent("MenuCliente.fxml");
            menu.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(IndieAirwaysClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Cambia el contenido de la ventana a la venta de las peliculas
     */
    public void gotoVerReserva() {
        try {
            FXMLDatosReservaController verReserva1 = (FXMLDatosReservaController) replaceSceneContent("FXMLDatosReserva.fxml");
            verReserva1.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(IndieAirwaysClient.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    private Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = IndieAirwaysClient.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(IndieAirwaysClient.class.getResource(fxml));
        AnchorPane page;
        try {
            page = (AnchorPane) loader.load(in);
        } finally {
            in.close();
        }
        Scene scene = new Scene(page, WINDOW_WIDTH, WINDOW_HEIGHT);
        stage.setScene(scene);
        stage.sizeToScene();
        return (Initializable) loader.getController();
    }

}
