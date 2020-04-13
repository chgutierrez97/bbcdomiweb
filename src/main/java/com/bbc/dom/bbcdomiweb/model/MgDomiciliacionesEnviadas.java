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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Christian Gutierrez
 */
@Entity
@Table(name = "MG_DOMICILIACIONES_ENVIADAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MgDomiciliacionesEnviadas.findAll", query = "SELECT m FROM MgDomiciliacionesEnviadas m")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByClaveOrdenante", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.mgDomiciliacionesEnviadasPK.claveOrdenante = :claveOrdenante")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByCodigoOrdenante", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.mgDomiciliacionesEnviadasPK.codigoOrdenante = :codigoOrdenante")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByRegistroOrdenante", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.registroOrdenante = :registroOrdenante")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByTipoOperacion", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.tipoOperacion = :tipoOperacion")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByReferenciaInterna", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.referenciaInterna = :referenciaInterna")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findBySubtipoDomiciliacion", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.subtipoDomiciliacion = :subtipoDomiciliacion")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByCodigoBancoDestino", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.codigoBancoDestino = :codigoBancoDestino")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByCodigoEmpresa", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.codigoEmpresa = :codigoEmpresa")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByCodigoAgencia", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.codigoAgencia = :codigoAgencia")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByCodigoAplicacion", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.codigoAplicacion = :codigoAplicacion")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByCodigoSubaplicacion", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.codigoSubaplicacion = :codigoSubaplicacion")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByNumeroCuenta", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.numeroCuenta = :numeroCuenta")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByCuentaOrdenante", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.cuentaOrdenante = :cuentaOrdenante")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByCuentaPagador", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.cuentaPagador = :cuentaPagador")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByMonto", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.monto = :monto")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByReferenciaOrdenante", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.referenciaOrdenante = :referenciaOrdenante")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByNombreOrdenante", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.nombreOrdenante = :nombreOrdenante")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByTipoPagador", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.tipoPagador = :tipoPagador")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByIdPagador", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.idPagador = :idPagador")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByNombrePagador", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.nombrePagador = :nombrePagador")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByReferenciaContrato", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.referenciaContrato = :referenciaContrato")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByNumeroFactura", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.numeroFactura = :numeroFactura")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByConcepto", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.concepto = :concepto")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByFechaFactura", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.fechaFactura = :fechaFactura")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByFechaCreacion", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByNumeroLote", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.numeroLote = :numeroLote")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByEspacios", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.espacios = :espacios")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByEnviadoUap", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.enviadoUap = :enviadoUap")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByRecidioUap", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.recidioUap = :recidioUap")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByEnviadoOrdenanteResp", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.enviadoOrdenanteResp = :enviadoOrdenanteResp")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByAplicadoDebito", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.aplicadoDebito = :aplicadoDebito")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByAplicadoPrestamo", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.aplicadoPrestamo = :aplicadoPrestamo")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByCodigoError", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.codigoError = :codigoError")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByCodigoDevolucion", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.codigoDevolucion = :codigoDevolucion")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByAdicionadoPor", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.adicionadoPor = :adicionadoPor")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByFechaValida", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.fechaValida = :fechaValida")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByFechaEncabezado", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.fechaEncabezado = :fechaEncabezado")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByFechaRecepcionOrd", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.fechaRecepcionOrd = :fechaRecepcionOrd")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByFechaEnvioUap", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.fechaEnvioUap = :fechaEnvioUap")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByFechaRespuestaUap", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.fechaRespuestaUap = :fechaRespuestaUap")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByFechaEnvioOrdenante", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.fechaEnvioOrdenante = :fechaEnvioOrdenante")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByFechaVencimientoP", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.fechaVencimientoP = :fechaVencimientoP")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByAplicadoUap", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.aplicadoUap = :aplicadoUap")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByCrAplicadoMpOrdenante", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.crAplicadoMpOrdenante = :crAplicadoMpOrdenante")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByModificadoPor", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.modificadoPor = :modificadoPor")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByFechaModificacion", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.fechaModificacion = :fechaModificacion")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByCanalAfiliacion", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.canalAfiliacion = :canalAfiliacion")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByReferenciaEnviadaUap", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.referenciaEnviadaUap = :referenciaEnviadaUap")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByFechaAdicion", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.fechaAdicion = :fechaAdicion")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByCobroExitoso", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.cobroExitoso = :cobroExitoso")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByNombreArchivo", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.nombreArchivo = :nombreArchivo")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByCopiadoOrdenante", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.copiadoOrdenante = :copiadoOrdenante")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByArchivoRespuesta", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.archivoRespuesta = :archivoRespuesta")
    , @NamedQuery(name = "MgDomiciliacionesEnviadas.findByEnviadoOrdenante", query = "SELECT m FROM MgDomiciliacionesEnviadas m WHERE m.enviadoOrdenante = :enviadoOrdenante")})
public class MgDomiciliacionesEnviadas implements Serializable {

    @Column(name = "SECUENCIA")
    private Integer secuencia;
    @Column(name = "SECUENCIA_LOTE")
    private Long secuenciaLote;
    @Column(name = "GRUPO")
    private Long grupo;
    @Column(name = "ELEMENTO_GRUPO")
    private Long elementoGrupo;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MgDomiciliacionesEnviadasPK mgDomiciliacionesEnviadasPK;
    @Column(name = "REGISTRO_ORDENANTE")
    private String registroOrdenante;
    @Column(name = "TIPO_OPERACION")
    private Short tipoOperacion;
    @Column(name = "REFERENCIA_INTERNA")
    private Integer referenciaInterna;
    @Column(name = "SUBTIPO_DOMICILIACION")
    private Short subtipoDomiciliacion;
    @Column(name = "CODIGO_BANCO_DESTINO")
    private Integer codigoBancoDestino;
    @Column(name = "CODIGO_EMPRESA")
    private Short codigoEmpresa;
    @Column(name = "CODIGO_AGENCIA")
    private Short codigoAgencia;
    @Column(name = "CODIGO_APLICACION")
    private String codigoAplicacion;
    @Column(name = "CODIGO_SUBAPLICACION")
    private Short codigoSubaplicacion;
    @Column(name = "NUMERO_CUENTA")
    private Long numeroCuenta;
    @Column(name = "CUENTA_ORDENANTE")
    private String cuentaOrdenante;
    @Column(name = "CUENTA_PAGADOR")
    private String cuentaPagador;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MONTO")
    private BigDecimal monto;
    @Column(name = "REFERENCIA_ORDENANTE")
    private String referenciaOrdenante;
    @Column(name = "NOMBRE_ORDENANTE")
    private String nombreOrdenante;
    @Column(name = "TIPO_PAGADOR")
    private String tipoPagador;
    @Column(name = "ID_PAGADOR")
    private String idPagador;
    @Column(name = "NOMBRE_PAGADOR")
    private String nombrePagador;
    @Column(name = "REFERENCIA_CONTRATO")
    private String referenciaContrato;
    @Column(name = "NUMERO_FACTURA")
    private String numeroFactura;
    @Column(name = "CONCEPTO")
    private String concepto;
    @Column(name = "FECHA_FACTURA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFactura;
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "NUMERO_LOTE")
    private Short numeroLote;
    @Column(name = "ESPACIOS")
    private String espacios;
    @Column(name = "ENVIADO_UAP")
    private String enviadoUap;
    @Column(name = "RECIDIO_UAP")
    private String recidioUap;
    @Column(name = "ENVIADO_ORDENANTE_RESP")
    private String enviadoOrdenanteResp;
    @Column(name = "APLICADO_DEBITO")
    private String aplicadoDebito;
    @Column(name = "APLICADO_PRESTAMO")
    private String aplicadoPrestamo;
    @Column(name = "CODIGO_ERROR")
    private String codigoError;
    @Column(name = "CODIGO_DEVOLUCION")
    private Short codigoDevolucion;
    @Column(name = "ADICIONADO_POR")
    private String adicionadoPor;
    @Column(name = "FECHA_VALIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaValida;
    @Column(name = "FECHA_ENCABEZADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEncabezado;
    @Column(name = "FECHA_RECEPCION_ORD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRecepcionOrd;
    @Column(name = "FECHA_ENVIO_UAP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEnvioUap;
    @Column(name = "FECHA_RESPUESTA_UAP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRespuestaUap;
    @Column(name = "FECHA_ENVIO_ORDENANTE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEnvioOrdenante;
    @Column(name = "FECHA_VENCIMIENTO_P")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVencimientoP;
    @Column(name = "APLICADO_UAP")
    private String aplicadoUap;
    @Column(name = "CR_APLICADO_MP_ORDENANTE")
    private String crAplicadoMpOrdenante;
    @Column(name = "MODIFICADO_POR")
    private String modificadoPor;
    @Column(name = "FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Column(name = "CANAL_AFILIACION")
    private String canalAfiliacion;
    @Column(name = "REFERENCIA_ENVIADA_UAP")
    private String referenciaEnviadaUap;
    @Column(name = "FECHA_ADICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAdicion;
    @Column(name = "COBRO_EXITOSO")
    private String cobroExitoso;
    @Column(name = "NOMBRE_ARCHIVO")
    private String nombreArchivo;
    @Column(name = "COPIADO_ORDENANTE")
    private String copiadoOrdenante;
    @Column(name = "ARCHIVO_RESPUESTA")
    private String archivoRespuesta;
    @Column(name = "ENVIADO_ORDENANTE")
    private String enviadoOrdenante;

    public MgDomiciliacionesEnviadas() {
    }

    public MgDomiciliacionesEnviadas(MgDomiciliacionesEnviadasPK mgDomiciliacionesEnviadasPK) {
        this.mgDomiciliacionesEnviadasPK = mgDomiciliacionesEnviadasPK;
    }

    public MgDomiciliacionesEnviadas(String claveOrdenante, String codigoOrdenante) {
        this.mgDomiciliacionesEnviadasPK = new MgDomiciliacionesEnviadasPK(claveOrdenante, codigoOrdenante);
    }

    public MgDomiciliacionesEnviadasPK getMgDomiciliacionesEnviadasPK() {
        return mgDomiciliacionesEnviadasPK;
    }

    public void setMgDomiciliacionesEnviadasPK(MgDomiciliacionesEnviadasPK mgDomiciliacionesEnviadasPK) {
        this.mgDomiciliacionesEnviadasPK = mgDomiciliacionesEnviadasPK;
    }

    public String getRegistroOrdenante() {
        return registroOrdenante;
    }

    public void setRegistroOrdenante(String registroOrdenante) {
        this.registroOrdenante = registroOrdenante;
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

    public Integer getCodigoBancoDestino() {
        return codigoBancoDestino;
    }

    public void setCodigoBancoDestino(Integer codigoBancoDestino) {
        this.codigoBancoDestino = codigoBancoDestino;
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

    public String getEnviadoUap() {
        return enviadoUap;
    }

    public void setEnviadoUap(String enviadoUap) {
        this.enviadoUap = enviadoUap;
    }

    public String getRecidioUap() {
        return recidioUap;
    }

    public void setRecidioUap(String recidioUap) {
        this.recidioUap = recidioUap;
    }

    public String getEnviadoOrdenanteResp() {
        return enviadoOrdenanteResp;
    }

    public void setEnviadoOrdenanteResp(String enviadoOrdenanteResp) {
        this.enviadoOrdenanteResp = enviadoOrdenanteResp;
    }

    public String getAplicadoDebito() {
        return aplicadoDebito;
    }

    public void setAplicadoDebito(String aplicadoDebito) {
        this.aplicadoDebito = aplicadoDebito;
    }

    public String getAplicadoPrestamo() {
        return aplicadoPrestamo;
    }

    public void setAplicadoPrestamo(String aplicadoPrestamo) {
        this.aplicadoPrestamo = aplicadoPrestamo;
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

    public String getAdicionadoPor() {
        return adicionadoPor;
    }

    public void setAdicionadoPor(String adicionadoPor) {
        this.adicionadoPor = adicionadoPor;
    }

    public Date getFechaValida() {
        return fechaValida;
    }

    public void setFechaValida(Date fechaValida) {
        this.fechaValida = fechaValida;
    }

    public Date getFechaEncabezado() {
        return fechaEncabezado;
    }

    public void setFechaEncabezado(Date fechaEncabezado) {
        this.fechaEncabezado = fechaEncabezado;
    }

    public Date getFechaRecepcionOrd() {
        return fechaRecepcionOrd;
    }

    public void setFechaRecepcionOrd(Date fechaRecepcionOrd) {
        this.fechaRecepcionOrd = fechaRecepcionOrd;
    }

    public Date getFechaEnvioUap() {
        return fechaEnvioUap;
    }

    public void setFechaEnvioUap(Date fechaEnvioUap) {
        this.fechaEnvioUap = fechaEnvioUap;
    }

    public Date getFechaRespuestaUap() {
        return fechaRespuestaUap;
    }

    public void setFechaRespuestaUap(Date fechaRespuestaUap) {
        this.fechaRespuestaUap = fechaRespuestaUap;
    }

    public Date getFechaEnvioOrdenante() {
        return fechaEnvioOrdenante;
    }

    public void setFechaEnvioOrdenante(Date fechaEnvioOrdenante) {
        this.fechaEnvioOrdenante = fechaEnvioOrdenante;
    }

    public Date getFechaVencimientoP() {
        return fechaVencimientoP;
    }

    public void setFechaVencimientoP(Date fechaVencimientoP) {
        this.fechaVencimientoP = fechaVencimientoP;
    }

    public String getAplicadoUap() {
        return aplicadoUap;
    }

    public void setAplicadoUap(String aplicadoUap) {
        this.aplicadoUap = aplicadoUap;
    }

    public String getCrAplicadoMpOrdenante() {
        return crAplicadoMpOrdenante;
    }

    public void setCrAplicadoMpOrdenante(String crAplicadoMpOrdenante) {
        this.crAplicadoMpOrdenante = crAplicadoMpOrdenante;
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

    public String getCanalAfiliacion() {
        return canalAfiliacion;
    }

    public void setCanalAfiliacion(String canalAfiliacion) {
        this.canalAfiliacion = canalAfiliacion;
    }

    public String getReferenciaEnviadaUap() {
        return referenciaEnviadaUap;
    }

    public void setReferenciaEnviadaUap(String referenciaEnviadaUap) {
        this.referenciaEnviadaUap = referenciaEnviadaUap;
    }

    public Date getFechaAdicion() {
        return fechaAdicion;
    }

    public void setFechaAdicion(Date fechaAdicion) {
        this.fechaAdicion = fechaAdicion;
    }

    public String getCobroExitoso() {
        return cobroExitoso;
    }

    public void setCobroExitoso(String cobroExitoso) {
        this.cobroExitoso = cobroExitoso;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getCopiadoOrdenante() {
        return copiadoOrdenante;
    }

    public void setCopiadoOrdenante(String copiadoOrdenante) {
        this.copiadoOrdenante = copiadoOrdenante;
    }

    public String getArchivoRespuesta() {
        return archivoRespuesta;
    }

    public void setArchivoRespuesta(String archivoRespuesta) {
        this.archivoRespuesta = archivoRespuesta;
    }

    public String getEnviadoOrdenante() {
        return enviadoOrdenante;
    }

    public void setEnviadoOrdenante(String enviadoOrdenante) {
        this.enviadoOrdenante = enviadoOrdenante;
    }

    /*public Short getSecuenciaLote() {
        return secuenciaLote;
    }

    public void setSecuenciaLote(Short secuenciaLote) {
        this.secuenciaLote = secuenciaLote;
    }*/
  
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mgDomiciliacionesEnviadasPK != null ? mgDomiciliacionesEnviadasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MgDomiciliacionesEnviadas)) {
            return false;
        }
        MgDomiciliacionesEnviadas other = (MgDomiciliacionesEnviadas) object;
        if ((this.mgDomiciliacionesEnviadasPK == null && other.mgDomiciliacionesEnviadasPK != null) || (this.mgDomiciliacionesEnviadasPK != null && !this.mgDomiciliacionesEnviadasPK.equals(other.mgDomiciliacionesEnviadasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication10.MgDomiciliacionesEnviadas[ mgDomiciliacionesEnviadasPK=" + mgDomiciliacionesEnviadasPK + " ]";
    }

    public Integer getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(Integer secuencia) {
        this.secuencia = secuencia;
    }

 /*   public Integer getSecuenciaLote() {
        return secuenciaLote;
    }

    public void setSecuenciaLote(Integer secuenciaLote) {
        this.secuenciaLote = secuenciaLote;
    }*/

    public Long getGrupo() {
        return grupo;
    }

    public void setGrupo(Long grupo) {
        this.grupo = grupo;
    }

    public Long getElementoGrupo() {
        return elementoGrupo;
    }

    public void setElementoGrupo(Long elementoGrupo) {
        this.elementoGrupo = elementoGrupo;
    }
    
}
