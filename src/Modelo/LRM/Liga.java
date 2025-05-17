/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.LRM;

import java.util.Date;

/**
 *
 * @author gzlzz
 */
public class Liga {
    
    public int idLiga;
    public String nameLiga;
    public Date fechaInicio;
    public Date fechaFin;
    
    public Liga (){
        
        this.idLiga=0;
        this.nameLiga="";
        this.fechaInicio= new Date();
        this.fechaFin= new Date();
    }

    public int getIdLiga() {
        return idLiga;
    }

    public void setIdLiga(int idLiga) {
        this.idLiga = idLiga;
    }

    public String getNameLiga() {
        return nameLiga;
    }

    public void setNameLiga(String nameLiga) {
        this.nameLiga = nameLiga;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return "Liga{" + "idLiga=" + idLiga + ", nameLiga=" + nameLiga + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + '}';
    }
    
    
    
    
    
    
}
