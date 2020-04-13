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
@Table(name = "MG_TABLAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MgTablas.findAll", query = "SELECT m FROM MgTablas m")
    , @NamedQuery(name = "MgTablas.findByCodigoTabla", query = "SELECT m FROM MgTablas m WHERE m.codigoTabla = :codigoTabla")
    , @NamedQuery(name = "MgTablas.findByNombreTabla", query = "SELECT m FROM MgTablas m WHERE m.nombreTabla = :nombreTabla")
    , @NamedQuery(name = "MgTablas.findByTablaAbanks", query = "SELECT m FROM MgTablas m WHERE m.tablaAbanks = :tablaAbanks")
    , @NamedQuery(name = "MgTablas.findByAdicionadoPor", query = "SELECT m FROM MgTablas m WHERE m.adicionadoPor = :adicionadoPor")
    , @NamedQuery(name = "MgTablas.findByFechaAdicion", query = "SELECT m FROM MgTablas m WHERE m.fechaAdicion = :fechaAdicion")
    , @NamedQuery(name = "MgTablas.findByModificadoPor", query = "SELECT m FROM MgTablas m WHERE m.modificadoPor = :modificadoPor")
    , @NamedQuery(name = "MgTablas.findByFechaModificacion", query = "SELECT m FROM MgTablas m WHERE m.fechaModificacion = :fechaModificacion")})
public class MgTablas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CODIGO_TABLA")
    private String codigoTabla;
    @Size(max = 120)
    @Column(name = "NOMBRE_TABLA")
    private String nombreTabla;
    @Size(max = 120)
    @Column(name = "TABLA_ABANKS")
    private String tablaAbanks;
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

    public MgTablas() {
    }

    public MgTablas(String codigoTabla) {
        this.codigoTabla = codigoTabla;
    }

    public String getCodigoTabla() {
        return codigoTabla;
    }

    public void setCodigoTabla(String codigoTabla) {
        this.codigoTabla = codigoTabla;
    }

    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    public String getTablaAbanks() {
        return tablaAbanks;
    }

    public void setTablaAbanks(String tablaAbanks) {
        this.tablaAbanks = tablaAbanks;
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
        hash += (codigoTabla != null ? codigoTabla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MgTablas)) {
            return false;
        }
        MgTablas other = (MgTablas) object;
        if ((this.codigoTabla == null && other.codigoTabla != null) || (this.codigoTabla != null && !this.codigoTabla.equals(other.codigoTabla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.MgTablas[ codigoTabla=" + codigoTabla + " ]";
    }
    
}
