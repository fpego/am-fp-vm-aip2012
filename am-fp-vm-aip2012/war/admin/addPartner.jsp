<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Admin AddPartner</title>
</head>
<body>
<a href="/admin">Back</a>

<h1>Crea un nuovo partner</h1>
<form action="${f:url('addPartner')}" method="post">
<input type="hidden" name="a" value="1" />
<h3>Inserisci il nome del nuovo partner:</h3>
<input type="text" ${f:text("nomePartner")}/>
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

</body>
</html>
