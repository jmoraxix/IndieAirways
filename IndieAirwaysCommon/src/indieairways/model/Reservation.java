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
public class Reservation {
    private Flight flight;
    private int tickets, luggage, totalPrice;
    private String seats;

    public Reservation() {
    }

    public Reservation(final Flight flight, int tickets, int luggage, int totalPrice, String seats) {
        this.flight = flight;
        this.tickets = tickets;
        this.luggage = luggage;
        this.totalPrice = totalPrice;
        this.seats = seats;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public int getTickets() {
        return tickets;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

    public int getLuggage() {
        return luggage;
    }

    public void setLuggage(int luggage) {
        this.luggage = luggage;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Reservation{" + "flight=" + flight + ", tickets=" + tickets + ", luggage=" + luggage + ", totalPrice=" + totalPrice + ", seats=" + seats + '}';
    }
    
    
}
