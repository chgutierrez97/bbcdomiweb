/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.daoimpl;

import com.bbc.dom.bbcdomiweb.dao.HomeDao;
import org.springframework.stereotype.Service;

/**
 *
 * @author Christian Gutierrez
 */
@Service
public class HomeDaoImpl implements HomeDao{

    public String construirRuta(String x) {
        return x;
    }
    
}
