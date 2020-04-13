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
@Table(name = "LC_COMISIONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LcComisiones.findAll", query = "SELECT l FROM LcComisiones l")
    , @NamedQuery(name = "LcComisiones.findByCodigoEmpresa", query = "SELECT l FROM LcComisiones l WHERE l.lcComisionesPK.codigoEmpresa = :codigoEmpresa")
    , @NamedQuery(name = "LcComisiones.findByCodigoAplicacion", query = "SELECT l FROM LcComisiones l WHERE l.codigoAplicacion = :codigoAplicacion")
    , @NamedQuery(name = "LcComisiones.findByCodigoAgencia", query = "SELECT l FROM LcComisiones l WHERE l.lcComisionesPK.codigoAgencia = :codigoAgencia")
    , @NamedQuery(name = "LcComisiones.findByCodigoSubAplicacion", query = "SELECT l FROM LcComisiones l WHERE l.lcComisionesPK.codigoSubAplicacion = :codigoSubAplicacion")
    , @NamedQuery(name = "LcComisiones.findByNumeroLineaCredito", query = "SELECT l FROM LcComisiones l WHERE l.lcComisionesPK.numeroLineaCredito = :numeroLineaCredito")
    , @NamedQuery(name = "LcComisiones.findByCodigoAplicacionCta", query = "SELECT l FROM LcComisiones l WHERE l.codigoAplicacionCta = :codigoAplicacionCta")
    , @NamedQuery(name = "LcComisiones.findByCodigoEmpresaCta", query = "SELECT l FROM LcComisiones l WHERE l.codigoEmpresaCta = :codigoEmpresaCta")
    , @NamedQuery(name = "LcComisiones.findByCodigoAgenciaCta", query = "SELECT l FROM LcComisiones l WHERE l.codigoAgenciaCta = :codigoAgenciaCta")
    , @NamedQuery(name = "LcComisiones.findByCodigoSubAplicacionCta", query = "SELECT l FROM LcComisiones l WHERE l.codigoSubAplicacionCta = :codigoSubAplicacionCta")
    , @NamedQuery(name = "LcComisiones.findByNumeroCuenta", query = "SELECT l FROM LcComisiones l WHERE l.numeroCuenta = :numeroCuenta")
    , @NamedQuery(name = "LcComisiones.findByTipoFrecuencia", query = "SELECT l FROM LcComisiones l WHERE l.tipoFrecuencia = :tipoFrecuencia")
    , @NamedQuery(name = "LcComisiones.findByFrecuencia", query = "SELECT l FROM LcComisiones l WHERE l.frecuencia = :frecuencia")
    , @NamedQuery(name = "LcComisiones.findByDiaPago", query = "SELECT l FROM LcComisiones l WHERE l.diaPago = :diaPago")
    , @NamedQuery(name = "LcComisiones.findByCodigoTasa", query = "SELECT l FROM LcComisiones l WHERE l.lcComisionesPK.codigoTasa = :codigoTasa")
    , @NamedQuery(name = "LcComisiones.findByTasaBase", query = "SELECT l FROM LcComisiones l WHERE l.tasaBase = :tasaBase")
    , @NamedQuery(name = "LcComisiones.findByRelacionMatematica", query = "SELECT l FROM LcComisiones l WHERE l.relacionMatematica = :relacionMatematica")
    , @NamedQuery(name = "LcComisiones.findBySpread", query = "SELECT l FROM LcComisiones l WHERE l.spread = :spread")
    , @NamedQuery(name = "LcComisiones.findByTasaComision", query = "SELECT l FROM LcComisiones l WHERE l.tasaComision = :tasaComision")
    , @NamedQuery(name = "LcComisiones.findByComisionVencida", query = "SELECT l FROM LcComisiones l WHERE l.comisionVencida = :comisionVencida")
    , @NamedQuery(name = "LcComisiones.findByTipoActivacion", query = "SELECT l FROM LcComisiones l WHERE l.tipoActivacion = :tipoActivacion")
    , @NamedQuery(name = "LcComisiones.findByActivado", query = "SELECT l FROM LcComisiones l WHERE l.activado = :activado")
    , @NamedQuery(name = "LcComisiones.findByNumeroCuotas", query = "SELECT l FROM LcComisiones l WHERE l.numeroCuotas = :numeroCuotas")
    , @NamedQuery(name = "LcComisiones.findByCuotasCreadas", query = "SELECT l FROM LcComisiones l WHERE l.cuotasCreadas = :cuotasCreadas")
    , @NamedQuery(name = "LcComisiones.findByCuotasPagadas", query = "SELECT l FROM LcComisiones l WHERE l.cuotasPagadas = :cuotasPagadas")
    , @NamedQuery(name = "LcComisiones.findByCuotasVencidas", query = "SELECT l FROM LcComisiones l WHERE l.cuotasVencidas = :cuotasVencidas")
    , @NamedQuery(name = "LcComisiones.findByFechaInicio", query = "SELECT l FROM LcComisiones l WHERE l.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "LcComisiones.findByFechaPrimerPago", query = "SELECT l FROM LcComisiones l WHERE l.fechaPrimerPago = :fechaPrimerPago")
    , @NamedQuery(name = "LcComisiones.findByFechaProximoPago", query = "SELECT l FROM LcComisiones l WHERE l.fechaProximoPago = :fechaProximoPago")
    , @NamedQuery(name = "LcComisiones.findByFechaDebeDesde", query = "SELECT l FROM LcComisiones l WHERE l.fechaDebeDesde = :fechaDebeDesde")
    , @NamedQuery(name = "LcComisiones.findByFechaUltimoPago", query = "SELECT l FROM LcComisiones l WHERE l.fechaUltimoPago = :fechaUltimoPago")
    , @NamedQuery(name = "LcComisiones.findByObservacion", query = "SELECT l FROM LcComisiones l WHERE l.observacion = :observacion")
    , @NamedQuery(name = "LcComisiones.findByFechaAdicion", query = "SELECT l FROM LcComisiones l WHERE l.fechaAdicion = :fechaAdicion")
    , @NamedQuery(name = "LcComisiones.findByAdicionadoPor", query = "SELECT l FROM LcComisiones l WHERE l.adicionadoPor = :adicionadoPor")
    , @NamedQuery(name = "LcComisiones.findByFechaModificacion", query = "SELECT l FROM LcComisiones l WHERE l.fechaModificacion = :fechaModificacion")
    , @NamedQuery(name = "LcComisiones.findByModificadoPor", query = "SELECT l FROM LcComisiones l WHERE l.modificadoPor = :modificadoPor")})
public class LcComisiones implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LcComisionesPK lcComisionesPK;
    @Size(max = 3)
    @Column(name = "CODIGO_APLICACION")
    private String codigoAplicacion;
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
    @Column(name = "TIPO_FRECUENCIA")
    private Short tipoFrecuencia;
    @Column(name = "FRECUENCIA")
    private Short frecuencia;
    @Column(name = "DIA_PAGO")
    private Short diaPago;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TASA_BASE")
    private BigDecimal tasaBase;
    @Size(max = 1)
    @Column(name = "RELACION_MATEMATICA")
    private String relacionMatematica;
    @Column(name = "SPREAD")
    private BigDecimal spread;
    @Column(name = "TASA_COMISION")
    private BigDecimal tasaComision;
    @Size(max = 1)
    @Column(name = "COMISION_VENCIDA")
    private String comisionVencida;
    @Size(max = 1)
    @Column(name = "TIPO_ACTIVACION")
    private String tipoActivacion;
    @Size(max = 1)
    @Column(name = "ACTIVADO")
    private String activado;
    @Column(name = "NUMERO_CUOTAS")
    private Integer numeroCuotas;
    @Column(name = "CUOTAS_CREADAS")
    private Integer cuotasCreadas;
    @Column(name = "CUOTAS_PAGADAS")
    private Integer cuotasPagadas;
    @Column(name = "CUOTAS_VENCIDAS")
    private Integer cuotasVencidas;
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "FECHA_PRIMER_PAGO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPrimerPago;
    @Column(name = "FECHA_PROXIMO_PAGO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaProximoPago;
    @Column(name = "FECHA_DEBE_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDebeDesde;
    @Column(name = "FECHA_ULTIMO_PAGO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltimoPago;
    @Size(max = 2000)
    @Column(name = "OBSERVACION")
    private String observacion;
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

    public LcComisiones() {
    }

    public LcComisiones(LcComisionesPK lcComisionesPK) {
        this.lcComisionesPK = lcComisionesPK;
    }

    public LcComisiones(short codigoEmpresa, short codigoAgencia, short codigoSubAplicacion, int numeroLineaCredito, short codigoTasa) {
        this.lcComisionesPK = new LcComisionesPK(codigoEmpresa, codigoAgencia, codigoSubAplicacion, numeroLineaCredito, codigoTasa);
    }

    public LcComisionesPK getLcComisionesPK() {
        return lcComisionesPK;
    }

    public void setLcComisionesPK(LcComisionesPK lcComisionesPK) {
        this.lcComisionesPK = lcComisionesPK;
    }

    public String getCodigoAplicacion() {
        return codigoAplicacion;
    }

    public void setCodigoAplicacion(String codigoAplicacion) {
        this.codigoAplicacion = codigoAplicacion;
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

    public Short getTipoFrecuencia() {
        return tipoFrecuencia;
    }

    public void setTipoFrecuencia(Short tipoFrecuencia) {
        this.tipoFrecuencia = tipoFrecuencia;
    }

    public Short getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(Short frecuencia) {
        this.frecuencia = frecuencia;
    }

    public Short getDiaPago() {
        return diaPago;
    }

    public void setDiaPago(Short diaPago) {
        this.diaPago = diaPago;
    }

    public BigDecimal getTasaBase() {
        return tasaBase;
    }

    public void setTasaBase(BigDecimal tasaBase) {
        this.tasaBase = tasaBase;
    }

    public String getRelacionMatematica() {
        return relacionMatematica;
    }

    public void setRelacionMatematica(String relacionMatematica) {
        this.relacionMatematica = relacionMatematica;
    }

    public BigDecimal getSpread() {
        return spread;
    }

    public void setSpread(BigDecimal spread) {
        this.spread = spread;
    }

    public BigDecimal getTasaComision() {
        return tasaComision;
    }

    public void setTasaComision(BigDecimal tasaComision) {
        this.tasaComision = tasaComision;
    }

    public String getComisionVencida() {
        return comisionVencida;
    }

    public void setComisionVencida(String comisionVencida) {
        this.comisionVencida = comisionVencida;
    }

    public String getTipoActivacion() {
        return tipoActivacion;
    }

    public void setTipoActivacion(String tipoActivacion) {
        this.tipoActivacion = tipoActivacion;
    }

    public String getActivado() {
        return activado;
    }

    public void setActivado(String activado) {
        this.activado = activado;
    }

    public Integer getNumeroCuotas() {
        return numeroCuotas;
    }

    public void setNumeroCuotas(Integer numeroCuotas) {
        this.numeroCuotas = numeroCuotas;
    }

    public Integer getCuotasCreadas() {
        return cuotasCreadas;
    }

    public void setCuotasCreadas(Integer cuotasCreadas) {
        this.cuotasCreadas = cuotasCreadas;
    }

    public Integer getCuotasPagadas() {
        return cuotasPagadas;
    }

    public void setCuotasPagadas(Integer cuotasPagadas) {
        this.cuotasPagadas = cuotasPagadas;
    }

    public Integer getCuotasVencidas() {
        return cuotasVencidas;
    }

    public void setCuotasVencidas(Integer cuotasVencidas) {
        this.cuotasVencidas = cuotasVencidas;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaPrimerPago() {
        return fechaPrimerPago;
    }

    public void setFechaPrimerPago(Date fechaPrimerPago) {
        this.fechaPrimerPago = fechaPrimerPago;
    }

    public Date getFechaProximoPago() {
        return fechaProximoPago;
    }

    public void setFechaProximoPago(Date fechaProximoPago) {
        this.fechaProximoPago = fechaProximoPago;
    }

    public Date getFechaDebeDesde() {
        return fechaDebeDesde;
    }

    public void setFechaDebeDesde(Date fechaDebeDesde) {
        this.fechaDebeDesde = fechaDebeDesde;
    }

    public Date getFechaUltimoPago() {
        return fechaUltimoPago;
    }

    public void setFechaUltimoPago(Date fechaUltimoPago) {
        this.fechaUltimoPago = fechaUltimoPago;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
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
        hash += (lcComisionesPK != null ? lcComisionesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LcComisiones)) {
            return false;
        }
        LcComisiones other = (LcComisiones) object;
        if ((this.lcComisionesPK == null && other.lcComisionesPK != null) || (this.lcComisionesPK != null && !this.lcComisionesPK.equals(other.lcComisionesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.LcComisiones[ lcComisionesPK=" + lcComisionesPK + " ]";
    }
    
}
