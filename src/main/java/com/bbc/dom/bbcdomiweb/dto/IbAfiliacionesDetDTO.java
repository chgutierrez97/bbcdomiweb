package com.bbc.dom.bbcdomiweb.dto;


import java.util.Date;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Christian Gutierrez
 */
public class IbAfiliacionesDetDTO {
    
     private Integer id;
  
    private int idAfi;
    
    private String codOrdenante;
   
    private String claveOrdenente;
  
    private String codBcoDestino;
    
    private String ctaBcoDestino;
   
    private String tipoOperacion;
    
    private String tipoPagador;
   
    private String numIdentPagador;
   
    private String nombrePagador;
   
    private String refContrato;
    
    private int codUsuarioCarga;

    private Date fechaCargar;
    
    private String Linea;
    
    private Boolean Status;
    
    private String errorInLine;
    
    private String nroRechazo;
    
    private Long codLote;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdAfi() {
        return idAfi;
    }

    public void setIdAfi(int idAfi) {
        this.idAfi = idAfi;
    }

    public String getCodOrdenante() {
        return codOrdenante;
    }

    public void setCodOrdenante(String codOrdenante) {
        this.codOrdenante = codOrdenante;
    }

    public String getClaveOrdenente() {
        return claveOrdenente;
    }

    public void setClaveOrdenente(String claveOrdenente) {
        this.claveOrdenente = claveOrdenente;
    }

    public String getCodBcoDestino() {
        return codBcoDestino;
    }

    public void setCodBcoDestino(String codBcoDestino) {
        this.codBcoDestino = codBcoDestino;
    }

    public String getCtaBcoDestino() {
        return ctaBcoDestino;
    }

    public void setCtaBcoDestino(String ctaBcoDestino) {
        this.ctaBcoDestino = ctaBcoDestino;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public String getTipoPagador() {
        return tipoPagador;
    }

    public void setTipoPagador(String tipoPagador) {
        this.tipoPagador = tipoPagador;
    }

    public String getNumIdentPagador() {
        return numIdentPagador;
    }

    public void setNumIdentPagador(String numIdentPagador) {
        this.numIdentPagador = numIdentPagador;
    }

    public String getNombrePagador() {
        return nombrePagador;
    }

    public void setNombrePagador(String nombrePagador) {
        this.nombrePagador = nombrePagador;
    }

    public String getRefContrato() {
        return refContrato;
    }

    public void setRefContrato(String refContrato) {
        this.refContrato = refContrato;
    }

    public int getCodUsuarioCarga() {
        return codUsuarioCarga;
    }

    public void setCodUsuarioCarga(int codUsuarioCarga) {
        this.codUsuarioCarga = codUsuarioCarga;
    }

    public Date getFechaCargar() {
        return fechaCargar;
    }

    public void setFechaCargar(Date fechaCargar) {
        this.fechaCargar = fechaCargar;
    }

    public String getLinea() {
        return Linea;
    }

    public void setLinea(String Linea) {
        this.Linea = Linea;
    }

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean Status) {
        this.Status = Status;
    }

    public String getErrorInLine() {
        return errorInLine;
    }

    public void setErrorInLine(String errorInLine) {
        this.errorInLine = errorInLine;
    }

    public String getNroRechazo() {
        return nroRechazo;
    }

    public void setNroRechazo(String nroRechazo) {
        this.nroRechazo = nroRechazo;
    }

    public Long getCodLote() {
        return codLote;
    }

    public void setCodLote(Long codLote) {
        this.codLote = codLote;
    }

    
    @Override
    public String toString() {
        return "IbAfiliacionesDetDTO{" + "id=" + id + ", idAfi=" + idAfi + ", codOrdenante=" + codOrdenante + ", claveOrdenente=" + claveOrdenente + ", codBcoDestino=" + codBcoDestino + ", ctaBcoDestino=" + ctaBcoDestino + ", tipoOperacion=" + tipoOperacion + ", tipoPagador=" + tipoPagador + ", numIdentPagador=" + numIdentPagador + ", nombrePagador=" + nombrePagador + ", refContrato=" + refContrato + ", codUsuarioCarga=" + codUsuarioCarga + ", fechaCargar=" + fechaCargar + ", Linea=" + Linea + ", Status=" + Status + ", errorInLine=" + errorInLine + ", nroRechazo=" + nroRechazo + '}';
    }
    
}
