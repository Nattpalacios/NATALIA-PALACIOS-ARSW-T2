package edu.eci.arsw.Coronavirus.model;

public class Country {

    private String name;
    private int muertos;
    private int infectados;
    private int curados;

    /**
     * Crea un pais con los datos especificados
     * @param name nombre del pais
     * @param muertos numero de muertos por el covid19
     * @param infectados numero de infectados del covid19
     * @param curados numero de personas recuperadas del covid19
     */
    public Country(String name, int muertos, int infectados, int curados){
        this.name = name;
        this.muertos = muertos;
        this.infectados = infectados;
        this.curados = curados;
    }

    /**
     * Permite saber el nombre del pais
     * @return nombre del pais
     */
    public String getName() {
        return name;
    }

    /**
     * Cambia el nombre del pais
     * @param name nombre nuevo para el pais
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Permite saber el numero de muertos por el covid19
     * @return numero de muertos por el covid19
     */
    public int getMuertos() {
        return muertos;
    }

    /**
     * Cambia el numero de muertos por el covid19
     * @param muertos nueva cantidad de muertos por el covid19
     */
    public void setMuertos(int muertos) {
        this.muertos = muertos;
    }

    /**
     * Permite saber el numero de infectados por el covid19
     * @return numero de infectados por el covid19
     */
    public int getInfectados() {
        return infectados;
    }

    /**
     * Cambia el numero de infectados por el covid19
     * @param infectados nueva cantidad de infectados por el covid19
     */
    public void setInfectados(int infectados) {
        this.infectados = infectados;
    }

    /**
     * Permite saber el numero de curados del covid19
     * @return numero de curados del covid19
     */
    public int getCurados() {
        return curados;
    }

    /**
     * Cambia el numero de curados del covid19
     * @param curados nueva cantidad de curados del covid19
     */
    public void setCurados(int curados) {
        this.curados = curados;
    }

}
