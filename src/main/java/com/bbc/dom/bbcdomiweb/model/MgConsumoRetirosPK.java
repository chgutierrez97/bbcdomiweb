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

/**
 *
 * @author Christian Gutierrez
 */
@Embeddable
public class MgConsumoRetirosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "SECUENCIA_MOVIMIENTO")
    private long secuenciaMovimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_VALIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaValida;

    public MgConsumoRetirosPK() {
    }

    public MgConsumoRetirosPK(long secuenciaMovimiento, Date fechaValida) {
        this.secuenciaMovimiento = secuenciaMovimiento;
        this.fechaValida = fechaValida;
    }

    public long getSecuenciaMovimiento() {
        return secuenciaMovimiento;
    }

    public void setSecuenciaMovimiento(long secuenciaMovimiento) {
        this.secuenciaMovimiento = secuenciaMovimiento;
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
        hash += (int) secuenciaMovimiento;
        hash += (fechaValida != null ? fechaValida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MgConsumoRetirosPK)) {
            return false;
        }
        MgConsumoRetirosPK other = (MgConsumoRetirosPK) object;
        if (this.secuenciaMovimiento != other.secuenciaMovimiento) {
            return false;
        }
        if ((this.fechaValida == null && other.fechaValida != null) || (this.fechaValida != null && !this.fechaValida.equals(other.fechaValida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.MgConsumoRetirosPK[ secuenciaMovimiento=" + secuenciaMovimiento + ", fechaValida=" + fechaValida + " ]";
    }
    
}
