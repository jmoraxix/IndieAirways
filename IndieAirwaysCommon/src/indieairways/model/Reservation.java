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

    private static int RESERVATIONS = 0;

    private String reservationCode;
    private Flight flight;
    private int tickets, luggage;
    private String seats;

    /*
    @TODO Add sector to reservation
     */
    public Reservation() {
    }

    public Reservation(final Flight flight, int tickets, int luggage, String seats) {
        this.reservationCode = getNextCode();
        this.flight = flight;
        this.tickets = tickets;
        this.luggage = luggage;
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
        return (this.getFlight().getCost() * this.tickets) + 100 * (this.tickets - this.luggage < 0 ? this.luggage - this.tickets : 0);
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getReservationCode() {
        return reservationCode;
    }

    private String getNextCode() {
        return String.valueOf(++RESERVATIONS);
    }

    @Override
    public String toString() {
        return "Reservation{" + "reservationCode=" + reservationCode + ", flight=" + flight + ", tickets=" + tickets + ", luggage=" + luggage + ", seats=" + seats + '}';
    }

}
