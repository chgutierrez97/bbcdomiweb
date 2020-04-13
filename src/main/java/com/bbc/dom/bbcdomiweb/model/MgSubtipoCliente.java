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
@Table(name = "MG_SUBTIPO_CLIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MgSubtipoCliente.findAll", query = "SELECT m FROM MgSubtipoCliente m")
    , @NamedQuery(name = "MgSubtipoCliente.findByCodigoSubtipo", query = "SELECT m FROM MgSubtipoCliente m WHERE m.codigoSubtipo = :codigoSubtipo")
    , @NamedQuery(name = "MgSubtipoCliente.findByDescripcion", query = "SELECT m FROM MgSubtipoCliente m WHERE m.descripcion = :descripcion")
    , @NamedQuery(name = "MgSubtipoCliente.findByCodigoTipoCliente", query = "SELECT m FROM MgSubtipoCliente m WHERE m.codigoTipoCliente = :codigoTipoCliente")
    , @NamedQuery(name = "MgSubtipoCliente.findByAdicionadoPor", query = "SELECT m FROM MgSubtipoCliente m WHERE m.adicionadoPor = :adicionadoPor")
    , @NamedQuery(name = "MgSubtipoCliente.findByFechaAdicion", query = "SELECT m FROM MgSubtipoCliente m WHERE m.fechaAdicion = :fechaAdicion")
    , @NamedQuery(name = "MgSubtipoCliente.findByModificadoPor", query = "SELECT m FROM MgSubtipoCliente m WHERE m.modificadoPor = :modificadoPor")
    , @NamedQuery(name = "MgSubtipoCliente.findByFechaModificacion", query = "SELECT m FROM MgSubtipoCliente m WHERE m.fechaModificacion = :fechaModificacion")})
public class MgSubtipoCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_SUBTIPO")
    private Short codigoSubtipo;
    @Size(max = 30)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "CODIGO_TIPO_CLIENTE")
    private Short codigoTipoCliente;
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

    public MgSubtipoCliente() {
    }

    public MgSubtipoCliente(Short codigoSubtipo) {
        this.codigoSubtipo = codigoSubtipo;
    }

    public Short getCodigoSubtipo() {
        return codigoSubtipo;
    }

    public void setCodigoSubtipo(Short codigoSubtipo) {
        this.codigoSubtipo = codigoSubtipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Short getCodigoTipoCliente() {
        return codigoTipoCliente;
    }

    public void setCodigoTipoCliente(Short codigoTipoCliente) {
        this.codigoTipoCliente = codigoTipoCliente;
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
        hash += (codigoSubtipo != null ? codigoSubtipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MgSubtipoCliente)) {
            return false;
        }
        MgSubtipoCliente other = (MgSubtipoCliente) object;
        if ((this.codigoSubtipo == null && other.codigoSubtipo != null) || (this.codigoSubtipo != null && !this.codigoSubtipo.equals(other.codigoSubtipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.MgSubtipoCliente[ codigoSubtipo=" + codigoSubtipo + " ]";
    }
    
}
