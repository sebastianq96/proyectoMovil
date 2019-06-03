package com.example.proyectomovil;

public class Students {
    private int cedula;
    private String nombre, rol, usuario,programa;

    public Students(int cedula, String nombre, String rol, String usuario, String programa) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.rol = rol;
        this.usuario = usuario;
        this.programa = programa;

       }


    public int getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRol() {
        return rol;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPrograma() {
        return programa;
    }
}

