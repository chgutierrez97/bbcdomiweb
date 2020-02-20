/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.model;

import java.io.Serializable;
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
@Table(name = "MG_MOTIVO_DEV_DOMICILIACIONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MgMotivoDevDomiciliaciones.findAll", query = "SELECT m FROM MgMotivoDevDomiciliaciones m")
    , @NamedQuery(name = "MgMotivoDevDomiciliaciones.findByCodigoDevolucion", query = "SELECT m FROM MgMotivoDevDomiciliaciones m WHERE m.codigoDevolucion = :codigoDevolucion")
    , @NamedQuery(name = "MgMotivoDevDomiciliaciones.findByDescripcion", query = "SELECT m FROM MgMotivoDevDomiciliaciones m WHERE m.descripcion = :descripcion")
    , @NamedQuery(name = "MgMotivoDevDomiciliaciones.findByAdicionadoPor", query = "SELECT m FROM MgMotivoDevDomiciliaciones m WHERE m.adicionadoPor = :adicionadoPor")
    , @NamedQuery(name = "MgMotivoDevDomiciliaciones.findByFechaAdicion", query = "SELECT m FROM MgMotivoDevDomiciliaciones m WHERE m.fechaAdicion = :fechaAdicion")
    , @NamedQuery(name = "MgMotivoDevDomiciliaciones.findByModificadoPor", query = "SELECT m FROM MgMotivoDevDomiciliaciones m WHERE m.modificadoPor = :modificadoPor")
    , @NamedQuery(name = "MgMotivoDevDomiciliaciones.findByFechaModificacion", query = "SELECT m FROM MgMotivoDevDomiciliaciones m WHERE m.fechaModificacion = :fechaModificacion")})
public class MgMotivoDevDomiciliaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_DEVOLUCION")
    private Long codigoDevolucion;
    @Size(max = 200)
    @Column(name = "DESCRIPCION")
    private String descripcion;
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

    public MgMotivoDevDomiciliaciones() {
    }

    public MgMotivoDevDomiciliaciones(Long codigoDevolucion) {
        this.codigoDevolucion = codigoDevolucion;
    }

    public Long getCodigoDevolucion() {
        return codigoDevolucion;
    }

    public void setCodigoDevolucion(Long codigoDevolucion) {
        this.codigoDevolucion = codigoDevolucion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (codigoDevolucion != null ? codigoDevolucion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MgMotivoDevDomiciliaciones)) {
            return false;
        }
        MgMotivoDevDomiciliaciones other = (MgMotivoDevDomiciliaciones) object;
        if ((this.codigoDevolucion == null && other.codigoDevolucion != null) || (this.codigoDevolucion != null && !this.codigoDevolucion.equals(other.codigoDevolucion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.MgMotivoDevDomiciliaciones[ codigoDevolucion=" + codigoDevolucion + " ]";
    }
    
}
