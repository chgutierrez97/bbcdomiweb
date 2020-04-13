/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sinergia
 */
@Entity
@Table(name = "LOG_DOMIC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LogDomic.findAll", query = "SELECT l FROM LogDomic l")
    , @NamedQuery(name = "LogDomic.findByIdlog", query = "SELECT l FROM LogDomic l WHERE l.idlog = :idlog")
    , @NamedQuery(name = "LogDomic.findByIduser", query = "SELECT l FROM LogDomic l WHERE l.iduser = :iduser")
    , @NamedQuery(name = "LogDomic.findByCoduser", query = "SELECT l FROM LogDomic l WHERE l.coduser = :coduser")
    , @NamedQuery(name = "LogDomic.findByEventtype", query = "SELECT l FROM LogDomic l WHERE l.eventtype = :eventtype")
    , @NamedQuery(name = "LogDomic.findByStatus", query = "SELECT l FROM LogDomic l WHERE l.status = :status")
    , @NamedQuery(name = "LogDomic.findByTrndate", query = "SELECT l FROM LogDomic l WHERE l.trndate = :trndate")
    , @NamedQuery(name = "LogDomic.findByTrntime", query = "SELECT l FROM LogDomic l WHERE l.trntime = :trntime")
    , @NamedQuery(name = "LogDomic.findByDetail", query = "SELECT l FROM LogDomic l WHERE l.detail = :detail")
    , @NamedQuery(name = "LogDomic.findByOrigin", query = "SELECT l FROM LogDomic l WHERE l.origin = :origin")
    , @NamedQuery(name = "LogDomic.findByIpclient", query = "SELECT l FROM LogDomic l WHERE l.ipclient = :ipclient")})
public class LogDomic implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDLOG")
    private Long idlog;
    @Size(max = 20)
    @Column(name = "IDUSER")
    private String iduser;
    @Size(max = 20)
    @Column(name = "CODUSER")
    private String coduser;
    @Size(max = 20)
    @Column(name = "EVENTTYPE")
    private String eventtype;
    @Size(max = 20)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 20)
    @Column(name = "TRNDATE")
    private String trndate;
    @Size(max = 20)
    @Column(name = "TRNTIME")
    private String trntime;
    @Size(max = 250)
    @Column(name = "DETAIL")
    private String detail;
    @Size(max = 250)
    @Column(name = "ORIGIN")
    private String origin;
    @Size(max = 20)
    @Column(name = "IPCLIENT")
    private String ipclient;

    public LogDomic() {
    }

    public LogDomic(Long idlog) {
        this.idlog = idlog;
    }

    public Long getIdlog() {
        return idlog;
    }

    public void setIdlog(Long idlog) {
        this.idlog = idlog;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    public String getEventtype() {
        return eventtype;
    }

    public void setEventtype(String eventtype) {
        this.eventtype = eventtype;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTrndate() {
        return trndate;
    }

    public void setTrndate(String trndate) {
        this.trndate = trndate;
    }

    public String getTrntime() {
        return trntime;
    }

    public void setTrntime(String trntime) {
        this.trntime = trntime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getIpclient() {
        return ipclient;
    }

    public void setIpclient(String ipclient) {
        this.ipclient = ipclient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlog != null ? idlog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LogDomic)) {
            return false;
        }
        LogDomic other = (LogDomic) object;
        if ((this.idlog == null && other.idlog != null) || (this.idlog != null && !this.idlog.equals(other.idlog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.controller.LogDomic[ idlog=" + idlog + " ]";
    }
    
}
