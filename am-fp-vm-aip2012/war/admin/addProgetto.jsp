<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="../js/jquery.autocomplete.min.js"></script>
<script type="text/javascript" src="../js/functions.js"></script>
<script type="text/javascript">Autocomplete();</script>
<title>Admin AddProgetto</title>
</head>
<body>
<a href="/admin">Back</a>

<h1>Crea un nuovo progetto</h1>
<br/><br/>
<p>Inserisci i dati per creare un nuovo progetto.<br/>
Se i partner che devi inserire non sono presenti nel nostro database, basta scriverli e verranno automaticamente aggiunti. In ogni caso, i partner devono essere almeno 5.<br/>
Il primo partner della lista diventa automaticamente il leader del progetto.<br/>
La durata deve essere un numero di anni intero, compreso tra 2 e 10.<br/>
</p>
<br/><br/>
<form action="${f:url('addProgetto')}" method="post" id="creaProgetto">
<input type="hidden" name="a" value="1" />
<table style="margin-left:auto;margin-right:auto;">
<thead></thead>
<tbody>
<tr><td>Titolo</td><td>
<input type="text" ${f:text("titoloProgetto")} class="${f:errorClass('titoloProgetto', 'err')}"/>${f:h(errors.titoloProgetto)}
</td></tr>
<tr><td>Tema</td><td>
<input type="text" ${f:text("tema")} class="${f:errorClass('tema', 'err')}"/>${f:h(errors.tema)}
</td></tr>
<tr><td>Durata (anni)</td><td>
<input type="text" ${f:text("durata")} class="${f:errorClass('durata', 'err')}"/>${f:h(durata.durata)}
</td></tr>
<tr><td>Presentazione</td><td>
<textarea name="presentazione" class="${f:errorClass('presentazione', 'err')}">${f:h(presentazione)}</textarea>${f:h(errors.presentazione)}
</td></tr>
<tr>
<td>Partners (almeno 5)</td>
<td><div id="partnersAdd">
<input type="hidden" name="numPartner" value="5" id="numPartner" />
<ul id="addPartnersList" style="list-style: none;">
	<li><input type="text" name="partner1" value=""/></li>
	<li><input type="text" name="partner2" value=""/></li>
	<li><input type="text" name="partner3" value=""/></li>
	<li><input type="text" name="partner4" value=""/></li>
	<li><input type="text" name="partner5" value=""/></li>
</ul>
<a id="AddSingleParnerButton" onclick="AddPartnerToList()">Aggiungi Partner</a>
</div></td>
</tr>
</tbody>
<tfoot>
<tr><td colspan="2">
<input type="submit" value="Crea"/>
</td></tr>
</tfoot>
</table>

</form>

</body>
</html>
