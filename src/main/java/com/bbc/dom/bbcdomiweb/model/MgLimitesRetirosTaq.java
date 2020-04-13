/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "MG_LIMITES_RETIROS_TAQ")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MgLimitesRetirosTaq.findAll", query = "SELECT m FROM MgLimitesRetirosTaq m")
    , @NamedQuery(name = "MgLimitesRetirosTaq.findByCodigoCategoria", query = "SELECT m FROM MgLimitesRetirosTaq m WHERE m.codigoCategoria = :codigoCategoria")
    , @NamedQuery(name = "MgLimitesRetirosTaq.findByLimiteDiario", query = "SELECT m FROM MgLimitesRetirosTaq m WHERE m.limiteDiario = :limiteDiario")
    , @NamedQuery(name = "MgLimitesRetirosTaq.findByLimiteSemanal", query = "SELECT m FROM MgLimitesRetirosTaq m WHERE m.limiteSemanal = :limiteSemanal")
    , @NamedQuery(name = "MgLimitesRetirosTaq.findByLimiteMensual", query = "SELECT m FROM MgLimitesRetirosTaq m WHERE m.limiteMensual = :limiteMensual")
    , @NamedQuery(name = "MgLimitesRetirosTaq.findByFechaAdicion", query = "SELECT m FROM MgLimitesRetirosTaq m WHERE m.fechaAdicion = :fechaAdicion")
    , @NamedQuery(name = "MgLimitesRetirosTaq.findByAdicionadoPor", query = "SELECT m FROM MgLimitesRetirosTaq m WHERE m.adicionadoPor = :adicionadoPor")
    , @NamedQuery(name = "MgLimitesRetirosTaq.findByModificadoPor", query = "SELECT m FROM MgLimitesRetirosTaq m WHERE m.modificadoPor = :modificadoPor")
    , @NamedQuery(name = "MgLimitesRetirosTaq.findByFechaModificacion", query = "SELECT m FROM MgLimitesRetirosTaq m WHERE m.fechaModificacion = :fechaModificacion")})
public class MgLimitesRetirosTaq implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_CATEGORIA")
    private Short codigoCategoria;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "LIMITE_DIARIO")
    private BigDecimal limiteDiario;
    @Column(name = "LIMITE_SEMANAL")
    private BigDecimal limiteSemanal;
    @Column(name = "LIMITE_MENSUAL")
    private BigDecimal limiteMensual;
    @Column(name = "FECHA_ADICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAdicion;
    @Size(max = 10)
    @Column(name = "ADICIONADO_POR")
    private String adicionadoPor;
    @Size(max = 10)
    @Column(name = "MODIFICADO_POR")
    private String modificadoPor;
    @Column(name = "FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    public MgLimitesRetirosTaq() {
    }

    public MgLimitesRetirosTaq(Short codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public Short getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(Short codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public BigDecimal getLimiteDiario() {
        return limiteDiario;
    }

    public void setLimiteDiario(BigDecimal limiteDiario) {
        this.limiteDiario = limiteDiario;
    }

    public BigDecimal getLimiteSemanal() {
        return limiteSemanal;
    }

    public void setLimiteSemanal(BigDecimal limiteSemanal) {
        this.limiteSemanal = limiteSemanal;
    }

    public BigDecimal getLimiteMensual() {
        return limiteMensual;
    }

    public void setLimiteMensual(BigDecimal limiteMensual) {
        this.limiteMensual = limiteMensual;
    }

    public Date getFechaAdicion() {
        return fechaAdicion;
    }

    public void setFechaAdicion(Date fechaAdicion) {
        this.fechaAdicion = fechaAdicion;
    }

    public String getAdicionadoPor() {
        return adicionadoPor;
    }

    public void setAdicionadoPor(String adicionadoPor) {
        this.adicionadoPor = adicionadoPor;
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
        hash += (codigoCategoria != null ? codigoCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MgLimitesRetirosTaq)) {
            return false;
        }
        MgLimitesRetirosTaq other = (MgLimitesRetirosTaq) object;
        if ((this.codigoCategoria == null && other.codigoCategoria != null) || (this.codigoCategoria != null && !this.codigoCategoria.equals(other.codigoCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.MgLimitesRetirosTaq[ codigoCategoria=" + codigoCategoria + " ]";
    }
    
}
