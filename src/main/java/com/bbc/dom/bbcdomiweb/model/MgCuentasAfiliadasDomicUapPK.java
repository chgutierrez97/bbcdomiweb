/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.model;

import java.io.Serializable;
import java.math.BigInteger;
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
public class MgCuentasAfiliadasDomicUapPK implements Serializable {

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
    @Column(name = "NUMERO_CUENTA_TDC")
    private BigInteger numeroCuentaTdc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "BANCO_EMISOR")
    private String bancoEmisor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "REFERENCIA_CONTRATO")
    private String referenciaContrato;

    public MgCuentasAfiliadasDomicUapPK() {
    }

    public MgCuentasAfiliadasDomicUapPK(short codigoEmpresa, short codigoAgencia, String codigoAplicacion, short codigoSubaplicacion, BigInteger numeroCuentaTdc, String bancoEmisor, String referenciaContrato) {
        this.codigoEmpresa = codigoEmpresa;
        this.codigoAgencia = codigoAgencia;
        this.codigoAplicacion = codigoAplicacion;
        this.codigoSubaplicacion = codigoSubaplicacion;
        this.numeroCuentaTdc = numeroCuentaTdc;
        this.bancoEmisor = bancoEmisor;
        this.referenciaContrato = referenciaContrato;
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

    public BigInteger getNumeroCuentaTdc() {
        return numeroCuentaTdc;
    }

    public void setNumeroCuentaTdc(BigInteger numeroCuentaTdc) {
        this.numeroCuentaTdc = numeroCuentaTdc;
    }

    public String getBancoEmisor() {
        return bancoEmisor;
    }

    public void setBancoEmisor(String bancoEmisor) {
        this.bancoEmisor = bancoEmisor;
    }

    public String getReferenciaContrato() {
        return referenciaContrato;
    }

    public void setReferenciaContrato(String referenciaContrato) {
        this.referenciaContrato = referenciaContrato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoEmpresa;
        hash += (int) codigoAgencia;
        hash += (codigoAplicacion != null ? codigoAplicacion.hashCode() : 0);
        hash += (int) codigoSubaplicacion;
        hash += (numeroCuentaTdc != null ? numeroCuentaTdc.hashCode() : 0);
        hash += (bancoEmisor != null ? bancoEmisor.hashCode() : 0);
        hash += (referenciaContrato != null ? referenciaContrato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MgCuentasAfiliadasDomicUapPK)) {
            return false;
        }
        MgCuentasAfiliadasDomicUapPK other = (MgCuentasAfiliadasDomicUapPK) object;
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
        if ((this.numeroCuentaTdc == null && other.numeroCuentaTdc != null) || (this.numeroCuentaTdc != null && !this.numeroCuentaTdc.equals(other.numeroCuentaTdc))) {
            return false;
        }
        if ((this.bancoEmisor == null && other.bancoEmisor != null) || (this.bancoEmisor != null && !this.bancoEmisor.equals(other.bancoEmisor))) {
            return false;
        }
        if ((this.referenciaContrato == null && other.referenciaContrato != null) || (this.referenciaContrato != null && !this.referenciaContrato.equals(other.referenciaContrato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.MgCuentasAfiliadasDomicUapPK[ codigoEmpresa=" + codigoEmpresa + ", codigoAgencia=" + codigoAgencia + ", codigoAplicacion=" + codigoAplicacion + ", codigoSubaplicacion=" + codigoSubaplicacion + ", numeroCuentaTdc=" + numeroCuentaTdc + ", bancoEmisor=" + bancoEmisor + ", referenciaContrato=" + referenciaContrato + " ]";
    }
    
}
