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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "MG_CALENDARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MgCalendario.findAll", query = "SELECT m FROM MgCalendario m")
    , @NamedQuery(name = "MgCalendario.findByCodigoEmpresa", query = "SELECT m FROM MgCalendario m WHERE m.mgCalendarioPK.codigoEmpresa = :codigoEmpresa")
    , @NamedQuery(name = "MgCalendario.findByCodigoAplicacion", query = "SELECT m FROM MgCalendario m WHERE m.mgCalendarioPK.codigoAplicacion = :codigoAplicacion")
    , @NamedQuery(name = "MgCalendario.findByFechaHoy", query = "SELECT m FROM MgCalendario m WHERE m.fechaHoy = :fechaHoy")
    , @NamedQuery(name = "MgCalendario.findByNombreDia", query = "SELECT m FROM MgCalendario m WHERE m.nombreDia = :nombreDia")
    , @NamedQuery(name = "MgCalendario.findByFechaAnterior", query = "SELECT m FROM MgCalendario m WHERE m.fechaAnterior = :fechaAnterior")
    , @NamedQuery(name = "MgCalendario.findByProximaFecha", query = "SELECT m FROM MgCalendario m WHERE m.proximaFecha = :proximaFecha")
    , @NamedQuery(name = "MgCalendario.findByPrimerDiaMes", query = "SELECT m FROM MgCalendario m WHERE m.primerDiaMes = :primerDiaMes")
    , @NamedQuery(name = "MgCalendario.findByPrimerHabilMes", query = "SELECT m FROM MgCalendario m WHERE m.primerHabilMes = :primerHabilMes")
    , @NamedQuery(name = "MgCalendario.findByUltimoDiaMes", query = "SELECT m FROM MgCalendario m WHERE m.ultimoDiaMes = :ultimoDiaMes")
    , @NamedQuery(name = "MgCalendario.findByUltimoHabilMes", query = "SELECT m FROM MgCalendario m WHERE m.ultimoHabilMes = :ultimoHabilMes")
    , @NamedQuery(name = "MgCalendario.findByNumeroBimestre", query = "SELECT m FROM MgCalendario m WHERE m.numeroBimestre = :numeroBimestre")
    , @NamedQuery(name = "MgCalendario.findByMesInicialBimestre", query = "SELECT m FROM MgCalendario m WHERE m.mesInicialBimestre = :mesInicialBimestre")
    , @NamedQuery(name = "MgCalendario.findByMesFinalBimestre", query = "SELECT m FROM MgCalendario m WHERE m.mesFinalBimestre = :mesFinalBimestre")
    , @NamedQuery(name = "MgCalendario.findByPrimerDiaBimestre", query = "SELECT m FROM MgCalendario m WHERE m.primerDiaBimestre = :primerDiaBimestre")
    , @NamedQuery(name = "MgCalendario.findByPrimerHabilBimestre", query = "SELECT m FROM MgCalendario m WHERE m.primerHabilBimestre = :primerHabilBimestre")
    , @NamedQuery(name = "MgCalendario.findByUltimoDiaBimestre", query = "SELECT m FROM MgCalendario m WHERE m.ultimoDiaBimestre = :ultimoDiaBimestre")
    , @NamedQuery(name = "MgCalendario.findByUltimoHabilBimestre", query = "SELECT m FROM MgCalendario m WHERE m.ultimoHabilBimestre = :ultimoHabilBimestre")
    , @NamedQuery(name = "MgCalendario.findByNumeroTrimestre", query = "SELECT m FROM MgCalendario m WHERE m.numeroTrimestre = :numeroTrimestre")
    , @NamedQuery(name = "MgCalendario.findByMesInicialTrimestre", query = "SELECT m FROM MgCalendario m WHERE m.mesInicialTrimestre = :mesInicialTrimestre")
    , @NamedQuery(name = "MgCalendario.findByMesFinalTrimestre", query = "SELECT m FROM MgCalendario m WHERE m.mesFinalTrimestre = :mesFinalTrimestre")
    , @NamedQuery(name = "MgCalendario.findByPrimerDiaTrimestre", query = "SELECT m FROM MgCalendario m WHERE m.primerDiaTrimestre = :primerDiaTrimestre")
    , @NamedQuery(name = "MgCalendario.findByPrimerHabilTrimestre", query = "SELECT m FROM MgCalendario m WHERE m.primerHabilTrimestre = :primerHabilTrimestre")
    , @NamedQuery(name = "MgCalendario.findByUltimoDiaTrimestre", query = "SELECT m FROM MgCalendario m WHERE m.ultimoDiaTrimestre = :ultimoDiaTrimestre")
    , @NamedQuery(name = "MgCalendario.findByUltimoHabilTrimestre", query = "SELECT m FROM MgCalendario m WHERE m.ultimoHabilTrimestre = :ultimoHabilTrimestre")
    , @NamedQuery(name = "MgCalendario.findByNumeroSemestre", query = "SELECT m FROM MgCalendario m WHERE m.numeroSemestre = :numeroSemestre")
    , @NamedQuery(name = "MgCalendario.findByMesInicialSemestre", query = "SELECT m FROM MgCalendario m WHERE m.mesInicialSemestre = :mesInicialSemestre")
    , @NamedQuery(name = "MgCalendario.findByMesFinalSemestre", query = "SELECT m FROM MgCalendario m WHERE m.mesFinalSemestre = :mesFinalSemestre")
    , @NamedQuery(name = "MgCalendario.findByPrimerDiaSemestre", query = "SELECT m FROM MgCalendario m WHERE m.primerDiaSemestre = :primerDiaSemestre")
    , @NamedQuery(name = "MgCalendario.findByPrimerHabilSemestre", query = "SELECT m FROM MgCalendario m WHERE m.primerHabilSemestre = :primerHabilSemestre")
    , @NamedQuery(name = "MgCalendario.findByUltimoDiaSemestre", query = "SELECT m FROM MgCalendario m WHERE m.ultimoDiaSemestre = :ultimoDiaSemestre")
    , @NamedQuery(name = "MgCalendario.findByUltimoHabilSemestre", query = "SELECT m FROM MgCalendario m WHERE m.ultimoHabilSemestre = :ultimoHabilSemestre")
    , @NamedQuery(name = "MgCalendario.findByAdicionadoPor", query = "SELECT m FROM MgCalendario m WHERE m.adicionadoPor = :adicionadoPor")
    , @NamedQuery(name = "MgCalendario.findByFechaAdicion", query = "SELECT m FROM MgCalendario m WHERE m.fechaAdicion = :fechaAdicion")
    , @NamedQuery(name = "MgCalendario.findByModificadoPor", query = "SELECT m FROM MgCalendario m WHERE m.modificadoPor = :modificadoPor")
    , @NamedQuery(name = "MgCalendario.findByFechaModificacion", query = "SELECT m FROM MgCalendario m WHERE m.fechaModificacion = :fechaModificacion")
    , @NamedQuery(name = "MgCalendario.findByFechaEstadistico", query = "SELECT m FROM MgCalendario m WHERE m.fechaEstadistico = :fechaEstadistico")
    , @NamedQuery(name = "MgCalendario.findByFechaMaestro", query = "SELECT m FROM MgCalendario m WHERE m.fechaMaestro = :fechaMaestro")
    , @NamedQuery(name = "MgCalendario.findByFechaMovimiento", query = "SELECT m FROM MgCalendario m WHERE m.fechaMovimiento = :fechaMovimiento")
    , @NamedQuery(name = "MgCalendario.findByEstadoEstadistico", query = "SELECT m FROM MgCalendario m WHERE m.estadoEstadistico = :estadoEstadistico")
    , @NamedQuery(name = "MgCalendario.findByEstadoMaestro", query = "SELECT m FROM MgCalendario m WHERE m.estadoMaestro = :estadoMaestro")
    , @NamedQuery(name = "MgCalendario.findByEstadoMovimiento", query = "SELECT m FROM MgCalendario m WHERE m.estadoMovimiento = :estadoMovimiento")
    , @NamedQuery(name = "MgCalendario.findByFechaCierre", query = "SELECT m FROM MgCalendario m WHERE m.fechaCierre = :fechaCierre")
    , @NamedQuery(name = "MgCalendario.findByEstadoProcesoEspecial", query = "SELECT m FROM MgCalendario m WHERE m.estadoProcesoEspecial = :estadoProcesoEspecial")
    , @NamedQuery(name = "MgCalendario.findByFechaSiguiente", query = "SELECT m FROM MgCalendario m WHERE m.fechaSiguiente = :fechaSiguiente")
    , @NamedQuery(name = "MgCalendario.findByFechaHoyInicial", query = "SELECT m FROM MgCalendario m WHERE m.fechaHoyInicial = :fechaHoyInicial")})
public class MgCalendario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MgCalendarioPK mgCalendarioPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_HOY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoy;
    @Size(max = 9)
    @Column(name = "NOMBRE_DIA")
    private String nombreDia;
    @Column(name = "FECHA_ANTERIOR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAnterior;
    @Column(name = "PROXIMA_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date proximaFecha;
    @Column(name = "PRIMER_DIA_MES")
    @Temporal(TemporalType.TIMESTAMP)
    private Date primerDiaMes;
    @Column(name = "PRIMER_HABIL_MES")
    @Temporal(TemporalType.TIMESTAMP)
    private Date primerHabilMes;
    @Column(name = "ULTIMO_DIA_MES")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimoDiaMes;
    @Column(name = "ULTIMO_HABIL_MES")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimoHabilMes;
    @Column(name = "NUMERO_BIMESTRE")
    private Short numeroBimestre;
    @Column(name = "MES_INICIAL_BIMESTRE")
    private Short mesInicialBimestre;
    @Column(name = "MES_FINAL_BIMESTRE")
    private Short mesFinalBimestre;
    @Column(name = "PRIMER_DIA_BIMESTRE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date primerDiaBimestre;
    @Column(name = "PRIMER_HABIL_BIMESTRE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date primerHabilBimestre;
    @Column(name = "ULTIMO_DIA_BIMESTRE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimoDiaBimestre;
    @Column(name = "ULTIMO_HABIL_BIMESTRE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimoHabilBimestre;
    @Column(name = "NUMERO_TRIMESTRE")
    private Short numeroTrimestre;
    @Column(name = "MES_INICIAL_TRIMESTRE")
    private Short mesInicialTrimestre;
    @Column(name = "MES_FINAL_TRIMESTRE")
    private Short mesFinalTrimestre;
    @Column(name = "PRIMER_DIA_TRIMESTRE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date primerDiaTrimestre;
    @Column(name = "PRIMER_HABIL_TRIMESTRE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date primerHabilTrimestre;
    @Column(name = "ULTIMO_DIA_TRIMESTRE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimoDiaTrimestre;
    @Column(name = "ULTIMO_HABIL_TRIMESTRE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimoHabilTrimestre;
    @Column(name = "NUMERO_SEMESTRE")
    private Short numeroSemestre;
    @Column(name = "MES_INICIAL_SEMESTRE")
    private Short mesInicialSemestre;
    @Column(name = "MES_FINAL_SEMESTRE")
    private Short mesFinalSemestre;
    @Column(name = "PRIMER_DIA_SEMESTRE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date primerDiaSemestre;
    @Column(name = "PRIMER_HABIL_SEMESTRE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date primerHabilSemestre;
    @Column(name = "ULTIMO_DIA_SEMESTRE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimoDiaSemestre;
    @Column(name = "ULTIMO_HABIL_SEMESTRE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimoHabilSemestre;
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
    @Column(name = "FECHA_ESTADISTICO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEstadistico;
    @Column(name = "FECHA_MAESTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaMaestro;
    @Column(name = "FECHA_MOVIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaMovimiento;
    @Column(name = "ESTADO_ESTADISTICO")
    private Short estadoEstadistico;
    @Column(name = "ESTADO_MAESTRO")
    private Short estadoMaestro;
    @Column(name = "ESTADO_MOVIMIENTO")
    private Short estadoMovimiento;
    @Column(name = "FECHA_CIERRE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCierre;
    @Column(name = "ESTADO_PROCESO_ESPECIAL")
    private Short estadoProcesoEspecial;
    @Column(name = "FECHA_SIGUIENTE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSiguiente;
    @Column(name = "FECHA_HOY_INICIAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoyInicial;

    public MgCalendario() {
    }

    public MgCalendario(MgCalendarioPK mgCalendarioPK) {
        this.mgCalendarioPK = mgCalendarioPK;
    }

    public MgCalendario(MgCalendarioPK mgCalendarioPK, Date fechaHoy) {
        this.mgCalendarioPK = mgCalendarioPK;
        this.fechaHoy = fechaHoy;
    }

    public MgCalendario(short codigoEmpresa, String codigoAplicacion) {
        this.mgCalendarioPK = new MgCalendarioPK(codigoEmpresa, codigoAplicacion);
    }

    public MgCalendarioPK getMgCalendarioPK() {
        return mgCalendarioPK;
    }

    public void setMgCalendarioPK(MgCalendarioPK mgCalendarioPK) {
        this.mgCalendarioPK = mgCalendarioPK;
    }

    public Date getFechaHoy() {
        return fechaHoy;
    }

    public void setFechaHoy(Date fechaHoy) {
        this.fechaHoy = fechaHoy;
    }

    public String getNombreDia() {
        return nombreDia;
    }

    public void setNombreDia(String nombreDia) {
        this.nombreDia = nombreDia;
    }

    public Date getFechaAnterior() {
        return fechaAnterior;
    }

    public void setFechaAnterior(Date fechaAnterior) {
        this.fechaAnterior = fechaAnterior;
    }

    public Date getProximaFecha() {
        return proximaFecha;
    }

    public void setProximaFecha(Date proximaFecha) {
        this.proximaFecha = proximaFecha;
    }

    public Date getPrimerDiaMes() {
        return primerDiaMes;
    }

    public void setPrimerDiaMes(Date primerDiaMes) {
        this.primerDiaMes = primerDiaMes;
    }

    public Date getPrimerHabilMes() {
        return primerHabilMes;
    }

    public void setPrimerHabilMes(Date primerHabilMes) {
        this.primerHabilMes = primerHabilMes;
    }

    public Date getUltimoDiaMes() {
        return ultimoDiaMes;
    }

    public void setUltimoDiaMes(Date ultimoDiaMes) {
        this.ultimoDiaMes = ultimoDiaMes;
    }

    public Date getUltimoHabilMes() {
        return ultimoHabilMes;
    }

    public void setUltimoHabilMes(Date ultimoHabilMes) {
        this.ultimoHabilMes = ultimoHabilMes;
    }

    public Short getNumeroBimestre() {
        return numeroBimestre;
    }

    public void setNumeroBimestre(Short numeroBimestre) {
        this.numeroBimestre = numeroBimestre;
    }

    public Short getMesInicialBimestre() {
        return mesInicialBimestre;
    }

    public void setMesInicialBimestre(Short mesInicialBimestre) {
        this.mesInicialBimestre = mesInicialBimestre;
    }

    public Short getMesFinalBimestre() {
        return mesFinalBimestre;
    }

    public void setMesFinalBimestre(Short mesFinalBimestre) {
        this.mesFinalBimestre = mesFinalBimestre;
    }

    public Date getPrimerDiaBimestre() {
        return primerDiaBimestre;
    }

    public void setPrimerDiaBimestre(Date primerDiaBimestre) {
        this.primerDiaBimestre = primerDiaBimestre;
    }

    public Date getPrimerHabilBimestre() {
        return primerHabilBimestre;
    }

    public void setPrimerHabilBimestre(Date primerHabilBimestre) {
        this.primerHabilBimestre = primerHabilBimestre;
    }

    public Date getUltimoDiaBimestre() {
        return ultimoDiaBimestre;
    }

    public void setUltimoDiaBimestre(Date ultimoDiaBimestre) {
        this.ultimoDiaBimestre = ultimoDiaBimestre;
    }

    public Date getUltimoHabilBimestre() {
        return ultimoHabilBimestre;
    }

    public void setUltimoHabilBimestre(Date ultimoHabilBimestre) {
        this.ultimoHabilBimestre = ultimoHabilBimestre;
    }

    public Short getNumeroTrimestre() {
        return numeroTrimestre;
    }

    public void setNumeroTrimestre(Short numeroTrimestre) {
        this.numeroTrimestre = numeroTrimestre;
    }

    public Short getMesInicialTrimestre() {
        return mesInicialTrimestre;
    }

    public void setMesInicialTrimestre(Short mesInicialTrimestre) {
        this.mesInicialTrimestre = mesInicialTrimestre;
    }

    public Short getMesFinalTrimestre() {
        return mesFinalTrimestre;
    }

    public void setMesFinalTrimestre(Short mesFinalTrimestre) {
        this.mesFinalTrimestre = mesFinalTrimestre;
    }

    public Date getPrimerDiaTrimestre() {
        return primerDiaTrimestre;
    }

    public void setPrimerDiaTrimestre(Date primerDiaTrimestre) {
        this.primerDiaTrimestre = primerDiaTrimestre;
    }

    public Date getPrimerHabilTrimestre() {
        return primerHabilTrimestre;
    }

    public void setPrimerHabilTrimestre(Date primerHabilTrimestre) {
        this.primerHabilTrimestre = primerHabilTrimestre;
    }

    public Date getUltimoDiaTrimestre() {
        return ultimoDiaTrimestre;
    }

    public void setUltimoDiaTrimestre(Date ultimoDiaTrimestre) {
        this.ultimoDiaTrimestre = ultimoDiaTrimestre;
    }

    public Date getUltimoHabilTrimestre() {
        return ultimoHabilTrimestre;
    }

    public void setUltimoHabilTrimestre(Date ultimoHabilTrimestre) {
        this.ultimoHabilTrimestre = ultimoHabilTrimestre;
    }

    public Short getNumeroSemestre() {
        return numeroSemestre;
    }

    public void setNumeroSemestre(Short numeroSemestre) {
        this.numeroSemestre = numeroSemestre;
    }

    public Short getMesInicialSemestre() {
        return mesInicialSemestre;
    }

    public void setMesInicialSemestre(Short mesInicialSemestre) {
        this.mesInicialSemestre = mesInicialSemestre;
    }

    public Short getMesFinalSemestre() {
        return mesFinalSemestre;
    }

    public void setMesFinalSemestre(Short mesFinalSemestre) {
        this.mesFinalSemestre = mesFinalSemestre;
    }

    public Date getPrimerDiaSemestre() {
        return primerDiaSemestre;
    }

    public void setPrimerDiaSemestre(Date primerDiaSemestre) {
        this.primerDiaSemestre = primerDiaSemestre;
    }

    public Date getPrimerHabilSemestre() {
        return primerHabilSemestre;
    }

    public void setPrimerHabilSemestre(Date primerHabilSemestre) {
        this.primerHabilSemestre = primerHabilSemestre;
    }

    public Date getUltimoDiaSemestre() {
        return ultimoDiaSemestre;
    }

    public void setUltimoDiaSemestre(Date ultimoDiaSemestre) {
        this.ultimoDiaSemestre = ultimoDiaSemestre;
    }

    public Date getUltimoHabilSemestre() {
        return ultimoHabilSemestre;
    }

    public void setUltimoHabilSemestre(Date ultimoHabilSemestre) {
        this.ultimoHabilSemestre = ultimoHabilSemestre;
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

    public Date getFechaEstadistico() {
        return fechaEstadistico;
    }

    public void setFechaEstadistico(Date fechaEstadistico) {
        this.fechaEstadistico = fechaEstadistico;
    }

    public Date getFechaMaestro() {
        return fechaMaestro;
    }

    public void setFechaMaestro(Date fechaMaestro) {
        this.fechaMaestro = fechaMaestro;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public Short getEstadoEstadistico() {
        return estadoEstadistico;
    }

    public void setEstadoEstadistico(Short estadoEstadistico) {
        this.estadoEstadistico = estadoEstadistico;
    }

    public Short getEstadoMaestro() {
        return estadoMaestro;
    }

    public void setEstadoMaestro(Short estadoMaestro) {
        this.estadoMaestro = estadoMaestro;
    }

    public Short getEstadoMovimiento() {
        return estadoMovimiento;
    }

    public void setEstadoMovimiento(Short estadoMovimiento) {
        this.estadoMovimiento = estadoMovimiento;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public Short getEstadoProcesoEspecial() {
        return estadoProcesoEspecial;
    }

    public void setEstadoProcesoEspecial(Short estadoProcesoEspecial) {
        this.estadoProcesoEspecial = estadoProcesoEspecial;
    }

    public Date getFechaSiguiente() {
        return fechaSiguiente;
    }

    public void setFechaSiguiente(Date fechaSiguiente) {
        this.fechaSiguiente = fechaSiguiente;
    }

    public Date getFechaHoyInicial() {
        return fechaHoyInicial;
    }

    public void setFechaHoyInicial(Date fechaHoyInicial) {
        this.fechaHoyInicial = fechaHoyInicial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mgCalendarioPK != null ? mgCalendarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MgCalendario)) {
            return false;
        }
        MgCalendario other = (MgCalendario) object;
        if ((this.mgCalendarioPK == null && other.mgCalendarioPK != null) || (this.mgCalendarioPK != null && !this.mgCalendarioPK.equals(other.mgCalendarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.MgCalendario[ mgCalendarioPK=" + mgCalendarioPK + " ]";
    }
    
}
