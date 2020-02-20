/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Christian Gutierrez
 */
@Embeddable
public class MgArchivosConsolidadosUapPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "CONSECUTIVO")
    private long consecutivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "FECHA_VALIDA")
    private String fechaValida;

    public MgArchivosConsolidadosUapPK() {
    }

    public MgArchivosConsolidadosUapPK(long consecutivo, String fechaValida) {
        this.consecutivo = consecutivo;
        this.fechaValida = fechaValida;
    }

    public long getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(long consecutivo) {
        this.consecutivo = consecutivo;
    }

    public String getFechaValida() {
        return fechaValida;
    }

    public void setFechaValida(String fechaValida) {
        this.fechaValida = fechaValida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) consecutivo;
        hash += (fechaValida != null ? fechaValida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MgArchivosConsolidadosUapPK)) {
            return false;
        }
        MgArchivosConsolidadosUapPK other = (MgArchivosConsolidadosUapPK) object;
        if (this.consecutivo != other.consecutivo) {
            return false;
        }
        if ((this.fechaValida == null && other.fechaValida != null) || (this.fechaValida != null && !this.fechaValida.equals(other.fechaValida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.MgArchivosConsolidadosUapPK[ consecutivo=" + consecutivo + ", fechaValida=" + fechaValida + " ]";
    }
    
}
