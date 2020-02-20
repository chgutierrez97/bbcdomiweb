/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.services;

import com.bbc.dom.bbcdomiweb.dto.ConsolidadoAfiliacionesDTO;
import com.bbc.dom.bbcdomiweb.dto.ConsolidadoDomiciliacionesDTO;
import com.bbc.dom.bbcdomiweb.dto.DetalleAfiliacionesDTO;
import com.bbc.dom.bbcdomiweb.dto.DetalleDomiciliacionesDTO;
import com.bbc.dom.bbcdomiweb.dto.IbDomiciliacionesDetDTO;
import com.bbc.dom.bbcdomiweb.model.IbSumarioPagos;
import com.bbc.dom.bbcdomiweb.model.MgAfiliacionesOrdenantes;
import com.bbc.dom.bbcdomiweb.model.MgCalendario;
import com.bbc.dom.bbcdomiweb.model.MgDomiciliacionesEnviadas;
import com.bbc.dom.bbcdomiweb.model.MgDomiciliacionesOrdenantes;
import com.bbc.dom.bbcdomiweb.model.MgDomiciliacionesOrdenantesPK;
import com.bbc.dom.bbcdomiweb.repository.DomiciliacionRepository;
import com.bbc.dom.bbcdomiweb.repository.SumarioPagosRepository;
import com.bbc.dom.bbcdomiweb.util.Util;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.springframework.stereotype.Service;
import javax.persistence.TemporalType;

/**
 *
 * @author Christian Gutierrez
 */
@Service
public class IbDomiciliacionesServices extends Util {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("bcdomicPU");
    EntityManager em = emf.createEntityManager();
    
    EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("bcdomicPU");
    EntityManager em1 = emf1.createEntityManager();

    public synchronized Boolean procesarCarga(List<IbDomiciliacionesDetDTO> domiciliacionesList) {
        Boolean flag = Boolean.TRUE;
        DomiciliacionRepository dr = new DomiciliacionRepository();
        dr.setEntityManager(em);
        Date fechaValida = BuscarFechaValida();

        int i = 0;
        try {
            StringBuilder consultaNextval = new StringBuilder();  // VERIFICAR
            consultaNextval.append("select BCRECER.MG_S_DOMICILIACIONES_ORD.nextval from dual"); // VERIFICAR
            BigDecimal secuencia = (BigDecimal) em1.createNativeQuery(consultaNextval.toString()).getSingleResult();
            Long nextval = secuencia.longValue();
            for (IbDomiciliacionesDetDTO domiciliacion : domiciliacionesList) {
                MgDomiciliacionesOrdenantes domiciliacioni = new MgDomiciliacionesOrdenantes();
                MgDomiciliacionesOrdenantesPK domicPK = new MgDomiciliacionesOrdenantesPK();
                domicPK.setCodigoOrdenante(Integer.valueOf(domiciliacion.getCodOrdenante()));
                domicPK.setFechaValida(fechaValida);
                domicPK.setRegistro(domiciliacion.getLinea());
                domiciliacioni.setFechaCarga(new Date());
                if (domiciliacion.getStatus()) {
                    domiciliacioni.setSituacion("C");
                } else {
                    domiciliacioni.setSituacion("R");
                }
                domiciliacioni.setMgDomiciliacionesOrdenantesPK(domicPK);
                domiciliacioni.setOrigenCarga("W");
                domiciliacioni.setUsuarioCarga("BCDOMIC");
                domiciliacioni.setSecuencia(nextval); // VERIFICAR
//                domiciliacioni.setSecuenciaLote(domiciliacion.getCodLote()); Verificar
                domiciliacioni.setGrupo(domiciliacion.getCodLote());
                System.out.println("Num--> " + ++i);
                dr.create(domiciliacioni);
                nextval++;
            }
        } catch (Exception e) {
            e.printStackTrace();
            flag = Boolean.FALSE;

        }
        return flag;
    }

    public Date BuscarFechaValida() {
        MgCalendario a = new MgCalendario();
        String var = "BCC";

        try {
            StringBuilder consulta = new StringBuilder();
            consulta.append("SELECT m FROM MgCalendario m ");
            consulta.append(" WHERE m.mgCalendarioPK.codigoAplicacion = :codigoAplicacion");

            a = (MgCalendario) em.createQuery(consulta.toString())
                    .setParameter("codigoAplicacion", var)
                    .getSingleResult();
        } catch (Exception e) {
            throw e;
        }

        return a.getFechaHoy();
    }

    public Long procesarSumario(IbSumarioPagos sumarioPagos) {
        Long flag = 0L;
        SumarioPagosRepository sp = new SumarioPagosRepository();
        sp.setEntityManager(em);
        try {
            //flag = sp.create(sumarioPagos).getId();
            IbSumarioPagos name = (IbSumarioPagos) sp.crearPJ(sumarioPagos).getObjet();

            StringBuilder consulta = new StringBuilder();
            IbSumarioPagos sumarioPag = new IbSumarioPagos();
            consulta.append(" SELECT b FROM IbSumarioPagos b ");
            consulta.append("where b.codigoOrdenante = :codigoOrdenante ");
            consulta.append("and  b.nombreArchivo = :nombreArchivo ");
            consulta.append("  ORDER BY b.fechaHoraCarga DESC ");
            sumarioPag = (IbSumarioPagos) em.createQuery(consulta.toString())
                    .setParameter("codigoOrdenante", sumarioPagos.getCodigoOrdenante())
                    .setParameter("nombreArchivo", sumarioPagos.getNombreArchivo())
                    .getSingleResult();
            flag = sumarioPag.getId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public List<IbSumarioPagos> ListarConsolidadosDedominciliaciones2(int codOrdenante) {
        List<IbSumarioPagos> ibSumarioPagos = null;
        try {
            StringBuilder consulta = new StringBuilder();
            consulta.append(" SELECT b FROM IbSumarioPagos b ");
            consulta.append("where b.codigoOrdenante = :codigoOrdenante ");
            consulta.append("  ORDER BY b.fechaHoraCarga DESC ");
            ibSumarioPagos = (List<IbSumarioPagos>) em.createQuery(consulta.toString())
                    .setParameter("codigoOrdenante", codOrdenante)
                    .getResultList();
        } catch (Exception e) {
            throw e;
        }

        return ibSumarioPagos;
    }

    public List<MgDomiciliacionesOrdenantes> BuscarDomiciliacionesPorFechas(String startDate, String endDate, int codOrdenante) {
        List<MgDomiciliacionesOrdenantes> mgDomiciliacionesOrdenantes = null;
        Date fechaInicio = new Date();
        Date fechaFin = new Date();
        Boolean flag1 = Boolean.TRUE;
        Boolean flag2 = Boolean.TRUE;
        if ((startDate == null)) {
            startDate = "";
            flag1 = Boolean.FALSE;
        }
        if ((endDate == null)) {
            endDate = "";
            flag2 = Boolean.FALSE;
        }
        if (flag1) {
            fechaInicio = theStringByToDate(startDate, Boolean.TRUE);
        }
        if (flag2) {
            fechaFin = theStringByToDate(endDate, Boolean.FALSE);
        }
        try {
            StringBuilder consulta = new StringBuilder();
            consulta.append(" SELECT b FROM MgDomiciliacionesOrdenantes b ");
            consulta.append(" WHERE   b.mgDomiciliacionesOrdenantesPK.codigoOrdenante = :codigoOrdenante");
            if (flag1 && flag2) {
                consulta.append(" AND b.fechaCarga BETWEEN :startDate  AND :endDate");
                mgDomiciliacionesOrdenantes = (List<MgDomiciliacionesOrdenantes>) em.createQuery(consulta.toString())
                        .setParameter("codigoOrdenante", codOrdenante)
                        .setParameter("startDate", fechaInicio, TemporalType.DATE)
                        .setParameter("endDate", fechaFin, TemporalType.DATE)
                        .getResultList();
            } else if (flag1) {
                consulta.append(" AND b.fechaCarga >= :startDate");
                mgDomiciliacionesOrdenantes = (List<MgDomiciliacionesOrdenantes>) em.createQuery(consulta.toString())
                        .setParameter("codigoOrdenante", codOrdenante)
                        .setParameter("startDate", fechaInicio, TemporalType.DATE)
                        .getResultList();
            } else if (flag2) {
                consulta.append(" AND b.fechaCarga =< :endDate");
                mgDomiciliacionesOrdenantes = (List<MgDomiciliacionesOrdenantes>) em.createQuery(consulta.toString())
                        .setParameter("codigoOrdenante", codOrdenante)
                        .setParameter("endDate", fechaFin, TemporalType.DATE)
                        .getResultList();
            }
        } catch (Exception e) {
            throw e;
        }
        return mgDomiciliacionesOrdenantes;
    }

    public List<DetalleDomiciliacionesDTO> BuscarDomiciliacionesByLote(Long numLote, String codOrdenante) {
        List<MgDomiciliacionesOrdenantes> mgDomiciliacionesOrdenantes = null;
        List<DetalleDomiciliacionesDTO> detalleDomiciliacionesDTO = new ArrayList<>();
        List<DetalleDomiciliacionesDTO> detalleDomiciliacionesDTOAux = new ArrayList<>();
        List<DetalleDomiciliacionesDTO> data = new ArrayList<>();

        try {
            StringBuilder consulta = new StringBuilder();
            consulta.append(" SELECT b FROM MgDomiciliacionesOrdenantes b ");
            consulta.append(" WHERE   b.grupo = :numeroLote");
//            consulta.append(" WHERE   b.secuenciaLote = :numeroLote"); Verificar
            mgDomiciliacionesOrdenantes = (List<MgDomiciliacionesOrdenantes>) em.createQuery(consulta.toString())
                    .setParameter("numeroLote", numLote)
                    .getResultList();

        } catch (Exception e) {
            throw e;
        }

        for (MgDomiciliacionesOrdenantes mgDomiciliacionesOrdenante : mgDomiciliacionesOrdenantes) {
            String linea = mgDomiciliacionesOrdenante.getMgDomiciliacionesOrdenantesPK().getRegistro();
            DetalleDomiciliacionesDTO detDomic = new DetalleDomiciliacionesDTO();
            detDomic.setCodigoResultado("" + mgDomiciliacionesOrdenante.getCodigoRechazo());
            detDomic.setIdentificacionPagador(linea.substring(61, 73).trim());
            detDomic.setNombrePagador(linea.substring(73, 103).trim());
            detDomic.setCuentaPagador(linea.substring(25, 45));
            detDomic.setMonto(linea.substring(45, 60));
            String nunFac = linea.substring(103, 133); // Ahora se envia el número de contrato

            detDomic.setFactura(nunFac);
            detDomic.setEmision(linea.substring(153, 161));
            String dateVencimiento = linea.substring(161, 169);
            dateVencimiento = dateVencimiento.substring(0, 2) + "/" + dateVencimiento.substring(2, 4) + "/" + dateVencimiento.substring(4, 8);
            detDomic.setVencimiento(dateVencimiento);
            detDomic.setDescripcion("");
            detDomic.setSituacion(mgDomiciliacionesOrdenante.getSituacion());
            detDomic.setCobroExitoso("www");
            detDomic.setFechaCarga(getFechaMod3(mgDomiciliacionesOrdenante.getFechaCarga()));
            detalleDomiciliacionesDTO.add(detDomic);
        }
        detalleDomiciliacionesDTOAux = this.BuscarDomiciliacionesEnviadas(numLote);
        boolean sw = false;
        if (detalleDomiciliacionesDTOAux.size() > 0) {
            for (DetalleDomiciliacionesDTO detalleDomiciliaciones : detalleDomiciliacionesDTO) {
                for (DetalleDomiciliacionesDTO detalleAfiliacionesDTOAux : detalleDomiciliacionesDTOAux) {
                    if (detalleDomiciliaciones.getIdentificacionPagador().equalsIgnoreCase(detalleAfiliacionesDTOAux.getIdentificacionPagador()) && detalleDomiciliaciones.getMonto().equalsIgnoreCase(detalleAfiliacionesDTOAux.getMonto())) {
                        data.add(detalleAfiliacionesDTOAux);
                        sw = true;
                        break;
                    }
                }
                if (sw == false) {
                    data.add(detalleDomiciliaciones);
                }
                sw = false;
            }
        } else {
            data.addAll(detalleDomiciliacionesDTO);
        }

        return data;
    }
    
    public List<DetalleDomiciliacionesDTO> BuscarDomiciliacionesEnviadas(Long numLote){
        List<MgDomiciliacionesEnviadas> mgDomiciliacionesEnviadas = null;
        List<DetalleDomiciliacionesDTO> detalleDomiciliacionesDTO = new ArrayList<>();
        try {
            StringBuilder consulta = new StringBuilder();
            consulta.append(" SELECT b FROM MgDomiciliacionesEnviadas b ");
            consulta.append(" WHERE  b.grupo = :secuenciaLote");
//            consulta.append(" WHERE  b.secuenciaLote = :secuenciaLote");Verificar
  
            mgDomiciliacionesEnviadas = (List<MgDomiciliacionesEnviadas>) em.createQuery(consulta.toString())
                    .setParameter("secuenciaLote", numLote)
                    .getResultList();

        } catch (Exception e) {
            throw e;
        }
        
        for (MgDomiciliacionesEnviadas domiciliacionesEnviadas : mgDomiciliacionesEnviadas) {

            String linea = domiciliacionesEnviadas.getRegistroOrdenante();
            DetalleDomiciliacionesDTO detDomic = new DetalleDomiciliacionesDTO();
            detDomic.setCodigoResultado("" + domiciliacionesEnviadas.getCodigoError());
            detDomic.setIdentificacionPagador(linea.substring(61, 73).trim());
            detDomic.setNombrePagador(linea.substring(73, 103).trim());
            detDomic.setCuentaPagador(linea.substring(25, 45));
            detDomic.setMonto(linea.substring(45, 60));
            String nunFac = linea.substring(103, 133); // Ahora se envia el número de contrato

            detDomic.setFactura(nunFac);
            detDomic.setEmision(linea.substring(153, 161));
            String dateVencimiento = linea.substring(161, 169);
            dateVencimiento = dateVencimiento.substring(0, 2) + "/" + dateVencimiento.substring(2, 4) + "/" + dateVencimiento.substring(4, 8);
            detDomic.setVencimiento(dateVencimiento);
            detDomic.setDescripcion("");
            detDomic.setSituacion(domiciliacionesEnviadas.getAplicadoUap());
            detDomic.setCobroExitoso(domiciliacionesEnviadas.getCobroExitoso());
            detDomic.setFechaCarga(getFechaMod3(domiciliacionesEnviadas.getFechaCreacion()));
            detalleDomiciliacionesDTO.add(detDomic);
        }
        return detalleDomiciliacionesDTO; 
    }

    public String getFechaMod3(Date fecha) {
        SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
        return sf.format(fecha);
    }

    public List<IbSumarioPagos> BuscarSumario(String nombreArchivo, String opraciopn) {
        List<IbSumarioPagos> ibSumarioPagos = null;
        if ((nombreArchivo == null)) {
            nombreArchivo = "";
        }
        try {
            StringBuilder consulta = new StringBuilder();
            if (opraciopn.equals("DO")) {
                consulta.append(" SELECT b FROM IbSumarioPagos b ");
            } else {
                consulta.append(" SELECT b FROM IbSumarioAfiliaciones b ");
            }

            consulta.append(" WHERE b.nombreArchivo = :nombreArchivo");
            ibSumarioPagos = (List<IbSumarioPagos>) em.createQuery(consulta.toString())
                    .setParameter("nombreArchivo", nombreArchivo)
                    .getResultList();
        } catch (Exception e) {
            throw e;
        }

        return ibSumarioPagos;
    }

    public List<ConsolidadoDomiciliacionesDTO> ListarConsolidadosDedominciliaciones(int codOrdenante) {

        List<ConsolidadoDomiciliacionesDTO> consolidadoDomiciliacionesDTO = new ArrayList<>();;

        try {
            // Ordenantes
            StringBuilder consulta = new StringBuilder();
            /*consulta.append("select  * from (SELECT distinct  p.id, p.fecha_hora_carga AS FECHA_HORA_CARGA,p.nombre_archivo AS NOMBRE_ARCHIVO,p.nro_registros_procesar AS NRO_REGISTROS_PROCESAR, ");
            consulta.append("(SELECT COUNT(1) FROM BCRECER.mg_domiciliaciones_ordenantes p where p.secuencia_lote =p.id  and (p.situacion='X' or p.situacion='R')) NRO_REGISTROS_RECHAZADOS , ");
            consulta.append("(SELECT COUNT(*) FROM BCRECER.mg_domiciliaciones_ordenantes p where p.secuencia_lote =p.id  and p.situacion='P') NRO_REGISTROS_VALIDADOS, ");
            consulta.append("(SELECT COUNT(*) FROM BCRECER.mg_domiciliaciones_ordenantes p where p.secuencia_lote =p.id  and p.situacion='C') NRO_REGISTROS_PENDIENTES  ");
            consulta.append("FROM  ib_sumario_pagos p where p.codigo_ordenante=" + codOrdenante + " ORDER BY p.fecha_hora_carga desc ) x where x.NRO_REGISTROS_RECHAZADOS!=0 or x.NRO_REGISTROS_VALIDADOS!=0 or x.NRO_REGISTROS_PENDIENTES!=0");*/

            consulta.append("select  * from (SELECT distinct  p.id, p.fecha_hora_carga AS FECHA_HORA_CARGA,p.nombre_archivo AS NOMBRE_ARCHIVO,p.nro_registros_procesar AS NRO_REGISTROS_PROCESAR, ");
            consulta.append("(SELECT COUNT(1) FROM BCRECER.mg_domiciliaciones_ordenantes p where p.grupo = p.id  and (p.situacion='X' or p.situacion='R') and p.CODIGO_ORDENANTE = " +codOrdenante+ ") NRO_REGISTROS_RECHAZADOS , ");
            consulta.append("(SELECT COUNT(*) FROM BCRECER.mg_domiciliaciones_ordenantes p where p.grupo = p.id  and p.situacion='P' and p.CODIGO_ORDENANTE = " +codOrdenante+ ") NRO_REGISTROS_VALIDADOS, ");
            consulta.append("(SELECT COUNT(*) FROM BCRECER.mg_domiciliaciones_ordenantes p where p.grupo = p.id  and p.situacion='C' and p.CODIGO_ORDENANTE = " +codOrdenante+ ") NRO_REGISTROS_PENDIENTES  ");
            consulta.append("FROM  ib_sumario_pagos p where p.codigo_ordenante=" + codOrdenante + " ORDER BY p.fecha_hora_carga desc ) x where x.NRO_REGISTROS_RECHAZADOS!=0 or x.NRO_REGISTROS_VALIDADOS!=0 or x.NRO_REGISTROS_PENDIENTES!=0");
         
            Query q = em.createNativeQuery(consulta.toString());

            // Enviadas
            StringBuilder consulta2 = new StringBuilder();
            /*consulta2.append("select * from (SELECT distinct  p.id, p.fecha_hora_carga AS FECHA_HORA_CARGA,p.nombre_archivo AS NOMBRE_ARCHIVO,p.nro_registros_procesar AS NRO_REGISTROS_PROCESAR, ");
            consulta2.append("null NRO_REGISTROS_RECHAZADOS, ");
            consulta2.append("(SELECT COUNT(*) FROM BCRECER.mg_domiciliaciones_enviadas p where p.secuencia_lote =p.id and ((p.aplicado_uap = 'P') or (p.aplicado_uap = 'K' and p.cobro_exitoso = 'SI') or (p.aplicado_uap = 'O' and p.cobro_exitoso = 'SI'))) NRO_REGISTROS_VALIDADOS, ");
            consulta2.append("(SELECT COUNT(*) FROM BCRECER.mg_domiciliaciones_enviadas p where p.secuencia_lote =p.id  and ((p.aplicado_uap = 'O' and p.cobro_exitoso = null))) NRO_REGISTROS_PENDIENTES  ");
            consulta2.append("FROM  ib_sumario_pagos p where p.codigo_ordenante=" + codOrdenante + " ORDER BY p.fecha_hora_carga desc ) x where x.NRO_REGISTROS_RECHAZADOS!=0 or x.NRO_REGISTROS_VALIDADOS!=0 or x.NRO_REGISTROS_PENDIENTES!=0");*/

            consulta2.append("select * from (SELECT distinct  p.id, p.fecha_hora_carga AS FECHA_HORA_CARGA,p.nombre_archivo AS NOMBRE_ARCHIVO,p.nro_registros_procesar AS NRO_REGISTROS_PROCESAR, ");
            consulta2.append("null NRO_REGISTROS_RECHAZADOS, ");
            consulta2.append("(SELECT COUNT(*) FROM BCRECER.mg_domiciliaciones_enviadas p where p.grupo = p.id and ((p.aplicado_uap = 'P') or (p.aplicado_uap = 'K' and p.cobro_exitoso = 'SI') or (p.aplicado_uap = 'O' and p.cobro_exitoso = 'SI')) and p.CODIGO_ORDENANTE = " +codOrdenante+ ") NRO_REGISTROS_VALIDADOS, ");
            consulta2.append("(SELECT COUNT(*) FROM BCRECER.mg_domiciliaciones_enviadas p where p.grupo = p.id  and ((p.aplicado_uap = 'O' and p.cobro_exitoso = null)) and p.CODIGO_ORDENANTE = " +codOrdenante+ ") NRO_REGISTROS_PENDIENTES  ");
            consulta2.append("FROM  ib_sumario_pagos p where p.codigo_ordenante=" + codOrdenante + " ORDER BY p.fecha_hora_carga desc ) x where x.NRO_REGISTROS_RECHAZADOS!=0 or x.NRO_REGISTROS_VALIDADOS!=0 or x.NRO_REGISTROS_PENDIENTES!=0");
          
            Query q2 = em.createNativeQuery(consulta2.toString());

            try {
                List listOrdenantes = q.getResultList();
                List listEnviadas = q2.getResultList();
                boolean sw = false;
                ConsolidadoDomiciliacionesDTO consolDomic = new ConsolidadoDomiciliacionesDTO();
                for (Object ordenantes : listOrdenantes) {
                    Object[] objectArrayO = (Object[]) ordenantes;
                    for (Object enviadas : listEnviadas) {
                        Object[] objectArrayE = (Object[]) enviadas;
                        consolDomic = new ConsolidadoDomiciliacionesDTO();
                        if (objectArrayO[0].toString().equals(objectArrayE[0].toString()) && objectArrayO[2].toString().equals(objectArrayE[2].toString())) {
                            System.out.println(objectArrayE[0]);
                            BigDecimal c = (BigDecimal) objectArrayE[0];
                            consolDomic.setId(c.longValue());
                            System.out.println(objectArrayE[1]);
                            consolDomic.setFechaHoraCarga((Date) objectArrayE[1]);
                            System.out.println(objectArrayE[2]);
                            consolDomic.setNombreArchivo((String) objectArrayE[2]);
                            System.out.println(objectArrayE[3]);
                            BigDecimal c1 = (BigDecimal) objectArrayE[3];
                            consolDomic.setNroRegistrosProcesar(c1.toBigInteger());
                            System.out.println(objectArrayE[4]);
                            BigDecimal c2 = (BigDecimal) objectArrayO[4];
                            consolDomic.setNroRegistrosRechazados(c2.toBigInteger());
                            System.out.println(objectArrayO[5]);
                            BigDecimal c3 = (BigDecimal) objectArrayE[5];
                            consolDomic.setNroRegistrosValidados(c3.toBigInteger());
                            System.out.println(objectArrayE[6]);
                            BigDecimal c4 = (BigDecimal) objectArrayE[6];
                            consolDomic.setNroRegistrosPendientes(c4.toBigInteger());
                            consolidadoDomiciliacionesDTO.add(consolDomic);
                            sw = true;
                            break;
                        }
                    }
                    if (sw == false) {
                        System.out.println(objectArrayO[0]);
                        BigDecimal c = (BigDecimal) objectArrayO[0];
                        consolDomic.setId(c.longValue());
                        System.out.println(objectArrayO[1]);
                        consolDomic.setFechaHoraCarga((Date) objectArrayO[1]);
                        System.out.println(objectArrayO[2]);
                        consolDomic.setNombreArchivo((String) objectArrayO[2]);
                        System.out.println(objectArrayO[3]);
                        BigDecimal c1 = (BigDecimal) objectArrayO[3];
                        consolDomic.setNroRegistrosProcesar(c1.toBigInteger());
                        System.out.println(objectArrayO[4]);
                        BigDecimal c2 = (BigDecimal) objectArrayO[4];
                        consolDomic.setNroRegistrosRechazados(c2.toBigInteger());
                        System.out.println(objectArrayO[5]);
                        BigDecimal c3 = (BigDecimal) objectArrayO[5];
                        consolDomic.setNroRegistrosValidados(c3.toBigInteger());
                        System.out.println(objectArrayO[6]);
                        BigDecimal c4 = (BigDecimal) objectArrayO[6];
                        consolDomic.setNroRegistrosPendientes(c4.toBigInteger());
                        consolidadoDomiciliacionesDTO.add(consolDomic);
                        consolDomic = new ConsolidadoDomiciliacionesDTO();
                    }
                    sw = false;
                }

                /*    List r = q.getResultList();
                Object O[] = null;
                for (int i = 0; i < r.size(); i++) {
                    ConsolidadoDomiciliacionesDTO consolDomic = new ConsolidadoDomiciliacionesDTO();
                    Object obj = r.get(i);
                    Object[] objectArray = (Object[]) obj;

                    System.out.println(objectArray[0]);
                    BigDecimal c = (BigDecimal) objectArray[0];
                    consolDomic.setId(c.longValue());
                    System.out.println(objectArray[1]);
                    consolDomic.setFechaHoraCarga((Date) objectArray[1]);
                    System.out.println(objectArray[2]);
                    consolDomic.setNombreArchivo((String) objectArray[2]);
                    System.out.println(objectArray[3]);
                    BigDecimal c1 = (BigDecimal) objectArray[3];
                    consolDomic.setNroRegistrosProcesar(c1.toBigInteger());
                    System.out.println(objectArray[4]);
                    BigDecimal c2 = (BigDecimal) objectArray[4];
                    consolDomic.setNroRegistrosRechazados(c2.toBigInteger());
                    System.out.println(objectArray[5]);
                    BigDecimal c3 = (BigDecimal) objectArray[5];
                    consolDomic.setNroRegistrosValidados(c3.toBigInteger());
                    System.out.println(objectArray[6]);
                    BigDecimal c4 = (BigDecimal) objectArray[6];
                    consolDomic.setNroRegistrosPendientes(c4.toBigInteger());
                    consolidadoDomiciliacionesDTO.add(consolDomic);
                }*/
            } catch (Exception e) {
                e.printStackTrace();

            }
        } catch (Exception e) {
            throw e;
        }
        return consolidadoDomiciliacionesDTO;
    }

}
