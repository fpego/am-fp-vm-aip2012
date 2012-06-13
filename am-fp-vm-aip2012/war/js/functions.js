/*
 * File: functions.js
 * Description: Raccolta di funzioni varie javascript di utilità per il progetto.
 * 
 */

/**
 * Funzione chiamata da ogni pagina, crea lo stile per i due menu
 */
function bootMenu(){
$(document).ready(function () {
    // Create a jqxMenu
    $("#jqxMenu").jqxMenu({ width: '100%', height: '30px', theme: 'base'});
    $("#jqxMenu").css('visibility', 'visible');
    $("#jqxMenu").jqxMenu('disable', 'fin', true);
    
    // Se esiste, creo anche il menu laterale
    if ($("#jqxMenuLeft") != null){
    	$("#jqxMenuLeft").jqxMenu({ width: '120', mode: 'vertical', theme: 'base' });
        $("#jqxMenuLeft").css('visibility', 'visible');
        $("#jqxMenuLeft").jqxMenu('disable', 'fin', true);
    }
});

}

/**
 * Usata solo nella pagina creaProgetto.jsp
 * Aggiunge un nuovo elemento alla lista di partner da inserire
 */
function AddPartnerToList(){
	var curNumPartners = parseInt($("#numPartner").val());
	var newNumPartners = curNumPartners + 1
	var toInsert = '<li><input type="text" name="partner' + newNumPartners + '" value=""/></li>';
	$("#addPartnersList").append(toInsert);
	$("#numPartner").val(newNumPartners);
}

function Autocomplete(){
	for (i = 1; i <= 5; i++){
		setAutocomplete(i);
	}
}

function setAutocomplete(i){
	var name = "#partner"+i;
	$(document).ready(function () {
		$(name).autocomplete({
			source: 'partner?page=ajax'
		});
	});
}

function visualizza(id){
	$("#"+id).toggle();
}