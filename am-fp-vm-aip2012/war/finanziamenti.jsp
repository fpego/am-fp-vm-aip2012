<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="/common/meta-head.jsp" />
<title>Progetti UE - Regole d'iscrizione</title>
</head>
<body>
<jsp:include page="/common/header.jsp" />
<section id="middle">
	<div id="container">
		<div id="content">
<!-- CONTENT START -->

<h1>Finanziamenti</h1>
<p>In un'economia globale aperta, la competitività si basa sulla capacità delle aziende di 
creare beni e servizi ad elevato valore aggiunto. L'evoluzione verso una crescita sostenibile 
basata sull'innovazione è quindi al centro della risposta dell'UE alla globalizzazione. A giugno 
2010 i capi di Stato e di governo dell'UE hanno approvato la strategia Europa 2020, volta a riportare 
l'economia europea in carreggiata. Al centro di Europa 2020 c'è la convinzione che occorrono R&S e innovazione 
per creare una crescita intelligente e sostenibile, per fare uscire l'Europa dall'attuale crisi economica.</p>
<p>La ricerca e l'innovazione possono offrire anche soluzioni per superare le grandi sfide che il nostro continente 
e il resto del mondo devono affrontare, sfide come la sicurezza energetica, i cambiamenti climatici, la degradazione 
ambientale, l'esclusione dei gruppi vulnerabili, l'invecchiamento della popolazione, le emergenze sanitarie globali 
e gli sviluppi demografici.</p>
<p>L'Unione europea possiede cinque meccanismi di finanziamento principali per sostenere la ricerca e l'innovazione: 
il Programma quadro per la ricerca, il Programma quadro per la competitività e l'innovazione, i Fondi strutturali e 
il Fondo di coesione nell'ambito della politica di coesione, il Fondo europeo agricolo per lo sviluppo rurale e il
 Fondo europeo per la pesca nell'ambito della politica di sviluppo rurale e della politica comune della pesca.</p>
 <p>Nel 2007 la Commissione europea ha pubblicato le sue idee riguardo alle "Regioni europee competitive grazie alla 
 ricerca e all'innovazione" e ha invitato gli Stati membri e le regioni dell'UE a fare un uso più efficace degli 
 strumenti di finanziamento disponibili. La prima edizione della Guida pratica è stata introdotta nel 2008 per 
 fornire una breve descrizione delle principali fonti di finanziamento nel campo della ricerca e dell'innovazione. 
 Essa spiegava come queste possono essere combinate tra di loro a livello pratico e consigliava ai responsabili delle 
 politiche come introdurre meccanismi, a livello nazionale e regionale, volti a promuovere un accesso coordinato a 
 tali fonti di finanziamento.</p>
 <p>Il Consiglio "Competitività" ha invitato la Commissione a continuare a impegnarsi in questa direzione, 
 in particolare migliorando, potenziando ed espandendo l'ambito della Guida pratica esistente, modernizzando 
 inoltre la guida come portale completo basato sul web dedicato alla ricerca e all'innovazione. </p>
 <p>Questa nuova edizione contiene una panoramica completamente aggiornata delle tre fonti di finanziamento 
 descritte nella Guida iniziale (7° Programma quadro per la ricerca, Programma quadro per la competitività e 
 l'innovazione e Fondi strutturali) completata da informazioni sul Fondo europeo agricolo per lo sviluppo rurale 
 e sul Fondo europeo per la pesca. Inoltre, concentra l'attenzione su altre opportunità di finanziamento nel campo 
 della ricerca e dell'innovazione. Essa contiene informazioni sul programma di apprendimento permanente e sui 
 programmi di cooperazione internazionale nel campo dell'istruzione.
 Descrive inoltre le opportunità di finanziamento in materia di ricerca e innovazione offerte ai paesi e territori 
 al di fuori dell'Unione europea, nel quadro dello strumento di assistenza preadesione e dello strumento europeo di 
 partenariato e vicinato.</p>
 <p>In questa sezione offriamo ai potenziali beneficiari dei finanziamenti dell'UE per la ricerca e l'innovazione 
 le informazioni pratiche di cui hanno bisogno per potervi accedere. Fornisce inoltre ai responsabili delle decisioni 
 una panoramica completa di tutte le opportunità di finanziamento fino al 2013. La complessità dell'attuale scenario 
 ci ha spinti a proporre di riunire tutta la gamma di strumenti di finanziamento per la ricerca e l'innovazione in 
 un unico quadro strategico nell'ambito del futuro quadro finanziario pluriannuale. Con una serie di regole e procedure 
 comuni semplificate e un unico insieme di strumenti di finanziamento, tale quadro strategico potrebbe rendere i 
 finanziamenti dell'UE più efficienti e aumentarne l'impatto, facilitando allo stesso tempo l'accesso per i partecipanti. 
 Il quadro strategico comune per il finanziamento della ricerca e dell'innovazione dell’UE ci permetterà, insieme ai 
 rinnovati fondi strutturali, di muoverci rapidamente verso l'attuazione della strategia Europa 2020.</p>
 
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
