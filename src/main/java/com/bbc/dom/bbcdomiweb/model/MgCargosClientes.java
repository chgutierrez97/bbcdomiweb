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
@Table(name = "MG_CARGOS_CLIENTES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MgCargosClientes.findAll", query = "SELECT m FROM MgCargosClientes m")
    , @NamedQuery(name = "MgCargosClientes.findByCodigoDelCargo", query = "SELECT m FROM MgCargosClientes m WHERE m.codigoDelCargo = :codigoDelCargo")
    , @NamedQuery(name = "MgCargosClientes.findByDescripcionDelCargo", query = "SELECT m FROM MgCargosClientes m WHERE m.descripcionDelCargo = :descripcionDelCargo")
    , @NamedQuery(name = "MgCargosClientes.findByAdicionadoPor", query = "SELECT m FROM MgCargosClientes m WHERE m.adicionadoPor = :adicionadoPor")
    , @NamedQuery(name = "MgCargosClientes.findByFechaAdicion", query = "SELECT m FROM MgCargosClientes m WHERE m.fechaAdicion = :fechaAdicion")
    , @NamedQuery(name = "MgCargosClientes.findByModificadoPor", query = "SELECT m FROM MgCargosClientes m WHERE m.modificadoPor = :modificadoPor")
    , @NamedQuery(name = "MgCargosClientes.findByFechaModificacion", query = "SELECT m FROM MgCargosClientes m WHERE m.fechaModificacion = :fechaModificacion")})
public class MgCargosClientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_DEL_CARGO")
    private Short codigoDelCargo;
    @Size(max = 30)
    @Column(name = "DESCRIPCION_DEL_CARGO")
    private String descripcionDelCargo;
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

    public MgCargosClientes() {
    }

    public MgCargosClientes(Short codigoDelCargo) {
        this.codigoDelCargo = codigoDelCargo;
    }

    public Short getCodigoDelCargo() {
        return codigoDelCargo;
    }

    public void setCodigoDelCargo(Short codigoDelCargo) {
        this.codigoDelCargo = codigoDelCargo;
    }

    public String getDescripcionDelCargo() {
        return descripcionDelCargo;
    }

    public void setDescripcionDelCargo(String descripcionDelCargo) {
        this.descripcionDelCargo = descripcionDelCargo;
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
        hash += (codigoDelCargo != null ? codigoDelCargo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MgCargosClientes)) {
            return false;
        }
        MgCargosClientes other = (MgCargosClientes) object;
        if ((this.codigoDelCargo == null && other.codigoDelCargo != null) || (this.codigoDelCargo != null && !this.codigoDelCargo.equals(other.codigoDelCargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.MgCargosClientes[ codigoDelCargo=" + codigoDelCargo + " ]";
    }
    
}
