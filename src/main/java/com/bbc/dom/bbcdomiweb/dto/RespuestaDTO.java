/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.dto;

import java.io.Serializable;

/**
 *
 * @author Christian Gutierrez
 */
public class RespuestaDTO implements Serializable{
    
     private String codigo;

    private String descripcion;
     private Object objet;
    

    public RespuestaDTO(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public RespuestaDTO() {
        this.codigo = "000";
        this.descripcion = "";
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Object getObjet() {
        return objet;
    }

    public void setObjet(Object objet) {
        this.objet = objet;
    }
     
}
