/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.services;

import com.bbc.dom.bbcdomiweb.dao.DesencriptacionDao;
import com.bbc.dom.bbcdomiweb.dto.SesionDTO;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import oracle.jdbc.proxy.annotation.Post;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    private static final Logger LOGGER = Logger.getLogger(Desencriptacion.class);

    /**
     * Mètodo para el inicio de la sesión
     *
     * @param nombre
     * @return
     */
    @Post
    @Consumes("application/x-www-form-urlencoded")
    @RequestMapping("/inicio")
    public String desencriptar(@FormParam("style") String style) throws UnknownHostException {
        String rif, ip, url, codigoOrdenante = "";
        SesionDTO sesion = new SesionDTO();
        ip = InetAddress.getLocalHost().getHostAddress();
        boolean sw = false;
        rif = desencriptacionDao.desencriptar(style);
        if (rif != null) {
            rif = rif.substring(0, 1) + "-" + rif.substring(1, rif.length());
            codigoOrdenante = desencriptacionDao.getCodigoOrdenante(rif);
            if (codigoOrdenante != null) {
                url = "http://" + InetAddress.getLocalHost().getHostAddress() + ":8080/bbcdomiweb/home2?codOr=" + codigoOrdenante;
                sesion.setCodigoOrdenante(codigoOrdenante);
                sesion.setStatus("1");
                sesion.setIdentificacionPagador(rif);
                sw = desencriptacionDao.insertNewSesion(sesion);
                if(!sw){
                    url = "http://" + InetAddress.getLocalHost().getHostAddress() + ":8080/bbcdomiweb/error";
                }
            } else {
                url = "http://" + InetAddress.getLocalHost().getHostAddress() + ":8080/bbcdomiweb/error";
            }
        } else {
            url = "http://" + InetAddress.getLocalHost().getHostAddress() + ":8080/bbcdomiweb/error";
        }
        return url;
    }

    @Post
    @Consumes("application/x-www-form-urlencoded")
    @RequestMapping("/mantenimientoSesionDomi")
    public String mantenimientoSesion(@FormParam("style") String style) throws UnknownHostException {
        String rif, codigoEstado, codigoOrdenante = "";
        SesionDTO sesion = new SesionDTO();
        boolean sw = false;
        rif = desencriptacionDao.desencriptar(style);
        if (rif != null) {
            rif = rif.substring(0, 1) + "-" + rif.substring(1, rif.length());
            codigoOrdenante = desencriptacionDao.getCodigoOrdenante(rif);
            if (codigoOrdenante != null) {
                codigoEstado = "202";
                sesion.setCodigoOrdenante(codigoOrdenante);;
                sesion.setIdentificacionPagador(rif);
                sw = desencriptacionDao.mantenimientoSesion(sesion);
                if(!sw){
                    codigoEstado = "404";
                }
            } else {
                codigoEstado = "404";
            }
        } else {
            codigoEstado = "404";
        }
        return codigoEstado;
    }
    
    @Post
    @Consumes("application/x-www-form-urlencoded")
    @RequestMapping("/cerrarSesionDomi")
    public String cerrarSesion(@FormParam("style") String style) throws UnknownHostException {
        String rif, codigoEstado, codigoOrdenante = "";
        SesionDTO sesion = new SesionDTO();
        boolean sw = false;
        rif = desencriptacionDao.desencriptar(style);
        if (rif != null) {
            rif = rif.substring(0, 1) + "-" + rif.substring(1, rif.length());
            codigoOrdenante = desencriptacionDao.getCodigoOrdenante(rif);
            if (codigoOrdenante != null) {
                codigoEstado = "202";
                sesion.setCodigoOrdenante(codigoOrdenante);;
                sesion.setIdentificacionPagador(rif);
                sw = desencriptacionDao.closeSesion(sesion);
                if(!sw){
                    codigoEstado = "404";
                }
            } else {
                codigoEstado = "404";
            }
        } else {
            codigoEstado = "404";
        }
        return codigoEstado;
    }

}
