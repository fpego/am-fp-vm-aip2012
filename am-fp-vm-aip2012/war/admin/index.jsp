<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<jsp:include page="/common/meta-head.jsp" />
<title>Admin</title>
</head>
<body>
<jsp:include page="/common/header.jsp" />
<section id="middle">
	<div id="container">
		<div id="content">
<!-- CONTENT START -->
<h1>Pannello di amministrazione</h1>
<h3>Lista di progetti</h3>
<h4>Selezionando un progetto, si entra nella pagina per modificarlo, aggiungere o rimuovere partner e uplodare, scaricare o cancellare file.</h4>

<c:forEach var="p" items="${projectList}">
	<c:set var="projectLink" value="progetto?key=${f:h(p.key)}" />
	<ul id="projectList">
		<li><a href="${f:url(projectLink)}">${f:h(p.titoloProgetto)}</a></li>
	</ul>
</c:forEach>
<!-- CONTENT END -->
		</div>
	</div>
<aside id="sideLeft">
<!-- LEFT MENU START -->
	<div id='jqxMenuLeft' style='visibility: hidden; margin-left:auto; margin-right:auto'>
<ul>
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
