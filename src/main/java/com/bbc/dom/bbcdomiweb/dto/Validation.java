/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.dto;

import java.util.List;

/**
 *
 * @author Christian Gutierrez
 */
public class Validation {
        
    private String errores;
    
    private String codError;
    
    private Boolean statusRegistro;
    
    private Boolean linea;

    public String getErrores() {
        return errores;
    }

    public void setErrores(String errores) {
        this.errores = errores;
    }

    public String getCodError() {
        return codError;
    }

    public void setCodError(String codError) {
        this.codError = codError;
    }

    public Boolean getStatusRegistro() {
        return statusRegistro;
    }

    public void setStatusRegistro(Boolean statusRegistro) {
        this.statusRegistro = statusRegistro;
    }

    public Boolean getLinea() {
        return linea;
    }

    public void setLinea(Boolean linea) {
        this.linea = linea;
    }

    
    
    
    
    
    
    
}
