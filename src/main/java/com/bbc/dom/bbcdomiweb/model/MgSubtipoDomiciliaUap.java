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
@Table(name = "MG_SUBTIPO_DOMICILIA_UAP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MgSubtipoDomiciliaUap.findAll", query = "SELECT m FROM MgSubtipoDomiciliaUap m")
    , @NamedQuery(name = "MgSubtipoDomiciliaUap.findByCodigoSubtipo", query = "SELECT m FROM MgSubtipoDomiciliaUap m WHERE m.codigoSubtipo = :codigoSubtipo")
    , @NamedQuery(name = "MgSubtipoDomiciliaUap.findByNombre", query = "SELECT m FROM MgSubtipoDomiciliaUap m WHERE m.nombre = :nombre")
    , @NamedQuery(name = "MgSubtipoDomiciliaUap.findByAdicionadoPor", query = "SELECT m FROM MgSubtipoDomiciliaUap m WHERE m.adicionadoPor = :adicionadoPor")
    , @NamedQuery(name = "MgSubtipoDomiciliaUap.findByFechaAdicion", query = "SELECT m FROM MgSubtipoDomiciliaUap m WHERE m.fechaAdicion = :fechaAdicion")
    , @NamedQuery(name = "MgSubtipoDomiciliaUap.findByModificadoPor", query = "SELECT m FROM MgSubtipoDomiciliaUap m WHERE m.modificadoPor = :modificadoPor")
    , @NamedQuery(name = "MgSubtipoDomiciliaUap.findByFechaModificacion", query = "SELECT m FROM MgSubtipoDomiciliaUap m WHERE m.fechaModificacion = :fechaModificacion")})
public class MgSubtipoDomiciliaUap implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_SUBTIPO")
    private Short codigoSubtipo;
    @Size(max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
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

    public MgSubtipoDomiciliaUap() {
    }

    public MgSubtipoDomiciliaUap(Short codigoSubtipo) {
        this.codigoSubtipo = codigoSubtipo;
    }

    public Short getCodigoSubtipo() {
        return codigoSubtipo;
    }

    public void setCodigoSubtipo(Short codigoSubtipo) {
        this.codigoSubtipo = codigoSubtipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        if (!(object instanceof MgSubtipoDomiciliaUap)) {
            return false;
        }
        MgSubtipoDomiciliaUap other = (MgSubtipoDomiciliaUap) object;
        if ((this.codigoSubtipo == null && other.codigoSubtipo != null) || (this.codigoSubtipo != null && !this.codigoSubtipo.equals(other.codigoSubtipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.MgSubtipoDomiciliaUap[ codigoSubtipo=" + codigoSubtipo + " ]";
    }
    
}
