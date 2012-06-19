<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="/common/meta-head.jsp" />
<title>Admin Partner</title>
</head>
<body>
<jsp:include page="/common/header_admin.jsp" />
<section id="middle">
	<div id="container">
		<div id="content">
<!-- CONTENT START -->
<h1>Partner '${f:h(p.nome)}'</h1>

<form action="${f:url(urlUpdate)}" method="post">
<input type="hidden" name="a" value="1"/>
<input type="hidden" name="key" value="${f:h(p.key)}"/>

<table style="margin-left:auto;margin-right:auto;">
<tbody>
<tr><td>Nome</td>
	<td><input type="text" name="nome" id="nome" value="${f:h(p.nome)}"/></td>
</tr>
<tr><td>Informazioni (opz)</td>
	<td><textarea name="chiSiamo" class="">${f:h(p.chiSiamo)}</textarea></td>
</tr>
<tr><td>Telefono (opz)</td>
	<td><input  type="text"  name="telefono" id="telefono" value="${f:h(p.telefono)}"></td>
</tr>
<tr><td>Indirizzo (opz)</td>
	<td><input  type="text"  name="indirizzo" id="indirizzo" value="${f:h(p.indirizzo)}"></td>
</tr>
<tr><td>Email</td>
	<td><input  type="text"  name="email" id="email" value="${f:h(p.email)}"></td>
</tr>
<tr><td>Sito Web (opz)</td>
	<td><input  type="text"  name="sitoWeb" id="sitoWeb" value="${f:h(p.sitoWeb)}"></td>
</tr>
<tr>
	<td colspan="2"><input type="submit" value="Salva"/></td>
</tr>
</tbody>
</table>
</form>

<c:choose>
	<c:when test="${fn:length(leaderList) > 0}">
		<h3>E' presente nei seguenti progetti come leader:</h3>
	
<c:forEach var="p" items="${leaderList}">
	<c:set var="projectLink" value="progetto?key=${f:h(p.key)}&origin=pA" />
	<ul id="projectList">
		<li><a href="${f:url(projectLink)}">${f:h(p.titoloProgetto)}</a></li>
	</ul>
</c:forEach>
	
	</c:when>
  	<c:otherwise>
  	<h3>Il partner "${f:h(partner.nome)}" non è leader di alcun progetto.</h3>
  	</c:otherwise>

</c:choose>

<c:choose>
	<c:when test="${fn:length(projectList) > 0}">
		<h3>E' presente nei seguenti progetti come partner non leader:</h3>
	
<c:forEach var="p" items="${projectList}">
	<c:set var="projectLink" value="progetto?key=${f:h(p.key)}&origin=pA" />
	<ul id="projectList">
		<li><a href="${f:url(projectLink)}">${f:h(p.titoloProgetto)}</a></li>
	</ul>
</c:forEach>
	
	</c:when>
  	<c:otherwise>
  	<h3>Il partner "${f:h(partner.nome)}" non partecipa come partner non leader ad alcun progetto.</h3>
  	</c:otherwise>

</c:choose>
 
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
