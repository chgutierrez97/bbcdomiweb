/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.services;

import com.bbc.dom.bbcdomiweb.dto.IbAfiliacionesDetDTO;
import com.bbc.dom.bbcdomiweb.dto.IbDomiciliacionesDetDTO;
import com.bbc.dom.bbcdomiweb.dto.LogDTO;
import com.bbc.dom.bbcdomiweb.util.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private final static Logger LOGGER = Logger.getLogger(IbhiloAfiliacionDomiciliacion.class.getName());
    private static final String Success = "Success";
    private static final String Fail = "Fail";
    private Util util = new Util();
    private LogDTO.LogTableDTO logTable = new LogDTO.LogTableDTO("", "", "");
    String clase = IbhiloAfiliacionDomiciliacion.class.getName();

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

    public void regis(LogDTO.LogTableDTO logTable) {
        try {
            if (flag) {
                if (ibAfiliacionesServices.procesarCarga(this.listIbAfiliacionesDet, logTable)) {
                    LOGGER.info(util.createLog(Level.INFO.toString(), Success, "Proceso de carga de afiliaciones culminado con éxito ", "", clase, logTable));
                    Thread.currentThread().interrupt();
                } else {
                    Thread.currentThread().interrupt();
                }
            } else {
                if (ibDomiciliacionesServices.procesarCarga(this.listIbDomiciliacionesDet, logTable)) {
                    LOGGER.info(util.createLog(Level.INFO.toString(), Success, "Proceso de carga de domiciliaciones culminado con éxito ", "", clase, logTable));
                    Thread.currentThread().interrupt();
                } else {
                    Thread.currentThread().interrupt();
                }

            }
        } catch (Exception e) {
        }

    }

}
