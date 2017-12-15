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
public enum Airplane {
  BIG_AIRPLANE("B777",8,16,32,56), AIRPLANE("B767-300",6,12,24,38),LITTLE_AIRPLANE("A320",4,8,16,28);
  private String airplaneName;
  private int seatsFirst, seatsBusiness, seatEconomy, total;

    private Airplane(String airplaneName, int seatsFirst, int seatsBusiness, int seatEconomy, int total) {
        this.airplaneName = airplaneName;
        this.seatsFirst = seatsFirst;
        this.seatsBusiness = seatsBusiness;
        this.seatEconomy = seatEconomy;
        this.total=total;
    }

    public String getAirplaneName() {
        return airplaneName;
    }

    public void setAirplaneName(String airplaneName) {
        this.airplaneName = airplaneName;
    }

    public int getSeatsFirst() {
        return seatsFirst;
    }

    public int getSeatsBusiness() {
        return seatsBusiness;
    }

    public int getSeatEconomy() {
        return seatEconomy;
    }
    public int getTotal(){
        return total;
    }

    @Override
    public String toString() {
        return "Airplane{" + "airplaneName=" + airplaneName + ", seatsFirst=" + seatsFirst + ", seatsBusiness=" + seatsBusiness + ", seatEconomy=" + seatEconomy + ", total=" + total + '}';
    }


  

}