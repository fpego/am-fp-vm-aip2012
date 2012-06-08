<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="/common/meta-head.jsp" />
<title>Progetti UE - Progetto - Esplora</title>
</head>
<body>
<jsp:include page="/common/header.jsp" />
<section id="middle">
	<div id="container">
		<div id="content">
<!-- CONTENT START -->

<h1>Progetto ${f:h(p.titoloProgetto)}</h1>

<h3>Esplora</h3>

<h4>Elenco dei partners</h4>

<ul id="partnerList">
	<c:set var="partnerLeaderLink" value="partner?key=${f:h(pLeader.key)}" />
	<li id="partnerLeader"><a href="${f:url(partnerLeaderLink)}">${f:h(pLeader.nome)} </a></li>
	
<c:forEach var="p" items="${partners}">
	<c:set var="partnerLink" value="partner?key=${f:h(p.key)}" />
		<li><a href="${f:url(partnerList)}">${f:h(p.nome)} </a></li>
</c:forEach>

</ul>


<h4>Elenco dei ricercatori coinvolti</h4>

<c:forEach var="r" items="${ricercatori}">
	<c:set var="ricercatoriLink" value="progetto?key=${f:h(r.key)}" />
	<ul id="projectList">
		<li><a href="${f:url(ricercatoriLink)}">${f:h(r.nome)}</a></li>
	</ul>
</c:forEach>

<!-- CONTENT END -->
		</div>
	</div>
<aside id="sideLeft">
<!-- LEFT MENU START -->
	<div id='jqxMenuLeft' style='visibility: hidden; margin-left:auto; margin-right:auto'>
	<ul>
		<li><a href="${f:h(urlProgetto)}">Presentazione</a></li>
		<li><a href="${f:h(urlRisultati)}">Risultati</a></li>
		<li><a href="${f:h(urlDocumentazione)}">Documentazione</a></li>
		<li><a href="${f:h(urlEsplora)}">Esplora</a></li>
	</ul>
	</div>
<!-- LEFT MENU END -->
</aside>
</section>
<jsp:include page="/common/footer.jsp" />

</body>
</html>
