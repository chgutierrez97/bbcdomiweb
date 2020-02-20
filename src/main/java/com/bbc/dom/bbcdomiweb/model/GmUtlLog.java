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
@Table(name = "GM_UTL_LOG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GmUtlLog.findAll", query = "SELECT g FROM GmUtlLog g")
    , @NamedQuery(name = "GmUtlLog.findByFecha", query = "SELECT g FROM GmUtlLog g WHERE g.gmUtlLogPK.fecha = :fecha")
    , @NamedQuery(name = "GmUtlLog.findBySecuencia", query = "SELECT g FROM GmUtlLog g WHERE g.gmUtlLogPK.secuencia = :secuencia")
    , @NamedQuery(name = "GmUtlLog.findByMensaje", query = "SELECT g FROM GmUtlLog g WHERE g.mensaje = :mensaje")
    , @NamedQuery(name = "GmUtlLog.findByTipo", query = "SELECT g FROM GmUtlLog g WHERE g.tipo = :tipo")
    , @NamedQuery(name = "GmUtlLog.findByProceso", query = "SELECT g FROM GmUtlLog g WHERE g.proceso = :proceso")
    , @NamedQuery(name = "GmUtlLog.findByDocumento", query = "SELECT g FROM GmUtlLog g WHERE g.documento = :documento")
    , @NamedQuery(name = "GmUtlLog.findByFechaHora", query = "SELECT g FROM GmUtlLog g WHERE g.fechaHora = :fechaHora")
    , @NamedQuery(name = "GmUtlLog.findByCodigoUsuario", query = "SELECT g FROM GmUtlLog g WHERE g.codigoUsuario = :codigoUsuario")})
public class GmUtlLog implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GmUtlLogPK gmUtlLogPK;
    @Size(max = 2048)
    @Column(name = "MENSAJE")
    private String mensaje;
    @Size(max = 1)
    @Column(name = "TIPO")
    private String tipo;
    @Size(max = 80)
    @Column(name = "PROCESO")
    private String proceso;
    @Size(max = 30)
    @Column(name = "DOCUMENTO")
    private String documento;
    @Column(name = "FECHA_HORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;
    @Size(max = 30)
    @Column(name = "CODIGO_USUARIO")
    private String codigoUsuario;

    public GmUtlLog() {
    }

    public GmUtlLog(GmUtlLogPK gmUtlLogPK) {
        this.gmUtlLogPK = gmUtlLogPK;
    }

    public GmUtlLog(Date fecha, long secuencia) {
        this.gmUtlLogPK = new GmUtlLogPK(fecha, secuencia);
    }

    public GmUtlLogPK getGmUtlLogPK() {
        return gmUtlLogPK;
    }

    public void setGmUtlLogPK(GmUtlLogPK gmUtlLogPK) {
        this.gmUtlLogPK = gmUtlLogPK;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gmUtlLogPK != null ? gmUtlLogPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GmUtlLog)) {
            return false;
        }
        GmUtlLog other = (GmUtlLog) object;
        if ((this.gmUtlLogPK == null && other.gmUtlLogPK != null) || (this.gmUtlLogPK != null && !this.gmUtlLogPK.equals(other.gmUtlLogPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.GmUtlLog[ gmUtlLogPK=" + gmUtlLogPK + " ]";
    }
    
}
