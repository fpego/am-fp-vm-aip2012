<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>


<!-- HEADER START -->
<div id="header">
	<div id="headImage"><a href="${f:url('/')}" style="text-decoration:none"><h1>Progetti Europei Finanziati</h1></a></div>
	<div id='jqxMenu' style='visibility: hidden;margin-left: auto;margin-right: auto;'>
	<ul>
		<li><a href="${f:url(index)}">Home</a></li>
		<li>Progetti
			<ul>
				<li><a href="${f:url('/tuttiProgetti')}">Tutti i progetti</a></li>
				<li><a href="${f:url('/tuttiProgetti?page=tuttiAnniInizio')}">Per anno d'inizio</a></li>
				<li><a href="${f:url('/tuttiProgetti?page=tuttiAnniFine')}">Per anno di fine</a></li>
				<li><a href="${f:url('/tuttiProgetti?page=tuttiTemi')}">Tutti i temi di progetti</a></li>
			</ul>
		</li>
		<li>Partners
			<ul>
				<li><a href="${f:url('/tuttiPartners')}">Tutti i partners</a></li>
				<li><a href="${f:url('/tuttiPartners?page=leader')}">Partners leader di progetto</a></li>
			</ul>		
		</li>
		<li>Eventi Pubblici_NI
			<ul>
				<li><a href="#">Tutti gli eventi_NI</a></li>
				<li><a href="#">Tutti temi di eventi_NI</a></li>
				<li><a href="#">Tutti tipi di eventi_NI</a></li>
				<li><a href="#">Tutti mesi_NI</a></li>
			</ul>
		</li>
		<li>Ricercatori_NI
			<ul>
				<li><a href="#">Tutti i ricercatori_NI</a></li>
				<li><a href="#">Ricercatori Accademici_NI</a></li>
				<li><a href="#">Ricercatori Industriali_NI</a></li>
				<li><a href="#">Aree di ricerca_NI</a></li>
			</ul>
		</li>
		<li><a href="${f:url('/commissioneEuropea')}">La Commissione Europea</a></li>
		<li><a href="${f:url('/finanziamenti')}">Finanziamenti</a></li>
		<li><a href="${f:url('/creaProgetto')}">Crea un progetto</a></li>
	</ul>
	</div>
</div>
<!-- HEADER END -->