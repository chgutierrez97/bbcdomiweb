<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html"%>
<%@ include file="../common/taglibs.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Afiliaciones</title>
        <%@ include file="../layouts/cssHeader.jsp"%>
    </head>


    <body>
        <!--  ========= PanelModal =================-->

        <!-- Modal -->
        <div class="modal fade" data-backdrop="static" data-keyboard="false"  id="mensajeGenericoMasiAfi" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">

                    <div class="modal-body">
                        <div class="col-lg-12" style="text-align: center;">
                            <h6 class="modal-title" id="mensajeGenericoLabelTitle">Su solicitud será procesada</h6>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <div class="col-lg-12">
                            <button type="button"  id="btnMensaje" class="btn btn-primary btn-lg btn-block"> ACEPTAR </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal -->
        <div class="modal fade" data-backdrop="static" data-keyboard="false"  id="cancelModalAfilDomic" tabindex="-1" role="dialog"  aria-hidden="true">
            <div class="modal-dialog" role="document"   style="margin-top: 200px;">
                <div class="modal-content">

                    <div class="modal-body">
                        <div class="col-lg-12" style="text-align: center;">
                            <h6 class="modal-title" id="mensajeGenericoLabelTitle">Al cancelar se perderán todos los datos y deberá cargar nuevamente la información. </h6>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <div class="col-lg-6">
                            <div class="text-center"><a data-dismiss="modal" id="cancel" class="btn btn-lg btn-block border-bottom border-top border-left border-right" href="home">REGRESAR</a></div>
                        </div>
                        <div class="col-lg-6">
                            <button type="button"  id="cancelarMasivoDomiciliacion"       class="btn btn-primary btn-lg btn-block"> ACEPTAR </button>                            
                        </div>




                    </div>
                </div>
            </div>
        </div>
        <div class="container" id="panelPrincipal">
            <br>
            <div class="contenedor-rg" id="logo2" >
                <img src="resources/images/Isologo.png" class="" alt="Cinque Terre" width="180" height="90"  > 
            </div>
            <br><br><br><br>
            <div class="row">
                <div class="col-lg-12">
                    <h4 class="card-title text-left">Resumen Carga de Domiciliaciones Masivas </h4>
                </div>
            </div>
            <div class="alert alert-warning" role="alert">
                Los registros de Cobro a Otros Bancos serán procesados dentro de la franja de la cámara de compensación
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <table class="table" id="sumarioDomicMasivo">
                        <thead align="center">
                            <tr>
                                <th scope="col">Nombre del Archivo</th>
                                <th scope="col">Fecha de carga</th>
                                <th scope="col">Total registros</th>
                                <th scope="col">Registros Rechazados</th>
                                <th scope="col">Registros Aprobados</th>
                                <th scope="col">Total Monto Aprobado</th>

                            </tr>
                        </thead>
                        <tbody align="center">

                        </tbody>
                    </table>
                    <form id="regAfiliacion" name="formRegregAfiliacionAfiliacion">
                        <div class="form-row">
                            <div class="col-lg-3">
                                <button type="button" id="cancelarMasivoAfiliacion" href="home" class="btn btn-dark btn-lg btn-block" data-toggle="modal" data-target="#cancelModalAfilDomic">Cancelar</button> 
                            </div>
                            <div class="col-lg-6" ></div>
                          
                            <div id="angree" class="form-group col-md-3" >
                                <button type="botton"   id="btnProcesarDomiciliaciones" class="btn btn-primary  btn-block">Enviar</button>
                            </div>

                        </div>
                        <div class="row contenedor">
                            <div id="alertaSumario" class="alert alert-warning col-lg-12" role="alert" ></div>
                            
                        </div> 
                    </form>
                </div>
            </div>
        </div>

    </body>
    <%@ include file="../layouts/jsFooter.jsp"%>  
    <script type="text/javascript" src="<c:url value="/resources/js/sumarioDomic.js" />"></script>

    <script type="text/javascript">
</html>
