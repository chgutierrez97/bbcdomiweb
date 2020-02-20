package com.bbc.dom.bbcdomiweb.services;

import com.bbc.dom.bbcdomiweb.dto.ConsolidadoAfiliacionesDTO;
import com.bbc.dom.bbcdomiweb.dto.DetalleAfiliacionesDTO;
import com.bbc.dom.bbcdomiweb.dto.IbAfiliacionesDetDTO;
import com.bbc.dom.bbcdomiweb.model.IbMensajes;
import com.bbc.dom.bbcdomiweb.model.IbSumarioAfiliaciones;
import com.bbc.dom.bbcdomiweb.model.IbSumarioPagos;
import com.bbc.dom.bbcdomiweb.repository.AfiliacionRepository;
import com.bbc.dom.bbcdomiweb.model.MgAfiliacionesOrdenantes;
import com.bbc.dom.bbcdomiweb.model.MgAfiliacionesOrdenantesPK;
import com.bbc.dom.bbcdomiweb.model.MgAfiliacionesPresentadas;
import com.bbc.dom.bbcdomiweb.model.MgCalendario;
import com.bbc.dom.bbcdomiweb.model.MgParametrosOrdenantes;
import com.bbc.dom.bbcdomiweb.repository.SumarioAfiliacionesRepository;
import com.bbc.dom.bbcdomiweb.repository.SumarioPagosRepository;
import com.bbc.dom.bbcdomiweb.util.Util;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.validation.ConstraintViolationException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Christian Gutierrez
 */
@Service
public class IbAfiliacionesServices extends Util {
    

    private final int LONGITUD_DETALLE_TIPO_OPERACION = 1;
    private final int LONGITUD_DETALLE_IDENTIFICADOR_PAGADOR = 12;
    private final int LONGITUD_DETALLE_CUENTA_PAGADOR = 20;
    private final int LONGITUD_DETALLE_NOMBRE_PAGADOR = 30;
    private final int LONGITUD_DETALLE_REFERENCIA_CONTRATO = 30;

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("bcdomicPU");
    EntityManager em = emf.createEntityManager();

    public Boolean procesarCarga(List<IbAfiliacionesDetDTO> afiliacionesList) {
        Boolean flag = Boolean.TRUE;
        AfiliacionRepository ar = new AfiliacionRepository();
        ar.setEntityManager(em);
        Date fechaValida = BuscarFechaValida();

        int i = 0;
//        Long j = 300L;
        try {
            for (IbAfiliacionesDetDTO ibAfiliacionesDetDTO : afiliacionesList) {
                try {
                    MgAfiliacionesOrdenantes afilia = new MgAfiliacionesOrdenantes();
                    MgAfiliacionesOrdenantesPK afiPK = new MgAfiliacionesOrdenantesPK(); 
                 /*   afiPK.setElementoGrupo(Integer.valueOf(ibAfiliacionesDetDTO.getCodOrdenante()));*/
                    afiPK.setFechaValida(fechaValida);
                    afiPK.setRegistro(ibAfiliacionesDetDTO.getLinea());
                    
                    afilia.setCodigoOrdenante(Integer.valueOf(ibAfiliacionesDetDTO.getCodOrdenante()));
                    afilia.setFechaCarga(new Date());
//                    afilia.setSecuenciaLote(ibAfiliacionesDetDTO.getCodLote()); Verificar
                    afilia.setGrupo(ibAfiliacionesDetDTO.getCodLote());
                    if(!ibAfiliacionesDetDTO.getStatus()){
                        afilia.setCodigoRechazo(212L);
                        afilia.setSituacion("X");
                    }else{  
                    afilia.setSituacion("C");
                    }
                    afilia.setMgAfiliacionesOrdenantesPK(afiPK);
                    afilia.setOrigenCarga("W");
                    afilia.setUsuarioCarga("BCDOMIC");
//                    afilia.setElementoGrupo(j++);
                    System.out.println("Num--> " + ++i);
                    ar.create(afilia);
                } catch (Exception e) {
                    e.printStackTrace();
                    flag = Boolean.FALSE;

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            flag = Boolean.FALSE;

        }
        return flag;

    }

    public Boolean procesarSumario(IbSumarioPagos sumarioPagos) {
        Boolean flag = Boolean.TRUE;
        SumarioPagosRepository sp = new SumarioPagosRepository();
        sp.setEntityManager(em);
        try {
            sp.create(sumarioPagos);
        } catch (Exception e) {
            e.printStackTrace();
            flag = Boolean.FALSE;
        }

        return null;
    }

    public Long procesarSumarioAfiliaciones(IbSumarioAfiliaciones sumarioAfiliaciones) {
        Long flag = 0L;
        SumarioAfiliacionesRepository sa = new SumarioAfiliacionesRepository();
        sa.setEntityManager(em);
        try {
            IbSumarioAfiliaciones name = (IbSumarioAfiliaciones) sa.create(sumarioAfiliaciones);
            StringBuilder consulta = new StringBuilder();
            IbSumarioAfiliaciones sumarioAfi = new IbSumarioAfiliaciones();
            consulta.append(" SELECT b FROM IbSumarioAfiliaciones b ");
            consulta.append("where b.codigoOrdenante = :codigoOrdenante ");
            consulta.append("and  b.nombreArchivo = :nombreArchivo ");
            consulta.append("  ORDER BY b.fechaHoraCarga DESC ");
            sumarioAfi = (IbSumarioAfiliaciones) em.createQuery(consulta.toString())
                    .setParameter("codigoOrdenante", sumarioAfiliaciones.getCodigoOrdenante())
                    .setParameter("nombreArchivo", sumarioAfiliaciones.getNombreArchivo())
                    .getSingleResult();
            flag = sumarioAfi.getId();
        } catch (ConstraintViolationException  e) {
            System.out.println("se genera una Exception al trabajar con la tabla IbSumarioAfiliaciones ");
            flag = 1L;
        } catch(Exception e){
            System.out.println("se genera una Exception al trabajar con la tabla IbSumarioAfiliaciones ");
            flag = 0L;
        }
        return flag;
    }

    public List<MgAfiliacionesPresentadas> BuscarAfiliadoPorIdentificacion(String numDocumento, String codOrdenante) {
        List<MgAfiliacionesPresentadas> mgAfiliacionesPresentadas = null;
        if ((numDocumento == null)) {
            numDocumento = "";
        }
        if ((codOrdenante == null)) {
            codOrdenante = "";
        }
        try {
            StringBuilder consulta = new StringBuilder();
            consulta.append(" SELECT b FROM MgAfiliacionesPresentadas b ");
            consulta.append(" WHERE b.mgAfiliacionesPresentadasPK.codigoOrdenante =:codOrdenante");
            consulta.append(" AND b.identificacionPagador =:numDocumento ");

            mgAfiliacionesPresentadas = (List<MgAfiliacionesPresentadas>) em.createQuery(consulta.toString())
                    .setParameter("codOrdenante", codOrdenante)
                    .setParameter("numDocumento", numDocumento)
                    .getResultList();
        } catch (Exception e) {
            throw e;
        }

        return mgAfiliacionesPresentadas;
    }
    
    public List<MgAfiliacionesPresentadas> BuscarAfiliadoPorIdentificacion2(String numDocumento, String codOrdenante) {
        List<MgAfiliacionesPresentadas> mgAfiliacionesPresentadas = null;
        if ((numDocumento == null)) {
            numDocumento = "";
        }
        if ((codOrdenante == null)) {
            codOrdenante = "";
        }
        try {
            StringBuilder consulta = new StringBuilder();
            consulta.append(" SELECT b FROM MgAfiliacionesPresentadas b ");
            consulta.append(" WHERE b.mgAfiliacionesPresentadasPK.codigoOrdenante =:codOrdenante");
            consulta.append(" AND b.identificacionPagador =:numDocumento ");
            consulta.append(" AND b.codigoResultado ='P' ");

            mgAfiliacionesPresentadas = (List<MgAfiliacionesPresentadas>) em.createQuery(consulta.toString())
                    .setParameter("codOrdenante", codOrdenante)
                    .setParameter("numDocumento", numDocumento)
                    .getResultList();
        } catch (Exception e) {
            throw e;
        }

        return mgAfiliacionesPresentadas;
    }

    public List<IbSumarioAfiliaciones> ListarConsolidadosDeAfiliaciones2(int codOrdenante) {

        List<IbSumarioAfiliaciones> ibSumarioAfiliacioness = null;

        try {
            StringBuilder consulta = new StringBuilder();
            consulta.append(" SELECT b FROM IbSumarioAfiliaciones b ");
            consulta.append("where b.codigoOrdenante = :codigoOrdenante ");
            consulta.append("  ORDER BY b.fechaHoraCarga DESC ");

            ibSumarioAfiliacioness = (List<IbSumarioAfiliaciones>) em.createQuery(consulta.toString())
                    .setParameter("codigoOrdenante", codOrdenante)
                    .getResultList();
        } catch (Exception e) {
            throw e;
        }

        return ibSumarioAfiliacioness;
    }


    public List<ConsolidadoAfiliacionesDTO> ListarConsolidadosDeAfiliaciones(int codOrdenante) {

        List<ConsolidadoAfiliacionesDTO> consolidadoAfiliacionesDTO = new ArrayList<>();;

        try {
            // Ordenantes
            StringBuilder consulta = new StringBuilder();
//            consulta.append("select  * from (SELECT distinct  p.id, p.fecha_hora_carga AS FECHA_HORA_CARGA,p.nombre_archivo AS NOMBRE_ARCHIVO,p.nro_registros_procesar AS NRO_REGISTROS_PROCESAR, ");
//            consulta.append("(SELECT COUNT(*) FROM BCRECER.mg_afiliaciones_ordenantes p where p.secuencia_lote =p.id  and (p.situacion='X' or p.situacion='R')) NRO_REGISTROS_RECHAZADOS , ");
//            consulta.append("(SELECT COUNT(*) FROM BCRECER.mg_afiliaciones_ordenantes p where p.secuencia_lote =p.id  and p.situacion='P') NRO_REGISTROS_VALIDADOS, ");
//            consulta.append("(SELECT COUNT(*) FROM BCRECER.mg_afiliaciones_ordenantes p where p.secuencia_lote =p.id  and (p.situacion='C')) NRO_REGISTROS_PENDIENTES ");
//            consulta.append("FROM  ib_sumario_afiliaciones p where p.codigo_ordenante="+codOrdenante+" ORDER BY p.fecha_hora_carga desc  ) x where x.NRO_REGISTROS_RECHAZADOS!=0 or x.NRO_REGISTROS_VALIDADOS!=0 or x.NRO_REGISTROS_PENDIENTES!=0"); Verificar
            
            consulta.append("select  * from (SELECT distinct  p.id, p.fecha_hora_carga AS FECHA_HORA_CARGA,p.nombre_archivo AS NOMBRE_ARCHIVO,p.nro_registros_procesar AS NRO_REGISTROS_PROCESAR, ");
            consulta.append("(SELECT COUNT(*) FROM BCRECER.mg_afiliaciones_ordenantes p where p.grupo = p.id  and (p.situacion='X' or p.situacion='R') and p.CODIGO_ORDENANTE = " +codOrdenante+ ") NRO_REGISTROS_RECHAZADOS , ");
            consulta.append("(SELECT COUNT(*) FROM BCRECER.mg_afiliaciones_ordenantes p where p.grupo = p.id  and p.situacion='P' and p.CODIGO_ORDENANTE = " +codOrdenante+ ") NRO_REGISTROS_VALIDADOS, ");
            consulta.append("(SELECT COUNT(*) FROM BCRECER.mg_afiliaciones_ordenantes p where p.grupo = p.id  and (p.situacion='C') and p.CODIGO_ORDENANTE = " +codOrdenante+ ") NRO_REGISTROS_PENDIENTES ");
            consulta.append("FROM  ib_sumario_afiliaciones p where p.codigo_ordenante="+codOrdenante+" ORDER BY p.fecha_hora_carga desc  ) x where x.NRO_REGISTROS_RECHAZADOS!=0 or x.NRO_REGISTROS_VALIDADOS!=0 or x.NRO_REGISTROS_PENDIENTES!=0");

            Query q = em.createNativeQuery(consulta.toString());
            
            // Presentadas
            StringBuilder consulta2 = new StringBuilder();
//            consulta2.append("select  * from (SELECT distinct  p.id, p.fecha_hora_carga AS FECHA_HORA_CARGA,p.nombre_archivo AS NOMBRE_ARCHIVO,p.nro_registros_procesar AS NRO_REGISTROS_PROCESAR, ");
//            consulta2.append("null NRO_REGISTROS_RECHAZADOS, ");
//            consulta2.append("(SELECT COUNT(*) FROM BCRECER.mg_afiliaciones_presentadas b where b.secuencia_lote =p.id  and b.CODIGO_RESULTADO='P') NRO_REGISTROS_VALIDADOS, ");
//            consulta2.append("(SELECT COUNT(*) FROM BCRECER.mg_afiliaciones_presentadas c where c.secuencia_lote =p.id  and (c.CODIGO_RESULTADO='C')) NRO_REGISTROS_PENDIENTES ");
//            consulta2.append("FROM  ib_sumario_afiliaciones p where p.codigo_ordenante="+codOrdenante+" ORDER BY p.fecha_hora_carga desc  ) x where x.NRO_REGISTROS_RECHAZADOS!=0 or x.NRO_REGISTROS_VALIDADOS!=0 or x.NRO_REGISTROS_PENDIENTES!=0");
            
            consulta2.append("select  * from (SELECT distinct  p.id, p.fecha_hora_carga AS FECHA_HORA_CARGA,p.nombre_archivo AS NOMBRE_ARCHIVO,p.nro_registros_procesar AS NRO_REGISTROS_PROCESAR, ");
            consulta2.append("null NRO_REGISTROS_RECHAZADOS, ");
            consulta2.append("(SELECT COUNT(*) FROM BCRECER.mg_afiliaciones_presentadas b where b.grupo = p.id  and b.CODIGO_RESULTADO='P' and b.CODIGO_ORDENANTE = " +codOrdenante+ ") NRO_REGISTROS_VALIDADOS, ");
            consulta2.append("(SELECT COUNT(*) FROM BCRECER.mg_afiliaciones_presentadas c where c.grupo = p.id  and (c.CODIGO_RESULTADO='C') and c.CODIGO_ORDENANTE =" +codOrdenante+ ") NRO_REGISTROS_PENDIENTES ");
            consulta2.append("FROM  ib_sumario_afiliaciones p where p.codigo_ordenante="+codOrdenante+" ORDER BY p.fecha_hora_carga desc  ) x where x.NRO_REGISTROS_RECHAZADOS!=0 or x.NRO_REGISTROS_VALIDADOS!=0 or x.NRO_REGISTROS_PENDIENTES!=0");

            Query q2 = em.createNativeQuery(consulta2.toString());

            try {
                
                List listOrdenantes = q.getResultList();
                List listPresentadas = q2.getResultList();
                boolean sw = false;
                ConsolidadoAfiliacionesDTO consolAfiliacion;
                for (Object ordenantes : listOrdenantes) {
                    Object[] objectArrayO = (Object[]) ordenantes;
                    for (Object presentadas : listPresentadas) {
                        Object[] objectArrayP = (Object[]) presentadas;
                        consolAfiliacion = new ConsolidadoAfiliacionesDTO();
                        if (objectArrayO[0].toString().equals(objectArrayP[0].toString()) && objectArrayO[2].toString().equals(objectArrayP[2].toString())) {
                            System.out.println(objectArrayP[0]);
                            BigDecimal c = (BigDecimal) objectArrayP[0];
                            consolAfiliacion.setId(c.longValue());
                            System.out.println(objectArrayP[1]);
                            consolAfiliacion.setFechaHoraCarga((Date) objectArrayP[1]);
                            System.out.println(objectArrayP[2]);
                            consolAfiliacion.setNombreArchivo((String) objectArrayP[2]);
                            System.out.println(objectArrayP[3]);
                            BigDecimal c1 = (BigDecimal) objectArrayP[3];
                            consolAfiliacion.setNroRegistrosProcesar(c1.toBigInteger());
                            System.out.println(objectArrayO[4]);
                            BigDecimal c2 = (BigDecimal) objectArrayO[4];
                            consolAfiliacion.setNroRegistrosRechazados(c2.toBigInteger());
                            System.out.println(objectArrayP[5]);
                            BigDecimal c3 = (BigDecimal) objectArrayP[5];
                            consolAfiliacion.setNroRegistrosValidados(c3.toBigInteger());
                            System.out.println(objectArrayP[6]);
                            BigDecimal c4 = (BigDecimal) objectArrayP[6];
                            consolAfiliacion.setNroRegistrosPendientes(c4.toBigInteger());
                            consolidadoAfiliacionesDTO.add(consolAfiliacion);
                            sw = true;
                            break;
                        }
                    }
                    if (sw == false) {
                        consolAfiliacion = new ConsolidadoAfiliacionesDTO();
                        System.out.println(objectArrayO[0]);
                        BigDecimal c = (BigDecimal) objectArrayO[0];
                        consolAfiliacion.setId(c.longValue());
                        System.out.println(objectArrayO[1]);
                        consolAfiliacion.setFechaHoraCarga((Date) objectArrayO[1]);
                        System.out.println(objectArrayO[2]);
                        consolAfiliacion.setNombreArchivo((String) objectArrayO[2]);
                        System.out.println(objectArrayO[3]);
                        BigDecimal c1 = (BigDecimal) objectArrayO[3];
                        consolAfiliacion.setNroRegistrosProcesar(c1.toBigInteger());
                        System.out.println(objectArrayO[4]);
                        BigDecimal c2 = (BigDecimal) objectArrayO[4];
                        consolAfiliacion.setNroRegistrosRechazados(c2.toBigInteger());
                        System.out.println(objectArrayO[5]);
                        BigDecimal c3 = (BigDecimal) objectArrayO[5];
                        consolAfiliacion.setNroRegistrosValidados(c3.toBigInteger());
                        System.out.println(objectArrayO[6]);
                        BigDecimal c4 = (BigDecimal) objectArrayO[6];
                        consolAfiliacion.setNroRegistrosPendientes(c4.toBigInteger());
                        consolidadoAfiliacionesDTO.add(consolAfiliacion);
                    }
                    sw = false;
                }

               /* List r = q.getResultList();
                Object O[] = null;
                for (int i = 0; i < r.size(); i++) {
                    ConsolidadoAfiliacionesDTO consolAfiliacios = new ConsolidadoAfiliacionesDTO();
                    Object obj = r.get(i);
                    Object[] objectArray = (Object[]) obj;

                    System.out.println(objectArray[0]);
                    BigDecimal c = (BigDecimal) objectArray[0];
                    consolAfiliacios.setId(c.longValue());
                    System.out.println(objectArray[1]);
                    consolAfiliacios.setFechaHoraCarga((Date) objectArray[1]);
                    System.out.println(objectArray[2]);
                    consolAfiliacios.setNombreArchivo((String) objectArray[2]);
                    System.out.println(objectArray[3]);
                    BigDecimal c1 = (BigDecimal) objectArray[3];
                    consolAfiliacios.setNroRegistrosProcesar(c1.toBigInteger());
                    System.out.println(objectArray[4]);
                    BigDecimal c2 = (BigDecimal) objectArray[4];
                    consolAfiliacios.setNroRegistrosRechazados(c2.toBigInteger());
                    System.out.println(objectArray[5]);
                    BigDecimal c3 = (BigDecimal) objectArray[5];
                    consolAfiliacios.setNroRegistrosValidados(c3.toBigInteger());
                    System.out.println(objectArray[6]);
                    BigDecimal c4 = (BigDecimal) objectArray[6];
                    consolAfiliacios.setNroRegistrosPendientes(c4.toBigInteger());
                    consolidadoAfiliacionesDTO.add(consolAfiliacios);
                }*/
                
            } catch (Exception e) {
                e.printStackTrace();
                //JOptionPane.showMessageDialog(null, "Error Cargando clientes - " + e.getMessage());
            }
        } catch (Exception e) {
            throw e;
        }
        return consolidadoAfiliacionesDTO;
    }

    public List<MgAfiliacionesPresentadas> BuscarAfiliadoPorFechas(String startDate, String endDate, int codOrdenante) {
        List<MgAfiliacionesPresentadas> mgAfiliacionesPresentadas = null;
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
            consulta.append(" SELECT b FROM MgAfiliacionesPresentadas b ");
            consulta.append(" WHERE   b.mgAfiliacionesPresentadasPK.codigoOrdenante = :codigoOrdenante");
            if (flag1 && flag2) {
                consulta.append(" AND b.fechaCarga BETWEEN :startDate  AND :endDate");
                mgAfiliacionesPresentadas = (List<MgAfiliacionesPresentadas>) em.createQuery(consulta.toString())
                        .setParameter("startDate", fechaInicio, TemporalType.DATE)
                        .setParameter("endDate", fechaFin, TemporalType.DATE)
                        .getResultList();
            } else if (flag1) {
                consulta.append(" AND b.fechaCarga >= :startDate");
                mgAfiliacionesPresentadas = (List<MgAfiliacionesPresentadas>) em.createQuery(consulta.toString())
                        .setParameter("codigoOrdenante", codOrdenante)
                        .setParameter("startDate", fechaInicio, TemporalType.DATE)
                        .getResultList();
            } else if (flag2) {
                consulta.append(" AND b.fechaCarga =< :endDate");
                mgAfiliacionesPresentadas = (List<MgAfiliacionesPresentadas>) em.createQuery(consulta.toString())
                        .setParameter("codigoOrdenante", codOrdenante)
                        .setParameter("endDate", fechaFin, TemporalType.DATE)
                        .getResultList();
            }

        } catch (Exception e) {
            throw e;
        }
        return mgAfiliacionesPresentadas;
    }

    public List<MgAfiliacionesPresentadas> BuscarAfiliadoPorlote2(Long numLote, String codOrdenante) {
        List<MgAfiliacionesPresentadas> mgAfiliacionesPresentadas = null;
        try {
            StringBuilder consulta = new StringBuilder();
            consulta.append(" SELECT b FROM MgAfiliacionesPresentadas b ");
            consulta.append(" WHERE   b.mgAfiliacionesPresentadasPK.codigoOrdenante = :codigoOrdenante");
            consulta.append(" and  b.grupo = :grupo");
//            consulta.append(" and  b.secuenciaLote = :secuenciaLote"); Verificar
            mgAfiliacionesPresentadas = (List<MgAfiliacionesPresentadas>) em.createQuery(consulta.toString())
                    .setParameter("codigoOrdenante", codOrdenante)
                    .setParameter("grupo", numLote)
//                    .setParameter("secuenciaLote", numLote) Verificar
                    .getResultList();

        } catch (Exception e) {
            throw e;
        }
        return mgAfiliacionesPresentadas;
    }
    
    
    public List<IbMensajes> CargarMensajes() {
        List<IbMensajes> ibMensajes = null;
        try {
            StringBuilder consulta = new StringBuilder();
            consulta.append(" SELECT b FROM IbMensajes b ");
            
            ibMensajes = (List<IbMensajes>) em.createQuery(consulta.toString())
                    .getResultList();

        } catch (Exception e) {
            throw e;
        }
        return ibMensajes;
    }

    
    public List<DetalleAfiliacionesDTO> BuscarAfiliadoPorlote(Long numLote, String codOrdenante) {
        List<MgAfiliacionesOrdenantes> mgAfiliacionesOrdenantes = null;
        List<DetalleAfiliacionesDTO> mgDetalleAfiliacionesDTO = new ArrayList<>();
        List<DetalleAfiliacionesDTO> mgDetalleAfiliacionesDTOAux = new ArrayList<>();
        List<DetalleAfiliacionesDTO> data = new ArrayList<>();
        try {
            StringBuilder consulta = new StringBuilder();
            consulta.append(" SELECT b FROM MgAfiliacionesOrdenantes b ");
            consulta.append(" WHERE  b.grupo = :grupo");
            consulta.append(" and  b.codigoOrdenante = :codigoOrdenante");
//            consulta.append(" WHERE  b.secuenciaLote = :secuenciaLote");Verificar
  
            mgAfiliacionesOrdenantes = (List<MgAfiliacionesOrdenantes>) em.createQuery(consulta.toString())
                    
                    .setParameter("grupo", numLote)
                    .setParameter("codigoOrdenante", Long.valueOf(codOrdenante))
//                    .setParameter("secuenciaLote", numLote)
                    .getResultList();

        } catch (Exception e) {
            throw e;
        }
        
        for (MgAfiliacionesOrdenantes mgAfiliacionesOrdenante : mgAfiliacionesOrdenantes) {

            String linea = mgAfiliacionesOrdenante.getMgAfiliacionesOrdenantesPK().getRegistro();
            DetalleAfiliacionesDTO  detAfi = new DetalleAfiliacionesDTO();
            if(mgAfiliacionesOrdenante.getFechaCarga() != null){
                detAfi.setSwOrdenantes(true);
            }else{
                detAfi.setSwOrdenantes(false);
            }            
            detAfi.setCodigoResultado(""+mgAfiliacionesOrdenante.getCodigoRechazo());
            detAfi.setContrato(linea.substring(87, linea.length()));
            detAfi.setCuentaPagador(linea.substring(37, (37+LONGITUD_DETALLE_CUENTA_PAGADOR)));
            detAfi.setIdentificacionPagador(linea.substring(25,  (25+LONGITUD_DETALLE_IDENTIFICADOR_PAGADOR)).trim());
            detAfi.setNombrePagador(linea.substring(57, (57+LONGITUD_DETALLE_NOMBRE_PAGADOR)).trim());
            detAfi.setTipoOperacion((linea.substring(23,  (23+LONGITUD_DETALLE_TIPO_OPERACION))));
            detAfi.setSituacion(mgAfiliacionesOrdenante.getSituacion());
            detAfi.setSwOrdenantes(true);
            mgDetalleAfiliacionesDTO.add(detAfi);
        }
        mgDetalleAfiliacionesDTOAux = this.BuscarAfiliadoPresentadas(numLote);
        boolean sw = false;
        if (mgDetalleAfiliacionesDTOAux.size() > 0) {
            for (DetalleAfiliacionesDTO detalleAfiliacionesDTO : mgDetalleAfiliacionesDTO) {
                for (DetalleAfiliacionesDTO detalleAfiliacionesDTOAux : mgDetalleAfiliacionesDTOAux) {
                    if(detalleAfiliacionesDTO.getIdentificacionPagador().equalsIgnoreCase(detalleAfiliacionesDTOAux.getIdentificacionPagador()) && detalleAfiliacionesDTO.getContrato().equalsIgnoreCase(detalleAfiliacionesDTOAux.getContrato())){
                        data.add(detalleAfiliacionesDTOAux);
                        sw = true;
                        break;
                    }
                }
                if(sw == false){
                    data.add(detalleAfiliacionesDTO);
                }
                sw = false;
            }
        }else{
            data.addAll(mgDetalleAfiliacionesDTO);
        }
        
        return data;
    }
    
    
    public List<DetalleAfiliacionesDTO> BuscarAfiliadoPresentadas(Long numLote) {
        
        List<MgAfiliacionesPresentadas> mgAfiliacionesPresentadas = null;
        List<DetalleAfiliacionesDTO> mgDetalleAfiliacionesDTO = new ArrayList<>();
        try {
            StringBuilder consulta = new StringBuilder();
            consulta.append(" SELECT b FROM MgAfiliacionesPresentadas b ");
            consulta.append(" WHERE  b.grupo = :grupo");
//            consulta.append(" WHERE  b.secuenciaLote = :secuenciaLote");
  
            mgAfiliacionesPresentadas = (List<MgAfiliacionesPresentadas>) em.createQuery(consulta.toString())
                    
                    .setParameter("grupo", numLote)
//                    .setParameter("secuenciaLote", numLote)
                    .getResultList();

        } catch (Exception e) {
            throw e;
        }
        
        for (MgAfiliacionesPresentadas mgAfiliacionesPresentada : mgAfiliacionesPresentadas) {

            String linea = mgAfiliacionesPresentada.getRegistroOrdenante();
            DetalleAfiliacionesDTO  detAfi = new DetalleAfiliacionesDTO();         
            detAfi.setContrato(linea.substring(87, linea.length()));
            detAfi.setCuentaPagador(linea.substring(37, (37+LONGITUD_DETALLE_CUENTA_PAGADOR)));
            detAfi.setIdentificacionPagador(linea.substring(25,  (25+LONGITUD_DETALLE_IDENTIFICADOR_PAGADOR)).trim());
            detAfi.setNombrePagador(linea.substring(57, (57+LONGITUD_DETALLE_NOMBRE_PAGADOR)).trim());
            detAfi.setTipoOperacion((linea.substring(23,  (23+LONGITUD_DETALLE_TIPO_OPERACION))));
            detAfi.setSituacion(mgAfiliacionesPresentada.getCodigoResultado()); 
            detAfi.setSwOrdenantes(false);
            mgDetalleAfiliacionesDTO.add(detAfi);
        }
        return mgDetalleAfiliacionesDTO;
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

    public MgParametrosOrdenantes BuscarEmpresaOrdenanteByRif(String numDocumento) {
        MgParametrosOrdenantes mgParametrosOrdenante = null;
        if ((numDocumento == null)) {
            numDocumento = "";
        }

        try {
            StringBuilder consulta = new StringBuilder();
            consulta.append(" SELECT b FROM MgParametrosOrdenantes b ");
            consulta.append(" WHERE b.rifOrdenante = :rifOrdenante ");
            mgParametrosOrdenante = (MgParametrosOrdenantes) em.createQuery(consulta.toString())
                    .setParameter("rifOrdenante", numDocumento)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            mgParametrosOrdenante = new MgParametrosOrdenantes();
        }

        return mgParametrosOrdenante;
    }
    
    public List<DetalleAfiliacionesDTO> BuscarAfiliadoPresentadasByOrdenante(String codigoOrdenante) {
        List<MgAfiliacionesPresentadas> mgAfiliacionesPresentadas = null;
        List<DetalleAfiliacionesDTO> mgDetalleAfiliacionesDTO = new ArrayList<>();
        try {
            StringBuilder consulta = new StringBuilder();
            consulta.append(" SELECT b FROM MgAfiliacionesPresentadas b ");
            consulta.append(" WHERE  b.codigoOrdenante = :codigoOrdenante and b.codigoResultado = 'P'");
  
            mgAfiliacionesPresentadas = (List<MgAfiliacionesPresentadas>) em.createQuery(consulta.toString())
                    .setParameter("codigoOrdenante", codigoOrdenante)
                    .getResultList();

        } catch (Exception e) {
            throw e;
        }
        for (MgAfiliacionesPresentadas mgAfiliacionesPresentada : mgAfiliacionesPresentadas) {

            String linea = mgAfiliacionesPresentada.getRegistroOrdenante();
            DetalleAfiliacionesDTO  detAfi = new DetalleAfiliacionesDTO();         
            detAfi.setContrato(mgAfiliacionesPresentada.getContrato());
            detAfi.setCuentaPagador(linea.substring(37, (37+LONGITUD_DETALLE_CUENTA_PAGADOR)));
            detAfi.setIdentificacionPagador(linea.substring(25,  (25+LONGITUD_DETALLE_IDENTIFICADOR_PAGADOR)).trim());
            detAfi.setNombrePagador(linea.substring(57, (57+LONGITUD_DETALLE_NOMBRE_PAGADOR)).trim());
            detAfi.setTipoOperacion((linea.substring(23,  (23+LONGITUD_DETALLE_TIPO_OPERACION))));
            detAfi.setSituacion(mgAfiliacionesPresentada.getCodigoResultado()); 
            detAfi.setSwOrdenantes(false);
            mgDetalleAfiliacionesDTO.add(detAfi);
        }
        return mgDetalleAfiliacionesDTO;
    }

}
