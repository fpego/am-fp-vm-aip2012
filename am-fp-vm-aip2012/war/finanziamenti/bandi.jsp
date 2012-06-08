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

<h1>Finanzimenti</h1>

<h3>Bandi</h3>
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
		<li><a href="${f:url('finanziamenti?page=faq')}">FAQ</a></li>
	</ul>
	</div>
<!-- LEFT MENU END -->
</aside>
</section>
<jsp:include page="/common/footer.jsp" />

</body>
</html>
