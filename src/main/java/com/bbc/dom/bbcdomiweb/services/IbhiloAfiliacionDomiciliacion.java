/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.services;

import com.bbc.dom.bbcdomiweb.dto.IbAfiliacionesDetDTO;
import com.bbc.dom.bbcdomiweb.dto.IbDomiciliacionesDetDTO;
import com.bbc.dom.bbcdomiweb.model.IbSumarioPagos;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Christian Gutierrez
 */
public class IbhiloAfiliacionDomiciliacion {

    IbAfiliacionesServices ibAfiliacionesServices = new IbAfiliacionesServices();
    IbDomiciliacionesServices ibDomiciliacionesServices = new IbDomiciliacionesServices();

    private List<IbAfiliacionesDetDTO> listIbAfiliacionesDet;
    private List<IbDomiciliacionesDetDTO> listIbDomiciliacionesDet;
    private Boolean flag = Boolean.TRUE;

    public IbhiloAfiliacionDomiciliacion(List<IbAfiliacionesDetDTO> listIbAfiliacionesDet, List<IbDomiciliacionesDetDTO> listIbDomiciliacionesDet, String opcion) {

        if (opcion.equals("AF")) {

            this.listIbAfiliacionesDet = new ArrayList<>();
            this.listIbAfiliacionesDet = listIbAfiliacionesDet;

        } else {
            flag = Boolean.FALSE;
            this.listIbDomiciliacionesDet = new ArrayList<>();
            this.listIbDomiciliacionesDet = listIbDomiciliacionesDet;

        }

    }

    public IbhiloAfiliacionDomiciliacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void regis() {
        try {
            if (flag) {
                if (ibAfiliacionesServices.procesarCarga(this.listIbAfiliacionesDet)) {
                    System.out.println("Procceso de carga de afiliaciones culminado con excito ");
                    Thread.currentThread().interrupt();
                } else {
                    System.out.println("  Falla en Procceso de carga de afiliaciones ");
                    Thread.currentThread().interrupt();
                }
            } else {
                if (ibDomiciliacionesServices.procesarCarga(this.listIbDomiciliacionesDet)) {
                    System.out.println("Procceso de carga de domiciliaciones culminado con exto ");
                    Thread.currentThread().interrupt();
                } else {
                    System.out.println("  Falla en Procceso de carga de domiciliaciones ");
                    Thread.currentThread().interrupt();
                }

            }
        } catch (Exception e) {
        }

    }

}
