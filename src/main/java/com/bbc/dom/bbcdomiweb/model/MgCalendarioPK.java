/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Christian Gutierrez
 */
@Embeddable
public class MgCalendarioPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_EMPRESA")
    private short codigoEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CODIGO_APLICACION")
    private String codigoAplicacion;

    public MgCalendarioPK() {
    }

    public MgCalendarioPK(short codigoEmpresa, String codigoAplicacion) {
        this.codigoEmpresa = codigoEmpresa;
        this.codigoAplicacion = codigoAplicacion;
    }

    public short getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public void setCodigoEmpresa(short codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    public String getCodigoAplicacion() {
        return codigoAplicacion;
    }

    public void setCodigoAplicacion(String codigoAplicacion) {
        this.codigoAplicacion = codigoAplicacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoEmpresa;
        hash += (codigoAplicacion != null ? codigoAplicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MgCalendarioPK)) {
            return false;
        }
        MgCalendarioPK other = (MgCalendarioPK) object;
        if (this.codigoEmpresa != other.codigoEmpresa) {
            return false;
        }
        if ((this.codigoAplicacion == null && other.codigoAplicacion != null) || (this.codigoAplicacion != null && !this.codigoAplicacion.equals(other.codigoAplicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.MgCalendarioPK[ codigoEmpresa=" + codigoEmpresa + ", codigoAplicacion=" + codigoAplicacion + " ]";
    }
    
}
