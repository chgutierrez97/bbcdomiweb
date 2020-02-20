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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sinergia
 */
@Entity
@Table(name = "IB_SESION_DOMICILIACIONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IbSesionDomiciliaciones.findAll", query = "SELECT i FROM IbSesionDomiciliaciones i")
    , @NamedQuery(name = "IbSesionDomiciliaciones.findByIdentificacionPagador", query = "SELECT i FROM IbSesionDomiciliaciones i WHERE i.identificacionPagador = :identificacionPagador")
    , @NamedQuery(name = "IbSesionDomiciliaciones.findByCodigoOrdenante", query = "SELECT i FROM IbSesionDomiciliaciones i WHERE i.codigoOrdenante = :codigoOrdenante")
    , @NamedQuery(name = "IbSesionDomiciliaciones.findByEstatus", query = "SELECT i FROM IbSesionDomiciliaciones i WHERE i.estatus = :estatus")
    , @NamedQuery(name = "IbSesionDomiciliaciones.findByFechaInicio", query = "SELECT i FROM IbSesionDomiciliaciones i WHERE i.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "IbSesionDomiciliaciones.findByFechaFin", query = "SELECT i FROM IbSesionDomiciliaciones i WHERE i.fechaFin = :fechaFin")
    , @NamedQuery(name = "IbSesionDomiciliaciones.findByFechaMantenimiento", query = "SELECT i FROM IbSesionDomiciliaciones i WHERE i.fechaMantenimiento = :fechaMantenimiento")
    , @NamedQuery(name = "IbSesionDomiciliaciones.findById", query = "SELECT i FROM IbSesionDomiciliaciones i WHERE i.id = :id")})

public class IbSesionDomiciliaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "IDENTIFICACION_PAGADOR")
    private String identificacionPagador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "CODIGO_ORDENANTE")
    private String codigoOrdenante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTATUS")
    private String estatus;
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Column(name = "FECHA_MANTENIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaMantenimiento;
    @Id
    @GeneratedValue(generator = "seqGen")
    @SequenceGenerator(name = "seqGen", sequenceName = "IB_SESION_DOMICILIACIONES_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    public IbSesionDomiciliaciones() {
    }

    public IbSesionDomiciliaciones(Long id) {
        this.id = id;
    }

    public IbSesionDomiciliaciones(Long id, String identificacionPagador, String codigoOrdenante, String estatus) {
        this.id = id;
        this.identificacionPagador = identificacionPagador;
        this.codigoOrdenante = codigoOrdenante;
        this.estatus = estatus;
    }

    public String getIdentificacionPagador() {
        return identificacionPagador;
    }

    public void setIdentificacionPagador(String identificacionPagador) {
        this.identificacionPagador = identificacionPagador;
    }

    public String getCodigoOrdenante() {
        return codigoOrdenante;
    }

    public void setCodigoOrdenante(String codigoOrdenante) {
        this.codigoOrdenante = codigoOrdenante;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaMantenimiento() {
        return fechaMantenimiento;
    }

    public void setFechaMantenimiento(Date fechaMantenimiento) {
        this.fechaMantenimiento = fechaMantenimiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof IbSesionDomiciliaciones)) {
            return false;
        }
        IbSesionDomiciliaciones other = (IbSesionDomiciliaciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.IbSesionDomiciliaciones[ id=" + id + " ]";
    }

}
