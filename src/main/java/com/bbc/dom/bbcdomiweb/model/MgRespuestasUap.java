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
@Table(name = "MG_RESPUESTAS_UAP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MgRespuestasUap.findAll", query = "SELECT m FROM MgRespuestasUap m")
    , @NamedQuery(name = "MgRespuestasUap.findByNombreArchivo", query = "SELECT m FROM MgRespuestasUap m WHERE m.mgRespuestasUapPK.nombreArchivo = :nombreArchivo")
    , @NamedQuery(name = "MgRespuestasUap.findByTipoArchivo", query = "SELECT m FROM MgRespuestasUap m WHERE m.mgRespuestasUapPK.tipoArchivo = :tipoArchivo")
    , @NamedQuery(name = "MgRespuestasUap.findByFechaValida", query = "SELECT m FROM MgRespuestasUap m WHERE m.mgRespuestasUapPK.fechaValida = :fechaValida")
    , @NamedQuery(name = "MgRespuestasUap.findBySecuencia", query = "SELECT m FROM MgRespuestasUap m WHERE m.mgRespuestasUapPK.secuencia = :secuencia")
    , @NamedQuery(name = "MgRespuestasUap.findByCabecera", query = "SELECT m FROM MgRespuestasUap m WHERE m.cabecera = :cabecera")
    , @NamedQuery(name = "MgRespuestasUap.findByRegistro", query = "SELECT m FROM MgRespuestasUap m WHERE m.registro = :registro")
    , @NamedQuery(name = "MgRespuestasUap.findBySituacion", query = "SELECT m FROM MgRespuestasUap m WHERE m.situacion = :situacion")
    , @NamedQuery(name = "MgRespuestasUap.findByCodigoRespuesta", query = "SELECT m FROM MgRespuestasUap m WHERE m.codigoRespuesta = :codigoRespuesta")
    , @NamedQuery(name = "MgRespuestasUap.findByError", query = "SELECT m FROM MgRespuestasUap m WHERE m.error = :error")
    , @NamedQuery(name = "MgRespuestasUap.findByHoraAdicion", query = "SELECT m FROM MgRespuestasUap m WHERE m.horaAdicion = :horaAdicion")})
public class MgRespuestasUap implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MgRespuestasUapPK mgRespuestasUapPK;
    @Size(max = 300)
    @Column(name = "CABECERA")
    private String cabecera;
    @Size(max = 500)
    @Column(name = "REGISTRO")
    private String registro;
    @Size(max = 1)
    @Column(name = "SITUACION")
    private String situacion;
    @Column(name = "CODIGO_RESPUESTA")
    private Integer codigoRespuesta;
    @Size(max = 300)
    @Column(name = "ERROR")
    private String error;
    @Column(name = "HORA_ADICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaAdicion;

    public MgRespuestasUap() {
    }

    public MgRespuestasUap(MgRespuestasUapPK mgRespuestasUapPK) {
        this.mgRespuestasUapPK = mgRespuestasUapPK;
    }

    public MgRespuestasUap(String nombreArchivo, String tipoArchivo, Date fechaValida, int secuencia) {
        this.mgRespuestasUapPK = new MgRespuestasUapPK(nombreArchivo, tipoArchivo, fechaValida, secuencia);
    }

    public MgRespuestasUapPK getMgRespuestasUapPK() {
        return mgRespuestasUapPK;
    }

    public void setMgRespuestasUapPK(MgRespuestasUapPK mgRespuestasUapPK) {
        this.mgRespuestasUapPK = mgRespuestasUapPK;
    }

    public String getCabecera() {
        return cabecera;
    }

    public void setCabecera(String cabecera) {
        this.cabecera = cabecera;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public Integer getCodigoRespuesta() {
        return codigoRespuesta;
    }

    public void setCodigoRespuesta(Integer codigoRespuesta) {
        this.codigoRespuesta = codigoRespuesta;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Date getHoraAdicion() {
        return horaAdicion;
    }

    public void setHoraAdicion(Date horaAdicion) {
        this.horaAdicion = horaAdicion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mgRespuestasUapPK != null ? mgRespuestasUapPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MgRespuestasUap)) {
            return false;
        }
        MgRespuestasUap other = (MgRespuestasUap) object;
        if ((this.mgRespuestasUapPK == null && other.mgRespuestasUapPK != null) || (this.mgRespuestasUapPK != null && !this.mgRespuestasUapPK.equals(other.mgRespuestasUapPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.MgRespuestasUap[ mgRespuestasUapPK=" + mgRespuestasUapPK + " ]";
    }
    
}
