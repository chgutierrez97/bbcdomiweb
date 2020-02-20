<%-- 
    Document   : panel
    Created on : 19/03/2019, 05:55:07 PM
    Author     : Christian Gutierrez

 <div class="container">   
        <img src="resources/images/Isologo.png" class="" alt="Cinque Terre" width="400" height="195" style="align-content: center"> 
        </div>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="container" id="panelPrincipal">
    <br>
   
    
    <div class="contenedor" id="logo1" >
            <img src="resources/images/Isologo.png" class="" alt="Cinque Terre" width="300" height="150"  > 
        </div>
    <br>
    <div class="contenedor-rg" id="logo2" >
            <img src="resources/images/Isologo.png" class="" alt="Cinque Terre" width="180" height="90"  > 
        </div>
 
    
    <div class="nav-justified">
    <div class="alert alert-danger" id="alert-error-file" style="display: none" ></div>

    </div>
    <br>
    <br>
    <br>
 
        <div class="row" id="panelBotones"  >
        <div class="col-lg-4">
            <div class="contenedor" id="btn-1" >           
               <div class="col-lg-12"  >
                   <img src="resources/images/afiliar-2.png" id="home-tab-af" class="home-tab-af" data-toggle="tab" href="#afiliaciones" role="tab" alt="Cinque Terre" disabled="true" width="350px" height="60px"  > 
                   <img src="resources/images/afiliar-1.png" id="home-tab-af-aux" class="home-tab-af-aux" data-toggle="tab" width="350px" height="60x" style="display: none" > 
               </div>
               
               
            </div>
        </div>
        <div class="col-lg-4">
            <div class="contenedor" id="btn-2">
                <div class="col-lg-12">
                   <img src="resources/images/cobrar-1.png"  id="home-tab-pg" class="profile-tab-pg" data-toggle="tab" href="#pagos" role="tab" class="" alt="Cinque Terre" disabled="true"  width="350px" height="60px"  > 
                   <img src="resources/images/cobrar-1.png"  id="home-tab-pg-aux" class="profile-tab-pg-aux" data-toggle="tab"   width="350px" height="60x" style="display: none" > 
               </div>               
            </div>
            
        </div>

        <div class="col-lg-4">
            <div class="contenedor" id="btn-3">
               <div class="col-lg-12" >
                   <img src="resources/images/consultar-1.png" id="profile-tab-consulta" class="profile-tab-consulta" data-toggle="tab" href="#consulta" role="tab" class="" alt="Cinque Terre" width="350px" height="60x"  > 
                   <img src="resources/images/consultar-1.png" id="profile-tab-consulta-aux" class="profile-tab-consulta-aux" data-toggle="tab"  width="350px" height="60x" style="display: none" > 
               </div>              
            </div>
        </div>
            
      </div>
    <div class="col-lg-12">

        <div class="tab-content">
            <div class="tab-pane active" id="afiliaciones" role="tabpanel" aria-labelledby="home-tab" >
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
</div>

</div>
