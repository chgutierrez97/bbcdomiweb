$(document).ready(function () {
    getListarAfiliaTemp();
    validacionArchivo();
    var miCadena = "";
    var divisiones = miCadena.split("-")[0];


    $("#numIdentPagador").keyup(function () {
        this.value = (this.value + '').replace(/[^0-9]/g, '');
    });
    $("#ctaBcoDestino").keyup(function () {
        this.value = (this.value + '').replace(/[^0-9]/g, '');
    });
    $("#refContrato").keyup(function () {
        this.value = (this.value + '').replace(/[^0-9a-zA-Z]/g, '');
    });
    $("#nombrePagador").keyup(function () {
        this.value = (this.value + '').replace(/[^0-9a-zA-Z ]/g, '');
    });
    $("#home-tab").click(function () {
        $("#alert-error-file").hide();

    });
    $("#profile-tab").click(function () {
        $("#alert-error-file").hide();
    });



    $("#masivoAfiliacion").hide();
    $("#manual-afiliacion").hide();

    $("#alert-suc").hide();
    $("#alert-dan").hide();


    $("#selectAfiliacion").change(function () {
        $("#regAfiliacion")[0].reset();
        $("#masivoPagos").hide();
        $("#manualDomiciliacion").hide();
        $('#selectDomiciliacion option:first').prop('selected', true);
        $("#tipoPagador").val("N");



        switch ($("#selectAfiliacion option:selected").val()) {

            case '1':
                $("#masivoAfiliacion").show();
                $("#manual-afiliacion").hide();
                $("#panelPpalAfil").hide();
                $("#home-tab-af").show();
                $("#home-tab-pg").hide();
                $("#profile-tab-consulta").hide();
                $("#home-tab-pg-aux").show();
                $("#profile-tab-consulta-aux").show();
                $("#alert-error-file").hide();
                $("#logo2").hide();
                $("#logo1").show();


                break;
            case '2':
                $("#masivoAfiliacion").hide();
                $("#manual-afiliacion").show();
                $("#panelPpalAfil").hide();
                $("#home-tab-af").hide();
                $("#home-tab-pg").hide();
                $("#profile-tab-consulta").hide();
                $("#home-tab-af-aux").hide();
                $("#home-tab-pg-aux").hide();
                $("#profile-tab-consulta-aux").hide();
                $("#alert-error-file").hide();
                $("#logo1").hide();
                $("#logo2").show();
                clearCargaAfiDom();


                break;

            default:
                $("#panelPpalAfil").show();
                $("#masivoAfiliacion").hide();
                $("#manual-afiliacion").hide();
        }



    });

    $("#tipoDoc").change(function () {
        var opcion = $("#tipoDoc option:selected").text();

        if (opcion == 'V' || opcion == 'E' || opcion == 'P') {
            $("#tipoPagador").val("N");
        } else if (opcion == 'J' || opcion == 'P' || opcion == 'G') {
            $("#tipoPagador").val("J");
        } else {
            $("#tipoPagador").val("");

        }


    });

    $("body").on("click", "#tableRegIndividual  a", function (event) {
        event.preventDefault();
        idsele = $(this).attr("id");
        accion = $(this).attr("class")

        if (accion == "fa fa-pencil") {

            buscarElementoById(idsele);
            eliminarElemento(idsele)

        } else {
            eliminarElemento(idsele);

        }

    })

    $("input[id=numIdentPagador]").change(function () {
        var opc = $('#tipoOperacion').val().split("-");
        var doc = $("#tipoDoc").val() + $("#numIdentPagador").val();
        if (opc[0] == 'D') {
            buscarAfiliadoByNumDoc(doc);
        }

        buscarEmpresaOrdenante(doc);

    });

    //agregar afiliaciones a la lista 

    $("#btnOk").click(function (evt) {
        evt.preventDefault();

        var search = {}
        if (validarFormulario()) {

            search["codBcoDestino"] = ($("#codBcoDestino").val());
            search["ctaBcoDestino"] = $("input#ctaBcoDestino").val();
            search["tipoOperacion"] = ($("#tipoOperacion").val()).split("-")[0];
            search["nameTipoOperacion"] = ($("#tipoOperacion").val()).split("-")[1];
            search["tipoPagador"] = $("input:hidden#tipoPagador").val();
            search["tipoDoc"] = $("#tipoDoc").val();
            search["numIdentPagador"] = $("input#numIdentPagador").val();
            search["nombrePagador"] = $("input#nombrePagador").val();
            search["refContrato"] = $("input#refContrato").val();


            if (validarFormulario()) {

                $.ajax({
                    type: "POST",
                    contentType: "application/json",
                    url: "/bbcdomiweb/regAfiliacionTemp",
                    data: JSON.stringify(search),
                    dataType: 'json',
                    timeout: 100000,
                    success: function (data) {
                        $("#tableRegIndividual > tbody").html("");
                        $.each(data, function (i, item) {
                            var tds = '<tr><td>' + item.nameTipoOperacion + '</td><td>' + item.tipoDoc + item.numIdentPagador + '</td><td>' + item.nombrePagador + '</td><td>' + item.nameBcoDestino + '</td><td>' + item.ctaBcoDestino + '</td><td>' + item.refContrato + '</td><td>   <a id="' + item.id + '" title="Editar" class="fa fa-pencil" aria-hidden="true" style="color: #666666; cursor:pointer;"></a>  <a id="' + item.id + '"  title="Borrar" class="fa fa-trash" aria-hidden="true"  style="color: #666666; cursor:pointer;"></a> </td></tr> ';
                            $("#tableRegIndividual").append(tds);
                        });
                        //agregarFilas();
                        console.log("SUCCESS: ", data);
                        display(data);
                    },
                    error: function (e) {
                        console.log("ERROR: ", e);
                        display(e);
                    },
                    done: function (e) {
                        console.log("DONE");
                        enableSearchButton(true);
                    }
                });
            }
            $("#regAfiliacion")[0].reset();
        }
    });

    $("#btnMensaje").click(function (evt) {
        evt.preventDefault();
        location.href = "home";
    });

    $("#btnEditOk").click(function (evt) {
        evt.preventDefault();

        var search = {}
        if (validarFormulario()) {

            search["codBcoDestino"] = ($("#codBcoDestino").val()).split("-")[0];
            search["nameBcoDestino"] = ($("#codBcoDestino").val()).split("-")[1];
            search["ctaBcoDestino"] = $("input#ctaBcoDestino").val();
            search["tipoOperacion"] = ($("#tipoOperacion").val()).split("-")[0];
            search["nameTipoOperacion"] = ($("#tipoOperacion").val()).split("-")[1];
            search["tipoPagador"] = $("input:hidden#tipoPagador").val();
            search["tipoDoc"] = $("#tipoDoc").val();
            search["numIdentPagador"] = $("input#numIdentPagador").val();
            search["nombrePagador"] = $("input#nombrePagador").val();
            search["refContrato"] = $("input#refContrato").val();


            if (validarFormulario()) {

                $.ajax({
                    type: "POST",
                    contentType: "application/json",
                    url: "/bbcdomiweb/editAfiliacionTemp",
                    data: JSON.stringify(search),
                    dataType: 'json',
                    timeout: 100000,
                    success: function (data) {
                        getListarAfiliaTemp();
                        console.log("SUCCESS: ", data);

                    },
                    error: function (e) {
                        console.log("ERROR: ", e);
                        display(e);
                    },
                    done: function (e) {
                        console.log("DONE");
                        enableSearchButton(true);
                    }
                });
            }
            $("#regAfiliacion")[0].reset();
        }
    });



    $("#btnEnviarIndividual").click(function (evt) {
        evt.preventDefault();



        var ctaBcoDestino = $("input#ctaBcoDestino").val();
        var numIdentPagador = $("input#numIdentPagador").val();
        var nombrePagador = $("input#nombrePagador").val();
        var refContrato = $("input#refContrato").val();

        if (ctaBcoDestino == "" && numIdentPagador == "" && nombrePagador == "" && refContrato == "") {
            $.ajax({
                type: "GET",
                url: "/bbcdomiweb/saveTempAfiliacion",
                dataType: 'json',
                timeout: 100000,
                success: function (data) {
                    if (data.codigo == "000") {
                        console.log("SUCCESS: ", data);

                        $('#mensajeGenerico').modal('show');
                        $("#alert-reg-afilia").hide();
                    } else {
                        $("#alert-reg-afilia").show();
                        $("#alert-reg-afilia").html("<strong>" + data.descripcion + "</strong> <br>");
                    }

                },
                error: function (e) {
                    console.log("ERROR: ", e);
                    display(e);
                },
                done: function (e) {
                    console.log("DONE");
                    enableSearchButton(true);
                }
            });
            $("#alert-reg-afilia").hide();
        } else {
            $("#alert-reg-afilia").show();
            $("#alert-reg-afilia").html("Hay un registro pendiente por Agregar ");
        }




    });

    $("#cancelarCargaIndividualAfiliacion").click(
            function (evt) {
                evt.preventDefault();
                cancelarAfiliaciones();
            });


    function cancelarAfiliaciones() {
        $.ajax({
            type: "GET",
            url: "/bbcdomiweb/cancelarAfiliacion",

            dataType: 'json',
            timeout: 100000,
            success: function (data) {
                console.log("SUCCESS: ", data);
                location.href = "home";

            },
            error: function (e) {
                console.log("ERROR: ", e);
                display(e);
            },
            done: function (e) {
                console.log("DONE");
                enableSearchButton(true);
            }
        });

    }
    function  eliminarTodas(n) {

        for (i = n - 1; i > 1; i--)
        {
            $("#tableRegIndividual tbody tr:eq('" + i + "')").remove();
        }
        ;
    }
    function getListarAfiliaTemp() {
        //
        $.ajax({
            type: "GET",
            url: "/bbcdomiweb/getAfilTemp",
            success: function (data) {
                $("#tableRegIndividual > tbody").html("");
                $.each(data, function (i, item) {
                    var tds = '<tr><td>' + item.nameTipoOperacion + '</td><td>' + item.tipoDoc + item.numIdentPagador + '</td><td>' + item.nombrePagador + '</td><td>' + item.nameBcoDestino + '</td><td>' + item.ctaBcoDestino + '</td><td>' + item.refContrato + '</td><td>   <a id="' + item.id + '" title="Editar" class="fa fa-pencil" aria-hidden="true" style="color: #666666; cursor:pointer;"></a> <a id="' + item.id + '"  title="Borrar" class="fa fa-trash" aria-hidden="true"  style="color: #666666; cursor:pointer;"></a> </td></tr> ';
                    $("#tableRegIndividual").append(tds);
                });

                console.log("SUCCESS: ", data);
                display(data);
            },
            error: function (e) {
                console.log("ERROR: ", e);
                display(e);
            },
            done: function (e) {
                console.log("DONE");
                enableSearchButton(true);
            }
        });

    }
    function eliminarElemento(ids) {
        //
        $.ajax({
            type: 'GET',
            contentType: "application/json",
            url: "/bbcdomiweb/delAfilTemp?id=" + ids,

            success: function (data) {

                console.log("SUCCESS: ", data);

                if (data) {
                    getListarAfiliaTemp();
                    $("#alert-reg-afilia").hide();
                } else {
                    $("#alert-reg-afilia").show();
                    $("#alert-reg-afilia").html("<strong> No se encontr&oacute; elemento a eliminar.</strong><br>");
                }

            }


        });

    }
    function validacionArchivo() {
        //
        $.ajax({
            type: "GET",
            url: "/bbcdomiweb/getValidoArchivoAfiliacion",

            success: function (data) {

                console.log("SUCCESS: ", data);

                if (data.codigo == '000') {
                    getListarAfiliaTemp();
                    $("#alert-error-file").hide();
                } else {
                    $("#alert-error-file").show();
                    $("#alert-error-file").html("<strong>" + data.descripcion + "</strong><br>");
                }

            }


        });

    }
    function buscarElementoById(ids) {
        //
        $.ajax({
            type: 'GET',
            contentType: "application/json",
            url: "/bbcdomiweb/findAfilTempById?id=" + ids,

            success: function (data) {

                console.log("SUCCESS: ", data);

                if (data) {
                    getListarAfiliaTemp();

                    $("#codBcoDestino").val(data.codBcoDestino.split("-")[0]);
                    $("#tipoOperacion").val(data.tipoOperacion + "-" + data.nameTipoOperacion);
                    $("input:hidden#tipoPagador").val(data.tipoPagador);
                    $("#tipoDoc").val(data.tipoDoc);
                    $("input#numIdentPagador").val(data.numIdentPagador);
                    $("input#nombrePagador").val(data.nombrePagador);
                    $("input#refContrato").val(data.refContrato);
                    $("input#ctaBcoDestino").val(data.ctaBcoDestino);


                    $("#alert-reg-afilia").hide();
                } else {

                    $("#alert-reg-afilia").show();
                    $("#alert-reg-afilia").html("<strong> No se encontr&oacute; elemento a editar.</strong><br>");
                }

            }


        });

    }
    function buscarAfiliadoByNumDoc(claveOrdenante) {
        //
        $.ajax({
            type: 'GET',
            contentType: "application/json",
            url: "/bbcdomiweb/findAfiliaByNumDoc?numDoc=" + claveOrdenante,

            success: function (data) {

                console.log("SUCCESS: ", data);

                if (data) {
                    getListarAfiliaTemp();
                    $("#codBcoDestino").val(data.codBcoDestino.split("-")[0]);
                    $("input#nombrePagador").val(data.nombrePagador);
                    $("input#refContrato").val(data.refContrato);
                    $("input#ctaBcoDestino").val(data.ctaBcoDestino);
                    $("#alert-reg-afilia").hide();
                } else {
                    $("#alert-reg-afilia").show();
                    $("#alert-reg-afilia").html("<strong> No se encontr&oacute; elemento a editar.</strong><br>");
                }
            }
        });

    }
    function buscarEmpresaOrdenante(claveOrdenante) {
        //
        $.ajax({
            type: 'GET',
            contentType: "application/json",
            url: "/bbcdomiweb/buscarEmpresaOrdenanteByRif?rif=" + claveOrdenante,

            success: function (data) {

                console.log("SUCCESS: ", data);

                if (data.codigo == '000') {
                    $("#alert-reg-afilia").hide();
                } else {
                    $("#alert-reg-afilia").show();
                    $("#alert-reg-afilia").html("<strong> " + data.descripcion + ".</strong><br>");
                    $("#regAfiliacion")[0].reset();
                }

            }


        });

    }
    function enableSearchButton(flag) {
        $("#btn-search").prop("disabled", flag);
    }
    function display(data) {
        var json = "<h4>Ajax Response</h4><pre>"
                + JSON.stringify(data, null, 4) + "</pre>";
        $('#feedback').html(json);
    }
    function validaRif(RIF) {

        var SumRIF;
        var NumRif;
        NumRif = RIF
        var cadena = new Array();
        if (NumRif.length == 10)
        {
            for (i = 0; i < 10; i++)
            {
                cadena[i] = NumRif.substr(i, 1);
            }
            cadena[0] = 0;
            if ((NumRif.substr(0, 1) == "V") || (NumRif.substr(0, 1) == "v"))
                cadena[0] = 1
            if ((NumRif.substr(0, 1) == "E") || (NumRif.substr(0, 1) == "e"))
                cadena[0] = 2
            if ((NumRif.substr(0, 1) == "J") || (NumRif.substr(0, 1) == "j"))
                cadena[0] = 3
            if ((NumRif.substr(0, 1) == "P") || (NumRif.substr(0, 1) == "p"))
                cadena[0] = 4
            if ((NumRif.substr(0, 1) == "G") || (NumRif.substr(0, 1) == "g"))
                cadena[0] = 5
            cadena[0] = cadena[0] * 4
            cadena[1] = cadena[1] * 3
            cadena[2] = cadena[2] * 2
            cadena[3] = cadena[3] * 7
            cadena[4] = cadena[4] * 6
            cadena[5] = cadena[5] * 5
            cadena[6] = cadena[6] * 4
            cadena[7] = cadena[7] * 3
            cadena[8] = cadena[8] * 2
            SumRIF = cadena[0] + cadena[1] + cadena[2] + cadena[3] +
                    cadena[4] + cadena[5] + cadena[6] + cadena[7] + cadena[8];
            EntRIF = parseInt(SumRIF / 11);
            Residuo = SumRIF - (EntRIF * 11)
            DigiVal = 11 - Residuo;
            if (DigiVal > 9)
                DigiVal = 0;
            if (DigiVal == cadena[9])
                return true;
            else
                return false;
        } else
            return false;
    }
    function validarFormulario() {
        if (!validarCamposFormulario("numIdentPagador")) {
            return false;
        } else if (!validarCamposFormulario("rif")) {
            return false;
        } else if (!validarCamposFormulario("nombrePagador")) {
            return false;
        } else if (!validarCamposFormulario("refContrato")) {
            return false;
        } else if (!validarCamposFormulario("ctaBcoDestino")) {
            return false;
        } else {
            return true;
        }


    }


    function  validarCamposFormulario(nombreCampo) {
        var flag = true;
        var mensagge = "";
        var alertaNumIden = "";

        if (nombreCampo == "numIdentPagador") {

            if ($("#numIdentPagador").val() == "") {
                alertaNumIden = " <strong> El campo n&uacute;mero de Identificador no puede estar vac&iacute;o. </strong><br>";
                flag = false;
            } else if ($("#numIdentPagador").val().length < 6) {
                alertaNumIden = alertaNumIden + " <strong>El campo n&uacute;mero de Identificador debe ser mayor a 6 caracteres.</strong> <br>";
                flag = false;
            } else if ($("#numIdentPagador").val().length > 13) {
                var alertaNumIden = alertaNumIden + "<strong> El campo n&uacute;mero de Identificador debe ser menor a 9 caracteres. </strong><br>";
                flag = false;
            } else if (isNaN($('#numIdentPagador').val())) {
                var alertaNumIden = alertaNumIden + "<strong>El campo n&uacute;mero de Identificador debe ser num&eacute;rico. </strong> <br>";
                flag = false;
            }

        }
        if (nombreCampo == "rif") {
            var typeDoc = $("#tipoDoc").val();
            if ($("#tipoDoc").val() == 'J' || $("#tipoDoc").val() == 'G') {
                if (!validaRif($("#tipoDoc").val() + $("input#numIdentPagador").val())) {
                    var alertaNumIden = alertaNumIden + "<strong>El Nro. de identificaci&oacute;n de persona Natural o Jur&iacute;dico Rif est&aacute; errado. </strong> <br>";
                    flag = false;
                }
            }


        }
        var valNomPaga = /[A-Za-z0-9 ]$/;
        if (nombreCampo == "nombrePagador") {
            if ($("#nombrePagador").val() == "") {
                alertaNumIden = " <strong> El campo nombre del pagador no puede estar vac&iacute;o. </strong><br>";
                flag = false;
            } else if ($("#nombrePagador").val().length < 6) {
                alertaNumIden = alertaNumIden + " <strong>El campo nombre del pagador debe ser mayor a 6 caracteres. </strong> <br>";
                flag = false;
            } else if ($("#nombrePagador").val().length > 30) {
                var alertaNumIden = alertaNumIden + "<strong> El campo nombre del pagador debe ser menor a 30 caracteres. </strong><br>";
                flag = false;
            } else if (!valNomPaga.test($('#nombrePagador').val())) {
                var alertaNumIden = alertaNumIden + "<strong>El campo nombre del pagador contiene caracteres no permitidos.  </strong> <br>";
                flag = false;
            }
        }
        var valRefCon = /[A-Za-z0-9]$/;
        if (nombreCampo == "refContrato") {
            if ($("#refContrato").val() == "") {
                alertaNumIden = " <strong> El campo referencia contrato no puede estar vac&iacute;o. </strong><br>";
                flag = false;
            } else if (!($("#refContrato").val().length <= 30)) {
                alertaNumIden = alertaNumIden + " <strong>El campo referencia contrato debe ser menor o igual a 30 caracteres. </strong> <br>";
                flag = false;
            } else if (!valRefCon.test($('#refContrato').val())) {
                var alertaNumIden = alertaNumIden + "<strong>El campo referencia contrato debe respetar el Formato. </strong> <br>";
                flag = false;
            }
        }
        if (nombreCampo == "ctaBcoDestino") {

            if ($("#ctaBcoDestino").val() == "") {
                alertaNumIden = " <strong> El campo n&uacute;mero de cuenta destino no puede estar vac&iacute;o. </strong><br>";
                flag = false;
            } else if ($("#ctaBcoDestino").val().length != 20) {
                alertaNumIden = alertaNumIden + " <strong>El campo n&uacute;mero de cuenta destino debe contener  20 d&iacute;gitos.</strong> <br>";
                flag = false;
            } else if (isNaN($('#ctaBcoDestino').val())) {
                var alertaNumIden = alertaNumIden + "<strong>El campo n&uacute;mero de cuenta destino debe ser num&eacute;rico.</strong> <br>";
                flag = false;
            } else if (!(($("#codBcoDestino").val()).split("-")[0] == ($("#ctaBcoDestino").val()).substring(0, 4))) {
                alertaNumIden = " <strong> Cuenta no pertenece a Banco Destino. </strong><br>";
                flag = false;
            }

        }
        if (flag) {
            $("#alert-reg-afilia").hide();
        } else {
            $("#alert-reg-afilia").show();
            $("#alert-reg-afilia").html(alertaNumIden);
        }
        return flag;
    }

});




