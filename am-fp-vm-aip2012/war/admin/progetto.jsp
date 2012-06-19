<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="/common/meta-head.jsp" />
<title>Admin Progetto</title>
</head>
<body>
<jsp:include page="/common/header_admin.jsp" />
<section id="middle">
	<div id="container">
		<div id="content">
<!-- CONTENT START -->
<h1>Progetto '${f:h(p.titoloProgetto)}'</h1>

<form action="${f:url(urlUpdate)}" method="post">
<input type="hidden" name="a" value="1"/>
<input type="hidden" name="key" value="${f:h(p.key)}"/>
<table style="margin-left:auto;margin-right:auto;">
<tr><td>Titolo</td><td>
<input type="text" name="titoloProgetto" value="${f:h(p.titoloProgetto)}"/></td></tr>
<tr><td>Tema</td><td>
<input type="text" name="tema" value="${f:h(p.tema)}"/></td></tr>
<tr><td>Anno d'inizio</td><td>${f:h(p.annoInizio)}</td></tr>
<tr><td>Anno di fine</td><td>${f:h(p.annoFine)}</td></tr>
<tr><td>Durata</td><td><input type="text" name="durata" value="${f:h(p.durata)}" maxlength="2" max="10" size="2"/></td></tr>
<tr><td>Presentazione</td><td><textarea ${f:text("presentazione")} cols="40" rows="5">${f:h(p.presentazione)}</textarea></td></tr>
<tr><td>Risultati</td><td><textarea ${f:text("risultati")} cols="40" rows="5">${f:h(p.risultati)}</textarea></td></tr>
<tr><td colspan="2"><input type="submit" value="Salva"/></td></tr>
</table>
</form>

<h3>Elenco dei partner</h3>
<table style="margin-left:auto;margin-right:auto;">
<tr><th colspan="2">Leader: '${f:h(partnerLeader.nome)}'</th></tr>
<c:forEach var="pp" items="${partnerList}">
<c:set var="deleteLinkUrl" value="removeLink?project=${f:h(p.key)}&partner=${f:h(pp.key)}"/>
	<tr><td>${f:h(pp.nome)}</td> 
	<td><a href="${f:url(deleteLinkUrl)}" onclick="return confirm('Sei sicuro di rimuovere il collegamento con il partner?')">Rimuovi collegamento</a></td></tr>
</c:forEach>
</table>

<h3>Elenco dei documenti</h3>
<table style="margin-left:auto;margin-right:auto;">
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
<c:set var="deleteUrl" value="delete?key=${f:h(e.key)}&version=${e.version}"/>
<td><a href="${f:url(downloadUrl)}" target="_blank">Download</a></td>
<td><a href="${f:url(deleteUrl)}" onclick="return confirm('Sei sicuro di cancellare il file?')">Delete</a></td>
</tr>
</c:forEach>
</tbody>
</table>

<form action="${f:url(urlUpdate)}" method="post">
<input type="hidden" name="key" value="${f:h(p.key)}"/>
<table style="margin-left:auto;margin-right:auto;">
<tr><th>Aggiungi un nuovo partner</th><td>
<input type="text" name="nomePartner" value="" id="newPartner" /></td></tr>
<tr><td colspan="2"><input type="submit" value="Aggiungi" /></td></tr>
</table>
</form>

<form action="${f:url(urlUpdate)}" method="post" enctype="multipart/form-data">
<input type="hidden" name="key" value="${f:h(p.key)}"/>
<input type="hidden" name="a" value="2"/>
<table style="margin-left:auto;margin-right:auto;">
<tr><th>Upload un nuovo file</th><td><input type="file" name="formFile" /></td></tr>
<tr><td colspan="2"><input type="submit" value="Upload"/></td></tr>
</table>
</form>
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
