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
@Table(name = "MG_DOMICILIACIONES_RECIBIDAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MgDomiciliacionesRecibidas.findAll", query = "SELECT m FROM MgDomiciliacionesRecibidas m")
    , @NamedQuery(name = "MgDomiciliacionesRecibidas.findByIbrn", query = "SELECT m FROM MgDomiciliacionesRecibidas m WHERE m.mgDomiciliacionesRecibidasPK.ibrn = :ibrn")
    , @NamedQuery(name = "MgDomiciliacionesRecibidas.findByTipoOperacion", query = "SELECT m FROM MgDomiciliacionesRecibidas m WHERE m.tipoOperacion = :tipoOperacion")
    , @NamedQuery(name = "MgDomiciliacionesRecibidas.findByReferenciaInterna", query = "SELECT m FROM MgDomiciliacionesRecibidas m WHERE m.referenciaInterna = :referenciaInterna")
    , @NamedQuery(name = "MgDomiciliacionesRecibidas.findBySubtipoDomiciliacion", query = "SELECT m FROM MgDomiciliacionesRecibidas m WHERE m.subtipoDomiciliacion = :subtipoDomiciliacion")
    , @NamedQuery(name = "MgDomiciliacionesRecibidas.findByCodigoEmpresa", query = "SELECT m FROM MgDomiciliacionesRecibidas m WHERE m.codigoEmpresa = :codigoEmpresa")
    , @NamedQuery(name = "MgDomiciliacionesRecibidas.findByCodigoAgencia", query = "SELECT m FROM MgDomiciliacionesRecibidas m WHERE m.codigoAgencia = :codigoAgencia")
    , @NamedQuery(name = "MgDomiciliacionesRecibidas.findByCodigoAplicacion", query = "SELECT m FROM MgDomiciliacionesRecibidas m WHERE m.codigoAplicacion = :codigoAplicacion")
    , @NamedQuery(name = "MgDomiciliacionesRecibidas.findByCodigoSubaplicacion", query = "SELECT m FROM MgDomiciliacionesRecibidas m WHERE m.codigoSubaplicacion = :codigoSubaplicacion")
    , @NamedQuery(name = "MgDomiciliacionesRecibidas.findByNumeroCuenta", query = "SELECT m FROM MgDomiciliacionesRecibidas m WHERE m.numeroCuenta = :numeroCuenta")
    , @NamedQuery(name = "MgDomiciliacionesRecibidas.findByCuentaOrdenante", query = "SELECT m FROM MgDomiciliacionesRecibidas m WHERE m.cuentaOrdenante = :cuentaOrdenante")
    , @NamedQuery(name = "MgDomiciliacionesRecibidas.findByCuentaPagador", query = "SELECT m FROM MgDomiciliacionesRecibidas m WHERE m.cuentaPagador = :cuentaPagador")
    , @NamedQuery(name = "MgDomiciliacionesRecibidas.findByMonto", query = "SELECT m FROM MgDomiciliacionesRecibidas m WHERE m.monto = :monto")
    , @NamedQuery(name = "MgDomiciliacionesRecibidas.findByReferenciaOrdenante", query = "SELECT m FROM MgDomiciliacionesRecibidas m WHERE m.referenciaOrdenante = :referenciaOrdenante")
    , @NamedQuery(name = "MgDomiciliacionesRecibidas.findByNombreOrdenante", query = "SELECT m FROM MgDomiciliacionesRecibidas m WHERE m.nombreOrdenante = :nombreOrdenante")
    , @NamedQuery(name = "MgDomiciliacionesRecibidas.findByTipoPagador", query = "SELECT m FROM MgDomiciliacionesRecibidas m WHERE m.tipoPagador = :tipoPagador")
    , @NamedQuery(name = "MgDomiciliacionesRecibidas.findByIdPagador", query = "SELECT m FROM MgDomiciliacionesRecibidas m WHERE m.idPagador = :idPagador")
    , @NamedQuery(name = "MgDomiciliacionesRecibidas.findByNombrePagador", query = "SELECT m FROM MgDomiciliacionesRecibidas m WHERE m.nombrePagador = :nombrePagador")
    , @NamedQuery(name = "MgDomiciliacionesRecibidas.findByReferenciaContrato", query = "SELECT m FROM MgDomiciliacionesRecibidas m WHERE m.referenciaContrato = :referenciaContrato")
    , @NamedQuery(name = "MgDomiciliacionesRecibidas.findByNumeroFactura", query = "SELECT m FROM MgDomiciliacionesRecibidas m WHERE m.numeroFactura = :numeroFactura")
    , @NamedQuery(name = "MgDomiciliacionesRecibidas.findByConcepto", query = "SELECT m FROM MgDomiciliacionesRecibidas m WHERE m.concepto = :concepto")
    , @NamedQuery(name = "MgDomiciliacionesRecibidas.findByFechaFactura", query = "SELECT m FROM MgDomiciliacionesRecibidas m WHERE m.fechaFactura = :fechaFactura")
    , @NamedQuery(name = "MgDomiciliacionesRecibidas.findByFechaVencimiento", query = "SELECT m FROM MgDomiciliacionesRecibidas m WHERE m.fechaVencimiento = :fechaVencimiento")
    , @NamedQuery(name = "MgDomiciliacionesRecibidas.findByFechaCreacion", query = "SELECT m FROM MgDomiciliacionesRecibidas m WHERE m.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "MgDomiciliacionesRecibidas.findByNumeroLote", query = "SELECT m FROM MgDomiciliacionesRecibidas m WHERE m.numeroLote = :numeroLote")
    , @NamedQuery(name = "MgDomiciliacionesRecibidas.findByEspacios", query = "SELECT m FROM MgDomiciliacionesRecibidas m WHERE m.espacios = :espacios")
    , @NamedQuery(name = "MgDomiciliacionesRecibidas.findByAdicionadoPor", query = "SELECT m FROM MgDomiciliacionesRecibidas m WHERE m.adicionadoPor = :adicionadoPor")
    , @NamedQuery(name = "MgDomiciliacionesRecibidas.findByFechaAdicion", query = "SELECT m FROM MgDomiciliacionesRecibidas m WHERE m.fechaAdicion = :fechaAdicion")
    , @NamedQuery(name = "MgDomiciliacionesRecibidas.findByFechaValida", query = "SELECT m FROM MgDomiciliacionesRecibidas m WHERE m.mgDomiciliacionesRecibidasPK.fechaValida = :fechaValida")
    , @NamedQuery(name = "MgDomiciliacionesRecibidas.findByModificadoPor", query = "SELECT m FROM MgDomiciliacionesRecibidas m WHERE m.modificadoPor = :modificadoPor")
    , @NamedQuery(name = "MgDomiciliacionesRecibidas.findByFechaModificacion", query = "SELECT m FROM MgDomiciliacionesRecibidas m WHERE m.fechaModificacion = :fechaModificacion")
    , @NamedQuery(name = "MgDomiciliacionesRecibidas.findByAplicado", query = "SELECT m FROM MgDomiciliacionesRecibidas m WHERE m.aplicado = :aplicado")
    , @NamedQuery(name = "MgDomiciliacionesRecibidas.findByEnviado", query = "SELECT m FROM MgDomiciliacionesRecibidas m WHERE m.enviado = :enviado")
    , @NamedQuery(name = "MgDomiciliacionesRecibidas.findByCodigoError", query = "SELECT m FROM MgDomiciliacionesRecibidas m WHERE m.codigoError = :codigoError")
    , @NamedQuery(name = "MgDomiciliacionesRecibidas.findByCodigoDevolucion", query = "SELECT m FROM MgDomiciliacionesRecibidas m WHERE m.codigoDevolucion = :codigoDevolucion")
    , @NamedQuery(name = "MgDomiciliacionesRecibidas.findByCodigoBancoOrigen", query = "SELECT m FROM MgDomiciliacionesRecibidas m WHERE m.codigoBancoOrigen = :codigoBancoOrigen")})
public class MgDomiciliacionesRecibidas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MgDomiciliacionesRecibidasPK mgDomiciliacionesRecibidasPK;
    @Column(name = "TIPO_OPERACION")
    private Short tipoOperacion;
    @Column(name = "REFERENCIA_INTERNA")
    private Integer referenciaInterna;
    @Column(name = "SUBTIPO_DOMICILIACION")
    private Short subtipoDomiciliacion;
    @Column(name = "CODIGO_EMPRESA")
    private Short codigoEmpresa;
    @Column(name = "CODIGO_AGENCIA")
    private Short codigoAgencia;
    @Size(max = 3)
    @Column(name = "CODIGO_APLICACION")
    private String codigoAplicacion;
    @Column(name = "CODIGO_SUBAPLICACION")
    private Short codigoSubaplicacion;
    @Column(name = "NUMERO_CUENTA")
    private Long numeroCuenta;
    @Size(max = 20)
    @Column(name = "CUENTA_ORDENANTE")
    private String cuentaOrdenante;
    @Size(max = 20)
    @Column(name = "CUENTA_PAGADOR")
    private String cuentaPagador;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MONTO")
    private BigDecimal monto;
    @Size(max = 12)
    @Column(name = "REFERENCIA_ORDENANTE")
    private String referenciaOrdenante;
    @Size(max = 35)
    @Column(name = "NOMBRE_ORDENANTE")
    private String nombreOrdenante;
    @Size(max = 1)
    @Column(name = "TIPO_PAGADOR")
    private String tipoPagador;
    @Size(max = 12)
    @Column(name = "ID_PAGADOR")
    private String idPagador;
    @Size(max = 35)
    @Column(name = "NOMBRE_PAGADOR")
    private String nombrePagador;
    @Size(max = 30)
    @Column(name = "REFERENCIA_CONTRATO")
    private String referenciaContrato;
    @Size(max = 30)
    @Column(name = "NUMERO_FACTURA")
    private String numeroFactura;
    @Size(max = 80)
    @Column(name = "CONCEPTO")
    private String concepto;
    @Column(name = "FECHA_FACTURA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFactura;
    @Column(name = "FECHA_VENCIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVencimiento;
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "NUMERO_LOTE")
    private Short numeroLote;
    @Size(max = 79)
    @Column(name = "ESPACIOS")
    private String espacios;
    @Size(max = 11)
    @Column(name = "ADICIONADO_POR")
    private String adicionadoPor;
    @Column(name = "FECHA_ADICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAdicion;
    @Size(max = 10)
    @Column(name = "MODIFICADO_POR")
    private String modificadoPor;
    @Column(name = "FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Size(max = 1)
    @Column(name = "APLICADO")
    private String aplicado;
    @Column(name = "ENVIADO")
    private Character enviado;
    @Size(max = 200)
    @Column(name = "CODIGO_ERROR")
    private String codigoError;
    @Column(name = "CODIGO_DEVOLUCION")
    private Short codigoDevolucion;
    @Column(name = "CODIGO_BANCO_ORIGEN")
    private Integer codigoBancoOrigen;

    public MgDomiciliacionesRecibidas() {
    }

    public MgDomiciliacionesRecibidas(MgDomiciliacionesRecibidasPK mgDomiciliacionesRecibidasPK) {
        this.mgDomiciliacionesRecibidasPK = mgDomiciliacionesRecibidasPK;
    }

    public MgDomiciliacionesRecibidas(String ibrn, Date fechaValida) {
        this.mgDomiciliacionesRecibidasPK = new MgDomiciliacionesRecibidasPK(ibrn, fechaValida);
    }

    public MgDomiciliacionesRecibidasPK getMgDomiciliacionesRecibidasPK() {
        return mgDomiciliacionesRecibidasPK;
    }

    public void setMgDomiciliacionesRecibidasPK(MgDomiciliacionesRecibidasPK mgDomiciliacionesRecibidasPK) {
        this.mgDomiciliacionesRecibidasPK = mgDomiciliacionesRecibidasPK;
    }

    public Short getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(Short tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public Integer getReferenciaInterna() {
        return referenciaInterna;
    }

    public void setReferenciaInterna(Integer referenciaInterna) {
        this.referenciaInterna = referenciaInterna;
    }

    public Short getSubtipoDomiciliacion() {
        return subtipoDomiciliacion;
    }

    public void setSubtipoDomiciliacion(Short subtipoDomiciliacion) {
        this.subtipoDomiciliacion = subtipoDomiciliacion;
    }

    public Short getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public void setCodigoEmpresa(Short codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    public Short getCodigoAgencia() {
        return codigoAgencia;
    }

    public void setCodigoAgencia(Short codigoAgencia) {
        this.codigoAgencia = codigoAgencia;
    }

    public String getCodigoAplicacion() {
        return codigoAplicacion;
    }

    public void setCodigoAplicacion(String codigoAplicacion) {
        this.codigoAplicacion = codigoAplicacion;
    }

    public Short getCodigoSubaplicacion() {
        return codigoSubaplicacion;
    }

    public void setCodigoSubaplicacion(Short codigoSubaplicacion) {
        this.codigoSubaplicacion = codigoSubaplicacion;
    }

    public Long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getCuentaOrdenante() {
        return cuentaOrdenante;
    }

    public void setCuentaOrdenante(String cuentaOrdenante) {
        this.cuentaOrdenante = cuentaOrdenante;
    }

    public String getCuentaPagador() {
        return cuentaPagador;
    }

    public void setCuentaPagador(String cuentaPagador) {
        this.cuentaPagador = cuentaPagador;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getReferenciaOrdenante() {
        return referenciaOrdenante;
    }

    public void setReferenciaOrdenante(String referenciaOrdenante) {
        this.referenciaOrdenante = referenciaOrdenante;
    }

    public String getNombreOrdenante() {
        return nombreOrdenante;
    }

    public void setNombreOrdenante(String nombreOrdenante) {
        this.nombreOrdenante = nombreOrdenante;
    }

    public String getTipoPagador() {
        return tipoPagador;
    }

    public void setTipoPagador(String tipoPagador) {
        this.tipoPagador = tipoPagador;
    }

    public String getIdPagador() {
        return idPagador;
    }

    public void setIdPagador(String idPagador) {
        this.idPagador = idPagador;
    }

    public String getNombrePagador() {
        return nombrePagador;
    }

    public void setNombrePagador(String nombrePagador) {
        this.nombrePagador = nombrePagador;
    }

    public String getReferenciaContrato() {
        return referenciaContrato;
    }

    public void setReferenciaContrato(String referenciaContrato) {
        this.referenciaContrato = referenciaContrato;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Short getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(Short numeroLote) {
        this.numeroLote = numeroLote;
    }

    public String getEspacios() {
        return espacios;
    }

    public void setEspacios(String espacios) {
        this.espacios = espacios;
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

    public String getAplicado() {
        return aplicado;
    }

    public void setAplicado(String aplicado) {
        this.aplicado = aplicado;
    }

    public Character getEnviado() {
        return enviado;
    }

    public void setEnviado(Character enviado) {
        this.enviado = enviado;
    }

    public String getCodigoError() {
        return codigoError;
    }

    public void setCodigoError(String codigoError) {
        this.codigoError = codigoError;
    }

    public Short getCodigoDevolucion() {
        return codigoDevolucion;
    }

    public void setCodigoDevolucion(Short codigoDevolucion) {
        this.codigoDevolucion = codigoDevolucion;
    }

    public Integer getCodigoBancoOrigen() {
        return codigoBancoOrigen;
    }

    public void setCodigoBancoOrigen(Integer codigoBancoOrigen) {
        this.codigoBancoOrigen = codigoBancoOrigen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mgDomiciliacionesRecibidasPK != null ? mgDomiciliacionesRecibidasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MgDomiciliacionesRecibidas)) {
            return false;
        }
        MgDomiciliacionesRecibidas other = (MgDomiciliacionesRecibidas) object;
        if ((this.mgDomiciliacionesRecibidasPK == null && other.mgDomiciliacionesRecibidasPK != null) || (this.mgDomiciliacionesRecibidasPK != null && !this.mgDomiciliacionesRecibidasPK.equals(other.mgDomiciliacionesRecibidasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.MgDomiciliacionesRecibidas[ mgDomiciliacionesRecibidasPK=" + mgDomiciliacionesRecibidasPK + " ]";
    }
    
}
