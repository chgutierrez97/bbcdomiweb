/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.services;

import com.bbc.dom.bbcdomiweb.dao.DesencriptacionDao;
import com.bbc.dom.bbcdomiweb.dto.ClienteDTO;
import com.bbc.dom.bbcdomiweb.dto.LogDTO;
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

    private final static Logger LOGGER = Logger.getLogger(Desencriptacion.class.getName());
    private static final String Success = "Success";
    private static final String Fail = "Fail";
    private Util util = new Util();
    String clase = Desencriptacion.class.getName();
    private static final String URL1 = ":8080/bbcdomiweb/home2?codOr=";
    private static final String URL2 = ":8080/bbcdomiweb/homeDashboard?codOr=";
    private static final String URL_ERROR = ":8080/bbcdomiweb/error";
    private static final String HTTP = "http://";
    private LogDTO.LogTableDTO logTable = new LogDTO.LogTableDTO("", "", "");

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
        String rif, url = "", codigoOrdenante = "", url2 = "", ip = request.getRemoteAddr(), ipServer = InetAddress.getLocalHost().getHostAddress();
        SesionDTO sesion = new SesionDTO();
        if(ipServer.equals("192.168.195.21")){
            ipServer = "200.74.198.190";
        }
        boolean sw = false;
        String url3 = HTTP + ipServer + URL_ERROR;
        logTable = new LogDTO.LogTableDTO("", "", ip);
        try {
            ClienteDTO clienteDto = desencriptacionDao.desencriptar2(style, logTable);
            logTable = new LogDTO.LogTableDTO(clienteDto.getUserID(), clienteDto.getNroAbank(), ip);
            ip = desencriptacionDao.encrypIp(ip);
            rif = clienteDto.getCedulaRif();
            if (rif != null) {
                rif = rif.substring(0, 1) + "-" + rif.substring(1, rif.length());
                codigoOrdenante = desencriptacionDao.getCodigoOrdenante(rif);
//                codigoOrdenante = "0090";// borrar
                if (codigoOrdenante != null) {
                    codigoOrdenante = util.completeZero(codigoOrdenante, 4);
                    url = HTTP + ipServer + URL1 + codigoOrdenante;
                    url2 = HTTP + ipServer + URL2 + codigoOrdenante + ip + "&field=" + style;
                    if (url2.length() < 2000) {
                        url = url2;
                    }
                    sesion.setCodigoOrdenante(codigoOrdenante);
                    sesion.setStatus("1");
                    sesion.setIdentificacionPagador(rif);
                    sw = desencriptacionDao.insertNewSesion(sesion);
                    if (!sw) {
                        url = url3;
                        LOGGER.info(util.createLog(Level.INFO.toString(), Success, "Página error", "", clase, logTable));
                        return url;
                    }
                } else {
                    url = url3;
                    LOGGER.info(util.createLog(Level.INFO.toString(), Success, "Página error", "", clase, logTable));
                    return url;
                }
            } else {
                url = url3;
                LOGGER.info(util.createLog(Level.INFO.toString(), Success, "Página error", "", clase, logTable));
                return url;
            }
            LOGGER.info(util.createLog(Level.INFO.toString(), Success, "Inicio de sesión exitoso", "", clase, logTable));
        } catch (Exception e) {
            LOGGER.info(util.createLog(Level.SEVERE.toString(), Fail, "Error en el inicio de sesión", e.getMessage(), clase, logTable));
        }
        return url;
    }

    @Post
    @Consumes("application/x-www-form-urlencoded")
    @RequestMapping("/mantenimientoSesionDomi")
    public String mantenimientoSesion(@Context HttpServletRequest request, @FormParam("style") String style) throws UnknownHostException {
        String rif, codigoEstado = null, codigoOrdenante = "";
        SesionDTO sesion = new SesionDTO();
        boolean sw = false;
        String ip = request.getRemoteAddr();
        logTable = new LogDTO.LogTableDTO("", "", ip);
        try {
            ClienteDTO clienteDto = desencriptacionDao.desencriptar2(style, logTable);
            logTable = new LogDTO.LogTableDTO(clienteDto.getUserID(), clienteDto.getNroAbank(), ip);
            ip = desencriptacionDao.encrypIp(ip);
            rif = clienteDto.getCedulaRif();
            if (rif != null) {
                rif = rif.substring(0, 1) + "-" + rif.substring(1, rif.length());
                codigoOrdenante = desencriptacionDao.getCodigoOrdenante(rif);
//                codigoOrdenante = "0090";// borrar
                if (codigoOrdenante != null) {
                    codigoEstado = "202";
                    sesion.setCodigoOrdenante(codigoOrdenante);;
                    sesion.setIdentificacionPagador(rif);
                    sw = desencriptacionDao.mantenimientoSesion(sesion);
                    if (!sw) {
                        codigoEstado = "404";
                        LOGGER.info(util.createLog(Level.SEVERE.toString(), Fail, "Error en el mantenimiento de sesión", "404", clase, logTable));
                        return codigoEstado;
                    }
                } else {
                    codigoEstado = "404";
                    LOGGER.info(util.createLog(Level.SEVERE.toString(), Fail, "Error en el mantenimiento de sesión", "404", clase, logTable));
                    return codigoEstado;
                }
            } else {
                codigoEstado = "404";
                LOGGER.info(util.createLog(Level.SEVERE.toString(), Fail, "Error en el mantenimiento de sesión", "404", clase, logTable));
                return codigoEstado;
            }
            LOGGER.info(util.createLog(Level.INFO.toString(), Success, "Mantenimiento de sesión exitoso", "", clase, logTable));
        } catch (Exception e) {
            LOGGER.info(util.createLog(Level.SEVERE.toString(), Fail, "Error en el mantenimiento de sesión", e.getMessage(), clase, logTable));
        }
        return codigoEstado;
    }

    @Post
    @Consumes("application/x-www-form-urlencoded")
    @RequestMapping("/cerrarSesionDomi")
    public String cerrarSesion(@Context HttpServletRequest request, @FormParam("style") String style) throws UnknownHostException {
        String rif, codigoEstado = null, codigoOrdenante = "";
        SesionDTO sesion = new SesionDTO();
        boolean sw = false;
        String ip = request.getRemoteAddr();
        logTable = new LogDTO.LogTableDTO("", "", ip);
        try {
            ClienteDTO clienteDto = desencriptacionDao.desencriptar2(style, logTable);
            logTable = new LogDTO.LogTableDTO(clienteDto.getUserID(), clienteDto.getNroAbank(), ip);
            ip = desencriptacionDao.encrypIp(ip);
            rif = clienteDto.getCedulaRif();
            if (rif != null) {
                rif = rif.substring(0, 1) + "-" + rif.substring(1, rif.length());
                codigoOrdenante = desencriptacionDao.getCodigoOrdenante(rif);
//                codigoOrdenante = "0090";// borrar
                if (codigoOrdenante != null) {
                    codigoEstado = "202";
                    sesion.setCodigoOrdenante(codigoOrdenante);;
                    sesion.setIdentificacionPagador(rif);
                    sw = desencriptacionDao.closeSesion(sesion);
                    if (!sw) {
                        codigoEstado = "404";
                        LOGGER.info(util.createLog(Level.SEVERE.toString(), Fail, "Error en el Cierre de sesión", "404", clase, logTable));
                        return codigoEstado;
                    }
                } else {
                    codigoEstado = "404";
                    LOGGER.info(util.createLog(Level.SEVERE.toString(), Fail, "Error en el Cierre de sesión", "404", clase, logTable));
                    return codigoEstado;
                }
            } else {
                codigoEstado = "404";
                LOGGER.info(util.createLog(Level.SEVERE.toString(), Fail, "Error en el Cierre de sesión", "404", clase, logTable));
                return codigoEstado;
            }
            LOGGER.info(util.createLog(Level.INFO.toString(), Success, "Cierre de sesión exitoso", "", clase, logTable));
        } catch (Exception e) {
            LOGGER.info(util.createLog(Level.SEVERE.toString(), Fail, "Error en el Cierre de sesión", e.getMessage(), clase, logTable));
        }
        return codigoEstado;
    }
}
