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
@Table(name = "MG_ARCHIVOS_CONSOLIDADOS_UAP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MgArchivosConsolidadosUap.findAll", query = "SELECT m FROM MgArchivosConsolidadosUap m")
    , @NamedQuery(name = "MgArchivosConsolidadosUap.findByConsecutivo", query = "SELECT m FROM MgArchivosConsolidadosUap m WHERE m.mgArchivosConsolidadosUapPK.consecutivo = :consecutivo")
    , @NamedQuery(name = "MgArchivosConsolidadosUap.findByFechaValida", query = "SELECT m FROM MgArchivosConsolidadosUap m WHERE m.mgArchivosConsolidadosUapPK.fechaValida = :fechaValida")
    , @NamedQuery(name = "MgArchivosConsolidadosUap.findByArchivoDesde", query = "SELECT m FROM MgArchivosConsolidadosUap m WHERE m.archivoDesde = :archivoDesde")
    , @NamedQuery(name = "MgArchivosConsolidadosUap.findByArchivoHasta", query = "SELECT m FROM MgArchivosConsolidadosUap m WHERE m.archivoHasta = :archivoHasta")
    , @NamedQuery(name = "MgArchivosConsolidadosUap.findByTipoArchivo", query = "SELECT m FROM MgArchivosConsolidadosUap m WHERE m.tipoArchivo = :tipoArchivo")
    , @NamedQuery(name = "MgArchivosConsolidadosUap.findByFechaAdicion", query = "SELECT m FROM MgArchivosConsolidadosUap m WHERE m.fechaAdicion = :fechaAdicion")
    , @NamedQuery(name = "MgArchivosConsolidadosUap.findByUsuarioAdicion", query = "SELECT m FROM MgArchivosConsolidadosUap m WHERE m.usuarioAdicion = :usuarioAdicion")
    , @NamedQuery(name = "MgArchivosConsolidadosUap.findByFechaModificacion", query = "SELECT m FROM MgArchivosConsolidadosUap m WHERE m.fechaModificacion = :fechaModificacion")
    , @NamedQuery(name = "MgArchivosConsolidadosUap.findByUsuarioModificacion", query = "SELECT m FROM MgArchivosConsolidadosUap m WHERE m.usuarioModificacion = :usuarioModificacion")})
public class MgArchivosConsolidadosUap implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MgArchivosConsolidadosUapPK mgArchivosConsolidadosUapPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "ARCHIVO_DESDE")
    private String archivoDesde;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "ARCHIVO_HASTA")
    private String archivoHasta;
    @Column(name = "TIPO_ARCHIVO")
    private Short tipoArchivo;
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

    public MgArchivosConsolidadosUap() {
    }

    public MgArchivosConsolidadosUap(MgArchivosConsolidadosUapPK mgArchivosConsolidadosUapPK) {
        this.mgArchivosConsolidadosUapPK = mgArchivosConsolidadosUapPK;
    }

    public MgArchivosConsolidadosUap(MgArchivosConsolidadosUapPK mgArchivosConsolidadosUapPK, String archivoDesde, String archivoHasta) {
        this.mgArchivosConsolidadosUapPK = mgArchivosConsolidadosUapPK;
        this.archivoDesde = archivoDesde;
        this.archivoHasta = archivoHasta;
    }

    public MgArchivosConsolidadosUap(long consecutivo, String fechaValida) {
        this.mgArchivosConsolidadosUapPK = new MgArchivosConsolidadosUapPK(consecutivo, fechaValida);
    }

    public MgArchivosConsolidadosUapPK getMgArchivosConsolidadosUapPK() {
        return mgArchivosConsolidadosUapPK;
    }

    public void setMgArchivosConsolidadosUapPK(MgArchivosConsolidadosUapPK mgArchivosConsolidadosUapPK) {
        this.mgArchivosConsolidadosUapPK = mgArchivosConsolidadosUapPK;
    }

    public String getArchivoDesde() {
        return archivoDesde;
    }

    public void setArchivoDesde(String archivoDesde) {
        this.archivoDesde = archivoDesde;
    }

    public String getArchivoHasta() {
        return archivoHasta;
    }

    public void setArchivoHasta(String archivoHasta) {
        this.archivoHasta = archivoHasta;
    }

    public Short getTipoArchivo() {
        return tipoArchivo;
    }

    public void setTipoArchivo(Short tipoArchivo) {
        this.tipoArchivo = tipoArchivo;
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
        hash += (mgArchivosConsolidadosUapPK != null ? mgArchivosConsolidadosUapPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MgArchivosConsolidadosUap)) {
            return false;
        }
        MgArchivosConsolidadosUap other = (MgArchivosConsolidadosUap) object;
        if ((this.mgArchivosConsolidadosUapPK == null && other.mgArchivosConsolidadosUapPK != null) || (this.mgArchivosConsolidadosUapPK != null && !this.mgArchivosConsolidadosUapPK.equals(other.mgArchivosConsolidadosUapPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.MgArchivosConsolidadosUap[ mgArchivosConsolidadosUapPK=" + mgArchivosConsolidadosUapPK + " ]";
    }
    
}
