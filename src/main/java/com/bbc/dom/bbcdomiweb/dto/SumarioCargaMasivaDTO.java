package com.bbc.dom.bbcdomiweb.dto;

import java.util.Date;

/**
 *
 * @author Christian Gutierrez
 */
public class SumarioCargaMasivaDTO {

    private Integer numRegProcesados;
    private Integer numRegRechazados;
    private Integer numRegValidados;
    private Date fechaCargaArchivo;
    private String nombreDeArchivo;
    private String fechaString;
    private Double montoTotalProcesado;
    private Double montoTotalAprovado;
    private Double montoTotalRechazado;
    private String montoTotal;

    public Integer getNumRegProcesados() {
        return numRegProcesados;
    }

    public void setNumRegProcesados(Integer numRegProcesados) {
        this.numRegProcesados = numRegProcesados;
    }

    public Integer getNumRegRechazados() {
        return numRegRechazados;
    }

    public void setNumRegRechazados(Integer numRegRechazados) {
        this.numRegRechazados = numRegRechazados;
    }

    public Integer getNumRegValidados() {
        return numRegValidados;
    }

    public void setNumRegValidados(Integer numRegValidados) {
        this.numRegValidados = numRegValidados;
    }

    public Date getFechaCargaArchivo() {
        return fechaCargaArchivo;
    }

    public void setFechaCargaArchivo(Date fechaCargaArchivo) {
        this.fechaCargaArchivo = fechaCargaArchivo;
    }

    public String getNombreDeArchivo() {
        return nombreDeArchivo;
    }

    public void setNombreDeArchivo(String nombreDeArchivo) {
        this.nombreDeArchivo = nombreDeArchivo;
    }

    public String getFechaString() {
        return fechaString;
    }

    public void setFechaString(String fechaString) {
        this.fechaString = fechaString;
    }

    public Double getMontoTotalProcesado() {
        return montoTotalProcesado;
    }

    public void setMontoTotalProcesado(Double montoTotalProcesado) {
        this.montoTotalProcesado = montoTotalProcesado;
    }

    public Double getMontoTotalAprovado() {
        return montoTotalAprovado;
    }

    public void setMontoTotalAprovado(Double montoTotalAprovado) {
        this.montoTotalAprovado = montoTotalAprovado;
    }

    public Double getMontoTotalRechazado() {
        return montoTotalRechazado;
    }

    public void setMontoTotalRechazado(Double montoTotalRechazado) {
        this.montoTotalRechazado = montoTotalRechazado;
    }

    public String getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(String montoTotal) {
        this.montoTotal = montoTotal;
    }

}
