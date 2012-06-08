<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="/common/meta-head.jsp" />
<title>Progetti UE - Commissione Europea - Chi siamo</title>
</head>
<body>
<jsp:include page="/common/header.jsp" />
<section id="middle">
	<div id="container">
		<div id="content">
<!-- CONTENT START -->

<h1>La Commissione Europea</h1>

<h2>Chi siamo</h2>
<img alt="img/commissione_europea.jpg" src="img/commissione_europea.jpg" id="presentazione">
<p>Siamo una delle principali istituzioni dell'Unione europea, l'organo esecutivo e promotrice del processo legislativo. 
Siamo composti da un delegato per stato membro: a ciascun delegato è tuttavia richiesta la massima indipendenza dal governo 
nazionale che lo ha indicato.</p>

<p>La Commissione rappresenta e tutela gli interessi dell'Unione europea nella sua interezza; avendo il monopolio del potere
 di iniziativa legislativa, propone l'adozione degli atti normativi comunitari, la cui approvazione ultima spetta al 
 Parlamento europeo e al Consiglio dell'Unione Europea; è responsabile inoltre dell'attuazione delle decisioni politiche 
 da parte degli organi legislativi, gestisce i programmi UE e la spesa dei suoi fondi.</p>

<!-- CONTENT END -->
		</div>
	</div>
<aside id="sideLeft">
<!-- LEFT MENU START -->
	<div id='jqxMenuLeft' style='visibility: hidden; margin-left:auto; margin-right:auto'>
	<ul>
		<li><a href="${f:url('/commissioneEuropea')}">Chi siamo</a></li>
		<li><a href="${f:url('/commissioneEuropea?page=visione')}">La nostra visione</a></li>
		<li><a href="${f:url('/commissioneEuropea?page=storia')}">La nostra storia</a></li>
		<li><a href="${f:url('/commissioneEuropea?page=contatti')}">Contatti</a></li>
	</ul>
	</div>
<!-- LEFT MENU END -->
</aside>
</section>
<jsp:include page="/common/footer.jsp" />

</body>
</html>
