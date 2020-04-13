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
@Table(name = "MG_ARCHIVOS_COPIADOS_UAP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MgArchivosCopiadosUap.findAll", query = "SELECT m FROM MgArchivosCopiadosUap m")
    , @NamedQuery(name = "MgArchivosCopiadosUap.findByNombreArchivo", query = "SELECT m FROM MgArchivosCopiadosUap m WHERE m.mgArchivosCopiadosUapPK.nombreArchivo = :nombreArchivo")
    , @NamedQuery(name = "MgArchivosCopiadosUap.findByTipoArchivo", query = "SELECT m FROM MgArchivosCopiadosUap m WHERE m.mgArchivosCopiadosUapPK.tipoArchivo = :tipoArchivo")
    , @NamedQuery(name = "MgArchivosCopiadosUap.findByFechaValida", query = "SELECT m FROM MgArchivosCopiadosUap m WHERE m.mgArchivosCopiadosUapPK.fechaValida = :fechaValida")
    , @NamedQuery(name = "MgArchivosCopiadosUap.findByEmpresaOrdenante", query = "SELECT m FROM MgArchivosCopiadosUap m WHERE m.empresaOrdenante = :empresaOrdenante")
    , @NamedQuery(name = "MgArchivosCopiadosUap.findByHoraCopia", query = "SELECT m FROM MgArchivosCopiadosUap m WHERE m.horaCopia = :horaCopia")
    , @NamedQuery(name = "MgArchivosCopiadosUap.findByHoraProceso", query = "SELECT m FROM MgArchivosCopiadosUap m WHERE m.horaProceso = :horaProceso")
    , @NamedQuery(name = "MgArchivosCopiadosUap.findByUsuarioCaptura", query = "SELECT m FROM MgArchivosCopiadosUap m WHERE m.usuarioCaptura = :usuarioCaptura")
    , @NamedQuery(name = "MgArchivosCopiadosUap.findByProcesado", query = "SELECT m FROM MgArchivosCopiadosUap m WHERE m.procesado = :procesado")
    , @NamedQuery(name = "MgArchivosCopiadosUap.findByComentario", query = "SELECT m FROM MgArchivosCopiadosUap m WHERE m.comentario = :comentario")
    , @NamedQuery(name = "MgArchivosCopiadosUap.findByErrorProcesando", query = "SELECT m FROM MgArchivosCopiadosUap m WHERE m.errorProcesando = :errorProcesando")
    , @NamedQuery(name = "MgArchivosCopiadosUap.findByCantidadRegistros", query = "SELECT m FROM MgArchivosCopiadosUap m WHERE m.cantidadRegistros = :cantidadRegistros")})
public class MgArchivosCopiadosUap implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MgArchivosCopiadosUapPK mgArchivosCopiadosUapPK;
    @Column(name = "EMPRESA_ORDENANTE")
    private Short empresaOrdenante;
    @Column(name = "HORA_COPIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaCopia;
    @Column(name = "HORA_PROCESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaProceso;
    @Size(max = 20)
    @Column(name = "USUARIO_CAPTURA")
    private String usuarioCaptura;
    @Size(max = 1)
    @Column(name = "PROCESADO")
    private String procesado;
    @Size(max = 300)
    @Column(name = "COMENTARIO")
    private String comentario;
    @Size(max = 1)
    @Column(name = "ERROR_PROCESANDO")
    private String errorProcesando;
    @Column(name = "CANTIDAD_REGISTROS")
    private Integer cantidadRegistros;

    public MgArchivosCopiadosUap() {
    }

    public MgArchivosCopiadosUap(MgArchivosCopiadosUapPK mgArchivosCopiadosUapPK) {
        this.mgArchivosCopiadosUapPK = mgArchivosCopiadosUapPK;
    }

    public MgArchivosCopiadosUap(String nombreArchivo, String tipoArchivo, Date fechaValida) {
        this.mgArchivosCopiadosUapPK = new MgArchivosCopiadosUapPK(nombreArchivo, tipoArchivo, fechaValida);
    }

    public MgArchivosCopiadosUapPK getMgArchivosCopiadosUapPK() {
        return mgArchivosCopiadosUapPK;
    }

    public void setMgArchivosCopiadosUapPK(MgArchivosCopiadosUapPK mgArchivosCopiadosUapPK) {
        this.mgArchivosCopiadosUapPK = mgArchivosCopiadosUapPK;
    }

    public Short getEmpresaOrdenante() {
        return empresaOrdenante;
    }

    public void setEmpresaOrdenante(Short empresaOrdenante) {
        this.empresaOrdenante = empresaOrdenante;
    }

    public Date getHoraCopia() {
        return horaCopia;
    }

    public void setHoraCopia(Date horaCopia) {
        this.horaCopia = horaCopia;
    }

    public Date getHoraProceso() {
        return horaProceso;
    }

    public void setHoraProceso(Date horaProceso) {
        this.horaProceso = horaProceso;
    }

    public String getUsuarioCaptura() {
        return usuarioCaptura;
    }

    public void setUsuarioCaptura(String usuarioCaptura) {
        this.usuarioCaptura = usuarioCaptura;
    }

    public String getProcesado() {
        return procesado;
    }

    public void setProcesado(String procesado) {
        this.procesado = procesado;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getErrorProcesando() {
        return errorProcesando;
    }

    public void setErrorProcesando(String errorProcesando) {
        this.errorProcesando = errorProcesando;
    }

    public Integer getCantidadRegistros() {
        return cantidadRegistros;
    }

    public void setCantidadRegistros(Integer cantidadRegistros) {
        this.cantidadRegistros = cantidadRegistros;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mgArchivosCopiadosUapPK != null ? mgArchivosCopiadosUapPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MgArchivosCopiadosUap)) {
            return false;
        }
        MgArchivosCopiadosUap other = (MgArchivosCopiadosUap) object;
        if ((this.mgArchivosCopiadosUapPK == null && other.mgArchivosCopiadosUapPK != null) || (this.mgArchivosCopiadosUapPK != null && !this.mgArchivosCopiadosUapPK.equals(other.mgArchivosCopiadosUapPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.MgArchivosCopiadosUap[ mgArchivosCopiadosUapPK=" + mgArchivosCopiadosUapPK + " ]";
    }
    
}
