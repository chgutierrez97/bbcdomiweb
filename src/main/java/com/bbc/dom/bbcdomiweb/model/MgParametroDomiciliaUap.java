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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Christian Gutierrez
 */
@Entity
@Table(name = "MG_PARAMETRO_DOMICILIA_UAP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MgParametroDomiciliaUap.findAll", query = "SELECT m FROM MgParametroDomiciliaUap m")
    , @NamedQuery(name = "MgParametroDomiciliaUap.findByCodigoEmpresa", query = "SELECT m FROM MgParametroDomiciliaUap m WHERE m.codigoEmpresa = :codigoEmpresa")
    , @NamedQuery(name = "MgParametroDomiciliaUap.findByServidorArchivosRecibe", query = "SELECT m FROM MgParametroDomiciliaUap m WHERE m.servidorArchivosRecibe = :servidorArchivosRecibe")
    , @NamedQuery(name = "MgParametroDomiciliaUap.findByServidorArchivosEnvia", query = "SELECT m FROM MgParametroDomiciliaUap m WHERE m.servidorArchivosEnvia = :servidorArchivosEnvia")
    , @NamedQuery(name = "MgParametroDomiciliaUap.findByRutaLecturaAfiliacion", query = "SELECT m FROM MgParametroDomiciliaUap m WHERE m.rutaLecturaAfiliacion = :rutaLecturaAfiliacion")
    , @NamedQuery(name = "MgParametroDomiciliaUap.findByRutaDestino", query = "SELECT m FROM MgParametroDomiciliaUap m WHERE m.rutaDestino = :rutaDestino")
    , @NamedQuery(name = "MgParametroDomiciliaUap.findByTrxDbDomiciliaBca", query = "SELECT m FROM MgParametroDomiciliaUap m WHERE m.trxDbDomiciliaBca = :trxDbDomiciliaBca")
    , @NamedQuery(name = "MgParametroDomiciliaUap.findByTrxDbDomiciliaBcc", query = "SELECT m FROM MgParametroDomiciliaUap m WHERE m.trxDbDomiciliaBcc = :trxDbDomiciliaBcc")
    , @NamedQuery(name = "MgParametroDomiciliaUap.findByCodigoCompensacion", query = "SELECT m FROM MgParametroDomiciliaUap m WHERE m.codigoCompensacion = :codigoCompensacion")
    , @NamedQuery(name = "MgParametroDomiciliaUap.findByRutaComandoOrd", query = "SELECT m FROM MgParametroDomiciliaUap m WHERE m.rutaComandoOrd = :rutaComandoOrd")
    , @NamedQuery(name = "MgParametroDomiciliaUap.findByAdicionadoPor", query = "SELECT m FROM MgParametroDomiciliaUap m WHERE m.adicionadoPor = :adicionadoPor")
    , @NamedQuery(name = "MgParametroDomiciliaUap.findByFechaAdicion", query = "SELECT m FROM MgParametroDomiciliaUap m WHERE m.fechaAdicion = :fechaAdicion")
    , @NamedQuery(name = "MgParametroDomiciliaUap.findByModificadoPor", query = "SELECT m FROM MgParametroDomiciliaUap m WHERE m.modificadoPor = :modificadoPor")
    , @NamedQuery(name = "MgParametroDomiciliaUap.findByFechaModificacion", query = "SELECT m FROM MgParametroDomiciliaUap m WHERE m.fechaModificacion = :fechaModificacion")})
public class MgParametroDomiciliaUap implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_EMPRESA")
    private Short codigoEmpresa;
    @Size(max = 30)
    @Column(name = "SERVIDOR_ARCHIVOS_RECIBE")
    private String servidorArchivosRecibe;
    @Size(max = 30)
    @Column(name = "SERVIDOR_ARCHIVOS_ENVIA")
    private String servidorArchivosEnvia;
    @Size(max = 30)
    @Column(name = "RUTA_LECTURA_AFILIACION")
    private String rutaLecturaAfiliacion;
    @Size(max = 30)
    @Column(name = "RUTA_DESTINO")
    private String rutaDestino;
    @Column(name = "TRX_DB_DOMICILIA_BCA")
    private Short trxDbDomiciliaBca;
    @Column(name = "TRX_DB_DOMICILIA_BCC")
    private Short trxDbDomiciliaBcc;
    @Size(max = 4)
    @Column(name = "CODIGO_COMPENSACION")
    private String codigoCompensacion;
    @Size(max = 30)
    @Column(name = "RUTA_COMANDO_ORD")
    private String rutaComandoOrd;
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

    public MgParametroDomiciliaUap() {
    }

    public MgParametroDomiciliaUap(Short codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    public Short getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public void setCodigoEmpresa(Short codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    public String getServidorArchivosRecibe() {
        return servidorArchivosRecibe;
    }

    public void setServidorArchivosRecibe(String servidorArchivosRecibe) {
        this.servidorArchivosRecibe = servidorArchivosRecibe;
    }

    public String getServidorArchivosEnvia() {
        return servidorArchivosEnvia;
    }

    public void setServidorArchivosEnvia(String servidorArchivosEnvia) {
        this.servidorArchivosEnvia = servidorArchivosEnvia;
    }

    public String getRutaLecturaAfiliacion() {
        return rutaLecturaAfiliacion;
    }

    public void setRutaLecturaAfiliacion(String rutaLecturaAfiliacion) {
        this.rutaLecturaAfiliacion = rutaLecturaAfiliacion;
    }

    public String getRutaDestino() {
        return rutaDestino;
    }

    public void setRutaDestino(String rutaDestino) {
        this.rutaDestino = rutaDestino;
    }

    public Short getTrxDbDomiciliaBca() {
        return trxDbDomiciliaBca;
    }

    public void setTrxDbDomiciliaBca(Short trxDbDomiciliaBca) {
        this.trxDbDomiciliaBca = trxDbDomiciliaBca;
    }

    public Short getTrxDbDomiciliaBcc() {
        return trxDbDomiciliaBcc;
    }

    public void setTrxDbDomiciliaBcc(Short trxDbDomiciliaBcc) {
        this.trxDbDomiciliaBcc = trxDbDomiciliaBcc;
    }

    public String getCodigoCompensacion() {
        return codigoCompensacion;
    }

    public void setCodigoCompensacion(String codigoCompensacion) {
        this.codigoCompensacion = codigoCompensacion;
    }

    public String getRutaComandoOrd() {
        return rutaComandoOrd;
    }

    public void setRutaComandoOrd(String rutaComandoOrd) {
        this.rutaComandoOrd = rutaComandoOrd;
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
        hash += (codigoEmpresa != null ? codigoEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MgParametroDomiciliaUap)) {
            return false;
        }
        MgParametroDomiciliaUap other = (MgParametroDomiciliaUap) object;
        if ((this.codigoEmpresa == null && other.codigoEmpresa != null) || (this.codigoEmpresa != null && !this.codigoEmpresa.equals(other.codigoEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.MgParametroDomiciliaUap[ codigoEmpresa=" + codigoEmpresa + " ]";
    }
    
}
