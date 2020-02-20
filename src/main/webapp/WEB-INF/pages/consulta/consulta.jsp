<%-- 
    Document   : consulta
    Created on : 06/04/2019, 12:27:44 PM
    Author     : Sinergia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <body>

        <div class="container" id="consultas">
            <br>
            <div class="row" id="panelConsulta">
                <div class="col-lg-1"></div>
                <div class="col-lg-10">
                    <div id="accion-consulta">
                        <div class="form-group">
                            <select class="form-control" id="selectConsulta" >
                                <option value="0" selected="">Seleccione tipo de Consulta</option>
                                <option value="1">Consolidado de Afiliaciones</option>
                                <option value="2">Consolidado de Cobros</option>
                            </select>
                        </div>
                    </div>     
                </div>
            </div>

            <div class="row" id="consultarAfiliacion">
                <div class="col-lg-12">
                    <h4 class="card-title text-left ">Consolidado de Afiliaciones</h4>
                </div>
                <br>
                <div class="col-lg-12">
                    <div class="alert alert-danger" id="alert-afi" style="display: none" ></div>
                    <div class="alert alert-success" id="alert-suc" style="display: none"></div>

                    <div class="my-custom-scrollbar2" >
                        <table class="table table-bordered  mb-0" id="consulta-consolidado-afiliacion">
                            <thead>
                                <tr style="text-align: center;">
                                    <th scope="col" style="width: 130px">Fecha Carga</th>
                                    <th scope="col">Nombre Archivo</th>
                                    <th scope="col">Total</th>
                                    <th scope="col">Pendientes</th>
                                    <th scope="col">Aprobados</th>
                                    <th scope="col">Rechazados</th>
                                </tr>
                            </thead>
                            <tbody style="text-align: center;">

                            </tbody>
                        </table>
                    </div>

                    <br>
                    <form method="POST" action="home" enctype="multipart/form-data">
                        <div class="row">
                            <div class="col-lg-3">
                            <button id="cancelarConsultarAfiliacion"  class="btn btn-dark btn-lg btn-block" href="home">Regresar</button>
                        </div>
                        <div class="col-lg-6 contenedor">
                            <div id="botones" class="btn-group"    role="group" arial-label="grupo">
                           </div>
                        </div>
                       </div>   
                        
                    </form>
                </div>
            </div>

            <div class="row" id="consultarCobros">
                <div class="col-lg-12">
                    <h4 class="card-title text-left ">Consolidado de Cobros</h4>
                </div>
                <br>
                <div class="col-lg-12">
                    <div class="alert alert-danger" id="alert-afi" style="display: none" ></div>
                    <div class="alert alert-success" id="alert-suc" style="display: none"></div>

                    <div class="my-custom-scrollbar2" >
                        <table class="table table-bordered  mb-0"  id="consulta-consolidado-cobros">
                            <thead>
                                <tr style="text-align: center;">
                                    <th scope="col" style="width: 130px">Fecha Carga</th>
                                    <th scope="col">Nombre Archivo</th>
                                    <th scope="col">Total</th>
                                    <th scope="col">Pendientes</th>
                                    <th scope="col">Aprobados</th>
                                    <th scope="col">Rechazados</th>
                                </tr>
                            </thead>
                            <tbody style="text-align: center;">

                            </tbody>
                        </table>
                    </div>
                    <br>
                    <form method="POST" action="home" enctype="multipart/form-data">
                        <div class="row">
                        <div class="col-lg-3">
                            <button id="cancelarConsultarCobros"  class="btn btn-dark btn-lg btn-block" href="home">Regresar</button>  
                        </div>
                        <div class="col-lg-6 contenedor">
                            <div id="botones1" class="btn-group" role="group" arial-label="grupo">
                           </div>
                        </div>
                      </div>      
                    </form>
                </div>
            </div>

            <div id="detalleAfiliacion" class="row">
                <div class="col-lg-12">
                    <h4 class=" text-left">Detalle de Afiliaciones</h4>
                </div>
                <br>
                <div class="col-lg-12">
                    <div class="alert alert-danger" id="alert-afi" style="display: none" ></div>
                    <div class="alert alert-warning" id="alert-warning-det-afi" style="display: none"></div>

                    <div class="table-wrapper-scroll-y my-custom-scrollbar" style="height: auto;">                      
                        <div class="input-group">
                            <div class="col-1-1" style="align-content: center">
                                <span class=" fa fa-search fa-lg" id="basic-addon2"></span>
                            </div>
                            <div class="col-lg-8"><input id="filtrar" type="text"  placeholder="Buscar" class="form-control" style="height: 30px;" aria-label="Buscar" aria-describedby="basic-addon1"></div>
                            <div class="col-lg-3">
                                <input  type=image id="btnExporDetailAfilia"  src="resources/images/UI_2-515.png" title="Desacargar Archivo" width="30px" height="30px">
                                <label for="fechaEmisionDomi">Descarga</label>
                            </div>

                        </div>

                        <div class="table-wrapper-scroll-y my-custom-scrollbar2">
                            <table class="table table-hover table-bordered  table-condensed align-content-md-center " id="detalle-afiliacion">
                                <thead>
                                    <tr style="text-align: center;">
                                        <th scope="col">Operación</th>
                                        <th scope="col" style="width: 107px !important;">Pagador</th>
                                        <th scope="col" style="width: 235px !important;">Nombre</th>
                                        <th scope="col" style="width: 166px !important;">Nro. de Cuenta</th>
                                        <th scope="col" style="width: 235px !important;">Contrato</th>
                                        <th scope="col" style="width: 175px !important;">Resultado</th>
                                    </tr>
                                </thead>
                                <tbody style="text-align: center;" class="buscar">

                                </tbody>
                            </table>
                        </div>
                        <div style="display: none">
                            <table class="table table-hover table-bordered  table-condensed align-content-md-center " id="detalle-afiliacion-print">
                                <thead>
                                    <tr style="text-align: center;">
                                        <th scope="col">Operación</th>
                                        <th scope="col" style="width: 107px !important;">Pagador</th>
                                        <th scope="col" style="width: 235px !important;">Nombre</th>
                                        <th scope="col" style="width: 166px !important;">Nro. de Cuenta</th>
                                        <th scope="col" style="width: 235px !important;">Contrato</th>
                                        <th scope="col" style="width: 175px !important;">Resultado</th>
                                    </tr>
                                </thead>
                                <tbody style="text-align: center;" class="buscar">

                                </tbody>
                            </table>
                        </div>
                        <br>

                        <div class="row">
                            <div class="col-lg-3">
                                <button id="cancelarDetalleConsulta"  class="btn btn-dark btn-lg btn-block" >Regresar</button>  
                            </div>
                            <div class="col-lg-6 contenedor">
                                <div id="botones2" class="btn-group"    role="group" arial-label="grupo">
                                </div>
                            </div>  
                        </div>

                            

                       
                    </div>
                </div>
            </div>
            <div id="detalleCobros" class="row">
                <div class="col-lg-12">
                    <h4 >Detalle de Cobro</h4>
                </div>
                <br>
                <div class="col-lg-12">
                    <div class="alert alert-danger" id="alert-afi" style="display: none" ></div>
                    <div class="alert alert-warning" id="alert-warning-det-dom" style="display: none"></div>

                    <div class="table-wrapper-scroll-y my-custom-scrollbar" style="height: auto;">
                        <br>
                        <div class="input-group">
                            <div class="col-1-1">
                                <span class="fa fa-search fa-lg" id="basic-addon2"></span>
                            </div>
                            <div class="col-lg-8">
                                <input id="filtrar2" type="text"  placeholder="Buscar" class="form-control" style="height: 30px;" aria-label="Buscar" aria-describedby="basic-addon1">
                            </div>

                            <div class="col-lg-3">
                                <input  type=image id="btnExporDetailCobros"  src="resources/images/UI_2-515.png" title="Desacargar Archivo" width="30px" height="30px">
                                <label for="fechaEmisionDomi">Descarga</label>
                            </div>
                        </div>

     
                        <div class="table-wrapper-scroll-y my-custom-scrollbar2">
                            <table class="table table-hover table-bordered  table-condensed align-content-md-center " id="reporte-detalle-cobro">
                                <thead>
                                    <tr style="text-align: center;">
                                        <th scope="col">Pagador</th>
                                        <th scope="col">Nombre</th>
                                        <th scope="col">Nro. de Cuenta</th>
                                        <th scope="col">Monto</th>
                                        <th scope="col">Contrato</th>
                                        <th scope="col">Emisión</th>
                                        <th scope="col">Vencimiento</th>
                                        <th scope="col">Descripción</th>
                                    </tr>
                                </thead>
                                <tbody style="text-align: center;" class="buscar">

                                </tbody>
                            </table>
                        </div>
                            <div class="table table-hover table-bordered  table-condensed align-content-md-center ">
                            <table style="display: none" id="reporte-detalle-cobro-print">
                                <thead>
                                    <tr style="text-align: center;">
                                        <th scope="col">Pagador</th>
                                        <th scope="col">Nombre</th>
                                        <th scope="col">Nro. de Cuenta</th>
                                        <th scope="col">Monto</th>
                                        <th scope="col">Contrato</th>
                                        <th scope="col">Emisión</th>
                                        <th scope="col">Vencimiento</th>
                                        <th scope="col">Descripción</th>
                                    </tr>
                                </thead>
                                <tbody style="text-align: center;" class="buscar">

                                </tbody>
                            </table>
                        </div>
                        
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-lg-3">
                            <button id="cancelarDetalleCobro"  class="btn btn-dark btn-lg btn-block" href="home">Regresar</button>  
                        </div>
                        <div class="col-lg-6 contenedor">
                                <div id="botones3" class="btn-group"    role="group" arial-label="grupo">
                                </div>
                        </div> 
                    </div>
                </div>
            </div>            
        </div>
    </body>       
</html>
