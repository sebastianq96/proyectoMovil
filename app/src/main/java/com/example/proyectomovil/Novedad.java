package com.example.proyectomovil;

public class Novedad {

    private String cambioSalon, cancelacionClase, recordatorio,salidaCampo;
    private double longitud,lactitud;

    public Novedad(String cambioSalon, String cancelacionClase, String recordatorio, String salidaCampo, double longitud, double lactitud) {
        this.cambioSalon = cambioSalon;
        this.cancelacionClase = cancelacionClase;
        this.recordatorio = recordatorio;
        this.salidaCampo = salidaCampo;
        this.longitud = longitud;
        this.lactitud = lactitud;
    }

    public String getCambioSalon() {
        return cambioSalon;
    }

    public String getCancelacionClase() {
        return cancelacionClase;
    }

    public String getRecordatorio() {
        return recordatorio;
    }

    public String getSalidaCampo() {
        return salidaCampo;
    }

    public double getLongitud() {
        return longitud;
    }

    public double getLactitud() {
        return lactitud;
    }

/*
    public void setCambioSalon(String cambioSalon) {
        this.cambioSalon = cambioSalon;
    }

    public void setCancelacionClase(String cancelacionClase) {
        this.cancelacionClase = cancelacionClase;
    }

    public void setRecordatorio(String recordatorio) {
        this.recordatorio = recordatorio;
    }

    public void setSalidaCampo(String salidaCampo) {
        this.salidaCampo = salidaCampo;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public void setLactitud(double lactitud) {
        this.lactitud = lactitud;
    }*/
}

