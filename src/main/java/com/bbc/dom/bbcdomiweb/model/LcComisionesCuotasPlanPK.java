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
public class LcComisionesCuotasPlanPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CODIGO_USUARIO")
    private String codigoUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_EMPRESA")
    private short codigoEmpresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_AGENCIA")
    private short codigoAgencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_SUB_APLICACION")
    private short codigoSubAplicacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERO_LINEA_CREDITO")
    private int numeroLineaCredito;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_TASA")
    private short codigoTasa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERO_CUOTA")
    private short numeroCuota;

    public LcComisionesCuotasPlanPK() {
    }

    public LcComisionesCuotasPlanPK(String codigoUsuario, short codigoEmpresa, short codigoAgencia, short codigoSubAplicacion, int numeroLineaCredito, short codigoTasa, short numeroCuota) {
        this.codigoUsuario = codigoUsuario;
        this.codigoEmpresa = codigoEmpresa;
        this.codigoAgencia = codigoAgencia;
        this.codigoSubAplicacion = codigoSubAplicacion;
        this.numeroLineaCredito = numeroLineaCredito;
        this.codigoTasa = codigoTasa;
        this.numeroCuota = numeroCuota;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public short getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public void setCodigoEmpresa(short codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    public short getCodigoAgencia() {
        return codigoAgencia;
    }

    public void setCodigoAgencia(short codigoAgencia) {
        this.codigoAgencia = codigoAgencia;
    }

    public short getCodigoSubAplicacion() {
        return codigoSubAplicacion;
    }

    public void setCodigoSubAplicacion(short codigoSubAplicacion) {
        this.codigoSubAplicacion = codigoSubAplicacion;
    }

    public int getNumeroLineaCredito() {
        return numeroLineaCredito;
    }

    public void setNumeroLineaCredito(int numeroLineaCredito) {
        this.numeroLineaCredito = numeroLineaCredito;
    }

    public short getCodigoTasa() {
        return codigoTasa;
    }

    public void setCodigoTasa(short codigoTasa) {
        this.codigoTasa = codigoTasa;
    }

    public short getNumeroCuota() {
        return numeroCuota;
    }

    public void setNumeroCuota(short numeroCuota) {
        this.numeroCuota = numeroCuota;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoUsuario != null ? codigoUsuario.hashCode() : 0);
        hash += (int) codigoEmpresa;
        hash += (int) codigoAgencia;
        hash += (int) codigoSubAplicacion;
        hash += (int) numeroLineaCredito;
        hash += (int) codigoTasa;
        hash += (int) numeroCuota;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LcComisionesCuotasPlanPK)) {
            return false;
        }
        LcComisionesCuotasPlanPK other = (LcComisionesCuotasPlanPK) object;
        if ((this.codigoUsuario == null && other.codigoUsuario != null) || (this.codigoUsuario != null && !this.codigoUsuario.equals(other.codigoUsuario))) {
            return false;
        }
        if (this.codigoEmpresa != other.codigoEmpresa) {
            return false;
        }
        if (this.codigoAgencia != other.codigoAgencia) {
            return false;
        }
        if (this.codigoSubAplicacion != other.codigoSubAplicacion) {
            return false;
        }
        if (this.numeroLineaCredito != other.numeroLineaCredito) {
            return false;
        }
        if (this.codigoTasa != other.codigoTasa) {
            return false;
        }
        if (this.numeroCuota != other.numeroCuota) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.LcComisionesCuotasPlanPK[ codigoUsuario=" + codigoUsuario + ", codigoEmpresa=" + codigoEmpresa + ", codigoAgencia=" + codigoAgencia + ", codigoSubAplicacion=" + codigoSubAplicacion + ", numeroLineaCredito=" + numeroLineaCredito + ", codigoTasa=" + codigoTasa + ", numeroCuota=" + numeroCuota + " ]";
    }
    
}
