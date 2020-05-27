/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.dto;

import java.util.Date;

/**
 *
 * @author Sinergia
 */
public class LogDTO {
    private String date;
    private String time;
    private String level;
    private String ip;
    private String status;
    private String origin;
    private String message;
    private String data;
    private String idUser;
    private String codUser;

    public LogDTO(String date, String time, String level, String ip, String status, String origin, String message, String data) {
        this.date = date;
        this.time = time;
        this.level = level;
        this.ip = ip;
        this.status = status;
        this.origin = origin;
        this.message = message;
        this.data = data;
    }

    public LogDTO(String date, String time, String level, String ip, String status, String origin, String message, String data, String idUser, String codUser) {
        this.date = date;
        this.time = time;
        this.level = level;
        this.ip = ip;
        this.status = status;
        this.origin = origin;
        this.message = message;
        this.data = data;
        this.idUser = idUser;
        this.codUser = codUser;
    }
    
    

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getCodUser() {
        return codUser;
    }

    public void setCodUser(String codUser) {
        this.codUser = codUser;
    }
    
    public static class LogTableDTO{
        private String idUser;
        private String codUser;
        private String ipClient;

        public LogTableDTO(String idUser, String codUser, String ipClient) {
            this.idUser = idUser;
            this.codUser = codUser;
            this.ipClient = ipClient;
        }
        
        public String getIdUser() {
            return idUser;
        }

        public void setIdUser(String idUser) {
            this.idUser = idUser;
        }

        public String getCodUser() {
            return codUser;
        }

        public void setCodUser(String codUser) {
            this.codUser = codUser;
        }

        public String getIpClient() {
            return ipClient;
        }

        public void setIpClient(String ipClient) {
            this.ipClient = ipClient;
        }        
    }   
}
