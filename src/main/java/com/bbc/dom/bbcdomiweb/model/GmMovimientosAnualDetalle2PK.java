/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.model;

import java.io.Serializable;
import java.math.BigInteger;
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
public class GmMovimientosAnualDetalle2PK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "USUARIO")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERO_MOVIMIENTO")
    private int numeroMovimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_MOVIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaMovimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SECUENCIA_RENGLON")
    private BigInteger secuenciaRenglon;

    public GmMovimientosAnualDetalle2PK() {
    }

    public GmMovimientosAnualDetalle2PK(String usuario, int numeroMovimiento, Date fechaMovimiento, BigInteger secuenciaRenglon) {
        this.usuario = usuario;
        this.numeroMovimiento = numeroMovimiento;
        this.fechaMovimiento = fechaMovimiento;
        this.secuenciaRenglon = secuenciaRenglon;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getNumeroMovimiento() {
        return numeroMovimiento;
    }

    public void setNumeroMovimiento(int numeroMovimiento) {
        this.numeroMovimiento = numeroMovimiento;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public BigInteger getSecuenciaRenglon() {
        return secuenciaRenglon;
    }

    public void setSecuenciaRenglon(BigInteger secuenciaRenglon) {
        this.secuenciaRenglon = secuenciaRenglon;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuario != null ? usuario.hashCode() : 0);
        hash += (int) numeroMovimiento;
        hash += (fechaMovimiento != null ? fechaMovimiento.hashCode() : 0);
        hash += (secuenciaRenglon != null ? secuenciaRenglon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GmMovimientosAnualDetalle2PK)) {
            return false;
        }
        GmMovimientosAnualDetalle2PK other = (GmMovimientosAnualDetalle2PK) object;
        if ((this.usuario == null && other.usuario != null) || (this.usuario != null && !this.usuario.equals(other.usuario))) {
            return false;
        }
        if (this.numeroMovimiento != other.numeroMovimiento) {
            return false;
        }
        if ((this.fechaMovimiento == null && other.fechaMovimiento != null) || (this.fechaMovimiento != null && !this.fechaMovimiento.equals(other.fechaMovimiento))) {
            return false;
        }
        if ((this.secuenciaRenglon == null && other.secuenciaRenglon != null) || (this.secuenciaRenglon != null && !this.secuenciaRenglon.equals(other.secuenciaRenglon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.GmMovimientosAnualDetalle2PK[ usuario=" + usuario + ", numeroMovimiento=" + numeroMovimiento + ", fechaMovimiento=" + fechaMovimiento + ", secuenciaRenglon=" + secuenciaRenglon + " ]";
    }
    
}
