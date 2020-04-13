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
@Table(name = "MG_EMPRESAS_AFILIADAS_UAP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MgEmpresasAfiliadasUap.findAll", query = "SELECT m FROM MgEmpresasAfiliadasUap m")
    , @NamedQuery(name = "MgEmpresasAfiliadasUap.findByBancoEmisor", query = "SELECT m FROM MgEmpresasAfiliadasUap m WHERE m.mgEmpresasAfiliadasUapPK.bancoEmisor = :bancoEmisor")
    , @NamedQuery(name = "MgEmpresasAfiliadasUap.findByReferenciaOrdenante", query = "SELECT m FROM MgEmpresasAfiliadasUap m WHERE m.mgEmpresasAfiliadasUapPK.referenciaOrdenante = :referenciaOrdenante")
    , @NamedQuery(name = "MgEmpresasAfiliadasUap.findByRazonSocial", query = "SELECT m FROM MgEmpresasAfiliadasUap m WHERE m.razonSocial = :razonSocial")
    , @NamedQuery(name = "MgEmpresasAfiliadasUap.findByEstado", query = "SELECT m FROM MgEmpresasAfiliadasUap m WHERE m.estado = :estado")
    , @NamedQuery(name = "MgEmpresasAfiliadasUap.findByAdicionadoPor", query = "SELECT m FROM MgEmpresasAfiliadasUap m WHERE m.adicionadoPor = :adicionadoPor")
    , @NamedQuery(name = "MgEmpresasAfiliadasUap.findByFechaAdicion", query = "SELECT m FROM MgEmpresasAfiliadasUap m WHERE m.fechaAdicion = :fechaAdicion")
    , @NamedQuery(name = "MgEmpresasAfiliadasUap.findByModificadoPor", query = "SELECT m FROM MgEmpresasAfiliadasUap m WHERE m.modificadoPor = :modificadoPor")
    , @NamedQuery(name = "MgEmpresasAfiliadasUap.findByFechaModificacion", query = "SELECT m FROM MgEmpresasAfiliadasUap m WHERE m.fechaModificacion = :fechaModificacion")})
public class MgEmpresasAfiliadasUap implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MgEmpresasAfiliadasUapPK mgEmpresasAfiliadasUapPK;
    @Size(max = 35)
    @Column(name = "RAZON_SOCIAL")
    private String razonSocial;
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

    public MgEmpresasAfiliadasUap() {
    }

    public MgEmpresasAfiliadasUap(MgEmpresasAfiliadasUapPK mgEmpresasAfiliadasUapPK) {
        this.mgEmpresasAfiliadasUapPK = mgEmpresasAfiliadasUapPK;
    }

    public MgEmpresasAfiliadasUap(String bancoEmisor, String referenciaOrdenante) {
        this.mgEmpresasAfiliadasUapPK = new MgEmpresasAfiliadasUapPK(bancoEmisor, referenciaOrdenante);
    }

    public MgEmpresasAfiliadasUapPK getMgEmpresasAfiliadasUapPK() {
        return mgEmpresasAfiliadasUapPK;
    }

    public void setMgEmpresasAfiliadasUapPK(MgEmpresasAfiliadasUapPK mgEmpresasAfiliadasUapPK) {
        this.mgEmpresasAfiliadasUapPK = mgEmpresasAfiliadasUapPK;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
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
        hash += (mgEmpresasAfiliadasUapPK != null ? mgEmpresasAfiliadasUapPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MgEmpresasAfiliadasUap)) {
            return false;
        }
        MgEmpresasAfiliadasUap other = (MgEmpresasAfiliadasUap) object;
        if ((this.mgEmpresasAfiliadasUapPK == null && other.mgEmpresasAfiliadasUapPK != null) || (this.mgEmpresasAfiliadasUapPK != null && !this.mgEmpresasAfiliadasUapPK.equals(other.mgEmpresasAfiliadasUapPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.MgEmpresasAfiliadasUap[ mgEmpresasAfiliadasUapPK=" + mgEmpresasAfiliadasUapPK + " ]";
    }
    
}
