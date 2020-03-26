package edu.eci.arsw.Coronavirus.model;

public class Country {

    private String name;
    private int muertos;
    private int infectados;
    private int curados;

    public Country(String name, int muertos, int infectados, int curados){
        this.name = name;
        this.muertos = muertos;
        this.infectados = infectados;
        this.curados = curados;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMuertos() {
        return muertos;
    }

    public void setMuertos(int muertos) {
        this.muertos = muertos;
    }

    public int getInfectados() {
        return infectados;
    }

    public void setInfectados(int infectados) {
        this.infectados = infectados;
    }

    public int getCurados() {
        return curados;
    }

    public void setCurados(int curados) {
        this.curados = curados;
    }

}
