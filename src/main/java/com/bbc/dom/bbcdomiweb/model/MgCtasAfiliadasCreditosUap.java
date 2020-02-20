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
@Table(name = "MG_CTAS_AFILIADAS_CREDITOS_UAP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MgCtasAfiliadasCreditosUap.findAll", query = "SELECT m FROM MgCtasAfiliadasCreditosUap m")
    , @NamedQuery(name = "MgCtasAfiliadasCreditosUap.findByCodigoEmpresa", query = "SELECT m FROM MgCtasAfiliadasCreditosUap m WHERE m.mgCtasAfiliadasCreditosUapPK.codigoEmpresa = :codigoEmpresa")
    , @NamedQuery(name = "MgCtasAfiliadasCreditosUap.findByCodigoAgencia", query = "SELECT m FROM MgCtasAfiliadasCreditosUap m WHERE m.mgCtasAfiliadasCreditosUapPK.codigoAgencia = :codigoAgencia")
    , @NamedQuery(name = "MgCtasAfiliadasCreditosUap.findByCodigoAplicacion", query = "SELECT m FROM MgCtasAfiliadasCreditosUap m WHERE m.mgCtasAfiliadasCreditosUapPK.codigoAplicacion = :codigoAplicacion")
    , @NamedQuery(name = "MgCtasAfiliadasCreditosUap.findByCodigoSubaplicacion", query = "SELECT m FROM MgCtasAfiliadasCreditosUap m WHERE m.mgCtasAfiliadasCreditosUapPK.codigoSubaplicacion = :codigoSubaplicacion")
    , @NamedQuery(name = "MgCtasAfiliadasCreditosUap.findByNumeroCuenta", query = "SELECT m FROM MgCtasAfiliadasCreditosUap m WHERE m.mgCtasAfiliadasCreditosUapPK.numeroCuenta = :numeroCuenta")
    , @NamedQuery(name = "MgCtasAfiliadasCreditosUap.findByCodigoCliente", query = "SELECT m FROM MgCtasAfiliadasCreditosUap m WHERE m.codigoCliente = :codigoCliente")
    , @NamedQuery(name = "MgCtasAfiliadasCreditosUap.findByCedulaDestino", query = "SELECT m FROM MgCtasAfiliadasCreditosUap m WHERE m.cedulaDestino = :cedulaDestino")
    , @NamedQuery(name = "MgCtasAfiliadasCreditosUap.findByNombreDestino", query = "SELECT m FROM MgCtasAfiliadasCreditosUap m WHERE m.nombreDestino = :nombreDestino")
    , @NamedQuery(name = "MgCtasAfiliadasCreditosUap.findByCodigoBancoDest", query = "SELECT m FROM MgCtasAfiliadasCreditosUap m WHERE m.codigoBancoDest = :codigoBancoDest")
    , @NamedQuery(name = "MgCtasAfiliadasCreditosUap.findByTipoProducto", query = "SELECT m FROM MgCtasAfiliadasCreditosUap m WHERE m.tipoProducto = :tipoProducto")
    , @NamedQuery(name = "MgCtasAfiliadasCreditosUap.findByNumeroCuentaDest", query = "SELECT m FROM MgCtasAfiliadasCreditosUap m WHERE m.mgCtasAfiliadasCreditosUapPK.numeroCuentaDest = :numeroCuentaDest")
    , @NamedQuery(name = "MgCtasAfiliadasCreditosUap.findByMontoMaximoAutorizado", query = "SELECT m FROM MgCtasAfiliadasCreditosUap m WHERE m.montoMaximoAutorizado = :montoMaximoAutorizado")
    , @NamedQuery(name = "MgCtasAfiliadasCreditosUap.findByEstado", query = "SELECT m FROM MgCtasAfiliadasCreditosUap m WHERE m.estado = :estado")
    , @NamedQuery(name = "MgCtasAfiliadasCreditosUap.findByAdicionadoPor", query = "SELECT m FROM MgCtasAfiliadasCreditosUap m WHERE m.adicionadoPor = :adicionadoPor")
    , @NamedQuery(name = "MgCtasAfiliadasCreditosUap.findByFechaAdicion", query = "SELECT m FROM MgCtasAfiliadasCreditosUap m WHERE m.fechaAdicion = :fechaAdicion")
    , @NamedQuery(name = "MgCtasAfiliadasCreditosUap.findByAutorizadoPor", query = "SELECT m FROM MgCtasAfiliadasCreditosUap m WHERE m.autorizadoPor = :autorizadoPor")
    , @NamedQuery(name = "MgCtasAfiliadasCreditosUap.findByFechaAutorizacion", query = "SELECT m FROM MgCtasAfiliadasCreditosUap m WHERE m.fechaAutorizacion = :fechaAutorizacion")
    , @NamedQuery(name = "MgCtasAfiliadasCreditosUap.findByModificadoPor", query = "SELECT m FROM MgCtasAfiliadasCreditosUap m WHERE m.modificadoPor = :modificadoPor")
    , @NamedQuery(name = "MgCtasAfiliadasCreditosUap.findByFechaModificacion", query = "SELECT m FROM MgCtasAfiliadasCreditosUap m WHERE m.fechaModificacion = :fechaModificacion")})
public class MgCtasAfiliadasCreditosUap implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MgCtasAfiliadasCreditosUapPK mgCtasAfiliadasCreditosUapPK;
    @Column(name = "CODIGO_CLIENTE")
    private Integer codigoCliente;
    @Size(max = 15)
    @Column(name = "CEDULA_DESTINO")
    private String cedulaDestino;
    @Size(max = 35)
    @Column(name = "NOMBRE_DESTINO")
    private String nombreDestino;
    @Column(name = "CODIGO_BANCO_DEST")
    private Short codigoBancoDest;
    @Size(max = 3)
    @Column(name = "TIPO_PRODUCTO")
    private String tipoProducto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MONTO_MAXIMO_AUTORIZADO")
    private BigDecimal montoMaximoAutorizado;
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

    public MgCtasAfiliadasCreditosUap() {
    }

    public MgCtasAfiliadasCreditosUap(MgCtasAfiliadasCreditosUapPK mgCtasAfiliadasCreditosUapPK) {
        this.mgCtasAfiliadasCreditosUapPK = mgCtasAfiliadasCreditosUapPK;
    }

    public MgCtasAfiliadasCreditosUap(short codigoEmpresa, short codigoAgencia, String codigoAplicacion, short codigoSubaplicacion, long numeroCuenta, String numeroCuentaDest) {
        this.mgCtasAfiliadasCreditosUapPK = new MgCtasAfiliadasCreditosUapPK(codigoEmpresa, codigoAgencia, codigoAplicacion, codigoSubaplicacion, numeroCuenta, numeroCuentaDest);
    }

    public MgCtasAfiliadasCreditosUapPK getMgCtasAfiliadasCreditosUapPK() {
        return mgCtasAfiliadasCreditosUapPK;
    }

    public void setMgCtasAfiliadasCreditosUapPK(MgCtasAfiliadasCreditosUapPK mgCtasAfiliadasCreditosUapPK) {
        this.mgCtasAfiliadasCreditosUapPK = mgCtasAfiliadasCreditosUapPK;
    }

    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getCedulaDestino() {
        return cedulaDestino;
    }

    public void setCedulaDestino(String cedulaDestino) {
        this.cedulaDestino = cedulaDestino;
    }

    public String getNombreDestino() {
        return nombreDestino;
    }

    public void setNombreDestino(String nombreDestino) {
        this.nombreDestino = nombreDestino;
    }

    public Short getCodigoBancoDest() {
        return codigoBancoDest;
    }

    public void setCodigoBancoDest(Short codigoBancoDest) {
        this.codigoBancoDest = codigoBancoDest;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public BigDecimal getMontoMaximoAutorizado() {
        return montoMaximoAutorizado;
    }

    public void setMontoMaximoAutorizado(BigDecimal montoMaximoAutorizado) {
        this.montoMaximoAutorizado = montoMaximoAutorizado;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mgCtasAfiliadasCreditosUapPK != null ? mgCtasAfiliadasCreditosUapPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MgCtasAfiliadasCreditosUap)) {
            return false;
        }
        MgCtasAfiliadasCreditosUap other = (MgCtasAfiliadasCreditosUap) object;
        if ((this.mgCtasAfiliadasCreditosUapPK == null && other.mgCtasAfiliadasCreditosUapPK != null) || (this.mgCtasAfiliadasCreditosUapPK != null && !this.mgCtasAfiliadasCreditosUapPK.equals(other.mgCtasAfiliadasCreditosUapPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.MgCtasAfiliadasCreditosUap[ mgCtasAfiliadasCreditosUapPK=" + mgCtasAfiliadasCreditosUapPK + " ]";
    }
    
}
