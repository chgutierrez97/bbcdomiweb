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

/**
 *
 * @author Christian Gutierrez
 */
@Embeddable
public class MgAfiliacionesPresentadasPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "CODIGO_ORDENANTE")
    private String codigoOrdenante;
    @Basic(optional = false)
    @Column(name = "CLAVE_ORDENANTE")
    private String claveOrdenante;

    public MgAfiliacionesPresentadasPK() {
    }

    public MgAfiliacionesPresentadasPK(String codigoOrdenante, String claveOrdenante) {
        this.codigoOrdenante = codigoOrdenante;
        this.claveOrdenante = claveOrdenante;
    }

    public String getCodigoOrdenante() {
        return codigoOrdenante;
    }

    public void setCodigoOrdenante(String codigoOrdenante) {
        this.codigoOrdenante = codigoOrdenante;
    }

    public String getClaveOrdenante() {
        return claveOrdenante;
    }

    public void setClaveOrdenante(String claveOrdenante) {
        this.claveOrdenante = claveOrdenante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoOrdenante != null ? codigoOrdenante.hashCode() : 0);
        hash += (claveOrdenante != null ? claveOrdenante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MgAfiliacionesPresentadasPK)) {
            return false;
        }
        MgAfiliacionesPresentadasPK other = (MgAfiliacionesPresentadasPK) object;
        if ((this.codigoOrdenante == null && other.codigoOrdenante != null) || (this.codigoOrdenante != null && !this.codigoOrdenante.equals(other.codigoOrdenante))) {
            return false;
        }
        if ((this.claveOrdenante == null && other.claveOrdenante != null) || (this.claveOrdenante != null && !this.claveOrdenante.equals(other.claveOrdenante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication11.model.MgAfiliacionesPresentadasPK[ codigoOrdenante=" + codigoOrdenante + ", claveOrdenante=" + claveOrdenante + " ]";
    }
    
}
