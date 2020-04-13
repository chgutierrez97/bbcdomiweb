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
@Table(name = "MG_SERVICIOS_DOMICILIACION_UAP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MgServiciosDomiciliacionUap.findAll", query = "SELECT m FROM MgServiciosDomiciliacionUap m")
    , @NamedQuery(name = "MgServiciosDomiciliacionUap.findByReferenciaOrdenante", query = "SELECT m FROM MgServiciosDomiciliacionUap m WHERE m.referenciaOrdenante = :referenciaOrdenante")
    , @NamedQuery(name = "MgServiciosDomiciliacionUap.findByNombre", query = "SELECT m FROM MgServiciosDomiciliacionUap m WHERE m.nombre = :nombre")
    , @NamedQuery(name = "MgServiciosDomiciliacionUap.findByEstado", query = "SELECT m FROM MgServiciosDomiciliacionUap m WHERE m.estado = :estado")
    , @NamedQuery(name = "MgServiciosDomiciliacionUap.findByAdicionadoPor", query = "SELECT m FROM MgServiciosDomiciliacionUap m WHERE m.adicionadoPor = :adicionadoPor")
    , @NamedQuery(name = "MgServiciosDomiciliacionUap.findByFechaAdicion", query = "SELECT m FROM MgServiciosDomiciliacionUap m WHERE m.fechaAdicion = :fechaAdicion")
    , @NamedQuery(name = "MgServiciosDomiciliacionUap.findByModificadoPor", query = "SELECT m FROM MgServiciosDomiciliacionUap m WHERE m.modificadoPor = :modificadoPor")
    , @NamedQuery(name = "MgServiciosDomiciliacionUap.findByFechaModificacion", query = "SELECT m FROM MgServiciosDomiciliacionUap m WHERE m.fechaModificacion = :fechaModificacion")})
public class MgServiciosDomiciliacionUap implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "REFERENCIA_ORDENANTE")
    private String referenciaOrdenante;
    @Size(max = 60)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 1)
    @Column(name = "ESTADO")
    private String estado;
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

    public MgServiciosDomiciliacionUap() {
    }

    public MgServiciosDomiciliacionUap(String referenciaOrdenante) {
        this.referenciaOrdenante = referenciaOrdenante;
    }

    public String getReferenciaOrdenante() {
        return referenciaOrdenante;
    }

    public void setReferenciaOrdenante(String referenciaOrdenante) {
        this.referenciaOrdenante = referenciaOrdenante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        hash += (referenciaOrdenante != null ? referenciaOrdenante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MgServiciosDomiciliacionUap)) {
            return false;
        }
        MgServiciosDomiciliacionUap other = (MgServiciosDomiciliacionUap) object;
        if ((this.referenciaOrdenante == null && other.referenciaOrdenante != null) || (this.referenciaOrdenante != null && !this.referenciaOrdenante.equals(other.referenciaOrdenante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.MgServiciosDomiciliacionUap[ referenciaOrdenante=" + referenciaOrdenante + " ]";
    }
    
}
