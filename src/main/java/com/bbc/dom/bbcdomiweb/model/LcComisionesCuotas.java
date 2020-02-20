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
@Table(name = "LC_COMISIONES_CUOTAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LcComisionesCuotas.findAll", query = "SELECT l FROM LcComisionesCuotas l")
    , @NamedQuery(name = "LcComisionesCuotas.findByCodigoEmpresa", query = "SELECT l FROM LcComisionesCuotas l WHERE l.lcComisionesCuotasPK.codigoEmpresa = :codigoEmpresa")
    , @NamedQuery(name = "LcComisionesCuotas.findByCodigoAgencia", query = "SELECT l FROM LcComisionesCuotas l WHERE l.lcComisionesCuotasPK.codigoAgencia = :codigoAgencia")
    , @NamedQuery(name = "LcComisionesCuotas.findByCodigoSubAplicacion", query = "SELECT l FROM LcComisionesCuotas l WHERE l.lcComisionesCuotasPK.codigoSubAplicacion = :codigoSubAplicacion")
    , @NamedQuery(name = "LcComisionesCuotas.findByNumeroLineaCredito", query = "SELECT l FROM LcComisionesCuotas l WHERE l.lcComisionesCuotasPK.numeroLineaCredito = :numeroLineaCredito")
    , @NamedQuery(name = "LcComisionesCuotas.findByCodigoTasa", query = "SELECT l FROM LcComisionesCuotas l WHERE l.lcComisionesCuotasPK.codigoTasa = :codigoTasa")
    , @NamedQuery(name = "LcComisionesCuotas.findByNumeroCuota", query = "SELECT l FROM LcComisionesCuotas l WHERE l.lcComisionesCuotasPK.numeroCuota = :numeroCuota")
    , @NamedQuery(name = "LcComisionesCuotas.findByFechaVence", query = "SELECT l FROM LcComisionesCuotas l WHERE l.fechaVence = :fechaVence")
    , @NamedQuery(name = "LcComisionesCuotas.findByFechaPagada", query = "SELECT l FROM LcComisionesCuotas l WHERE l.fechaPagada = :fechaPagada")
    , @NamedQuery(name = "LcComisionesCuotas.findByPagado", query = "SELECT l FROM LcComisionesCuotas l WHERE l.pagado = :pagado")
    , @NamedQuery(name = "LcComisionesCuotas.findByTasaComision", query = "SELECT l FROM LcComisionesCuotas l WHERE l.tasaComision = :tasaComision")
    , @NamedQuery(name = "LcComisionesCuotas.findByValorLinea", query = "SELECT l FROM LcComisionesCuotas l WHERE l.valorLinea = :valorLinea")
    , @NamedQuery(name = "LcComisionesCuotas.findByValor", query = "SELECT l FROM LcComisionesCuotas l WHERE l.valor = :valor")
    , @NamedQuery(name = "LcComisionesCuotas.findByValorPagado", query = "SELECT l FROM LcComisionesCuotas l WHERE l.valorPagado = :valorPagado")
    , @NamedQuery(name = "LcComisionesCuotas.findByValorVpc", query = "SELECT l FROM LcComisionesCuotas l WHERE l.valorVpc = :valorVpc")
    , @NamedQuery(name = "LcComisionesCuotas.findBySecuenciaVpc", query = "SELECT l FROM LcComisionesCuotas l WHERE l.secuenciaVpc = :secuenciaVpc")
    , @NamedQuery(name = "LcComisionesCuotas.findByValorDisponible", query = "SELECT l FROM LcComisionesCuotas l WHERE l.valorDisponible = :valorDisponible")
    , @NamedQuery(name = "LcComisionesCuotas.findByObservacion", query = "SELECT l FROM LcComisionesCuotas l WHERE l.observacion = :observacion")
    , @NamedQuery(name = "LcComisionesCuotas.findByProcesado", query = "SELECT l FROM LcComisionesCuotas l WHERE l.procesado = :procesado")
    , @NamedQuery(name = "LcComisionesCuotas.findByFechaAdicion", query = "SELECT l FROM LcComisionesCuotas l WHERE l.fechaAdicion = :fechaAdicion")
    , @NamedQuery(name = "LcComisionesCuotas.findByAdicionadoPor", query = "SELECT l FROM LcComisionesCuotas l WHERE l.adicionadoPor = :adicionadoPor")
    , @NamedQuery(name = "LcComisionesCuotas.findByFechaModificacion", query = "SELECT l FROM LcComisionesCuotas l WHERE l.fechaModificacion = :fechaModificacion")
    , @NamedQuery(name = "LcComisionesCuotas.findByModificadoPor", query = "SELECT l FROM LcComisionesCuotas l WHERE l.modificadoPor = :modificadoPor")})
public class LcComisionesCuotas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LcComisionesCuotasPK lcComisionesCuotasPK;
    @Column(name = "FECHA_VENCE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVence;
    @Column(name = "FECHA_PAGADA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPagada;
    @Size(max = 1)
    @Column(name = "PAGADO")
    private String pagado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TASA_COMISION")
    private BigDecimal tasaComision;
    @Column(name = "VALOR_LINEA")
    private BigDecimal valorLinea;
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Column(name = "VALOR_PAGADO")
    private BigDecimal valorPagado;
    @Column(name = "VALOR_VPC")
    private BigDecimal valorVpc;
    @Column(name = "SECUENCIA_VPC")
    private Long secuenciaVpc;
    @Column(name = "VALOR_DISPONIBLE")
    private BigDecimal valorDisponible;
    @Size(max = 2000)
    @Column(name = "OBSERVACION")
    private String observacion;
    @Size(max = 1)
    @Column(name = "PROCESADO")
    private String procesado;
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

    public LcComisionesCuotas() {
    }

    public LcComisionesCuotas(LcComisionesCuotasPK lcComisionesCuotasPK) {
        this.lcComisionesCuotasPK = lcComisionesCuotasPK;
    }

    public LcComisionesCuotas(short codigoEmpresa, short codigoAgencia, short codigoSubAplicacion, int numeroLineaCredito, short codigoTasa, short numeroCuota) {
        this.lcComisionesCuotasPK = new LcComisionesCuotasPK(codigoEmpresa, codigoAgencia, codigoSubAplicacion, numeroLineaCredito, codigoTasa, numeroCuota);
    }

    public LcComisionesCuotasPK getLcComisionesCuotasPK() {
        return lcComisionesCuotasPK;
    }

    public void setLcComisionesCuotasPK(LcComisionesCuotasPK lcComisionesCuotasPK) {
        this.lcComisionesCuotasPK = lcComisionesCuotasPK;
    }

    public Date getFechaVence() {
        return fechaVence;
    }

    public void setFechaVence(Date fechaVence) {
        this.fechaVence = fechaVence;
    }

    public Date getFechaPagada() {
        return fechaPagada;
    }

    public void setFechaPagada(Date fechaPagada) {
        this.fechaPagada = fechaPagada;
    }

    public String getPagado() {
        return pagado;
    }

    public void setPagado(String pagado) {
        this.pagado = pagado;
    }

    public BigDecimal getTasaComision() {
        return tasaComision;
    }

    public void setTasaComision(BigDecimal tasaComision) {
        this.tasaComision = tasaComision;
    }

    public BigDecimal getValorLinea() {
        return valorLinea;
    }

    public void setValorLinea(BigDecimal valorLinea) {
        this.valorLinea = valorLinea;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValorPagado() {
        return valorPagado;
    }

    public void setValorPagado(BigDecimal valorPagado) {
        this.valorPagado = valorPagado;
    }

    public BigDecimal getValorVpc() {
        return valorVpc;
    }

    public void setValorVpc(BigDecimal valorVpc) {
        this.valorVpc = valorVpc;
    }

    public Long getSecuenciaVpc() {
        return secuenciaVpc;
    }

    public void setSecuenciaVpc(Long secuenciaVpc) {
        this.secuenciaVpc = secuenciaVpc;
    }

    public BigDecimal getValorDisponible() {
        return valorDisponible;
    }

    public void setValorDisponible(BigDecimal valorDisponible) {
        this.valorDisponible = valorDisponible;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getProcesado() {
        return procesado;
    }

    public void setProcesado(String procesado) {
        this.procesado = procesado;
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
        hash += (lcComisionesCuotasPK != null ? lcComisionesCuotasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LcComisionesCuotas)) {
            return false;
        }
        LcComisionesCuotas other = (LcComisionesCuotas) object;
        if ((this.lcComisionesCuotasPK == null && other.lcComisionesCuotasPK != null) || (this.lcComisionesCuotasPK != null && !this.lcComisionesCuotasPK.equals(other.lcComisionesCuotasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.LcComisionesCuotas[ lcComisionesCuotasPK=" + lcComisionesCuotasPK + " ]";
    }
    
}
