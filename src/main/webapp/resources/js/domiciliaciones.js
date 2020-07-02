var swMasivaD = 1;
$(document).ready(function () {
    getListarDomiciliacionesTemp();
    $("#masivoPagos").hide();
    $("#manualDomiciliacion").hide();
    $("#alert-suc").hide();
    $("#alert-dan").hide();
    $("#montoDomi").mask('0.000.000.000.000,00', {reverse: true});
    $("#lbeTmonto").mask('000.000.000.000.000,00', {reverse: true});

    getFechaHoy();

    $("#selectDomiciliacion").change(function () {
        $("#regDomiciliacion")[0].reset();
        $("#masivoAfiliacion").hide();
        $("#manual-afiliacion").hide();
        $('#selectAfiliacion option:first').prop('selected', true);


        switch ($("#selectDomiciliacion option:selected").val()) {
            case '1':
                swMasivaD = 0;
                $("#masivoPagos").show();
                $("#manualDomiciliacion").hide();
                $("#panelPpalDomi").hide();
                $("#alert-error-file").hide();
                $("#logo2").show();
                break;
            case '2':
                $("#masivoPagos").hide();
                $("#manualDomiciliacion").show();
                $("#panelPpalDomi").hide();
                $("#btn-1").hide();
                $("#btn-2").hide();
                $("#btn-3").hide();
                $("#alert-error-file").hide();
                $("#logo1").hide();
                $("#logo2").show();
                break;
            default:
                $("#masivoPagos").hide();
                $("#manualDomiciliacion").hide();
        }

    });


    $("#numIdentPagadorDomi").keyup(function () {
        this.value = (this.value + '').replace(/[^0-9]/g, '');
    });

    $("#montoDomi").keyup(function () {
        this.value = (this.value + '').replace(/[^0-9,.]/g, '');
    });

    $("#nroFacturaDomi").keyup(function () {
        this.value = (this.value + '').replace(/[^0-9]/g, '');
    });

    $("#profile-tab").click(function () {
        $("#alert-error-file").hide();
    });



    $("#btnAgregarDomi").click(function (evt) {
        evt.preventDefault();
        var search = {}
        if (validarFormulario()) {
            search["tipoDoc"] = $("#tipoDocDomi").val();
            search["numIdentPagador"] = $("input#numIdentPagadorDomi").val();
            search["nombrePagador"] = $("input#nombrePagadorDomi").val();
            search["codBcoDestino"] = ($("#codBcoDestinoDomi").val()).split("-")[0];
            search["nameBcoDestino"] = ($("#codBcoDestinoDomi").val()).split("-")[1];
            search["ctaBcoDestino"] = $("input#ctaBcoDestinoDomi").val();
            search["tipoPagador"] = $("input:hidden#tipoPagadorDomic").val();
            search["monto"] = $("input#montoDomi").val();
            search["fechaEmision"] = $("input#fechaEmisionDomi").val();
            search["fechaVcto"] = $("input#fechaVctoDomi").val();
            search["nroFactura"] = $("input#nroFacturaDomi").val();
            search["refContrato"] = $("input#refContratoDomi").val();
            search["tipoOperacion"] = $("input#tipoOperacion").val();

            if (validarFormulario()) {
                $.ajax({
                    type: "POST",
                    contentType: "application/json",
                    url: "/bbcdomiweb/regDomiciliacionTemp",
                    data: JSON.stringify(search),
                    dataType: 'json',
                    timeout: 100000,
                    success: function (data) {
                        var formatter = new Intl.NumberFormat('de-DE', {
                            minimumFractionDigits: 2
                        });
                        $("#tableRegIndividualDomic > tbody").html("");
                        $.each(data.list, function (i, item) {
                            var tds =
                                    '<tr><td style="border: hidden">' + item.tipoDoc + item.numIdentPagador + '</td><td style="border: hidden">' +
                                    item.nombrePagador + '</td><td style="border: hidden">' +
                                    item.ctaBcoDestino + '</td><td style="border: hidden">' +
                                    item.monto + '</td><td style="border: hidden">' +
                                    item.nroFactura + '</td><td style="border: hidden">' +
                                    item.fechaEmision + '</td><td style="border: hidden">' +
                                    item.fechaVcto + '</td><td style="border: hidden">        <a id="' + item.id + '" title="Editar" class="fa fa-pencil" aria-hidden="true" style="color: #666666; cursor:pointer;"></a>                     \n\
                                    <a id="' + item.id + '" title="Borrar"  class="fa fa-trash" aria-hidden="true" style="color: #666666; cursor:pointer;"></a>          </td></tr> ';
                            $("#tableRegIndividualDomic").append(tds);
                        });
                        if (data.numRegistros != 0) {
                            document.getElementById('lbeTregs').innerHTML = 'Total Registros : ' + data.numRegistros;
                            document.getElementById('lbeTmonto').innerHTML = 'Total monto : ' + formatter.format(data.totalMontosString);
                        } else {
                            document.getElementById('lbeTregs').innerHTML = '' + data.numRegistros;
                            document.getElementById('lbeTmonto').innerHTML = '' + formatter.format(data.totalMontosString);
                        }
                    },
                    error: function (e) {
                        console.log("ERROR: ", e);

                    },
                    done: function (e) {
                        console.log("DONE");
                        enableSearchButton(true);
                    }
                });
            }
            $("#regDomiciliacion")[0].reset();
        }
    });


    $("body").on("click", "#tableRegIndividualDomic  a", function (event) {
        event.preventDefault();
        idsele = $(this).attr("id");
        accion = $(this).attr("title")

        if (accion == "Editar") {
            buscarElementoById(idsele);
            eliminarElemento(idsele)
        } else {
            eliminarElemento(idsele);
            console.log("borrar");
        }

    })

    function buscarElementoById(ids) {
        //
        $.ajax({
            type: 'GET',
            contentType: "application/json",
            url: "/bbcdomiweb/findDomicTempById?id=" + ids,

            success: function (data) {

                console.log("SUCCESS: ", data);

                if (data) {
                    getListarDomiciliacionesTemp();
                    document.getElementById("tipoDocDomi").selectedIndex = 0;
                    document.getElementById("tipoDocDomi").value = data.tipoDoc;
                    $("input#nombrePagadorDomi").val(data.nombrePagador);
                    $("input#numIdentPagadorDomi").val(data.numIdentPagador);
                    $("input#montoDomi").val(data.monto);
                    $("input#nroFacturaDomi").val(data.nroFactura);
                    var fechaini = data.fechaEmision.split("/");
                    var fechafin = data.fechaVcto.split("/");
                    $("#fechaEmisionDomi").val(fechaini[2] + '-' + fechaini[1] + '-' + fechaini[0]);
                    $("input#fechaVctoDomi").val(fechafin[2] + '-' + fechafin[1] + '-' + fechafin[0]);
                    $("input#refContratoDomi").val(data.refContrato);
                    $("input#ctaBcoDestinoDomi").val(data.ctaBcoDestino);
                    $("input#codBcoDestinoDomi").val(data.codBcoDestino.split("-")[0]);
                    $("input#nombreBcoDestinoDomi").val(data.codBcoDestino.split("-")[1]);
                    $("#alert-reg-domi").hide();
                    $("#alert-reg-afilia").hide();
                } else {
                    $("#alert-reg-afilia").show();
                    $("#alert-reg-afilia").html("<strong> No se encontro elemento a editar.</strong><br>");
                }

            }


        });

    }

    function eliminarElemento(ids) {
        //
        $.ajax({
            type: 'GET',
            contentType: "application/json",
            url: "/bbcdomiweb/delDomicTemp?id=" + ids,

            success: function (data) {

                console.log("SUCCESS: ", data);

                if (data) {
                    getListarDomiciliacionesTemp();
                    $("#alert-reg-afilia").hide();
                } else {
                    $("#alert-reg-afilia").show();
                    $("#alert-reg-afilia").html("<strong> No se encontro elemento a eliminar.</strong><br>");
                }

            }


        });

    }

    function getListarDomiciliacionesTemp() {
        $.ajax({
        type: "GET",
                url: "/bbcdomiweb/getDomicTemp",
                success: function (data) {
                var formatter = new Intl.NumberFormat('de-DE', {
                minimumFractionDigits: 2
                });
                        $("#tableRegIndividualDomic > tbody").html("");
                        $.each(data.list, function (i, item) {
                        var tds =
                                '<tr><td style="border: hidden">' + item.tipoDoc + item.numIdentPagador + '</td><td style="border: hidden">' +
                                item.nombrePagador + '</td><td style="border: hidden">' +
                                item.ctaBcoDestino + '</td><td style="border: hidden">' +
                                item.monto + '</td><td style="border: hidden">' +
                                item.nroFactura + '</td><td style="border: hidden">' +
                                item.fechaEmision + '</td><td style="border: hidden">' +
                                item.fechaVcto + '</td><td style="border: hidden">        <a id="' + item.id + '" title="Editar" class="fa fa-pencil" aria-hidden="true" style="color: #666666; cursor:pointer;"></a>                     \n\
                                    <a id="' + item.id + '" title="Borrar"  class="fa fa-trash" aria-hidden="true" style="color: #666666; cursor:pointer;"></a>          </td></tr> ';
                                $("#tableRegIndividualDomic").append(tds);
                        });
                        if (data.numRegistros != 0) {
                            document.getElementById('lbeTregs').innerHTML = 'Total Registros : ' + data.numRegistros;
                            document.getElementById('lbeTmonto').innerHTML = 'Total monto : ' + formatter.format(data.totalMontosString);
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
        }

        function getFechaHoy() {
        //
        $.ajax({
            type: "GET",
            url: "/bbcdomiweb/getfecha",
            success: function (data) {
                var tds = data;
                $("#fechaEmisionDomi").attr("min", data);
                $("#fechaVctoDomi").attr("min", data);
                console.log("SUCCESS: ", data);
//                display(data);
            },
            error: function (e) {
                console.log("ERROR: ", e);

            },
            done: function (e) {
                console.log("DONE");
                enableSearchButton(true);
            }
        });

    }

    $("#btnMensaje").click(function (evt) {
        evt.preventDefault();
        location.href = "home";
    });

    $("#btnEnviarDomicIndividual").click(function (evt) {
        evt.preventDefault();

        $.ajax({
            type: "GET",
            url: "/bbcdomiweb/saveTempDomiciliacion",

            dataType: 'json',
            timeout: 100000,
            success: function (data) {
                if (data.codigo == "000") {
                    console.log("SUCCESS: ", data);
                    $('#mensajeGenerico').modal('show');

                    $("#alert-reg-domi").hide();
                } else {
                    $("#alert-reg-domi").show();
                    $("#alert-reg-domi").html("<strong>" + data.descripcion + "</strong> <br>");
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



    });

    $("#tipoDocDomi").change(function () {
        var opcion = $("#tipoDocDomi option:selected").text();

        if (opcion == 'V' || opcion == 'E' || opcion == 'P') {
            $("#tipoPagadorDomic").val("N");
        } else if (opcion == 'J' || opcion == 'G') {
            $("#tipoPagadorDomic").val("J");
        } else {
            $("#tipoPagadorDomic").val("");

        }


    });


    function validarFormulario() {
        if (!validarCamposFormulario("numIdentPagadorDomi")) {
            return false;
        } else if (!validarCamposFormulario("nombrePagadorDomi")) {
            return false;
        } else if (!validarCamposFormulario("ctaBcoDestinoDomi")) {
            return false;
        } else if (!validarCamposFormulario("ctaBcoDestino")) {
            return false;
        } else if (!validarCamposFormulario("montoDomi")) {
            return false;
        } else if (!validarCamposFormulario("fechaEmisionDomi")) {
            return false;
        } else if (!validarCamposFormulario("fechaVctoDomi")) {
            return false;
        } else if (!validarCamposFormulario("nroFacturaDomi")) {
            return false;
        } else if (!validarCamposFormulario("refContratoDomi")) {
            return false;
        } else {
            return true;
        }
    }

    function  validarCamposFormulario(nombreCampo) {
        var flag = true;
        var alerta = "";
        switch (nombreCampo) {
            case 'numIdentPagadorDomi':
                if ($("#numIdentPagadorDomi").val() == "") {
                    alerta = " <strong> El campo N&uacute;mero de Identificador no puede estar vac&iacute;o. </strong><br>";
                    flag = false;
                } else if ($("#numIdentPagadorDomi").val().length < 6) {
                    alerta = alerta + " <strong>El campo N&uacute;mero de Identificador debe ser mayor a 6 caracteres.</strong> <br>";
                    flag = false;
                } else if ($("#numIdentPagadorDomi").val().length > 9) {
                    var alerta = alerta + "<strong> El campo N&uacute;mero de Identificador debe ser menor a 9 caracteres.</strong><br>";
                    flag = false;
                } else if (isNaN($('#numIdentPagadorDomi').val())) {
                    var alerta = alerta + "<strong>El campo N&uacute;mero de Identificador debe ser num&eacute;rico.</strong> <br>";
                    flag = false;
                }
                break;
            case 'rif':
                var typeDoc = $("#tipoDoc").val();
                if (!validaRif($("#tipoDoc").val() + $("input#numIdentPagador").val())) {
                    var alertaNumIden = alertaNumIden + "<strong>El N° de identificaci&oacute;n de persona Natural o Jur&iacute;dico Rif esta errado.</strong> <br>";
                    flag = false;
                }
                break;
            case 'nombrePagadorDomi':
                var valNomPaga = /[A-Za-z0-9 ]$/;
                if ($("#nombrePagadorDomi").val() == "") {
                    alerta = " <strong> El campo nombre del pagador no puede estar vac&iacute;o.</strong><br>";
                    flag = false;
                } else if ($("#nombrePagadorDomi").val().length < 6) {
                    alerta = alerta + " <strong>El campo nombre del pagador debe ser mayor a 6 caracteres.</strong> <br>";
                    flag = false;
                } else if ($("#nombrePagadorDomi").val().length > 30) {
                    var alerta = alerta + "<strong> El campo nombre del pagador debe ser menor a 30 caracteres.</strong><br>";
                    flag = false;
                } else if (!valNomPaga.test($('#nombrePagadorDomi').val())) {
                    var alerta = alerta + "<strong>El campo nombre del pagador contiene caracteres no permitidos.</strong> <br>";
                    flag = false;
                }
                var valRefCon = /[A-Za-z0-9]$/;
                break;
            case 'ctaBcoDestinoDomi':
                if ($("#ctaBcoDestinoDomi").val() == "") {
                    alerta = " <strong> El campo N&uacute;mero de cuenta destino no puede estar vac&iacute;o.</strong><br>";
                    flag = false;
                } else if ($("#ctaBcoDestinoDomi").val().length != 20) {
                    alerta = alerta + " <strong>El campo N&uacute;mero de cuenta destino debe contener  20 d&iacute;gitos</strong> <br>";
                    flag = false;
                } else if (isNaN($('#ctaBcoDestinoDomi').val())) {
                    var alerta = alerta + "<strong>El campo N&uacute;mero de cuenta destino debe ser num&eacute;rico </strong> <br>";
                    flag = false;
                } else if (!(($("#codBcoDestinoDomi").val()).split("-")[0] == ($("#ctaBcoDestinoDomi").val()).substring(0, 4))) {
                    alerta = " <strong> Cuenta no pertenece a Banco Destino.</strong><br>";
                    flag = false;
                }
                break;
            case 'montoDomi':
                if ($("#montoDomi").val() == "") {
                    alerta = " <strong> El campo Monto no puede estar vac&iacute;o.</strong><br>";
                    flag = false;
                }
                break;
            case 'fechaEmisionDomi':
                if ($("#fechaEmisionDomi").val() == "") {
                    alerta = " <strong> El campo Fecha de Emisi&oacute;n no puede estar vac&iacute;o.</strong><br>";
                    flag = false;
                } else if ($("#fechaEmisionDomi").val() > $("#fechaVctoDomi").val() && $("#fechaVctoDomi").val() != "") {
                    alerta = " <strong> El campo Fecha de Emisi&oacute;n  debe ser menor a la fecha de vencimiento.</strong><br>";
                    flag = false;
                }
                break;
            case 'fechaVctoDomi':
                if ($("#fechaVctoDomi").val() == "") {
                    alerta = " <strong> El campo Fecha de Vencimiento no puede estar vac&iacute;o.</strong><br>";
                    flag = false;
                }
                break;
            case 'nroFacturaDomi':
                if ($("#nroFacturaDomi").val() == "") {
                    alerta = " <strong> El campo N&uacute;mero de Factura no puede estar vac&iacute;o.</strong><br>";
                    flag = false;
                }
                break;
            case 'refContratoDomi':
                if ($("#refContratoDomi").val() == "") {
                    alerta = " <strong> El campo Referencia Contrato no puede estar vac&iacute;o.</strong><br>";
                    flag = false;
                }
                break;

            default :
                break;
        }
        if (flag) {
            $("#alert-reg-domi").hide();
        } else {
            $("#alert-reg-domi").show();
            $("#alert-reg-domi").html(alerta);
        }
        return flag;
    }

    $("input[id=numIdentPagadorDomi]").change(function () {
        var doc = $("#tipoDocDomi").val() + $("#numIdentPagadorDomi").val();
        buscarAfiliadoByNumDoc(doc);
    });

    function buscarAfiliadoByNumDoc(numIdentificador) {
        $.ajax({
            type: 'GET',
            contentType: "application/json",
            url: "/bbcdomiweb/findAfiliaByNumDoc2?numDoc=" + numIdentificador,
            success: function (data) {
                console.log("SUCCESS: ", data);
                if (data.nombrePagador != null) {
                    getListarDomiciliacionesTemp();
                    $("input#nombrePagadorDomi").val(data.nombrePagador);
                    $("input#refContratoDomi").val(data.refContrato);
                    $("input#ctaBcoDestinoDomi").val(data.ctaBcoDestino);
                    $("input#codBcoDestinoDomi").val(data.codBcoDestino.split("-")[0]);
                    $("input#nombreBcoDestinoDomi").val(data.codBcoDestino.split("-")[1]);
                    $("input#nroFacturaDomi").val(data.refContrato);
                    ;
                    $("#alert-reg-domi").hide();
                } else {
                    $("#alert-reg-domi").show();
                    $("#alert-reg-domi").html("<strong> No se encontr&oacute el N&uacute;mero Identificador de Pagador</strong><br>");
                }
            }
        });
    }
});
