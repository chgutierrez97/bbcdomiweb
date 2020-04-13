/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Christian Gutierrez
 */
@Entity
@Table(name = "MG_CONSUMO_RETIROS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MgConsumoRetiros.findAll", query = "SELECT m FROM MgConsumoRetiros m")
    , @NamedQuery(name = "MgConsumoRetiros.findBySecuenciaMovimiento", query = "SELECT m FROM MgConsumoRetiros m WHERE m.mgConsumoRetirosPK.secuenciaMovimiento = :secuenciaMovimiento")
    , @NamedQuery(name = "MgConsumoRetiros.findByFechaValida", query = "SELECT m FROM MgConsumoRetiros m WHERE m.mgConsumoRetirosPK.fechaValida = :fechaValida")
    , @NamedQuery(name = "MgConsumoRetiros.findByNumeroCuenta", query = "SELECT m FROM MgConsumoRetiros m WHERE m.numeroCuenta = :numeroCuenta")
    , @NamedQuery(name = "MgConsumoRetiros.findByCodigoCliente", query = "SELECT m FROM MgConsumoRetiros m WHERE m.codigoCliente = :codigoCliente")
    , @NamedQuery(name = "MgConsumoRetiros.findByMonto", query = "SELECT m FROM MgConsumoRetiros m WHERE m.monto = :monto")
    , @NamedQuery(name = "MgConsumoRetiros.findByHora", query = "SELECT m FROM MgConsumoRetiros m WHERE m.hora = :hora")})
public class MgConsumoRetiros implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MgConsumoRetirosPK mgConsumoRetirosPK;
    @Column(name = "NUMERO_CUENTA")
    private Long numeroCuenta;
    @Column(name = "CODIGO_CLIENTE")
    private Long codigoCliente;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MONTO")
    private BigDecimal monto;
    @Column(name = "HORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hora;

    public MgConsumoRetiros() {
    }

    public MgConsumoRetiros(MgConsumoRetirosPK mgConsumoRetirosPK) {
        this.mgConsumoRetirosPK = mgConsumoRetirosPK;
    }

    public MgConsumoRetiros(long secuenciaMovimiento, Date fechaValida) {
        this.mgConsumoRetirosPK = new MgConsumoRetirosPK(secuenciaMovimiento, fechaValida);
    }

    public MgConsumoRetirosPK getMgConsumoRetirosPK() {
        return mgConsumoRetirosPK;
    }

    public void setMgConsumoRetirosPK(MgConsumoRetirosPK mgConsumoRetirosPK) {
        this.mgConsumoRetirosPK = mgConsumoRetirosPK;
    }

    public Long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Long getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Long codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mgConsumoRetirosPK != null ? mgConsumoRetirosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MgConsumoRetiros)) {
            return false;
        }
        MgConsumoRetiros other = (MgConsumoRetiros) object;
        if ((this.mgConsumoRetirosPK == null && other.mgConsumoRetirosPK != null) || (this.mgConsumoRetirosPK != null && !this.mgConsumoRetirosPK.equals(other.mgConsumoRetirosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.MgConsumoRetiros[ mgConsumoRetirosPK=" + mgConsumoRetirosPK + " ]";
    }
    
}
