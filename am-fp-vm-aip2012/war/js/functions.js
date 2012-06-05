/*
 * File: functions.js
 * Description: Raccolta di funzioni varie javascript di utilità per il progetto.
 * 
 */

function bootMenu(){
$(document).ready(function () {
    // Create a jqxMenu
    $("#jqxMenu").jqxMenu({ width: '1000', height: '30px', theme: 'base' });
    $("#jqxMenu").css('visibility', 'visible');
    $("#jqxMenu").jqxMenu('disable', 'fin', true);
    
    // Se esiste, creo anche il menu laterale
    if ($("#jqxMenuLeft") != null){
    	$("#jqxMenuLeft").jqxMenu({ width: '110', mode: 'vertical', theme: 'base' });
        $("#jqxMenuLeft").css('visibility', 'visible');
        $("#jqxMenuLeft").jqxMenu('disable', 'fin', true);
    }
});

}