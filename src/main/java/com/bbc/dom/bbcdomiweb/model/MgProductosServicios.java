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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Christian Gutierrez
 */
@Entity
@Table(name = "MG_PRODUCTOS_SERVICIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MgProductosServicios.findAll", query = "SELECT m FROM MgProductosServicios m")
    , @NamedQuery(name = "MgProductosServicios.findByCodigoCliente", query = "SELECT m FROM MgProductosServicios m WHERE m.codigoCliente = :codigoCliente")
    , @NamedQuery(name = "MgProductosServicios.findByMontoPromedioMes", query = "SELECT m FROM MgProductosServicios m WHERE m.montoPromedioMes = :montoPromedioMes")
    , @NamedQuery(name = "MgProductosServicios.findByCantidadTransCr", query = "SELECT m FROM MgProductosServicios m WHERE m.cantidadTransCr = :cantidadTransCr")
    , @NamedQuery(name = "MgProductosServicios.findByCantidadTransDb", query = "SELECT m FROM MgProductosServicios m WHERE m.cantidadTransDb = :cantidadTransDb")
    , @NamedQuery(name = "MgProductosServicios.findByCodigoPaisOriTransf", query = "SELECT m FROM MgProductosServicios m WHERE m.codigoPaisOriTransf = :codigoPaisOriTransf")
    , @NamedQuery(name = "MgProductosServicios.findByCodigoPaisDesTransf", query = "SELECT m FROM MgProductosServicios m WHERE m.codigoPaisDesTransf = :codigoPaisDesTransf")
    , @NamedQuery(name = "MgProductosServicios.findByCodigoMonedaVirtual", query = "SELECT m FROM MgProductosServicios m WHERE m.codigoMonedaVirtual = :codigoMonedaVirtual")
    , @NamedQuery(name = "MgProductosServicios.findByCodigoMotivoServicio", query = "SELECT m FROM MgProductosServicios m WHERE m.codigoMotivoServicio = :codigoMotivoServicio")
    , @NamedQuery(name = "MgProductosServicios.findByCodigoOrigenFondos", query = "SELECT m FROM MgProductosServicios m WHERE m.codigoOrigenFondos = :codigoOrigenFondos")
    , @NamedQuery(name = "MgProductosServicios.findByCodigoDestinoFondos", query = "SELECT m FROM MgProductosServicios m WHERE m.codigoDestinoFondos = :codigoDestinoFondos")
    , @NamedQuery(name = "MgProductosServicios.findByComentarioUsoOtros", query = "SELECT m FROM MgProductosServicios m WHERE m.comentarioUsoOtros = :comentarioUsoOtros")
    , @NamedQuery(name = "MgProductosServicios.findByAdicionadoPor", query = "SELECT m FROM MgProductosServicios m WHERE m.adicionadoPor = :adicionadoPor")
    , @NamedQuery(name = "MgProductosServicios.findByFechaAdicion", query = "SELECT m FROM MgProductosServicios m WHERE m.fechaAdicion = :fechaAdicion")
    , @NamedQuery(name = "MgProductosServicios.findByModificadoPor", query = "SELECT m FROM MgProductosServicios m WHERE m.modificadoPor = :modificadoPor")
    , @NamedQuery(name = "MgProductosServicios.findByFechaModificacion", query = "SELECT m FROM MgProductosServicios m WHERE m.fechaModificacion = :fechaModificacion")})
public class MgProductosServicios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_CLIENTE")
    private Long codigoCliente;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MONTO_PROMEDIO_MES")
    private BigDecimal montoPromedioMes;
    @Column(name = "CANTIDAD_TRANS_CR")
    private Integer cantidadTransCr;
    @Column(name = "CANTIDAD_TRANS_DB")
    private Integer cantidadTransDb;
    @Column(name = "CODIGO_PAIS_ORI_TRANSF")
    private Short codigoPaisOriTransf;
    @Column(name = "CODIGO_PAIS_DES_TRANSF")
    private Short codigoPaisDesTransf;
    @Size(max = 2)
    @Column(name = "CODIGO_MONEDA_VIRTUAL")
    private String codigoMonedaVirtual;
    @Size(max = 2)
    @Column(name = "CODIGO_MOTIVO_SERVICIO")
    private String codigoMotivoServicio;
    @Size(max = 2)
    @Column(name = "CODIGO_ORIGEN_FONDOS")
    private String codigoOrigenFondos;
    @Size(max = 2)
    @Column(name = "CODIGO_DESTINO_FONDOS")
    private String codigoDestinoFondos;
    @Size(max = 100)
    @Column(name = "COMENTARIO_USO_OTROS")
    private String comentarioUsoOtros;
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

    public MgProductosServicios() {
    }

    public MgProductosServicios(Long codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public Long getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Long codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public BigDecimal getMontoPromedioMes() {
        return montoPromedioMes;
    }

    public void setMontoPromedioMes(BigDecimal montoPromedioMes) {
        this.montoPromedioMes = montoPromedioMes;
    }

    public Integer getCantidadTransCr() {
        return cantidadTransCr;
    }

    public void setCantidadTransCr(Integer cantidadTransCr) {
        this.cantidadTransCr = cantidadTransCr;
    }

    public Integer getCantidadTransDb() {
        return cantidadTransDb;
    }

    public void setCantidadTransDb(Integer cantidadTransDb) {
        this.cantidadTransDb = cantidadTransDb;
    }

    public Short getCodigoPaisOriTransf() {
        return codigoPaisOriTransf;
    }

    public void setCodigoPaisOriTransf(Short codigoPaisOriTransf) {
        this.codigoPaisOriTransf = codigoPaisOriTransf;
    }

    public Short getCodigoPaisDesTransf() {
        return codigoPaisDesTransf;
    }

    public void setCodigoPaisDesTransf(Short codigoPaisDesTransf) {
        this.codigoPaisDesTransf = codigoPaisDesTransf;
    }

    public String getCodigoMonedaVirtual() {
        return codigoMonedaVirtual;
    }

    public void setCodigoMonedaVirtual(String codigoMonedaVirtual) {
        this.codigoMonedaVirtual = codigoMonedaVirtual;
    }

    public String getCodigoMotivoServicio() {
        return codigoMotivoServicio;
    }

    public void setCodigoMotivoServicio(String codigoMotivoServicio) {
        this.codigoMotivoServicio = codigoMotivoServicio;
    }

    public String getCodigoOrigenFondos() {
        return codigoOrigenFondos;
    }

    public void setCodigoOrigenFondos(String codigoOrigenFondos) {
        this.codigoOrigenFondos = codigoOrigenFondos;
    }

    public String getCodigoDestinoFondos() {
        return codigoDestinoFondos;
    }

    public void setCodigoDestinoFondos(String codigoDestinoFondos) {
        this.codigoDestinoFondos = codigoDestinoFondos;
    }

    public String getComentarioUsoOtros() {
        return comentarioUsoOtros;
    }

    public void setComentarioUsoOtros(String comentarioUsoOtros) {
        this.comentarioUsoOtros = comentarioUsoOtros;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCliente != null ? codigoCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MgProductosServicios)) {
            return false;
        }
        MgProductosServicios other = (MgProductosServicios) object;
        if ((this.codigoCliente == null && other.codigoCliente != null) || (this.codigoCliente != null && !this.codigoCliente.equals(other.codigoCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.MgProductosServicios[ codigoCliente=" + codigoCliente + " ]";
    }
    
}
