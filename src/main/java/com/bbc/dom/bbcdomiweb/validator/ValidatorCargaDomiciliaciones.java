/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.validator;

import com.bbc.dom.bbcdomiweb.dto.Validation;
import com.bbc.dom.bbcdomiweb.dto.IbDomiciliacionesDetDTO;
import com.bbc.dom.bbcdomiweb.propeties.BancosEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author christian.gutierrez
 */
@Service
public class ValidatorCargaDomiciliaciones {

    private final int LONGITUD_DETALLE_DOM_CUENTA_PAGADOR = 20;
    private final int LONGITUD_DETALLE_DOM_NOMBRE_PAGADOR = 30;
    private final int LONGITUD_DOM_DE_LINEA = 170;
    private final int LONGITUD_DETALLE_REFERENCIA_CONTRATO = 30;

    @Autowired
    ElementoValidator elementoValidator;

    public ValidatorCargaDomiciliaciones() {

    }

    public Validation getValidaDomiciliacion(IbDomiciliacionesDetDTO domiciliaciones) {
        Validation valida = new Validation();
        Boolean flag = Boolean.TRUE;
        valida.setLinea(Boolean.TRUE);
        StringBuffer errorInLine = new StringBuffer();
        String linea = " ";
        String nroRechazo = "";
        try {

            //Longitud del detalle        
            if (domiciliaciones.getLinea().length() > LONGITUD_DOM_DE_LINEA) {
                errorInLine.append("Registro no cumple especif. 170 caracteres ");
                flag = Boolean.FALSE;
                nroRechazo = "212";
            }

            if (!elementoValidator.validaSoloNumeros(domiciliaciones.getCodOrdenante())) {
                errorInLine.append("Código Empresa Ordenante invalido posee caracteres alpha-numericos ");
                flag = Boolean.FALSE;
                nroRechazo = "500";
            }

            //Clave Ordenante
            if (!elementoValidator.validaAlfaNumerico(domiciliaciones.getClaveOrdenente().trim())) {
                errorInLine.append(linea);
                flag = Boolean.FALSE;
                nroRechazo = "212";
            }

            //Banco destino
            if (!elementoValidator.validaSoloNumeros(domiciliaciones.getCtaPagador().trim())) {
                errorInLine.append("La Cta. pagador  no puede contener caracteres alpha numericos ");
                flag = Boolean.FALSE;
                nroRechazo = "212";
            }

            if (BancosEnum.getById(Integer.valueOf(domiciliaciones.getCtaPagador().trim().substring(0, 4))) == null) {
                flag = Boolean.FALSE;
                errorInLine.append("El codigo Banco no corresponde con bancos registrados ");
                nroRechazo = "212";
            }

            //Tipo Operacion  
            if (!elementoValidator.validaSoloNumeros(domiciliaciones.getTipoOperacion())) {
                errorInLine.append("Campo Tipo de Operacion  que no aplica formato ");
                flag = Boolean.FALSE;
                nroRechazo = "212";
            }

            if (!domiciliaciones.getTipoOperacion().equals("020")) {
                errorInLine.append(linea);
                flag = Boolean.FALSE;
                nroRechazo = "212";
            }

            //Tipo Pagador          
            if (!elementoValidator.validaSolaUnaDeEstasLetras(domiciliaciones.getTipoPagador(), "NRJG")) {
                errorInLine.append("Campo Tipo Pagador que no aplica formato ");
                flag = Boolean.FALSE;
                nroRechazo = "212";
            }
            
            //Detalle tipo pagador
            String resultadoValidatorTipoPagador = domiciliaciones.getTipoPagador();
            if (resultadoValidatorTipoPagador.contains("N")) {
                if (!elementoValidator.validaSolaUnaDeEstasLetras(domiciliaciones.getIdentificadorPagador().substring(0, 1), "VEP")) {
                    errorInLine.append("Campo Detalle Tipo Pagador natural que no aplica formato ");
                    flag = Boolean.FALSE;
                    nroRechazo = "500";
                }
            } else if (resultadoValidatorTipoPagador.contains("R")) {
                if (!elementoValidator.validaSolaUnaDeEstasLetras(domiciliaciones.getIdentificadorPagador().substring(0, 1), "VE")) {
                    errorInLine.append("Campo Detalle Tipo Pagador natural que no aplica formato ");
                    flag = Boolean.FALSE;
                    nroRechazo = "212";
                }
            } else if (resultadoValidatorTipoPagador.contains("J")) {
                if (!elementoValidator.validaSolaUnaDeEstasLetras(domiciliaciones.getIdentificadorPagador().substring(0, 1), "J") && !elementoValidator.validaSolaUnaDeEstasLetras(domiciliaciones.getIdentificadorPagador().substring(0, 1), "G")) {
                    errorInLine.append("Campo Detalle Tipo Pagador Juridico que no aplica formato ");
                    flag = Boolean.FALSE;
                    nroRechazo = "212";
                }
            } else if (resultadoValidatorTipoPagador.contains("G")) {
                if (!elementoValidator.validaSolaUnaDeEstasLetras(domiciliaciones.getIdentificadorPagador().substring(0, 1), "G")) {
                    errorInLine.append("Campo Detalle Tipo Pagador Gubernamental que no aplica formato ");
                    flag = Boolean.FALSE;
                }
            }

            //numero identificacion pagador
            if (!elementoValidator.validaSoloNumeros(domiciliaciones.getIdentificadorPagador().substring(1, (domiciliaciones.getIdentificadorPagador().length() - 1)).trim())) {
                flag = Boolean.FALSE;
                errorInLine.append("Campo Detalle Nro. identificador Pagador  no aplica formato ");
                nroRechazo = "212";
            }

            if (!elementoValidator.validaSoloNumeros(domiciliaciones.getCtaPagador())) {
                flag = Boolean.FALSE;
                errorInLine.append("La Cta.Pagador posee caracteres alpha numericos ");
                nroRechazo = "212";
            }

            if (domiciliaciones.getCtaPagador().length() != LONGITUD_DETALLE_DOM_CUENTA_PAGADOR) {
                flag = Boolean.FALSE;
                errorInLine.append("La Cta. tiene una longitud diferente a la establecida de 20 digitos ");
                nroRechazo = "212";
            }

            //Nombre Pagador
           /* if (!elementoValidator.validaAlfanumericoPuntoComa(domiciliaciones.getNombrePagador())) {
                flag = Boolean.FALSE;
                errorInLine.append("Error en formato de nombre del pagador");
            }*/
            if (!(domiciliaciones.getNombrePagador().length() <= LONGITUD_DETALLE_DOM_NOMBRE_PAGADOR)) {
                flag = Boolean.FALSE;
                valida.setLinea(Boolean.FALSE);
                errorInLine.append("EL nombre del pagador tiene una longitud diferente a la establecida de 30 caracteres ");
                nroRechazo = "212";

            }
            if (!(domiciliaciones.getNombrePagador().length() > 5)) {
                flag = Boolean.FALSE;
                valida.setLinea(Boolean.FALSE);
                errorInLine.append("EL nombre del pagador debe ser mayor a 5 caracteres ");
                nroRechazo = "212";
            }

            //Referencia Contrato
            if (!(domiciliaciones.getRefContrato().length() <= LONGITUD_DETALLE_REFERENCIA_CONTRATO)) {
                flag = Boolean.FALSE;
                valida.setLinea(Boolean.FALSE);
                errorInLine.append("La Ref. Contrato tiene una longitud diferente a la establecida de " + LONGITUD_DETALLE_REFERENCIA_CONTRATO + "caracteres ");
                nroRechazo = "212";
            }
            if (!elementoValidator.validaAlfaNumerico(domiciliaciones.getRefContrato())) {
                flag = Boolean.FALSE;
                errorInLine.append("La Ref. Contrato posee caracteres incorrectos ");
                nroRechazo = "212";
            }
            
            //validar fecha
            if(!elementoValidator.validaFecha(domiciliaciones.getFechaEmisionFactura(), "ddMMyyyy")){
                flag = Boolean.FALSE;
                errorInLine.append("La fecha de emision no cumple con el formato ddMMyyyy ");
                nroRechazo = "212";
            }
            if(!elementoValidator.validaFecha(domiciliaciones.getFechaVencimientoFactura(), "ddMMyyyy")){
                flag = Boolean.FALSE;
                errorInLine.append("La fecha de vencimiento no cumple con el formato ddMMyyyy ");
                nroRechazo = "212";
            }
        } catch (Exception e) {
            errorInLine.append("Registro no valido por error general de formato de la linea ");
            flag = Boolean.FALSE;
            nroRechazo = "212";
        }

        valida.setErrores(errorInLine.toString());
        valida.setStatusRegistro(flag);
        valida.setCodError(nroRechazo);
        return valida;
    }

}
