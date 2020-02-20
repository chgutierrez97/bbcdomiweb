/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "LC_LOG_CUPO_COMPROMETIDO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LcLogCupoComprometido.findAll", query = "SELECT l FROM LcLogCupoComprometido l")
    , @NamedQuery(name = "LcLogCupoComprometido.findByCodigoEmpresa", query = "SELECT l FROM LcLogCupoComprometido l WHERE l.lcLogCupoComprometidoPK.codigoEmpresa = :codigoEmpresa")
    , @NamedQuery(name = "LcLogCupoComprometido.findByCodigoLineaCredito", query = "SELECT l FROM LcLogCupoComprometido l WHERE l.lcLogCupoComprometidoPK.codigoLineaCredito = :codigoLineaCredito")
    , @NamedQuery(name = "LcLogCupoComprometido.findByFechaCuota", query = "SELECT l FROM LcLogCupoComprometido l WHERE l.lcLogCupoComprometidoPK.fechaCuota = :fechaCuota")
    , @NamedQuery(name = "LcLogCupoComprometido.findByFechaCobro", query = "SELECT l FROM LcLogCupoComprometido l WHERE l.fechaCobro = :fechaCobro")
    , @NamedQuery(name = "LcLogCupoComprometido.findByMontoDisponible", query = "SELECT l FROM LcLogCupoComprometido l WHERE l.montoDisponible = :montoDisponible")
    , @NamedQuery(name = "LcLogCupoComprometido.findByMontoCuota", query = "SELECT l FROM LcLogCupoComprometido l WHERE l.montoCuota = :montoCuota")
    , @NamedQuery(name = "LcLogCupoComprometido.findByCuota", query = "SELECT l FROM LcLogCupoComprometido l WHERE l.lcLogCupoComprometidoPK.cuota = :cuota")
    , @NamedQuery(name = "LcLogCupoComprometido.findByDescripcionComision", query = "SELECT l FROM LcLogCupoComprometido l WHERE l.descripcionComision = :descripcionComision")
    , @NamedQuery(name = "LcLogCupoComprometido.findByEstado", query = "SELECT l FROM LcLogCupoComprometido l WHERE l.estado = :estado")
    , @NamedQuery(name = "LcLogCupoComprometido.findByFechaAdicion", query = "SELECT l FROM LcLogCupoComprometido l WHERE l.fechaAdicion = :fechaAdicion")
    , @NamedQuery(name = "LcLogCupoComprometido.findByAdicionadoPor", query = "SELECT l FROM LcLogCupoComprometido l WHERE l.adicionadoPor = :adicionadoPor")
    , @NamedQuery(name = "LcLogCupoComprometido.findByFechaModificacion", query = "SELECT l FROM LcLogCupoComprometido l WHERE l.fechaModificacion = :fechaModificacion")
    , @NamedQuery(name = "LcLogCupoComprometido.findByModificadoPor", query = "SELECT l FROM LcLogCupoComprometido l WHERE l.modificadoPor = :modificadoPor")})
public class LcLogCupoComprometido implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LcLogCupoComprometidoPK lcLogCupoComprometidoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_COBRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCobro;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "MONTO_DISPONIBLE")
    private BigDecimal montoDisponible;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MONTO_CUOTA")
    private BigDecimal montoCuota;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DESCRIPCION_COMISION")
    private String descripcionComision;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "FECHA_ADICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAdicion;
    @Size(max = 15)
    @Column(name = "ADICIONADO_POR")
    private String adicionadoPor;
    @Column(name = "FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Size(max = 15)
    @Column(name = "MODIFICADO_POR")
    private String modificadoPor;

    public LcLogCupoComprometido() {
    }

    public LcLogCupoComprometido(LcLogCupoComprometidoPK lcLogCupoComprometidoPK) {
        this.lcLogCupoComprometidoPK = lcLogCupoComprometidoPK;
    }

    public LcLogCupoComprometido(LcLogCupoComprometidoPK lcLogCupoComprometidoPK, Date fechaCobro, BigDecimal montoDisponible, BigDecimal montoCuota, String descripcionComision, String estado) {
        this.lcLogCupoComprometidoPK = lcLogCupoComprometidoPK;
        this.fechaCobro = fechaCobro;
        this.montoDisponible = montoDisponible;
        this.montoCuota = montoCuota;
        this.descripcionComision = descripcionComision;
        this.estado = estado;
    }

    public LcLogCupoComprometido(short codigoEmpresa, long codigoLineaCredito, Date fechaCuota, BigInteger cuota) {
        this.lcLogCupoComprometidoPK = new LcLogCupoComprometidoPK(codigoEmpresa, codigoLineaCredito, fechaCuota, cuota);
    }

    public LcLogCupoComprometidoPK getLcLogCupoComprometidoPK() {
        return lcLogCupoComprometidoPK;
    }

    public void setLcLogCupoComprometidoPK(LcLogCupoComprometidoPK lcLogCupoComprometidoPK) {
        this.lcLogCupoComprometidoPK = lcLogCupoComprometidoPK;
    }

    public Date getFechaCobro() {
        return fechaCobro;
    }

    public void setFechaCobro(Date fechaCobro) {
        this.fechaCobro = fechaCobro;
    }

    public BigDecimal getMontoDisponible() {
        return montoDisponible;
    }

    public void setMontoDisponible(BigDecimal montoDisponible) {
        this.montoDisponible = montoDisponible;
    }

    public BigDecimal getMontoCuota() {
        return montoCuota;
    }

    public void setMontoCuota(BigDecimal montoCuota) {
        this.montoCuota = montoCuota;
    }

    public String getDescripcionComision() {
        return descripcionComision;
    }

    public void setDescripcionComision(String descripcionComision) {
        this.descripcionComision = descripcionComision;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
        hash += (lcLogCupoComprometidoPK != null ? lcLogCupoComprometidoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LcLogCupoComprometido)) {
            return false;
        }
        LcLogCupoComprometido other = (LcLogCupoComprometido) object;
        if ((this.lcLogCupoComprometidoPK == null && other.lcLogCupoComprometidoPK != null) || (this.lcLogCupoComprometidoPK != null && !this.lcLogCupoComprometidoPK.equals(other.lcLogCupoComprometidoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.LcLogCupoComprometido[ lcLogCupoComprometidoPK=" + lcLogCupoComprometidoPK + " ]";
    }
    
}
