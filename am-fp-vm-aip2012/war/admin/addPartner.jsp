<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Admin AddPartner</title>
<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="../js/jquery-ui-1.8.20.custom.min.js"></script>
<link href="../css/jquery.css" rel="stylesheet" type="text/css" />
<jsp:include page="/common/meta-head.jsp" />
<script type="text/javascript">
$(document).ready(function () {
	$("#nomePartner").autocomplete({
		source: '../partner?page=ajax'
	});
});
</script>
</head>
<body>
<jsp:include page="/common/header.jsp" />
<section id="middle">
	<div id="container">
		<div id="content">
<!-- CONTENT START -->
<h1>Pannello di amministrazione -> Crea un nuovo partner</h1>
<form action="${f:url('addPartner')}" method="post">
<input type="hidden" name="a" value="1" />
<h3>Inserisci il nome del nuovo partner:</h3>
<input type="text" ${f:text("nomePartner")} id="nomePartner"/>
<br/>
<input type="submit" value="Crea"/>
</form>

<br/>
<h3>Elenco dei partner presenti nel sistema:</h3>

<table>
<tbody>
<c:forEach var="p" items="${pList}">
<c:set var="deleteUrl" value="addPartner?key=${f:h(p.key)}&a=2"/>
<tr>
<td>${f:h(p.nome)}</td>
<td><a href="${f:url(deleteUrl)}" onclick="return confirm('Sei sicuro di cancellare il partner?')">Delete</a></td>
</tr>
</c:forEach>
</tbody>
</table>
<!-- CONTENT END -->
		</div>
	</div>
<aside id="sideLeft">
<!-- LEFT MENU START -->
	<div id='jqxMenuLeft' style='visibility: hidden; margin-left:auto; margin-right:auto'>
<ul>
	<li><a href="${f:url('/admin')}">Back</a></li>
	<li><a href="${f:url('addProgetto')}">Crea un nuovo progetto</a></li>
	<li><a href="${f:url('addPartner')}">Crea un nuovo partner o cancella quelli già presenti</a></li>
</ul>
</div>
<!-- LEFT MENU END -->
</aside>
</section>
<jsp:include page="/common/footer.jsp" />
</body>
</html>
