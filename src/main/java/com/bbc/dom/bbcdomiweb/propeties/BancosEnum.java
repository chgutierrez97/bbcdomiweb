/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.propeties;

/**
 *
 * @author Christian Gutierrez
 */
public enum BancosEnum {
    CienporcientoBanco(156, "100% Banco"),
    Bancamiga(172, "Bancamiga"),
    Bancaribe(114, "Bancaribe"),
    BancoDelPueblo(149, "Banco del Pueblo Soberano C.A."),
    BancoActivo(171, "Banco Activo"),
    BacoAgricola(166, "Banco Agrícola"),
    BancoBicentenario(175, "Banco Bicentenario"),
    BancoCaroni(128, "Banco Caroni"),
    BancoDeVenezuela(102, "Banco de Venezuela"),
    BancodelTesoro(163, "Banco del Tesoro"),
    BancoExterior(115, "Banco Exterior"),
    BancoFondoComun(151, "Banco Fondo Comun"),
    BancoMercantil(105, "Banco Mercantil"),
    BancoNacionaCredito(191, "Banco Nacional de Credito"),
    BancoOccidentalDeDescuento(116, "Banco Occidental de Descuento"),
    BancoProvincial(108, "Banco Provincial"),
    BancoPlaza(138, "Banco Plaza"),
    BancoVenezolanoCredito(104, "Banco Venezolano de Crédito"),
    BancoBancrecer(168, "Bancrecer"),
    BancoBanesco(134, "Banesco"),
    BancoBanfanb(177, "Banfanb"),
    BancoBanplus(174, "Banplus"),
    BancoDelSur(157, "Del Sur Banco"),
    BancoBanGente(146, "BanGente"),
    BancoCityBank(190, "CityBank"),
    BancoSofitasa(137, "Sofitas"),
    BancoMiBanco(169, "Mi Banco");

    private int id;
    private String descripcion;

    private BancosEnum(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public static BancosEnum getById(int id) {
        switch (id) {
            case 156:
                return CienporcientoBanco;
            case 172:
                return Bancamiga;
            case 114:
                return Bancaribe;
            case 171:
                return BancoActivo;
            case 166:
                return BacoAgricola;
            case 175:
                return BancoBicentenario;
            case 128:
                return BancoCaroni;
            case 102:
                return BancoDeVenezuela;
            case 163:
                return BancodelTesoro;
            case 115:
                return BancoExterior;
            case 151:
                return BancoFondoComun;
            case 105:
                return BancoMercantil;
            case 191:
                return BancoNacionaCredito;
            case 116:
                return BancoOccidentalDeDescuento;
            case 108:
                return BancoProvincial;
            case 104:
                return BancoVenezolanoCredito;
            case 168:
                return BancoBancrecer;
            case 134:
                return BancoBanesco;
            case 177:
                return BancoBanfanb;
            case 174:
                return BancoBanplus;
            case 157:
                return BancoDelSur;
            case 169:
                return BancoMiBanco;
            case 149:
                return BancoDelPueblo;
            case 138:
                return BancoPlaza;
            case 146:
                return BancoBanGente;
            case 190:
                return BancoCityBank;
            case 137:
                return BancoSofitasa;
            default:
                return null;
        }
    }
}
