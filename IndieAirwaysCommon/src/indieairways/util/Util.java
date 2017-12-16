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
package indieairways.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import indieairways.model.Airplane;
import indieairways.model.Airport;
import indieairways.model.Flight;
import indieairways.model.Reservation;
import indieairways.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author jmora
 */
public class Util {

    //Variables de las ventanas
    public static int WIDTH = 642;
    public static int HEIGHT = 528;

    public static int SERVER_PORT = 2356;
    public static String SERVER_IP = "localhost";

    public static Gson getGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
//        gsonBuilder.registerTypeAdapter(Date.class, new DateSerializer());
//        gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());
        return gsonBuilder.create();
    }

    //Variables globales de la aplicación
    public static User CURRENT_USER = null;
    public static ObservableList<User> USER_LIST = FXCollections.observableArrayList();
    public static ObservableList<Airport> AIRPORT_LIST = FXCollections.observableArrayList();
    public static ObservableList<Airplane> AIRPLANE_LIST = FXCollections.observableArrayList();
    public static ObservableList<Reservation> RESERVATION_LIST = FXCollections.observableArrayList();
    public static ObservableList<Flight> FLIGHT_LIST = FXCollections.observableArrayList();

//    public static ObservableList<Sala> getSalas() {
//        Util.LISTA_SALAS.add(new Sala(1, 50));
//        Util.LISTA_SALAS.add(new Sala(2, 50));
//        Util.LISTA_SALAS.add(new Sala(3, 75));
//        Util.LISTA_SALAS.add(new Sala(4, 255));
//
//        return Util.LISTA_SALAS;
//    }
//
//    public static ObservableList<String> getIDsSalas() {
//        ObservableList<String> salas = FXCollections.observableArrayList();
//
//        getSalas().forEach(sala -> salas.add(String.valueOf(sala.getiD())));
//
//        System.out.println(salas);
//        return salas;
//    }
    
    
    public void generateData(){
        
    }
    
    
} //Fin de la clase

//class DepartmentInstanceCreator implements InstanceCreator<Reservacion> {
//
//    public Reservacion createInstance(Type type) {
//        return new Reservacion();
//    }
//}
