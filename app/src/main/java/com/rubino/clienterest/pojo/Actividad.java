package com.rubino.clienterest.pojo;

import java.io.Serializable;

/**
 * Created by marco on 15/02/2016.
 */
public class Actividad implements Serializable{


    
    private String tipo, fechai, fechaf, lugari, lugarf, descripcion, alumno,id, idprofesor;



    public Actividad(String id, String idprofesor, String tipo, String fechai, String fechaf, String lugari, String lugarf, String descripcion, String alumno) {
        this.id = id;
        this.idprofesor = idprofesor;
        this.tipo = tipo;
        this.fechai = fechai;
        this.fechaf = fechaf;
        this.lugari = lugari;
        this.lugarf = lugarf;
        this.descripcion = descripcion;
        this.alumno = alumno;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdprofesor() {
        return idprofesor;
    }

    public void setIdprofesor(String idprofesor) {
        this.idprofesor = idprofesor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFechaf() {
        return fechaf;
    }

    public void setFechaf(String fechaf) {
        this.fechaf = fechaf;
    }

    public String getFechai() {
        return fechai;
    }

    public void setFechai(String fechai) {
        this.fechai = fechai;
    }

    public String getLugari() {
        return lugari;
    }

    public void setLugari(String lugari) {
        this.lugari = lugari;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLugarf() {
        return lugarf;
    }

    public void setLugarf(String lugarf) {
        this.lugarf = lugarf;
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    @Override
    public String toString() {
        return "Actividad{" +
                "id=" + id +
                ", idprofesor=" + idprofesor +
                ", tipo='" + tipo + '\'' +
                ", fechai='" + fechai + '\'' +
                ", fechaf='" + fechaf + '\'' +
                ", lugari='" + lugari + '\'' +
                ", lugarf='" + lugarf + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", alumno='" + alumno + '\'' +
                '}';
    }
}
