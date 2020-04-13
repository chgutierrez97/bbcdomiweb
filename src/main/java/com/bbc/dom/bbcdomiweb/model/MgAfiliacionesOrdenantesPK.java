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
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Christian Gutierrez
 */
@Embeddable
public class MgAfiliacionesOrdenantesPK implements Serializable {

   /* @Basic(optional = false)
    @NotNull
    @Column(name = "ELEMENTO_GRUPO")
    private int elementoGrupo;*/
//    @Column(name = "CODIGO_ORDENANTE")Verificar
//    private int codigoOrdenante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_VALIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaValida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "REGISTRO")
    private String registro;

    public MgAfiliacionesOrdenantesPK() {
    }

    public MgAfiliacionesOrdenantesPK(/*int codigoOrdenante,*/ Date fechaValida, String registro) {
      /*  this.elementoGrupo = codigoOrdenante;*/
//        this.codigoOrdenante = codigoOrdenante;Verificar
        this.fechaValida = fechaValida;
        this.registro = registro;
    }

//    public int getCodigoOrdenante() {Verificar
//        return codigoOrdenante;
//    }
//
//    public void setCodigoOrdenante(int codigoOrdenante) {Verificar
//        this.codigoOrdenante = codigoOrdenante;
//    }

   /* public int getElementoGrupo() {
        return elementoGrupo;
    }

    public void setElementoGrupo(int elementoGrupo) {
        this.elementoGrupo = elementoGrupo;
    }*/

    public Date getFechaValida() {
        return fechaValida;
    }

    public void setFechaValida(Date fechaValida) {
        this.fechaValida = fechaValida;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
    /*    hash += (int) elementoGrupo;*/
//        hash += (int) codigoOrdenante;Verificar
        hash += (fechaValida != null ? fechaValida.hashCode() : 0);
        hash += (registro != null ? registro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MgAfiliacionesOrdenantesPK)) {
            return false;
        }
        MgAfiliacionesOrdenantesPK other = (MgAfiliacionesOrdenantesPK) object;
       /* if (this.elementoGrupo != other.elementoGrupo) {
            return false;
        }*/
//        if (this.codigoOrdenante != other.codigoOrdenante) { Verificar
//            return false;
//        }
        if ((this.fechaValida == null && other.fechaValida != null) || (this.fechaValida != null && !this.fechaValida.equals(other.fechaValida))) {
            return false;
        }
        if ((this.registro == null && other.registro != null) || (this.registro != null && !this.registro.equals(other.registro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.MgAfiliacionesOrdenantesPK[  fechaValida=" + fechaValida + ", registro=" + registro + " ]";
    }
//    @Override Verificar
//    public String toString() {
//        return "com.bbc.dom.bbcdomiweb.model.MgAfiliacionesOrdenantesPK[ codigoOrdenante=" + codigoOrdenante + ", fechaValida=" + fechaValida + ", registro=" + registro + " ]";
//    }
    
}
