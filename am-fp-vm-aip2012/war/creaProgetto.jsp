<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="/common/meta-head.jsp" />
<title>Progetti UE - Crea un nuovo progetto</title>
</head>
<body>
<jsp:include page="/common/header.jsp" />
<section id="middle">
	<div id="container">
		<div id="content">
<!-- CONTENT START -->
<script type="text/javascript">Autocomplete();</script>
<h1>Crea un nuovo progetto</h1>
<br/><br/>
<p>
Inserisci i dati per creare un nuovo progetto.<br/>
Se i partner che devi inserire non sono presenti nel nostro database, basta scriverli e verranno automaticamente aggiunti. In ogni caso, i partner devono essere almeno 5.<br/>
Il primo partner della lista diventa automaticamente il leader del progetto.<br/>
La durata deve essere un numero di anni intero, compreso tra 2 e 10.<br/>
</p>
<br/><br/>
<form action="${f:url('progettoInsert')}" method="post" id="creaProgetto">
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
<ul id="addPartnersList">
	<li><input type="text" name="partner1" id="partner1" value=""/></li>
	<li><input type="text" name="partner2" id="partner2" value=""/></li>
	<li><input type="text" name="partner3" id="partner3" value=""/></li>
	<li><input type="text" name="partner4" id="partner4" value=""/></li>
	<li><input type="text" name="partner5" id="partner5" value=""/></li>
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
<!-- CONTENT END -->
		</div>
	</div>
<aside id="sideLeft">
<!-- LEFT MENU START -->
<!-- LEFT MENU END -->
</aside>
</section>
<jsp:include page="/common/footer.jsp" />

</body>
</html>
