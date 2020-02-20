
$(document).ready(function () {
    
    $("#afiliaciones").show();
    $("#pagos").hide();
    $("#mconsulta").hide();
    $("#home-tab-af-aux").hide();
    $("#home-tab-pg-aux").hide();
    $("#profile-tab-consulta-aux").hide();
    
    $("#pane11").show();
    $("#pane12").show();
    $("#pane13").show();
    $("#logo1").show();
    $("#logo2").hide();
    

    
//    $('.home-tab-af').hover(function () {     
//        $(this).attr("src", "resources/images/afiliar-2.png");      
//    }, function () {
//        $(this).attr("src", "resources/images/afiliar-1.png");
//    });
//    
//    $('.profile-tab-pg').hover(function () {       
//            $(this).attr("src", "resources/images/cobrar-2.png");         
//    }, function () {
//        $(this).attr("src", "resources/images/cobrar-1.png");
//    });
//    
//    $('.profile-tab-consulta').hover(function () {      
//            $(this).attr("src", "resources/images/consultar-2.png");
//    }, function () {
//        $(this).attr("src", "resources/images/consultar-1.png");
//    });
    
    $('.home-tab-af').click(function () {   
        $("#afiliaciones").show();
        $("#pagos").hide();
        $("#consulta").hide();
        $(this).attr("src", "resources/images/afiliar-2.png");
        $("#home-tab-pg").attr("src", "resources/images/cobrar-1.png");
        $("#profile-tab-consulta").attr("src", "resources/images/consultar-1.png");
        btn_cs_sts=1;
        
    });
    
    
      $('.profile-tab-pg').click(function () {   
        $("#afiliaciones").hide();
        $("#pagos").show();
        $("#consulta").hide();
        $(this).attr("src", "resources/images/cobrar-2.png");
        $("#home-tab-af").attr("src", "resources/images/afiliar-1.png");
        $("#profile-tab-consulta").attr("src", "resources/images/consultar-1.png");
        btn_dm_sts=1;
    });
    
      $('.profile-tab-consulta').click(function () {   
        $("#afiliaciones").hide();
        $("#pagos").hide();
        $("#consulta").show();
        $(this).attr("src", "resources/images/consultar-2.png");
        $("#home-tab-af").attr("src", "resources/images/afiliar-1.png");
        $("#home-tab-pg").attr("src", "resources/images/cobrar-1.png");
        
        btn_cs_sts=1;
    });
    
});
