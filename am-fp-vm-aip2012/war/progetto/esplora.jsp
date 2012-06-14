<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="/common/meta-head.jsp" />
<title>Progetti UE - Progetto - Esplora il consorzio</title>
</head>
<body>
<jsp:include page="/common/header.jsp" />
<section id="middle">
	<div id="container">
		<div id="content">
<!-- CONTENT START -->

<h1>Progetto ${f:h(p.titoloProgetto)}</h1>

<h3>Esplora il consorzio</h3>
<br />
<h4>Elenco dei partners</h4>
<ul id="partnerList">
	<c:set var="partnerLeaderLink" value="partner?key=${f:h(pLeader.key)}&origin=project" />
	<li id="partnerLeader"><a href="${f:url(partnerLeaderLink)}">${f:h(pLeader.nome)} </a></li>
	
<c:forEach var="p" items="${partners}">
	<c:set var="partnerLink" value="partner?key=${f:h(p.key)}&origin=project" />
		<li><a href="${f:url(partnerLink)}">${f:h(p.nome)} </a></li>
</c:forEach>

</ul>

<br/>
<h4>Elenco dei ricercatori coinvolti (NOT IMPLEMENTED)</h4>

<!-- CONTENT END -->
		</div>
	</div>
<aside id="sideLeft">
<!-- LEFT MENU START -->
	<jsp:include page="/common/leftMenu_progetto.jsp" />
<!-- LEFT MENU END -->
</aside>
</section>
<jsp:include page="/common/footer.jsp" />

</body>
</html>
