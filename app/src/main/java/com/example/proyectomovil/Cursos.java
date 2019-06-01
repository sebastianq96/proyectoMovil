package com.example.proyectomovil;


import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;


public class Cursos {

    private int id_curso;
    private String nombreCurso;
    private String fechaIni;
    private String fechaFin;
    private String horario;
    private String descripcion;



    public Cursos(JSONObject objetoJSON) throws JSONException {
        this.id_curso = objetoJSON.getInt("id_curso");
        this.nombreCurso = objetoJSON.getString("nombreCurso");
        this.fechaIni = objetoJSON.getString("fechaIni");
        this.fechaFin = objetoJSON.getString("fechaFin");
        this.horario = objetoJSON.getString("horario");
        this.descripcion = objetoJSON.getString("descripcion");

    }

    public int getid_curso() {
        return id_curso;
    }
    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public String getnombreCurso() {
        return nombreCurso;
    }
    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getFechaIni(){return fechaIni;}
    public void setFechaIni(String fechaIni){this.fechaIni= fechaIni;}

    public String getFechaFin(){return fechaFin;}
    public void setFechaFin(String fechaFin){this.fechaFin= fechaFin;}

    public String getHorario(){return horario;}
    public void setHorario(String horario){this.horario= horario;}

    public String getDescripcion(){return descripcion;}
    public void setDescripcion(String descripcion){this.descripcion= descripcion;}





}
