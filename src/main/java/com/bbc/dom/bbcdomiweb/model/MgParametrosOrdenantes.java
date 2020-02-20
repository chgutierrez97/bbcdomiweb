/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Christian Gutierrez  MgParametrosOrdenantes
 */
@Entity
@Table(name = "MG_PARAMETROS_ORDENANTES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MgParametrosOrdenantes.findAll", query = "SELECT m FROM MgParametrosOrdenantes m")
    , @NamedQuery(name = "MgParametrosOrdenantes.findByCodigoOrdenante", query = "SELECT m FROM MgParametrosOrdenantes m WHERE m.codigoOrdenante = :codigoOrdenante")
    , @NamedQuery(name = "MgParametrosOrdenantes.findByNombreOrdenante", query = "SELECT m FROM MgParametrosOrdenantes m WHERE m.nombreOrdenante = :nombreOrdenante")
    , @NamedQuery(name = "MgParametrosOrdenantes.findByRifOrdenante", query = "SELECT m FROM MgParametrosOrdenantes m WHERE m.rifOrdenante = :rifOrdenante")
    , @NamedQuery(name = "MgParametrosOrdenantes.findByNumeroCuenta", query = "SELECT m FROM MgParametrosOrdenantes m WHERE m.numeroCuenta = :numeroCuenta")
    , @NamedQuery(name = "MgParametrosOrdenantes.findByTrxCredito", query = "SELECT m FROM MgParametrosOrdenantes m WHERE m.trxCredito = :trxCredito")
    , @NamedQuery(name = "MgParametrosOrdenantes.findByGeneraCreditoAut", query = "SELECT m FROM MgParametrosOrdenantes m WHERE m.generaCreditoAut = :generaCreditoAut")
    , @NamedQuery(name = "MgParametrosOrdenantes.findByModificadoPor", query = "SELECT m FROM MgParametrosOrdenantes m WHERE m.modificadoPor = :modificadoPor")
    , @NamedQuery(name = "MgParametrosOrdenantes.findByAdicionadoPor", query = "SELECT m FROM MgParametrosOrdenantes m WHERE m.adicionadoPor = :adicionadoPor")
    , @NamedQuery(name = "MgParametrosOrdenantes.findByFechaAdicion", query = "SELECT m FROM MgParametrosOrdenantes m WHERE m.fechaAdicion = :fechaAdicion")
    , @NamedQuery(name = "MgParametrosOrdenantes.findByFechaModificacion", query = "SELECT m FROM MgParametrosOrdenantes m WHERE m.fechaModificacion = :fechaModificacion")
    , @NamedQuery(name = "MgParametrosOrdenantes.findByCodigoAplicacion", query = "SELECT m FROM MgParametrosOrdenantes m WHERE m.codigoAplicacion = :codigoAplicacion")
    , @NamedQuery(name = "MgParametrosOrdenantes.findByRutaEmpresa", query = "SELECT m FROM MgParametrosOrdenantes m WHERE m.rutaEmpresa = :rutaEmpresa")
    , @NamedQuery(name = "MgParametrosOrdenantes.findByValidarPrestamo", query = "SELECT m FROM MgParametrosOrdenantes m WHERE m.validarPrestamo = :validarPrestamo")
    , @NamedQuery(name = "MgParametrosOrdenantes.findByCantDiasAfiliacion", query = "SELECT m FROM MgParametrosOrdenantes m WHERE m.cantDiasAfiliacion = :cantDiasAfiliacion")
    , @NamedQuery(name = "MgParametrosOrdenantes.findByAfiliadoTdc", query = "SELECT m FROM MgParametrosOrdenantes m WHERE m.afiliadoTdc = :afiliadoTdc")
    , @NamedQuery(name = "MgParametrosOrdenantes.findByRutaAfiliaciones", query = "SELECT m FROM MgParametrosOrdenantes m WHERE m.rutaAfiliaciones = :rutaAfiliaciones")
    , @NamedQuery(name = "MgParametrosOrdenantes.findByRutaDomiciliaciones", query = "SELECT m FROM MgParametrosOrdenantes m WHERE m.rutaDomiciliaciones = :rutaDomiciliaciones")
    , @NamedQuery(name = "MgParametrosOrdenantes.findByActiva", query = "SELECT m FROM MgParametrosOrdenantes m WHERE m.activa = :activa")
    , @NamedQuery(name = "MgParametrosOrdenantes.findByCodigoAgencia", query = "SELECT m FROM MgParametrosOrdenantes m WHERE m.codigoAgencia = :codigoAgencia")
    , @NamedQuery(name = "MgParametrosOrdenantes.findByCodigoSubaplicacion", query = "SELECT m FROM MgParametrosOrdenantes m WHERE m.codigoSubaplicacion = :codigoSubaplicacion")
    , @NamedQuery(name = "MgParametrosOrdenantes.findByPorcentajeComision", query = "SELECT m FROM MgParametrosOrdenantes m WHERE m.porcentajeComision = :porcentajeComision")
    , @NamedQuery(name = "MgParametrosOrdenantes.findByTrxComision", query = "SELECT m FROM MgParametrosOrdenantes m WHERE m.trxComision = :trxComision")
    , @NamedQuery(name = "MgParametrosOrdenantes.findByPorcentajeDiferido", query = "SELECT m FROM MgParametrosOrdenantes m WHERE m.porcentajeDiferido = :porcentajeDiferido")})
public class MgParametrosOrdenantes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODIGO_ORDENANTE")
    private Integer codigoOrdenante;
    @Column(name = "NOMBRE_ORDENANTE")
    private String nombreOrdenante;
    @Column(name = "RIF_ORDENANTE")
    private String rifOrdenante;
    @Column(name = "NUMERO_CUENTA")
    private String numeroCuenta;
    @Column(name = "TRX_CREDITO")
    private Integer trxCredito;
    @Column(name = "GENERA_CREDITO_AUT")
    private String generaCreditoAut;
    @Column(name = "MODIFICADO_POR")
    private String modificadoPor;
    @Column(name = "ADICIONADO_POR")
    private String adicionadoPor;
    @Column(name = "FECHA_ADICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAdicion;
    @Column(name = "FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Column(name = "CODIGO_APLICACION")
    private String codigoAplicacion;
    @Column(name = "RUTA_EMPRESA")
    private String rutaEmpresa;
    @Column(name = "VALIDAR_PRESTAMO")
    private String validarPrestamo;
    @Column(name = "CANT_DIAS_AFILIACION")
    private Integer cantDiasAfiliacion;
    @Column(name = "AFILIADO_TDC")
    private String afiliadoTdc;
    @Column(name = "RUTA_AFILIACIONES")
    private String rutaAfiliaciones;
    @Column(name = "RUTA_DOMICILIACIONES")
    private String rutaDomiciliaciones;
    @Column(name = "ACTIVA")
    private String activa;
    @Column(name = "CODIGO_AGENCIA")
    private Integer codigoAgencia;
    @Column(name = "CODIGO_SUBAPLICACION")
    private Integer codigoSubaplicacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PORCENTAJE_COMISION")
    private BigDecimal porcentajeComision;
    @Column(name = "TRX_COMISION")
    private Integer trxComision;
    @Column(name = "PORCENTAJE_DIFERIDO")
    private BigDecimal porcentajeDiferido;

    public MgParametrosOrdenantes() {
    }

    public MgParametrosOrdenantes(Integer codigoOrdenante) {
        this.codigoOrdenante = codigoOrdenante;
    }

    public Integer getCodigoOrdenante() {
        return codigoOrdenante;
    }

    public void setCodigoOrdenante(Integer codigoOrdenante) {
        this.codigoOrdenante = codigoOrdenante;
    }

    public String getNombreOrdenante() {
        return nombreOrdenante;
    }

    public void setNombreOrdenante(String nombreOrdenante) {
        this.nombreOrdenante = nombreOrdenante;
    }

    public String getRifOrdenante() {
        return rifOrdenante;
    }

    public void setRifOrdenante(String rifOrdenante) {
        this.rifOrdenante = rifOrdenante;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Integer getTrxCredito() {
        return trxCredito;
    }

    public void setTrxCredito(Integer trxCredito) {
        this.trxCredito = trxCredito;
    }

    public String getGeneraCreditoAut() {
        return generaCreditoAut;
    }

    public void setGeneraCreditoAut(String generaCreditoAut) {
        this.generaCreditoAut = generaCreditoAut;
    }

    public String getModificadoPor() {
        return modificadoPor;
    }

    public void setModificadoPor(String modificadoPor) {
        this.modificadoPor = modificadoPor;
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

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getCodigoAplicacion() {
        return codigoAplicacion;
    }

    public void setCodigoAplicacion(String codigoAplicacion) {
        this.codigoAplicacion = codigoAplicacion;
    }

    public String getRutaEmpresa() {
        return rutaEmpresa;
    }

    public void setRutaEmpresa(String rutaEmpresa) {
        this.rutaEmpresa = rutaEmpresa;
    }

    public String getValidarPrestamo() {
        return validarPrestamo;
    }

    public void setValidarPrestamo(String validarPrestamo) {
        this.validarPrestamo = validarPrestamo;
    }

    public Integer getCantDiasAfiliacion() {
        return cantDiasAfiliacion;
    }

    public void setCantDiasAfiliacion(Integer cantDiasAfiliacion) {
        this.cantDiasAfiliacion = cantDiasAfiliacion;
    }

    public String getAfiliadoTdc() {
        return afiliadoTdc;
    }

    public void setAfiliadoTdc(String afiliadoTdc) {
        this.afiliadoTdc = afiliadoTdc;
    }

    public String getRutaAfiliaciones() {
        return rutaAfiliaciones;
    }

    public void setRutaAfiliaciones(String rutaAfiliaciones) {
        this.rutaAfiliaciones = rutaAfiliaciones;
    }

    public String getRutaDomiciliaciones() {
        return rutaDomiciliaciones;
    }

    public void setRutaDomiciliaciones(String rutaDomiciliaciones) {
        this.rutaDomiciliaciones = rutaDomiciliaciones;
    }

    public String getActiva() {
        return activa;
    }

    public void setActiva(String activa) {
        this.activa = activa;
    }

    public Integer getCodigoAgencia() {
        return codigoAgencia;
    }

    public void setCodigoAgencia(Integer codigoAgencia) {
        this.codigoAgencia = codigoAgencia;
    }

    public Integer getCodigoSubaplicacion() {
        return codigoSubaplicacion;
    }

    public void setCodigoSubaplicacion(Integer codigoSubaplicacion) {
        this.codigoSubaplicacion = codigoSubaplicacion;
    }

    public BigDecimal getPorcentajeComision() {
        return porcentajeComision;
    }

    public void setPorcentajeComision(BigDecimal porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
    }

    public Integer getTrxComision() {
        return trxComision;
    }

    public void setTrxComision(Integer trxComision) {
        this.trxComision = trxComision;
    }

    public BigDecimal getPorcentajeDiferido() {
        return porcentajeDiferido;
    }

    public void setPorcentajeDiferido(BigDecimal porcentajeDiferido) {
        this.porcentajeDiferido = porcentajeDiferido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoOrdenante != null ? codigoOrdenante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MgParametrosOrdenantes)) {
            return false;
        }
        MgParametrosOrdenantes other = (MgParametrosOrdenantes) object;
        if ((this.codigoOrdenante == null && other.codigoOrdenante != null) || (this.codigoOrdenante != null && !this.codigoOrdenante.equals(other.codigoOrdenante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication11.model.MgParametrosOrdenantes[ codigoOrdenante=" + codigoOrdenante + " ]";
    }
    
}
