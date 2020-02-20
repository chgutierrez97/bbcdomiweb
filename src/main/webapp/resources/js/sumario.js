$(document).ready(function () {
    getListarAfiliaTemp() 
    
    
    
    $("#btnProcesarAfiliaciones").click(function (evt) {
        evt.preventDefault();
        $.ajax({
            type: "GET",
            url: "/bbcdomiweb/procesarAfiliaciones",
            success: function (data) {

                console.log("SUCCESS: ", data);
                if(data){
                    $('#mensajeGenericoMasiAfi').modal('show');
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
    
      $("#btnMensaje").click(function (evt) {
        evt.preventDefault();
        location.href = "home";
     });
    
    $("#cancelarMasivoAfiliacion").click(function (evt) {
                evt.preventDefault();

                $.ajax({
                    type: "GET",
                    url: "/bbcdomiweb/cancelarDomiciliacion",

                    dataType: 'json',
                    timeout: 100000,
                    success: function (data) {
                         console.log("SUCCESS: ", data);
                         location.href ="home";
 
                    }
                });
                

     });
     
    function getListarAfiliaTemp() {
        //
       $.ajax({
            type: "GET",
            url: "/bbcdomiweb/getSumariAfilMasiva",
            success: function (data) {
                $("#sumarioAfiliaMasivo > tbody").html("");
               
                    var tds = '<tr><td>'+data.nombreDeArchivo+'</td><td>'+data.fechaString+'</td><td>'+data.numRegProcesados+'</td><td>'+data.numRegValidados+'</td><td>'+data.numRegRechazados+'</td></tr> ';
               
                    if(data.numRegRechazados==data.numRegProcesados){
                        $('#btnProcesarAfiliaciones').attr("disabled", true);
                        $('#btnProcesarAfiliaciones').css('background', '#a51717');
                        $("#alertaSumario").removeClass("alert-warning");
                        $("#alertaSumario").addClass("alert-danger");
                        $('#alertaSumario').show();
                        $("#alertaSumario").html("<strong> Advertencia: </strong>El archivo contiene en su totalidad registros con  errores, por lo que no se puede procesar. favor corregir y enviar nuevamente. <br>");
                        
                    }else if(data.numRegValidados>0 && (data.numRegValidados!=data.numRegProcesados)){
                         $("#sumarioAfiliaMasivo").append(tds);
                         $('#alertaSumario').show();
                         $("#alertaSumario").html("<strong> Advertencia: </strong>  Existen registros con errores de validación. Presione Enviar si desea continuar con el proceso. <br>");
                        
                    }else{
                        $("#sumarioAfiliaMasivo").append(tds);
                        $('#alertaSumario').hide();
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

              
                   /* */
         

    }
    
    
    
    
    
    
    
    
});



