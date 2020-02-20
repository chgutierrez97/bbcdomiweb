/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */
package com.bbc.dom.bbcdomiweb.dto;

import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author Christian Gutierrez
 */
public class ConsolidadoAfiliacionesDTO {
    private Long id;
    private Date fechaHoraCarga;
    private String nombreArchivo;
    private BigInteger nroRegistrosProcesar;
    private BigInteger nroRegistrosRechazados;
    private BigInteger nroRegistrosValidados;
    private BigInteger nroRegistrosPendientes;

    public ConsolidadoAfiliacionesDTO() {
    }

    public ConsolidadoAfiliacionesDTO(Long id, Date fechaHoraCarga, String nombreArchivo, BigInteger nroRegistrosProcesar, BigInteger nroRegistrosRechazados, BigInteger nroRegistrosValidados, BigInteger nroRegistrosPendientes) {
        super();
        this.id = id;
        this.fechaHoraCarga = fechaHoraCarga;
        this.nombreArchivo = nombreArchivo;
        this.nroRegistrosProcesar = nroRegistrosProcesar;
        this.nroRegistrosRechazados = nroRegistrosRechazados;
        this.nroRegistrosValidados = nroRegistrosValidados;
        this.nroRegistrosPendientes = nroRegistrosPendientes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaHoraCarga() {
        return fechaHoraCarga;
    }

    public void setFechaHoraCarga(Date fechaHoraCarga) {
        this.fechaHoraCarga = fechaHoraCarga;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public BigInteger getNroRegistrosProcesar() {
        return nroRegistrosProcesar;
    }

    public void setNroRegistrosProcesar(BigInteger nroRegistrosProcesar) {
        this.nroRegistrosProcesar = nroRegistrosProcesar;
    }

    public BigInteger getNroRegistrosRechazados() {
        return nroRegistrosRechazados;
    }

    public void setNroRegistrosRechazados(BigInteger nroRegistrosRechazados) {
        this.nroRegistrosRechazados = nroRegistrosRechazados;
    }

    public BigInteger getNroRegistrosValidados() {
        return nroRegistrosValidados;
    }

    public void setNroRegistrosValidados(BigInteger nroRegistrosValidados) {
        this.nroRegistrosValidados = nroRegistrosValidados;
    }

    public BigInteger getNroRegistrosPendientes() {
        return nroRegistrosPendientes;
    }

    public void setNroRegistrosPendientes(BigInteger nroRegistrosPendientes) {
        this.nroRegistrosPendientes = nroRegistrosPendientes;
    }

    @Override
    public String toString() {
        return "ConsolidadoAfiliacionesDTO{" + "id:" + id + ", fechaHoraCarga:" + fechaHoraCarga + ", nombreArchivo:" + nombreArchivo + ", nroRegistrosProcesar:" + nroRegistrosProcesar + ", nroRegistrosRechazados:" + nroRegistrosRechazados + ", nroRegistrosValidados:" + nroRegistrosValidados + ", nroRegistrosPendientes:" + nroRegistrosPendientes + '}';
    }
    
}
