/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var json = "";
var pag = 1;
var totales = 0;
var xPag = 9999999999999999;
var nPag = 0;
var offset = 0;
var hasta = 0;
function mostrarLista(desde, hasta, opcion) {
    var lista = '';
    if (hasta > totales) {
        hasta = totales
    }
    if (opcion == 1) {
        $("#consulta-consolidado-afiliacion > tbody").html("");
    } else {
        $("#consulta-consolidado-cobros > tbody").html("");
    }

//             nroRegistrosPendientes
    for (var i = desde; i < hasta; i++) {
        var d = new Date(json[i].fechaHoraCarga);
        var dia = d.getDate();
        var mes = (d.getMonth()+1);
        if(dia < 10){
            dia = '0' + dia;
        }
        if(mes < 10){
            mes = '0' + mes;
        }
        var tds =
                '<tr><td style="border: hidden">' + dia + '/' + mes + '/' + d.getFullYear() + '</td><td style="border: hidden">' +
                json[i].nombreArchivo + '</td><td style="border: hidden">' +
                json[i].nroRegistrosProcesar + '</td><td style="border: hidden">' +
                json[i].nroRegistrosPendientes + '</td><td style="border: hidden">' +
                json[i].nroRegistrosValidados + '</td><td style="border: hidden">' +
                json[i].nroRegistrosRechazados + '</td><td style="border: hidden" bgcolor="#f8f9fa"><a id="' + json[i].id + '" class="fa fa-search" aria-hidden="true" style="color: #808080; cursor:pointer;"></a></td></tr> ';
        if (opcion == 1) {
            $("#consulta-consolidado-afiliacion").append(tds);
        } else {
            $("#consulta-consolidado-cobros").append(tds);
        }

    }

}
function mostrarListaDet(desde, hasta, opcion) {
    var lista = '';
    if (hasta > totales) {
        hasta = totales
    }
    if (opcion == 1) {
        $("#detalle-afiliacion > tbody").html("");
        $("#detalle-afiliacion-print > tbody").html("");
        for (var i = 0; i < json.length; i++) {
            var op = "";
            var codigoOperacion = "";
            if (json[i].tipoOperacion == 'A') {
                op = "Afiliaci&oacute;n"
            } else {
                op = "Desafiliaci&oacute;n"
            }
            if (json[i].codigoResultado == "null" && json[i].situacion != "C") {
                codigoOperacion = 'APROBADO'
            } else if (json[i].codigoResultado == "null" && json[i].situacion == "C") {
                codigoOperacion = 'PENDIENTE'
            } else {
                codigoOperacion = json[i].codigoResultado;

            }
            var tds =
                    '<tr class="first"><td>' + op + '</td><td>' +
                    json[i].identificacionPagador + '</td><td>' +
                    json[i].nombrePagador + '</td><td>' +
                    json[i].cuentaPagador + '&nbsp' + '</td><td>' +
                    json[i].contrato + '</td><td>' +
                    codigoOperacion + '</td><td>' +
                    json[i].motivoRechazo + '</td></tr>';
            $("#detalle-afiliacion-print").append(tds);
        }
        for (var i = desde; i < hasta; i++) {
            var op = "";
            var codigoOperacion = "";
            if (json[i].tipoOperacion == 'A') {
                op = "Afiliaci&oacute;n"
            } else {
                op = "Desafiliaci&oacute;n"
            }
            if (json[i].codigoResultado == "null" && json[i].situacion != "C") {
                codigoOperacion = 'APROBADO'
            } else if (json[i].codigoResultado == "null" && json[i].situacion == "C") {
                codigoOperacion = 'PENDIENTE'
            } else {
                codigoOperacion = json[i].codigoResultado;

            }
            var tds =
                    '<tr class="first"><td style="border: hidden">' + json[i].tipoOperacion + '</td><td style="border: hidden">' +
                    json[i].identificacionPagador + '</td><td style="border: hidden">' +
                    json[i].nombrePagador + '</td><td style="border: hidden">' +
                    json[i].cuentaPagador + '</td><td style="border: hidden">' +
                    json[i].contrato + '</td><td style="border: hidden">' +
                    codigoOperacion + '</td><tr>';
            $("#detalle-afiliacion").append(tds);
        }
    } else {
        $("#reporte-detalle-cobro > tbody").html("");
        $("#reporte-detalle-cobro-print > tbody").html("");
        var formatter = new Intl.NumberFormat('de-DE', {
                minimumFractionDigits: 2
                });
        for (var i = 0; i < json.length; i++) {
            var d1 = new Date();
            var d = json[i].vencimiento;
            var tds =
                    '<tr class="first"><td style="border: hidden">' + json[i].identificacionPagador + '</td><td style="border: hidden">' +
                    json[i].nombrePagador + '</td><td style="border: hidden">' +
                    json[i].cuentaPagador + '&nbsp' + '</td><td style="border: hidden">' +
                    json[i].monto + '</td><td style="border: hidden">' +
                    json[i].factura.substring(0, 20) + '&nbsp' + '</td><td style="border: hidden">' +
                    json[i].fechaCarga + '</td><td style="border: hidden">' +
                    d + '</td><td style="border: hidden">' +
                    json[i].codigoResultado + '</td><td style="border: hidden">' +
                    json[i].motivoRechazo + '</td></tr>';
            $("#reporte-detalle-cobro-print").append(tds);
        }

        for (var i = desde; i < hasta; i++) {
            var d1 = new Date();
            var d = json[i].vencimiento;
            var tds =
                    '<tr class="first"><td style="border: hidden">' + json[i].identificacionPagador + '</td><td style="border: hidden">' +
                    json[i].nombrePagador + '</td><td style="border: hidden">' +
                    json[i].cuentaPagador + '</td><td style="border: hidden">' +
                    formatter.format(json[i].monto) + '</td><td style="border: hidden">' +
                    json[i].factura.substring(0, 20) + '</td><td style="border: hidden">' +
                    json[i].fechaCarga + '</td><td style="border: hidden">' +
                    d + '</td><td style="border: hidden">' +
                    json[i].codigoResultado + '</td></tr>';
            $("#reporte-detalle-cobro").append(tds);
        }

    }


}

function limpiarBotones(op)
{
    if (op == 1) {
        document.getElementById("botones2").innerHTML = "";
    } else if (op == 2) {
        document.getElementById("botones3").innerHTML = "";
    }

}


function mostrarBotones(t, op) {
    var botones = '';
    for (var i = 0; i < t; i++) {
        var cada = '';
        cada = "<button type='button' " +
                "class='btn btn-primary'  value='" + (i + 1) + "'>" + (i + 1) +
                "</button>";
        botones += cada;
    }
    if (op == 1) {
        $('#botones').append(botones);
    } else if (op == 2) {
        $('#botones1').append(botones);
    } else if (op == 3) {
        $('#botones2').append(botones);
    } else if (op == 4) {
        $('#botones3').append(botones);
    }



}

function quitarActivo(op) {
    var losBotones;
    if (op == 1) {
        losBotones = document.querySelectorAll('#botones button');
    } else if (op == 2) {
        losBotones = document.querySelectorAll('#botones1 button');
    } else if (op == 3) {
        losBotones = document.querySelectorAll('#botones2 button');
    } else if (op == 4) {
        losBotones = document.querySelectorAll('#botones3 button');
    }
    for (var i = 0; i < losBotones.length; i++) {
        $(losBotones[i]).removeClass('active');
    }
}



$(document).ready(function () {
    $("#consulta-afiliacion").hide();
    $("#consultarAfiliacion").hide();
    $("#consultarCobros").hide();
    $("#consulta-consolidado-cobros").hide();
    $("#detalleAfiliacion").hide();
    $("#detalleCobros").hide();
    $("#alert-suc").hide();
    $("#alert-dan").hide();

    $("#profile-tab-consulta").click(function () {
        $("#alert-error-file").hide();
    });

    $("#cancelarDetalleConsulta").click(function () {
        $("#detalleAfiliacion").hide();
        cosolidadoAfiliaciones(2)
        limpiarBotones(1);
        $("#consultarAfiliacion").show();

    });

    $("#cancelarDetalleCobro").click(function () {
        $("#detalleCobros").hide();
        cosolidadoAfiliaciones(2)
        limpiarBotones(2);
        $("#consultarCobros").show();
        $("#consulta-consolidado-cobros").show();
    });


    $("#btnExporDetailAfilia").click(function (evt) {
        evt.preventDefault();
        $("#detalle-afiliacion-print").table2excel({
            exclude: ".noExl",
            name: "Afiliaciones",
            filename: "Afiliaciones" + new Date().toISOString().replace(/[\-\:\.]/g, ""),
            fileext: ".xls",
            exclude_img: true,
            exclude_links: true,
            exclude_inputs: true
        });
    });
    $("#btnExporDetailCobros").click(function (evt) {
        evt.preventDefault();
        $("#reporte-detalle-cobro-print").table2excel({
            exclude: ".noExl",
            name: "Domiciliaciones",
            filename: "Domiciliaciones" + new Date().toISOString().replace(/[\-\:\.]/g, ""),
            fileext: ".xls",
            exclude_img: true,
            exclude_links: true,
            exclude_inputs: true
        });
    });
    $("#selectConsulta").change(function () {
        $("#regAfiliacion")[0].reset();
        $("#masivoPagos").hide();
        $("#manualDomiciliacion").hide();
        $('#selectDomiciliacion option:first').prop('selected', true);
        $("#tipoPagador").val("N");


        switch ($("#selectConsulta option:selected").val()) {
            case '1':
                cosolidadoAfiliaciones(1);
                $("#consulta-consolidado-afiliacion").show();
                $("#btn-1").hide();
                $("#btn-2").hide();
                $("#btn-3").hide();
                $("#consultarCobros").hide();
                $("#consulta-consolidado-cobros").hide();
                $("#detalleAfiliación").hide();
                $("#panelConsulta").hide();
                $("#consultarAfiliacion").show();
                $("#alert-error-file").hide();
            //    $("#logo1").hide();
                $("#logo2").show();
                break;
            case '2':
                cosolidadoDomiciliaciones(1);
                $("#consultarCobros").show();
                $("#consulta-consolidado-cobros").show();
                $("#btn-1").hide();
                $("#btn-2").hide();
                $("#btn-3").hide();
                $("#consultarAfiliacion").hide();
                $("#consulta-afiliacion").hide();
                $("#detalleAfiliacion").hide();
                $("#panelConsulta").hide();
                $("#alert-error-file").hide();
            //    $("#logo1").hide();
                $("#logo2").show();
                break;
            case '3':
                $("#consultarCobros").hide();
                $("#consulta-consolidado-cobros").hide();
                $("#consultarAfiliacion").hide();
                $("#consulta-afiliacion").hide();
                $("#detalleAfiliacion").hide();
                $("#panelConsulta").hide();
                break;

            default:
                $("#panelPpalAfil").show();
                $("#consultarCobros").hide();
                $("#consulta-consolidado-cobros").hide();
                $("#consultarAfiliacion").hide();
                $("#consulta-afiliacion").hide();
                $("#detalleAfiliacion").hide();
                $("#panelConsulta").hide();
        }
    });
    $("body").on("click", "#consulta-consolidado-afiliacion     a", function (event) {
        event.preventDefault();
        idsele = $(this).attr("id");
        accion = $(this).attr("class")

        if (accion != "fa-search") {
            detalleAfiliaciones(idsele);
            $("#consultarCobros").hide();
            $("#consulta-consolidado-cobros").hide();
            $("#consultarAfiliacion").hide();
            $("#consulta-afiliacion").hide();
            $("#detalleAfiliacion").hide();
            $("#panelConsulta").hide();
            $("#detalleAfiliacion").show();
        }
    })

    function cosolidadoAfiliaciones(op) {
        $.ajax({
            type: "GET",
            url: "/bbcdomiweb/consolidadoAfiliaciones",
            dataType: 'json',
            success: function (data) {
                json = data;

                totales = json.length;
                nPag = Math.ceil(totales / xPag);
                offset = (pag - 1) * xPag;
                hasta = pag * xPag;
                mostrarLista(offset, hasta, 1);
                if (op == 1) {
                    if (nPag > 1) {
                        mostrarBotones(nPag, 1);
                    }
                    // Activar el primer botón
                    $('#botones button:first-child').addClass('active');

                    // Poner oyentes a cada botón
                    var losBotones = document.querySelectorAll('#botones button');
                    for (var i = 0; i < losBotones.length; i++) {
                        losBotones[i].addEventListener('click', function () {
                            quitarActivo(1);
                            var indice = parseInt(this.textContent);
                            var o = (indice - 1) * xPag;
                            var h = indice * xPag;
                            mostrarLista(o, h, 1);
                            $(this).addClass('active');
                        });
                    }
                }
                console.log("SUCCESS: ", data);
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

    function detalleAfiliaciones(idsele) {
        $.ajax({
            type: "GET",
            url: "/bbcdomiweb/detalleAfiliaciones?idLote=" + idsele,
            dataType: 'json',
            success: function (data) {
                if (data.length > 0) {
                    json = data;
                    totales = json.length;
                    nPag = Math.ceil(totales / xPag);
                    offset = (pag - 1) * xPag;
                    hasta = pag * xPag;
                    mostrarListaDet(offset, hasta, 1);
                    if (nPag > 1) {
                        if (nPag < 10) {
                            mostrarBotones(nPag, 3);
                        } else {
                            mostrarBotones(nPag, 3);
                        }
                    }
                    // Activar el primer botón
                    $('#botones2 button:first-child').addClass('active');

                    // Poner oyentes a cada botón
                    var losBotones = document.querySelectorAll('#botones2 button');
                    for (var i = 0; i < losBotones.length; i++) {
                        losBotones[i].addEventListener('click', function () {
                            quitarActivo(3);
                            var indice = parseInt(this.textContent);
                            var o = (indice - 1) * xPag;
                            var h = indice * xPag;
                            mostrarListaDet(o, h, 1);
                            $(this).addClass('active');
                        });
                    }
                    $("#alert-warning-det-afi").hide();
                } else {
                    $("#alert-warning-det-afi").show();

                    $("#alert-warning-det-afi").html("<strong>Nota!</strong> En proceso de transmisi&oacute;n al BCV");
                    eliminarFila('detalle-afiliacion');
                }
                console.log("SUCCESS:-----> ", data.length);
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


    function eliminarFila(nombreTabla) {
        // Obtenemos el total de columnas (tr) del id "tabla"
        var trs = $("#" + nombreTabla + " tr").length;
        if (trs > 1)
        {
            // Eliminamos la ultima columna

            for (i = trs; i > 1; i--) {
                $("#" + nombreTabla + " tr:last").remove();
            }

        }

    }

    $("body").on("click", "#consulta-consolidado-cobros a", function (event) {
        event.preventDefault();
        idsele = $(this).attr("id");
        accion = $(this).attr("class")
        if (accion != "fa-search") {
            detalleDomiciliaciones(idsele);
            $("#consultarCobros").hide();
            $("#consulta-consolidado-cobros").hide();
//            document.getElementById("home-tab").disabled = true;
//            document.getElementById("profile-tab").disabled = true;
            $("#consultarAfiliacion").hide();
            $("#consulta-afiliacion").hide();
            $("#detalleAfiliacion").hide();
            $("#panelConsulta").hide();
            $("#detalleCobros").show();
        }
    })

    function cosolidadoDomiciliaciones(op) {
        $.ajax({
            type: "GET",
            url: "/bbcdomiweb/cosolidadoDomiciliaciones",
            dataType: 'json',
            success: function (data) {

                json = data;
                totales = json.length;
                nPag = Math.ceil(totales / xPag);
                offset = (pag - 1) * xPag;
                hasta = pag * xPag;
                mostrarLista(offset, hasta, 2);
                if (op == 1) {
                    if (nPag > 1) {
                        mostrarBotones(nPag, 2);
                    }
                    // Activar el primer botón
                    $('#botones1 button:first-child').addClass('active');

                    // Poner oyentes a cada botón
                    var losBotones = document.querySelectorAll('#botones1 button');
                    for (var i = 0; i < losBotones.length; i++) {
                        losBotones[i].addEventListener('click', function () {
                            quitarActivo(2);
                            var indice = parseInt(this.textContent);
                            var o = (indice - 1) * xPag;
                            var h = indice * xPag;
                            mostrarLista(o, h, 2);
                            $(this).addClass('active');
                        });
                    }
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

    function detalleDomiciliaciones(idsele) {
        $.ajax({
            type: "GET",
            url: "/bbcdomiweb/detalleDomiciliaciones?idLote=" + idsele,
            dataType: 'json',
            success: function (data) {
                if (data.length > 0) {
                    json = data;
                    totales = json.length;
                    nPag = Math.ceil(totales / xPag);
                    offset = (pag - 1) * xPag;
                    hasta = pag * xPag;
                    mostrarListaDet(offset, hasta, 2);
                    if (nPag > 1) {
                        mostrarBotones(nPag, 4);
                    }
                    // Activar el primer botón
                    $('#botones3 button:first-child').addClass('active');

                    // Poner oyentes a cada botón
                    var losBotones = document.querySelectorAll('#botones3 button');
                    for (var i = 0; i < losBotones.length; i++) {
                        losBotones[i].addEventListener('click', function () {
                            quitarActivo(4);
                            var indice = parseInt(this.textContent);
                            var o = (indice - 1) * xPag;
                            var h = indice * xPag;
                            mostrarListaDet(o, h, 2);
                            $(this).addClass('active');
                        });
                    }
                    $("#alert-warning-det-dom").hide();
                } else {

                    $("#alert-warning-det-dom").show();

                    $("#alert-warning-det-dom").html("<strong>Nota!</strong> En proceso de transmisi&oacute;n al BCV");
                    eliminarFila('reporte-detalle-cobro');

                }
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


    $(document).ready(function () {
        (function ($) {
            $('#filtrar').keyup(function () {
                var rex = new RegExp($(this).val(), 'i');
                $('.buscar tr').hide();
                $('.buscar tr').filter(function () {
                    return rex.test($(this).text());
                }).show();
            })
        }(jQuery));
    }
    );

    $(document).ready(function () {
        (function ($) {
            $('#filtrar2').keyup(function () {
                var rex = new RegExp($(this).val(), 'i');
                $('.buscar tr').hide();
                $('.buscar tr').filter(function () {
                    return rex.test($(this).text());
                }).show();
            })
        }(jQuery));
    });
    $("#btnFirsConAf").click(function (evt) {
        evt.preventDefault();

        a

        var pagActual = $(".first");


    });

    $("#btnNexConAf").click(function (evt) {
        evt.preventDefault();


    });

});
