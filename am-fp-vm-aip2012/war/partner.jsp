<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="/common/meta-head.jsp" />
<title>Progetti UE - Partner</title>
</head>
<body>
<jsp:include page="/common/header.jsp" />
<section id="middle">
	<div id="container">
		<div id="content">
<!-- CONTENT START -->

<h1>${f:h(partner.nome)} -> Chi siamo?</h1>

<p>${f:h(partner.chiSiamo)}</p>

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

<p class="risalto">Scopri più di noi: <a>Attività</a>, <a>Eventi</a>, <a>Ricercatori</a> (links NI)</p>
<!-- CONTENT END -->
		</div>
	</div>
<aside id="sideLeft">
<!-- LEFT MENU START -->
<jsp:include page="/common/leftMenu_partner.jsp" />
<!-- LEFT MENU END -->
</aside>
</section>
<jsp:include page="/common/footer.jsp" />

</body>
</html>
