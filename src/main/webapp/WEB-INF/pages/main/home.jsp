<%-- 
    Document   : home
    Created on : 19/03/2019, 03:56:37 PM
    Author     : Christian Gutierrez
--%>

<%@ page language="java" contentType="text/html"%>
<%@ include file="../common/taglibs.jsp"%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Domiciliaciones</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Bootstrap core CSS -->

        <%@ include file="../layouts/cssHeader.jsp"%>

    </head>
    <body>
        <!--  ========= PanelModal =================-->

        <!-- Modal -->
        <div class="modal fade" data-backdrop="static" data-keyboard="false"  id="mensajeGenerico" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document" style="margin-top: 200px;">
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
                            <button type="button"  id="cancelarCargaIndividualAfiliacion"       class="btn btn-primary btn-lg btn-block"> ACEPTAR </button>                            
                        </div>
                   
                        
                       
                        
                    </div>
                </div>
            </div>
        </div>

        
        <!--  ========= Panel Principal =================-->

        <%@ include file="panel.jsp"%>



    </body> 
    <!-- jQuery core js -->
    <%@ include file="../layouts/jsFooter.jsp"%>  

    <script type="text/javascript" src="<c:url value="/resources/js/afiliaciones.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/domiciliaciones.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/consultas.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/botones.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.mask.js" />"></script>
    <script type="text/javascript">

    
    </script>
    <script type="text/javascript">

        function validarExtAfi()
        {
            var archivoInput = document.getElementById('fileAli');
            var archivoRuta = archivoInput.value;
            var extPermitidas = /(.txt|.xls|.xlsx)$/i;
            if (!extPermitidas.exec(archivoRuta)) {

                archivoInput.value = '';
                $("#alert-afi").show();
                $("#alert-suc").hide();
                $("#alert-afi").html("<strong>Asegurese de haber seleccionado un archivo  Excel o TXT. </strong>");

                return false;
            } else {
                $("#alert-afi").hide();
                return true;
            }

        }


        function validarExtDom()
        {
            var archivoInput = document.getElementById('fileDom');
            var archivoRuta = archivoInput.value;
            var extPermitidas = /(.txt|.xls|.xlsx)$/i;
            if (!extPermitidas.exec(archivoRuta)) {
                archivoInput.value = '';
                $("#alert-dom").show();
                $("#alert-suc").hide();
                $("#alert-dom").html("<strong>Asegurese de haber seleccionado un archivo  Excel o TXT. </strong>");
                return false;
            } else {
                $("#alert-dom").hide();
                return true;
            }
        }
    </script>
</html>
