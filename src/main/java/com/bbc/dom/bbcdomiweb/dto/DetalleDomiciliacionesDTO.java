/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.dto;

/**
 *
 * @author Christian Gutierrez
 */
public class DetalleDomiciliacionesDTO {
    
     private String identificacionPagador;
     private String nombrePagador;  
     private String cuentaPagador; 
     private String Monto;
     private String factura;
     private String emision;
     private String vencimiento;
     private String Descripcion;
     private String codigoResultado;
     private String situacion;
     private String fechaCarga;
     private String cobroExitoso;

    public DetalleDomiciliacionesDTO() {
    }

    public DetalleDomiciliacionesDTO(String identificacionPagador, String nombrePagador, String cuentaPagador, String Monto, String factura, String emision, String vencimiento, String codigoResultado, String situacion) {
        this.identificacionPagador = identificacionPagador;
        this.nombrePagador = nombrePagador;
        this.cuentaPagador = cuentaPagador;
        this.Monto = Monto;
        this.factura = factura;
        this.emision = emision;
        this.vencimiento = vencimiento;
        this.codigoResultado = codigoResultado;
        this.situacion = situacion;
    }

    public String getIdentificacionPagador() {
        return identificacionPagador;
    }

    public void setIdentificacionPagador(String identificacionPagador) {
        this.identificacionPagador = identificacionPagador;
    }

    public String getNombrePagador() {
        return nombrePagador;
    }

    public void setNombrePagador(String nombrePagador) {
        this.nombrePagador = nombrePagador;
    }

    public String getCuentaPagador() {
        return cuentaPagador;
    }

    public void setCuentaPagador(String cuentaPagador) {
        this.cuentaPagador = cuentaPagador;
    }

    public String getMonto() {
        return Monto;
    }

    public void setMonto(String Monto) {
        this.Monto = Monto;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public String getEmision() {
        return emision;
    }

    public void setEmision(String emision) {
        this.emision = emision;
    }

    public String getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(String vencimiento) {
        this.vencimiento = vencimiento;
    }

    public String getCodigoResultado() {
        return codigoResultado;
    }

    public void setCodigoResultado(String codigoResultado) {
        this.codigoResultado = codigoResultado;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getFechaCarga() {
        return fechaCarga;
    }

    public void setFechaCarga(String fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    public String getCobroExitoso() {
        return cobroExitoso;
    }

    public void setCobroExitoso(String cobroExitoso) {
        this.cobroExitoso = cobroExitoso;
    }

    @Override
    public String toString() {
        return "DetalleDomiciliacionesDTO{" + "identificacionPagador=" + identificacionPagador + ", nombrePagador=" + nombrePagador + ", cuentaPagador=" + cuentaPagador + ", Monto=" + Monto + ", factura=" + factura + ", emision=" + emision + ", vencimiento=" + vencimiento + ", Descripcion=" + Descripcion + ", codigoResultado=" + codigoResultado + ", situacion=" + situacion + ", fechaCarga=" + fechaCarga + '}';
    }
    
}
