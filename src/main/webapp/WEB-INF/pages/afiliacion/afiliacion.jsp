<%-- 
    Document   : uploadAfiliacion
    Created on : 19/03/2019, 04:44:21 PM
    Author     : Christian Gutierrez
--%>

<div class="container"   id="afiliaciones">
    <br>

    <div class="row" id="panelPpalAfil">
        <div class="col-lg-1"></div>
        <div class="col-lg-10">
            <div id="accion-afiliacion">

                <div class="form-group">

                    <select class="form-control " id="selectAfiliacion" >
                        <option value="0" selected="true">Seleccione tipo de Afiliación</option>
                        <option value="1">Carga Masiva</option>
                        <option value="2">Carga Individual</option>

                    </select>
                </div>
            </div>     
        </div>
    </div>

    <div class="row" id="masivoAfiliacion">
         <div class="col-lg-1"></div>
        <div class="col-lg-11">
            <h4 class="card-title text-left ">Carga Masiva Para Afiliar</h4>
        </div>
        <br>
        <div class="col-lg-12">
            <div class="alert alert-danger" id="alert-afi" style="display: none" ></div>
            <div class="alert alert-success" id="alert-suc" style="display: none"></div>

            <div id="archivo-afiliacion">
                <form method="POST" action="/bbcdomiweb/uploadAfiliacion.htm" enctype="multipart/form-data">
                    <div class="row">
                        <div class="col-lg-1"></div>
                        <div class="col-lg-3">
                            <input id="fileAli" type="file" name="fileAfiliacion" required="true" onchange="return validarExtAfi()"  />
                        </div>
                     </div>
                    
                    <br>
                    <br>
                    <div class="row">
                        <div class="col-lg-1"></div>
                        <div class="col-lg-3">
                            <button type="button" id="cancelarMasivoAfiliacion" href="home" class="btn btn-dark btn-lg btn-block" data-toggle="modal" data-target="#cancelModalAfilDomic">Cancelar</button>
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
    <br>
    <div class="row" id="manual-afiliacion">
        <div class="col-lg-12">
            <h4 class="card-title text-left ">Carga Individual Para Afiliar</h4>
        </div>

        <div class="col-lg-12">
            <div class="alert alert-danger" id="alert-reg-afilia" style="display: none"></div>
            <div id="archivo-afiliacion1">
                <div id="cargaData" class="row ">                   
                    <div class="col-md-12">

                        <form id="regAfiliacion" name="formRegregAfiliacionAfiliacion">
                            <div class="form-row">
                                <div class="form-group col-md-3">

                                    <select id="tipoOperacion"  required="true"  class="form-control">
                                        <option selected value="A-Afiliación">Afiliar</option>
                                        <option value="D-Desafiliación">Desafiliar</option>
                                    </select>
                                </div>
                                <div class="form-group col-md-1">
                                    <select id="tipoDoc"  required="true"  class="form-control">                                    
                                        <option selected value="V">V</option>
                                        <option value="E">E</option>
                                        <option value="P">P</option>
                                        <option value="J">J</option>
                                        <option value="G">G</option>
                                    </select>
                                </div>
                                <input id="tipoPagador" type="hidden">
                                <input id="claveOrdenante" type="hidden">
                                <div class="form-group col-md-3">
                                    <input id="numIdentPagador" type="text" minlength="5" maxlength="11" oninput="if(this.value.length > this.maxLength ) this.value = this.value.slice(0, this.maxLength);" class="form-control" required="true"  placeholder="Identificador Pagador">
                                </div>
                                <div class="form-group col-md-5">
                                    <input id="nombrePagador" type="text" class="form-control" maxlength="30" oninput="if(this.value.length > this.maxLength ) this.value = this.value.slice(0, this.maxLength);" required="true"  placeholder="Nombre del Pagador">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-3">
                                    <select id="codBcoDestino" required="true"  class="form-control">
                                        <option value="0156">100%BANCO</option>
                                        <option value="0172">BANCAMIGA BANCO MICROFINANCIERO, C.A.</option>
                                        <option value="0171">BANCO ACTIVO BANCO COMERCIAL, C.A.</option>
                                        <option value="0166">BANCO AGRICOLA</option>
                                        <option value="0175">BANCO BICENTENARIO</option>
                                        <option value="0128">BANCO CARONI, C.A. BANCO UNIVERSAL</option>
                                        <option value="0102">BANCO DE VENEZUELA S.A.I.C.A.</option>
                                        <option value="0114">BANCO DEL CARIBE C.A.</option>
                                        <option value="0149">BANCO DEL PUEBLO SOBERANO C.A.</option>
                                        <option value="0163">BANCO DEL TESORO</option>
                                        <option value="0115">BANCO EXTERIOR C.A.</option>                                     
                                        <option value="0105">BANCO MERCANTIL C.A.</option>
                                        <option value="0191">BANCO NACIONAL DE CREDITO</option>
                                        <option value="0116">BANCO OCCIDENTAL DE DESCUENTO.</option>
                                        <option value="0138">BANCO PLAZA</option>
                                        <option value="0108">BANCO PROVINCIAL BBVA</option>
                                        <option value="0104">BANCO VENEZOLANO DE CREDITO S.A.</option>
                                        <option value="0168" selected="true">BANCRECER S.A. </option>
                                        <option value="0134">BANESCO BANCO UNIVERSAL</option>  
                                        <option value="0177">BANFANB</option>
                                        <option value="0146">BANGENTE</option>
                                        <option value="0174">BANPLUS BANCO COMERCIAL C.A</option>
                                        <option value="0190">CITIBANK.</option>
                                        <option value="0157">DELSUR BANCO UNIVERSAL</option>
                                        <option value="0151">FONDO COMUN</option>
                                        <option value="0169">MIBANCO BANCO DE DESARROLLO, C.A.</option>
                                        <option value="0137">SOFITASA</option>
                                    </select>
                                </div>
                                <div class="form-group col-md-5">
                                    <input id="ctaBcoDestino" type="text"  required="true"  class="form-control" id="ctaBancoPagadot" maxlength="20" oninput="if(this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);" placeholder="Cuenta Pagador">
                                </div>
                                <div class="form-group col-md-3">
                                    <input  id="refContrato" type="text" class="form-control" minlength="1" maxlength="30" required="true"  placeholder="Contrato">
                                </div>
                                <div id="angree" class="form-group col-md-1">
                                    <input type=image id="btnOk"  src="resources/images/UI_2-512.png" title="Agregar Registro" width="40px" height="40px">
                                </div>

                            </div>





                        </form>

                        <hr>
                    </div>
                </div>

            </div>     
            <div class=" my-custom-scrollbar">
                <table class="table table-bordered table-striped " id="tableRegIndividual" >
                    <thead>
                        <tr style="text-align: center;">

                            <th scope="col">Operación</th>
                            <th scope="col">Pagador</th>
                            <th scope="col">Nombre del Pagador</th>
                            <th scope="col">Banco Destino</th>
                            <th scope="col">Nro. de Cta. Pagador</th>
                            <th scope="col">Contrato</th>

                        </tr>
                    </thead>
                    <tbody style="text-align: center;">


                    </tbody>
                </table>


            </div>
            <br>
            <br>


            <div class="row">
                <div class="col-lg-1"></div>
                <div class="col-lg-3">
                    <button type="button" id="cancel" href="home" class="btn btn-dark btn-lg btn-block" data-toggle="modal" data-target="#cancelModalAfilDomic">Cancelar</button> 

                </div>
                <div class="col-lg-4"></div>
                <div class="col-lg-3">
                    <button type="button"  id="btnEnviarIndividual" class="btn btn-primary btn-lg btn-block">Enviar</button> 
                </div>
                <div class="col-lg-1"></div>


            </div>
        </div>
    </div>
</div>
