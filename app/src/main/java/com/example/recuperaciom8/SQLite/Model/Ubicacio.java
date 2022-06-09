package com.example.recuperaciom8.SQLite.Model;

public class Ubicacio {

    public String ciutat;
    public String temps;
    public String temperatura;

    public Ubicacio() {

    }

    public Ubicacio(String ciutat, String temps, String temperatura) {
        this.ciutat = ciutat;
        this.temps = temps;
        this.temperatura = temperatura;
    }

    //Getters & Setters
    public String getCiutat() { return ciutat; }
    public String getTemps() { return temps; }
    public String getTemperatura() { return temperatura; }

    public void setCiutat(String ciutat) { this.ciutat = ciutat; }
    public void setTemps(String temps) { this.temps = temps; }
    public void setTemperatura(String temperatura) { this.temperatura = temperatura; }



}
