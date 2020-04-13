/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Christian Gutierrez
 */
@Entity
@Table(name = "LC_COMISIONES_PAGOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LcComisionesPagos.findAll", query = "SELECT l FROM LcComisionesPagos l")
    , @NamedQuery(name = "LcComisionesPagos.findByCodigoEmpresa", query = "SELECT l FROM LcComisionesPagos l WHERE l.lcComisionesPagosPK.codigoEmpresa = :codigoEmpresa")
    , @NamedQuery(name = "LcComisionesPagos.findByCodigoAgencia", query = "SELECT l FROM LcComisionesPagos l WHERE l.lcComisionesPagosPK.codigoAgencia = :codigoAgencia")
    , @NamedQuery(name = "LcComisionesPagos.findByCodigoSubAplicacion", query = "SELECT l FROM LcComisionesPagos l WHERE l.lcComisionesPagosPK.codigoSubAplicacion = :codigoSubAplicacion")
    , @NamedQuery(name = "LcComisionesPagos.findByNumeroLineaCredito", query = "SELECT l FROM LcComisionesPagos l WHERE l.lcComisionesPagosPK.numeroLineaCredito = :numeroLineaCredito")
    , @NamedQuery(name = "LcComisionesPagos.findByCodigoTasa", query = "SELECT l FROM LcComisionesPagos l WHERE l.lcComisionesPagosPK.codigoTasa = :codigoTasa")
    , @NamedQuery(name = "LcComisionesPagos.findByNumeroCuota", query = "SELECT l FROM LcComisionesPagos l WHERE l.lcComisionesPagosPK.numeroCuota = :numeroCuota")
    , @NamedQuery(name = "LcComisionesPagos.findBySecuenciaPago", query = "SELECT l FROM LcComisionesPagos l WHERE l.lcComisionesPagosPK.secuenciaPago = :secuenciaPago")
    , @NamedQuery(name = "LcComisionesPagos.findByCodigoAplicacionCta", query = "SELECT l FROM LcComisionesPagos l WHERE l.codigoAplicacionCta = :codigoAplicacionCta")
    , @NamedQuery(name = "LcComisionesPagos.findByCodigoEmpresaCta", query = "SELECT l FROM LcComisionesPagos l WHERE l.codigoEmpresaCta = :codigoEmpresaCta")
    , @NamedQuery(name = "LcComisionesPagos.findByCodigoAgenciaCta", query = "SELECT l FROM LcComisionesPagos l WHERE l.codigoAgenciaCta = :codigoAgenciaCta")
    , @NamedQuery(name = "LcComisionesPagos.findByCodigoSubAplicacionCta", query = "SELECT l FROM LcComisionesPagos l WHERE l.codigoSubAplicacionCta = :codigoSubAplicacionCta")
    , @NamedQuery(name = "LcComisionesPagos.findByNumeroCuenta", query = "SELECT l FROM LcComisionesPagos l WHERE l.numeroCuenta = :numeroCuenta")
    , @NamedQuery(name = "LcComisionesPagos.findByFechaValida", query = "SELECT l FROM LcComisionesPagos l WHERE l.fechaValida = :fechaValida")
    , @NamedQuery(name = "LcComisionesPagos.findBySecuenciaDebito", query = "SELECT l FROM LcComisionesPagos l WHERE l.secuenciaDebito = :secuenciaDebito")
    , @NamedQuery(name = "LcComisionesPagos.findByCodigoUsuario", query = "SELECT l FROM LcComisionesPagos l WHERE l.codigoUsuario = :codigoUsuario")
    , @NamedQuery(name = "LcComisionesPagos.findByCodigoTipoTransaccion", query = "SELECT l FROM LcComisionesPagos l WHERE l.codigoTipoTransaccion = :codigoTipoTransaccion")
    , @NamedQuery(name = "LcComisionesPagos.findByValorDebito", query = "SELECT l FROM LcComisionesPagos l WHERE l.valorDebito = :valorDebito")
    , @NamedQuery(name = "LcComisionesPagos.findByValorImpuestos", query = "SELECT l FROM LcComisionesPagos l WHERE l.valorImpuestos = :valorImpuestos")
    , @NamedQuery(name = "LcComisionesPagos.findByFechaAdicion", query = "SELECT l FROM LcComisionesPagos l WHERE l.fechaAdicion = :fechaAdicion")
    , @NamedQuery(name = "LcComisionesPagos.findByAdicionadoPor", query = "SELECT l FROM LcComisionesPagos l WHERE l.adicionadoPor = :adicionadoPor")
    , @NamedQuery(name = "LcComisionesPagos.findByFechaModificacion", query = "SELECT l FROM LcComisionesPagos l WHERE l.fechaModificacion = :fechaModificacion")
    , @NamedQuery(name = "LcComisionesPagos.findByModificadoPor", query = "SELECT l FROM LcComisionesPagos l WHERE l.modificadoPor = :modificadoPor")})
public class LcComisionesPagos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LcComisionesPagosPK lcComisionesPagosPK;
    @Size(max = 3)
    @Column(name = "CODIGO_APLICACION_CTA")
    private String codigoAplicacionCta;
    @Column(name = "CODIGO_EMPRESA_CTA")
    private Short codigoEmpresaCta;
    @Column(name = "CODIGO_AGENCIA_CTA")
    private Short codigoAgenciaCta;
    @Column(name = "CODIGO_SUB_APLICACION_CTA")
    private Short codigoSubAplicacionCta;
    @Column(name = "NUMERO_CUENTA")
    private Long numeroCuenta;
    @Column(name = "FECHA_VALIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaValida;
    @Column(name = "SECUENCIA_DEBITO")
    private Long secuenciaDebito;
    @Size(max = 30)
    @Column(name = "CODIGO_USUARIO")
    private String codigoUsuario;
    @Column(name = "CODIGO_TIPO_TRANSACCION")
    private Short codigoTipoTransaccion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR_DEBITO")
    private BigDecimal valorDebito;
    @Column(name = "VALOR_IMPUESTOS")
    private BigDecimal valorImpuestos;
    @Column(name = "FECHA_ADICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAdicion;
    @Size(max = 30)
    @Column(name = "ADICIONADO_POR")
    private String adicionadoPor;
    @Column(name = "FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Size(max = 30)
    @Column(name = "MODIFICADO_POR")
    private String modificadoPor;

    public LcComisionesPagos() {
    }

    public LcComisionesPagos(LcComisionesPagosPK lcComisionesPagosPK) {
        this.lcComisionesPagosPK = lcComisionesPagosPK;
    }

    public LcComisionesPagos(short codigoEmpresa, short codigoAgencia, short codigoSubAplicacion, int numeroLineaCredito, short codigoTasa, short numeroCuota, long secuenciaPago) {
        this.lcComisionesPagosPK = new LcComisionesPagosPK(codigoEmpresa, codigoAgencia, codigoSubAplicacion, numeroLineaCredito, codigoTasa, numeroCuota, secuenciaPago);
    }

    public LcComisionesPagosPK getLcComisionesPagosPK() {
        return lcComisionesPagosPK;
    }

    public void setLcComisionesPagosPK(LcComisionesPagosPK lcComisionesPagosPK) {
        this.lcComisionesPagosPK = lcComisionesPagosPK;
    }

    public String getCodigoAplicacionCta() {
        return codigoAplicacionCta;
    }

    public void setCodigoAplicacionCta(String codigoAplicacionCta) {
        this.codigoAplicacionCta = codigoAplicacionCta;
    }

    public Short getCodigoEmpresaCta() {
        return codigoEmpresaCta;
    }

    public void setCodigoEmpresaCta(Short codigoEmpresaCta) {
        this.codigoEmpresaCta = codigoEmpresaCta;
    }

    public Short getCodigoAgenciaCta() {
        return codigoAgenciaCta;
    }

    public void setCodigoAgenciaCta(Short codigoAgenciaCta) {
        this.codigoAgenciaCta = codigoAgenciaCta;
    }

    public Short getCodigoSubAplicacionCta() {
        return codigoSubAplicacionCta;
    }

    public void setCodigoSubAplicacionCta(Short codigoSubAplicacionCta) {
        this.codigoSubAplicacionCta = codigoSubAplicacionCta;
    }

    public Long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Date getFechaValida() {
        return fechaValida;
    }

    public void setFechaValida(Date fechaValida) {
        this.fechaValida = fechaValida;
    }

    public Long getSecuenciaDebito() {
        return secuenciaDebito;
    }

    public void setSecuenciaDebito(Long secuenciaDebito) {
        this.secuenciaDebito = secuenciaDebito;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public Short getCodigoTipoTransaccion() {
        return codigoTipoTransaccion;
    }

    public void setCodigoTipoTransaccion(Short codigoTipoTransaccion) {
        this.codigoTipoTransaccion = codigoTipoTransaccion;
    }

    public BigDecimal getValorDebito() {
        return valorDebito;
    }

    public void setValorDebito(BigDecimal valorDebito) {
        this.valorDebito = valorDebito;
    }

    public BigDecimal getValorImpuestos() {
        return valorImpuestos;
    }

    public void setValorImpuestos(BigDecimal valorImpuestos) {
        this.valorImpuestos = valorImpuestos;
    }

    public Date getFechaAdicion() {
        return fechaAdicion;
    }

    public void setFechaAdicion(Date fechaAdicion) {
        this.fechaAdicion = fechaAdicion;
    }

    public String getAdicionadoPor() {
        return adicionadoPor;
    }

    public void setAdicionadoPor(String adicionadoPor) {
        this.adicionadoPor = adicionadoPor;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getModificadoPor() {
        return modificadoPor;
    }

    public void setModificadoPor(String modificadoPor) {
        this.modificadoPor = modificadoPor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lcComisionesPagosPK != null ? lcComisionesPagosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LcComisionesPagos)) {
            return false;
        }
        LcComisionesPagos other = (LcComisionesPagos) object;
        if ((this.lcComisionesPagosPK == null && other.lcComisionesPagosPK != null) || (this.lcComisionesPagosPK != null && !this.lcComisionesPagosPK.equals(other.lcComisionesPagosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.LcComisionesPagos[ lcComisionesPagosPK=" + lcComisionesPagosPK + " ]";
    }
    
}
