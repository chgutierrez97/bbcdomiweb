package com.bbc.dom.bbcdomiweb.dto;

import java.util.Date;

/**
 *
 * @author Christian Gutierrez
 */
public class IbDomiciliacionesDetDTO {

    private Integer id;

    private int idAfi;

    private String codOrdenante;

    private String claveOrdenente;

    private String tipoOperacion;

    private String subTipoDominio;

    private String ctaPagador;

    private String monto;

    private String tipoPagador;

    private String identificadorPagador;

    private String nombrePagador;

    private String refContrato;

    private String facturaNumero;

    private String fechaEmisionFactura;

    private String fechaVencimientoFactura;

    private int codUsuarioCarga;

    private Date fechaCargar;

    private String Linea;

    private Boolean Status;

    private String errorInLine;

    private Long codLote;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdAfi() {
        return idAfi;
    }

    public void setIdAfi(int idAfi) {
        this.idAfi = idAfi;
    }

    public String getCodOrdenante() {
        return codOrdenante;
    }

    public void setCodOrdenante(String codOrdenante) {
        this.codOrdenante = codOrdenante;
    }

    public String getClaveOrdenente() {
        return claveOrdenente;
    }

    public void setClaveOrdenente(String claveOrdenente) {
        this.claveOrdenente = claveOrdenente;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public String getSubTipoDominio() {
        return subTipoDominio;
    }

    public void setSubTipoDominio(String subTipoDominio) {
        this.subTipoDominio = subTipoDominio;
    }

    public String getCtaPagador() {
        return ctaPagador;
    }

    public void setCtaPagador(String ctaPagador) {
        this.ctaPagador = ctaPagador;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getTipoPagador() {
        return tipoPagador;
    }

    public void setTipoPagador(String tipoPagador) {
        this.tipoPagador = tipoPagador;
    }

    public String getIdentificadorPagador() {
        return identificadorPagador;
    }

    public void setIdentificadorPagador(String identificadorPagador) {
        this.identificadorPagador = identificadorPagador;
    }

    public String getNombrePagador() {
        return nombrePagador;
    }

    public void setNombrePagador(String nombrePagador) {
        this.nombrePagador = nombrePagador;
    }

    public String getRefContrato() {
        return refContrato;
    }

    public void setRefContrato(String refContrato) {
        this.refContrato = refContrato;
    }

    public String getFacturaNumero() {
        return facturaNumero;
    }

    public void setFacturaNumero(String facturaNumero) {
        this.facturaNumero = facturaNumero;
    }

    public String getFechaEmisionFactura() {
        return fechaEmisionFactura;
    }

    public void setFechaEmisionFactura(String fechaEmisionFactura) {
        this.fechaEmisionFactura = fechaEmisionFactura;
    }

    public String getFechaVencimientoFactura() {
        return fechaVencimientoFactura;
    }

    public void setFechaVencimientoFactura(String fechaVencimientoFactura) {
        this.fechaVencimientoFactura = fechaVencimientoFactura;
    }

    public int getCodUsuarioCarga() {
        return codUsuarioCarga;
    }

    public void setCodUsuarioCarga(int codUsuarioCarga) {
        this.codUsuarioCarga = codUsuarioCarga;
    }

    public Date getFechaCargar() {
        return fechaCargar;
    }

    public void setFechaCargar(Date fechaCargar) {
        this.fechaCargar = fechaCargar;
    }

    public String getLinea() {
        return Linea;
    }

    public void setLinea(String Linea) {
        this.Linea = Linea;
    }

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean Status) {
        this.Status = Status;
    }

    public String getErrorInLine() {
        return errorInLine;
    }

    public void setErrorInLine(String errorInLine) {
        this.errorInLine = errorInLine;
    }

    public Long getCodLote() {
        return codLote;
    }

    public void setCodLote(Long codLote) {
        this.codLote = codLote;
    }

    @Override
    public String toString() {
        return "IbDomiciliacionesDetDTO{" + "id=" + id + ", idAfi=" + idAfi + ", codOrdenante=" + codOrdenante + ", claveOrdenente=" + claveOrdenente + ", tipoOperacion=" + tipoOperacion + ", subTipoDominio=" + subTipoDominio + ", ctaPagador=" + ctaPagador + ", monto=" + monto + ", tipoPagador=" + tipoPagador + ", identificadorPagador=" + identificadorPagador + ", nombrePagador=" + nombrePagador + ", refContrato=" + refContrato + ", facturaNumero=" + facturaNumero + ", fechaEmisionFactura=" + fechaEmisionFactura + ", fechaVencimientoFactura=" + fechaVencimientoFactura + ", codUsuarioCarga=" + codUsuarioCarga + ", fechaCargar=" + fechaCargar + ", Linea=" + Linea + ", Status=" + Status + ", errorInLine=" + errorInLine + '}';
    }

}
