/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Christian Gutierrez
 */
@Embeddable
public class MgArchivosDomiciliaUapPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE_ARCHIVO")
    private String nombreArchivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_VALIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaValida;

    public MgArchivosDomiciliaUapPK() {
    }

    public MgArchivosDomiciliaUapPK(String nombreArchivo, Date fechaValida) {
        this.nombreArchivo = nombreArchivo;
        this.fechaValida = fechaValida;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public Date getFechaValida() {
        return fechaValida;
    }

    public void setFechaValida(Date fechaValida) {
        this.fechaValida = fechaValida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombreArchivo != null ? nombreArchivo.hashCode() : 0);
        hash += (fechaValida != null ? fechaValida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MgArchivosDomiciliaUapPK)) {
            return false;
        }
        MgArchivosDomiciliaUapPK other = (MgArchivosDomiciliaUapPK) object;
        if ((this.nombreArchivo == null && other.nombreArchivo != null) || (this.nombreArchivo != null && !this.nombreArchivo.equals(other.nombreArchivo))) {
            return false;
        }
        if ((this.fechaValida == null && other.fechaValida != null) || (this.fechaValida != null && !this.fechaValida.equals(other.fechaValida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.MgArchivosDomiciliaUapPK[ nombreArchivo=" + nombreArchivo + ", fechaValida=" + fechaValida + " ]";
    }
    
}
