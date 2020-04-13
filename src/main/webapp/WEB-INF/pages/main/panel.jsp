<%-- 
   Document   : panel
   Created on : 19/03/2019, 05:55:07 PM
   Author     : Ledwin Belén
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="container" id="panelPrincipal">
    <br>
    <div class="contenedor-rg" id="logo2">
        <img src="resources/images/Isologo.png" class="" alt="Cinque Terre" width="145" height="53">
    </div>
    <div class="nav-justified">
        <div class="alert alert-danger" id="alert-error-file" style="display: none"></div>
    </div>
        <div id="contenedor-botones">
            <div class="boton home-tab-af" id="btn-1">Afiliar</div>
            <div class="boton profile-tab-pg" id="btn-2">Cobrar</div>
            <div class="boton profile-tab-consulta" id="btn-3">Consultar</div>
            <div class="clear">
                
            </div>
        </div>
    <div class="col-lg-12">
        <div class="tab-content">
            <div class="tab-pane active" id="afiliaciones" role="tabpanel" aria-labelledby="home-tab">
                <%@ include file="../afiliacion/afiliacion.jsp"%>
            </div>
            <div class="tab-pane" id="pagos" role="tabpanel" aria-labelledby="profile-tab">
                <%@ include file="../pagos/domiciliacion.jsp"%>
            </div>
            <div class="tab-pane" id="consulta" role="tabpanel" aria-labelledby="profile-tab">
                <%@ include file="../consulta/consulta.jsp"%>
            </div>
        </div>
    </div>
</div>
