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
public class MgCtasAfiliadasCreditosUapPK implements Serializable {

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
    @Size(min = 1, max = 3)
    @Column(name = "CODIGO_APLICACION")
    private String codigoAplicacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_SUBAPLICACION")
    private short codigoSubaplicacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERO_CUENTA")
    private long numeroCuenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NUMERO_CUENTA_DEST")
    private String numeroCuentaDest;

    public MgCtasAfiliadasCreditosUapPK() {
    }

    public MgCtasAfiliadasCreditosUapPK(short codigoEmpresa, short codigoAgencia, String codigoAplicacion, short codigoSubaplicacion, long numeroCuenta, String numeroCuentaDest) {
        this.codigoEmpresa = codigoEmpresa;
        this.codigoAgencia = codigoAgencia;
        this.codigoAplicacion = codigoAplicacion;
        this.codigoSubaplicacion = codigoSubaplicacion;
        this.numeroCuenta = numeroCuenta;
        this.numeroCuentaDest = numeroCuentaDest;
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

    public String getCodigoAplicacion() {
        return codigoAplicacion;
    }

    public void setCodigoAplicacion(String codigoAplicacion) {
        this.codigoAplicacion = codigoAplicacion;
    }

    public short getCodigoSubaplicacion() {
        return codigoSubaplicacion;
    }

    public void setCodigoSubaplicacion(short codigoSubaplicacion) {
        this.codigoSubaplicacion = codigoSubaplicacion;
    }

    public long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getNumeroCuentaDest() {
        return numeroCuentaDest;
    }

    public void setNumeroCuentaDest(String numeroCuentaDest) {
        this.numeroCuentaDest = numeroCuentaDest;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoEmpresa;
        hash += (int) codigoAgencia;
        hash += (codigoAplicacion != null ? codigoAplicacion.hashCode() : 0);
        hash += (int) codigoSubaplicacion;
        hash += (int) numeroCuenta;
        hash += (numeroCuentaDest != null ? numeroCuentaDest.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MgCtasAfiliadasCreditosUapPK)) {
            return false;
        }
        MgCtasAfiliadasCreditosUapPK other = (MgCtasAfiliadasCreditosUapPK) object;
        if (this.codigoEmpresa != other.codigoEmpresa) {
            return false;
        }
        if (this.codigoAgencia != other.codigoAgencia) {
            return false;
        }
        if ((this.codigoAplicacion == null && other.codigoAplicacion != null) || (this.codigoAplicacion != null && !this.codigoAplicacion.equals(other.codigoAplicacion))) {
            return false;
        }
        if (this.codigoSubaplicacion != other.codigoSubaplicacion) {
            return false;
        }
        if (this.numeroCuenta != other.numeroCuenta) {
            return false;
        }
        if ((this.numeroCuentaDest == null && other.numeroCuentaDest != null) || (this.numeroCuentaDest != null && !this.numeroCuentaDest.equals(other.numeroCuentaDest))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.MgCtasAfiliadasCreditosUapPK[ codigoEmpresa=" + codigoEmpresa + ", codigoAgencia=" + codigoAgencia + ", codigoAplicacion=" + codigoAplicacion + ", codigoSubaplicacion=" + codigoSubaplicacion + ", numeroCuenta=" + numeroCuenta + ", numeroCuentaDest=" + numeroCuentaDest + " ]";
    }
    
}
