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
import indieairways.model.Reservation;
import java.time.LocalDate;

/**
 *
 * @author jmora
 */
public class IndieAirwaysClient extends Application {

    private Stage stage;
    private final double WINDOW_WIDTH = Util.WIDTH;
    private final double WINDOW_HEIGHT = Util.HEIGHT;
    
    private String cityO, cityD; //Ciudad de destino y ciudad de origen
    private LocalDate depDate, depDate2;
    
    private String confirmCode;
    
    private FXMLDatosReservaController reserva;
    
    //Variables del cliente TCP
//    private Cliente cliente;
    private static Reservation reservacion = new Reservation();
    
    public void setCiudadO(String ciudadO){
        this.cityO = ciudadO;
    }
        
    public void setCityD(String cityD){
        this.cityD = cityD;
    }
    
    public void setDepDate(LocalDate depDate){
        this.depDate = depDate;
    }
    
    public void setDepDate2(LocalDate depDate2){
        this.depDate2 = depDate2;
    }
    
    public void setConfirmCode(String confirmCode){
        this.confirmCode = confirmCode;
    }
    
    public String getConfirmCode(){
        return confirmCode;
    }
    
    public void setLabelTimer(FXMLDatosReservaController verReserva, int n){
        verReserva.setLabelTimer(n);
    }
    
    public void setTipoReserva(FXMLDatosReservaController reserva){
        this.reserva = reserva; 
    }
    
    public FXMLDatosReservaController getTipoReserva(){
        return reserva;
    }
    
    
    //TODO Instanciar el hilo para el timer de reserva del vuelo 
    
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
            gotoLogin();
            //gotoMenu();
            primaryStage.show(); 
        } catch (Exception ex) {
            Logger.getLogger(IndieAirwaysClient.class.getName()).log(Level.SEVERE, null, ex);
        }

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
            FXMLDatosReservaController verReserva = (FXMLDatosReservaController) replaceSceneContent("FXMLDatosReserva.fxml");
            verReserva.setApp(this);
            //setTipoReserva(verReserva); //Setea el tipo de reserva
        } catch (Exception ex) {
            Logger.getLogger(IndieAirwaysClient.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    public void gotoCreateUser(){
        try {
            FXMLCreateUserController verCreateUser = (FXMLCreateUserController) replaceSceneContent("FXMLCreateUser.fxml");
            verCreateUser.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(IndieAirwaysClient.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    public void gotoReservaOneWay(){
        try {
            FXMLReservaOneWayController verReservaOW = (FXMLReservaOneWayController) replaceSceneContent("FXMLReservaOneWay.fxml");
            verReservaOW.setApp(this);
            verReservaOW.setText(cityO, cityD, depDate);
        } catch (Exception ex) {
            Logger.getLogger(IndieAirwaysClient.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    public void gotoReservaRoundTrip(){
        try {
            FXMLReservaRoundTripController verReservaRT = (FXMLReservaRoundTripController) replaceSceneContent("FXMLReservaRoundTrip.fxml");
            verReservaRT.setApp(this);
            verReservaRT.setText(cityO, cityD, depDate, depDate2);
        } catch (Exception ex) {
            Logger.getLogger(IndieAirwaysClient.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    public void gotoConfirmCode(){
        try {
            FXMLPantallaReservaFinalController verPantallaFinal = (FXMLPantallaReservaFinalController) replaceSceneContent("FXMLPantallaReservaFinal.fxml");
            verPantallaFinal.setApp(this);
            verPantallaFinal.setText();
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
