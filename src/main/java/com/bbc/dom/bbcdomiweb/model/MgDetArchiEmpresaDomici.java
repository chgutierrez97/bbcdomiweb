/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.model;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "MG_DET_ARCHI_EMPRESA_DOMICI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MgDetArchiEmpresaDomici.findAll", query = "SELECT m FROM MgDetArchiEmpresaDomici m")
    , @NamedQuery(name = "MgDetArchiEmpresaDomici.findBySecuencia", query = "SELECT m FROM MgDetArchiEmpresaDomici m WHERE m.mgDetArchiEmpresaDomiciPK.secuencia = :secuencia")
    , @NamedQuery(name = "MgDetArchiEmpresaDomici.findByNombreArchivo", query = "SELECT m FROM MgDetArchiEmpresaDomici m WHERE m.mgDetArchiEmpresaDomiciPK.nombreArchivo = :nombreArchivo")
    , @NamedQuery(name = "MgDetArchiEmpresaDomici.findByFechaValida", query = "SELECT m FROM MgDetArchiEmpresaDomici m WHERE m.mgDetArchiEmpresaDomiciPK.fechaValida = :fechaValida")
    , @NamedQuery(name = "MgDetArchiEmpresaDomici.findByTipoRegistro", query = "SELECT m FROM MgDetArchiEmpresaDomici m WHERE m.tipoRegistro = :tipoRegistro")
    , @NamedQuery(name = "MgDetArchiEmpresaDomici.findByCodigoInstitucion", query = "SELECT m FROM MgDetArchiEmpresaDomici m WHERE m.codigoInstitucion = :codigoInstitucion")
    , @NamedQuery(name = "MgDetArchiEmpresaDomici.findByMensaje", query = "SELECT m FROM MgDetArchiEmpresaDomici m WHERE m.mensaje = :mensaje")
    , @NamedQuery(name = "MgDetArchiEmpresaDomici.findByAdicionadoPor", query = "SELECT m FROM MgDetArchiEmpresaDomici m WHERE m.adicionadoPor = :adicionadoPor")
    , @NamedQuery(name = "MgDetArchiEmpresaDomici.findByFechaAdicion", query = "SELECT m FROM MgDetArchiEmpresaDomici m WHERE m.fechaAdicion = :fechaAdicion")
    , @NamedQuery(name = "MgDetArchiEmpresaDomici.findByModificadoPor", query = "SELECT m FROM MgDetArchiEmpresaDomici m WHERE m.modificadoPor = :modificadoPor")
    , @NamedQuery(name = "MgDetArchiEmpresaDomici.findByFechaModificacion", query = "SELECT m FROM MgDetArchiEmpresaDomici m WHERE m.fechaModificacion = :fechaModificacion")})
public class MgDetArchiEmpresaDomici implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MgDetArchiEmpresaDomiciPK mgDetArchiEmpresaDomiciPK;
    @Size(max = 3)
    @Column(name = "TIPO_REGISTRO")
    private String tipoRegistro;
    @Size(max = 4)
    @Column(name = "CODIGO_INSTITUCION")
    private String codigoInstitucion;
    @Size(max = 54)
    @Column(name = "MENSAJE")
    private String mensaje;
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

    public MgDetArchiEmpresaDomici() {
    }

    public MgDetArchiEmpresaDomici(MgDetArchiEmpresaDomiciPK mgDetArchiEmpresaDomiciPK) {
        this.mgDetArchiEmpresaDomiciPK = mgDetArchiEmpresaDomiciPK;
    }

    public MgDetArchiEmpresaDomici(BigInteger secuencia, String nombreArchivo, Date fechaValida) {
        this.mgDetArchiEmpresaDomiciPK = new MgDetArchiEmpresaDomiciPK(secuencia, nombreArchivo, fechaValida);
    }

    public MgDetArchiEmpresaDomiciPK getMgDetArchiEmpresaDomiciPK() {
        return mgDetArchiEmpresaDomiciPK;
    }

    public void setMgDetArchiEmpresaDomiciPK(MgDetArchiEmpresaDomiciPK mgDetArchiEmpresaDomiciPK) {
        this.mgDetArchiEmpresaDomiciPK = mgDetArchiEmpresaDomiciPK;
    }

    public String getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(String tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    public String getCodigoInstitucion() {
        return codigoInstitucion;
    }

    public void setCodigoInstitucion(String codigoInstitucion) {
        this.codigoInstitucion = codigoInstitucion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
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
        hash += (mgDetArchiEmpresaDomiciPK != null ? mgDetArchiEmpresaDomiciPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MgDetArchiEmpresaDomici)) {
            return false;
        }
        MgDetArchiEmpresaDomici other = (MgDetArchiEmpresaDomici) object;
        if ((this.mgDetArchiEmpresaDomiciPK == null && other.mgDetArchiEmpresaDomiciPK != null) || (this.mgDetArchiEmpresaDomiciPK != null && !this.mgDetArchiEmpresaDomiciPK.equals(other.mgDetArchiEmpresaDomiciPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.MgDetArchiEmpresaDomici[ mgDetArchiEmpresaDomiciPK=" + mgDetArchiEmpresaDomiciPK + " ]";
    }
    
}
