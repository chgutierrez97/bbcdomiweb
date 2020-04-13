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
@Table(name = "MG_ARCHIVOS_COPIADOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MgArchivosCopiados.findAll", query = "SELECT m FROM MgArchivosCopiados m")
    , @NamedQuery(name = "MgArchivosCopiados.findByNombreArchivo", query = "SELECT m FROM MgArchivosCopiados m WHERE m.nombreArchivo = :nombreArchivo")
    , @NamedQuery(name = "MgArchivosCopiados.findByTipoArchivo", query = "SELECT m FROM MgArchivosCopiados m WHERE m.tipoArchivo = :tipoArchivo")
    , @NamedQuery(name = "MgArchivosCopiados.findByFechaValida", query = "SELECT m FROM MgArchivosCopiados m WHERE m.fechaValida = :fechaValida")
    , @NamedQuery(name = "MgArchivosCopiados.findByEmpresaOrdenante", query = "SELECT m FROM MgArchivosCopiados m WHERE m.empresaOrdenante = :empresaOrdenante")
    , @NamedQuery(name = "MgArchivosCopiados.findByHoraCopia", query = "SELECT m FROM MgArchivosCopiados m WHERE m.horaCopia = :horaCopia")
    , @NamedQuery(name = "MgArchivosCopiados.findByHoraProceso", query = "SELECT m FROM MgArchivosCopiados m WHERE m.horaProceso = :horaProceso")
    , @NamedQuery(name = "MgArchivosCopiados.findByUsuarioCaptura", query = "SELECT m FROM MgArchivosCopiados m WHERE m.usuarioCaptura = :usuarioCaptura")
    , @NamedQuery(name = "MgArchivosCopiados.findByProcesado", query = "SELECT m FROM MgArchivosCopiados m WHERE m.procesado = :procesado")
    , @NamedQuery(name = "MgArchivosCopiados.findByComentario", query = "SELECT m FROM MgArchivosCopiados m WHERE m.comentario = :comentario")
    , @NamedQuery(name = "MgArchivosCopiados.findByErrorProcesando", query = "SELECT m FROM MgArchivosCopiados m WHERE m.errorProcesando = :errorProcesando")
    , @NamedQuery(name = "MgArchivosCopiados.findByCantidadRegistros", query = "SELECT m FROM MgArchivosCopiados m WHERE m.cantidadRegistros = :cantidadRegistros")
    , @NamedQuery(name = "MgArchivosCopiados.findByComandoOrdGenerado", query = "SELECT m FROM MgArchivosCopiados m WHERE m.comandoOrdGenerado = :comandoOrdGenerado")})
public class MgArchivosCopiados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "NOMBRE_ARCHIVO")
    private String nombreArchivo;
    @Size(max = 2)
    @Column(name = "TIPO_ARCHIVO")
    private String tipoArchivo;
    @Column(name = "FECHA_VALIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaValida;
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
    @Size(max = 50)
    @Column(name = "COMANDO_ORD_GENERADO")
    private String comandoOrdGenerado;

    public MgArchivosCopiados() {
    }

    public MgArchivosCopiados(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getTipoArchivo() {
        return tipoArchivo;
    }

    public void setTipoArchivo(String tipoArchivo) {
        this.tipoArchivo = tipoArchivo;
    }

    public Date getFechaValida() {
        return fechaValida;
    }

    public void setFechaValida(Date fechaValida) {
        this.fechaValida = fechaValida;
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

    public String getComandoOrdGenerado() {
        return comandoOrdGenerado;
    }

    public void setComandoOrdGenerado(String comandoOrdGenerado) {
        this.comandoOrdGenerado = comandoOrdGenerado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombreArchivo != null ? nombreArchivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MgArchivosCopiados)) {
            return false;
        }
        MgArchivosCopiados other = (MgArchivosCopiados) object;
        if ((this.nombreArchivo == null && other.nombreArchivo != null) || (this.nombreArchivo != null && !this.nombreArchivo.equals(other.nombreArchivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.MgArchivosCopiados[ nombreArchivo=" + nombreArchivo + " ]";
    }
    
}
