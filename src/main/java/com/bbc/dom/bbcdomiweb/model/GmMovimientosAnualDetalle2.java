/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "GM_MOVIMIENTOS_ANUAL_DETALLE_2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GmMovimientosAnualDetalle2.findAll", query = "SELECT g FROM GmMovimientosAnualDetalle2 g")
    , @NamedQuery(name = "GmMovimientosAnualDetalle2.findByUsuario", query = "SELECT g FROM GmMovimientosAnualDetalle2 g WHERE g.gmMovimientosAnualDetalle2PK.usuario = :usuario")
    , @NamedQuery(name = "GmMovimientosAnualDetalle2.findByNumeroMovimiento", query = "SELECT g FROM GmMovimientosAnualDetalle2 g WHERE g.gmMovimientosAnualDetalle2PK.numeroMovimiento = :numeroMovimiento")
    , @NamedQuery(name = "GmMovimientosAnualDetalle2.findByFechaMovimiento", query = "SELECT g FROM GmMovimientosAnualDetalle2 g WHERE g.gmMovimientosAnualDetalle2PK.fechaMovimiento = :fechaMovimiento")
    , @NamedQuery(name = "GmMovimientosAnualDetalle2.findBySecuenciaRenglon", query = "SELECT g FROM GmMovimientosAnualDetalle2 g WHERE g.gmMovimientosAnualDetalle2PK.secuenciaRenglon = :secuenciaRenglon")
    , @NamedQuery(name = "GmMovimientosAnualDetalle2.findByUsuarioAutorizador", query = "SELECT g FROM GmMovimientosAnualDetalle2 g WHERE g.usuarioAutorizador = :usuarioAutorizador")
    , @NamedQuery(name = "GmMovimientosAnualDetalle2.findByNumeroAutorizacion", query = "SELECT g FROM GmMovimientosAnualDetalle2 g WHERE g.numeroAutorizacion = :numeroAutorizacion")
    , @NamedQuery(name = "GmMovimientosAnualDetalle2.findByNivel1", query = "SELECT g FROM GmMovimientosAnualDetalle2 g WHERE g.nivel1 = :nivel1")
    , @NamedQuery(name = "GmMovimientosAnualDetalle2.findByNivel2", query = "SELECT g FROM GmMovimientosAnualDetalle2 g WHERE g.nivel2 = :nivel2")
    , @NamedQuery(name = "GmMovimientosAnualDetalle2.findByNivel3", query = "SELECT g FROM GmMovimientosAnualDetalle2 g WHERE g.nivel3 = :nivel3")
    , @NamedQuery(name = "GmMovimientosAnualDetalle2.findByNivel4", query = "SELECT g FROM GmMovimientosAnualDetalle2 g WHERE g.nivel4 = :nivel4")
    , @NamedQuery(name = "GmMovimientosAnualDetalle2.findByNivel5", query = "SELECT g FROM GmMovimientosAnualDetalle2 g WHERE g.nivel5 = :nivel5")
    , @NamedQuery(name = "GmMovimientosAnualDetalle2.findByNivel6", query = "SELECT g FROM GmMovimientosAnualDetalle2 g WHERE g.nivel6 = :nivel6")
    , @NamedQuery(name = "GmMovimientosAnualDetalle2.findByNivel7", query = "SELECT g FROM GmMovimientosAnualDetalle2 g WHERE g.nivel7 = :nivel7")
    , @NamedQuery(name = "GmMovimientosAnualDetalle2.findByNivel8", query = "SELECT g FROM GmMovimientosAnualDetalle2 g WHERE g.nivel8 = :nivel8")
    , @NamedQuery(name = "GmMovimientosAnualDetalle2.findByCodigoMoneda", query = "SELECT g FROM GmMovimientosAnualDetalle2 g WHERE g.codigoMoneda = :codigoMoneda")
    , @NamedQuery(name = "GmMovimientosAnualDetalle2.findByCodigoAuxiliar", query = "SELECT g FROM GmMovimientosAnualDetalle2 g WHERE g.codigoAuxiliar = :codigoAuxiliar")
    , @NamedQuery(name = "GmMovimientosAnualDetalle2.findByFechaValida", query = "SELECT g FROM GmMovimientosAnualDetalle2 g WHERE g.fechaValida = :fechaValida")
    , @NamedQuery(name = "GmMovimientosAnualDetalle2.findByDebitoCredito", query = "SELECT g FROM GmMovimientosAnualDetalle2 g WHERE g.debitoCredito = :debitoCredito")
    , @NamedQuery(name = "GmMovimientosAnualDetalle2.findByMontoMovimiento", query = "SELECT g FROM GmMovimientosAnualDetalle2 g WHERE g.montoMovimiento = :montoMovimiento")
    , @NamedQuery(name = "GmMovimientosAnualDetalle2.findByMovimientoAjuste", query = "SELECT g FROM GmMovimientosAnualDetalle2 g WHERE g.movimientoAjuste = :movimientoAjuste")
    , @NamedQuery(name = "GmMovimientosAnualDetalle2.findByTasaCambio", query = "SELECT g FROM GmMovimientosAnualDetalle2 g WHERE g.tasaCambio = :tasaCambio")
    , @NamedQuery(name = "GmMovimientosAnualDetalle2.findByFechaTasaCambio", query = "SELECT g FROM GmMovimientosAnualDetalle2 g WHERE g.fechaTasaCambio = :fechaTasaCambio")
    , @NamedQuery(name = "GmMovimientosAnualDetalle2.findByMontoMovimientoLocal", query = "SELECT g FROM GmMovimientosAnualDetalle2 g WHERE g.montoMovimientoLocal = :montoMovimientoLocal")
    , @NamedQuery(name = "GmMovimientosAnualDetalle2.findByDescripcionDetalle", query = "SELECT g FROM GmMovimientosAnualDetalle2 g WHERE g.descripcionDetalle = :descripcionDetalle")
    , @NamedQuery(name = "GmMovimientosAnualDetalle2.findByReferencia", query = "SELECT g FROM GmMovimientosAnualDetalle2 g WHERE g.referencia = :referencia")
    , @NamedQuery(name = "GmMovimientosAnualDetalle2.findByCodigoEmpresa", query = "SELECT g FROM GmMovimientosAnualDetalle2 g WHERE g.codigoEmpresa = :codigoEmpresa")
    , @NamedQuery(name = "GmMovimientosAnualDetalle2.findByCodigoGerencia", query = "SELECT g FROM GmMovimientosAnualDetalle2 g WHERE g.codigoGerencia = :codigoGerencia")
    , @NamedQuery(name = "GmMovimientosAnualDetalle2.findByCodigoSubgerencia", query = "SELECT g FROM GmMovimientosAnualDetalle2 g WHERE g.codigoSubgerencia = :codigoSubgerencia")
    , @NamedQuery(name = "GmMovimientosAnualDetalle2.findByCodigoAsistencia", query = "SELECT g FROM GmMovimientosAnualDetalle2 g WHERE g.codigoAsistencia = :codigoAsistencia")
    , @NamedQuery(name = "GmMovimientosAnualDetalle2.findByCodigoDepartamentoEmpresa", query = "SELECT g FROM GmMovimientosAnualDetalle2 g WHERE g.codigoDepartamentoEmpresa = :codigoDepartamentoEmpresa")
    , @NamedQuery(name = "GmMovimientosAnualDetalle2.findByCodigoSeccion", query = "SELECT g FROM GmMovimientosAnualDetalle2 g WHERE g.codigoSeccion = :codigoSeccion")
    , @NamedQuery(name = "GmMovimientosAnualDetalle2.findByCodigoUnidad", query = "SELECT g FROM GmMovimientosAnualDetalle2 g WHERE g.codigoUnidad = :codigoUnidad")
    , @NamedQuery(name = "GmMovimientosAnualDetalle2.findByCentroDeCosto", query = "SELECT g FROM GmMovimientosAnualDetalle2 g WHERE g.centroDeCosto = :centroDeCosto")
    , @NamedQuery(name = "GmMovimientosAnualDetalle2.findByCodigoPresupuesto", query = "SELECT g FROM GmMovimientosAnualDetalle2 g WHERE g.codigoPresupuesto = :codigoPresupuesto")
    , @NamedQuery(name = "GmMovimientosAnualDetalle2.findByClasePresupuesto", query = "SELECT g FROM GmMovimientosAnualDetalle2 g WHERE g.clasePresupuesto = :clasePresupuesto")
    , @NamedQuery(name = "GmMovimientosAnualDetalle2.findByNumeroOrden", query = "SELECT g FROM GmMovimientosAnualDetalle2 g WHERE g.numeroOrden = :numeroOrden")
    , @NamedQuery(name = "GmMovimientosAnualDetalle2.findByNumeroItemOrden", query = "SELECT g FROM GmMovimientosAnualDetalle2 g WHERE g.numeroItemOrden = :numeroItemOrden")
    , @NamedQuery(name = "GmMovimientosAnualDetalle2.findByCodigoAuxiliarRef", query = "SELECT g FROM GmMovimientosAnualDetalle2 g WHERE g.codigoAuxiliarRef = :codigoAuxiliarRef")
    , @NamedQuery(name = "GmMovimientosAnualDetalle2.findByCodigoCompania", query = "SELECT g FROM GmMovimientosAnualDetalle2 g WHERE g.codigoCompania = :codigoCompania")})
public class GmMovimientosAnualDetalle2 implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GmMovimientosAnualDetalle2PK gmMovimientosAnualDetalle2PK;
    @Size(max = 10)
    @Column(name = "USUARIO_AUTORIZADOR")
    private String usuarioAutorizador;
    @Column(name = "NUMERO_AUTORIZACION")
    private Long numeroAutorizacion;
    @Size(max = 4)
    @Column(name = "NIVEL_1")
    private String nivel1;
    @Size(max = 4)
    @Column(name = "NIVEL_2")
    private String nivel2;
    @Size(max = 4)
    @Column(name = "NIVEL_3")
    private String nivel3;
    @Size(max = 4)
    @Column(name = "NIVEL_4")
    private String nivel4;
    @Size(max = 4)
    @Column(name = "NIVEL_5")
    private String nivel5;
    @Size(max = 4)
    @Column(name = "NIVEL_6")
    private String nivel6;
    @Size(max = 4)
    @Column(name = "NIVEL_7")
    private String nivel7;
    @Size(max = 4)
    @Column(name = "NIVEL_8")
    private String nivel8;
    @Column(name = "CODIGO_MONEDA")
    private Short codigoMoneda;
    @Column(name = "CODIGO_AUXILIAR")
    private Integer codigoAuxiliar;
    @Column(name = "FECHA_VALIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaValida;
    @Size(max = 1)
    @Column(name = "DEBITO_CREDITO")
    private String debitoCredito;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MONTO_MOVIMIENTO")
    private BigDecimal montoMovimiento;
    @Size(max = 1)
    @Column(name = "MOVIMIENTO_AJUSTE")
    private String movimientoAjuste;
    @Column(name = "TASA_CAMBIO")
    private BigDecimal tasaCambio;
    @Column(name = "FECHA_TASA_CAMBIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTasaCambio;
    @Column(name = "MONTO_MOVIMIENTO_LOCAL")
    private BigDecimal montoMovimientoLocal;
    @Size(max = 2000)
    @Column(name = "DESCRIPCION_DETALLE")
    private String descripcionDetalle;
    @Size(max = 10)
    @Column(name = "REFERENCIA")
    private String referencia;
    @Column(name = "CODIGO_EMPRESA")
    private Short codigoEmpresa;
    @Column(name = "CODIGO_GERENCIA")
    private Short codigoGerencia;
    @Column(name = "CODIGO_SUBGERENCIA")
    private Short codigoSubgerencia;
    @Column(name = "CODIGO_ASISTENCIA")
    private Short codigoAsistencia;
    @Column(name = "CODIGO_DEPARTAMENTO_EMPRESA")
    private Short codigoDepartamentoEmpresa;
    @Column(name = "CODIGO_SECCION")
    private Short codigoSeccion;
    @Column(name = "CODIGO_UNIDAD")
    private Short codigoUnidad;
    @Column(name = "CENTRO_DE_COSTO")
    private Short centroDeCosto;
    @Column(name = "CODIGO_PRESUPUESTO")
    private Short codigoPresupuesto;
    @Column(name = "CLASE_PRESUPUESTO")
    private Short clasePresupuesto;
    @Column(name = "NUMERO_ORDEN")
    private Integer numeroOrden;
    @Column(name = "NUMERO_ITEM_ORDEN")
    private Short numeroItemOrden;
    @Column(name = "CODIGO_AUXILIAR_REF")
    private Integer codigoAuxiliarRef;
    @Column(name = "CODIGO_COMPANIA")
    private Short codigoCompania;

    public GmMovimientosAnualDetalle2() {
    }

    public GmMovimientosAnualDetalle2(GmMovimientosAnualDetalle2PK gmMovimientosAnualDetalle2PK) {
        this.gmMovimientosAnualDetalle2PK = gmMovimientosAnualDetalle2PK;
    }

    public GmMovimientosAnualDetalle2(String usuario, int numeroMovimiento, Date fechaMovimiento, BigInteger secuenciaRenglon) {
        this.gmMovimientosAnualDetalle2PK = new GmMovimientosAnualDetalle2PK(usuario, numeroMovimiento, fechaMovimiento, secuenciaRenglon);
    }

    public GmMovimientosAnualDetalle2PK getGmMovimientosAnualDetalle2PK() {
        return gmMovimientosAnualDetalle2PK;
    }

    public void setGmMovimientosAnualDetalle2PK(GmMovimientosAnualDetalle2PK gmMovimientosAnualDetalle2PK) {
        this.gmMovimientosAnualDetalle2PK = gmMovimientosAnualDetalle2PK;
    }

    public String getUsuarioAutorizador() {
        return usuarioAutorizador;
    }

    public void setUsuarioAutorizador(String usuarioAutorizador) {
        this.usuarioAutorizador = usuarioAutorizador;
    }

    public Long getNumeroAutorizacion() {
        return numeroAutorizacion;
    }

    public void setNumeroAutorizacion(Long numeroAutorizacion) {
        this.numeroAutorizacion = numeroAutorizacion;
    }

    public String getNivel1() {
        return nivel1;
    }

    public void setNivel1(String nivel1) {
        this.nivel1 = nivel1;
    }

    public String getNivel2() {
        return nivel2;
    }

    public void setNivel2(String nivel2) {
        this.nivel2 = nivel2;
    }

    public String getNivel3() {
        return nivel3;
    }

    public void setNivel3(String nivel3) {
        this.nivel3 = nivel3;
    }

    public String getNivel4() {
        return nivel4;
    }

    public void setNivel4(String nivel4) {
        this.nivel4 = nivel4;
    }

    public String getNivel5() {
        return nivel5;
    }

    public void setNivel5(String nivel5) {
        this.nivel5 = nivel5;
    }

    public String getNivel6() {
        return nivel6;
    }

    public void setNivel6(String nivel6) {
        this.nivel6 = nivel6;
    }

    public String getNivel7() {
        return nivel7;
    }

    public void setNivel7(String nivel7) {
        this.nivel7 = nivel7;
    }

    public String getNivel8() {
        return nivel8;
    }

    public void setNivel8(String nivel8) {
        this.nivel8 = nivel8;
    }

    public Short getCodigoMoneda() {
        return codigoMoneda;
    }

    public void setCodigoMoneda(Short codigoMoneda) {
        this.codigoMoneda = codigoMoneda;
    }

    public Integer getCodigoAuxiliar() {
        return codigoAuxiliar;
    }

    public void setCodigoAuxiliar(Integer codigoAuxiliar) {
        this.codigoAuxiliar = codigoAuxiliar;
    }

    public Date getFechaValida() {
        return fechaValida;
    }

    public void setFechaValida(Date fechaValida) {
        this.fechaValida = fechaValida;
    }

    public String getDebitoCredito() {
        return debitoCredito;
    }

    public void setDebitoCredito(String debitoCredito) {
        this.debitoCredito = debitoCredito;
    }

    public BigDecimal getMontoMovimiento() {
        return montoMovimiento;
    }

    public void setMontoMovimiento(BigDecimal montoMovimiento) {
        this.montoMovimiento = montoMovimiento;
    }

    public String getMovimientoAjuste() {
        return movimientoAjuste;
    }

    public void setMovimientoAjuste(String movimientoAjuste) {
        this.movimientoAjuste = movimientoAjuste;
    }

    public BigDecimal getTasaCambio() {
        return tasaCambio;
    }

    public void setTasaCambio(BigDecimal tasaCambio) {
        this.tasaCambio = tasaCambio;
    }

    public Date getFechaTasaCambio() {
        return fechaTasaCambio;
    }

    public void setFechaTasaCambio(Date fechaTasaCambio) {
        this.fechaTasaCambio = fechaTasaCambio;
    }

    public BigDecimal getMontoMovimientoLocal() {
        return montoMovimientoLocal;
    }

    public void setMontoMovimientoLocal(BigDecimal montoMovimientoLocal) {
        this.montoMovimientoLocal = montoMovimientoLocal;
    }

    public String getDescripcionDetalle() {
        return descripcionDetalle;
    }

    public void setDescripcionDetalle(String descripcionDetalle) {
        this.descripcionDetalle = descripcionDetalle;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Short getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public void setCodigoEmpresa(Short codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    public Short getCodigoGerencia() {
        return codigoGerencia;
    }

    public void setCodigoGerencia(Short codigoGerencia) {
        this.codigoGerencia = codigoGerencia;
    }

    public Short getCodigoSubgerencia() {
        return codigoSubgerencia;
    }

    public void setCodigoSubgerencia(Short codigoSubgerencia) {
        this.codigoSubgerencia = codigoSubgerencia;
    }

    public Short getCodigoAsistencia() {
        return codigoAsistencia;
    }

    public void setCodigoAsistencia(Short codigoAsistencia) {
        this.codigoAsistencia = codigoAsistencia;
    }

    public Short getCodigoDepartamentoEmpresa() {
        return codigoDepartamentoEmpresa;
    }

    public void setCodigoDepartamentoEmpresa(Short codigoDepartamentoEmpresa) {
        this.codigoDepartamentoEmpresa = codigoDepartamentoEmpresa;
    }

    public Short getCodigoSeccion() {
        return codigoSeccion;
    }

    public void setCodigoSeccion(Short codigoSeccion) {
        this.codigoSeccion = codigoSeccion;
    }

    public Short getCodigoUnidad() {
        return codigoUnidad;
    }

    public void setCodigoUnidad(Short codigoUnidad) {
        this.codigoUnidad = codigoUnidad;
    }

    public Short getCentroDeCosto() {
        return centroDeCosto;
    }

    public void setCentroDeCosto(Short centroDeCosto) {
        this.centroDeCosto = centroDeCosto;
    }

    public Short getCodigoPresupuesto() {
        return codigoPresupuesto;
    }

    public void setCodigoPresupuesto(Short codigoPresupuesto) {
        this.codigoPresupuesto = codigoPresupuesto;
    }

    public Short getClasePresupuesto() {
        return clasePresupuesto;
    }

    public void setClasePresupuesto(Short clasePresupuesto) {
        this.clasePresupuesto = clasePresupuesto;
    }

    public Integer getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(Integer numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public Short getNumeroItemOrden() {
        return numeroItemOrden;
    }

    public void setNumeroItemOrden(Short numeroItemOrden) {
        this.numeroItemOrden = numeroItemOrden;
    }

    public Integer getCodigoAuxiliarRef() {
        return codigoAuxiliarRef;
    }

    public void setCodigoAuxiliarRef(Integer codigoAuxiliarRef) {
        this.codigoAuxiliarRef = codigoAuxiliarRef;
    }

    public Short getCodigoCompania() {
        return codigoCompania;
    }

    public void setCodigoCompania(Short codigoCompania) {
        this.codigoCompania = codigoCompania;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gmMovimientosAnualDetalle2PK != null ? gmMovimientosAnualDetalle2PK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GmMovimientosAnualDetalle2)) {
            return false;
        }
        GmMovimientosAnualDetalle2 other = (GmMovimientosAnualDetalle2) object;
        if ((this.gmMovimientosAnualDetalle2PK == null && other.gmMovimientosAnualDetalle2PK != null) || (this.gmMovimientosAnualDetalle2PK != null && !this.gmMovimientosAnualDetalle2PK.equals(other.gmMovimientosAnualDetalle2PK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.GmMovimientosAnualDetalle2[ gmMovimientosAnualDetalle2PK=" + gmMovimientosAnualDetalle2PK + " ]";
    }
    
}
