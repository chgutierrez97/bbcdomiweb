
package com.bbc.dom.bbcdomiweb.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    
}
