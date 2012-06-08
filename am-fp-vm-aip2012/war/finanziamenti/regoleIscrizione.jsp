<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="/common/meta-head.jsp" />
<title>Progetti UE - Regole d'iscrizione - Bandi</title>
</head>
<body>
<jsp:include page="/common/header.jsp" />
<section id="middle">
	<div id="container">
		<div id="content">
<!-- CONTENT START -->

<h1>Finanziamenti</h1>

<h3>Regole d'iscrizione</h3>

<p><a href="${f:url('regoleIscrizione?page=passo1')}">Passo 1 - Possiedo i requisiti per un dato programma o una data fonte di finanziamento?</a></p>
<p><a href="${f:url('regoleIscrizione?page=passo2')}">Passo 2 - Chi altro è convolto nel progetto?</a></p>
<p><a href="${f:url('regoleIscrizione?page=passo3')}">Passo 3 - Come candidarsi al programma di finanziamento?</a></p>
<!-- CONTENT END -->
		</div>
	</div>
<aside id="sideLeft">
<!-- LEFT MENU START -->
	<div id='jqxMenuLeft' style='visibility: hidden; margin-left:auto; margin-right:auto'>
	<ul>
		<li><a href="${f:url('finanziamenti')}">Finanziamenti</a></li>
		<li><a href="${f:url('finanziamenti?page=regoleIscrizione')}">Regole d'iscrizione</a></li>
		<li><a href="${f:url('finanziamenti?page=bandi')}">Bandi</a></li>
	</ul>
	</div>
<!-- LEFT MENU END -->
</aside>
</section>
<jsp:include page="/common/footer.jsp" />

</body>
</html>