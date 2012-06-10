<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="/common/meta-head.jsp" />
<title>Home - EU Projects</title>
</head>
<body>
<jsp:include page="/common/header.jsp" />
<section id="middle">
	<div id="container">
		<div id="content">
<!-- CONTENT START -->

<h1>Tutti gli anni di inizio di un progetto</h1>

<c:forEach var="anno" items="${yearList}">
	<c:set var="yearLink" value="tuttiProgetti?page=perAnnoInizio&anno=${f:h(anno)}" />
	<ul>
		<li><a href="${f:url(yearLink)}">Anno ${f:h(anno)}</a></li>
	</ul>
</c:forEach>

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
