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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
@Table(name = "MG_DET_ARCHIVOS_DOMICILIA_UAP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MgDetArchivosDomiciliaUap.findAll", query = "SELECT m FROM MgDetArchivosDomiciliaUap m")
    , @NamedQuery(name = "MgDetArchivosDomiciliaUap.findBySecuencia", query = "SELECT m FROM MgDetArchivosDomiciliaUap m WHERE m.mgDetArchivosDomiciliaUapPK.secuencia = :secuencia")
    , @NamedQuery(name = "MgDetArchivosDomiciliaUap.findByNombreArchivo", query = "SELECT m FROM MgDetArchivosDomiciliaUap m WHERE m.mgDetArchivosDomiciliaUapPK.nombreArchivo = :nombreArchivo")
    , @NamedQuery(name = "MgDetArchivosDomiciliaUap.findByFechaValida", query = "SELECT m FROM MgDetArchivosDomiciliaUap m WHERE m.mgDetArchivosDomiciliaUapPK.fechaValida = :fechaValida")
    , @NamedQuery(name = "MgDetArchivosDomiciliaUap.findByTipoTransaccion", query = "SELECT m FROM MgDetArchivosDomiciliaUap m WHERE m.tipoTransaccion = :tipoTransaccion")
    , @NamedQuery(name = "MgDetArchivosDomiciliaUap.findByCodigoInterno", query = "SELECT m FROM MgDetArchivosDomiciliaUap m WHERE m.codigoInterno = :codigoInterno")
    , @NamedQuery(name = "MgDetArchivosDomiciliaUap.findByReferenciaOrdenante", query = "SELECT m FROM MgDetArchivosDomiciliaUap m WHERE m.referenciaOrdenante = :referenciaOrdenante")
    , @NamedQuery(name = "MgDetArchivosDomiciliaUap.findByReferenciaContrato", query = "SELECT m FROM MgDetArchivosDomiciliaUap m WHERE m.referenciaContrato = :referenciaContrato")
    , @NamedQuery(name = "MgDetArchivosDomiciliaUap.findByTipoPagador", query = "SELECT m FROM MgDetArchivosDomiciliaUap m WHERE m.tipoPagador = :tipoPagador")
    , @NamedQuery(name = "MgDetArchivosDomiciliaUap.findByIdentificadorPagador", query = "SELECT m FROM MgDetArchivosDomiciliaUap m WHERE m.identificadorPagador = :identificadorPagador")
    , @NamedQuery(name = "MgDetArchivosDomiciliaUap.findByIdentificacionPagador", query = "SELECT m FROM MgDetArchivosDomiciliaUap m WHERE m.identificacionPagador = :identificacionPagador")
    , @NamedQuery(name = "MgDetArchivosDomiciliaUap.findByCuentaPagador", query = "SELECT m FROM MgDetArchivosDomiciliaUap m WHERE m.cuentaPagador = :cuentaPagador")
    , @NamedQuery(name = "MgDetArchivosDomiciliaUap.findByNombrePagador", query = "SELECT m FROM MgDetArchivosDomiciliaUap m WHERE m.nombrePagador = :nombrePagador")
    , @NamedQuery(name = "MgDetArchivosDomiciliaUap.findByFechaOrigen", query = "SELECT m FROM MgDetArchivosDomiciliaUap m WHERE m.fechaOrigen = :fechaOrigen")
    , @NamedQuery(name = "MgDetArchivosDomiciliaUap.findByCodigoResultado", query = "SELECT m FROM MgDetArchivosDomiciliaUap m WHERE m.codigoResultado = :codigoResultado")
    , @NamedQuery(name = "MgDetArchivosDomiciliaUap.findByMensaje", query = "SELECT m FROM MgDetArchivosDomiciliaUap m WHERE m.mensaje = :mensaje")
    , @NamedQuery(name = "MgDetArchivosDomiciliaUap.findByProcesada", query = "SELECT m FROM MgDetArchivosDomiciliaUap m WHERE m.procesada = :procesada")
    , @NamedQuery(name = "MgDetArchivosDomiciliaUap.findByAdicionadoPor", query = "SELECT m FROM MgDetArchivosDomiciliaUap m WHERE m.adicionadoPor = :adicionadoPor")
    , @NamedQuery(name = "MgDetArchivosDomiciliaUap.findByFechaAdicion", query = "SELECT m FROM MgDetArchivosDomiciliaUap m WHERE m.fechaAdicion = :fechaAdicion")
    , @NamedQuery(name = "MgDetArchivosDomiciliaUap.findByModificadoPor", query = "SELECT m FROM MgDetArchivosDomiciliaUap m WHERE m.modificadoPor = :modificadoPor")
    , @NamedQuery(name = "MgDetArchivosDomiciliaUap.findByFechaModificacion", query = "SELECT m FROM MgDetArchivosDomiciliaUap m WHERE m.fechaModificacion = :fechaModificacion")})
public class MgDetArchivosDomiciliaUap implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MgDetArchivosDomiciliaUapPK mgDetArchivosDomiciliaUapPK;
    @Size(max = 3)
    @Column(name = "TIPO_TRANSACCION")
    private String tipoTransaccion;
    @Size(max = 20)
    @Column(name = "CODIGO_INTERNO")
    private String codigoInterno;
    @Size(max = 12)
    @Column(name = "REFERENCIA_ORDENANTE")
    private String referenciaOrdenante;
    @Size(max = 30)
    @Column(name = "REFERENCIA_CONTRATO")
    private String referenciaContrato;
    @Size(max = 1)
    @Column(name = "TIPO_PAGADOR")
    private String tipoPagador;
    @Size(max = 1)
    @Column(name = "IDENTIFICADOR_PAGADOR")
    private String identificadorPagador;
    @Size(max = 12)
    @Column(name = "IDENTIFICACION_PAGADOR")
    private String identificacionPagador;
    @Size(max = 20)
    @Column(name = "CUENTA_PAGADOR")
    private String cuentaPagador;
    @Size(max = 35)
    @Column(name = "NOMBRE_PAGADOR")
    private String nombrePagador;
    @Size(max = 8)
    @Column(name = "FECHA_ORIGEN")
    private String fechaOrigen;
    @Size(max = 3)
    @Column(name = "CODIGO_RESULTADO")
    private String codigoResultado;
    @Size(max = 144)
    @Column(name = "MENSAJE")
    private String mensaje;
    @Size(max = 1)
    @Column(name = "PROCESADA")
    private String procesada;
    @Size(max = 10)
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
    @JoinColumns({
        @JoinColumn(name = "NOMBRE_ARCHIVO", referencedColumnName = "NOMBRE_ARCHIVO", insertable = false, updatable = false)
        , @JoinColumn(name = "FECHA_VALIDA", referencedColumnName = "FECHA_VALIDA", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private MgArchivosDomiciliaUap mgArchivosDomiciliaUap;
    @JoinColumn(name = "CODIGO_RECHAZO", referencedColumnName = "CODIGO_RECHAZO")
    @ManyToOne
    private MgMsnRechazoDomiciliaUap codigoRechazo;

    public MgDetArchivosDomiciliaUap() {
    }

    public MgDetArchivosDomiciliaUap(MgDetArchivosDomiciliaUapPK mgDetArchivosDomiciliaUapPK) {
        this.mgDetArchivosDomiciliaUapPK = mgDetArchivosDomiciliaUapPK;
    }

    public MgDetArchivosDomiciliaUap(BigInteger secuencia, String nombreArchivo, Date fechaValida) {
        this.mgDetArchivosDomiciliaUapPK = new MgDetArchivosDomiciliaUapPK(secuencia, nombreArchivo, fechaValida);
    }

    public MgDetArchivosDomiciliaUapPK getMgDetArchivosDomiciliaUapPK() {
        return mgDetArchivosDomiciliaUapPK;
    }

    public void setMgDetArchivosDomiciliaUapPK(MgDetArchivosDomiciliaUapPK mgDetArchivosDomiciliaUapPK) {
        this.mgDetArchivosDomiciliaUapPK = mgDetArchivosDomiciliaUapPK;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public String getCodigoInterno() {
        return codigoInterno;
    }

    public void setCodigoInterno(String codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    public String getReferenciaOrdenante() {
        return referenciaOrdenante;
    }

    public void setReferenciaOrdenante(String referenciaOrdenante) {
        this.referenciaOrdenante = referenciaOrdenante;
    }

    public String getReferenciaContrato() {
        return referenciaContrato;
    }

    public void setReferenciaContrato(String referenciaContrato) {
        this.referenciaContrato = referenciaContrato;
    }

    public String getTipoPagador() {
        return tipoPagador;
    }

    public void setTipoPagador(String tipoPagador) {
        this.tipoPagador = tipoPagador;
    }

    public String getIdentificadorPagador() {
        return identificadorPagador;
    }

    public void setIdentificadorPagador(String identificadorPagador) {
        this.identificadorPagador = identificadorPagador;
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

    public String getFechaOrigen() {
        return fechaOrigen;
    }

    public void setFechaOrigen(String fechaOrigen) {
        this.fechaOrigen = fechaOrigen;
    }

    public String getCodigoResultado() {
        return codigoResultado;
    }

    public void setCodigoResultado(String codigoResultado) {
        this.codigoResultado = codigoResultado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getProcesada() {
        return procesada;
    }

    public void setProcesada(String procesada) {
        this.procesada = procesada;
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

    public MgArchivosDomiciliaUap getMgArchivosDomiciliaUap() {
        return mgArchivosDomiciliaUap;
    }

    public void setMgArchivosDomiciliaUap(MgArchivosDomiciliaUap mgArchivosDomiciliaUap) {
        this.mgArchivosDomiciliaUap = mgArchivosDomiciliaUap;
    }

    public MgMsnRechazoDomiciliaUap getCodigoRechazo() {
        return codigoRechazo;
    }

    public void setCodigoRechazo(MgMsnRechazoDomiciliaUap codigoRechazo) {
        this.codigoRechazo = codigoRechazo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mgDetArchivosDomiciliaUapPK != null ? mgDetArchivosDomiciliaUapPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MgDetArchivosDomiciliaUap)) {
            return false;
        }
        MgDetArchivosDomiciliaUap other = (MgDetArchivosDomiciliaUap) object;
        if ((this.mgDetArchivosDomiciliaUapPK == null && other.mgDetArchivosDomiciliaUapPK != null) || (this.mgDetArchivosDomiciliaUapPK != null && !this.mgDetArchivosDomiciliaUapPK.equals(other.mgDetArchivosDomiciliaUapPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.MgDetArchivosDomiciliaUap[ mgDetArchivosDomiciliaUapPK=" + mgDetArchivosDomiciliaUapPK + " ]";
    }
    
}
