/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.model;

import java.io.Serializable;
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
@Table(name = "MG_ARCHIVOS_UAP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MgArchivosUap.findAll", query = "SELECT m FROM MgArchivosUap m")
    , @NamedQuery(name = "MgArchivosUap.findByFechaValida", query = "SELECT m FROM MgArchivosUap m WHERE m.mgArchivosUapPK.fechaValida = :fechaValida")
    , @NamedQuery(name = "MgArchivosUap.findByNombreArchivo", query = "SELECT m FROM MgArchivosUap m WHERE m.mgArchivosUapPK.nombreArchivo = :nombreArchivo")
    , @NamedQuery(name = "MgArchivosUap.findByTipoArchivo", query = "SELECT m FROM MgArchivosUap m WHERE m.mgArchivosUapPK.tipoArchivo = :tipoArchivo")
    , @NamedQuery(name = "MgArchivosUap.findByFechaAdicion", query = "SELECT m FROM MgArchivosUap m WHERE m.fechaAdicion = :fechaAdicion")
    , @NamedQuery(name = "MgArchivosUap.findByUsuarioAdicion", query = "SELECT m FROM MgArchivosUap m WHERE m.usuarioAdicion = :usuarioAdicion")
    , @NamedQuery(name = "MgArchivosUap.findByFechaModificacion", query = "SELECT m FROM MgArchivosUap m WHERE m.fechaModificacion = :fechaModificacion")
    , @NamedQuery(name = "MgArchivosUap.findByUsuarioModificacion", query = "SELECT m FROM MgArchivosUap m WHERE m.usuarioModificacion = :usuarioModificacion")})
public class MgArchivosUap implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MgArchivosUapPK mgArchivosUapPK;
    @Column(name = "FECHA_ADICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAdicion;
    @Size(max = 10)
    @Column(name = "USUARIO_ADICION")
    private String usuarioAdicion;
    @Column(name = "FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Size(max = 10)
    @Column(name = "USUARIO_MODIFICACION")
    private String usuarioModificacion;

    public MgArchivosUap() {
    }

    public MgArchivosUap(MgArchivosUapPK mgArchivosUapPK) {
        this.mgArchivosUapPK = mgArchivosUapPK;
    }

    public MgArchivosUap(Date fechaValida, String nombreArchivo, short tipoArchivo) {
        this.mgArchivosUapPK = new MgArchivosUapPK(fechaValida, nombreArchivo, tipoArchivo);
    }

    public MgArchivosUapPK getMgArchivosUapPK() {
        return mgArchivosUapPK;
    }

    public void setMgArchivosUapPK(MgArchivosUapPK mgArchivosUapPK) {
        this.mgArchivosUapPK = mgArchivosUapPK;
    }

    public Date getFechaAdicion() {
        return fechaAdicion;
    }

    public void setFechaAdicion(Date fechaAdicion) {
        this.fechaAdicion = fechaAdicion;
    }

    public String getUsuarioAdicion() {
        return usuarioAdicion;
    }

    public void setUsuarioAdicion(String usuarioAdicion) {
        this.usuarioAdicion = usuarioAdicion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mgArchivosUapPK != null ? mgArchivosUapPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MgArchivosUap)) {
            return false;
        }
        MgArchivosUap other = (MgArchivosUap) object;
        if ((this.mgArchivosUapPK == null && other.mgArchivosUapPK != null) || (this.mgArchivosUapPK != null && !this.mgArchivosUapPK.equals(other.mgArchivosUapPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.MgArchivosUap[ mgArchivosUapPK=" + mgArchivosUapPK + " ]";
    }
    
}
