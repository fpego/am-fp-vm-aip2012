<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Admin Progetto</title>
</head>
<body>
<!-- edit, crea collegamenti, file upload -->

<a href="/admin">Back</a>

<h1>Progetto '${f:h(p.titoloProgetto)}'</h1>

<form action="${f:url(urlUpdate)}" method="post">
<input type="hidden" name="a" value="1"/>
<input type="hidden" name="key" value="${f:h(p.key)}"/>
<h3>Titolo</h3>
<input type="text" name="titoloProgetto" value="${f:h(p.titoloProgetto)}"/>
<br/>
<h3>Tema</h3>
<input type="text" name="tema" value="${f:h(p.tema)}"/>
<br/>
<h3>Anno d'inizio</h3>
${f:h(p.annoInizio)}
<br/>
<h3>Anno di fine</h3>
${f:h(p.annoFine)}
<br/>
<h3>Durata</h3>
<input type="text" name="durata" value="${f:h(p.durata)}"/>
<h3>Presentazione</h3>
<textarea ${f:text("presentazione")}>${f:h(p.presentazione)}</textarea>
<br/>
<h3>Risultati</h3>
<textarea ${f:text("risultati")}>${f:h(p.risultati)}</textarea>
<br/>
<input type="submit" value="Salva"/>
</form>

<form action="${f:url(urlUpdate)}" method="post" enctype="multipart/form-data">
<input type="hidden" name="a" value="2"/>
<h3>Upload un nuovo file</h3>
<input type="file" name="formFile" />
<br/>
<input type="submit" value="Upload"/>
</form>

<table>
<c:if test="${fn:length(docList) > 0}">
<thead>
<tr><th>FileName</th><th>Bytes</th></tr>
</thead>
</c:if>
<tbody>
<c:forEach var="e" items="${docList}">
<tr>
<td>${f:h(e.fileName)}</td><td>${f:h(e.length)}</td>
<c:set var="downloadUrl" value="download?key=${f:h(e.key)}&version=${e.version}"/>
<c:set var="showUrl" value="show?key=${f:h(e.key)}&version=${e.version}"/>
<c:set var="deleteUrl" value="delete?key=${f:h(e.key)}&version=${e.version}"/>
<td><a href="${f:url(downloadUrl)}">Download</a></td>
<td><a href="${f:url(showUrl)}">Show</a></td>
<td><a href="${f:url(deleteUrl)}" onclick="return confirm('delete OK?')">Delete</a></td>
</tr>
</c:forEach>
</tbody>
</table>

</body>
</html>
