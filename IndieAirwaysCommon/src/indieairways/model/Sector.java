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
public enum Sector {

    FIRST_CLASS("First Class", 0.40), BUSINESS_CLASS("Business Class", 0.20), ECONOMY_CLASS("Economy Class", 0.05);

    private static int SECTORS = 0;
    
    private String sectorCode;
    private String name;
    private double cost;

    private Sector(String name, double cost) {
        this.sectorCode = getNextCode();
        this.name = name;
        this.cost = cost;
    }

    public String getSectorCode() {
        return sectorCode;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }
    
    private String getNextCode(){
        return String.valueOf(++SECTORS);
    }

    @Override
    public String toString() {
        return this.name;
    }

}
