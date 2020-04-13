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
@Table(name = "LC_COMISIONES_LOG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LcComisionesLog.findAll", query = "SELECT l FROM LcComisionesLog l")
    , @NamedQuery(name = "LcComisionesLog.findByFecha", query = "SELECT l FROM LcComisionesLog l WHERE l.lcComisionesLogPK.fecha = :fecha")
    , @NamedQuery(name = "LcComisionesLog.findBySecuencia", query = "SELECT l FROM LcComisionesLog l WHERE l.lcComisionesLogPK.secuencia = :secuencia")
    , @NamedQuery(name = "LcComisionesLog.findByTipo", query = "SELECT l FROM LcComisionesLog l WHERE l.tipo = :tipo")
    , @NamedQuery(name = "LcComisionesLog.findByDocumento", query = "SELECT l FROM LcComisionesLog l WHERE l.documento = :documento")
    , @NamedQuery(name = "LcComisionesLog.findByMensaje", query = "SELECT l FROM LcComisionesLog l WHERE l.mensaje = :mensaje")
    , @NamedQuery(name = "LcComisionesLog.findByFechaHora", query = "SELECT l FROM LcComisionesLog l WHERE l.fechaHora = :fechaHora")
    , @NamedQuery(name = "LcComisionesLog.findByCodigoUsuario", query = "SELECT l FROM LcComisionesLog l WHERE l.codigoUsuario = :codigoUsuario")})
public class LcComisionesLog implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LcComisionesLogPK lcComisionesLogPK;
    @Size(max = 1)
    @Column(name = "TIPO")
    private String tipo;
    @Size(max = 30)
    @Column(name = "DOCUMENTO")
    private String documento;
    @Size(max = 2048)
    @Column(name = "MENSAJE")
    private String mensaje;
    @Column(name = "FECHA_HORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;
    @Size(max = 30)
    @Column(name = "CODIGO_USUARIO")
    private String codigoUsuario;

    public LcComisionesLog() {
    }

    public LcComisionesLog(LcComisionesLogPK lcComisionesLogPK) {
        this.lcComisionesLogPK = lcComisionesLogPK;
    }

    public LcComisionesLog(Date fecha, long secuencia) {
        this.lcComisionesLogPK = new LcComisionesLogPK(fecha, secuencia);
    }

    public LcComisionesLogPK getLcComisionesLogPK() {
        return lcComisionesLogPK;
    }

    public void setLcComisionesLogPK(LcComisionesLogPK lcComisionesLogPK) {
        this.lcComisionesLogPK = lcComisionesLogPK;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
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
        hash += (lcComisionesLogPK != null ? lcComisionesLogPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LcComisionesLog)) {
            return false;
        }
        LcComisionesLog other = (LcComisionesLog) object;
        if ((this.lcComisionesLogPK == null && other.lcComisionesLogPK != null) || (this.lcComisionesLogPK != null && !this.lcComisionesLogPK.equals(other.lcComisionesLogPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.LcComisionesLog[ lcComisionesLogPK=" + lcComisionesLogPK + " ]";
    }
    
}
