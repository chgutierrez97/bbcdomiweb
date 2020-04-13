
package com.bbc.dom.bbcdomiweb.model;

import com.bbc.dom.bbcdomiweb.dto.IbAfiliacionesDetDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Christian Gutierrez
 */
public class AfiliacionJsonResponse {
    
   private FormAfiliacion afiliacionesDet;
   private List<FormAfiliacion> afiliacionesDetList;
   private boolean validated;
   private Map<String, String> errorMessages;

    public FormAfiliacion getAfiliacionesDet() {
        return afiliacionesDet;
    }

    public void setAfiliacionesDet(FormAfiliacion afiliacionesDet) {
        this.afiliacionesDet = afiliacionesDet;
    }

    public List<FormAfiliacion> getAfiliacionesDetList() {
        return afiliacionesDetList;
    }

    public void setAfiliacionesDetList(List<FormAfiliacion> afiliacionesDetList) {
        this.afiliacionesDetList = afiliacionesDetList;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public Map<String, String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(Map<String, String> errorMessages) {
        this.errorMessages = errorMessages;
    }
    
}
