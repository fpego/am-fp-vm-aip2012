<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="common/meta-head.jsp" />
<title>Progetti UE - Home</title>
</head>
<body>
<jsp:include page="common/header.jsp" />
<section id="middle">
	<div id="container">
		<div id="content">
<!-- CONTENT START -->

<h1>Progetti fondati dall'Unione Europea</h1>
<img alt="" src="css/imgs/menu_header.jpg" class="presentazione">
<p>Benvenuto sul sito che raccoglie tutti i progetti di durata di almeno 2 anni finanziati dall'Unione Europea nel campo dell'IT.</p>
<p>Lo scopo primario di questo sito è divulgare i risultati dei progetti e promuovere lo scambio di informazioni tra i diversi consorzi.</p>

<div class="lista">
	
	<p class="risalto">Progetti</p> 
	<p class="risalto">Posso ottenere sostegno alle mie idee?</p>
		<ul>
			<li>Siete un ricercatore con un'idea per un progetto di ricerca o di innovazione?</li>
		   	<li>Desiderate migliorare le competenze o la capacità del vostro istituto di ricerca?</li>
		   	<li>Siete un imprenditore che desidera intraprendere attività di ricerca e di innovazione?</li>
		   	<li>Avete già avviato attività di innovazione a fini commerciali derivanti o non derivanti dalla ricerca e sviluppo?</li>
		   	<li>Siete un responsabile di cluster con l'obiettivo di internazionalizzare un cluster e renderlo più innovativo?</li>
		   	<li>Siete un responsabile delle politiche di innovazione regionale, un responsabile dell'informazione o di un programma di ricerca e desiderate scambiare buone pratiche con i vostri colleghi di altri Stati membri?</li>
		</ul>
		<p class="risalto">Scopri i nostri <a href="${f:url('/finanziamenti')}">FINANZIAMENTI</a></p>
</div>

<!-- CONTENT END -->
		</div>
	</div>
<aside id="sideLeft">
<!-- LEFT MENU START -->
<!-- LEFT MENU END -->
</aside>
</section>
<jsp:include page="common/footer.jsp" />
</body>
</html>
