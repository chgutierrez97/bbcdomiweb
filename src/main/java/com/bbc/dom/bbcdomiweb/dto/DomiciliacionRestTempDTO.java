
package com.bbc.dom.bbcdomiweb.dto;

import com.bbc.dom.bbcdomiweb.model.FormDomiciliacion;
import java.util.List;

/**
 *
 * @author CGutierrez
 */
public class DomiciliacionRestTempDTO {
    private List<FormDomiciliacion> list;
    private Long numRegistros;
    private Double totalMontos;
    private String totalMontosString;

    public List<FormDomiciliacion> getList() {
        return list;
    }

    public void setList(List<FormDomiciliacion> list) {
        this.list = list;
    }

    public Long getNumRegistros() {
        return numRegistros;
    }

    public void setNumRegistros(Long numRegistros) {
        this.numRegistros = numRegistros;
    }

    public Double getTotalMontos() {
        return totalMontos;
    }

    public void setTotalMontos(Double totalMontos) {
        this.totalMontos = totalMontos;
    }

    public String getTotalMontosString() {
        return totalMontosString;
    }

    public void setTotalMontosString(String totalMontosString) {
        this.totalMontosString = totalMontosString;
    }
    
}
