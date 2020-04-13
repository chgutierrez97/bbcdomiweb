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
public class MgEmpresasAfiliadasUapPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "BANCO_EMISOR")
    private String bancoEmisor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "REFERENCIA_ORDENANTE")
    private String referenciaOrdenante;

    public MgEmpresasAfiliadasUapPK() {
    }

    public MgEmpresasAfiliadasUapPK(String bancoEmisor, String referenciaOrdenante) {
        this.bancoEmisor = bancoEmisor;
        this.referenciaOrdenante = referenciaOrdenante;
    }

    public String getBancoEmisor() {
        return bancoEmisor;
    }

    public void setBancoEmisor(String bancoEmisor) {
        this.bancoEmisor = bancoEmisor;
    }

    public String getReferenciaOrdenante() {
        return referenciaOrdenante;
    }

    public void setReferenciaOrdenante(String referenciaOrdenante) {
        this.referenciaOrdenante = referenciaOrdenante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bancoEmisor != null ? bancoEmisor.hashCode() : 0);
        hash += (referenciaOrdenante != null ? referenciaOrdenante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MgEmpresasAfiliadasUapPK)) {
            return false;
        }
        MgEmpresasAfiliadasUapPK other = (MgEmpresasAfiliadasUapPK) object;
        if ((this.bancoEmisor == null && other.bancoEmisor != null) || (this.bancoEmisor != null && !this.bancoEmisor.equals(other.bancoEmisor))) {
            return false;
        }
        if ((this.referenciaOrdenante == null && other.referenciaOrdenante != null) || (this.referenciaOrdenante != null && !this.referenciaOrdenante.equals(other.referenciaOrdenante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.MgEmpresasAfiliadasUapPK[ bancoEmisor=" + bancoEmisor + ", referenciaOrdenante=" + referenciaOrdenante + " ]";
    }
    
}
