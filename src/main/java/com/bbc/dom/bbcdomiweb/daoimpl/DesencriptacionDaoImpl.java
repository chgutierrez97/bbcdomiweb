/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.daoimpl;

import com.bbc.dom.bbcdomiweb.dao.DesencriptacionDao;
import com.bbc.dom.bbcdomiweb.dto.ClienteDTO;
import com.bbc.dom.bbcdomiweb.dto.SesionDTO;
import com.bbc.dom.bbcdomiweb.model.IbSesionDomiciliaciones;
import com.bbc.dom.bbcdomiweb.model.MgParametrosOrdenantes;
import com.bbc.dom.bbcdomiweb.repository.SesionRepository;
import java.util.Base64;
import java.util.StringTokenizer;
import java.util.logging.Level;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Sinergia
 */
@Service
public class DesencriptacionDaoImpl implements DesencriptacionDao {

    private static final Logger LOGGER = Logger.getLogger(DesencriptacionDaoImpl.class);
    private static final String CIPHER_NAME = "Blowfish/CBC/PKCS5PADDING";
    private static final int CIPHER_KEY_LEN = 16;
    private static final String key = "qwerty";
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("bcdomicPU");
    EntityManager em = emf.createEntityManager();

    @Override
    public String desencriptar(String Semilla) {
        String hashB24;
        ClienteDTO cdto = null;
        String b24Decodificado;
        JsonObject jsonObject;
        String token;
        String desencriptadoBlowfish;
        String desencriptadoBlowfishBase64Decode = null;
        String rif = null;
        try {
            b24Decodificado = decodificarBase24(Semilla);
            java.util.logging.Logger.getLogger("GESTOR DE INTEGRACION, RESULTADO DE DECODIFICACION BASE24 " + b24Decodificado + "\\r"/*+cal.getFechaDDMMYYYString()+" "+cal.getHoraHHMMSSAAPM_SMS()*/);
            jsonObject = decodificarObjetoJSON(b24Decodificado);
            System.out.println("Objeto JSON es: " + jsonObject.toString());
            token = getTokenDashboardBase64(jsonObject);
            System.out.println("TOKEN BASE64: " + token);
            String claveRandom = getClaveRandomDashboardBase64(jsonObject);
            System.out.println("CLAVE RANDOM IV BASE64: " + claveRandom);
            System.out.println("INICIANDO PROCESO DE DESENCRIPCION BLOWFISH");
            desencriptadoBlowfish = this.desencriptacionBlowfish(key, token, claveRandom);
            System.out.println("RESULTADO DE DESCRIPCION " + desencriptadoBlowfish);
            System.out.println("INICIANDO BLOWFISH 64 DECODE");
            desencriptadoBlowfishBase64Decode = decodificarBase24(desencriptadoBlowfish);
            System.out.println("RESULTADO BLOWFISH 64 DECODE: " + desencriptadoBlowfishBase64Decode);
            rif = parserObjetoJsonDesencriptado(desencriptadoBlowfishBase64Decode).getCedulaRif();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(DesencriptacionDaoImpl.class.getName()).log(Level.SEVERE, "Semilla inválida", ex);
            desencriptadoBlowfishBase64Decode = "Semilla inválida";
        }
        return rif;

    }

    public String decodificarBase24(String hashDashboard) {
//		cal = new Calendario();
        String decodificado = "";
        LOGGER.info("GESTOR DE INTEGRACION, INICIO DE PROCESO DECO BASE24 "/*+cal.getFechaDDMMYYYString()+" "+cal.getHoraHHMMSSAAPM_SMS()*/);
        byte[] decodedBytes = Base64.getDecoder().decode(hashDashboard);
        decodificado = new String(decodedBytes);
        LOGGER.info("GESTOR DE INTEGRACION, FIN DE PROCESO DECO BASE24 "/*+cal.getFechaDDMMYYYString()+" "+cal.getHoraHHMMSSAAPM_SMS()*/);
        return decodificado;
    }

    public JsonObject decodificarObjetoJSON(String hashBase24Decodificado) throws Exception {
        JsonObject jsonObject = null;
//		cal = new Calendario();
        LOGGER.info("GESTOR DE INTEGRACION, INICIO DE PROCESO DECO JSON "/*+cal.getFechaDDMMYYYString()+" "+cal.getHoraHHMMSSAAPM_SMS()*/);
        jsonObject = new JsonParser().parse(hashBase24Decodificado).getAsJsonObject();
        if (jsonObject == null) {
            throw new Exception("ERROR EN DECODIFICAR JSON DE HASHBASE24 PASADO COMO PARAMETROS");
        }
        LOGGER.info("GESTOR DE INTEGRACION, FIN DE PROCESO DECO JSON "/*+cal.getFechaDDMMYYYString()+" "+cal.getHoraHHMMSSAAPM_SMS()*/);
        return jsonObject;
    }

    public static String getTokenDashboardBase64(com.google.gson.JsonObject jsonObject) {
        String token = "";
//		cal = new Calendario();
        try {
            LOGGER.info("JSON OBJECT RECIBIDO " + jsonObject.toString() + "\r" + "-->FECHA: "/*+cal.getFechaDDMMYYYString()+" "+cal.getHoraHHMMSSAAPM_SMS()*/);
            token = jsonObject.get("encrypted_data").getAsString();
        } catch (Exception e) {
            LOGGER.error("ERROR, GESTOR DE INTEGRACION, NO SE PUEDE OBTENER ELEMENTO encrypted_data " + e + "\r" + "-->FECHA: "/*+cal.getFechaDDMMYYYString()+" "+cal.getHoraHHMMSSAAPM_SMS()*/);
            throw e;
        }

        return token;
    }

    public String getClaveRandomDashboardBase64(JsonObject jsonObject) {
        String clave = "";
//		cal = new Calendario();
        try {
            LOGGER.info("JSON OBJECT RECIBIDO " + jsonObject.toString() + "\r" + "-->FECHA: "/*+cal.getFechaDDMMYYYString()+" "+cal.getHoraHHMMSSAAPM_SMS()*/);
            clave = jsonObject.get("iv").getAsString();
        } catch (Exception e) {
            LOGGER.error("ERROR, GESTOR DE INTEGRACION, NO SE PUEDE OBTENER ELEMENTO IV " + e + "\r" + "-->FECHA: "/*+cal.getFechaDDMMYYYString()+" "+cal.getHoraHHMMSSAAPM_SMS()*/);
            throw e;
        }

        return clave;
    }

    public static String desencriptacionBlowfish(String key, String encrypted_data, String iv) {
        LOGGER.info("DENTRO DE PROCESO DESENCRIPTACION FINHACK");
        try {
            LOGGER.info("PARAMETRO CLAVE " + key);
            LOGGER.info("PARAMETRO DATA A DESENCRIPTAR " + encrypted_data);
            LOGGER.info("PARAMETRO IV A DESENCRIPTAR " + iv);
            IvParameterSpec parametroIV = new IvParameterSpec(Base64.getDecoder().decode(iv));
            SecretKeySpec clave = new SecretKeySpec(acomodarkey(key).getBytes("UTF-8"), "Blowfish");
            Cipher cifrado = Cipher.getInstance(CIPHER_NAME);
            cifrado.init(Cipher.DECRYPT_MODE, clave, parametroIV);

            byte[] dataDecodificada = Base64.getDecoder().decode(encrypted_data);

            byte[] dataDesencriptada = cifrado.doFinal(dataDecodificada);

            return new String(dataDesencriptada);
        } catch (Exception ex) {
            LOGGER.error("Error en proceso desencripcion de finhack " + ex);
            throw new RuntimeException(ex);
        }
    }

    private static String acomodarkey(String key) {
        if (key.length() < CIPHER_KEY_LEN) {
            int numPad = CIPHER_KEY_LEN - key.length();
            for (int i = 0; i < numPad; i++) {
                key += "0";
            }
            return key;
        }
        if (key.length() > CIPHER_KEY_LEN) {
            return key.substring(0, CIPHER_KEY_LEN);
        }
        return key;
    }

    public ClienteDTO parserObjetoJsonDesencriptado(String dataDesencriptada) throws Exception {
        ClienteDTO cdto = null;
//		cal = new Calendario();
        String aux = "";
        int i = 0;
        try {
            LOGGER.info("REALIZANDO PARSER DE DATA RECIBIDA " + dataDesencriptada + "\r" + "-->FECHA: "/*+cal.getFechaDDMMYYYString()+" "+cal.getHoraHHMMSSAAPM_SMS()*/);
            cdto = new ClienteDTO();
            StringTokenizer st = new StringTokenizer(dataDesencriptada, ":");
            LOGGER.info("INCIANDO PARSER CON DELIMITADOR :");
            while (st.hasMoreTokens()) {
                i++;
                aux = st.nextToken();
                //LOGGER.info("token nro "+i+" = "+aux);
                if (i == 7) {
                    cdto.setToken(aux.substring(0, aux.length() - 2).replace('"', ' ').trim());
                    LOGGER.info("token de sesion de usuario es " + cdto.getToken());
                }
                if (i == 11) {
                    cdto.setUserID(aux.substring(0, aux.length() - 2).replace('"', ' ').trim());
                    LOGGER.info("user id de usuario es " + cdto.getUserID());
                }
                if (i == 15) {
                    cdto.setNombre(new String(aux.substring(0, aux.length() - 2).replace('"', ' ').trim().getBytes(), "ISO-8859-1"));
                    LOGGER.info("nombre de usuario es " + cdto.getNombre());
                }
                if (i == 19) {
                    cdto.setCedulaRif(aux.substring(0, aux.length() - 2).replace('"', ' ').trim());
                    LOGGER.info("cedula/rif de usuario es " + cdto.getCedulaRif());
                }
                if (i == 23) {
                    cdto.setCorreo(aux.substring(0, aux.length() - 2).replace('"', ' ').trim());
                    LOGGER.info("correo de usuario es " + cdto.getCorreo());
                }
                if (i == 33) {
                    cdto.setNroAbank(aux.substring(0, aux.length() - 2).replace('"', ' ').trim());
                    LOGGER.info("nro abank de usuario es " + cdto.getNroAbank());
                }
                if (i == 47) {
                    cdto.setTelefono(aux.substring(0, aux.length() - 2).replace('"', ' ').trim());
                    String aux2 = cdto.getTelefono();
                    cdto.setTelefono("0" + aux2.substring(2, aux2.length()));
                    LOGGER.info("telefono de usuario es " + cdto.getTelefono());
                }
                if (i == 51) {
                    cdto.setPlataformDeSesion(aux.substring(0, aux.length() - 2).replace('"', ' ').trim());
                    LOGGER.info("plataforma de sesion de usuario es " + cdto.getPlataformDeSesion());
                }
                if (i == 55) {
                    cdto.setCanalDeSesion(aux.substring(0, aux.length() - 2).replace('"', ' ').trim());
                    LOGGER.info("canal de sesion de usuario es " + cdto.getCanalDeSesion());
                }
                if (i == 59) {
                    cdto.setCodigoSubaplicacion(aux.substring(0, aux.length() - 2).replace('"', ' ').trim());
                    LOGGER.info("codigo de subaplicacion de usuario es " + cdto.getCodigoSubaplicacion());
                }
            }
        } catch (Exception e) {
            LOGGER.error("ERROR, GESTOR DE INTEGRACION, NO SE PUEDE OBTENER ELEMENTO DE SESION DEL CLIENTE DASHBOARD " + e + "\r" + "-->FECHA: "/*+cal.getFechaDDMMYYYString()+" "+cal.getHoraHHMMSSAAPM_SMS()*/);
            throw e;
        }

        return cdto;
    }

    @Override
    public String getCodigoOrdenante(String rif) {
        MgParametrosOrdenantes mgParametrosOrdenantes = null;
        try {
            StringBuilder consulta = new StringBuilder();
            consulta.append(" SELECT m FROM MgParametrosOrdenantes m ");
            consulta.append(" WHERE m.rifOrdenante = :rifOrdenante");

            mgParametrosOrdenantes = (MgParametrosOrdenantes) em.createQuery(consulta.toString())
                    .setParameter("rifOrdenante", rif.trim())
                    .getSingleResult();
        } catch (Exception e) {
            LOGGER.info(e);
        }
        if (mgParametrosOrdenantes != null) {
            return mgParametrosOrdenantes.getCodigoOrdenante().toString();
        }
        return null;
    }

    @Override
    public boolean insertNewSesion(SesionDTO sesion) {
        IbSesionDomiciliaciones ibSesionDomiciliaciones = new IbSesionDomiciliaciones();
        SesionRepository sr = new SesionRepository();
        try {
            ibSesionDomiciliaciones = this.getIdByRif(sesion.getIdentificacionPagador());
            ibSesionDomiciliaciones.setCodigoOrdenante(sesion.getCodigoOrdenante());
            ibSesionDomiciliaciones.setIdentificacionPagador(sesion.getIdentificacionPagador());
            ibSesionDomiciliaciones.setEstatus("1");
            ibSesionDomiciliaciones.setFechaInicio(new Date());
            ibSesionDomiciliaciones.setFechaFin(null);
            ibSesionDomiciliaciones.setFechaMantenimiento(null);
            sr.setEntityManager(em);
            sr.persist(ibSesionDomiciliaciones);
        } catch (Exception e) {
            LOGGER.info("Error al insertar nueva sesion" + e);
            return false;
        }
        return true;
    }

    @Override
    public boolean closeSesion(SesionDTO sesion) {
        IbSesionDomiciliaciones ibSesionDomiciliaciones = new IbSesionDomiciliaciones();
        SesionRepository sr = new SesionRepository();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Date date = new Date();
        String dateString = dateFormat.format(date);
        try {
            ibSesionDomiciliaciones = this.getIdByRif(sesion.getIdentificacionPagador());
            if (ibSesionDomiciliaciones != null && ibSesionDomiciliaciones.getEstatus().equals("1")) {
                ibSesionDomiciliaciones.setEstatus("0");
                ibSesionDomiciliaciones.setFechaFin(new Date());
                sr.setEntityManager(em);
                sr.persist(ibSesionDomiciliaciones);
            } else {
                return false;
            }
        } catch (Exception e) {
            LOGGER.info("Error al cerrar sesion" + e);
            return false;
        }
        return true;
    }
   
    @Override
    public boolean mantenimientoSesion(SesionDTO sesion) {
        IbSesionDomiciliaciones ibSesionDomiciliaciones = new IbSesionDomiciliaciones();
        SesionRepository sr = new SesionRepository();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Date date = new Date();
        String dateString = dateFormat.format(date);
        try {
            ibSesionDomiciliaciones = this.getIdByRif(sesion.getIdentificacionPagador());
            if (ibSesionDomiciliaciones != null && ibSesionDomiciliaciones.getEstatus().equals("1")) {
                ibSesionDomiciliaciones.setEstatus("1");
                ibSesionDomiciliaciones.setFechaMantenimiento(new Date());
                sr.setEntityManager(em);
                sr.persist(ibSesionDomiciliaciones);
            } else {
                return false;
            }
        } catch (Exception e) {
            LOGGER.info("Error al actualizar la sesion" + e);
            return false;
        }
        return true;
    }

    public IbSesionDomiciliaciones getIdByRif(String rif) {
        IbSesionDomiciliaciones ibSesionDomiciliaciones = null;
        try {
            StringBuilder consulta = new StringBuilder();
            consulta.append(" SELECT i FROM IbSesionDomiciliaciones i ");
            consulta.append(" WHERE i.identificacionPagador = :identificacionPagador");
            ibSesionDomiciliaciones = (IbSesionDomiciliaciones) em.createQuery(consulta.toString())
                    .setParameter("identificacionPagador", rif.trim())
                    .getSingleResult();
        } catch (Exception e) {
            LOGGER.info(e);
        }
        if (ibSesionDomiciliaciones != null) {
            return ibSesionDomiciliaciones;
        }
        return new IbSesionDomiciliaciones();
    }

}
