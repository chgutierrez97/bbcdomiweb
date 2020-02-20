/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Christian Gutierrez
 */
@Entity
@Table(name = "MG_CUENTAS_AFILIADAS_DOMIC_UAP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MgCuentasAfiliadasDomicUap.findAll", query = "SELECT m FROM MgCuentasAfiliadasDomicUap m")
    , @NamedQuery(name = "MgCuentasAfiliadasDomicUap.findByCodigoEmpresa", query = "SELECT m FROM MgCuentasAfiliadasDomicUap m WHERE m.mgCuentasAfiliadasDomicUapPK.codigoEmpresa = :codigoEmpresa")
    , @NamedQuery(name = "MgCuentasAfiliadasDomicUap.findByCodigoAgencia", query = "SELECT m FROM MgCuentasAfiliadasDomicUap m WHERE m.mgCuentasAfiliadasDomicUapPK.codigoAgencia = :codigoAgencia")
    , @NamedQuery(name = "MgCuentasAfiliadasDomicUap.findByCodigoAplicacion", query = "SELECT m FROM MgCuentasAfiliadasDomicUap m WHERE m.mgCuentasAfiliadasDomicUapPK.codigoAplicacion = :codigoAplicacion")
    , @NamedQuery(name = "MgCuentasAfiliadasDomicUap.findByCodigoSubaplicacion", query = "SELECT m FROM MgCuentasAfiliadasDomicUap m WHERE m.mgCuentasAfiliadasDomicUapPK.codigoSubaplicacion = :codigoSubaplicacion")
    , @NamedQuery(name = "MgCuentasAfiliadasDomicUap.findByNumeroCuentaTdc", query = "SELECT m FROM MgCuentasAfiliadasDomicUap m WHERE m.mgCuentasAfiliadasDomicUapPK.numeroCuentaTdc = :numeroCuentaTdc")
    , @NamedQuery(name = "MgCuentasAfiliadasDomicUap.findByBancoEmisor", query = "SELECT m FROM MgCuentasAfiliadasDomicUap m WHERE m.mgCuentasAfiliadasDomicUapPK.bancoEmisor = :bancoEmisor")
    , @NamedQuery(name = "MgCuentasAfiliadasDomicUap.findByReferenciaContrato", query = "SELECT m FROM MgCuentasAfiliadasDomicUap m WHERE m.mgCuentasAfiliadasDomicUapPK.referenciaContrato = :referenciaContrato")
    , @NamedQuery(name = "MgCuentasAfiliadasDomicUap.findByCodigoCliente", query = "SELECT m FROM MgCuentasAfiliadasDomicUap m WHERE m.codigoCliente = :codigoCliente")
    , @NamedQuery(name = "MgCuentasAfiliadasDomicUap.findByReferenciaOrdenante", query = "SELECT m FROM MgCuentasAfiliadasDomicUap m WHERE m.referenciaOrdenante = :referenciaOrdenante")
    , @NamedQuery(name = "MgCuentasAfiliadasDomicUap.findByMontoMaximoAutorizado", query = "SELECT m FROM MgCuentasAfiliadasDomicUap m WHERE m.montoMaximoAutorizado = :montoMaximoAutorizado")
    , @NamedQuery(name = "MgCuentasAfiliadasDomicUap.findByFechaValida", query = "SELECT m FROM MgCuentasAfiliadasDomicUap m WHERE m.fechaValida = :fechaValida")
    , @NamedQuery(name = "MgCuentasAfiliadasDomicUap.findByEstado", query = "SELECT m FROM MgCuentasAfiliadasDomicUap m WHERE m.estado = :estado")
    , @NamedQuery(name = "MgCuentasAfiliadasDomicUap.findByAdicionadoPor", query = "SELECT m FROM MgCuentasAfiliadasDomicUap m WHERE m.adicionadoPor = :adicionadoPor")
    , @NamedQuery(name = "MgCuentasAfiliadasDomicUap.findByFechaAdicion", query = "SELECT m FROM MgCuentasAfiliadasDomicUap m WHERE m.fechaAdicion = :fechaAdicion")
    , @NamedQuery(name = "MgCuentasAfiliadasDomicUap.findByAutorizadoPor", query = "SELECT m FROM MgCuentasAfiliadasDomicUap m WHERE m.autorizadoPor = :autorizadoPor")
    , @NamedQuery(name = "MgCuentasAfiliadasDomicUap.findByFechaAutorizacion", query = "SELECT m FROM MgCuentasAfiliadasDomicUap m WHERE m.fechaAutorizacion = :fechaAutorizacion")
    , @NamedQuery(name = "MgCuentasAfiliadasDomicUap.findByModificadoPor", query = "SELECT m FROM MgCuentasAfiliadasDomicUap m WHERE m.modificadoPor = :modificadoPor")
    , @NamedQuery(name = "MgCuentasAfiliadasDomicUap.findByFechaModificacion", query = "SELECT m FROM MgCuentasAfiliadasDomicUap m WHERE m.fechaModificacion = :fechaModificacion")
    , @NamedQuery(name = "MgCuentasAfiliadasDomicUap.findByAgenciaAdiciona", query = "SELECT m FROM MgCuentasAfiliadasDomicUap m WHERE m.agenciaAdiciona = :agenciaAdiciona")
    , @NamedQuery(name = "MgCuentasAfiliadasDomicUap.findByCodigoAfiliaUap", query = "SELECT m FROM MgCuentasAfiliadasDomicUap m WHERE m.codigoAfiliaUap = :codigoAfiliaUap")
    , @NamedQuery(name = "MgCuentasAfiliadasDomicUap.findByCodigoDesafiliaUap", query = "SELECT m FROM MgCuentasAfiliadasDomicUap m WHERE m.codigoDesafiliaUap = :codigoDesafiliaUap")
    , @NamedQuery(name = "MgCuentasAfiliadasDomicUap.findByUltimoCambio", query = "SELECT m FROM MgCuentasAfiliadasDomicUap m WHERE m.ultimoCambio = :ultimoCambio")
    , @NamedQuery(name = "MgCuentasAfiliadasDomicUap.findByCanalAfiliacion", query = "SELECT m FROM MgCuentasAfiliadasDomicUap m WHERE m.canalAfiliacion = :canalAfiliacion")
    , @NamedQuery(name = "MgCuentasAfiliadasDomicUap.findByCodigoEmpresaAct", query = "SELECT m FROM MgCuentasAfiliadasDomicUap m WHERE m.codigoEmpresaAct = :codigoEmpresaAct")
    , @NamedQuery(name = "MgCuentasAfiliadasDomicUap.findByCodigoAgenciaAct", query = "SELECT m FROM MgCuentasAfiliadasDomicUap m WHERE m.codigoAgenciaAct = :codigoAgenciaAct")
    , @NamedQuery(name = "MgCuentasAfiliadasDomicUap.findByCodigoAplicacionAct", query = "SELECT m FROM MgCuentasAfiliadasDomicUap m WHERE m.codigoAplicacionAct = :codigoAplicacionAct")
    , @NamedQuery(name = "MgCuentasAfiliadasDomicUap.findByNumeroCuentaTdcAct", query = "SELECT m FROM MgCuentasAfiliadasDomicUap m WHERE m.numeroCuentaTdcAct = :numeroCuentaTdcAct")
    , @NamedQuery(name = "MgCuentasAfiliadasDomicUap.findByBancoEmisorAct", query = "SELECT m FROM MgCuentasAfiliadasDomicUap m WHERE m.bancoEmisorAct = :bancoEmisorAct")
    , @NamedQuery(name = "MgCuentasAfiliadasDomicUap.findByReferenciaContratoAct", query = "SELECT m FROM MgCuentasAfiliadasDomicUap m WHERE m.referenciaContratoAct = :referenciaContratoAct")
    , @NamedQuery(name = "MgCuentasAfiliadasDomicUap.findByCodigoSubaplicacionAct", query = "SELECT m FROM MgCuentasAfiliadasDomicUap m WHERE m.codigoSubaplicacionAct = :codigoSubaplicacionAct")})
public class MgCuentasAfiliadasDomicUap implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MgCuentasAfiliadasDomicUapPK mgCuentasAfiliadasDomicUapPK;
    @Column(name = "CODIGO_CLIENTE")
    private Long codigoCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "REFERENCIA_ORDENANTE")
    private String referenciaOrdenante;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MONTO_MAXIMO_AUTORIZADO")
    private BigDecimal montoMaximoAutorizado;
    @Column(name = "FECHA_VALIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaValida;
    @Size(max = 10)
    @Column(name = "ESTADO")
    private String estado;
    @Size(max = 10)
    @Column(name = "ADICIONADO_POR")
    private String adicionadoPor;
    @Column(name = "FECHA_ADICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAdicion;
    @Size(max = 10)
    @Column(name = "AUTORIZADO_POR")
    private String autorizadoPor;
    @Column(name = "FECHA_AUTORIZACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAutorizacion;
    @Size(max = 10)
    @Column(name = "MODIFICADO_POR")
    private String modificadoPor;
    @Column(name = "FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Column(name = "AGENCIA_ADICIONA")
    private Short agenciaAdiciona;
    @Size(max = 3)
    @Column(name = "CODIGO_AFILIA_UAP")
    private String codigoAfiliaUap;
    @Size(max = 3)
    @Column(name = "CODIGO_DESAFILIA_UAP")
    private String codigoDesafiliaUap;
    @Column(name = "ULTIMO_CAMBIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimoCambio;
    @Size(max = 3)
    @Column(name = "CANAL_AFILIACION")
    private String canalAfiliacion;
    @Column(name = "CODIGO_EMPRESA_ACT")
    private Short codigoEmpresaAct;
    @Column(name = "CODIGO_AGENCIA_ACT")
    private Short codigoAgenciaAct;
    @Size(max = 3)
    @Column(name = "CODIGO_APLICACION_ACT")
    private String codigoAplicacionAct;
    @Column(name = "NUMERO_CUENTA_TDC_ACT")
    private BigInteger numeroCuentaTdcAct;
    @Size(max = 4)
    @Column(name = "BANCO_EMISOR_ACT")
    private String bancoEmisorAct;
    @Size(max = 30)
    @Column(name = "REFERENCIA_CONTRATO_ACT")
    private String referenciaContratoAct;
    @Column(name = "CODIGO_SUBAPLICACION_ACT")
    private Short codigoSubaplicacionAct;

    public MgCuentasAfiliadasDomicUap() {
    }

    public MgCuentasAfiliadasDomicUap(MgCuentasAfiliadasDomicUapPK mgCuentasAfiliadasDomicUapPK) {
        this.mgCuentasAfiliadasDomicUapPK = mgCuentasAfiliadasDomicUapPK;
    }

    public MgCuentasAfiliadasDomicUap(MgCuentasAfiliadasDomicUapPK mgCuentasAfiliadasDomicUapPK, String referenciaOrdenante) {
        this.mgCuentasAfiliadasDomicUapPK = mgCuentasAfiliadasDomicUapPK;
        this.referenciaOrdenante = referenciaOrdenante;
    }

    public MgCuentasAfiliadasDomicUap(short codigoEmpresa, short codigoAgencia, String codigoAplicacion, short codigoSubaplicacion, BigInteger numeroCuentaTdc, String bancoEmisor, String referenciaContrato) {
        this.mgCuentasAfiliadasDomicUapPK = new MgCuentasAfiliadasDomicUapPK(codigoEmpresa, codigoAgencia, codigoAplicacion, codigoSubaplicacion, numeroCuentaTdc, bancoEmisor, referenciaContrato);
    }

    public MgCuentasAfiliadasDomicUapPK getMgCuentasAfiliadasDomicUapPK() {
        return mgCuentasAfiliadasDomicUapPK;
    }

    public void setMgCuentasAfiliadasDomicUapPK(MgCuentasAfiliadasDomicUapPK mgCuentasAfiliadasDomicUapPK) {
        this.mgCuentasAfiliadasDomicUapPK = mgCuentasAfiliadasDomicUapPK;
    }

    public Long getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Long codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getReferenciaOrdenante() {
        return referenciaOrdenante;
    }

    public void setReferenciaOrdenante(String referenciaOrdenante) {
        this.referenciaOrdenante = referenciaOrdenante;
    }

    public BigDecimal getMontoMaximoAutorizado() {
        return montoMaximoAutorizado;
    }

    public void setMontoMaximoAutorizado(BigDecimal montoMaximoAutorizado) {
        this.montoMaximoAutorizado = montoMaximoAutorizado;
    }

    public Date getFechaValida() {
        return fechaValida;
    }

    public void setFechaValida(Date fechaValida) {
        this.fechaValida = fechaValida;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getAdicionadoPor() {
        return adicionadoPor;
    }

    public void setAdicionadoPor(String adicionadoPor) {
        this.adicionadoPor = adicionadoPor;
    }

    public Date getFechaAdicion() {
        return fechaAdicion;
    }

    public void setFechaAdicion(Date fechaAdicion) {
        this.fechaAdicion = fechaAdicion;
    }

    public String getAutorizadoPor() {
        return autorizadoPor;
    }

    public void setAutorizadoPor(String autorizadoPor) {
        this.autorizadoPor = autorizadoPor;
    }

    public Date getFechaAutorizacion() {
        return fechaAutorizacion;
    }

    public void setFechaAutorizacion(Date fechaAutorizacion) {
        this.fechaAutorizacion = fechaAutorizacion;
    }

    public String getModificadoPor() {
        return modificadoPor;
    }

    public void setModificadoPor(String modificadoPor) {
        this.modificadoPor = modificadoPor;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Short getAgenciaAdiciona() {
        return agenciaAdiciona;
    }

    public void setAgenciaAdiciona(Short agenciaAdiciona) {
        this.agenciaAdiciona = agenciaAdiciona;
    }

    public String getCodigoAfiliaUap() {
        return codigoAfiliaUap;
    }

    public void setCodigoAfiliaUap(String codigoAfiliaUap) {
        this.codigoAfiliaUap = codigoAfiliaUap;
    }

    public String getCodigoDesafiliaUap() {
        return codigoDesafiliaUap;
    }

    public void setCodigoDesafiliaUap(String codigoDesafiliaUap) {
        this.codigoDesafiliaUap = codigoDesafiliaUap;
    }

    public Date getUltimoCambio() {
        return ultimoCambio;
    }

    public void setUltimoCambio(Date ultimoCambio) {
        this.ultimoCambio = ultimoCambio;
    }

    public String getCanalAfiliacion() {
        return canalAfiliacion;
    }

    public void setCanalAfiliacion(String canalAfiliacion) {
        this.canalAfiliacion = canalAfiliacion;
    }

    public Short getCodigoEmpresaAct() {
        return codigoEmpresaAct;
    }

    public void setCodigoEmpresaAct(Short codigoEmpresaAct) {
        this.codigoEmpresaAct = codigoEmpresaAct;
    }

    public Short getCodigoAgenciaAct() {
        return codigoAgenciaAct;
    }

    public void setCodigoAgenciaAct(Short codigoAgenciaAct) {
        this.codigoAgenciaAct = codigoAgenciaAct;
    }

    public String getCodigoAplicacionAct() {
        return codigoAplicacionAct;
    }

    public void setCodigoAplicacionAct(String codigoAplicacionAct) {
        this.codigoAplicacionAct = codigoAplicacionAct;
    }

    public BigInteger getNumeroCuentaTdcAct() {
        return numeroCuentaTdcAct;
    }

    public void setNumeroCuentaTdcAct(BigInteger numeroCuentaTdcAct) {
        this.numeroCuentaTdcAct = numeroCuentaTdcAct;
    }

    public String getBancoEmisorAct() {
        return bancoEmisorAct;
    }

    public void setBancoEmisorAct(String bancoEmisorAct) {
        this.bancoEmisorAct = bancoEmisorAct;
    }

    public String getReferenciaContratoAct() {
        return referenciaContratoAct;
    }

    public void setReferenciaContratoAct(String referenciaContratoAct) {
        this.referenciaContratoAct = referenciaContratoAct;
    }

    public Short getCodigoSubaplicacionAct() {
        return codigoSubaplicacionAct;
    }

    public void setCodigoSubaplicacionAct(Short codigoSubaplicacionAct) {
        this.codigoSubaplicacionAct = codigoSubaplicacionAct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mgCuentasAfiliadasDomicUapPK != null ? mgCuentasAfiliadasDomicUapPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MgCuentasAfiliadasDomicUap)) {
            return false;
        }
        MgCuentasAfiliadasDomicUap other = (MgCuentasAfiliadasDomicUap) object;
        if ((this.mgCuentasAfiliadasDomicUapPK == null && other.mgCuentasAfiliadasDomicUapPK != null) || (this.mgCuentasAfiliadasDomicUapPK != null && !this.mgCuentasAfiliadasDomicUapPK.equals(other.mgCuentasAfiliadasDomicUapPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.MgCuentasAfiliadasDomicUap[ mgCuentasAfiliadasDomicUapPK=" + mgCuentasAfiliadasDomicUapPK + " ]";
    }
    
}
