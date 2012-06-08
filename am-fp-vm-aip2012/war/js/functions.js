/*
 * File: functions.js
 * Description: Raccolta di funzioni varie javascript di utilit� per il progetto.
 * 
 */

/**
 * Funzione chiamata da ogni pagina, crea lo stile per i due menu
 */
function bootMenu(){
$(document).ready(function () {
    // Create a jqxMenu
    $("#jqxMenu").jqxMenu({ width: '1000', height: '30px', theme: 'base' });
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
		setAutocomplete(i)
	}
}

function setAutocomplete(i){
	
	jQuery(function () {
		var onAutocompleteSelect = function(value, data) {
            //$('#selection').html('<img src="\/global\/flags\/small\/' + data + '.png" alt="" \/> ' + value);
			alert(value);
			alert(data);
        };

        
        var options = {
            serviceUrl: 'partner.jsp?page=ajax',
            width: 384,
            // delimiter: /(,|;)\s*/,
            onSelect: onAutocompleteSelect,
            deferRequestBy: 0, //miliseconds
            params: { country: 'Yes' },
            noCache: false //set to true, to disable caching
        };


        auto[1] = $('#').autocomplete(options);

    });

}