/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.controller;

import com.bbc.dom.bbcdomiweb.daoimpl.LogTableDaoImpl;
import com.bbc.dom.bbcdomiweb.dto.LogDTO;

/**
 *
 * @author Sinergia
 */
public class LogTableController {
    public void logTable(LogDTO log) {
        LogTableDaoImpl logTableDao = new LogTableDaoImpl();
        logTableDao.logTable(log);
    }
}
