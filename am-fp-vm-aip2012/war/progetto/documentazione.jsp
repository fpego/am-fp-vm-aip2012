<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="/common/meta-head.jsp" />
<title>Progetti UE - Progetto - Documentazione</title>
</head>
<body>
<jsp:include page="/common/header.jsp" />
<section id="middle">
	<div id="container">
		<div id="content">
<!-- CONTENT START -->

<h1>Progetto ${f:h(p.titoloProgetto)}</h1>

<h3>Documentazione</h3>

<c:forEach var="d" items="${documenti}">
	<c:set var="docLink" value="admin/download?key=${f:h(d.key)}&version=${f:h(d.version)}" />
	<ul id="docList">
		<li><a href="${f:url(docLink)}">${f:h(d.fileName)} (size: ${f:h(d.length)} bytes)</a></li>
	</ul>
</c:forEach>

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
