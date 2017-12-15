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
package indieairways.model;

/**
 *
 * @author emilioevans
 */
public class Airport {

    private String city, city_code, flight_code;

    public Airport() {
    }

    public Airport(String city, String city_code, String flight_code) {
        this.city = city;
        this.city_code = city_code;
        this.flight_code = flight_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }

    public String getFlight_code() {
        return flight_code;
    }

    public void setFlight_code(String flight_code) {
        this.flight_code = flight_code;
    }

    @Override
    public String toString() {
        return "Aeropuerto{" + "city=" + city + ", city_code=" + city_code + ", flight_code=" + flight_code + '}';
    }

}
