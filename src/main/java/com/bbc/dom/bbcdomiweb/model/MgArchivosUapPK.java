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
public class MgArchivosUapPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_VALIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaValida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "NOMBRE_ARCHIVO")
    private String nombreArchivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO_ARCHIVO")
    private short tipoArchivo;

    public MgArchivosUapPK() {
    }

    public MgArchivosUapPK(Date fechaValida, String nombreArchivo, short tipoArchivo) {
        this.fechaValida = fechaValida;
        this.nombreArchivo = nombreArchivo;
        this.tipoArchivo = tipoArchivo;
    }

    public Date getFechaValida() {
        return fechaValida;
    }

    public void setFechaValida(Date fechaValida) {
        this.fechaValida = fechaValida;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public short getTipoArchivo() {
        return tipoArchivo;
    }

    public void setTipoArchivo(short tipoArchivo) {
        this.tipoArchivo = tipoArchivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fechaValida != null ? fechaValida.hashCode() : 0);
        hash += (nombreArchivo != null ? nombreArchivo.hashCode() : 0);
        hash += (int) tipoArchivo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MgArchivosUapPK)) {
            return false;
        }
        MgArchivosUapPK other = (MgArchivosUapPK) object;
        if ((this.fechaValida == null && other.fechaValida != null) || (this.fechaValida != null && !this.fechaValida.equals(other.fechaValida))) {
            return false;
        }
        if ((this.nombreArchivo == null && other.nombreArchivo != null) || (this.nombreArchivo != null && !this.nombreArchivo.equals(other.nombreArchivo))) {
            return false;
        }
        if (this.tipoArchivo != other.tipoArchivo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.MgArchivosUapPK[ fechaValida=" + fechaValida + ", nombreArchivo=" + nombreArchivo + ", tipoArchivo=" + tipoArchivo + " ]";
    }
    
}
