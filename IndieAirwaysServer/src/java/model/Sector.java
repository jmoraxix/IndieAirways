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
package model;

/**
 *
 * @author emilioevans
 */
public enum Sector {
    first_class("First Class", 0.40), business_class("Business Class", 0.20), economy_class("Economy Class", 0.05);
    private String name;
    private double cost;

    private Sector(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "name=" + name + ", cost=" + cost;
    }

}
