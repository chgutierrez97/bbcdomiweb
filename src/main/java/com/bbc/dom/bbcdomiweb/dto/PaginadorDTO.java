/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.dto;

import com.bbc.dom.bbcdomiweb.model.IbSumarioAfiliaciones;
import com.bbc.dom.bbcdomiweb.model.IbSumarioPagos;
import com.bbc.dom.bbcdomiweb.model.MgAfiliacionesPresentadas;
import com.bbc.dom.bbcdomiweb.model.MgDomiciliacionesEnviadas;
import java.util.List;

/**
 *
 * @author Christian Gutierrez
 */
public class PaginadorDTO {
     private List<IbSumarioAfiliaciones> listIbSumarioAfiliacionesPag;
     private List<IbSumarioPagos> listIbSumarioPagosPag;
     private List<MgDomiciliacionesEnviadas> listMgDomiciliacionesEnviadasPag;
     private List<MgAfiliacionesPresentadas> listMgAfiliacionesPresentadasPag;
     private Integer numPagAnt;
     private Integer numPagAct;
     private Integer numPagSig;

    public PaginadorDTO() {
    }
     
     

    public List<IbSumarioAfiliaciones> getListIbSumarioAfiliacionesPag() {
        return listIbSumarioAfiliacionesPag;
    }

    public void setListIbSumarioAfiliacionesPag(List<IbSumarioAfiliaciones> listIbSumarioAfiliacionesPag) {
        this.listIbSumarioAfiliacionesPag = listIbSumarioAfiliacionesPag;
    }

    public List<IbSumarioPagos> getListIbSumarioPagosPag() {
        return listIbSumarioPagosPag;
    }

    public void setListIbSumarioPagosPag(List<IbSumarioPagos> listIbSumarioPagosPag) {
        this.listIbSumarioPagosPag = listIbSumarioPagosPag;
    }

    public List<MgDomiciliacionesEnviadas> getListMgDomiciliacionesEnviadasPag() {
        return listMgDomiciliacionesEnviadasPag;
    }

    public void setListMgDomiciliacionesEnviadasPag(List<MgDomiciliacionesEnviadas> listMgDomiciliacionesEnviadasPag) {
        this.listMgDomiciliacionesEnviadasPag = listMgDomiciliacionesEnviadasPag;
    }

    public List<MgAfiliacionesPresentadas> getListMgAfiliacionesPresentadasPag() {
        return listMgAfiliacionesPresentadasPag;
    }

    public void setListMgAfiliacionesPresentadasPag(List<MgAfiliacionesPresentadas> listMgAfiliacionesPresentadasPag) {
        this.listMgAfiliacionesPresentadasPag = listMgAfiliacionesPresentadasPag;
    }

    public Integer getNumPagAnt() {
        return numPagAnt;
    }

    public void setNumPagAnt(Integer numPagAnt) {
        this.numPagAnt = numPagAnt;
    }

    public Integer getNumPagAct() {
        return numPagAct;
    }

    public void setNumPagAct(Integer numPagAct) {
        this.numPagAct = numPagAct;
    }

    public Integer getNumPagSig() {
        return numPagSig;
    }

    public void setNumPagSig(Integer numPagSig) {
        this.numPagSig = numPagSig;
    }

    @Override
    public String toString() {
        return "PaginadorDTO{" + "listIbSumarioAfiliacionesPag=" + listIbSumarioAfiliacionesPag + ", listIbSumarioPagosPag=" + listIbSumarioPagosPag + ", listMgDomiciliacionesEnviadasPag=" + listMgDomiciliacionesEnviadasPag + ", listMgAfiliacionesPresentadasPag=" + listMgAfiliacionesPresentadasPag + ", numPagAnt=" + numPagAnt + ", numPagAct=" + numPagAct + ", numPagSig=" + numPagSig + '}';
    }
     
    
     
}
