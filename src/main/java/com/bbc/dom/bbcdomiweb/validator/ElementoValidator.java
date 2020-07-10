/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.validator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Service;

/**
 *
 * @author Christian Gutierrez
 */
@Service
public class ElementoValidator {
    
      
 	public byte[] readfile(String filename) throws FileNotFoundException, IOException {
        byte[] data;
        data = new byte[1000];
        File file = new File(filename);
        FileInputStream fis = new FileInputStream(file);
        int i = fis.read(data);
        return data;
    }

/**
     * valida si un string sea solo numerico
     *
     * @param texto el string a validar
     * @return
     */
    public boolean validaSoloNumeros(String texto) {
        return texto.matches("[0-9]+");
    }
    /**
     * valida si un string sea solo numerico con espacios en blanco
     *
     * @param texto el string a validar
     * @return
     */    
    public boolean validaSoloNumerosYEspaciosEnBlanco(String texto) {
        return texto.matches("[0-9 ]+");
    }

    /**
     * valida si el indice rif es valido
     *
     * @param texto el string a validar
     * @return
     */
    public boolean validaIndiceRif(String texto) {
        return texto.matches("[JVGPEjvgpe]+");
    }

    /**
     * valida si un string posee solo letras
     *
     * @param texto el string a validar
     * @return
     */
    public boolean validaAlfabetico(String texto) {
        return texto.replaceAll(" ", "").matches("[a-zA-ZÁÉÍÓÚáéíóúÑñ]+");
    }
    
    /**
     * valida si un string posee solo letras y los caracteres especiales "," y "."
     *
     * @param texto el string a validar
     * @return
     */
    public boolean validaAlfanumericoPuntoComa(String texto) {
        return texto.replaceAll(" ", "").matches("[a-zA-Z0-9ÁÉÍÓÚáéíóúÑñ]+");
    }
    
    public boolean validaAlfanumericoConGuion(String texto) {
        return texto.replaceAll(" ", "").matches("[a-zA-Z0-9ÁÉÍÓÚáéíóúÑñ-]+");
    }

    public boolean validaAlfaNumerico(String texto) {
        return texto.replaceAll(" ", "").matches("[a-zA-Z0-9ÁÉÍÓÚáéíóúÑñ.,;:]+");
    }


    
    public boolean validaEmail(String texto) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        return texto.replaceAll(" ", "").matches(EMAIL_PATTERN);
    }

    /**
     * valida que el string "letra" sea solo una de las letras contenidas en el
     * string "letras"
     *
     * @param letra
     * @param letras
     * @return
     */
    public boolean validaSolaUnaDeEstasLetras(String letra, String letras) {
        return (letra.length() == 1) && (letras.indexOf(letra) >= 0);
    }

    /**
     * retorna la diferencia en horas entre dos fechas
     *
     * @param d1
     * @param d2
     * @return
     */
    public static long diferenciaDeHorasEntre(Date d1, Date d2) {
        final int MILLI_TO_HOUR = 1000 * 60 * 60;
        long salida = (long) (d1.getTime() - d2.getTime()) / MILLI_TO_HOUR;
        return salida;
    }

    /**
     * retorna la fecha del sistema del instante, similar a la funcion "now" o
     * "sysdate" de otras plataformas
     *
     * @return la fecha y hora actual del sistema
     */
    public static Date ahora() {
        return new Date();
    }

    /**
     * verifica si un elemento entero esta entra a y b
     *
     * @param elememto
     * @param a
     * @param b
     * @return ::= " elemento entre a y b? " ::= " a <= elemento <= b "
     */
    public static boolean between(int elemento, int a, int b) {
        return (a <= elemento) && (elemento <= b);
    }

    public boolean validaSoloLetras(String texto) {
        return texto.replaceAll(" ", "").matches("[a-zA-Z]+");
    }

    public boolean validaFecha(String strFecha, String strFormat) {
        try {
            DateFormat df = new SimpleDateFormat(strFormat);
            df.setLenient(false);
            df.parse(strFecha);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    
    public boolean validaFormatoFecha(String texto) {
        return texto.replaceAll(" ", "").matches("[a-zA-Z]+");
    }
}
