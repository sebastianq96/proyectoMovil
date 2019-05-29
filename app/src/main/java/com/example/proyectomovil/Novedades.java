package com.example.proyectomovil;

import org.json.JSONException;
import org.json.JSONObject;

public class Novedades {

    private int id_novedades;
    private String recordatorio;
    private String cambioSalon;
    private String cancelacionClase;
    private int salidaCampo;
    private double longitud;
    private double lactitud;

    public Novedades(JSONObject objetoJSON) throws JSONException {
        this.id_novedades = objetoJSON.getInt("id_novedades");
        this.recordatorio = objetoJSON.getString("recordatorio");
        this.cambioSalon = objetoJSON.getString("cambioSalon");
        this.cancelacionClase = objetoJSON.getString("cancelacionClase");
        this.salidaCampo = objetoJSON.getInt("salidaCampo");
        this.longitud= objetoJSON.getDouble("longitud");
        this.lactitud= objetoJSON.getDouble("lactitud");
    }

    public int getId_novedades() {
        return id_novedades;
    }
    public void setId_novedades(int id_novedades) {
        this.id_novedades = id_novedades;
    }

    public String getRecordatorio() {
        return recordatorio;
    }
    public void setRecordatorio(String recordatorio) {
        this.recordatorio = recordatorio;
    }

    public String getCambioSalon(){return cambioSalon;}
    public void setCambioSalon(String cambioSalon){this.cambioSalon= cambioSalon;}

    public String getCancelacionClase(){return cancelacionClase;}
    public void setCancelacionClase(String cancelacionClase){this.cancelacionClase= cancelacionClase;}

    public int getSalidaCampo(){return salidaCampo;}
    public void setSalidaCampo(int salidaCampo){this.salidaCampo= salidaCampo;}

    public double getLongitud(){return longitud;}
    public void setLongitud(double longitud){this.longitud= longitud;}

    public double getLactitud(){return lactitud;}
    public void setLactitud(double lactitud){this.lactitud= lactitud;}

}
