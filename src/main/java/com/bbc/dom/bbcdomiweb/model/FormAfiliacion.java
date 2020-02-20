
package com.bbc.dom.bbcdomiweb.model;

import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Christian Gutierrez
 */
public class FormAfiliacion {
    
    private int id;

    private String codBcoDestino;
    
    private String nameBcoDestino;
   
    private String ctaBcoDestino;
   
    private String tipoOperacion;
    
    private String nameTipoOperacion;
    
    private String tipoPagador;
    
    private String tipoDoc;
    
    private String numIdentPagador;
    
    private String nombrePagador;

    private String refContrato;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String getCodBcoDestino() {
        return codBcoDestino;
    }

    public void setCodBcoDestino(String codBcoDestino) {
        this.codBcoDestino = codBcoDestino;
    }

    public String getNameBcoDestino() {
        return nameBcoDestino;
    }

    public void setNameBcoDestino(String nameBcoDestino) {
        this.nameBcoDestino = nameBcoDestino;
    }

    public String getCtaBcoDestino() {
        return ctaBcoDestino;
    }

    public void setCtaBcoDestino(String ctaBcoDestino) {
        this.ctaBcoDestino = ctaBcoDestino;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public String getNameTipoOperacion() {
        return nameTipoOperacion;
    }

    public void setNameTipoOperacion(String nameTipoOperacion) {
        this.nameTipoOperacion = nameTipoOperacion;
    }

    public String getTipoPagador() {
        return tipoPagador;
    }

    public void setTipoPagador(String tipoPagador) {
        this.tipoPagador = tipoPagador;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getNumIdentPagador() {
        return numIdentPagador;
    }

    public void setNumIdentPagador(String numIdentPagador) {
        this.numIdentPagador = numIdentPagador;
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

    @Override
    public String toString() {
        return "FormAfiliacion{" + "codBcoDestino:" + codBcoDestino + ", nameBcoDestino:" + nameBcoDestino + ", ctaBcoDestino:" + ctaBcoDestino + ", tipoOperacion:" + tipoOperacion + ", nameTipoOperacion:" + nameTipoOperacion + ", tipoPagador:" + tipoPagador + ", tipoDoc:" + tipoDoc + ", numIdentPagador:" + numIdentPagador + ", nombrePagador:" + nombrePagador + ", refContrato:" + refContrato + '}';
    }

   

    
}
