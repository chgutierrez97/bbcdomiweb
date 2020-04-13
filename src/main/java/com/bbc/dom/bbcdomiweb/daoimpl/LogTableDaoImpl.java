/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.daoimpl;

import com.bbc.dom.bbcdomiweb.dao.LogTableDao;
import com.bbc.dom.bbcdomiweb.dto.LogDTO;
import com.bbc.dom.bbcdomiweb.model.LogDomic;
import com.bbc.dom.bbcdomiweb.repository.LogTableRepository;
import com.bbc.dom.bbcdomiweb.util.Util;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sinergia
 */
@Service
public class LogTableDaoImpl {

    private final static Logger LOGGER = Logger.getLogger(LogTableDaoImpl.class.getName());
    private static final String Success = "Success";
    private static final String Fail = "Fail";
    private Util util = new Util();
    String clase = LogTableDaoImpl.class.getName();
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("bcdomicPU");
    EntityManager em = emf.createEntityManager();

    public void logTable(LogDTO log) {
        LogDomic logDomic = new LogDomic();
        LogTableRepository sr = new LogTableRepository();
        try {
            StringBuilder consultaNextval = new StringBuilder();
            consultaNextval.append("select BCDOMIC.LOG_DOMIC_SEQ.nextval from dual");
            BigDecimal secuencia = (BigDecimal) em.createNativeQuery(consultaNextval.toString()).getSingleResult();
            Long nextval = secuencia.longValue();
            logDomic.setIdlog(nextval);
            logDomic.setIduser("");
            logDomic.setCoduser("");
            logDomic.setEventtype(log.getLevel());
            logDomic.setStatus(log.getStatus());
            logDomic.setTrndate(log.getDate());
            logDomic.setTrntime(log.getTime());
            logDomic.setDetail(log.getMessage());
            logDomic.setOrigin(log.getOrigin());
            logDomic.setIpclient(log.getIp());
            sr.setEntityManager(em);
            sr.persist(logDomic);
        } catch (Exception e) {
            LOGGER.info(util.createLog(Level.SEVERE.toString(), Fail, "Erro al guardar log en la tabla", e.getMessage(), clase));
        }
    }

}
