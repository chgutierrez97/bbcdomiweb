package com.bbc.dom.bbcdomiweb.controller;

import com.bbc.dom.bbcdomiweb.dto.ConsolidadoAfiliacionesDTO;
import com.bbc.dom.bbcdomiweb.dto.ConsolidadoDomiciliacionesDTO;
import com.bbc.dom.bbcdomiweb.dto.DetalleAfiliacionesDTO;
import com.bbc.dom.bbcdomiweb.dto.DetalleDomiciliacionesDTO;
import com.bbc.dom.bbcdomiweb.dto.DomiciliacionRestTempDTO;
import com.bbc.dom.bbcdomiweb.dto.Validation;
import com.bbc.dom.bbcdomiweb.dto.IbAfiliacionesDetDTO;
import com.bbc.dom.bbcdomiweb.dto.IbDomiciliacionesDetDTO;
import com.bbc.dom.bbcdomiweb.dto.PaginadorDTO;
import com.bbc.dom.bbcdomiweb.dto.RespuestaDTO;
import com.bbc.dom.bbcdomiweb.dto.SumarioCargaMasivaDTO;
import com.bbc.dom.bbcdomiweb.model.FormAfiliacion;
import com.bbc.dom.bbcdomiweb.model.FormDomiciliacion;
import com.bbc.dom.bbcdomiweb.model.IbMensajes;
import com.bbc.dom.bbcdomiweb.model.IbSumarioAfiliaciones;
import com.bbc.dom.bbcdomiweb.model.IbSumarioPagos;
import com.bbc.dom.bbcdomiweb.model.MgAfiliacionesOrdenantes;
import com.bbc.dom.bbcdomiweb.model.MgAfiliacionesPresentadas;
import com.bbc.dom.bbcdomiweb.model.MgDomiciliacionesEnviadas;
import com.bbc.dom.bbcdomiweb.model.MgDomiciliacionesOrdenantes;
import com.bbc.dom.bbcdomiweb.model.MgParametrosOrdenantes;
import com.bbc.dom.bbcdomiweb.model.UploadedFile;
import com.bbc.dom.bbcdomiweb.propeties.BancosEnum;
import com.bbc.dom.bbcdomiweb.services.IbAfiliacionesServices;
import com.bbc.dom.bbcdomiweb.services.IbDomiciliacionesServices;
import com.bbc.dom.bbcdomiweb.services.IbhiloAfiliacionDomiciliacion;
import com.bbc.dom.bbcdomiweb.util.GeneradorClaveOrdenante;
import com.bbc.dom.bbcdomiweb.validator.FileValidator;
import com.bbc.dom.bbcdomiweb.validator.ValidatorCargaAfiliaciones;
import com.bbc.dom.bbcdomiweb.validator.ValidatorCargaDomiciliaciones;
import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import java.text.DecimalFormat;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Controller
public class UploadController {

    @Autowired
    FileValidator fileValidator;
    @Autowired
    ValidatorCargaAfiliaciones validatorCargaAfiliaciones;
    @Autowired
    ValidatorCargaDomiciliaciones validatorCargaDomiciliaciones;
    @Autowired
    IbAfiliacionesServices ibAfiliacionesServices;
    @Autowired
    IbDomiciliacionesServices ibDomiciliacionesServices;

    private final int LONGITUD_DETALLE_CODIGO_ORDENANTE = 4;
    private final int LONGITUD_DETALLE_CLAVE_ORDENANTE = 15;
    private final int LONGITUD_DETALLE_BANCO_DESTINO = 4;
    private final int LONGITUD_DETALLE_TIPO_OPERACION = 1;
    private final int LONGITUD_DETALLE_TIPO_PAGADOR = 1;
    protected final int LONGITUD_DETALLE_TIPO_PAGADOR_DETALLE = 1;
    private final int LONGITUD_DETALLE_IDENTIFICADOR_PAGADOR = 12;
    private final int LONGITUD_DETALLE_CUENTA_PAGADOR = 20;
    private final int LONGITUD_DETALLE_NOMBRE_PAGADOR = 30;
    private final int LONGITUD_NUMERO_PAGADOR = 12;
    private final int LONGITUD_DETALLE_REFERENCIA_CONTRATO = 30;

    private final int LONGITUD_DETALLE_DOM_CODIGO_ORDENANTE = 4;
    private final int LONGITUD_DETALLE_DOM_CLAVE_ORDENANTE = 15;
    private final int LONGITUD_DETALLE_DOM_TIPO_OPERACION = 3;
    private final int LONGITUD_DETALLE_DOM_TIPO_SUB_DOMINIO = 3;
    private final int LONGITUD_DETALLE_DOM_CUENTA_PAGADOR = 20;
    private final int LONGITUD_DETALLE_DOM_MONTO = 15;
    private final int LONGITUD_DETALLE_DOM_TIPO_PAGADOR = 1;
    private final int LONGITUD_DETALLE_DOM_IDENTIFICADOR_PAGADOR = 12;
    private final int LONGITUD_DETALLE_DOM_NOMBRE_PAGADOR = 30;
    private final int LONGITUD_DETALLE_DOM_REFERENCIA_CONTRATO = 30;
    private final int LONGITUD_DETALLE_DOM_FACTURA_NUMERO = 20;
    private final int LONGITUD_DETALLE_DOM_FECHA_EMICION_FACTURA = 8;
    private final int LONGITUD_DETALLE_DOM_FECHA_VENCIMIENTO_FACTURA = 8;

    private String fileName;
    private String operationName;
    private String ErrorMensajeArch;

    private List<IbAfiliacionesDetDTO> listIbAfiliacionesDet;
    private List<IbAfiliacionesDetDTO> listIbAfiliacionesDetError;
    private List<IbDomiciliacionesDetDTO> listIbDomiciliacionesDet;
    private List<IbDomiciliacionesDetDTO> listIbDomiciliacionesDetError;
    private List<FormAfiliacion> listFormAfiliacion = new ArrayList<>();
    private List<FormDomiciliacion> listFormDomiciliacion = new ArrayList<>();
    private List<IbSumarioPagos> listIbSumarioPagos = new ArrayList<>();
    private List<IbSumarioAfiliaciones> listIbSumarioAfiliaciones = new ArrayList<>();
    private List<ConsolidadoAfiliacionesDTO> listConsolidadoAfiliaciones = new ArrayList<>();
    private SumarioCargaMasivaDTO sumAfiliaMasive;
    private String codigoOrdenante = "0001";
    private Boolean FlagArchivo = Boolean.TRUE;

    private int id = 0;
    private int idDomi = 0;
    private float totalPagSumAfi = 0;
    private int totalPagSumDom = 0;
    private int totalPagDetAfi = 0;
    private int totalPagDetDom = 0;

    public List<IbSumarioPagos> getListIbSumarioPagos() {
        return listIbSumarioPagos;
    }

    public void setListIbSumarioPagos(List<IbSumarioPagos> listIbSumarioPagos) {
        this.listIbSumarioPagos = listIbSumarioPagos;
    }

    public List<IbSumarioAfiliaciones> getListIbSumarioAfiliaciones() {
        return listIbSumarioAfiliaciones;
    }

    public void setListIbSumarioAfiliaciones(List<IbSumarioAfiliaciones> listIbSumarioAfiliaciones) {
        this.listIbSumarioAfiliaciones = listIbSumarioAfiliaciones;
    }

    public List<IbAfiliacionesDetDTO> getListIbAfiliacionesDet() {
        return listIbAfiliacionesDet;
    }

    public void setListIbAfiliacionesDet(List<IbAfiliacionesDetDTO> listIbAfiliacionesDet) {
        this.listIbAfiliacionesDet = listIbAfiliacionesDet;
    }

    public List<IbAfiliacionesDetDTO> getListIbAfiliacionesDetError() {
        return listIbAfiliacionesDetError;
    }

    public void setListIbAfiliacionesDetError(List<IbAfiliacionesDetDTO> listIbAfiliacionesDetError) {
        this.listIbAfiliacionesDetError = listIbAfiliacionesDetError;
    }

    public List<IbDomiciliacionesDetDTO> getListIbDomiciliacionesDetError() {
        return listIbDomiciliacionesDetError;
    }

    public void setListIbDomiciliacionesDetError(List<IbDomiciliacionesDetDTO> listIbDomiciliacionesDetError) {
        this.listIbDomiciliacionesDetError = listIbDomiciliacionesDetError;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public List<FormAfiliacion> getListFormAfiliacion() {
        return listFormAfiliacion;
    }

    public void setListFormAfiliacion(List<FormAfiliacion> listFormAfiliacion) {
        this.listFormAfiliacion = listFormAfiliacion;
    }

    public String getCodigoOrdenante() {
        return codigoOrdenante;
    }

    public void setCodigoOrdenante(String codigoOrdenante) {
        this.codigoOrdenante = codigoOrdenante;
    }

    public Boolean getFlagArchivo() {
        return FlagArchivo;
    }

    public void setFlagArchivo(Boolean FlagArchivo) {
        this.FlagArchivo = FlagArchivo;
    }

    public String getErrorMensajeArch() {
        return ErrorMensajeArch;
    }

    public void setErrorMensajeArch(String ErrorMensajeArch) {
        this.ErrorMensajeArch = ErrorMensajeArch;
    }

    public List<ConsolidadoAfiliacionesDTO> getListConsolidadoAfiliaciones() {
        return listConsolidadoAfiliaciones;
    }

    public void setListConsolidadoAfiliaciones(List<ConsolidadoAfiliacionesDTO> listConsolidadoAfiliaciones) {
        this.listConsolidadoAfiliaciones = listConsolidadoAfiliaciones;
    }

    @RequestMapping("/fileUploadForm")
    public ModelAndView getUploadForm(@ModelAttribute("uploadedFile") UploadedFile uploadedFile, BindingResult result) {
        return new ModelAndView("uploadForm");
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("upload");
    }

    @RequestMapping(value = "/domiciliacion", method = RequestMethod.POST)
    public ModelAndView uploadPagosMasivo(@RequestParam("opcion") String opcion) {
        return new ModelAndView("main/home");
    }

    @RequestMapping(value = "/saveTempDomiciliacion", method = RequestMethod.GET)
    @ResponseBody
    public RespuestaDTO saveTempDomiciliacion() {
        Long idSumarioDomi = 0L;
        RespuestaDTO respuesta = new RespuestaDTO();
        List<DetalleAfiliacionesDTO> mgDetalleAfiliacionesDTO = new ArrayList<>();
        boolean sw = false;
        this.listIbDomiciliacionesDet = new ArrayList<>();
        try {
            mgDetalleAfiliacionesDTO = ibAfiliacionesServices.BuscarAfiliadoPresentadasByOrdenante(this.codigoOrdenante);
            for (FormDomiciliacion formDomiciliacion : this.listFormDomiciliacion) {
                IbDomiciliacionesDetDTO domiciliacion = new IbDomiciliacionesDetDTO();
                domiciliacion.setCodOrdenante(this.codigoOrdenante);
                String claveOrdenante
                        = GeneradorClaveOrdenante.getPassword(
                                GeneradorClaveOrdenante.MINUSCULAS
                                + GeneradorClaveOrdenante.MAYUSCULAS
                                + GeneradorClaveOrdenante.ESPECIALES, 10);
                domiciliacion.setClaveOrdenente(claveOrdenante);

                domiciliacion.setCtaPagador(formDomiciliacion.getCtaBcoDestino());
                domiciliacion.setCodUsuarioCarga(123);

                domiciliacion.setTipoPagador(formDomiciliacion.getTipoPagador());
                domiciliacion.setIdentificadorPagador(formDomiciliacion.getTipoDoc() + formDomiciliacion.getNumIdentPagador());

                domiciliacion.setNombrePagador(formDomiciliacion.getNombrePagador());
                domiciliacion.setRefContrato(formDomiciliacion.getRefContrato());
                domiciliacion.setTipoOperacion(formDomiciliacion.getTipoOperacion());
                domiciliacion.setMonto(formDomiciliacion.getMonto());
                for (DetalleAfiliacionesDTO obj : mgDetalleAfiliacionesDTO) {
                    if (obj.getSituacion().equalsIgnoreCase("P") && obj.getContrato().trim().equals(domiciliacion.getRefContrato().trim())) {
                        sw = true;
                        break;
                    }
                }
                if (sw == false) {
                    domiciliacion.setStatus(false);
                } else {
                    domiciliacion.setStatus(true);
                }
                sw = false;

                String nombre = formDomiciliacion.getNombrePagador();

                int iterator;
                String espacio = "";
                if ((nombre.length() > 5) && (nombre.length() < LONGITUD_DETALLE_NOMBRE_PAGADOR)) {
                    iterator = 0;
                    StringBuffer errorInLine = new StringBuffer();
                    iterator = LONGITUD_DETALLE_NOMBRE_PAGADOR - nombre.length();

                    for (int m = 0; m < iterator; m++) {
                        errorInLine.append(" ");
                    }

                    espacio = errorInLine.toString();
                } else if (nombre.length() > LONGITUD_DETALLE_NOMBRE_PAGADOR) {

                    nombre = nombre.substring(0, 29);
                }
                String monto = formDomiciliacion.getMonto().replaceAll("[,.]", "");
                String linea = this.codigoOrdenante.trim() + claveOrdenante + agregarEspacio(claveOrdenante, LONGITUD_DETALLE_DOM_CLAVE_ORDENANTE) + "020001" + formDomiciliacion.getCtaBcoDestino() + agregarCeros(monto, LONGITUD_DETALLE_DOM_MONTO) + monto + formDomiciliacion.getTipoPagador() + formDomiciliacion.getTipoDoc() + formDomiciliacion.getNumIdentPagador() + agregarEspacio(formDomiciliacion.getTipoDoc() + formDomiciliacion.getNumIdentPagador(), LONGITUD_NUMERO_PAGADOR) + formDomiciliacion.getNombrePagador().trim() + agregarEspacio(formDomiciliacion.getNombrePagador().trim(), LONGITUD_DETALLE_DOM_NOMBRE_PAGADOR) + formDomiciliacion.getRefContrato() + agregarEspacio(formDomiciliacion.getRefContrato(), LONGITUD_DETALLE_DOM_REFERENCIA_CONTRATO) + agregarCeros("", LONGITUD_DETALLE_DOM_FACTURA_NUMERO) + formDomiciliacion.getFechaEmision().replace("/", "") + formDomiciliacion.getFechaVcto().replace("/", "");
                System.out.println(linea);
                domiciliacion.setNombrePagador(nombre);
                domiciliacion.setLinea(linea);
                domiciliacion.setRefContrato(linea);
                this.listIbDomiciliacionesDet.add(domiciliacion);
            }
            if (this.listIbDomiciliacionesDet.size() > 0) {

                IbSumarioPagos sumarioPagos = new IbSumarioPagos();
                sumarioPagos.setCodigoOrdenante(Long.valueOf(this.codigoOrdenante));
                sumarioPagos.setEstatusCargar(0L);
                sumarioPagos.setFechaHoraCarga(new Date());
                SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
                String fechaHora = ((new Date()).getTime() + "");
                String nombreDinamicoArchivo2 = "DO_" + this.codigoOrdenante + "_" + formatter.format(new Date()) + "_M_" + fechaHora.subSequence((fechaHora.length() - 4), fechaHora.length());
                sumarioPagos.setNombreArchivo(nombreDinamicoArchivo2);
                sumarioPagos.setNroRegistrosProcesar(new BigInteger("" + this.listIbDomiciliacionesDet.size()));
                sumarioPagos.setNroRegistrosRechazados(new BigInteger("" + new BigInteger("0")));
                sumarioPagos.setNroRegistrosValidados(new BigInteger("" + this.listIbDomiciliacionesDet.size()));
                Double total = 0D;
                for (IbDomiciliacionesDetDTO ibDomiciliacionesDetDTO : this.listIbDomiciliacionesDet) {
                    String motoRegistro = ibDomiciliacionesDetDTO.getMonto();
                    String motoRegistroAux = "";
                    String[] a = motoRegistro.split(",");
                    motoRegistroAux = a[0].replace(".", "");
                    motoRegistroAux = motoRegistroAux + "." + a[1];

                    total = total + Double.valueOf(motoRegistroAux);
                }

                sumarioPagos.setMontoTotalAprovado(new BigDecimal(total));

                if (sumarioPagos.getNroRegistrosValidados() != BigInteger.ZERO) {
                    idSumarioDomi = ibDomiciliacionesServices.procesarSumario(sumarioPagos);
                    if (idSumarioDomi == 0L) {
                        idSumarioDomi = ibDomiciliacionesServices.procesarSumario(sumarioPagos);
                        if (idSumarioDomi == 0L) {
                            idSumarioDomi = ibDomiciliacionesServices.procesarSumario(sumarioPagos);
                        }
                    }
                }

                if (idSumarioDomi != 0L) {

                    for (IbDomiciliacionesDetDTO ibDomiciliacionesDetDTO : listIbDomiciliacionesDet) {

                        ibDomiciliacionesDetDTO.setCodLote(idSumarioDomi);
                    }
                    ExecutorService executor = Executors.newSingleThreadExecutor();
                    executor.submit(() -> {
                        IbhiloAfiliacionDomiciliacion hiloAfiliacion = new IbhiloAfiliacionDomiciliacion(null, this.listIbDomiciliacionesDet, "DO");
                        hiloAfiliacion.regis();
                        executor.shutdown();
                    });
                    clearCargaAfiDom();
                }

            } else {
                respuesta.setCodigo("001");
                respuesta.setDescripcion("Error, no hay data para guardar.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            respuesta.setCodigo("001");
            respuesta.setDescripcion("Error en servicio de afiliacion individual en linea. ");
        }

        return respuesta;
    }

    /**
     * ***********************PROCESO MASIVO DE DOMICILIACION *
     * *********************************
     */
    @RequestMapping(value = "/uploadDomiciliacion", method = RequestMethod.POST)
    public ModelAndView uploadPagosMasivo(@RequestParam("fileDomiciliacion") MultipartFile fileDomiciliacion, RedirectAttributes redirectAttributes) {
        this.listIbDomiciliacionesDet = new ArrayList<>();
        this.listIbDomiciliacionesDetError = new ArrayList<>();
        RespuestaDTO resp = procesoArchivo(fileDomiciliacion, "DO");
        if (resp.getCodigo().equals("000")) {
            ModelAndView model = new ModelAndView("pagos/sumarioCargaMasivaDomiciliacion");
            return model;
        } else {
            ModelAndView model = new ModelAndView("main/home");
            return model;
        }
    }

    public void uploadExelDomiciliacion2(String inputFilePath) throws FileNotFoundException, IOException {
        InputStream inp = null;
        try {
            List<DetalleAfiliacionesDTO> mgDetalleAfiliacionesDTO = new ArrayList<>();
            boolean sw = false;
            inp = new FileInputStream(inputFilePath);

            XSSFWorkbook libro = new XSSFWorkbook(inp); //Declare XSSF WorkBook
            XSSFSheet hoja = libro.getSheetAt(0); //sheet can be used as common for XSSF and HSSF
            int rows = hoja.getLastRowNum();
            int tregisVal = 0, tregisRecha = 0;
            int tregisTotal = 0;
            int filaNum = 1;
            Double total = 0D;
            for (int i = 1; i <= rows; ++i) {
                Validation validado = new Validation();
                IbDomiciliacionesDetDTO newDomi = new IbDomiciliacionesDetDTO();

                XSSFRow q = hoja.getRow(filaNum);
                String link0 = ("" + q.getCell(0)).trim();
                String link1 = ("" + q.getCell(1)).trim();
                String link2 = ("" + q.getCell(2)).trim();
                String link3 = ("" + q.getCell(3)).trim();
                String link4 = ("" + q.getCell(4)).trim();
                String link5 = ("" + q.getCell(5)).trim();
                String link6 = ("" + q.getCell(6)).trim();
                String link7 = ("" + q.getCell(7)).trim();
                String link8 = ("" + q.getCell(8)).trim();
                String link9 = ("" + q.getCell(9)).trim();
                String link10 = ("" + q.getCell(10)).trim();
                String link11 = ("" + q.getCell(11)).trim();
                String link12 = ("" + q.getCell(12)).trim();

                newDomi.setCodOrdenante(link0);
                newDomi.setClaveOrdenente(link1);
                newDomi.setTipoOperacion(link2);
                newDomi.setSubTipoDominio(link3);
                newDomi.setCtaPagador(link4);
                newDomi.setMonto(link5);
                newDomi.setTipoPagador(link6);
                newDomi.setIdentificadorPagador(link7);
                newDomi.setNombrePagador(link8);
                newDomi.setRefContrato(link9);
                newDomi.setFacturaNumero(link10);
                newDomi.setFechaEmisionFactura(link11);
                newDomi.setFechaVencimientoFactura(link12);
                newDomi.setFechaCargar(new Date());
                newDomi.setIdAfi(1);
                newDomi.setCodUsuarioCarga(123);
                newDomi.setLinea("");

                String nombre = link8;
                int iterator;
                String espacio = "";
                if ((nombre.length() > 5) && (nombre.length() < LONGITUD_DETALLE_NOMBRE_PAGADOR)) {
                    iterator = 0;
                    StringBuffer errorInLine = new StringBuffer();
                    iterator = LONGITUD_DETALLE_NOMBRE_PAGADOR - nombre.length();

                    for (int m = 0; m < iterator; m++) {
                        errorInLine.append(" ");
                    }

                    espacio = errorInLine.toString();
                } else if (nombre.length() > LONGITUD_DETALLE_NOMBRE_PAGADOR) {

                    nombre = nombre.substring(0, 29);
                }

                String linea = link0.trim() + agregarCeros(link1.trim(), LONGITUD_DETALLE_DOM_CLAVE_ORDENANTE) + link1.trim() + "020001" + link4.trim() + agregarCeros(link5.trim(), LONGITUD_DETALLE_DOM_MONTO) + link5.trim() + link6.trim() + link7.trim() + agregarEspacio(link7.trim(), LONGITUD_NUMERO_PAGADOR) + "   " + link8.trim() + agregarEspacio(link8.trim(), LONGITUD_DETALLE_DOM_NOMBRE_PAGADOR) + link9.trim() + agregarEspacio(link9.trim(), LONGITUD_DETALLE_DOM_REFERENCIA_CONTRATO) + link10.trim() + agregarCeros(link10.trim(), LONGITUD_DETALLE_DOM_FACTURA_NUMERO) + link11.trim() + link12.trim();
                System.out.println(linea);

                validado = validatorCargaDomiciliaciones.getValidaDomiciliacion(newDomi);

                if (!this.codigoOrdenante.equals(link0.trim())) {
                    validado.setCodError("212");
                    validado.setStatusRegistro(false);
                    validado.setErrores("Codigo ordenante del registro nopertenece a la empresa que esta procesando el archivo.");
                } else {
                    if (i == 1) {
                        mgDetalleAfiliacionesDTO = ibAfiliacionesServices.BuscarAfiliadoPresentadasByOrdenante(this.codigoOrdenante);
                    }
                    for (DetalleAfiliacionesDTO obj : mgDetalleAfiliacionesDTO) {
                        if (obj.getSituacion().equalsIgnoreCase("P") /*obj.getContrato().trim().equals(newDom.getRefContrato())*/ && obj.getIdentificacionPagador().trim().equals(newDomi.getIdentificadorPagador().trim())) {
                            sw = true;
                            break;
                        }
                    }
                }
                if (sw == false) {
                    validado.setCodError("212");
                    validado.setStatusRegistro(false);
                    validado.setErrores("Registro no se encuentra en mg_afiliaciones_presentadas.");
                }
                sw = false;

                newDomi.setStatus(validado.getStatusRegistro());
                newDomi.setErrorInLine(validado.getErrores());

                if (validado.getLinea()) {
                    newDomi.setLinea(linea);
                } else {
                    newDomi.setLinea("");
                }
                if (newDomi.getStatus().equals(false)) {
                    tregisRecha++;
                } else {
                    tregisVal++;
                }
                listIbDomiciliacionesDet.add(newDomi);

                filaNum++;
                int longitud = link5.trim().length();
                //String monto =  link5.substring(0,longitud-2)+"."+link5.substring((longitud-2),4);
                total = total + Double.valueOf(link5);
            }
            this.sumAfiliaMasive = new SumarioCargaMasivaDTO();
            sumAfiliaMasive.setFechaCargaArchivo(new Date());
            sumAfiliaMasive.setFechaString(getFechaMod(new Date()));
            sumAfiliaMasive.setNombreDeArchivo(inputFilePath.split("-")[1]);
            sumAfiliaMasive.setNumRegProcesados(rows);
            sumAfiliaMasive.setNumRegValidados(tregisVal);
            sumAfiliaMasive.setNumRegRechazados(tregisRecha);
            sumAfiliaMasive.setMontoTotalAprovado(total);
            inp.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UploadController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UploadController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void uploadExelDomiciliacion(String inputFilePath) {
        try {
            List<DetalleAfiliacionesDTO> mgDetalleAfiliacionesDTO = new ArrayList<>();
            boolean sw = false;
            listIbDomiciliacionesDet.clear();
            HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(inputFilePath));
            HSSFSheet sheet = wb.getSheetAt(0);

            int rows = sheet.getLastRowNum();
            int filaNum = 1;
            int tregisVal = 0, tregisRecha = 0;
            int tregisTotal = 0;
            Double total = 0D;
            for (int i = 1; i <= rows; i++) {

                Validation validado = new Validation();
                IbDomiciliacionesDetDTO newDomi = new IbDomiciliacionesDetDTO();

                HSSFRow row = sheet.getRow(filaNum);
                HSSFCell linkCel0 = row.getCell(0);
                HSSFCell linkCel1 = row.getCell(1);
                HSSFCell linkCel2 = row.getCell(2);
                HSSFCell linkCel3 = row.getCell(3);
                HSSFCell linkCel4 = row.getCell(4);
                HSSFCell linkCel5 = row.getCell(5);
                HSSFCell linkCel6 = row.getCell(6);
                HSSFCell linkCel7 = row.getCell(7);
                HSSFCell linkCel8 = row.getCell(8);
                HSSFCell linkCel9 = row.getCell(9);
                HSSFCell linkCel10 = row.getCell(10);
                HSSFCell linkCel11 = row.getCell(11);
                HSSFCell linkCel12 = row.getCell(12);

                String link0 = linkCel0.getStringCellValue().trim();
                String link1 = linkCel1.getStringCellValue().trim();
                String link2 = linkCel2.getStringCellValue().trim();
                String link3 = linkCel3.getStringCellValue().trim();
                String link4 = linkCel4.getStringCellValue().trim();
                String link5 = linkCel5.getStringCellValue().trim();
                String link6 = linkCel6.getStringCellValue().trim();
                String link7 = linkCel7.getStringCellValue().trim();
                String link8 = linkCel8.getStringCellValue().trim();
                String link9 = linkCel9.getStringCellValue().trim();
                String link10 = linkCel10.getStringCellValue().trim();
                String link11 = linkCel11.getStringCellValue().trim();
                String link12 = linkCel12.getStringCellValue().trim();

                newDomi.setCodOrdenante(link0);
                newDomi.setClaveOrdenente(link1);
                newDomi.setTipoOperacion(link2);
                newDomi.setSubTipoDominio(link3);
                newDomi.setCtaPagador(link4);
                newDomi.setMonto(link5);
                newDomi.setTipoPagador(link6);
                newDomi.setIdentificadorPagador(link7);
                newDomi.setNombrePagador(link8);
                newDomi.setRefContrato(link9);
                newDomi.setFacturaNumero(link10);
                newDomi.setFechaEmisionFactura(link11);
                newDomi.setFechaVencimientoFactura(link12);

                newDomi.setFechaCargar(new Date());
                newDomi.setIdAfi(1);
                newDomi.setCodUsuarioCarga(123);
                newDomi.setLinea("");
                String nombre = link8;

                int iterator;
                String espacio = "";
                if ((nombre.length() > 5) && (nombre.length() < LONGITUD_DETALLE_NOMBRE_PAGADOR)) {
                    iterator = 0;
                    StringBuffer errorInLine = new StringBuffer();
                    iterator = LONGITUD_DETALLE_NOMBRE_PAGADOR - nombre.length();

                    for (int m = 0; m < iterator; m++) {
                        errorInLine.append(" ");
                    }

                    espacio = errorInLine.toString();
                } else if (nombre.length() > LONGITUD_DETALLE_NOMBRE_PAGADOR) {

                    nombre = nombre.substring(0, 29);
                }

                String linea = link0.trim() + agregarCeros(link1.trim(), LONGITUD_DETALLE_DOM_CLAVE_ORDENANTE) + link1.trim() + "020001" + link4.trim() + agregarCeros(link5.trim(), LONGITUD_DETALLE_DOM_MONTO) + link5.trim() + link6.trim() + link7.trim() + agregarEspacio(link7.trim(), LONGITUD_NUMERO_PAGADOR) + "   " + link8.trim() + agregarEspacio(link8.trim(), LONGITUD_DETALLE_DOM_NOMBRE_PAGADOR) + link9.trim() + agregarEspacio(link9.trim(), LONGITUD_DETALLE_DOM_REFERENCIA_CONTRATO) + link10.trim() + agregarCeros(link10.trim(), LONGITUD_DETALLE_DOM_FACTURA_NUMERO) + link11.trim() + link12.trim();
                System.out.println(linea);

                validado = validatorCargaDomiciliaciones.getValidaDomiciliacion(newDomi);

                if (!this.codigoOrdenante.equals(link0.trim())) {
                    validado.setCodError("212");
                    validado.setStatusRegistro(false);
                    validado.setErrores("Codigo ordenante del registro nopertenece a la empresa que esta procesando el archivo.");
                } else {
                    if (i == 1) {
                        mgDetalleAfiliacionesDTO = ibAfiliacionesServices.BuscarAfiliadoPresentadasByOrdenante(this.codigoOrdenante);
                    }
                    for (DetalleAfiliacionesDTO obj : mgDetalleAfiliacionesDTO) {
                        if (obj.getSituacion().equalsIgnoreCase("P") /*obj.getContrato().trim().equals(newDom.getRefContrato())*/ && obj.getIdentificacionPagador().trim().equals(newDomi.getIdentificadorPagador().trim())) {
                            sw = true;
                            break;
                        }
                    }
                }
                if (sw == false) {
                    validado.setCodError("212");
                    validado.setStatusRegistro(false);
                    validado.setErrores("Registro no se encuentra en mg_afiliaciones_presentadas.");
                }
                sw = false;
                newDomi.setStatus(validado.getStatusRegistro());
                newDomi.setErrorInLine(validado.getErrores());

                if (validado.getLinea()) {
                    newDomi.setLinea(linea);
                } else {
                    newDomi.setLinea("");
                }

                if (newDomi.getStatus().equals(false)) {
                    tregisRecha++;
                } else {
                    tregisVal++;
                }

                listIbDomiciliacionesDet.add(newDomi);
                tregisTotal++;
                filaNum++;
                int longitud = link5.trim().length();
                //String monto =  link5.substring(0,longitud-2)+"."+link5.substring((longitud-2),4);
                //String monto =  link5.substring(0,longitud-2)+"."+link5.substring((longitud-2),4);
                total = total + Double.valueOf(link5);

            }

            this.sumAfiliaMasive = new SumarioCargaMasivaDTO();
            sumAfiliaMasive.setFechaCargaArchivo(new Date());
            sumAfiliaMasive.setFechaString(getFechaMod(new Date()));
            sumAfiliaMasive.setNombreDeArchivo(inputFilePath.split("-")[1]);
            sumAfiliaMasive.setNumRegProcesados(tregisTotal);
            sumAfiliaMasive.setNumRegValidados(tregisVal);
            sumAfiliaMasive.setNumRegRechazados(tregisRecha);
            sumAfiliaMasive.setMontoTotalAprovado(total);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * ********************PROCESO DE AFILIACION MANUAL EN LINEA * *
     * ****************************
     */
    @RequestMapping(value = "/regAfiliacionTemp", method = RequestMethod.POST)
    @ResponseBody
    public List<FormAfiliacion> regAfiliacionTemp(@RequestBody FormAfiliacion afiliado) {
        id++;
        afiliado.setId(id);
        afiliado.setNameBcoDestino(BancosEnum.getById(Integer.valueOf(afiliado.getCodBcoDestino())).getDescripcion());
        if(afiliado.getTipoDoc().equalsIgnoreCase("J") || afiliado.getTipoDoc().equalsIgnoreCase("G")){
            afiliado.setTipoPagador("J");
        }else{
            afiliado.setTipoPagador("N");
        }
        listFormAfiliacion.add(afiliado);
        return listFormAfiliacion;
    }

    @RequestMapping(value = "/regDomiciliacionTemp", method = RequestMethod.POST)
    @ResponseBody
    public DomiciliacionRestTempDTO regDomiciliacionTemp(@RequestBody FormDomiciliacion domiciliacion) {
        DomiciliacionRestTempDTO respuesta = new DomiciliacionRestTempDTO();
        idDomi++;
        Long tRegis = 0L;
        Double tMontos = 0D;
        domiciliacion.setId(idDomi);
        listFormDomiciliacion.add(domiciliacion);
        for (FormDomiciliacion formDomiciliacion : listFormDomiciliacion) {
            tRegis++;

            String motoRegistro = formDomiciliacion.getMonto();
            String motoRegistroAux = "";
            String[] a = motoRegistro.split(",");
            motoRegistroAux = a[0].replace(".", "");
            motoRegistroAux = motoRegistroAux + "." + a[1];
            tMontos = tMontos + Double.valueOf(motoRegistroAux);

        }

        respuesta.setList(listFormDomiciliacion);
        respuesta.setNumRegistros(tRegis);
        respuesta.setTotalMontos(tMontos);
        DecimalFormat formateador = new DecimalFormat("###,###.##");
        respuesta.setTotalMontosString(formateador.format(tMontos));
        return respuesta;
    }

    @RequestMapping(value = "/editAfiliacionTemp", method = RequestMethod.POST)
    @ResponseBody
    public List<FormAfiliacion> editAfiliacionTemp(@RequestBody FormAfiliacion afiliado) {
        int flag = 0;
        if(afiliado.getTipoDoc().equalsIgnoreCase("J") || afiliado.getTipoDoc().equalsIgnoreCase("G")){
            afiliado.setTipoPagador("J");
        }else{
            afiliado.setTipoPagador("N");
        }
        for (FormAfiliacion formAfiliacion : listFormAfiliacion) {
            if (formAfiliacion.getId() == afiliado.getId()) {
                formAfiliacion.setCodBcoDestino(afiliado.getCodBcoDestino());
                formAfiliacion.setCtaBcoDestino(afiliado.getCtaBcoDestino());
                formAfiliacion.setNameBcoDestino(afiliado.getNameBcoDestino());
                formAfiliacion.setNameTipoOperacion(afiliado.getNameTipoOperacion());
                formAfiliacion.setTipoOperacion(afiliado.getTipoOperacion());
                formAfiliacion.setNombrePagador(afiliado.getNombrePagador());
                formAfiliacion.setTipoDoc(afiliado.getTipoDoc());
                formAfiliacion.setTipoPagador(afiliado.getTipoPagador());

                flag = 1;
            }
        }

        return listFormAfiliacion;
    }

    @RequestMapping(value = "/delAfilTemp", method = RequestMethod.GET)
    @ResponseBody
    public String getSingleAgents(@RequestParam("id") int id) {
        int flag = 0;
        FormAfiliacion deleteAfiliacion = new FormAfiliacion();
        for (FormAfiliacion formAfiliacion : listFormAfiliacion) {
            if (formAfiliacion.getId() == id) {
                deleteAfiliacion = formAfiliacion;
                flag = 1;
            }
        }
        listFormAfiliacion.remove(deleteAfiliacion);
        String resp = "{status:" + flag + "}";
        return resp;
    }

    @RequestMapping(value = "/getfecha", method = RequestMethod.GET)
    @ResponseBody
    public String getfecha() {

        return getFechaMod2(new Date());
    }

    @RequestMapping(value = "/delDomicTemp", method = RequestMethod.GET)
    @ResponseBody
    public String delDomicTemp(@RequestParam("id") int id) {
        int flag = 0;
        FormDomiciliacion deleteDomiciliacion = new FormDomiciliacion();
        for (FormDomiciliacion formDomiciliacion : listFormDomiciliacion) {
            if (formDomiciliacion.getId() == id) {
                deleteDomiciliacion = formDomiciliacion;
                flag = 1;
            }
        }
        listFormDomiciliacion.remove(deleteDomiciliacion);
        String resp = "{status:" + flag + "}";
        return resp;
    }

    @RequestMapping(value = "/findAfilTempById", method = RequestMethod.GET)
    @ResponseBody
    public FormAfiliacion findAfilTempById(@RequestParam("id") int id) {
        int flag = 0;
        FormAfiliacion deleteAfiliacion = new FormAfiliacion();
        for (FormAfiliacion formAfiliacion : listFormAfiliacion) {
            if (formAfiliacion.getId() == id) {
                int afilicod = Integer.valueOf(formAfiliacion.getCodBcoDestino().substring(1, 4));
                String banco = BancosEnum.getById(afilicod).getDescripcion();
                formAfiliacion.setCodBcoDestino(formAfiliacion.getCodBcoDestino().substring(0, 4) + "-" + banco);
                deleteAfiliacion = formAfiliacion;
                flag = 1;
            }
        }
        return deleteAfiliacion;
    }

    @RequestMapping(value = "/findDomicTempById", method = RequestMethod.GET)
    @ResponseBody
    public FormDomiciliacion findDomicTempById(@RequestParam("id") int id) {
        int flag = 0;
        FormDomiciliacion selectormDomiciliacion = new FormDomiciliacion();
        for (FormDomiciliacion formDomiciliacion : listFormDomiciliacion) {
            if (formDomiciliacion.getId() == id) {
                selectormDomiciliacion = formDomiciliacion;
                flag = 1;
            }
        }
        return selectormDomiciliacion;
    }

    @RequestMapping(value = "/buscarEmpresaOrdenanteByRif", method = RequestMethod.GET)
    @ResponseBody
    public RespuestaDTO buscarEmpresaOrdenanteByRif(@RequestParam("rif") String rif) {
        MgParametrosOrdenantes mgParametrosOrdenantes = ibAfiliacionesServices.BuscarEmpresaOrdenanteByRif(rif);
        Integer codOrd = Integer.valueOf(this.codigoOrdenante);
        RespuestaDTO respuesta = new RespuestaDTO();

        if (codOrd != mgParametrosOrdenantes.getCodigoOrdenante()) {
            respuesta.setCodigo("000");
            respuesta.setDescripcion("");

        } else {
            respuesta.setCodigo("001");
            respuesta.setDescripcion("El ordenante y el pagador no pueden ser la misma persona. ");
        }
        return respuesta;
    }

    @RequestMapping(value = "/home2", method = RequestMethod.GET)
    public ModelAndView redirectHome(@RequestParam("codOr") String codOr) {
        ModelAndView mv = new ModelAndView();
        this.codigoOrdenante = codOr;
        mv.setViewName("main/home");
        return mv;

    }

    @RequestMapping(value = "/findAfiliaByNumDoc", method = RequestMethod.GET)
    @ResponseBody
    public FormAfiliacion findAfiliaByNumDoc(@RequestParam("numDoc") String numDoc) {
        int flag = 0;
        FormAfiliacion Afiliado = new FormAfiliacion();
        List<MgAfiliacionesPresentadas> afiliaciones = new ArrayList<MgAfiliacionesPresentadas>();
        afiliaciones = ibAfiliacionesServices.BuscarAfiliadoPorIdentificacion(numDoc, this.codigoOrdenante);

        FormAfiliacion afliacion = new FormAfiliacion();
        for (MgAfiliacionesPresentadas afiliacione : afiliaciones) {

            afliacion.setCtaBcoDestino(afiliacione.getCuentaPagador());
            afliacion.setNombrePagador(afiliacione.getNombrePagador());
            afliacion.setNumIdentPagador(afiliacione.getIdentificacionPagador().substring(1, afiliacione.getIdentificacionPagador().length()));
            afliacion.setRefContrato(afiliacione.getContrato());
            int afilicod = Integer.valueOf(afiliacione.getCuentaPagador().substring(1, 4));
            String banco = BancosEnum.getById(afilicod).getDescripcion();
            afliacion.setCodBcoDestino(afiliacione.getCuentaPagador().substring(0, 4) + "-" + banco);
        }

        return afliacion;
    }

    @RequestMapping(value = "/findAfiliaByNumDoc2", method = RequestMethod.GET)
    @ResponseBody
    public FormAfiliacion findAfiliaByNumDoc2(@RequestParam("numDoc") String numDoc) {
        int flag = 0;
        FormAfiliacion Afiliado = new FormAfiliacion();
        List<MgAfiliacionesPresentadas> afiliaciones = new ArrayList<MgAfiliacionesPresentadas>();
        afiliaciones = ibAfiliacionesServices.BuscarAfiliadoPorIdentificacion2(numDoc, this.codigoOrdenante);

        FormAfiliacion afliacion = new FormAfiliacion();

        for (MgAfiliacionesPresentadas afiliacione : afiliaciones) {
            System.out.println("CANTIDAD DE ENCONTRADOS " + afiliaciones.size());
            afliacion.setCtaBcoDestino(afiliacione.getCuentaPagador());
            afliacion.setNombrePagador(afiliacione.getNombrePagador());
            System.out.println("NOMBRE: " + afiliacione.getNombrePagador());
            afliacion.setNumIdentPagador(afiliacione.getIdentificacionPagador().substring(1, afiliacione.getIdentificacionPagador().length()));
            afliacion.setRefContrato(afiliacione.getContrato());
            int afilicod = Integer.valueOf(afiliacione.getCuentaPagador().substring(1, 4));
            String banco = BancosEnum.getById(afilicod).getDescripcion();
            afliacion.setCodBcoDestino(afiliacione.getCuentaPagador().substring(0, 4) + "-" + banco);
        }

        return afliacion;
    }

    @RequestMapping(value = "/getAfilTemp", method = RequestMethod.GET)
    @ResponseBody
    public List<FormAfiliacion> getAfiliacionTemp() {
        return this.listFormAfiliacion;
    }

    @RequestMapping(value = "/getDomicTemp", method = RequestMethod.GET)
    @ResponseBody
    public DomiciliacionRestTempDTO getDomiciliacionTemp() {
        DomiciliacionRestTempDTO respuesta = new DomiciliacionRestTempDTO();
        Long tRegis = 0L;
        Double tMontos = 0D;
        for (FormDomiciliacion formDomiciliacion : this.listFormDomiciliacion) {
            tRegis++;

            String motoRegistro = formDomiciliacion.getMonto();
            String motoRegistroAux = "";
            String[] a = motoRegistro.split(",");
            motoRegistroAux = a[0].replace(".", "");
            motoRegistroAux = motoRegistroAux + "." + a[1];
            tMontos = tMontos + Double.valueOf(motoRegistroAux);
        }
        DecimalFormat formateador = new DecimalFormat("###,###.##");
        respuesta.setList(listFormDomiciliacion);
        respuesta.setNumRegistros(tRegis);
        respuesta.setTotalMontos(tMontos);
        respuesta.setTotalMontosString(formateador.format(tMontos));

        return respuesta;
    }

    @RequestMapping(value = "/cancelarAfiliacion", method = RequestMethod.GET)
    @ResponseBody
    public RespuestaDTO cancelarAfiliacion() {
        RespuestaDTO respuesta = new RespuestaDTO();
        clearCargaAfiDom();
        return respuesta;
    }

    @RequestMapping(value = "/cancelarDomiciliacion", method = RequestMethod.GET)
    @ResponseBody
    public RespuestaDTO cancelarDomiciliacion() {
        RespuestaDTO respuesta = new RespuestaDTO();
        limpiarCargaAfiDom();
        return respuesta;
    }

    @RequestMapping(value = "/saveTempAfiliacion", method = RequestMethod.GET)
    @ResponseBody
    public RespuestaDTO saveTempAfiliacion() {
        Long idSumarioAfi = 0L;
        RespuestaDTO respuesta = new RespuestaDTO();
        this.listIbAfiliacionesDet = new ArrayList<>();
        try {

            for (FormAfiliacion formAfiliacion1 : this.listFormAfiliacion) {
                IbAfiliacionesDetDTO afiliacion = new IbAfiliacionesDetDTO();
                afiliacion.setCodOrdenante(this.codigoOrdenante);
                String claveOrdenante
                        = GeneradorClaveOrdenante.getPassword(
                                GeneradorClaveOrdenante.MAYUSCULAS
                                + GeneradorClaveOrdenante.NUMEROS + GeneradorClaveOrdenante.MINUSCULAS, 10);
                afiliacion.setClaveOrdenente(claveOrdenante);
                afiliacion.setCodBcoDestino(formAfiliacion1.getCodBcoDestino());
                afiliacion.setCtaBcoDestino(formAfiliacion1.getCtaBcoDestino());
                afiliacion.setCodUsuarioCarga(123);

                afiliacion.setTipoPagador(formAfiliacion1.getTipoPagador());
                afiliacion.setNumIdentPagador(formAfiliacion1.getTipoDoc() + formAfiliacion1.getNumIdentPagador());

                afiliacion.setNombrePagador(formAfiliacion1.getNombrePagador());
                afiliacion.setRefContrato(formAfiliacion1.getRefContrato());
                afiliacion.setTipoOperacion(formAfiliacion1.getTipoOperacion());

                String nombre = formAfiliacion1.getNombrePagador();

                int iterator;
                String espacio = "";
                if ((nombre.length() > 5) && (nombre.length() < LONGITUD_DETALLE_NOMBRE_PAGADOR)) {
                    iterator = 0;
                    StringBuffer errorInLine = new StringBuffer();
                    iterator = LONGITUD_DETALLE_NOMBRE_PAGADOR - nombre.length();

                    for (int m = 0; m < iterator; m++) {
                        errorInLine.append(" ");
                    }

                    espacio = errorInLine.toString();
                } else if (nombre.length() > LONGITUD_DETALLE_NOMBRE_PAGADOR) {

                    nombre = nombre.substring(0, 29);
                }

                String linea = this.codigoOrdenante.trim() + claveOrdenante + agregarEspacio(claveOrdenante, LONGITUD_DETALLE_CLAVE_ORDENANTE) + formAfiliacion1.getCodBcoDestino().trim() + formAfiliacion1.getTipoOperacion() + formAfiliacion1.getTipoPagador() + formAfiliacion1.getTipoDoc() + formAfiliacion1.getNumIdentPagador() + agregarEspacio(formAfiliacion1.getTipoDoc() + formAfiliacion1.getNumIdentPagador(), LONGITUD_NUMERO_PAGADOR) + formAfiliacion1.getCtaBcoDestino() + nombre.trim() + espacio + formAfiliacion1.getRefContrato().trim() + agregarEspacio(formAfiliacion1.getRefContrato().trim(), LONGITUD_DETALLE_REFERENCIA_CONTRATO);

                afiliacion.setNombrePagador(nombre);
                afiliacion.setLinea(linea);
                this.listIbAfiliacionesDet.add(afiliacion);
            }

            if (this.listIbAfiliacionesDet.size() > 0) {
                IbSumarioAfiliaciones sumarioAfiliaciones = new IbSumarioAfiliaciones();
                sumarioAfiliaciones.setCodigoOrdenante(Long.valueOf(this.codigoOrdenante));
                sumarioAfiliaciones.setEstatusCargar(0L);
                sumarioAfiliaciones.setFechaHoraCarga(new Date());
                SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
                String fechaHora = ((new Date()).getTime() + "");

                String nombreDinamicoArchivo = "AF_" + this.codigoOrdenante + "_" + formatter.format(new Date()) + "_M_" + fechaHora.subSequence((fechaHora.length() - 4), fechaHora.length());
                sumarioAfiliaciones.setNombreArchivo(nombreDinamicoArchivo);
                sumarioAfiliaciones.setNroRegistrosProcesar(new BigInteger("" + this.listIbAfiliacionesDet.size()));
                sumarioAfiliaciones.setNroRegistrosRechazados(new BigInteger("0"));
                sumarioAfiliaciones.setNroRegistrosValidados(new BigInteger("" + this.listIbAfiliacionesDet.size()));

                idSumarioAfi = ibAfiliacionesServices.procesarSumarioAfiliaciones(sumarioAfiliaciones);
                if (idSumarioAfi == 0L) {
                    idSumarioAfi = ibAfiliacionesServices.procesarSumarioAfiliaciones(sumarioAfiliaciones);
                    if (idSumarioAfi == 0L) {
                        idSumarioAfi = ibAfiliacionesServices.procesarSumarioAfiliaciones(sumarioAfiliaciones);
                    }
                }
                if (idSumarioAfi != 0L) {

                    for (IbAfiliacionesDetDTO ibAfiliacionesDetDTO : listIbAfiliacionesDet) {
                        ibAfiliacionesDetDTO.setCodLote(idSumarioAfi);
                        ibAfiliacionesDetDTO.setStatus(Boolean.TRUE);
                        ibAfiliacionesDetDTO.setClaveOrdenente(this.codigoOrdenante);
                    }

                    ExecutorService executor = Executors.newSingleThreadExecutor();
                    executor.submit(() -> {
                        IbhiloAfiliacionDomiciliacion hiloAfiliacion = new IbhiloAfiliacionDomiciliacion(this.listIbAfiliacionesDet, null, "AF");
                        hiloAfiliacion.regis();
                        executor.shutdown();
                    });
                    clearCargaAfiDom();
                } else {
                    respuesta.setCodigo("001");
                    respuesta.setDescripcion("Error al procesar la afiliacion intentelo nuevamente.");
                }
            } else {
                respuesta.setCodigo("001");
                respuesta.setDescripcion("Error, no hay afiliaciones para procesar.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            respuesta.setCodigo("001");
            respuesta.setDescripcion("Error en servicio de afiliación individual en linea ");
        }

        return respuesta;
    }

    /**
     * ********************PROCESO MASIVO DE AFILIACION
     * **********************************
     */
    @RequestMapping(value = "/uploadAfiliacion", method = RequestMethod.POST)
    public ModelAndView uploadAfiliacionMasiva(@RequestParam("fileAfiliacion") MultipartFile fileAfiliacion, RedirectAttributes redirectAttributes) {
        try {
            this.listIbAfiliacionesDet = new ArrayList<>();
            this.listIbAfiliacionesDetError = new ArrayList<>();
            System.out.println("paso 1 --> uploadAfiliacionMasiva");
            RespuestaDTO resp = procesoArchivo(fileAfiliacion, "AF");
            if (resp.getCodigo().equals("000")) {
                System.out.println("paso 4 --> uploadAfiliacionMasiva");
                ModelAndView model = new ModelAndView("afiliacion/datosAfiliacionCagaMasiva");
                return model;
            } else {
                ModelAndView model = new ModelAndView("main/home");
                return model;
            }
        } catch (Exception e) {
            System.out.println("paso 1 exc --> uploadAfiliacionMasiva");
            ModelAndView model = new ModelAndView("main/home");
            return model;
        }
    }

    @RequestMapping(value = "/getSumariAfilMasiva", method = RequestMethod.GET)
    @ResponseBody
    public SumarioCargaMasivaDTO getSumariAfilMasiva() {

        return this.sumAfiliaMasive;
    }

    @RequestMapping(value = "/getSumarioDomicMasiva", method = RequestMethod.GET)
    @ResponseBody
    public SumarioCargaMasivaDTO getSumarioDomicMasiva() {
        DecimalFormat formateador = new DecimalFormat("###,###.##");
        String as = this.sumAfiliaMasive.getMontoTotalAprovado().toString();
        String monto[] = this.sumAfiliaMasive.getMontoTotalAprovado().toString().split("\\.");
        as = as.replaceAll("[,.]", "");
        String m = monto[0] + "." + monto[1];
        Double mon = Double.valueOf(m);
        this.sumAfiliaMasive.setMontoTotal(formateador.format(mon));
        return this.sumAfiliaMasive;
    }

    @RequestMapping(value = "/procesarAfiliaciones", method = RequestMethod.GET)
    @ResponseBody

    public Boolean procesarAfiliaciones() {
        Boolean flag = Boolean.TRUE;
        Long idSumarioAfi = 0L;
        try {

            IbSumarioAfiliaciones sumarioAfiliaciones = new IbSumarioAfiliaciones();
            sumarioAfiliaciones.setCodigoOrdenante(Long.valueOf(this.codigoOrdenante));
            sumarioAfiliaciones.setEstatusCargar(0L);
            sumarioAfiliaciones.setFechaHoraCarga(new Date());
            sumarioAfiliaciones.setNombreArchivo(sumAfiliaMasive.getNombreDeArchivo());
            sumarioAfiliaciones.setNroRegistrosProcesar(new BigInteger("" + sumAfiliaMasive.getNumRegProcesados()));
            sumarioAfiliaciones.setNroRegistrosRechazados(new BigInteger("" + sumAfiliaMasive.getNumRegRechazados()));
            sumarioAfiliaciones.setNroRegistrosValidados(new BigInteger("" + sumAfiliaMasive.getNumRegValidados()));
            idSumarioAfi = ibAfiliacionesServices.procesarSumarioAfiliaciones(sumarioAfiliaciones);
            if (idSumarioAfi == 0L) {
                idSumarioAfi = ibAfiliacionesServices.procesarSumarioAfiliaciones(sumarioAfiliaciones);
            }
            if (idSumarioAfi != 0L) {
                for (IbAfiliacionesDetDTO ibAfiliacionesDetDTO : listIbAfiliacionesDet) {
                    ibAfiliacionesDetDTO.setCodLote(idSumarioAfi);
                    ibAfiliacionesDetDTO.setClaveOrdenente(this.codigoOrdenante);
                }

                ExecutorService executor = Executors.newSingleThreadExecutor();
                executor.submit(() -> {
                    IbhiloAfiliacionDomiciliacion hiloAfiliacion = new IbhiloAfiliacionDomiciliacion(this.listIbAfiliacionesDet, null, "AF");
                    hiloAfiliacion.regis();
                    executor.shutdown();
                });
                FlagArchivo = Boolean.TRUE;
            } else {
                FlagArchivo = Boolean.FALSE;
            }

        } catch (Exception e) {
            flag = Boolean.FALSE;
        }

        return flag;
    }

    @RequestMapping(value = "/procesarDomiciliaciones", method = RequestMethod.GET)
    @ResponseBody
    public Boolean procesarDomiciliaciones() {
        Boolean flag = Boolean.TRUE;
        Long idSumarioDomic = 0L;
        try {

            IbSumarioPagos sumarioPagos = new IbSumarioPagos();
            sumarioPagos.setCodigoOrdenante(Long.valueOf(this.codigoOrdenante));
            sumarioPagos.setEstatusCargar(0L);
            sumarioPagos.setFechaHoraCarga(new Date());
            sumarioPagos.setNombreArchivo(sumAfiliaMasive.getNombreDeArchivo());
            sumarioPagos.setNroRegistrosProcesar(new BigInteger("" + sumAfiliaMasive.getNumRegProcesados()));
            sumarioPagos.setNroRegistrosRechazados(new BigInteger("" + sumAfiliaMasive.getNumRegRechazados()));
            sumarioPagos.setNroRegistrosValidados(new BigInteger("" + sumAfiliaMasive.getNumRegValidados()));
            sumarioPagos.setMontoTotalAprovado(new BigDecimal("" + sumAfiliaMasive.getMontoTotalAprovado()));

            if (sumarioPagos.getNroRegistrosValidados() != BigInteger.ZERO) {
                idSumarioDomic = ibDomiciliacionesServices.procesarSumario(sumarioPagos);
                if (idSumarioDomic == 0L) {
                    idSumarioDomic = ibDomiciliacionesServices.procesarSumario(sumarioPagos);
                }
            }

            if (idSumarioDomic != 0L) {

                for (IbDomiciliacionesDetDTO ibDomiciliacionesDetDTO : listIbDomiciliacionesDet) {
                    ibDomiciliacionesDetDTO.setCodLote(idSumarioDomic);
                }
                ExecutorService executor = Executors.newSingleThreadExecutor();
                executor.submit(() -> {
                    IbhiloAfiliacionDomiciliacion hiloDomiciliacion = new IbhiloAfiliacionDomiciliacion(null, this.listIbDomiciliacionesDet, "DO");
                    hiloDomiciliacion.regis();
                    executor.shutdown();
                });

                FlagArchivo = Boolean.TRUE;
            } else {
                FlagArchivo = Boolean.FALSE;
            }

        } catch (Exception e) {
            flag = Boolean.FALSE;
        }

        return flag;
    }

    @RequestMapping(value = "/getValidoArchivoAfiliacion", method = RequestMethod.GET)
    @ResponseBody
    public RespuestaDTO getValidoArchivoAfiliacion() {
        RespuestaDTO respArchAfilia = new RespuestaDTO();
        if (!this.FlagArchivo) {
            respArchAfilia.setCodigo("001");
            respArchAfilia.setDescripcion(this.ErrorMensajeArch);
        }
        FlagArchivo = Boolean.TRUE;
        return respArchAfilia;
    }

    public void uploadExelAfiliacion2(String inputFilePath) {
        InputStream inp = null;
        try {
            inp = new FileInputStream(inputFilePath);

            XSSFWorkbook libro = new XSSFWorkbook(inp); //Declare XSSF WorkBook
            XSSFSheet hoja = libro.getSheetAt(0); //sheet can be used as common for XSSF and HSSF
            int rows = hoja.getLastRowNum();
            int tregisVal = 0, tregisRecha = 0;
            int tregisTotal = 0;
            for (int i = 1; i <= rows; ++i) {
                Validation validado = new Validation();
                IbAfiliacionesDetDTO newAfi = new IbAfiliacionesDetDTO();
                tregisTotal++;

                XSSFRow q = hoja.getRow(i);
                String link0 = ("" + q.getCell(0)).trim();
                String link1 = ("" + q.getCell(1)).trim();
                String link2 = ("" + q.getCell(2)).trim();
                String link3 = ("" + q.getCell(3)).trim();
                String link4 = ("" + q.getCell(4)).trim();
                String link5 = ("" + q.getCell(5)).trim();
                String link6 = ("" + q.getCell(6)).trim();
                String link7 = ("" + q.getCell(7)).trim();
                String link8 = ("" + q.getCell(8)).trim();

                newAfi.setCodOrdenante(("" + q.getCell(0)).trim());
                newAfi.setClaveOrdenente(("" + q.getCell(1)).trim());
                newAfi.setCodBcoDestino(("" + q.getCell(2)).trim());
                newAfi.setTipoOperacion(("" + q.getCell(3)).trim());
                newAfi.setTipoPagador(("" + q.getCell(4)).trim());
                newAfi.setNumIdentPagador(("" + q.getCell(5)).trim());
                newAfi.setCtaBcoDestino(("" + q.getCell(6)).trim());
                newAfi.setNombrePagador(("" + q.getCell(7)).trim());
                newAfi.setRefContrato(("" + q.getCell(8)).trim());
                newAfi.setFechaCargar(new Date());
                newAfi.setIdAfi(1);
                newAfi.setCodUsuarioCarga(123);
                newAfi.setLinea("");
                int iterator;
                String espacio = "";
                if ((link7.length() > 5) && (link7.length() < LONGITUD_DETALLE_NOMBRE_PAGADOR)) {
                    iterator = 0;
                    StringBuffer errorInLine = new StringBuffer();
                    iterator = LONGITUD_DETALLE_NOMBRE_PAGADOR - link7.length();

                    for (int m = 0; m < iterator; m++) {
                        errorInLine.append(" ");
                    }

                    espacio = errorInLine.toString();
                } else if (link7.length() > LONGITUD_DETALLE_NOMBRE_PAGADOR) {

                    link7 = link7.substring(0, 29);
                }
                String as = link0 + link1 + agregarEspacio(link1, LONGITUD_DETALLE_CLAVE_ORDENANTE) + link2 + link3 + link4 + link5 + agregarEspacio(link5, LONGITUD_NUMERO_PAGADOR) + link6 + link7.trim() + espacio + link8.trim() + agregarEspacio(link8.trim(), LONGITUD_DETALLE_REFERENCIA_CONTRATO);
                newAfi.setLinea(as);

                validado = validatorCargaAfiliaciones.getValidaAfiliacion(newAfi);

                if (!this.codigoOrdenante.equals(link0.trim())) {
                    validado.setCodError("212");
                    validado.setStatusRegistro(false);
                    validado.setErrores("Codigo ordenante del registro no pertenece a la empresa que esta procesando el archivo.");
                }
                newAfi.setStatus(validado.getStatusRegistro());
                newAfi.setErrorInLine(validado.getErrores());
                newAfi.setNroRechazo(validado.getCodError());

                if (validado.getStatusRegistro()) {
                    tregisVal++;
                } else {
                    tregisRecha++;
                }
                listIbAfiliacionesDet.add(newAfi);
            }
            listIbAfiliacionesDet.addAll(listIbAfiliacionesDetError);
            this.sumAfiliaMasive = new SumarioCargaMasivaDTO();
            sumAfiliaMasive.setFechaCargaArchivo(new Date());
            sumAfiliaMasive.setFechaString(getFechaMod(new Date()));
            sumAfiliaMasive.setNombreDeArchivo(inputFilePath.split("-")[1]);
            sumAfiliaMasive.setNumRegProcesados(tregisTotal);
            sumAfiliaMasive.setNumRegValidados(tregisVal);
            sumAfiliaMasive.setNumRegRechazados(tregisRecha);

            inp.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UploadController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UploadController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void uploadExelAfiliacion(String inputFilePath) {
        System.out.println("LLega a uploadExelAfiliacion");
        listIbAfiliacionesDet.clear();
        try {
            HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(inputFilePath));
            HSSFSheet sheet = wb.getSheetAt(0);
            int tregisVal = 0, tregisRecha = 0;
            int tregisTotal = 0;
            int rows = sheet.getLastRowNum();
            for (int i = 1; i <= rows; ++i) {
                Validation validado = new Validation();
                IbAfiliacionesDetDTO newAfi = new IbAfiliacionesDetDTO();
                tregisTotal++;
                HSSFRow row = sheet.getRow(i);
                HSSFCell linkCel0 = row.getCell(0);
                HSSFCell linkCel1 = row.getCell(1);
                HSSFCell linkCel2 = row.getCell(2);
                HSSFCell linkCel3 = row.getCell(3);
                HSSFCell linkCel4 = row.getCell(4);
                HSSFCell linkCel5 = row.getCell(5);
                HSSFCell linkCel6 = row.getCell(6);
                HSSFCell linkCel7 = row.getCell(7);
                HSSFCell linkCel8 = row.getCell(8);
                String link0 = linkCel0.getStringCellValue().trim();
                String link1 = linkCel1.getStringCellValue().trim();
                String link2 = linkCel2.getStringCellValue().trim();
                String link3 = linkCel3.getStringCellValue().trim();
                String link4 = linkCel4.getStringCellValue().trim();
                String link5 = linkCel5.getStringCellValue().trim();
                String link6 = linkCel6.getStringCellValue().trim();
                String link7 = linkCel7.getStringCellValue().trim();
                String link8 = linkCel8.getStringCellValue().trim();
                newAfi.setCodOrdenante(linkCel0.getStringCellValue().trim());
                newAfi.setClaveOrdenente(linkCel1.getStringCellValue().trim());
                newAfi.setCodBcoDestino(linkCel2.getStringCellValue().trim());
                newAfi.setTipoOperacion(linkCel3.getStringCellValue().trim());
                newAfi.setTipoPagador(linkCel4.getStringCellValue().trim());
                newAfi.setNumIdentPagador(linkCel5.getStringCellValue().trim());
                newAfi.setCtaBcoDestino(linkCel6.getStringCellValue().trim());
                newAfi.setNombrePagador(linkCel7.getStringCellValue().trim());
                newAfi.setRefContrato(linkCel8.getStringCellValue().trim());

                newAfi.setFechaCargar(new Date());
                newAfi.setIdAfi(1);
                newAfi.setCodUsuarioCarga(123);
                newAfi.setLinea("");

                int iterator;
                String espacio = "";
                if ((link7.length() > 5) && (link7.length() < LONGITUD_DETALLE_NOMBRE_PAGADOR)) {
                    iterator = 0;
                    StringBuffer errorInLine = new StringBuffer();
                    iterator = LONGITUD_DETALLE_NOMBRE_PAGADOR - link7.length();

                    for (int m = 0; m < iterator; m++) {
                        errorInLine.append(" ");
                    }

                    espacio = errorInLine.toString();
                } else if (link7.length() > LONGITUD_DETALLE_NOMBRE_PAGADOR) {

                    link7 = link7.substring(0, 29);
                }

                String as = link0 + link1 + agregarEspacio(link1, LONGITUD_DETALLE_CLAVE_ORDENANTE) + link2 + link3 + link4 + link5 + agregarEspacio(link5, LONGITUD_NUMERO_PAGADOR) + link6 + link7.trim() + espacio + link8.trim() + agregarEspacio(link8.trim(), LONGITUD_DETALLE_REFERENCIA_CONTRATO);

                newAfi.setLinea(as);

                validado = validatorCargaAfiliaciones.getValidaAfiliacion(newAfi);
                if (!this.codigoOrdenante.equals(link0.trim())) {
                    validado.setCodError("212");
                    validado.setStatusRegistro(false);
                    validado.setErrores("Codigo ordenante del registro nopertenece a la empresa que esta procesando el archivo.");
                }
                newAfi.setStatus(validado.getStatusRegistro());
                newAfi.setErrorInLine(validado.getErrores());
                newAfi.setNroRechazo(validado.getCodError());

                if (validado.getStatusRegistro()) {
                    tregisVal++;
                } else {
                    tregisRecha++;
                }
                listIbAfiliacionesDet.add(newAfi);

            }

            this.sumAfiliaMasive = new SumarioCargaMasivaDTO();
            sumAfiliaMasive.setFechaCargaArchivo(new Date());
            sumAfiliaMasive.setFechaString(getFechaMod(new Date()));
            sumAfiliaMasive.setNombreDeArchivo(inputFilePath.split("-")[1]);
            sumAfiliaMasive.setNumRegProcesados(tregisTotal);
            sumAfiliaMasive.setNumRegValidados(tregisVal);
            sumAfiliaMasive.setNumRegRechazados(tregisRecha);

        } catch (Exception ex) {
            Logger.getLogger(UploadController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error Por excepcion en uploadExelAfiliacion");
        }
    }

    public Boolean validateNameFile(String fileName, String operacion) {
        this.sumAfiliaMasive = new SumarioCargaMasivaDTO();
        this.ErrorMensajeArch = "El formato del archivo o estructura de campos no es válido, favor verificar ";
        Boolean flag = Boolean.FALSE;
        // se elimina espacios en blanco del nombre 
        fileName = fileName.trim();
        String fileNameAux2 = fileName.trim();
        // se sustituye el punto por " " para separar la extencion del archivo del nombre 
        String fileNameAux = fileName.replace(".", " ");
        //sacar el nombre del archivo
        fileName = fileNameAux.split(" ")[0];
        //Separo en partes el nombre del archivo 
        String[] arrayName = fileName.split("_");
        // se optiene la fecha del dia;
        Date fecha = new Date(Calendar.getInstance().getTimeInMillis());

        // En esta linea de código estamos indicando el nuevo formato que queremos para nuestra fecha.
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
//        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyy");
        // Aqui usamos la instancia formatter para darle el formato a la fecha. Es importante ver que el resultado es un string.
        String fechaTexto = formatter.format(fecha);
        operationName = arrayName[0];
        if (arrayName[0].equals(operacion)) {

            //Buscar el codigo ordenante del cliente  preguntar de donde se consigue 
            if (arrayName[1].equals(this.codigoOrdenante)) {
                if (arrayName[2].equals(fechaTexto)) {
                    if (!validarSecuencia(fileNameAux2, operacion)) {
                        flag = Boolean.TRUE;
                    } else {
                        if (operacion.equals("DO")) {
                            this.ErrorMensajeArch = "Ya existe cargado un archivo con el mismo nombre , revise e intente de nuevo";
                        } else {
                            // this.ErrorMensajeArch = ErrorMensajeArch + " la carga del archivo no puedes ser procesado inténtelo mas tarde o el siguiente día hábil Bancario ";
                            this.ErrorMensajeArch = "Ya existe cargado un archivo con el mismo nombre , revise e intente de nuevo";
                        }
                    }
                } else {
                    this.ErrorMensajeArch = ErrorMensajeArch + " la fecha no corresponde con la fecha de carga del archivo o en formatos favor verificar ";
                }
            } else {

                this.ErrorMensajeArch = ErrorMensajeArch + " el código  ordenante no corresponde a la empresa ordenante favor verificar";
            }
        } else {
            this.ErrorMensajeArch = ErrorMensajeArch + " el tipo de operación  no corresponde a la opción seleccionada favor verificar";
        }
        this.FlagArchivo = flag;
        return flag;
    }

    public Boolean validarSecuencia(String archivo, String operacion) {
        return (ibDomiciliacionesServices.BuscarSumario(archivo, operacion).size() > 0);
    }

    public RespuestaDTO procesoArchivo(MultipartFile file, String operacion) {
        String nameFile = file.getOriginalFilename();
        RespuestaDTO respuesta = new RespuestaDTO();
        listIbAfiliacionesDet = new ArrayList<>();
        listIbAfiliacionesDetError = new ArrayList<>();
        listIbDomiciliacionesDet = new ArrayList<>();
        listIbDomiciliacionesDetError = new ArrayList<>();
        boolean swFile = true;
        if (validateNameFile(nameFile, operacion)) {
            try {
                //Se extraen todos los datos binarios del documentos 
                byte[] bytes = file.getBytes();

                String[] archivo = file.getContentType().split("/");
                String[] archivo2 = file.getOriginalFilename().split("\\.");

                for (int x = 0; x < archivo.length; x++) {
                    if (/*archivo[x].compareTo("vnd.ms-excel") == 0 || */archivo2[1].equals("xls") && swFile) {
                        swFile = false;
                        // se verifica si existe la carpeta tempAfiliaciones sino se crea 
                        String rutaCarpeta = "/tempAfiliaciones/afiliacionFile/";
                        File fRuta = new File(rutaCarpeta);
                        if (!fRuta.isDirectory()) {
                            if (fRuta.mkdirs()) {
                                System.out.println("se creo el directorio ");
                            } else {
                                System.out.println("no se creo el directorio 1");
                            }
                        }
                        // se  crea el la path para el archivo temporal 
                        String dirDestino = rutaCarpeta + new Date().getTime() + "-" + file.getOriginalFilename();
                        //Path path = Paths.get(directorioRaiz+"\\" + file.getOriginalFilename());
                        Path path = Paths.get(dirDestino);
                        // Crea e;l archivo ebn el directorio
                        Files.write(path, bytes);
                        if (this.operationName.equals("AF")) {
                            uploadExelAfiliacion(dirDestino);
                        } else if (this.operationName.equals("DO")) {
                            uploadExelDomiciliacion(dirDestino);
                        }
                        if (new File(dirDestino).delete()) {
                            System.out.println("El fichero ha sido borrado satisfactoriamente");
                        } else {
                            System.out.println("El fichero no puede ser borrado");
                        }

                    } else if (/*archivo[x].compareTo("vnd.openxmlformats-officedocument.spreadsheetml.sheet") == 0 ||*/ archivo2[1].equals("xlsx") && swFile) {
                        swFile = false;
                        // se verifica si existe la carpeta tempAfiliaciones sino se crea 
                        String rutaCarpeta = "/tempAfiliaciones/afiliacionFile/";
                        File fRuta = new File(rutaCarpeta);
                        if (!fRuta.isDirectory()) {
                            if (fRuta.mkdirs()) {
                                System.out.println("se creo el directorio ");
                            } else {
                                System.out.println("no se creo el directorio 1");
                            }
                        }
                        // se  crea el la path para el archivo temporal 
                        String dirDestino = rutaCarpeta + new Date().getTime() + "-" + file.getOriginalFilename();
                        //Path path = Paths.get(directorioRaiz+"\\" + file.getOriginalFilename());
                        Path path = Paths.get(dirDestino);
                        // Crea e;l archivo ebn el directorio
                        Files.write(path, bytes);
                        if (this.operationName.equals("AF")) {
                            uploadExelAfiliacion2(dirDestino);
                        } else if (this.operationName.equals("DO")) {
                            uploadExelDomiciliacion2(dirDestino);
                        }
                        if (new File(dirDestino).delete()) {
                            System.out.println("El fichero ha sido borrado satisfactoriamente");
                        } else {
                            System.out.println("El fichero no puede ser borrado");
                        }

                    } else if (archivo[x].compareTo("text") == 0) {
                        BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bytes)));
                        String linea;
                        int tregisVal = 0, tregisRecha = 0;
                        int tregisTotal = 0;
                        if (this.operationName.equals("AF")) {
                            int o = 0;
                            while ((linea = br.readLine()) != null) {
                                if (!linea.trim().equals("")) {
                                    Validation validado = new Validation();
                                    int pos = 0;
                                    if (!linea.equals("")) {
                                        removerTildes(linea);
                                        tregisTotal++;
                                        IbAfiliacionesDetDTO newAfi = new IbAfiliacionesDetDTO();
                                        newAfi.setCodOrdenante(linea.substring(pos, pos += LONGITUD_DETALLE_CODIGO_ORDENANTE));
                                        newAfi.setClaveOrdenente(linea.substring(pos, pos += LONGITUD_DETALLE_CLAVE_ORDENANTE).trim());
                                        newAfi.setCodBcoDestino(linea.substring(pos, pos += LONGITUD_DETALLE_BANCO_DESTINO));
                                        newAfi.setTipoOperacion(linea.substring(pos, pos += LONGITUD_DETALLE_TIPO_OPERACION));
                                        newAfi.setTipoPagador(linea.substring(pos, pos += LONGITUD_DETALLE_TIPO_PAGADOR));
                                        newAfi.setNumIdentPagador(linea.substring(pos, pos += LONGITUD_DETALLE_IDENTIFICADOR_PAGADOR).trim());
                                        newAfi.setCtaBcoDestino(linea.substring(pos, pos += LONGITUD_DETALLE_CUENTA_PAGADOR));
                                        newAfi.setNombrePagador(linea.substring(pos, pos += LONGITUD_DETALLE_NOMBRE_PAGADOR));
                                        //newAfi.setRefContrato(linea.substring(pos, pos += LONGITUD_DETALLE_REFERENCIA_CONTRATO));
                                        newAfi.setRefContrato(linea.substring(pos, linea.length()));
                                        newAfi.setLinea(linea);
                                        newAfi.setFechaCargar(new Date());
                                        newAfi.setIdAfi(1);
                                        newAfi.setCodUsuarioCarga(123);
                                        validado = validatorCargaAfiliaciones.getValidaAfiliacion(newAfi);

                                        if (!this.codigoOrdenante.equals(newAfi.getCodOrdenante().trim())) {
                                            validado.setCodError("212");
                                            validado.setStatusRegistro(false);
                                            validado.setErrores("Codigo ordenante del registro no pertenece a la empresa que esta procesando el archivo.");
                                        }

                                        newAfi.setStatus(validado.getStatusRegistro());
                                        newAfi.setErrorInLine(validado.getErrores());
                                        newAfi.setNroRechazo(validado.getCodError());

                                        if (validado.getStatusRegistro()) {
                                            tregisVal++;
                                        } else {
                                            tregisRecha++;
                                        }
                                        listIbAfiliacionesDet.add(newAfi);

                                    }
                                    System.out.println("" + o);
                                    o++;
                                }

                            }
                            this.sumAfiliaMasive = new SumarioCargaMasivaDTO();
                            sumAfiliaMasive.setFechaCargaArchivo(new Date());
                            sumAfiliaMasive.setFechaString(getFechaMod(new Date()));
                            sumAfiliaMasive.setNombreDeArchivo(file.getOriginalFilename());
                            sumAfiliaMasive.setNumRegProcesados(tregisTotal);
                            sumAfiliaMasive.setNumRegValidados(tregisVal);
                            sumAfiliaMasive.setNumRegRechazados(tregisRecha);

                        } else if (this.operationName.equals("DO")) {

                            List<DetalleAfiliacionesDTO> mgDetalleAfiliacionesDTO = new ArrayList<>();
                            int i = 0;
                            boolean sw = false;
                            int regisValDomic = 0, regisRechaDomic = 0;
                            int regisTotalDomic = 0;
                            Double montoTotalDomic = 0D;
                            Double montoTotalDomicVal = 0D;
                            Double montoTotalDomicRech = 0D;
                            while ((linea = br.readLine()) != null) {
                                Validation validado = new Validation();
                                int poss = 0;

                                if (!linea.trim().equals("")) {
                                    removerTildes(linea);
                                    i++;
                                    System.out.println(linea);
                                    IbDomiciliacionesDetDTO newDom = new IbDomiciliacionesDetDTO();
                                    regisTotalDomic++;
                                    newDom.setCodOrdenante(linea.substring(poss, poss += LONGITUD_DETALLE_DOM_CODIGO_ORDENANTE));
                                    newDom.setClaveOrdenente(linea.substring(poss, poss += LONGITUD_DETALLE_DOM_CLAVE_ORDENANTE));
                                    newDom.setTipoOperacion(linea.substring(poss, poss += LONGITUD_DETALLE_DOM_TIPO_OPERACION));
                                    newDom.setSubTipoDominio(linea.substring(poss, poss += LONGITUD_DETALLE_DOM_TIPO_SUB_DOMINIO));
                                    newDom.setCtaPagador(linea.substring(poss, poss += LONGITUD_DETALLE_DOM_CUENTA_PAGADOR));
                                    newDom.setMonto(linea.substring(poss, poss += LONGITUD_DETALLE_DOM_MONTO));
                                    newDom.setTipoPagador(linea.substring(poss, poss += LONGITUD_DETALLE_DOM_TIPO_PAGADOR));
                                    newDom.setIdentificadorPagador(linea.substring(poss, poss += LONGITUD_DETALLE_DOM_IDENTIFICADOR_PAGADOR));
                                    newDom.setNombrePagador(linea.substring(poss, poss += LONGITUD_DETALLE_DOM_NOMBRE_PAGADOR));
                                    newDom.setRefContrato(linea.substring(poss, poss += LONGITUD_DETALLE_DOM_REFERENCIA_CONTRATO));
                                    newDom.setFacturaNumero(linea.substring(poss, poss += LONGITUD_DETALLE_DOM_FACTURA_NUMERO));
                                    newDom.setFechaEmisionFactura(linea.substring(poss, poss += LONGITUD_DETALLE_DOM_FECHA_EMICION_FACTURA));
                                    newDom.setFechaVencimientoFactura(linea.substring(poss, poss += LONGITUD_DETALLE_DOM_FECHA_VENCIMIENTO_FACTURA));

                                    newDom.setLinea(linea);
                                    newDom.setFechaCargar(new Date());
                                    newDom.setIdAfi(1);
                                    newDom.setCodUsuarioCarga(123);

                                    validado = validatorCargaDomiciliaciones.getValidaDomiciliacion(newDom);
                                    if (!this.codigoOrdenante.equals(newDom.getCodOrdenante().trim())) {
                                        validado.setCodError("212");
                                        validado.setStatusRegistro(false);
                                        validado.setErrores("Codigo ordenante del registro no pertenece a la empresa que esta procesando el archivo.");
                                    } else {
                                        if (i == 1) {
                                            mgDetalleAfiliacionesDTO = ibAfiliacionesServices.BuscarAfiliadoPresentadasByOrdenante(this.codigoOrdenante);
                                        }
                                        for (DetalleAfiliacionesDTO obj : mgDetalleAfiliacionesDTO) {
                                            if (obj.getSituacion().equalsIgnoreCase("P") /*obj.getContrato().trim().equals(newDom.getRefContrato())*/ && obj.getIdentificacionPagador().trim().equals(newDom.getIdentificadorPagador().trim())) {
                                                sw = true;
                                                break;
                                            }
                                        }
                                    }
                                    if (sw == false) {
                                        validado.setCodError("212");
                                        validado.setStatusRegistro(false);
                                        validado.setErrores("Registro no se encuentra en mg_afiliaciones_presentadas.");
                                    }
                                    sw = false;
                                    //Validacon con mg_afiliaciones_presentadas
                                    /*se consulta la tabla 
                                     select mapr.codigo_ordenante, mapr.clave_ordenante, mapr.referencia_contrato, mapr.codigo_resultado 
                                    from mg_afiliaciones_presentadas mapr where mapr.codigo_ordenante=0001 and mapr.codigo_resultado = 'P'
                                    y se compara con los valores del archivo
                                     */
                                    newDom.setStatus(validado.getStatusRegistro());
                                    newDom.setErrorInLine(validado.getErrores());

                                    montoTotalDomic = montoTotalDomic + Double.valueOf(newDom.getMonto());

                                    if (validado.getStatusRegistro()) {
                                        regisValDomic++;

                                        montoTotalDomicVal = montoTotalDomicVal + Double.valueOf(newDom.getMonto());
                                    } else {
                                        regisRechaDomic++;

                                        montoTotalDomicRech = montoTotalDomicRech + Double.valueOf(newDom.getMonto());
                                    }
                                    this.listIbDomiciliacionesDet.add(newDom);
                                }
                            }

                            this.sumAfiliaMasive = new SumarioCargaMasivaDTO();
                            sumAfiliaMasive.setFechaCargaArchivo(new Date());
                            sumAfiliaMasive.setFechaString(getFechaMod(new Date()));
                            sumAfiliaMasive.setNombreDeArchivo(file.getOriginalFilename());
                            sumAfiliaMasive.setNumRegProcesados(regisTotalDomic);
                            sumAfiliaMasive.setNumRegValidados(regisValDomic);
                            sumAfiliaMasive.setNumRegRechazados(regisRechaDomic);
                            sumAfiliaMasive.setMontoTotalProcesado(montoTotalDomic);
                            sumAfiliaMasive.setMontoTotalAprovado(montoTotalDomicVal);
                            sumAfiliaMasive.setMontoTotalRechazado(montoTotalDomicRech);

                        }

                    }

                }

            } catch (IOException e) {

                e.printStackTrace();
            }

        } else {
            // error de formato de nombre de archivo 
            respuesta.setCodigo("101");
            respuesta.setDescripcion("error de formato de nombre de archivo");

        }
        return respuesta;
    }

    public void clearCargaAfiDom() {
        if (this.listFormAfiliacion != null) {
            this.listFormAfiliacion.clear();
        }
        if (this.listFormDomiciliacion != null) {
            this.listFormDomiciliacion.clear();
        }
    }

    public Boolean limpiarCargaAfiDom() {
        if (this.listIbAfiliacionesDet != null) {
            this.listIbAfiliacionesDet.clear();
        }
        if (this.listIbAfiliacionesDetError != null) {
            this.listIbAfiliacionesDetError.clear();
        }
        if (this.listIbDomiciliacionesDet != null) {
            this.listIbDomiciliacionesDet.clear();
        }
        if (this.listIbDomiciliacionesDetError != null) {
            this.listIbDomiciliacionesDetError.clear();
        }
        if (this.listFormAfiliacion != null) {
            this.listFormAfiliacion.clear();
        }
        if (this.listFormDomiciliacion != null) {
            this.listFormDomiciliacion.clear();
        }
        this.sumAfiliaMasive = new SumarioCargaMasivaDTO();
        return null;
    }

    public String getFechaMod(Date fecha) {
        SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yy hh:mm:ss");
        return sf.format(fecha);
    }

    public String getFechaMod2(Date fecha) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        return sf.format(fecha);
    }

    public String getFechaMod3(Date fecha) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd");
        return sf.format(fecha);
    }

    static String removerTildes(String cadena) {
        return cadena.replace("Á", "A")
                .replace("É", "E")
                .replace("Í", "I")
                .replace("Ó", "O")
                .replace("Ú", "U")
                .replace("Ñ", "N")
                .replace("á", "a")
                .replace("é", "e")
                .replace("í", "i")
                .replace("ó", "o")
                .replace("ñ", "n")
                .replace("ú", "u");
    }

    public String agregarEspacio(String variable1, int longitud) {
        int iterator2;
        String espacio2 = "";
        if ((variable1.trim().length() < longitud)) {
            iterator2 = 0;
            StringBuffer errorInLine = new StringBuffer();
            iterator2 = longitud - variable1.trim().length();

            for (int m = 0; m < iterator2; m++) {
                errorInLine.append(" ");
            }
            espacio2 = errorInLine.toString();
        }
        return espacio2;
    }

    public String agregarCeros(String monto, int longitud) {
        int iterator2;
        String ceros = "";
        if ((monto.trim().length() < longitud)) {
            iterator2 = 0;
            StringBuffer errorInLine = new StringBuffer();
            iterator2 = longitud - monto.trim().length();

            for (int m = 0; m < iterator2; m++) {
                errorInLine.append("0");
            }
            ceros = errorInLine.toString();
        }
        return ceros;
    }

    public String formatFecha(Date fecha) {
        SimpleDateFormat formateador = new SimpleDateFormat("ddMMyyyy");
        String fechaFormatString = formateador.format(fecha);
        return fechaFormatString;

    }

    @RequestMapping(value = "/consolidadoAfiliaciones", method = RequestMethod.GET)
    @ResponseBody
    public List<ConsolidadoAfiliacionesDTO> consolidadoAfiliaciones() {
        listConsolidadoAfiliaciones = ibAfiliacionesServices.ListarConsolidadosDeAfiliaciones(Integer.valueOf(this.codigoOrdenante));
        return listConsolidadoAfiliaciones;
    }

    @RequestMapping(value = "/detalleAfiliaciones", method = RequestMethod.GET)
    @ResponseBody
    public List<DetalleAfiliacionesDTO> detalleAfiliaciones(@RequestParam("idLote") String idLote) {

        List<IbMensajes> mensajes = ibAfiliacionesServices.CargarMensajes();
        List<DetalleAfiliacionesDTO> detalleList = ibAfiliacionesServices.BuscarAfiliadoPorlote(Long.valueOf(idLote), this.codigoOrdenante);
        for (DetalleAfiliacionesDTO detalleAfiliacionesDTO : detalleList) {
            // for (IbMensajes mensaje : mensajes) {
            /*   if (detalleAfiliacionesDTO.getCodigoResultado() != null && detalleAfiliacionesDTO.getCodigoResultado().equals("" + mensaje.getId())) {
                    detalleAfiliacionesDTO.setCodigoResultado(mensaje.getDescripcion());
              /*  } else if (detalleAfiliacionesDTO.getCodigoResultado().equals("null") && (detalleAfiliacionesDTO.getSituacion().equals("A"))) {
                    detalleAfiliacionesDTO.setCodigoResultado("APROBADO");*/
 /*   } else*/
            if (/*detalleAfiliacionesDTO.getCodigoResultado() == null && */(detalleAfiliacionesDTO.getSituacion().equals("P"))) {
                detalleAfiliacionesDTO.setCodigoResultado("APROBADA");
            } else if (/*detalleAfiliacionesDTO.getCodigoResultado() == null &&*/(detalleAfiliacionesDTO.getSituacion().equals("C"))) {
                if (detalleAfiliacionesDTO.isSwOrdenantes() == false) {// el registro està en presentadas
                    detalleAfiliacionesDTO.setCodigoResultado("ENVIADO A CÁMARA");
                } else {
                    detalleAfiliacionesDTO.setCodigoResultado("POR PROCESAR");
                }
            } else if (/*detalleAfiliacionesDTO.getCodigoResultado() == null &&*/(detalleAfiliacionesDTO.getSituacion().equals("X")) || (detalleAfiliacionesDTO.getSituacion().equals("R"))) {
                detalleAfiliacionesDTO.setCodigoResultado("RECHAZADA");
            }
        }
        //}
        return detalleList;
    }

    @RequestMapping(value = "/cosolidadoDomiciliaciones", method = RequestMethod.GET)
    @ResponseBody
    public List<ConsolidadoDomiciliacionesDTO> cosolidadoDomiciliaciones() {
        return ibDomiciliacionesServices.ListarConsolidadosDedominciliaciones(Integer.valueOf(this.codigoOrdenante));
    }

    @RequestMapping(value = "/detalleDomiciliaciones", method = RequestMethod.GET)
    @ResponseBody
    public List<DetalleDomiciliacionesDTO> detalleDomiciliaciones(@RequestParam("idLote") String idLote) {
        DecimalFormat formateador = new DecimalFormat("###,###.##");
        List<IbMensajes> mensajes = ibAfiliacionesServices.CargarMensajes();
        List<DetalleDomiciliacionesDTO> listDomicilia = ibDomiciliacionesServices.BuscarDomiciliacionesByLote(Long.valueOf(idLote), this.codigoOrdenante);
        for (DetalleDomiciliacionesDTO detalleDomiciliacionesDTO : listDomicilia) {
            String as = null;
            if(detalleDomiciliacionesDTO.getMonto().trim().contains(".")){
                as = detalleDomiciliacionesDTO.getMonto().trim();
                detalleDomiciliacionesDTO.setMonto(as);
            }else{
                as = Integer.valueOf(detalleDomiciliacionesDTO.getMonto().trim()).toString();
                detalleDomiciliacionesDTO.setMonto(formateador.format(Double.valueOf(as.substring(0, (as.length() - 2)) + "." + as.substring((as.length() - 2), as.length()))));
            }
//            for (IbMensajes mensaje : mensajes) {
//                if (detalleDomiciliacionesDTO.getCodigoResultado().equals("" + mensaje.getId())) {
//                    detalleDomiciliacionesDTO.setCodigoResultado(mensaje.getDescripcion());
//                } else 
            if (detalleDomiciliacionesDTO.getSituacion().equals("X") || detalleDomiciliacionesDTO.getSituacion().equals("R") ) {
                detalleDomiciliacionesDTO.setCodigoResultado("RECHAZADO");
            } else if ((detalleDomiciliacionesDTO.getSituacion().equals("O") && detalleDomiciliacionesDTO.getCobroExitoso().equals(null)) || detalleDomiciliacionesDTO.getSituacion().equals("C")) {
                detalleDomiciliacionesDTO.setCodigoResultado("En PROCESO");
            } else if ((detalleDomiciliacionesDTO.getSituacion().equals("O") && detalleDomiciliacionesDTO.getCobroExitoso().equals("SI")) || detalleDomiciliacionesDTO.getSituacion().equals("P") || detalleDomiciliacionesDTO.getSituacion().equals("K")) {
                detalleDomiciliacionesDTO.setCodigoResultado("PROCESADO");
            } 
//            }
        }
        return listDomicilia;
    }
}
