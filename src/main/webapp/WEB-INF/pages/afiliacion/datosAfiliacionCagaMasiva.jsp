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
                            <h6 class="modal-title" id="mensajeGenericoLabelTitle">Archivo recibido con éxito. Pronto será procesado</h6>
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
                            <button type="button"  id="cancelarMasivoAfiliacion" class="btn btn-primary btn-lg btn-block"> ACEPTAR </button>                            
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="container" id="panelPrincipal">
            <br>
            <div class="contenedor-rg" id="logo2" >
                <img src="resources/images/Isologo.png" class="" alt="Cinque Terre" width="145" height="53"  > 
            </div>
            <br><br><br>
            <div class="row">
                <div class="col-lg-12">
                    <h5 class="card-title text-left ">Resumen Carga Afiliaciones Masivas</h5>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <table class="table table-led" id="sumarioAfiliaMasivo">
                        <thead align="center">
                            <tr>
                                <th scope="col">Nombre del Archivo</th>
                                <th scope="col">Fecha de Carga</th>
                                <th scope="col">Total Registros</th>
                                <th scope="col">Registros Validos</th>
                                <th scope="col">Registros Rechazados</th>
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
                            <div class="col-lg-6"></div>
                            <div id="angree" class="col-lg-3">
                                <button type="botton" id="btnProcesarAfiliaciones" class="btn btn-primary  btn-block">Enviar</button>
                            </div>
                        </div>
                        <div class="row contenedor">
                            <div id="alertaSumario" class="alert alert-warning container-led" role="alert" ></div>
                        </div> 
                    </form>
                </div>
            </div>
        </div>

    </body>
    <%@ include file="../layouts/jsFooter.jsp"%>  
    <script type="text/javascript" src="<c:url value="/resources/js/sumario.js" />"></script>
    <script type="text/javascript">
</html>
