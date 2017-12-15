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
 private Airplane airplane;
 private String flight_code;
 private Airport arrival, departures;
 private String departureTime, duration, date, seat;

    public Flight() {
    }

    public Flight(final Airplane airplane, String flight_code,final Airport arrival,final Airport departures, String departureTime, String duration, String date, String seat) {
        this.airplane = airplane;
        this.flight_code = flight_code;
        this.arrival = arrival;
        this.departures = departures;
        this.departureTime = departureTime;
        this.duration = duration;
        this.date = date;
        this.seat = seat;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public String getFlight_code() {
        return flight_code;
    }

    public void setFlight_code(String flight_code) {
        this.flight_code = flight_code;
    }

    public Airport getArrival() {
        return arrival;
    }

    public void setArrival(Airport arrival) {
        this.arrival = arrival;
    }

    public Airport getDepartures() {
        return departures;
    }

    public void setDepartures(Airport departures) {
        this.departures = departures;
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

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }
    
    
}
