/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.model;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Christian Gutierrez
 */
@Entity
@Table(name = "IB_SUMARIO_AFILIACIONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IbSumarioAfiliaciones.findAll", query = "SELECT i FROM IbSumarioAfiliaciones i")
    , @NamedQuery(name = "IbSumarioAfiliaciones.findById", query = "SELECT i FROM IbSumarioAfiliaciones i WHERE i.id = :id")
    , @NamedQuery(name = "IbSumarioAfiliaciones.findByCodigoOrdenante", query = "SELECT i FROM IbSumarioAfiliaciones i WHERE i.codigoOrdenante = :codigoOrdenante")
    , @NamedQuery(name = "IbSumarioAfiliaciones.findByNombreArchivo", query = "SELECT i FROM IbSumarioAfiliaciones i WHERE i.nombreArchivo = :nombreArchivo")
    , @NamedQuery(name = "IbSumarioAfiliaciones.findByNroRegistrosProcesar", query = "SELECT i FROM IbSumarioAfiliaciones i WHERE i.nroRegistrosProcesar = :nroRegistrosProcesar")
    , @NamedQuery(name = "IbSumarioAfiliaciones.findByNroRegistrosRechazados", query = "SELECT i FROM IbSumarioAfiliaciones i WHERE i.nroRegistrosRechazados = :nroRegistrosRechazados")
    , @NamedQuery(name = "IbSumarioAfiliaciones.findByNroRegistrosValidados", query = "SELECT i FROM IbSumarioAfiliaciones i WHERE i.nroRegistrosValidados = :nroRegistrosValidados")
    , @NamedQuery(name = "IbSumarioAfiliaciones.findByFechaHoraCarga", query = "SELECT i FROM IbSumarioAfiliaciones i WHERE i.fechaHoraCarga = :fechaHoraCarga")
    , @NamedQuery(name = "IbSumarioAfiliaciones.findByEstatusCargar", query = "SELECT i FROM IbSumarioAfiliaciones i WHERE i.estatusCargar = :estatusCargar")})

public class IbSumarioAfiliaciones implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "ID", nullable = true, unique = true)
    private Long id;
    @Column(name = "CODIGO_ORDENANTE")
    private Long codigoOrdenante;
    @Column(name = "NOMBRE_ARCHIVO")
    private String nombreArchivo;
    @Column(name = "NRO_REGISTROS_PROCESAR")
    private BigInteger nroRegistrosProcesar;
    @Column(name = "NRO_REGISTROS_RECHAZADOS")
    private BigInteger nroRegistrosRechazados;
    @Column(name = "NRO_REGISTROS_VALIDADOS")
    private BigInteger nroRegistrosValidados;
    @Column(name = "FECHA_HORA_CARGA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraCarga;
    @Column(name = "ESTATUS_CARGAR")
    private Long estatusCargar;

    public IbSumarioAfiliaciones() {
    }

    public IbSumarioAfiliaciones(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCodigoOrdenante() {
        return codigoOrdenante;
    }

    public void setCodigoOrdenante(Long codigoOrdenante) {
        this.codigoOrdenante = codigoOrdenante;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public BigInteger getNroRegistrosProcesar() {
        return nroRegistrosProcesar;
    }

    public void setNroRegistrosProcesar(BigInteger nroRegistrosProcesar) {
        this.nroRegistrosProcesar = nroRegistrosProcesar;
    }

    public BigInteger getNroRegistrosRechazados() {
        return nroRegistrosRechazados;
    }

    public void setNroRegistrosRechazados(BigInteger nroRegistrosRechazados) {
        this.nroRegistrosRechazados = nroRegistrosRechazados;
    }

    public BigInteger getNroRegistrosValidados() {
        return nroRegistrosValidados;
    }

    public void setNroRegistrosValidados(BigInteger nroRegistrosValidados) {
        this.nroRegistrosValidados = nroRegistrosValidados;
    }

    public Date getFechaHoraCarga() {
        return fechaHoraCarga;
    }

    public void setFechaHoraCarga(Date fechaHoraCarga) {
        this.fechaHoraCarga = fechaHoraCarga;
    }

    public Long getEstatusCargar() {
        return estatusCargar;
    }

    public void setEstatusCargar(Long estatusCargar) {
        this.estatusCargar = estatusCargar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IbSumarioAfiliaciones)) {
            return false;
        }
        IbSumarioAfiliaciones other = (IbSumarioAfiliaciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication10.model.IbSumarioAfiliaciones[ id=" + id + " ]";
    }
    
}
