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
@Table(name = "MG_AFILIACIONES_ORDENANTES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MgAfiliacionesOrdenantes.findAll", query = "SELECT m FROM MgAfiliacionesOrdenantes m")
//    , @NamedQuery(name = "MgAfiliacionesOrdenantes.findByCodigoOrdenante", query = "SELECT m FROM MgAfiliacionesOrdenantes m WHERE m.mgAfiliacionesOrdenantesPK.codigoOrdenante = :codigoOrdenante") Verificar
    , @NamedQuery(name = "MgAfiliacionesOrdenantes.findByFechaValida", query = "SELECT m FROM MgAfiliacionesOrdenantes m WHERE m.mgAfiliacionesOrdenantesPK.fechaValida = :fechaValida")
    , @NamedQuery(name = "MgAfiliacionesOrdenantes.findBySecuencia", query = "SELECT m FROM MgAfiliacionesOrdenantes m WHERE m.secuencia = :secuencia")
    , @NamedQuery(name = "MgAfiliacionesOrdenantes.findByRegistro", query = "SELECT m FROM MgAfiliacionesOrdenantes m WHERE m.mgAfiliacionesOrdenantesPK.registro = :registro")
    , @NamedQuery(name = "MgAfiliacionesOrdenantes.findBySituacion", query = "SELECT m FROM MgAfiliacionesOrdenantes m WHERE m.situacion = :situacion")
    , @NamedQuery(name = "MgAfiliacionesOrdenantes.findByFechaCarga", query = "SELECT m FROM MgAfiliacionesOrdenantes m WHERE m.fechaCarga = :fechaCarga")
    , @NamedQuery(name = "MgAfiliacionesOrdenantes.findByUsuarioCarga", query = "SELECT m FROM MgAfiliacionesOrdenantes m WHERE m.usuarioCarga = :usuarioCarga")
    , @NamedQuery(name = "MgAfiliacionesOrdenantes.findByOrigenCarga", query = "SELECT m FROM MgAfiliacionesOrdenantes m WHERE m.origenCarga = :origenCarga")
    , @NamedQuery(name = "MgAfiliacionesOrdenantes.findByMotivoRechazo", query = "SELECT m FROM MgAfiliacionesOrdenantes m WHERE m.motivoRechazo = :motivoRechazo")
    , @NamedQuery(name = "MgAfiliacionesOrdenantes.findByCodigoRechazo", query = "SELECT m FROM MgAfiliacionesOrdenantes m WHERE m.codigoRechazo = :codigoRechazo")})

@SequenceGenerator(
    name="MgSAfiliacionesOrd",
   // sequenceName = "MG_S_AFILIACIONES_ORD",
    sequenceName = "MG_S_GRUPO_AFILIACION",
    initialValue = 1, 
    allocationSize = 10
)
public class MgAfiliacionesOrdenantes implements Serializable {

    @Column(name = "CODIGO_ORDENANTE")
    private Integer codigoOrdenante;
    @Column(name = "CODIGO_RECHAZO")
    private Long codigoRechazo;
    @Column(name = "SECUENCIA_LOTE")
    private Long secuenciaLote;
    @Column(name = "SECUENCIA_LOTE_DET")
    private Integer secuenciaLoteDet;
    @Column(name = "GRUPO")
    private Long grupo;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MgAfiliacionesOrdenantesPK mgAfiliacionesOrdenantesPK;
    @Column(name = "SECUENCIA")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MgSAfiliacionesOrd")
    private Long secuencia;
    @Column(name = "ELEMENTO_GRUPO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MgSAfiliacionesOrd")
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

    public MgAfiliacionesOrdenantes() {
    }

    public MgAfiliacionesOrdenantes(MgAfiliacionesOrdenantesPK mgAfiliacionesOrdenantesPK) {
        this.mgAfiliacionesOrdenantesPK = mgAfiliacionesOrdenantesPK;
    }

    public MgAfiliacionesOrdenantes(int codigoOrdenante, Date fechaValida, String registro) {
        this.mgAfiliacionesOrdenantesPK = new MgAfiliacionesOrdenantesPK(/*codigoOrdenante,*/ fechaValida, registro);
    }

    public MgAfiliacionesOrdenantesPK getMgAfiliacionesOrdenantesPK() {
        return mgAfiliacionesOrdenantesPK;
    }

    public void setMgAfiliacionesOrdenantesPK(MgAfiliacionesOrdenantesPK mgAfiliacionesOrdenantesPK) {
        this.mgAfiliacionesOrdenantesPK = mgAfiliacionesOrdenantesPK;
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

    public Long getCodigoRechazo() {
        return codigoRechazo;
    }

    public void setCodigoRechazo(Long codigoRechazo) {
        this.codigoRechazo = codigoRechazo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mgAfiliacionesOrdenantesPK != null ? mgAfiliacionesOrdenantesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MgAfiliacionesOrdenantes)) {
            return false;
        }
        MgAfiliacionesOrdenantes other = (MgAfiliacionesOrdenantes) object;
        if ((this.mgAfiliacionesOrdenantesPK == null && other.mgAfiliacionesOrdenantesPK != null) || (this.mgAfiliacionesOrdenantesPK != null && !this.mgAfiliacionesOrdenantesPK.equals(other.mgAfiliacionesOrdenantesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.MgAfiliacionesOrdenantes[ mgAfiliacionesOrdenantesPK=" + mgAfiliacionesOrdenantesPK + " ]";
    }

    public Integer getCodigoOrdenante() {
        return codigoOrdenante;
    }

    public void setCodigoOrdenante(Integer codigoOrdenante) {
        this.codigoOrdenante = codigoOrdenante;
    }

  /*  public Short getCodigoRechazo() {
        return codigoRechazo;
    }

    public void setCodigoRechazo(Short codigoRechazo) {
        this.codigoRechazo = codigoRechazo;
    }*/

   /* public Integer getSecuenciaLote() {
        return secuenciaLote;
    }

    public void setSecuenciaLote(Integer secuenciaLote) {
        this.secuenciaLote = secuenciaLote;
    }*/

    public Integer getSecuenciaLoteDet() {
        return secuenciaLoteDet;
    }

    public void setSecuenciaLoteDet(Integer secuenciaLoteDet) {
        this.secuenciaLoteDet = secuenciaLoteDet;
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
