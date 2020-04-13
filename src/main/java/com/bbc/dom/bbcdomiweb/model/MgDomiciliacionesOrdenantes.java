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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
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
@Table(name = "MG_DOMICILIACIONES_ORDENANTES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MgDomiciliacionesOrdenantes.findAll", query = "SELECT m FROM MgDomiciliacionesOrdenantes m")
    , @NamedQuery(name = "MgDomiciliacionesOrdenantes.findByCodigoOrdenante", query = "SELECT m FROM MgDomiciliacionesOrdenantes m WHERE m.mgDomiciliacionesOrdenantesPK.codigoOrdenante = :codigoOrdenante")
    , @NamedQuery(name = "MgDomiciliacionesOrdenantes.findByFechaValida", query = "SELECT m FROM MgDomiciliacionesOrdenantes m WHERE m.mgDomiciliacionesOrdenantesPK.fechaValida = :fechaValida")
    , @NamedQuery(name = "MgDomiciliacionesOrdenantes.findBySecuencia", query = "SELECT m FROM MgDomiciliacionesOrdenantes m WHERE m.secuencia = :secuencia")
    , @NamedQuery(name = "MgDomiciliacionesOrdenantes.findByRegistro", query = "SELECT m FROM MgDomiciliacionesOrdenantes m WHERE m.mgDomiciliacionesOrdenantesPK.registro = :registro")
    , @NamedQuery(name = "MgDomiciliacionesOrdenantes.findBySituacion", query = "SELECT m FROM MgDomiciliacionesOrdenantes m WHERE m.situacion = :situacion")
    , @NamedQuery(name = "MgDomiciliacionesOrdenantes.findByFechaCarga", query = "SELECT m FROM MgDomiciliacionesOrdenantes m WHERE m.fechaCarga = :fechaCarga")
    , @NamedQuery(name = "MgDomiciliacionesOrdenantes.findByUsuarioCarga", query = "SELECT m FROM MgDomiciliacionesOrdenantes m WHERE m.usuarioCarga = :usuarioCarga")
    , @NamedQuery(name = "MgDomiciliacionesOrdenantes.findByOrigenCarga", query = "SELECT m FROM MgDomiciliacionesOrdenantes m WHERE m.origenCarga = :origenCarga")
    , @NamedQuery(name = "MgDomiciliacionesOrdenantes.findByMotivoRechazo", query = "SELECT m FROM MgDomiciliacionesOrdenantes m WHERE m.motivoRechazo = :motivoRechazo")
    , @NamedQuery(name = "MgDomiciliacionesOrdenantes.findByCodigoRechazo", query = "SELECT m FROM MgDomiciliacionesOrdenantes m WHERE m.codigoRechazo = :codigoRechazo")})
@SequenceGenerator(
    name="MgDomiciliacionesOrd",
   // sequenceName = "MG_S_GRUPO_DOMICILIACION",
    sequenceName = "MG_S_DOMICILIACIONES_ORD", 
    initialValue = 1, 
    allocationSize = 10
)
public class MgDomiciliacionesOrdenantes implements Serializable {

    @Column(name = "SECUENCIA_LOTE")
    private Long secuenciaLote;
    @Size(max = 1)
    @Column(name = "COBRO_EXITOSO")
    private String cobroExitoso;
    @Column(name = "GRUPO")
    private Long grupo;
    
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MgDomiciliacionesOrdenantesPK mgDomiciliacionesOrdenantesPK;
    @Column(name = "SECUENCIA")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MgDomiciliacionesOrd")
    private Long secuencia;
    @Column(name = "ELEMENTO_GRUPO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MgDomiciliacionesOrd")
    private Long elementoGrupo;
    @Size(max = 1)
    @Column(name = "SITUACION")
    private String situacion;
    @Column(name = "FECHA_CARGA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCarga;
    @Size(max = 20)
    @Column(name = "USUARIO_CARGA")
    private String usuarioCarga;
    @Size(max = 1)
    @Column(name = "ORIGEN_CARGA")
    private String origenCarga;
    @Size(max = 200)
    @Column(name = "MOTIVO_RECHAZO")
    private String motivoRechazo;
    @Column(name = "CODIGO_RECHAZO")
    private Short codigoRechazo;

    public MgDomiciliacionesOrdenantes() {
    }

    public MgDomiciliacionesOrdenantes(MgDomiciliacionesOrdenantesPK mgDomiciliacionesOrdenantesPK) {
        this.mgDomiciliacionesOrdenantesPK = mgDomiciliacionesOrdenantesPK;
    }

    public MgDomiciliacionesOrdenantes(int codigoOrdenante, Date fechaValida, String registro) {
        this.mgDomiciliacionesOrdenantesPK = new MgDomiciliacionesOrdenantesPK(codigoOrdenante, fechaValida, registro);
    }

    public MgDomiciliacionesOrdenantesPK getMgDomiciliacionesOrdenantesPK() {
        return mgDomiciliacionesOrdenantesPK;
    }

    public void setMgDomiciliacionesOrdenantesPK(MgDomiciliacionesOrdenantesPK mgDomiciliacionesOrdenantesPK) {
        this.mgDomiciliacionesOrdenantesPK = mgDomiciliacionesOrdenantesPK;
    }

    public Long getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(Long secuencia) {
        this.secuencia = secuencia;
    }

    public Long getSecuenciaLote() {
        return secuenciaLote;
    }

    public void setSecuenciaLote(Long secuenciaLote) {
        this.secuenciaLote = secuenciaLote;
    }
    
    

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public Date getFechaCarga() {
        return fechaCarga;
    }

    public void setFechaCarga(Date fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    public String getUsuarioCarga() {
        return usuarioCarga;
    }

    public void setUsuarioCarga(String usuarioCarga) {
        this.usuarioCarga = usuarioCarga;
    }

    public String getOrigenCarga() {
        return origenCarga;
    }

    public void setOrigenCarga(String origenCarga) {
        this.origenCarga = origenCarga;
    }

    public String getMotivoRechazo() {
        return motivoRechazo;
    }

    public void setMotivoRechazo(String motivoRechazo) {
        this.motivoRechazo = motivoRechazo;
    }

    public Short getCodigoRechazo() {
        return codigoRechazo;
    }

    public void setCodigoRechazo(Short codigoRechazo) {
        this.codigoRechazo = codigoRechazo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mgDomiciliacionesOrdenantesPK != null ? mgDomiciliacionesOrdenantesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MgDomiciliacionesOrdenantes)) {
            return false;
        }
        MgDomiciliacionesOrdenantes other = (MgDomiciliacionesOrdenantes) object;
        if ((this.mgDomiciliacionesOrdenantesPK == null && other.mgDomiciliacionesOrdenantesPK != null) || (this.mgDomiciliacionesOrdenantesPK != null && !this.mgDomiciliacionesOrdenantesPK.equals(other.mgDomiciliacionesOrdenantesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.MgDomiciliacionesOrdenantes[ mgDomiciliacionesOrdenantesPK=" + mgDomiciliacionesOrdenantesPK + " ]";
    }

  /*  public Integer getSecuenciaLote() {
        return secuenciaLote;
    }*/

   /* public void setSecuenciaLote(Integer secuenciaLote) {
        this.secuenciaLote = secuenciaLote;
    }*/

    public String getCobroExitoso() {
        return cobroExitoso;
    }

    public void setCobroExitoso(String cobroExitoso) {
        this.cobroExitoso = cobroExitoso;
    }

    public Long getGrupo() {
        return grupo;
    }

    public void setGrupo(Long grupo) {
        this.grupo = grupo;
    }

    public Long getElementoGrupo() {
        return elementoGrupo;
    }

    public void setElementoGrupo(Long elementoGrupo) {
        this.elementoGrupo = elementoGrupo;
    }
    
}
