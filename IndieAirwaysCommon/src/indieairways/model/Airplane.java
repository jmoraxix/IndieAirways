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
    BIG_AIRPLANE("B777", 8, 16, 32), AIRPLANE("B767-300", 6, 12, 24), LITTLE_AIRPLANE("A320", 4, 8, 16);
    
    private static int AIRPLANES = 0;
    
    private String airplaneCode;
    private String airplaneName;
    private int seatsFirst, seatsBusiness, seatEconomy;

    private Airplane(String airplaneName, int seatsFirst, int seatsBusiness, int seatEconomy) {
        this.airplaneCode = getNextCode();
        this.airplaneName = airplaneName;
        this.seatsFirst = seatsFirst;
        this.seatsBusiness = seatsBusiness;
        this.seatEconomy = seatEconomy;
    }

    public String getAirplaneCode() {
        return airplaneCode;
    }

    public String getAirplaneName() {
        return airplaneName;
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

    /**
     *
     * @return
     */
    public int getTotal() {
        return this.seatEconomy + this.seatsBusiness + this.seatsFirst;
    }
    
    private String getNextCode(){
        return String.valueOf(++AIRPLANES);
    }

    @Override
    public String toString() {
        return "Airplane{" + "airplaneCode=" + airplaneCode + ", airplaneName=" + airplaneName + ", seatsFirst=" + seatsFirst + ", seatsBusiness=" + seatsBusiness + ", seatEconomy=" + seatEconomy + '}';
    }
}
