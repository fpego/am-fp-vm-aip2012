<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>


<!-- HEADER START -->
<div id="header">
	<div id="headImage">IMMAGINE HEAD</div>
	<div id='jqxMenu' style='visibility: hidden;margin-left: auto;margin-right: auto;'>
	<ul>
		<li><a href="${f:url('/')}">Home</a></li>
		<li>Progetti
			<ul>
				<li><a href="${f:url('tuttiProgetti')}">Tutti i progetti</a></li>
				<li><a href="${f:url('tuttiProgetti?page=perAnnoInizio')}">Per anno d'inizio</a></li>
				<li><a href="${f:url('tuttiProgetti?page=perAnnoFine')}">Per anno di fine</a></li>
				<li><a href="${f:url('tuttiProgetti?page=perTema')}">Progetti per tema</a></li>
			</ul>
		</li>
		<li>Partners
			<ul>
				<li><a href="${f:url('tuttiPartners')}">Tutti i partners</a></li>
				<li><a href="${f:url('tuttiPartners?page=leader')}">Partners leader di progetto</a></li>
			</ul>		
		</li>
		<li>Eventi
			<ul>
				<li><a href="#">Tutti gli eventi</a></li>
				<li><a href="#">Eventi per temi</a></li>
				<li><a href="#">Eventi per tipo</a></li>
				<li><a href="#">Eventi per mese</a></li>
			</ul>
		</li>
		<li>Ricercatori
			<ul>
				<li><a href="#">Tutti i ricercatori</a></li>
				<li><a href="#">Ricercatori Accademici</a></li>
				<li><a href="#">Ricercatori Industriali</a></li>
				<li><a href="#">Aree di ricerca</a></li>
			</ul>
		</li>
		<li>Attività
			<ul>
				<li><a href="#">Tutte le attività</a></li>
				<li><a href="#">Attività per mese</a></li>
			</ul>
		</li>
		<li><a href="#">Eventi Pubblici</a></li>
		<li><a href="/commissioneEuropea">La Commissione Europea</a></li>
		<li><a href="/regoleIscrizione">Regole d'iscrizione</a>
			<ul>
				<li><a href="/regoleIscrizione/bandi">Bandi</a></li>
				<li><a href="/regoleIscrizione/faq">FAQ</a></li>
			</ul>
		</li>
		<li><a href="/creaProgetto">Crea un progetto</a></li>
	</ul>
	</div>
</div>
<!-- HEADER END -->