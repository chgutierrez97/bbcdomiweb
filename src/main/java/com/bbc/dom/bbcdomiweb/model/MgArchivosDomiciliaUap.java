/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Christian Gutierrez
 */
@Entity
@Table(name = "MG_ARCHIVOS_DOMICILIA_UAP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MgArchivosDomiciliaUap.findAll", query = "SELECT m FROM MgArchivosDomiciliaUap m")
    , @NamedQuery(name = "MgArchivosDomiciliaUap.findByNombreArchivo", query = "SELECT m FROM MgArchivosDomiciliaUap m WHERE m.mgArchivosDomiciliaUapPK.nombreArchivo = :nombreArchivo")
    , @NamedQuery(name = "MgArchivosDomiciliaUap.findByFechaValida", query = "SELECT m FROM MgArchivosDomiciliaUap m WHERE m.mgArchivosDomiciliaUapPK.fechaValida = :fechaValida")
    , @NamedQuery(name = "MgArchivosDomiciliaUap.findByTipoMensaje", query = "SELECT m FROM MgArchivosDomiciliaUap m WHERE m.tipoMensaje = :tipoMensaje")
    , @NamedQuery(name = "MgArchivosDomiciliaUap.findByBancoEmisor", query = "SELECT m FROM MgArchivosDomiciliaUap m WHERE m.bancoEmisor = :bancoEmisor")
    , @NamedQuery(name = "MgArchivosDomiciliaUap.findByEncabezadoMensaje", query = "SELECT m FROM MgArchivosDomiciliaUap m WHERE m.encabezadoMensaje = :encabezadoMensaje")
    , @NamedQuery(name = "MgArchivosDomiciliaUap.findByRechazoTotal", query = "SELECT m FROM MgArchivosDomiciliaUap m WHERE m.rechazoTotal = :rechazoTotal")
    , @NamedQuery(name = "MgArchivosDomiciliaUap.findByGeneroRespuesta", query = "SELECT m FROM MgArchivosDomiciliaUap m WHERE m.generoRespuesta = :generoRespuesta")
    , @NamedQuery(name = "MgArchivosDomiciliaUap.findByAdicionadoPor", query = "SELECT m FROM MgArchivosDomiciliaUap m WHERE m.adicionadoPor = :adicionadoPor")
    , @NamedQuery(name = "MgArchivosDomiciliaUap.findByFechaAdicion", query = "SELECT m FROM MgArchivosDomiciliaUap m WHERE m.fechaAdicion = :fechaAdicion")
    , @NamedQuery(name = "MgArchivosDomiciliaUap.findByModificadoPor", query = "SELECT m FROM MgArchivosDomiciliaUap m WHERE m.modificadoPor = :modificadoPor")
    , @NamedQuery(name = "MgArchivosDomiciliaUap.findByFechaModificacion", query = "SELECT m FROM MgArchivosDomiciliaUap m WHERE m.fechaModificacion = :fechaModificacion")})
public class MgArchivosDomiciliaUap implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MgArchivosDomiciliaUapPK mgArchivosDomiciliaUapPK;
    @Size(max = 3)
    @Column(name = "TIPO_MENSAJE")
    private String tipoMensaje;
    @Size(max = 4)
    @Column(name = "BANCO_EMISOR")
    private String bancoEmisor;
    @Size(max = 30)
    @Column(name = "ENCABEZADO_MENSAJE")
    private String encabezadoMensaje;
    @Size(max = 1)
    @Column(name = "RECHAZO_TOTAL")
    private String rechazoTotal;
    @Size(max = 1)
    @Column(name = "GENERO_RESPUESTA")
    private String generoRespuesta;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mgArchivosDomiciliaUap")
    private Collection<MgDetArchivosDomiciliaUap> mgDetArchivosDomiciliaUapCollection;
    @JoinColumn(name = "CODIGO_RECHAZO", referencedColumnName = "CODIGO_RECHAZO")
    @ManyToOne
    private MgMsnRechazoDomiciliaUap codigoRechazo;

    public MgArchivosDomiciliaUap() {
    }

    public MgArchivosDomiciliaUap(MgArchivosDomiciliaUapPK mgArchivosDomiciliaUapPK) {
        this.mgArchivosDomiciliaUapPK = mgArchivosDomiciliaUapPK;
    }

    public MgArchivosDomiciliaUap(String nombreArchivo, Date fechaValida) {
        this.mgArchivosDomiciliaUapPK = new MgArchivosDomiciliaUapPK(nombreArchivo, fechaValida);
    }

    public MgArchivosDomiciliaUapPK getMgArchivosDomiciliaUapPK() {
        return mgArchivosDomiciliaUapPK;
    }

    public void setMgArchivosDomiciliaUapPK(MgArchivosDomiciliaUapPK mgArchivosDomiciliaUapPK) {
        this.mgArchivosDomiciliaUapPK = mgArchivosDomiciliaUapPK;
    }

    public String getTipoMensaje() {
        return tipoMensaje;
    }

    public void setTipoMensaje(String tipoMensaje) {
        this.tipoMensaje = tipoMensaje;
    }

    public String getBancoEmisor() {
        return bancoEmisor;
    }

    public void setBancoEmisor(String bancoEmisor) {
        this.bancoEmisor = bancoEmisor;
    }

    public String getEncabezadoMensaje() {
        return encabezadoMensaje;
    }

    public void setEncabezadoMensaje(String encabezadoMensaje) {
        this.encabezadoMensaje = encabezadoMensaje;
    }

    public String getRechazoTotal() {
        return rechazoTotal;
    }

    public void setRechazoTotal(String rechazoTotal) {
        this.rechazoTotal = rechazoTotal;
    }

    public String getGeneroRespuesta() {
        return generoRespuesta;
    }

    public void setGeneroRespuesta(String generoRespuesta) {
        this.generoRespuesta = generoRespuesta;
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

    @XmlTransient
    public Collection<MgDetArchivosDomiciliaUap> getMgDetArchivosDomiciliaUapCollection() {
        return mgDetArchivosDomiciliaUapCollection;
    }

    public void setMgDetArchivosDomiciliaUapCollection(Collection<MgDetArchivosDomiciliaUap> mgDetArchivosDomiciliaUapCollection) {
        this.mgDetArchivosDomiciliaUapCollection = mgDetArchivosDomiciliaUapCollection;
    }

    public MgMsnRechazoDomiciliaUap getCodigoRechazo() {
        return codigoRechazo;
    }

    public void setCodigoRechazo(MgMsnRechazoDomiciliaUap codigoRechazo) {
        this.codigoRechazo = codigoRechazo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mgArchivosDomiciliaUapPK != null ? mgArchivosDomiciliaUapPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MgArchivosDomiciliaUap)) {
            return false;
        }
        MgArchivosDomiciliaUap other = (MgArchivosDomiciliaUap) object;
        if ((this.mgArchivosDomiciliaUapPK == null && other.mgArchivosDomiciliaUapPK != null) || (this.mgArchivosDomiciliaUapPK != null && !this.mgArchivosDomiciliaUapPK.equals(other.mgArchivosDomiciliaUapPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.MgArchivosDomiciliaUap[ mgArchivosDomiciliaUapPK=" + mgArchivosDomiciliaUapPK + " ]";
    }
    
}
