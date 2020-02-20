/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.model;


import java.io.Serializable;
import java.math.BigInteger;
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
 * @author CGutierrez
 */
@Entity
@Table(name = "MG_AFILIACIONES_PRESENTADAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MgAfiliacionesPresentadas.findAll", query = "SELECT m FROM MgAfiliacionesPresentadas m")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findByCodigoOrdenante", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.mgAfiliacionesPresentadasPK.codigoOrdenante = :codigoOrdenante")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findByClaveOrdenante", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.mgAfiliacionesPresentadasPK.claveOrdenante = :claveOrdenante")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findBySecuenciaLote", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.secuenciaLote = :secuenciaLote")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findBySecuencia", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.secuencia = :secuencia")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findByRegistroOrdenante", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.registroOrdenante = :registroOrdenante")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findByCanalAfiliacion", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.canalAfiliacion = :canalAfiliacion")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findByCodigoEmpresa", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.codigoEmpresa = :codigoEmpresa")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findByReferenciaOrdenante", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.referenciaOrdenante = :referenciaOrdenante")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findByTipoOperacion", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.tipoOperacion = :tipoOperacion")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findByBancoDestino", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.bancoDestino = :bancoDestino")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findByCodigoOperacion", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.codigoOperacion = :codigoOperacion")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findByCodigoResultado", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.codigoResultado = :codigoResultado")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findByTipoPagador", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.tipoPagador = :tipoPagador")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findByIdentificacionPagador", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.identificacionPagador = :identificacionPagador")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findByCuentaPagador", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.cuentaPagador = :cuentaPagador")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findByNombrePagador", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.nombrePagador = :nombrePagador")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findByContrato", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.contrato = :contrato")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findByNumeroMensaje", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.numeroMensaje = :numeroMensaje")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findByEnviado", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.enviado = :enviado")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findByRecibidoUap", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.recibidoUap = :recibidoUap")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findByEnviadoOrdenante", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.enviadoOrdenante = :enviadoOrdenante")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findByFechaValida", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.fechaValida = :fechaValida")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findByFechaEncabezado", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.fechaEncabezado = :fechaEncabezado")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findByFechaRecepcionOrd", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.fechaRecepcionOrd = :fechaRecepcionOrd")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findByFechaEnvioUap", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.fechaEnvioUap = :fechaEnvioUap")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findByFechaRespuestaUap", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.fechaRespuestaUap = :fechaRespuestaUap")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findByFechaEnvioOrdenante", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.fechaEnvioOrdenante = :fechaEnvioOrdenante")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findByAdicionadoPor", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.adicionadoPor = :adicionadoPor")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findByAgenciaAdiciona", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.agenciaAdiciona = :agenciaAdiciona")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findByEnviadoUapPor", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.enviadoUapPor = :enviadoUapPor")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findByRecibidoUapPor", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.recibidoUapPor = :recibidoUapPor")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findByEnvioOrdenante", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.envioOrdenante = :envioOrdenante")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findByDiasAplicaUap", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.diasAplicaUap = :diasAplicaUap")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findByModificadoPor", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.modificadoPor = :modificadoPor")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findByFechaModificacion", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.fechaModificacion = :fechaModificacion")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findByReferenciaContrato", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.referenciaContrato = :referenciaContrato")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findByFechaAdicion", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.fechaAdicion = :fechaAdicion")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findBySecuenciaInterna", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.secuenciaInterna = :secuenciaInterna")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findByMotivoRechazo", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.motivoRechazo = :motivoRechazo")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findByNombreArchivo", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.nombreArchivo = :nombreArchivo")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findByNombreArchivoOrd", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.nombreArchivoOrd = :nombreArchivoOrd")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findByArchivoRespuesta", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.archivoRespuesta = :archivoRespuesta")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findByCopiadoOrdenante", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.copiadoOrdenante = :copiadoOrdenante")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findByDiasVenceAfiliacion", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.diasVenceAfiliacion = :diasVenceAfiliacion")
    , @NamedQuery(name = "MgAfiliacionesPresentadas.findBySecuenciaLoteDet", query = "SELECT m FROM MgAfiliacionesPresentadas m WHERE m.secuenciaLoteDet = :secuenciaLoteDet")})
public class MgAfiliacionesPresentadas implements Serializable {

    @Column(name = "LOTE_DEVOLUCION")
    private Short loteDevolucion;
    @Size(max = 1)
    @Column(name = "ENVIADO_DEVOLUCION")
    private String enviadoDevolucion;
    @Column(name = "FECHA_ENVIO_DESAFILIACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEnvioDesafiliacion;
    @Column(name = "GRUPO")
    private Long grupo;
    @Column(name = "ELEMENTO_GRUPO")
    private Long elementoGrupo;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MgAfiliacionesPresentadasPK mgAfiliacionesPresentadasPK;
    @Column(name = "SECUENCIA_LOTE")
    private Long secuenciaLote;
    @Column(name = "SECUENCIA")
    private BigInteger secuencia;
    @Column(name = "REGISTRO_ORDENANTE")
    private String registroOrdenante;
    @Column(name = "CANAL_AFILIACION")
    private String canalAfiliacion;
    @Column(name = "CODIGO_EMPRESA")
    private String codigoEmpresa;
    @Column(name = "REFERENCIA_ORDENANTE")
    private String referenciaOrdenante;
    @Column(name = "TIPO_OPERACION")
    private String tipoOperacion;
    @Column(name = "BANCO_DESTINO")
    private Short bancoDestino;
    @Column(name = "CODIGO_OPERACION")
    private String codigoOperacion;
    @Column(name = "CODIGO_RESULTADO")
    private String codigoResultado;
    @Column(name = "TIPO_PAGADOR")
    private String tipoPagador;
    @Column(name = "IDENTIFICACION_PAGADOR")
    private String identificacionPagador;
    @Column(name = "CUENTA_PAGADOR")
    private String cuentaPagador;
    @Column(name = "NOMBRE_PAGADOR")
    private String nombrePagador;
    @Column(name = "CONTRATO")
    private String contrato;
    @Column(name = "NUMERO_MENSAJE")
    private Short numeroMensaje;
    @Column(name = "ENVIADO")
    private String enviado;
    @Column(name = "RECIBIDO_UAP")
    private String recibidoUap;
    @Column(name = "ENVIADO_ORDENANTE")
    private String enviadoOrdenante;
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
    @Column(name = "ADICIONADO_POR")
    private String adicionadoPor;
    @Column(name = "AGENCIA_ADICIONA")
    private Short agenciaAdiciona;
    @Column(name = "ENVIADO_UAP_POR")
    private String enviadoUapPor;
    @Column(name = "RECIBIDO_UAP_POR")
    private String recibidoUapPor;
    @Column(name = "ENVIO_ORDENANTE")
    private String envioOrdenante;
    @Column(name = "DIAS_APLICA_UAP")
    private String diasAplicaUap;
    @Column(name = "MODIFICADO_POR")
    private String modificadoPor;
    @Column(name = "FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Column(name = "REFERENCIA_CONTRATO")
    private String referenciaContrato;
    @Column(name = "FECHA_ADICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAdicion;
    @Column(name = "SECUENCIA_INTERNA")
    private Long secuenciaInterna;
    @Column(name = "MOTIVO_RECHAZO")
    private String motivoRechazo;
    @Column(name = "NOMBRE_ARCHIVO")
    private String nombreArchivo;
    @Column(name = "NOMBRE_ARCHIVO_ORD")
    private String nombreArchivoOrd;
    @Column(name = "ARCHIVO_RESPUESTA")
    private String archivoRespuesta;
    @Column(name = "COPIADO_ORDENANTE")
    private String copiadoOrdenante;
    @Column(name = "DIAS_VENCE_AFILIACION")
    private Short diasVenceAfiliacion;
    @Column(name = "SECUENCIA_LOTE_DET")
    private Integer secuenciaLoteDet;
    @Column(name = "CODIGO_ORDENANTE")
    private String codigoOrdenante;

    public MgAfiliacionesPresentadas() {
    }

    public MgAfiliacionesPresentadas(MgAfiliacionesPresentadasPK mgAfiliacionesPresentadasPK) {
        this.mgAfiliacionesPresentadasPK = mgAfiliacionesPresentadasPK;
    }

    public MgAfiliacionesPresentadas(String codigoOrdenante, String claveOrdenante) {
        this.mgAfiliacionesPresentadasPK = new MgAfiliacionesPresentadasPK(codigoOrdenante, claveOrdenante);
    }

    public MgAfiliacionesPresentadasPK getMgAfiliacionesPresentadasPK() {
        return mgAfiliacionesPresentadasPK;
    }

    public void setMgAfiliacionesPresentadasPK(MgAfiliacionesPresentadasPK mgAfiliacionesPresentadasPK) {
        this.mgAfiliacionesPresentadasPK = mgAfiliacionesPresentadasPK;
    }

    public Long getSecuenciaLote() {
        return secuenciaLote;
    }

    public void setSecuenciaLote(Long secuenciaLote) {
        this.secuenciaLote = secuenciaLote;
    }

    public BigInteger getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(BigInteger secuencia) {
        this.secuencia = secuencia;
    }

    public String getRegistroOrdenante() {
        return registroOrdenante;
    }

    public void setRegistroOrdenante(String registroOrdenante) {
        this.registroOrdenante = registroOrdenante;
    }

    public String getCanalAfiliacion() {
        return canalAfiliacion;
    }

    public void setCanalAfiliacion(String canalAfiliacion) {
        this.canalAfiliacion = canalAfiliacion;
    }

    public String getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public void setCodigoEmpresa(String codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    public String getReferenciaOrdenante() {
        return referenciaOrdenante;
    }

    public void setReferenciaOrdenante(String referenciaOrdenante) {
        this.referenciaOrdenante = referenciaOrdenante;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public Short getBancoDestino() {
        return bancoDestino;
    }

    public void setBancoDestino(Short bancoDestino) {
        this.bancoDestino = bancoDestino;
    }

    public String getCodigoOperacion() {
        return codigoOperacion;
    }

    public void setCodigoOperacion(String codigoOperacion) {
        this.codigoOperacion = codigoOperacion;
    }

    public String getCodigoResultado() {
        return codigoResultado;
    }

    public void setCodigoResultado(String codigoResultado) {
        this.codigoResultado = codigoResultado;
    }

    public String getTipoPagador() {
        return tipoPagador;
    }

    public void setTipoPagador(String tipoPagador) {
        this.tipoPagador = tipoPagador;
    }

    public String getIdentificacionPagador() {
        return identificacionPagador;
    }

    public void setIdentificacionPagador(String identificacionPagador) {
        this.identificacionPagador = identificacionPagador;
    }

    public String getCuentaPagador() {
        return cuentaPagador;
    }

    public void setCuentaPagador(String cuentaPagador) {
        this.cuentaPagador = cuentaPagador;
    }

    public String getNombrePagador() {
        return nombrePagador;
    }

    public void setNombrePagador(String nombrePagador) {
        this.nombrePagador = nombrePagador;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    public Short getNumeroMensaje() {
        return numeroMensaje;
    }

    public void setNumeroMensaje(Short numeroMensaje) {
        this.numeroMensaje = numeroMensaje;
    }

    public String getEnviado() {
        return enviado;
    }

    public void setEnviado(String enviado) {
        this.enviado = enviado;
    }

    public String getRecibidoUap() {
        return recibidoUap;
    }

    public void setRecibidoUap(String recibidoUap) {
        this.recibidoUap = recibidoUap;
    }

    public String getEnviadoOrdenante() {
        return enviadoOrdenante;
    }

    public void setEnviadoOrdenante(String enviadoOrdenante) {
        this.enviadoOrdenante = enviadoOrdenante;
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

    public String getAdicionadoPor() {
        return adicionadoPor;
    }

    public void setAdicionadoPor(String adicionadoPor) {
        this.adicionadoPor = adicionadoPor;
    }

    public Short getAgenciaAdiciona() {
        return agenciaAdiciona;
    }

    public void setAgenciaAdiciona(Short agenciaAdiciona) {
        this.agenciaAdiciona = agenciaAdiciona;
    }

    public String getEnviadoUapPor() {
        return enviadoUapPor;
    }

    public void setEnviadoUapPor(String enviadoUapPor) {
        this.enviadoUapPor = enviadoUapPor;
    }

    public String getRecibidoUapPor() {
        return recibidoUapPor;
    }

    public void setRecibidoUapPor(String recibidoUapPor) {
        this.recibidoUapPor = recibidoUapPor;
    }

    public String getEnvioOrdenante() {
        return envioOrdenante;
    }

    public void setEnvioOrdenante(String envioOrdenante) {
        this.envioOrdenante = envioOrdenante;
    }

    public String getDiasAplicaUap() {
        return diasAplicaUap;
    }

    public void setDiasAplicaUap(String diasAplicaUap) {
        this.diasAplicaUap = diasAplicaUap;
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

    public String getReferenciaContrato() {
        return referenciaContrato;
    }

    public void setReferenciaContrato(String referenciaContrato) {
        this.referenciaContrato = referenciaContrato;
    }

    public Date getFechaAdicion() {
        return fechaAdicion;
    }

    public void setFechaAdicion(Date fechaAdicion) {
        this.fechaAdicion = fechaAdicion;
    }

    public Long getSecuenciaInterna() {
        return secuenciaInterna;
    }

    public void setSecuenciaInterna(Long secuenciaInterna) {
        this.secuenciaInterna = secuenciaInterna;
    }

    public String getMotivoRechazo() {
        return motivoRechazo;
    }

    public void setMotivoRechazo(String motivoRechazo) {
        this.motivoRechazo = motivoRechazo;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getNombreArchivoOrd() {
        return nombreArchivoOrd;
    }

    public void setNombreArchivoOrd(String nombreArchivoOrd) {
        this.nombreArchivoOrd = nombreArchivoOrd;
    }

    public String getArchivoRespuesta() {
        return archivoRespuesta;
    }

    public void setArchivoRespuesta(String archivoRespuesta) {
        this.archivoRespuesta = archivoRespuesta;
    }

    public String getCopiadoOrdenante() {
        return copiadoOrdenante;
    }

    public void setCopiadoOrdenante(String copiadoOrdenante) {
        this.copiadoOrdenante = copiadoOrdenante;
    }

    public Short getDiasVenceAfiliacion() {
        return diasVenceAfiliacion;
    }

    public void setDiasVenceAfiliacion(Short diasVenceAfiliacion) {
        this.diasVenceAfiliacion = diasVenceAfiliacion;
    }

    public Integer getSecuenciaLoteDet() {
        return secuenciaLoteDet;
    }

    public void setSecuenciaLoteDet(Integer secuenciaLoteDet) {
        this.secuenciaLoteDet = secuenciaLoteDet;
    }

    public String getCodigoOrdenante() {
        return codigoOrdenante;
    }

    public void setCodigoOrdenante(String codigoOrdenante) {
        this.codigoOrdenante = codigoOrdenante;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mgAfiliacionesPresentadasPK != null ? mgAfiliacionesPresentadasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MgAfiliacionesPresentadas)) {
            return false;
        }
        MgAfiliacionesPresentadas other = (MgAfiliacionesPresentadas) object;
        if ((this.mgAfiliacionesPresentadasPK == null && other.mgAfiliacionesPresentadasPK != null) || (this.mgAfiliacionesPresentadasPK != null && !this.mgAfiliacionesPresentadasPK.equals(other.mgAfiliacionesPresentadasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.model.MgAfiliacionesPresentadas[ mgAfiliacionesPresentadasPK=" + mgAfiliacionesPresentadasPK + " ]";
    }

    public Short getLoteDevolucion() {
        return loteDevolucion;
    }

    public void setLoteDevolucion(Short loteDevolucion) {
        this.loteDevolucion = loteDevolucion;
    }

    public String getEnviadoDevolucion() {
        return enviadoDevolucion;
    }

    public void setEnviadoDevolucion(String enviadoDevolucion) {
        this.enviadoDevolucion = enviadoDevolucion;
    }

    public Date getFechaEnvioDesafiliacion() {
        return fechaEnvioDesafiliacion;
    }

    public void setFechaEnvioDesafiliacion(Date fechaEnvioDesafiliacion) {
        this.fechaEnvioDesafiliacion = fechaEnvioDesafiliacion;
    }

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
