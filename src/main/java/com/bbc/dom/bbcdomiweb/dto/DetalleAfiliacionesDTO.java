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
public class DetalleAfiliacionesDTO {
     private String tipoOperacion;
     private String identificacionPagador;
     private String nombrePagador;  
     private String cuentaPagador;     
     private String contrato;
     private String codigoResultado;
     private String situacion;
     private boolean swOrdenantes;
     private String motivoRechazo;

    public DetalleAfiliacionesDTO() {
    }

    public DetalleAfiliacionesDTO(String tipoOperacion, String identificacionPagador, String nombrePagador, String cuentaPagador, String contrato, String codigoResultado, String situacion) {
        this.tipoOperacion = tipoOperacion;
        this.identificacionPagador = identificacionPagador;
        this.nombrePagador = nombrePagador;
        this.cuentaPagador = cuentaPagador;
        this.contrato = contrato;
        this.codigoResultado = codigoResultado;
        this.situacion = situacion;
    }

  
    
    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
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

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
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

    public boolean isSwOrdenantes() {
        return swOrdenantes;
    }

    public void setSwOrdenantes(boolean swOrdenantes) {
        this.swOrdenantes = swOrdenantes;
    }

    public String getMotivoRechazo() {
        return motivoRechazo;
    }

    public void setMotivoRechazo(String motivoRechazo) {
        this.motivoRechazo = motivoRechazo;
    }
    
    @Override
    public String toString() {
        return "DetalleAfiliacionesDTO{" + "tipoOperacion=" + tipoOperacion + ", identificacionPagador=" + identificacionPagador + ", nombrePagador=" + nombrePagador + ", cuentaPagador=" + cuentaPagador + ", contrato=" + contrato + ", codigoResultado=" + codigoResultado + ", situacion=" + situacion + '}';
    }
       
}
