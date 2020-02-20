/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Christian Gutierrez
 */
@Entity
@Table(name = "MG_MSN_RECHAZO_DOMICILIA_UAP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MgMsnRechazoDomiciliaUap.findAll", query = "SELECT m FROM MgMsnRechazoDomiciliaUap m")
    , @NamedQuery(name = "MgMsnRechazoDomiciliaUap.findByCodigoRechazo", query = "SELECT m FROM MgMsnRechazoDomiciliaUap m WHERE m.codigoRechazo = :codigoRechazo")
    , @NamedQuery(name = "MgMsnRechazoDomiciliaUap.findByDescripcion", query = "SELECT m FROM MgMsnRechazoDomiciliaUap m WHERE m.descripcion = :descripcion")
    , @NamedQuery(name = "MgMsnRechazoDomiciliaUap.findByTipoValidacion", query = "SELECT m FROM MgMsnRechazoDomiciliaUap m WHERE m.tipoValidacion = :tipoValidacion")
    , @NamedQuery(name = "MgMsnRechazoDomiciliaUap.findByEstado", query = "SELECT m FROM MgMsnRechazoDomiciliaUap m WHERE m.estado = :estado")
    , @NamedQuery(name = "MgMsnRechazoDomiciliaUap.findByAdicionadoPor", query = "SELECT m FROM MgMsnRechazoDomiciliaUap m WHERE m.adicionadoPor = :adicionadoPor")
    , @NamedQuery(name = "MgMsnRechazoDomiciliaUap.findByFechaAdicion", query = "SELECT m FROM MgMsnRechazoDomiciliaUap m WHERE m.fechaAdicion = :fechaAdicion")
    , @NamedQuery(name = "MgMsnRechazoDomiciliaUap.findByModificadoPor", query = "SELECT m FROM MgMsnRechazoDomiciliaUap m WHERE m.modificadoPor = :modificadoPor")
    , @NamedQuery(name = "MgMsnRechazoDomiciliaUap.findByFechaModificacion", query = "SELECT m FROM MgMsnRechazoDomiciliaUap m WHERE m.fechaModificacion = :fechaModificacion")})
public class MgMsnRechazoDomiciliaUap implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CODIGO_RECHAZO")
    private String codigoRechazo;
    @Size(max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 1)
    @Column(name = "TIPO_VALIDACION")
    private String tipoValidacion;
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
    @OneToMany(mappedBy = "codigoRechazo")
    private Collection<MgDetArchivosDomiciliaUap> mgDetArchivosDomiciliaUapCollection;
    @OneToMany(mappedBy = "codigoRechazo")
    private Collection<MgArchivosDomiciliaUap> mgArchivosDomiciliaUapCollection;

    public MgMsnRechazoDomiciliaUap() {
    }

    public MgMsnRechazoDomiciliaUap(String codigoRechazo) {
        this.codigoRechazo = codigoRechazo;
    }

    public String getCodigoRechazo() {
        return codigoRechazo;
    }

    public void setCodigoRechazo(String codigoRechazo) {
        this.codigoRechazo = codigoRechazo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoValidacion() {
        return tipoValidacion;
    }

    public void setTipoValidacion(String tipoValidacion) {
        this.tipoValidacion = tipoValidacion;
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

    @XmlTransient
    public Collection<MgDetArchivosDomiciliaUap> getMgDetArchivosDomiciliaUapCollection() {
        return mgDetArchivosDomiciliaUapCollection;
    }

    public void setMgDetArchivosDomiciliaUapCollection(Collection<MgDetArchivosDomiciliaUap> mgDetArchivosDomiciliaUapCollection) {
        this.mgDetArchivosDomiciliaUapCollection = mgDetArchivosDomiciliaUapCollection;
    }

    @XmlTransient
    public Collection<MgArchivosDomiciliaUap> getMgArchivosDomiciliaUapCollection() {
        return mgArchivosDomiciliaUapCollection;
    }

    public void setMgArchivosDomiciliaUapCollection(Collection<MgArchivosDomiciliaUap> mgArchivosDomiciliaUapCollection) {
        this.mgArchivosDomiciliaUapCollection = mgArchivosDomiciliaUapCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoRechazo != null ? codigoRechazo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MgMsnRechazoDomiciliaUap)) {
            return false;
        }
        MgMsnRechazoDomiciliaUap other = (MgMsnRechazoDomiciliaUap) object;
        if ((this.codigoRechazo == null && other.codigoRechazo != null) || (this.codigoRechazo != null && !this.codigoRechazo.equals(other.codigoRechazo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.MgMsnRechazoDomiciliaUap[ codigoRechazo=" + codigoRechazo + " ]";
    }
    
}
