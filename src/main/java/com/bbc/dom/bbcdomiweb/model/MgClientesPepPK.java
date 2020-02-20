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
public class MgClientesPepPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_CLIENTE")
    private long codigoCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_TIPO_PEP")
    private short codigoTipoPep;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NUMERO_IDENTIF_PEP")
    private String numeroIdentifPep;

    public MgClientesPepPK() {
    }

    public MgClientesPepPK(long codigoCliente, short codigoTipoPep, String numeroIdentifPep) {
        this.codigoCliente = codigoCliente;
        this.codigoTipoPep = codigoTipoPep;
        this.numeroIdentifPep = numeroIdentifPep;
    }

    public long getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(long codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public short getCodigoTipoPep() {
        return codigoTipoPep;
    }

    public void setCodigoTipoPep(short codigoTipoPep) {
        this.codigoTipoPep = codigoTipoPep;
    }

    public String getNumeroIdentifPep() {
        return numeroIdentifPep;
    }

    public void setNumeroIdentifPep(String numeroIdentifPep) {
        this.numeroIdentifPep = numeroIdentifPep;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoCliente;
        hash += (int) codigoTipoPep;
        hash += (numeroIdentifPep != null ? numeroIdentifPep.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MgClientesPepPK)) {
            return false;
        }
        MgClientesPepPK other = (MgClientesPepPK) object;
        if (this.codigoCliente != other.codigoCliente) {
            return false;
        }
        if (this.codigoTipoPep != other.codigoTipoPep) {
            return false;
        }
        if ((this.numeroIdentifPep == null && other.numeroIdentifPep != null) || (this.numeroIdentifPep != null && !this.numeroIdentifPep.equals(other.numeroIdentifPep))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.MgClientesPepPK[ codigoCliente=" + codigoCliente + ", codigoTipoPep=" + codigoTipoPep + ", numeroIdentifPep=" + numeroIdentifPep + " ]";
    }
    
}
