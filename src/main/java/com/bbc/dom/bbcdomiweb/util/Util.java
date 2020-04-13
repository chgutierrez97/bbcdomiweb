package com.bbc.dom.bbcdomiweb.util;

import com.bbc.dom.bbcdomiweb.controller.LogTableController;
import com.bbc.dom.bbcdomiweb.daoimpl.DesencriptacionDaoImpl;
import com.bbc.dom.bbcdomiweb.dto.LogDTO;
import com.bbc.dom.bbcdomiweb.services.Desencriptacion;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Christian Gutierrez
 */
public class Util {

    public Date theStringByToDate(String fechaString, Boolean flag) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy , HH:mm:ss ");
        SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yy");

        if (!flag) {
            fechaString = fechaString + " , 23:59:59 ";
        }
        try {
            if (flag) {
                Date date = formatter2.parse(fechaString);
                return date;
            } else {
                Date date = formatter.parse(fechaString);
                return date;
            }

        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }

    public String completeZero(String codOrdenante, Integer quantity) {
        for (int i = 0; codOrdenante.length() < quantity; i++) {
            codOrdenante = "0" + codOrdenante;
        }
        return codOrdenante;
    }

    public synchronized String createLog(String level, String status, String message, String data, String origin) {
        LogTableController logTable= new LogTableController();
        Date date = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        String fecha = formatoFecha.format(date);
        String hora = formatoHora.format(date);
        String ip = "";
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            Desencriptacion des = new Desencriptacion();
            LogDTO log = new LogDTO(fecha, hora, level, des.IP, status, origin, message, data);
            json = mapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(log);
            logTable.logTable(log);
        } catch (Exception ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }
}
