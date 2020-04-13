/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.validator;

import com.bbc.dom.bbcdomiweb.dto.Validation;
import com.bbc.dom.bbcdomiweb.dto.IbAfiliacionesDetDTO;
import com.bbc.dom.bbcdomiweb.propeties.BancosEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author christian.gutierrez
 */
@Service
public class ValidatorCargaAfiliaciones {

    private final int LONGITUD_DE_LINEA_SUP = 118;
    private final int LONGITUD_DE_LINEA_INF = 97;
    protected final int LONGITUD_DETALLE_TIPO_PAGADOR_DETALLE = 1;
    private final int LONGITUD_DETALLE_CUENTA_PAGADOR = 20;
    private final int LONGITUD_DETALLE_NOMBRE_PAGADOR = 30;
    private final int LONGITUD_DETALLE_REFERENCIA_CONTRATO = 30;

    @Autowired
    ElementoValidator elementoValidator;

    public ValidatorCargaAfiliaciones() {

    }

    public Validation getValidaAfiliacion(IbAfiliacionesDetDTO afiliaciones) {
        Validation valida = new Validation();
        Boolean flag = Boolean.TRUE;
        valida.setLinea(Boolean.TRUE);
        StringBuffer errorInLine = new StringBuffer();
        String nroRechazo = "";
        String linea = " ";
        try {

            //Longitud del detalle        
            if (!(afiliaciones.getLinea().length() <= LONGITUD_DE_LINEA_SUP) || !(afiliaciones.getLinea().length() >= LONGITUD_DE_LINEA_INF)) {
                errorInLine.append("Registro no cumple especif. 117/118 caracteres");
                nroRechazo = "212";
                flag = Boolean.FALSE;
            }

            if (!elementoValidator.validaSoloNumeros(afiliaciones.getCodOrdenante())) {
                errorInLine.append("Código Empresa Ordenante invalido posee caracteres alpha-numericos ");

                nroRechazo = "500";
                flag = Boolean.FALSE;
            }

            //Clave Ordenante
            if (!elementoValidator.validaAlfaNumerico(afiliaciones.getClaveOrdenente().trim())) {
                errorInLine.append("Campo que no aplica formato -->" + afiliaciones.getClaveOrdenente().trim());
                nroRechazo = "212";
                flag = Boolean.FALSE;

            }

            //Banco destino
            if (!elementoValidator.validaSoloNumeros(afiliaciones.getCtaBcoDestino().trim())) {
                errorInLine.append("Campo codigo de banco que no aplica formato debe ser numerico");
                nroRechazo = "212";
                flag = Boolean.FALSE;
            }

            //Tipo Operacion  
            if (!elementoValidator.validaSolaUnaDeEstasLetras(afiliaciones.getTipoOperacion(), "AD")) {
                errorInLine.append("Campo Tipo de Operacion  que no aplica formato");
                nroRechazo = "212";
                flag = Boolean.FALSE;
            }

            //Tipo Pagador          
            if (!elementoValidator.validaSolaUnaDeEstasLetras(afiliaciones.getTipoPagador(), "NRJG")) {
                errorInLine.append("Campo Tipo Pagador que no aplica formato");
                nroRechazo = "212";
                flag = Boolean.FALSE;
            }
            //Detalle tipo pagador
            String resultadoValidatorTipoPagador = afiliaciones.getTipoPagador();
            if (resultadoValidatorTipoPagador.contains("N")) {
                if (!elementoValidator.validaSolaUnaDeEstasLetras(afiliaciones.getNumIdentPagador().substring(0, 1), "VEP")) {
                    errorInLine.append("Campo Detalle Tipo Pagador natural que no aplica formato");
                    nroRechazo = "212";
                    flag = Boolean.FALSE;
                }
            } else if (resultadoValidatorTipoPagador.contains("R")) {
                if (!elementoValidator.validaSolaUnaDeEstasLetras(afiliaciones.getNumIdentPagador().substring(0, 1), "VE")) {
                    errorInLine.append("Campo Detalle Tipo Pagador natural que no aplica formato");
                    nroRechazo = "212";
                    flag = Boolean.FALSE;
                }
            } else if (resultadoValidatorTipoPagador.contains("J")) {
                if (!elementoValidator.validaSolaUnaDeEstasLetras(afiliaciones.getNumIdentPagador().substring(0, 1), "JG")) {
                    errorInLine.append("Campo Detalle Tipo Pagador Juridico que no aplica formato");
                    nroRechazo = "212";
                    flag = Boolean.FALSE;
                }
            }/* else if (resultadoValidatorTipoPagador.contains("J")) {
                if (!elementoValidator.validaSolaUnaDeEstasLetras(afiliaciones.getNumIdentPagador().substring(0, 1), "G")) {

                    errorInLine.append("Campo Detalle Tipo Pagador Gubernamental que no aplica formato");
                    nroRechazo = "212";
                    flag = Boolean.FALSE;
                }
            }*/

            //numero identificacion pagador
            if (!elementoValidator.validaSoloNumeros(afiliaciones.getNumIdentPagador().substring(1, (afiliaciones.getNumIdentPagador().length() - 1)))) {
                flag = Boolean.FALSE;
                errorInLine.append("Campo Detalle Nro. identificador Pagador  no aplica formato");
                nroRechazo = "500";
            }

            if (!elementoValidator.validaSoloNumeros(afiliaciones.getCtaBcoDestino())) {
                flag = Boolean.FALSE;
                errorInLine.append("La Cta. posee caracteres alpha numericos ");
                nroRechazo = "212";
            }

            if (afiliaciones.getCtaBcoDestino().length() != LONGITUD_DETALLE_CUENTA_PAGADOR) {
                flag = Boolean.FALSE;
                errorInLine.append("La Cta. tiene una longitud diferente a la establecida de 20 digitos");
                nroRechazo = "212";
            }
            if (BancosEnum.getById(Integer.valueOf(afiliaciones.getCtaBcoDestino().substring(0, 4))) == null) {
                flag = Boolean.FALSE;
                errorInLine.append("El codigo Banco no corresponde con bancos registrados. ");
                nroRechazo = "212";
            }
            if (!(afiliaciones.getCtaBcoDestino().substring(0, 4).trim().equals(afiliaciones.getCodBcoDestino()))){
                flag = Boolean.FALSE;
                errorInLine.append("Error en codigo Banco no corresponde en Cta. ");
                nroRechazo = "212";
            }

            //Nombre Pagador
          /*  if (!elementoValidator.validaAlfanumericoPuntoComa(afiliaciones.getNombrePagador())) {
                flag = Boolean.FALSE;
                errorInLine.append("Error en formato de nombre del pagador ");
                nroRechazo = "212";
            }*/
            if (!(afiliaciones.getNombrePagador().length() <= LONGITUD_DETALLE_NOMBRE_PAGADOR)) {
                flag = Boolean.FALSE;
                valida.setLinea(Boolean.FALSE);
                errorInLine.append("EL nombre del pagador tiene una longitud diferente a la establecida de 30 caracteres");
                nroRechazo = "212";
            }
            if (!(afiliaciones.getNombrePagador().length() > 5)) {
                flag = Boolean.FALSE;
                valida.setLinea(Boolean.FALSE);
                errorInLine.append("EL nombre del pagador debe ser mayor a 5 caracteres");
                nroRechazo = "212";
            }

            //Referencia Contrato
            if (!(afiliaciones.getRefContrato().length() <= LONGITUD_DETALLE_REFERENCIA_CONTRATO)) {
                flag = Boolean.FALSE;
                valida.setLinea(Boolean.FALSE);
                errorInLine.append("La Ref. Contrato tiene una longitud diferente a la establecida de " + LONGITUD_DETALLE_REFERENCIA_CONTRATO + "caracteres");
                nroRechazo = "212";
            }
            if (!elementoValidator.validaAlfaNumerico(afiliaciones.getRefContrato())) {
                flag = Boolean.FALSE;
                errorInLine.append("La Ref. Contrato posee caracteres incorrectos");
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
