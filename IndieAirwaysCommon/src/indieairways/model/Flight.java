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
public class Flight {

    private static int FLIGHTS = 0;

    private String flightCode;
    private Airplane airplane;
    private Airport arrival, departure;
    private String date, departureTime, duration;
    private int cost;

    public Flight() {
    }

    public Flight(Airplane airplane, final Airport arrival, final Airport departures, String date, String departureTime, String duration, int cost) {
        this.flightCode = getNextCode();
        this.airplane = airplane;
        this.arrival = arrival;
        this.departure = departures;
        this.departureTime = departureTime;
        this.duration = duration;
        this.date = date; //
        this.cost = cost;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public Airport getArrival() {
        return arrival;
    }

    public void setArrival(Airport arrival) {
        this.arrival = arrival;
    }

    public Airport getDeparture() {
        return departure;
    }

    public void setDeparture(Airport departure) {
        this.departure = departure;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    private String getNextCode() {
        return String.valueOf(++FLIGHTS);
    }
}
