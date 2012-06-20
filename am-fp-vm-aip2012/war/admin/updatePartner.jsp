<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Admin Modifica Partner</title>
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
<jsp:include page="/common/header_admin.jsp" />
<section id="middle">
	<div id="container">
		<div id="content">
<!-- CONTENT START -->
<h1>Pannello di amministrazione -> Modifica un partner</h1>

<h3><a href="${f:url(urlIndietro)}">Torna indietro</a></h3>

<form action="${f:url('updatePartner')}" method="post">
<input type="hidden" name="a" value="1"/>
<input type="hidden" name="key" value="${f:h(p.key)}"/>
<h3>Modifica il partner:</h3>
<table style="margin-left:auto;margin-right:auto;">
<thead></thead>
<tbody>
<tr><td>Nome</td>
	<td><input type="text" value="${f:h(p.nome)}" name="nome" id="nome" /></td>
</tr>
<tr><td>Informazioni (opz)</td>
	<td><textarea name="chiSiamo" class="chiSiamo">${f:h(p.chiSiamo)}</textarea></td>
</tr>
<tr><td>Telefono (opz)</td>
	<td><input  type="text" value="${f:h(p.telefono)}" id="telefono" name="telefono"></td>
</tr>
<tr><td>Indirizzo (opz)</td>
	<td><input  type="text" value="${f:h(p.indirizzo)}" id="indirizzo" name="indirizzo"></td>
</tr>
<tr><td>Email</td>
	<td><input  type="text" value="${f:h(p.email)}" pattern="[a-zA-Z0-9_\.]+@[a-zA-Z0-9_\.]+\.[A-z]{2,6}" id="email" name="email"></td>
</tr>
<tr><td>Sito Web (opz)</td>
	<td><input  type="text" value="${f:h(p.sitoWeb)}" id="sitoWeb" name="sitoWeb"></td>
</tr>
<tr>
	<td colspan="2"><input type="submit" value="Salva le Modifiche"/></td>
</tr>
</tbody>
</table>
</form>
<!-- CONTENT END -->
		</div>
	</div>
<aside id="sideLeft">
<!-- LEFT MENU START -->
<jsp:include page="/common/leftMenu_admin.jsp" />
<!-- LEFT MENU END -->
</aside>
</section>
<jsp:include page="/common/footer.jsp" />
</body>
</html>
