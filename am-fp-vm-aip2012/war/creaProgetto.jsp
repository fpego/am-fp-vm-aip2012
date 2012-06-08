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

<h1>Crea un nuovo progetto</h1>
<br/><br/>
<form action="${f:url('progettoInsert')}" method="post" id="creaProgetto">
<table style="margin-left:auto;margin-right:auto;">
<thead></thead>
<tbody>
<tr><td>Titolo</td><td>
<input type="text" ${f:text("titolo")} class="${f:errorClass('titolo', 'err')}"/>${f:h(errors.titolo)}
</td></tr>
<tr><td>Tema</td><td>
<input type="text" ${f:text("genere")} class="${f:errorClass('genere', 'err')}"/>${f:h(errors.genere)}
</td></tr>
<tr><td>Presentazione</td><td>
<textarea name="presentazione" class="${f:errorClass('presentazione', 'err')}">${f:h(presentazione)}</textarea>${f:h(errors.presentazione)}
</td></tr>
<tr>
<td>Partners (almeno 5)</td>
<td><div id="partnersAdd">
<input type="hidden" name="numPartner" value="5" id="numPartner" />
<ul id="addPartnersList">
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
