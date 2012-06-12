<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Admin</title>
</head>
<body>
<h1>Pannello di amministrazione</h1>

<h3><a>Crea un nuovo progetto</a></h3>
<br/>
<h3><a>Crea un nuovo partner</a></h3>
<br/>
<h3>Lista di progetti</h3>
<h4>Selezionando un progetto, si entra nella pagina per modificarlo, aggiungere o rimuovere partner e uplodare file.</h4>

<c:forEach var="p" items="${projectList}">
	<c:set var="projectLink" value="progetto?key=${f:h(p.key)}" />
	<ul id="projectList">
		<li><a href="${f:url(projectLink)}">${f:h(p.titoloProgetto)}</a></li>
	</ul>
</c:forEach>

</body>
</html>
