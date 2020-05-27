/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.daoimpl;

import com.bbc.dom.bbcdomiweb.dao.DesencriptacionDao;
import com.bbc.dom.bbcdomiweb.dto.ClienteDTO;
import com.bbc.dom.bbcdomiweb.dto.LogDTO;
import com.bbc.dom.bbcdomiweb.dto.SesionDTO;
import com.bbc.dom.bbcdomiweb.model.IbSesionDomiciliaciones;
import com.bbc.dom.bbcdomiweb.model.MgParametrosOrdenantes;
import com.bbc.dom.bbcdomiweb.repository.SesionRepository;
import com.bbc.dom.bbcdomiweb.util.Util;
import java.util.Base64;
import java.util.StringTokenizer;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.stereotype.Service;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author Sinergia
 */
@Service
public class DesencriptacionDaoImpl implements DesencriptacionDao {

    private final static Logger LOGGER = Logger.getLogger(DesencriptacionDaoImpl.class.getName());
    private static final String CIPHER_NAME = "Blowfish/CBC/PKCS5PADDING";
    private static final int CIPHER_KEY_LEN = 16;
    private static final String key = "qwerty";
    private static final String Success = "Success";
    private static final String Fail = "Fail";
    private Util util = new Util();
    private LogDTO.LogTableDTO logTable = new LogDTO.LogTableDTO("", "", "");
    String clase = DesencriptacionDaoImpl.class.getName();
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
            jsonObject = decodificarObjetoJSON(b24Decodificado);
            token = getTokenDashboardBase64(jsonObject);
            String claveRandom = getClaveRandomDashboardBase64(jsonObject);
            desencriptadoBlowfish = this.desencriptacionBlowfish(key, token, claveRandom);
            desencriptadoBlowfishBase64Decode = decodificarBase24(desencriptadoBlowfish);
            rif = parserObjetoJsonDesencriptado(desencriptadoBlowfishBase64Decode).getCedulaRif();
            LOGGER.info(util.createLog(Level.INFO.toString(), Success, "Semilla válida", "", clase, logTable));
        } catch (Exception ex) {
            LOGGER.info(util.createLog(Level.SEVERE.toString(), Fail, "Semilla inválida", ex.getMessage(), clase, logTable));
        }
        return rif;
    }

    @Override
    public ClienteDTO desencriptar2(String Semilla, LogDTO.LogTableDTO logTable) {
        this.logTable = logTable;
        String hashB24;
        ClienteDTO cdto = null;
        String b24Decodificado;
        JsonObject jsonObject;
        String token;
        String desencriptadoBlowfish;
        String desencriptadoBlowfishBase64Decode = null;
        ClienteDTO cliente = null;
        try {
            b24Decodificado = decodificarBase24(Semilla);
            jsonObject = decodificarObjetoJSON(b24Decodificado);
            token = getTokenDashboardBase64(jsonObject);
            String claveRandom = getClaveRandomDashboardBase64(jsonObject);
            desencriptadoBlowfish = this.desencriptacionBlowfish(key, token, claveRandom);
            desencriptadoBlowfishBase64Decode = decodificarBase24(desencriptadoBlowfish);
            cliente = parserObjetoJsonDesencriptado(desencriptadoBlowfishBase64Decode);
            LOGGER.info(util.createLog(Level.INFO.toString(), Success, "Semilla válida", "", clase, logTable));
        } catch (Exception ex) {
            LOGGER.info(util.createLog(Level.SEVERE.toString(), Fail, "Semilla inválida", ex.getMessage(), clase, logTable));
        }
        return cliente;
    }

    public String decodificarBase24(String hashDashboard) {
        String decodificado = "";
        byte[] decodedBytes = Base64.getDecoder().decode(hashDashboard);
        decodificado = new String(decodedBytes);
        return decodificado;
    }

    public JsonObject decodificarObjetoJSON(String hashBase24Decodificado) throws Exception {
        JsonObject jsonObject = null;
        jsonObject = new JsonParser().parse(hashBase24Decodificado).getAsJsonObject();
        if (jsonObject == null) {
            LOGGER.info(util.createLog(Level.SEVERE.toString(), Fail, "Error en decodificar JSON de HASHBASE24", "", clase, logTable));
        }
        return jsonObject;
    }

    public String getTokenDashboardBase64(com.google.gson.JsonObject jsonObject) {
        String token = "";
        try {
            token = jsonObject.get("encrypted_data").getAsString();
        } catch (Exception e) {
            LOGGER.info(util.createLog(Level.SEVERE.toString(), Fail, "No se puede obtenerelemento encrypted_data", e.getMessage(), clase, logTable));
        }
        return token;
    }

    public String getClaveRandomDashboardBase64(JsonObject jsonObject) {
        String clave = "";
        try {
            clave = jsonObject.get("iv").getAsString();
        } catch (Exception e) {
            LOGGER.info(util.createLog(Level.SEVERE.toString(), Fail, "No se puede obtenerelemento IV", e.getMessage(), clase, logTable));
        }
        return clave;
    }

    public String desencriptacionBlowfish(String key, String encrypted_data, String iv) {
        byte[] dataDesencriptada = null;
        try {
            LOGGER.info("PARAMETRO CLAVE " + key);
            LOGGER.info("PARAMETRO DATA A DESENCRIPTAR " + encrypted_data);
            LOGGER.info("PARAMETRO IV A DESENCRIPTAR " + iv);
            IvParameterSpec parametroIV = new IvParameterSpec(Base64.getDecoder().decode(iv));
            SecretKeySpec clave = new SecretKeySpec(acomodarkey(key).getBytes("UTF-8"), "Blowfish");
            Cipher cifrado = Cipher.getInstance(CIPHER_NAME);
            cifrado.init(Cipher.DECRYPT_MODE, clave, parametroIV);
            byte[] dataDecodificada = Base64.getDecoder().decode(encrypted_data);
            dataDesencriptada = cifrado.doFinal(dataDecodificada);
        } catch (Exception ex) {
            LOGGER.info(util.createLog(Level.SEVERE.toString(), Fail, "Error en proceso desencripcion", ex.getMessage(), clase, logTable));
        }
        return new String(dataDesencriptada);
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
        String aux = "";
        int i = 0;
        try {
            cdto = new ClienteDTO();
            StringTokenizer st = new StringTokenizer(dataDesencriptada, ":");
            while (st.hasMoreTokens()) {
                i++;
                aux = st.nextToken();
                if (i == 7) {
                    cdto.setToken(aux.substring(0, aux.length() - 2).replace('"', ' ').trim());
                }
                if (i == 11) {
                    cdto.setUserID(aux.substring(0, aux.length() - 2).replace('"', ' ').trim());
                }
                if (i == 15) {
                    cdto.setNombre(new String(aux.substring(0, aux.length() - 2).replace('"', ' ').trim().getBytes(), "ISO-8859-1"));
                }
                if (i == 19) {
                    cdto.setCedulaRif(aux.substring(0, aux.length() - 2).replace('"', ' ').trim());
                }
                if (i == 23) {
                    cdto.setCorreo(aux.substring(0, aux.length() - 2).replace('"', ' ').trim());
                }
                if (i == 33) {
                    cdto.setNroAbank(aux.substring(0, aux.length() - 2).replace('"', ' ').trim());
                }
                if (i == 47) {
                    cdto.setTelefono(aux.substring(0, aux.length() - 2).replace('"', ' ').trim());
                    String aux2 = cdto.getTelefono();
                    cdto.setTelefono("0" + aux2.substring(2, aux2.length()));
                }
                if (i == 51) {
                    cdto.setPlataformDeSesion(aux.substring(0, aux.length() - 2).replace('"', ' ').trim());
                }
                if (i == 55) {
                    cdto.setCanalDeSesion(aux.substring(0, aux.length() - 2).replace('"', ' ').trim());
                }
                if (i == 59) {
                    cdto.setCodigoSubaplicacion(aux.substring(0, aux.length() - 2).replace('"', ' ').trim());
                }
            }
        } catch (Exception e) {
            LOGGER.info(util.createLog(Level.SEVERE.toString(), Fail, "NO SE PUEDE OBTENER ELEMENTO DE SESION DEL CLIENTE DASHBOARD", e.getMessage(), clase, logTable));
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
            LOGGER.info(util.createLog(Level.SEVERE.toString(), Fail, "Error obteniendo el código ordenante", e.getMessage(), clase, logTable));
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
            LOGGER.info(util.createLog(Level.SEVERE.toString(), Fail, "Error al insertar la nueva sesión", e.getMessage(), clase, logTable));
            return false;
        }
        LOGGER.info(util.createLog(Level.INFO.toString(), Success, "Sesion nueva creada", "", clase, logTable));
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
            LOGGER.info(util.createLog(Level.SEVERE.toString(), Fail, "Error al cerrar la sesión", e.getMessage(), clase, logTable));
            return false;
        }
        LOGGER.info(util.createLog(Level.INFO.toString(), Success, "Sesion cerrada correctamente", "", clase, logTable));
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
            LOGGER.info(util.createLog(Level.SEVERE.toString(), Fail, "Error al actualizar la sesión", e.getMessage(), clase, logTable));
            return false;
        }
        LOGGER.info(util.createLog(Level.INFO.toString(), Success, "Sesion Actualizada Correctamente", "", clase, logTable));
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
            LOGGER.info(util.createLog(Level.SEVERE.toString(), Fail, "Error obteniendo el id de la sesión", e.getMessage(), clase, logTable));
        }
        if (ibSesionDomiciliaciones != null) {
            return ibSesionDomiciliaciones;
        }
        return new IbSesionDomiciliaciones();
    }

    @Override
    public String encrypIp(String mensaje) {
        try {
            char array[] = mensaje.toCharArray();
            for (int i = 0; i < array.length; i++) {
                array[i] = (char) (array[i] + (char) 5);
            }
            return String.valueOf(array);
        } catch (Exception ex) {
            LOGGER.info("Falló encriptación SNG");
        }
        return "";
    }
    
    @Override
    public String desencrypIp(String mensaje) {
        try {
            char array[] = mensaje.toCharArray();
            for (int i = 0; i < array.length; i++) {
                array[i] = (char) (array[i] - (char) 5);
            }
            return String.valueOf(array);
        } catch (Exception ex) {
            LOGGER.info("Falló encriptación SNG");
        }
        return "";
    }
}
