/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.services;

import com.bbc.dom.bbcdomiweb.dao.DesencriptacionDao;
import com.bbc.dom.bbcdomiweb.dto.SesionDTO;
import com.bbc.dom.bbcdomiweb.util.Util;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.Context;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Sinergia
 */
@RestController
@RequestMapping("/domiciliaciones")
public class Desencriptacion {

    @Autowired
    private DesencriptacionDao desencriptacionDao;

    public String IP;
    private final static Logger LOGGER = Logger.getLogger(Desencriptacion.class.getName());
    private static final String Success = "Success";
    private static final String Fail = "Fail";
    private Util util = new Util();
    String clase = Desencriptacion.class.getName();

    public Desencriptacion() throws UnknownHostException {
        this.IP = InetAddress.getLocalHost().getHostAddress();
    }

    /**
     * Mètodo para el inicio de la sesión
     *
     * @param nombre
     * @return
     */
    @Post
    @Consumes("application/x-www-form-urlencoded")
    @RequestMapping("/inicio")
    public String desencriptar(@Context HttpServletRequest request, @FormParam("style") String style) throws UnknownHostException {
        Util util = new Util();
        String rif, url = null, codigoOrdenante = "";
        request.getRemoteAddr();// ip cliente
        SesionDTO sesion = new SesionDTO();
        boolean sw = false;
        try {
            rif = desencriptacionDao.desencriptar(style);
            if (rif != null) {
                rif = rif.substring(0, 1) + "-" + rif.substring(1, rif.length());
                codigoOrdenante = desencriptacionDao.getCodigoOrdenante(rif);
                if (codigoOrdenante != null) {
                    codigoOrdenante = util.completeZero(codigoOrdenante, 4);
                    url = "http://" + InetAddress.getLocalHost().getHostAddress() + ":8080/bbcdomiweb/home2?codOr=" + codigoOrdenante;
                    sesion.setCodigoOrdenante(codigoOrdenante);
                    sesion.setStatus("1");
                    sesion.setIdentificacionPagador(rif);
                    sw = desencriptacionDao.insertNewSesion(sesion);
                    if (!sw) {
                        url = "http://" + InetAddress.getLocalHost().getHostAddress() + ":8080/bbcdomiweb/error";
                    }
                } else {
                    url = "http://" + InetAddress.getLocalHost().getHostAddress() + ":8080/bbcdomiweb/error";
                }
            } else {
                url = "http://" + InetAddress.getLocalHost().getHostAddress() + ":8080/bbcdomiweb/error";
            }
            LOGGER.info(util.createLog(Level.INFO.toString(), Success, "Inicio de sesión exitoso", "", clase));
        } catch (Exception e) {
            LOGGER.info(util.createLog(Level.SEVERE.toString(), Fail, "Error en el inicio de sesión", e.getMessage(), clase));
        }
        return url;
    }

    @Post
    @Consumes("application/x-www-form-urlencoded")
    @RequestMapping("/mantenimientoSesionDomi")
    public String mantenimientoSesion(@FormParam("style") String style) throws UnknownHostException {
        String rif, codigoEstado = null, codigoOrdenante = "";
        SesionDTO sesion = new SesionDTO();
        boolean sw = false;
        try {
            rif = desencriptacionDao.desencriptar(style);
            if (rif != null) {
                rif = rif.substring(0, 1) + "-" + rif.substring(1, rif.length());
                codigoOrdenante = desencriptacionDao.getCodigoOrdenante(rif);
                if (codigoOrdenante != null) {
                    codigoEstado = "202";
                    sesion.setCodigoOrdenante(codigoOrdenante);;
                    sesion.setIdentificacionPagador(rif);
                    sw = desencriptacionDao.mantenimientoSesion(sesion);
                    if (!sw) {
                        codigoEstado = "404";
                    }
                } else {
                    codigoEstado = "404";
                }
            } else {
                codigoEstado = "404";
            }
            LOGGER.info(util.createLog(Level.INFO.toString(), Success, "Mantenimiento de sesión exitoso", "", clase));
        } catch (Exception e) {
            LOGGER.info(util.createLog(Level.SEVERE.toString(), Fail, "Error en el mantenimiento de sesión", e.getMessage(), clase));
        }
        return codigoEstado;
    }

    @Post
    @Consumes("application/x-www-form-urlencoded")
    @RequestMapping("/cerrarSesionDomi")
    public String cerrarSesion(@FormParam("style") String style) throws UnknownHostException {
        String rif, codigoEstado = null, codigoOrdenante = "";
        SesionDTO sesion = new SesionDTO();
        boolean sw = false;
        try {
            rif = desencriptacionDao.desencriptar(style);
            if (rif != null) {
                rif = rif.substring(0, 1) + "-" + rif.substring(1, rif.length());
                codigoOrdenante = desencriptacionDao.getCodigoOrdenante(rif);
                if (codigoOrdenante != null) {
                    codigoEstado = "202";
                    sesion.setCodigoOrdenante(codigoOrdenante);;
                    sesion.setIdentificacionPagador(rif);
                    sw = desencriptacionDao.closeSesion(sesion);
                    if (!sw) {
                        codigoEstado = "404";
                    }
                } else {
                    codigoEstado = "404";
                }
            } else {
                codigoEstado = "404";
            }
            LOGGER.info(util.createLog(Level.INFO.toString(), Success, "Cierre de sesión exitoso", "", clase));
        } catch (Exception e) {
            LOGGER.info(util.createLog(Level.SEVERE.toString(), Fail, "Error en el Cierre de sesión", e.getMessage(), clase));
        }
        return codigoEstado;
    }
}
