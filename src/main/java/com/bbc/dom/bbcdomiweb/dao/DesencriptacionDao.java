/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.dao;

import com.bbc.dom.bbcdomiweb.dto.ClienteDTO;
import com.bbc.dom.bbcdomiweb.dto.LogDTO;
import com.bbc.dom.bbcdomiweb.dto.SesionDTO;

/**
 *
 * @author Sinergia
 */
public interface DesencriptacionDao {
    
    public String desencriptar(String Semilla);
    
    public ClienteDTO desencriptar2(String Semilla, LogDTO.LogTableDTO logTable);
    
    public String getCodigoOrdenante(String rif);
    
    public boolean insertNewSesion(SesionDTO sesion);
    
    public boolean closeSesion(SesionDTO sesion);
    
    public boolean mantenimientoSesion(SesionDTO sesion);
    
    public String encrypIp(String mensaje);
    
    public String desencrypIp(String mensaje);
    
}
