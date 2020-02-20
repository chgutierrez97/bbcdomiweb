/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Christian Gutierrez
 */
@Entity
@Table(name = "MG_CLIENTES_PEP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MgClientesPep.findAll", query = "SELECT m FROM MgClientesPep m")
    , @NamedQuery(name = "MgClientesPep.findByCodigoCliente", query = "SELECT m FROM MgClientesPep m WHERE m.mgClientesPepPK.codigoCliente = :codigoCliente")
    , @NamedQuery(name = "MgClientesPep.findByCodigoTipoPep", query = "SELECT m FROM MgClientesPep m WHERE m.mgClientesPepPK.codigoTipoPep = :codigoTipoPep")
    , @NamedQuery(name = "MgClientesPep.findByCodigoTipoIdPep", query = "SELECT m FROM MgClientesPep m WHERE m.codigoTipoIdPep = :codigoTipoIdPep")
    , @NamedQuery(name = "MgClientesPep.findByNumeroIdentifPep", query = "SELECT m FROM MgClientesPep m WHERE m.mgClientesPepPK.numeroIdentifPep = :numeroIdentifPep")
    , @NamedQuery(name = "MgClientesPep.findByNombres", query = "SELECT m FROM MgClientesPep m WHERE m.nombres = :nombres")
    , @NamedQuery(name = "MgClientesPep.findByApellidos", query = "SELECT m FROM MgClientesPep m WHERE m.apellidos = :apellidos")
    , @NamedQuery(name = "MgClientesPep.findByFechaNacimiento", query = "SELECT m FROM MgClientesPep m WHERE m.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "MgClientesPep.findByLugarNacimiento", query = "SELECT m FROM MgClientesPep m WHERE m.lugarNacimiento = :lugarNacimiento")
    , @NamedQuery(name = "MgClientesPep.findBySexo", query = "SELECT m FROM MgClientesPep m WHERE m.sexo = :sexo")
    , @NamedQuery(name = "MgClientesPep.findByCodigoPaisNac", query = "SELECT m FROM MgClientesPep m WHERE m.codigoPaisNac = :codigoPaisNac")
    , @NamedQuery(name = "MgClientesPep.findByCodigoPaisNacOtro", query = "SELECT m FROM MgClientesPep m WHERE m.codigoPaisNacOtro = :codigoPaisNacOtro")
    , @NamedQuery(name = "MgClientesPep.findByCodigoProfesion", query = "SELECT m FROM MgClientesPep m WHERE m.codigoProfesion = :codigoProfesion")
    , @NamedQuery(name = "MgClientesPep.findByCodigoPais", query = "SELECT m FROM MgClientesPep m WHERE m.codigoPais = :codigoPais")
    , @NamedQuery(name = "MgClientesPep.findByCodigoDepartamento", query = "SELECT m FROM MgClientesPep m WHERE m.codigoDepartamento = :codigoDepartamento")
    , @NamedQuery(name = "MgClientesPep.findByCodigoMunicipio", query = "SELECT m FROM MgClientesPep m WHERE m.codigoMunicipio = :codigoMunicipio")
    , @NamedQuery(name = "MgClientesPep.findByCoigoSector", query = "SELECT m FROM MgClientesPep m WHERE m.coigoSector = :coigoSector")
    , @NamedQuery(name = "MgClientesPep.findByZona", query = "SELECT m FROM MgClientesPep m WHERE m.zona = :zona")
    , @NamedQuery(name = "MgClientesPep.findByUrbanizacion", query = "SELECT m FROM MgClientesPep m WHERE m.urbanizacion = :urbanizacion")
    , @NamedQuery(name = "MgClientesPep.findByCalle", query = "SELECT m FROM MgClientesPep m WHERE m.calle = :calle")
    , @NamedQuery(name = "MgClientesPep.findByEdificioResidencia", query = "SELECT m FROM MgClientesPep m WHERE m.edificioResidencia = :edificioResidencia")
    , @NamedQuery(name = "MgClientesPep.findByNroCasaApartamento", query = "SELECT m FROM MgClientesPep m WHERE m.nroCasaApartamento = :nroCasaApartamento")
    , @NamedQuery(name = "MgClientesPep.findByManzanaPisoSector", query = "SELECT m FROM MgClientesPep m WHERE m.manzanaPisoSector = :manzanaPisoSector")
    , @NamedQuery(name = "MgClientesPep.findByApartadoPostal", query = "SELECT m FROM MgClientesPep m WHERE m.apartadoPostal = :apartadoPostal")
    , @NamedQuery(name = "MgClientesPep.findByTelefono", query = "SELECT m FROM MgClientesPep m WHERE m.telefono = :telefono")
    , @NamedQuery(name = "MgClientesPep.findByCelular", query = "SELECT m FROM MgClientesPep m WHERE m.celular = :celular")
    , @NamedQuery(name = "MgClientesPep.findByEmail", query = "SELECT m FROM MgClientesPep m WHERE m.email = :email")
    , @NamedQuery(name = "MgClientesPep.findByNombreEntePep", query = "SELECT m FROM MgClientesPep m WHERE m.nombreEntePep = :nombreEntePep")
    , @NamedQuery(name = "MgClientesPep.findByCargoEntePep", query = "SELECT m FROM MgClientesPep m WHERE m.cargoEntePep = :cargoEntePep")
    , @NamedQuery(name = "MgClientesPep.findByCodigoPaisEntePep", query = "SELECT m FROM MgClientesPep m WHERE m.codigoPaisEntePep = :codigoPaisEntePep")
    , @NamedQuery(name = "MgClientesPep.findByAdicionadoPor", query = "SELECT m FROM MgClientesPep m WHERE m.adicionadoPor = :adicionadoPor")
    , @NamedQuery(name = "MgClientesPep.findByFechaAdicion", query = "SELECT m FROM MgClientesPep m WHERE m.fechaAdicion = :fechaAdicion")
    , @NamedQuery(name = "MgClientesPep.findByModificadoPor", query = "SELECT m FROM MgClientesPep m WHERE m.modificadoPor = :modificadoPor")
    , @NamedQuery(name = "MgClientesPep.findByFechaModificacion", query = "SELECT m FROM MgClientesPep m WHERE m.fechaModificacion = :fechaModificacion")
    , @NamedQuery(name = "MgClientesPep.findByCodigoSector", query = "SELECT m FROM MgClientesPep m WHERE m.codigoSector = :codigoSector")})
public class MgClientesPep implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MgClientesPepPK mgClientesPepPK;
    @Column(name = "CODIGO_TIPO_ID_PEP")
    private Short codigoTipoIdPep;
    @Size(max = 50)
    @Column(name = "NOMBRES")
    private String nombres;
    @Size(max = 50)
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @Size(max = 50)
    @Column(name = "LUGAR_NACIMIENTO")
    private String lugarNacimiento;
    @Size(max = 1)
    @Column(name = "SEXO")
    private String sexo;
    @Column(name = "CODIGO_PAIS_NAC")
    private Short codigoPaisNac;
    @Column(name = "CODIGO_PAIS_NAC_OTRO")
    private Short codigoPaisNacOtro;
    @Column(name = "CODIGO_PROFESION")
    private Short codigoProfesion;
    @Column(name = "CODIGO_PAIS")
    private Short codigoPais;
    @Column(name = "CODIGO_DEPARTAMENTO")
    private Short codigoDepartamento;
    @Column(name = "CODIGO_MUNICIPIO")
    private Short codigoMunicipio;
    @Column(name = "COIGO_SECTOR")
    private Integer coigoSector;
    @Column(name = "ZONA")
    private Short zona;
    @Size(max = 30)
    @Column(name = "URBANIZACION")
    private String urbanizacion;
    @Size(max = 71)
    @Column(name = "CALLE")
    private String calle;
    @Size(max = 30)
    @Column(name = "EDIFICIO_RESIDENCIA")
    private String edificioResidencia;
    @Size(max = 10)
    @Column(name = "NRO_CASA_APARTAMENTO")
    private String nroCasaApartamento;
    @Size(max = 30)
    @Column(name = "MANZANA_PISO_SECTOR")
    private String manzanaPisoSector;
    @Column(name = "APARTADO_POSTAL")
    private Long apartadoPostal;
    @Size(max = 15)
    @Column(name = "TELEFONO")
    private String telefono;
    @Size(max = 15)
    @Column(name = "CELULAR")
    private String celular;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 40)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 50)
    @Column(name = "NOMBRE_ENTE_PEP")
    private String nombreEntePep;
    @Size(max = 50)
    @Column(name = "CARGO_ENTE_PEP")
    private String cargoEntePep;
    @Column(name = "CODIGO_PAIS_ENTE_PEP")
    private Short codigoPaisEntePep;
    @Size(max = 10)
    @Column(name = "ADICIONADO_POR")
    private String adicionadoPor;
    @Column(name = "FECHA_ADICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAdicion;
    @Size(max = 10)
    @Column(name = "MODIFICADO_POR")
    private String modificadoPor;
    @Column(name = "FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Column(name = "CODIGO_SECTOR")
    private Integer codigoSector;

    public MgClientesPep() {
    }

    public MgClientesPep(MgClientesPepPK mgClientesPepPK) {
        this.mgClientesPepPK = mgClientesPepPK;
    }

    public MgClientesPep(long codigoCliente, short codigoTipoPep, String numeroIdentifPep) {
        this.mgClientesPepPK = new MgClientesPepPK(codigoCliente, codigoTipoPep, numeroIdentifPep);
    }

    public MgClientesPepPK getMgClientesPepPK() {
        return mgClientesPepPK;
    }

    public void setMgClientesPepPK(MgClientesPepPK mgClientesPepPK) {
        this.mgClientesPepPK = mgClientesPepPK;
    }

    public Short getCodigoTipoIdPep() {
        return codigoTipoIdPep;
    }

    public void setCodigoTipoIdPep(Short codigoTipoIdPep) {
        this.codigoTipoIdPep = codigoTipoIdPep;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Short getCodigoPaisNac() {
        return codigoPaisNac;
    }

    public void setCodigoPaisNac(Short codigoPaisNac) {
        this.codigoPaisNac = codigoPaisNac;
    }

    public Short getCodigoPaisNacOtro() {
        return codigoPaisNacOtro;
    }

    public void setCodigoPaisNacOtro(Short codigoPaisNacOtro) {
        this.codigoPaisNacOtro = codigoPaisNacOtro;
    }

    public Short getCodigoProfesion() {
        return codigoProfesion;
    }

    public void setCodigoProfesion(Short codigoProfesion) {
        this.codigoProfesion = codigoProfesion;
    }

    public Short getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(Short codigoPais) {
        this.codigoPais = codigoPais;
    }

    public Short getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(Short codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public Short getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public void setCodigoMunicipio(Short codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public Integer getCoigoSector() {
        return coigoSector;
    }

    public void setCoigoSector(Integer coigoSector) {
        this.coigoSector = coigoSector;
    }

    public Short getZona() {
        return zona;
    }

    public void setZona(Short zona) {
        this.zona = zona;
    }

    public String getUrbanizacion() {
        return urbanizacion;
    }

    public void setUrbanizacion(String urbanizacion) {
        this.urbanizacion = urbanizacion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getEdificioResidencia() {
        return edificioResidencia;
    }

    public void setEdificioResidencia(String edificioResidencia) {
        this.edificioResidencia = edificioResidencia;
    }

    public String getNroCasaApartamento() {
        return nroCasaApartamento;
    }

    public void setNroCasaApartamento(String nroCasaApartamento) {
        this.nroCasaApartamento = nroCasaApartamento;
    }

    public String getManzanaPisoSector() {
        return manzanaPisoSector;
    }

    public void setManzanaPisoSector(String manzanaPisoSector) {
        this.manzanaPisoSector = manzanaPisoSector;
    }

    public Long getApartadoPostal() {
        return apartadoPostal;
    }

    public void setApartadoPostal(Long apartadoPostal) {
        this.apartadoPostal = apartadoPostal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreEntePep() {
        return nombreEntePep;
    }

    public void setNombreEntePep(String nombreEntePep) {
        this.nombreEntePep = nombreEntePep;
    }

    public String getCargoEntePep() {
        return cargoEntePep;
    }

    public void setCargoEntePep(String cargoEntePep) {
        this.cargoEntePep = cargoEntePep;
    }

    public Short getCodigoPaisEntePep() {
        return codigoPaisEntePep;
    }

    public void setCodigoPaisEntePep(Short codigoPaisEntePep) {
        this.codigoPaisEntePep = codigoPaisEntePep;
    }

    public String getAdicionadoPor() {
        return adicionadoPor;
    }

    public void setAdicionadoPor(String adicionadoPor) {
        this.adicionadoPor = adicionadoPor;
    }

    public Date getFechaAdicion() {
        return fechaAdicion;
    }

    public void setFechaAdicion(Date fechaAdicion) {
        this.fechaAdicion = fechaAdicion;
    }

    public String getModificadoPor() {
        return modificadoPor;
    }

    public void setModificadoPor(String modificadoPor) {
        this.modificadoPor = modificadoPor;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Integer getCodigoSector() {
        return codigoSector;
    }

    public void setCodigoSector(Integer codigoSector) {
        this.codigoSector = codigoSector;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mgClientesPepPK != null ? mgClientesPepPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MgClientesPep)) {
            return false;
        }
        MgClientesPep other = (MgClientesPep) object;
        if ((this.mgClientesPepPK == null && other.mgClientesPepPK != null) || (this.mgClientesPepPK != null && !this.mgClientesPepPK.equals(other.mgClientesPepPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbc.dom.bbcdomiweb.model.MgClientesPep[ mgClientesPepPK=" + mgClientesPepPK + " ]";
    }
    
}
