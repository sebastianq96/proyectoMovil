package com.example.proyectomovil;

import org.json.JSONException;
import org.json.JSONObject;

public class rol {

    private int id_rol;
    private int id_curso;
    private String cedula;
    private String nombre;
    private String programa;
    private String rol;
    private String usuario;
    private String contrasena;

    public rol(JSONObject objetoJSON) throws JSONException {
        this.id_rol = objetoJSON.getInt("id_rol");
        this.id_curso = objetoJSON.getInt("id_curso");
        this.cedula = objetoJSON.getString("cedula");
        this.nombre = objetoJSON.getString("nombre");
        this.programa = objetoJSON.getString("programa");
        this.rol = objetoJSON.getString("rol");
        this.usuario = objetoJSON.getString("usuario");
        this.contrasena = objetoJSON.getString("contrasena");
    }

    public int getId_rol() {
        return id_rol;
    }
    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public int getId_curso() {
        return id_curso;
    }
    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }


    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrograma() {
        return programa;
    }
    public void setPrograma(String programa) {
        this.programa = programa;
    }


    public String getRol() {
        return rol;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }


    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}
