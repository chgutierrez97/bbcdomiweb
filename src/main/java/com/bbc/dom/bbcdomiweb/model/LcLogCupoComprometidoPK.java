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

/**
 *
 * @author Christian Gutierrez
 */
@Embeddable
public class LcLogCupoComprometidoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_EMPRESA")
    private short codigoEmpresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_LINEA_CREDITO")
    private long codigoLineaCredito;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_CUOTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCuota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUOTA")
    private BigInteger cuota;

    public LcLogCupoComprometidoPK() {
    }

    public LcLogCupoComprometidoPK(short codigoEmpresa, long codigoLineaCredito, Date fechaCuota, BigInteger cuota) {
        this.codigoEmpresa = codigoEmpresa;
        this.codigoLineaCredito = codigoLineaCredito;
        this.fechaCuota = fechaCuota;
        this.cuota = cuota;
    }

    public short getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public void setCodigoEmpresa(short codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    public long getCodigoLineaCredito() {
        return codigoLineaCredito;
    }

    public void setCodigoLineaCredito(long codigoLineaCredito) {
        this.codigoLineaCredito = codigoLineaCredito;
    }

    public Date getFechaCuota() {
        return fechaCuota;
    }

    public void setFechaCuota(Date fechaCuota) {
        this.fechaCuota = fechaCuota;
    }

    public BigInteger getCuota() {
        return cuota;
    }

    public void setCuota(BigInteger cuota) {
        this.cuota = cuota;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoEmpresa;
        hash += (int) codigoLineaCredito;
        hash += (fechaCuota != null ? fechaCuota.hashCode() : 0);
        hash += (cuota != null ? cuota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LcLogCupoComprometidoPK)) {
            return false;
        }
        LcLogCupoComprometidoPK other = (LcLogCupoComprometidoPK) object;
        if (this.codigoEmpresa != other.codigoEmpresa) {
            return false;
        }
        if (this.codigoLineaCredito != other.codigoLineaCredito) {
            return false;
        }
        if ((this.fechaCuota == null && other.fechaCuota != null) || (this.fechaCuota != null && !this.fechaCuota.equals(other.fechaCuota))) {
            return false;
        }
        if ((this.cuota == null && other.cuota != null) || (this.cuota != null && !this.cuota.equals(other.cuota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.LcLogCupoComprometidoPK[ codigoEmpresa=" + codigoEmpresa + ", codigoLineaCredito=" + codigoLineaCredito + ", fechaCuota=" + fechaCuota + ", cuota=" + cuota + " ]";
    }
    
}
