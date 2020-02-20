<%-- 
    Document   : domiciliacion
    Created on : 20/03/2019, 08:22:19 PM
    Author     : Ledwin Belen
--%>

<div class="container"   id="domiciliaciones">
    <br>
   
    <div class="row" id="panelPpalDomi">
        <div class="col-lg-1"></div>
        <div class="col-lg-10">
            <div id="accion-domiciliacion">

                <div class="form-group">

                    <select class="form-control" id="selectDomiciliacion" >
                        <option value="0">Seleccione tipo de cobro</option>
                        <option value="1">Cobro Masivo</option>
                        <option value="2">Cobro individual</option>
                    </select>
                </div>

            </div>     
        </div>
    </div>
   
    <div class="row" id="masivoPagos">  
        <div class="col-lg-1"></div>
        <div class="col-lg-11">
            <h4 class="card-title text-left ">Carga Masiva Para Cobrar</h4>
        </div>
        <br>
        <div class="col-lg-12">
            <div class="alert alert-danger" id="alert-dom" style="display: none" ></div>
            <div class="alert alert-success" id="alert-suc" style="display: none"></div>
            <div id="archivo-afiliacion">
                <form method="POST" action="/bbcdomiweb/uploadDomiciliacion.htm" enctype="multipart/form-data">
                    <div class="row">
                        <div class="col-lg-1"></div>
                        <div class="col-lg-3">
                            <input id="fileDom" type="file" name="fileDomiciliacion"   required="true" onchange="return validarExtDom()"/>   
                        </div> 
                    </div>
                    
                    <br>
                    <br>
                    <div class="row">
                        <div class="col-lg-1"></div>
                        <div class="col-lg-3">
                            <button type="button" id="cancelarMasivoDomiciliacion" href="home" class="btn btn-dark btn-lg btn-block" data-toggle="modal" data-target="#cancelModalAfilDomic">Cancelar</button>
                        </div>
                        <div class="col-lg-4"></div>
                        <div class="col-lg-3">
                            <button type="submit" class="btn btn-primary btn-lg btn-block">Enviar</button> 
                        </div>
                        <div class="col-lg-1"></div>
                    </div>
                </form>
            </div>     
        </div>
    </div>
    
    <div class="row" id="manualDomiciliacion">
        <div class="col-lg-12">
            <h4 class="card-title text-left ">Carga Individual Para Cobrar</h4>
        </div>
        <div class="col-lg-12">
            <div class="alert alert-danger" id="alert-reg-domi" style="display: none"></div>
            <div id="cargaDataDomi"> 
                    <form id="regDomiciliacion" name="">
                        <div class="form-row">
                            <input id="tipoPagadorDomic"  value="N" type="hidden">
                            <input id="refContratoDomi"   type="hidden">
                            <input id="tipoOperacion"  value="D"  type="hidden">
                            <input id="codBcoDestinoDomi"  value="D"  type="hidden">
                            <input id="nombreBcoDestinoDomi"  value="D"  type="hidden">
                            
                            
                            <div class="form-group col-md-1">
                                <select id="tipoDocDomi"  required="true"  class="form-control">                                    
                                    <option selected value="V">V</option>
                                    <option value="E">E</option>
                                    <option value="J">J</option>
                                    <option value="G">G</option>
                                    <option value="P">P</option>
                                </select>
                            </div>
                            <div class="form-group col-md-3">
                                <input id="numIdentPagadorDomi" type="text" minlength="5" maxlength="12" oninput="if(this.value.length > this.maxLength ) this.value = this.value.slice(0, this.maxLength);" class="form-control" required="true"  placeholder="Identificador Pagador">
                            </div>
                            <div class="form-group col-md-5">
                                <input id="nombrePagadorDomi" type="text" class="form-control" maxlength="30" oninput="if(this.value.length > this.maxLength ) this.value = this.value.slice(0, this.maxLength);" required="true"  placeholder="Nombre del Pagador" disabled="true">
                            </div>
                            <div class="form-group col-md-3">
                                <input id="ctaBcoDestinoDomi" type="text"  required="true"  class="form-control" id="ctaBancoPagadot" maxlength="20" oninput="if(this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);" placeholder="Cuenta Pagador" disabled="true">
                            </div>
                        </div>
                        <div>
                            <br>
                            <h5 class="card-title text-left">Datos de la factura:</h5>      
                            <br>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-3">
                                <label for="fechaEmisionDomi">Fecha Emisión</label>
                                <input type="date" name='fechaEmisionDomi'  class="form-control" id="fechaEmisionDomi" >
                            </div>
                            <div class="form-group col-md-3">
                                <label for="fechaVctoDomi">Fecha Vencimiento</label>
                                <input type="date" name='fechaVctoDomi' class="form-control" id="fechaVctoDomi">
                            </div>
                            <div class="form-group col-md-3" style="margin-top:32px;">
                                <input  id="nroFacturaDomi" type="text" class="form-control" minlength="" maxlength="30"required="true"  placeholder="Contrato" disabled="true">
                            </div>
                            <div class="form-group col-md-2" style="margin-top:32px;">
                                <input  id="montoDomi" tmontoDomiype="number" class="form-control" minlength="9" maxlength="20"required="true"  placeholder="Monto">
                            </div>
                            <div id="agregarDomi" class="form-group col-md-1" style="margin-top:10px;">
                                <label for="btnAgregarDomi"></label> <br>
                                <input type=image id="btnAgregarDomi"  src="resources/images/UI_2-512.png" title="AGREGAR" width="40px" height="40px">
                            </div>  
                        </div>
                    </form>
                    <hr>
            </div>  
     
            <div class="table-wrapper-scroll-y my-custom-scrollbar">
                <table class="table table-bordered table-striped mb-0" id="tableRegIndividualDomic" >
                    <thead>
                        <tr style="text-align: center;">
                            <th scope="col">Pagador</th>
                            <th scope="col">Nombre del Pagador</th>
                            <th scope="col">Nro. de Cuenta</th>
                            <th scope="col">Monto</th>
                            <th scope="col">Contrato</th>
                            <th scope="col" style="width: 140px;">Emisión</th>
                            <th scope="col">Vencimiento</th>
                        </tr>
                    </thead>
                    <tbody style="text-align: center;">
                    </tbody>
                </table>
               
            </div>
            <div class="row">
                <div class="col-lg-6">
                    
                </div>
                <div class="col-lg-3" id="tregister">
                    <label id="lbeTregs"></label>
                </div>
                <div class="col-lg-3" id="tMontoPro">
                    <label id="lbeTmonto"></label>
                </div>
                
            </div>
            <div class="row">
                <div class="col-lg-1"></div>
                 <div class="col-lg-3" >
                    <button type="button" id="cancel" href="home" class="btn btn-dark btn-lg btn-block" data-toggle="modal" data-target="#cancelModalAfilDomic">Cancelar</button> 
                    
                </div>
                <div class="col-lg-4"></div>
                <div class="col-lg-3 ">
                    <button type="button"  id="btnEnviarDomicIndividual" class="btn btn-primary btn-lg btn-block">Enviar</button> 
                </div>
                 <div class="col-lg-1"></div>
            </div>
        </div>
    </div>
</div>
