/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "MG_PARAMETRO_DOMICILIACIONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MgParametroDomiciliaciones.findAll", query = "SELECT m FROM MgParametroDomiciliaciones m")
    , @NamedQuery(name = "MgParametroDomiciliaciones.findByCodigoEmpresa", query = "SELECT m FROM MgParametroDomiciliaciones m WHERE m.codigoEmpresa = :codigoEmpresa")
    , @NamedQuery(name = "MgParametroDomiciliaciones.findByRutaTrabajoAfil", query = "SELECT m FROM MgParametroDomiciliaciones m WHERE m.rutaTrabajoAfil = :rutaTrabajoAfil")
    , @NamedQuery(name = "MgParametroDomiciliaciones.findByRutaTrabajoDomic", query = "SELECT m FROM MgParametroDomiciliaciones m WHERE m.rutaTrabajoDomic = :rutaTrabajoDomic")
    , @NamedQuery(name = "MgParametroDomiciliaciones.findByRutaUapAfiliaciones", query = "SELECT m FROM MgParametroDomiciliaciones m WHERE m.rutaUapAfiliaciones = :rutaUapAfiliaciones")
    , @NamedQuery(name = "MgParametroDomiciliaciones.findByRutaUapDomiciliaciones", query = "SELECT m FROM MgParametroDomiciliaciones m WHERE m.rutaUapDomiciliaciones = :rutaUapDomiciliaciones")
    , @NamedQuery(name = "MgParametroDomiciliaciones.findByTrxDbBcaPropia", query = "SELECT m FROM MgParametroDomiciliaciones m WHERE m.trxDbBcaPropia = :trxDbBcaPropia")
    , @NamedQuery(name = "MgParametroDomiciliaciones.findByTrxDbBccPropia", query = "SELECT m FROM MgParametroDomiciliaciones m WHERE m.trxDbBccPropia = :trxDbBccPropia")
    , @NamedQuery(name = "MgParametroDomiciliaciones.findByTrxCrBcaRecaudacion", query = "SELECT m FROM MgParametroDomiciliaciones m WHERE m.trxCrBcaRecaudacion = :trxCrBcaRecaudacion")
    , @NamedQuery(name = "MgParametroDomiciliaciones.findByTrxCrBccRecaudacion", query = "SELECT m FROM MgParametroDomiciliaciones m WHERE m.trxCrBccRecaudacion = :trxCrBccRecaudacion")
    , @NamedQuery(name = "MgParametroDomiciliaciones.findByIncluirChr13EnLinea", query = "SELECT m FROM MgParametroDomiciliaciones m WHERE m.incluirChr13EnLinea = :incluirChr13EnLinea")
    , @NamedQuery(name = "MgParametroDomiciliaciones.findByUapServidor", query = "SELECT m FROM MgParametroDomiciliaciones m WHERE m.uapServidor = :uapServidor")
    , @NamedQuery(name = "MgParametroDomiciliaciones.findByUapUsuarioFtp", query = "SELECT m FROM MgParametroDomiciliaciones m WHERE m.uapUsuarioFtp = :uapUsuarioFtp")
    , @NamedQuery(name = "MgParametroDomiciliaciones.findByUapPwdFtp", query = "SELECT m FROM MgParametroDomiciliaciones m WHERE m.uapPwdFtp = :uapPwdFtp")
    , @NamedQuery(name = "MgParametroDomiciliaciones.findByUapRutaLot", query = "SELECT m FROM MgParametroDomiciliaciones m WHERE m.uapRutaLot = :uapRutaLot")
    , @NamedQuery(name = "MgParametroDomiciliaciones.findByUapRutaCro", query = "SELECT m FROM MgParametroDomiciliaciones m WHERE m.uapRutaCro = :uapRutaCro")
    , @NamedQuery(name = "MgParametroDomiciliaciones.findByUapRutaInf", query = "SELECT m FROM MgParametroDomiciliaciones m WHERE m.uapRutaInf = :uapRutaInf")
    , @NamedQuery(name = "MgParametroDomiciliaciones.findByUapRutaBdAfil", query = "SELECT m FROM MgParametroDomiciliaciones m WHERE m.uapRutaBdAfil = :uapRutaBdAfil")
    , @NamedQuery(name = "MgParametroDomiciliaciones.findByUapRutaBdDomi", query = "SELECT m FROM MgParametroDomiciliaciones m WHERE m.uapRutaBdDomi = :uapRutaBdDomi")
    , @NamedQuery(name = "MgParametroDomiciliaciones.findByClienteServidor", query = "SELECT m FROM MgParametroDomiciliaciones m WHERE m.clienteServidor = :clienteServidor")
    , @NamedQuery(name = "MgParametroDomiciliaciones.findByClienteUsuarioFtp", query = "SELECT m FROM MgParametroDomiciliaciones m WHERE m.clienteUsuarioFtp = :clienteUsuarioFtp")
    , @NamedQuery(name = "MgParametroDomiciliaciones.findByClientePwdFtp", query = "SELECT m FROM MgParametroDomiciliaciones m WHERE m.clientePwdFtp = :clientePwdFtp")
    , @NamedQuery(name = "MgParametroDomiciliaciones.findByClienteRutaComun", query = "SELECT m FROM MgParametroDomiciliaciones m WHERE m.clienteRutaComun = :clienteRutaComun")
    , @NamedQuery(name = "MgParametroDomiciliaciones.findByUapRutaRespInf", query = "SELECT m FROM MgParametroDomiciliaciones m WHERE m.uapRutaRespInf = :uapRutaRespInf")
    , @NamedQuery(name = "MgParametroDomiciliaciones.findByClienteRutaBase", query = "SELECT m FROM MgParametroDomiciliaciones m WHERE m.clienteRutaBase = :clienteRutaBase")
    , @NamedQuery(name = "MgParametroDomiciliaciones.findByUapRutaOrd", query = "SELECT m FROM MgParametroDomiciliaciones m WHERE m.uapRutaOrd = :uapRutaOrd")
    , @NamedQuery(name = "MgParametroDomiciliaciones.findByDiasVenceAfiliacion", query = "SELECT m FROM MgParametroDomiciliaciones m WHERE m.diasVenceAfiliacion = :diasVenceAfiliacion")
    , @NamedQuery(name = "MgParametroDomiciliaciones.findByComisionGeneral", query = "SELECT m FROM MgParametroDomiciliaciones m WHERE m.comisionGeneral = :comisionGeneral")
    , @NamedQuery(name = "MgParametroDomiciliaciones.findByComisionCobrosExitosos", query = "SELECT m FROM MgParametroDomiciliaciones m WHERE m.comisionCobrosExitosos = :comisionCobrosExitosos")
    , @NamedQuery(name = "MgParametroDomiciliaciones.findByAdicionadoPor", query = "SELECT m FROM MgParametroDomiciliaciones m WHERE m.adicionadoPor = :adicionadoPor")
    , @NamedQuery(name = "MgParametroDomiciliaciones.findByFechaAdicion", query = "SELECT m FROM MgParametroDomiciliaciones m WHERE m.fechaAdicion = :fechaAdicion")
    , @NamedQuery(name = "MgParametroDomiciliaciones.findByModificadoPor", query = "SELECT m FROM MgParametroDomiciliaciones m WHERE m.modificadoPor = :modificadoPor")
    , @NamedQuery(name = "MgParametroDomiciliaciones.findByFechaModificacion", query = "SELECT m FROM MgParametroDomiciliaciones m WHERE m.fechaModificacion = :fechaModificacion")
    , @NamedQuery(name = "MgParametroDomiciliaciones.findByUapRutaCrl", query = "SELECT m FROM MgParametroDomiciliaciones m WHERE m.uapRutaCrl = :uapRutaCrl")})
public class MgParametroDomiciliaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_EMPRESA")
    private Short codigoEmpresa;
    @Size(max = 200)
    @Column(name = "RUTA_TRABAJO_AFIL")
    private String rutaTrabajoAfil;
    @Size(max = 200)
    @Column(name = "RUTA_TRABAJO_DOMIC")
    private String rutaTrabajoDomic;
    @Size(max = 200)
    @Column(name = "RUTA_UAP_AFILIACIONES")
    private String rutaUapAfiliaciones;
    @Size(max = 200)
    @Column(name = "RUTA_UAP_DOMICILIACIONES")
    private String rutaUapDomiciliaciones;
    @Column(name = "TRX_DB_BCA_PROPIA")
    private Short trxDbBcaPropia;
    @Column(name = "TRX_DB_BCC_PROPIA")
    private Short trxDbBccPropia;
    @Column(name = "TRX_CR_BCA_RECAUDACION")
    private Short trxCrBcaRecaudacion;
    @Column(name = "TRX_CR_BCC_RECAUDACION")
    private Short trxCrBccRecaudacion;
    @Size(max = 1)
    @Column(name = "INCLUIR_CHR13_EN_LINEA")
    private String incluirChr13EnLinea;
    @Size(max = 200)
    @Column(name = "UAP_SERVIDOR")
    private String uapServidor;
    @Size(max = 200)
    @Column(name = "UAP_USUARIO_FTP")
    private String uapUsuarioFtp;
    @Size(max = 200)
    @Column(name = "UAP_PWD_FTP")
    private String uapPwdFtp;
    @Size(max = 200)
    @Column(name = "UAP_RUTA_LOT")
    private String uapRutaLot;
    @Size(max = 200)
    @Column(name = "UAP_RUTA_CRO")
    private String uapRutaCro;
    @Size(max = 200)
    @Column(name = "UAP_RUTA_INF")
    private String uapRutaInf;
    @Size(max = 200)
    @Column(name = "UAP_RUTA_BD_AFIL")
    private String uapRutaBdAfil;
    @Size(max = 200)
    @Column(name = "UAP_RUTA_BD_DOMI")
    private String uapRutaBdDomi;
    @Size(max = 200)
    @Column(name = "CLIENTE_SERVIDOR")
    private String clienteServidor;
    @Size(max = 200)
    @Column(name = "CLIENTE_USUARIO_FTP")
    private String clienteUsuarioFtp;
    @Size(max = 200)
    @Column(name = "CLIENTE_PWD_FTP")
    private String clientePwdFtp;
    @Size(max = 200)
    @Column(name = "CLIENTE_RUTA_COMUN")
    private String clienteRutaComun;
    @Size(max = 200)
    @Column(name = "UAP_RUTA_RESP_INF")
    private String uapRutaRespInf;
    @Size(max = 200)
    @Column(name = "CLIENTE_RUTA_BASE")
    private String clienteRutaBase;
    @Size(max = 100)
    @Column(name = "UAP_RUTA_ORD")
    private String uapRutaOrd;
    @Column(name = "DIAS_VENCE_AFILIACION")
    private Short diasVenceAfiliacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "COMISION_GENERAL")
    private BigDecimal comisionGeneral;
    @Size(max = 1)
    @Column(name = "COMISION_COBROS_EXITOSOS")
    private String comisionCobrosExitosos;
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
    @Size(max = 200)
    @Column(name = "UAP_RUTA_CRL")
    private String uapRutaCrl;

    public MgParametroDomiciliaciones() {
    }

    public MgParametroDomiciliaciones(Short codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    public Short getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public void setCodigoEmpresa(Short codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    public String getRutaTrabajoAfil() {
        return rutaTrabajoAfil;
    }

    public void setRutaTrabajoAfil(String rutaTrabajoAfil) {
        this.rutaTrabajoAfil = rutaTrabajoAfil;
    }

    public String getRutaTrabajoDomic() {
        return rutaTrabajoDomic;
    }

    public void setRutaTrabajoDomic(String rutaTrabajoDomic) {
        this.rutaTrabajoDomic = rutaTrabajoDomic;
    }

    public String getRutaUapAfiliaciones() {
        return rutaUapAfiliaciones;
    }

    public void setRutaUapAfiliaciones(String rutaUapAfiliaciones) {
        this.rutaUapAfiliaciones = rutaUapAfiliaciones;
    }

    public String getRutaUapDomiciliaciones() {
        return rutaUapDomiciliaciones;
    }

    public void setRutaUapDomiciliaciones(String rutaUapDomiciliaciones) {
        this.rutaUapDomiciliaciones = rutaUapDomiciliaciones;
    }

    public Short getTrxDbBcaPropia() {
        return trxDbBcaPropia;
    }

    public void setTrxDbBcaPropia(Short trxDbBcaPropia) {
        this.trxDbBcaPropia = trxDbBcaPropia;
    }

    public Short getTrxDbBccPropia() {
        return trxDbBccPropia;
    }

    public void setTrxDbBccPropia(Short trxDbBccPropia) {
        this.trxDbBccPropia = trxDbBccPropia;
    }

    public Short getTrxCrBcaRecaudacion() {
        return trxCrBcaRecaudacion;
    }

    public void setTrxCrBcaRecaudacion(Short trxCrBcaRecaudacion) {
        this.trxCrBcaRecaudacion = trxCrBcaRecaudacion;
    }

    public Short getTrxCrBccRecaudacion() {
        return trxCrBccRecaudacion;
    }

    public void setTrxCrBccRecaudacion(Short trxCrBccRecaudacion) {
        this.trxCrBccRecaudacion = trxCrBccRecaudacion;
    }

    public String getIncluirChr13EnLinea() {
        return incluirChr13EnLinea;
    }

    public void setIncluirChr13EnLinea(String incluirChr13EnLinea) {
        this.incluirChr13EnLinea = incluirChr13EnLinea;
    }

    public String getUapServidor() {
        return uapServidor;
    }

    public void setUapServidor(String uapServidor) {
        this.uapServidor = uapServidor;
    }

    public String getUapUsuarioFtp() {
        return uapUsuarioFtp;
    }

    public void setUapUsuarioFtp(String uapUsuarioFtp) {
        this.uapUsuarioFtp = uapUsuarioFtp;
    }

    public String getUapPwdFtp() {
        return uapPwdFtp;
    }

    public void setUapPwdFtp(String uapPwdFtp) {
        this.uapPwdFtp = uapPwdFtp;
    }

    public String getUapRutaLot() {
        return uapRutaLot;
    }

    public void setUapRutaLot(String uapRutaLot) {
        this.uapRutaLot = uapRutaLot;
    }

    public String getUapRutaCro() {
        return uapRutaCro;
    }

    public void setUapRutaCro(String uapRutaCro) {
        this.uapRutaCro = uapRutaCro;
    }

    public String getUapRutaInf() {
        return uapRutaInf;
    }

    public void setUapRutaInf(String uapRutaInf) {
        this.uapRutaInf = uapRutaInf;
    }

    public String getUapRutaBdAfil() {
        return uapRutaBdAfil;
    }

    public void setUapRutaBdAfil(String uapRutaBdAfil) {
        this.uapRutaBdAfil = uapRutaBdAfil;
    }

    public String getUapRutaBdDomi() {
        return uapRutaBdDomi;
    }

    public void setUapRutaBdDomi(String uapRutaBdDomi) {
        this.uapRutaBdDomi = uapRutaBdDomi;
    }

    public String getClienteServidor() {
        return clienteServidor;
    }

    public void setClienteServidor(String clienteServidor) {
        this.clienteServidor = clienteServidor;
    }

    public String getClienteUsuarioFtp() {
        return clienteUsuarioFtp;
    }

    public void setClienteUsuarioFtp(String clienteUsuarioFtp) {
        this.clienteUsuarioFtp = clienteUsuarioFtp;
    }

    public String getClientePwdFtp() {
        return clientePwdFtp;
    }

    public void setClientePwdFtp(String clientePwdFtp) {
        this.clientePwdFtp = clientePwdFtp;
    }

    public String getClienteRutaComun() {
        return clienteRutaComun;
    }

    public void setClienteRutaComun(String clienteRutaComun) {
        this.clienteRutaComun = clienteRutaComun;
    }

    public String getUapRutaRespInf() {
        return uapRutaRespInf;
    }

    public void setUapRutaRespInf(String uapRutaRespInf) {
        this.uapRutaRespInf = uapRutaRespInf;
    }

    public String getClienteRutaBase() {
        return clienteRutaBase;
    }

    public void setClienteRutaBase(String clienteRutaBase) {
        this.clienteRutaBase = clienteRutaBase;
    }

    public String getUapRutaOrd() {
        return uapRutaOrd;
    }

    public void setUapRutaOrd(String uapRutaOrd) {
        this.uapRutaOrd = uapRutaOrd;
    }

    public Short getDiasVenceAfiliacion() {
        return diasVenceAfiliacion;
    }

    public void setDiasVenceAfiliacion(Short diasVenceAfiliacion) {
        this.diasVenceAfiliacion = diasVenceAfiliacion;
    }

    public BigDecimal getComisionGeneral() {
        return comisionGeneral;
    }

    public void setComisionGeneral(BigDecimal comisionGeneral) {
        this.comisionGeneral = comisionGeneral;
    }

    public String getComisionCobrosExitosos() {
        return comisionCobrosExitosos;
    }

    public void setComisionCobrosExitosos(String comisionCobrosExitosos) {
        this.comisionCobrosExitosos = comisionCobrosExitosos;
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

    public String getUapRutaCrl() {
        return uapRutaCrl;
    }

    public void setUapRutaCrl(String uapRutaCrl) {
        this.uapRutaCrl = uapRutaCrl;
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
        if (!(object instanceof MgParametroDomiciliaciones)) {
            return false;
        }
        MgParametroDomiciliaciones other = (MgParametroDomiciliaciones) object;
        if ((this.codigoEmpresa == null && other.codigoEmpresa != null) || (this.codigoEmpresa != null && !this.codigoEmpresa.equals(other.codigoEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.MgParametroDomiciliaciones[ codigoEmpresa=" + codigoEmpresa + " ]";
    }
    
}
