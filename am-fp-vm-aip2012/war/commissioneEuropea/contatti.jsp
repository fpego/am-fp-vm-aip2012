<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="/common/meta-head.jsp" />
<title>Progetti UE - Commissione Europea - Contatti</title>
</head>
<body>
<jsp:include page="/common/header.jsp" />
<section id="middle">
	<div id="container">
		<div id="content">
<!-- CONTENT START -->

<h1>La Commissione Europea</h1>

<h2>Contatti</h2>
<img alt="img/europa.jpg" src="css/imgs/europa.jpg" id="presentazione">

<p>ITALIA:</p>
<p>Via IV Novembre, 149</p>
<p>	00187 Roma</p>
<p>	Tel.: 06 699991</p>
<p>	Fax: 06 6791658 - 6793652</p>
<!-- CONTENT END -->
		</div>
	</div>
<aside id="sideLeft">
<!-- LEFT MENU START -->
	<div id='jqxMenuLeft' style='visibility: hidden; margin-left:auto; margin-right:auto'>
	<ul>
		<li><a href="/commissioneEuropea">Chi siamo</a></li>
		<li><a href="/commissioneEuropea/visione">La nostra visione</a></li>
		<li><a href="/commissioneEuropea/storia">La nostra storia</a></li>
		<li><a href="/commissioneEuropea/contatti">Contatti</a></li>
	</ul>
	</div>
	
<!-- LEFT MENU END -->
</aside>
</section>
<jsp:include page="/common/footer.jsp" />

</body>
</html>
