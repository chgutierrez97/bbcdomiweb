
$(document).ready(function () {
    $("#afiliaciones").show();
    $("#pagos").hide();
    $("#mconsulta").hide();
    $("#pane11").show();
    $("#pane12").show();
    $("#pane13").show();
    $("#logo2").show();

    $('.home-tab-af').click(function () {
        if (swMasivaD != 0) {
            $("#afiliaciones").show();
            $("#pagos").hide();
            $("#consulta").hide();
            btn_cs_sts = 1;
        }

    });

    $('.profile-tab-pg').click(function () {
        if (swMasivaA != 0) {
            $("#afiliaciones").hide();
            $("#pagos").show();
            $("#consulta").hide();
            btn_dm_sts = 1;
        }
    });

    $('.profile-tab-consulta').click(function () {
        if (swMasivaD != 0 && swMasivaA != 0) {
            $("#afiliaciones").hide();
            $("#pagos").hide();
            $("#consulta").show();
            btn_cs_sts = 1;
        }
    });

});
