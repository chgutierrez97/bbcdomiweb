$(document).ready(function () {
    getSumarioDomicMasiva() 
    
    
    
    $("#btnProcesarDomiciliaciones").click(function (evt) {
        evt.preventDefault();
        $.ajax({
            type: "GET",
            url: "/bbcdomiweb/procesarDomiciliaciones",
            success: function (data) {

                console.log("SUCCESS: ", data);
                if(data){
                    $('#mensajeGenericoMasiAfi').modal('show');
                    //location.href ="home";
                }else{
                    alert("errot en proceso");
                    
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
    
    $("#cancelarMasivoDomiciliacion").click(function (evt) {
                evt.preventDefault();

                $.ajax({
                    type: "GET",
                    url: "/bbcdomiweb/cancelarDomiciliacion",

                    dataType: 'json',
                    timeout: 100000,
                    success: function (data) {
                         console.log("SUCCESS: ", data);
                         location.href ="home";
 
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
     
      $("#btnMensaje").click(function (evt) {
        evt.preventDefault();
        location.href = "home";
      });
     
    function getSumarioDomicMasiva() {
        //
       $.ajax({
            type: "GET",
            url: "/bbcdomiweb/getSumarioDomicMasiva",
            success: function (data) {
                var formatter = new Intl.NumberFormat('de-DE', {
                minimumFractionDigits: 2
                });
                $("#sumarioDomicMasivo > tbody").html("");
                    var tds = '<tr><td style="border: hidden">'+data.nombreDeArchivo+'</td><td style="border: hidden">'
                            +data.fechaString+'</td><td style="border: hidden">'
                            +data.numRegProcesados+'</td><td style="border: hidden">'
                            +data.numRegRechazados+'</td><td style="border: hidden">'
                            +data.numRegValidados+'</td><td style="border: hidden">'
                            +formatter.format(data.montoTotal)+'</td></tr> ';
                    $("#sumarioDomicMasivo").append(tds);
                    
               
                   if(data.numRegRechazados==data.numRegProcesados){
                        $('#btnProcesarDomiciliaciones').attr("disabled", true);
                        $('#btnProcesarDomiciliaciones').css('background', '#a51717');
                        $("#alertaSumario").removeClass("alert-warning");
                        $("#alertaSumario").addClass("alert-danger");
                        $('#alertaSumario').show();
                        $("#alertaSumario").html("<strong> Nota: </strong>El archivo contiene errores de formato. Revise y realice la carga nuevamente. <br>");
                        
                    }else if(data.numRegValidados>0 && (data.numRegValidados!=data.numRegProcesados)){
                         $('#alertaSumario').show();
                         $("#alertaSumario").html("<strong> Nota: </strong>Hay algunos registros del archivo con errores <br>");
                        
                    }else{
                        $('#alertaSumario').hide();
                    }
                console.log("SUCCESS: ", data);
                
            },
            error: function (e) {
                $('#alertaSumario').show();
                $("#alertaSumario").html("<strong> Nota: </strong>Hay algunos registros del archivo con errores <br>");
                console.log("ERROR: ", e);
                display(e);
            },
            done: function (e) {
                console.log("DONE");
                enableSearchButton(true);
            }
        });
    }
});



