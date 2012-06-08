<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="/common/meta-head.jsp" />
<title>Progetti UE - Finanziamenti - Regole d'iscrizione</title>
</head>
<body>
<jsp:include page="/common/header.jsp" />
<section id="middle">
	<div id="container">
		<div id="content">
<!-- CONTENT START -->

<h1>Finanziamenti</h1>
<h2><a href="${f:url('regoleIscrizione')}">Regole d'iscrizione</a></h2>
<h3>Passo 1 - Possiedo i requisiti per un dato programma o una data fonte di finanziamento?</h3>
<p class="titoloPasso">Imprese (micro, piccola, media, grande impresa – con/senza scopo di lucro, partenariato pubblico-privato, fornitore di servizi, 
coordinatore di progetti, ecc.) eccetto gli istituti di ricerca</p>

<p>7° PQ: Sì. Le imprese possono partecipare a quasi tutte le attività del 7° PQ e sono incoraggiate a farlo. Inoltre, il programma 
PERSONE del 7° PQ prevede una specifica azione Marie Curie per le imprese commerciali, mentre il programma "Capacità" del 7° PQ offre 
specifici schemi di ricerca in materia di PMI.</p> 
<p>CIP: Sì. Le imprese possono beneficiare degli strumenti finanziari del CIP a condizione che siano PMI e previa approvazione da parte 
dagli intermediari finanziari autorizzati da tali strumenti. Le PMI in cerca di finanziamenti possono contattare un intermediario 
finanziario situato nel loro paese o nella loro regione. L'elenco degli intermediari finanziari e informazioni sui criteri di ammissibilità 
e sulle procedure di candidatura sono disponibili all'indirizzo www.access2finance.eu</p>
<p>I progetti pilota e di prima applicazione commerciale sono anche indirizzati alle imprese, indipendentemente dalle loro dimensioni, 
anche se il programma "Eco-innovazione" del CIP si rivolge principalmente alle PMI.</p>
<p>Le sovvenzioni per i progetti di networking sono prevalentemente destinate solo agli organismi di diritto pubblico o alle organizzazioni 
imprenditoriali oppure ai partenariati pubblico-privati.
FS: Sì. I Fondi strutturali offrono numerose possibilità di finanziamento per le imprese (in particolare per le PMI). Le condizioni e le 
tematiche variano da programma a programma; è pertanto necessario consultare i programmi operativi di ogni Stato membro o regione. </p>
<p>Enterprise Europe Network. Una rete di oltre 550 attori regionali provenienti da oltre 40 paesi che offre servizi di supporto al business 
e all'innovazione, quali informazioni in materia di UE, cooperazione commerciale e tecnologica, sfruttamento e trasferimento dei risultati 
della ricerca o partecipazione alla RSTI e ad altri programmi finanziati dall'UE. I servizi di questa rete sono concepiti in modo particolare 
per le PMI, ma sono anche disponibili per tutte le imprese, i centri di ricerca e le università europei. </p>
<p>Nota bene: oltre a ricevere sovvenzioni per svolgere attività di ricerca e di innovazione, le imprese (ivi incluse le società di consulenza) 
possono ricevere fondi in qualità di coordinatori di progetti. Possono altresì partecipare alle gare d'appalto per la fornitura di servizi di 
analisi e di organizzazione legati all'attuazione dei programmi o per la prestazione di servizi di consulenza esperta.</p>

<p class="titoloPasso">Istituto di ricerca/università, inclusi gli istituti di ricerca privati</p> 
<p>7° PQ: Sì per tutti i filoni del 7° PQ.</p> 
<p>CIP: Talvolta. Gli istituti di ricerca e le università possono partecipare ad alcuni progetti e attività di networking, a 
seconda delle condizioni descritte nei rispettivi inviti a presentare proposte. Esistono in particolare opportunità nell'
ambito dei programmi che si occupano di tecnologie dell'informazione, energia intelligente e tecnologie ambientali. 
Possono inoltre candidarsi per aggiudicarsi contratti di servizi di analisi e di organizzazione. Gli istituti di ricerca 
e le università possono beneficiare, nel quadro del trasferimento tecnologico,  degli Strumenti finanziaricomunitari. 
Tali istituti di ricerca possono contattare un intermediario finanziario situato nel loro paese o nella loro regione 
per avere informazioni sui criteri di ammissione e sulle procedure di candidatura.</p> 
<p>FS: Sì. Il FSE (Fondo sociale europeo – vedere Allegato 3), può sostenere lo sviluppo del potenziale umano nella 
ricerca e nell'innovazione, segnatamente attraverso studi post-laurea e la formazione dei ricercatori. Per ulteriori 
dettagli e per conoscere le condizioni, occorre contattare l'autorità di gestione regionale/nazionale del FSE. Nell'ambito
 del FESR sono possibili alcune misure di sostegno a favore dei singoli ricercatori, a condizione che siano previste dal programma operativo pertinente. </p>
<p>È inoltre possibile chiedere informazioni presso il proprio ateneo sulle borse Erasmus per studiare all'estero nell'ambito del programma 
di apprendimento permanente dell'UE.</p>

<p class="titoloPasso">ONG/associazione di categoria o di ricerca/camera di commercio </p>
<p>7° PQ: Sì, se il proponente svolge attività pertinenti a un dato invito a presentare proposte.</p> 
<p>CIP: Sì, se specificato nell'invito a presentare proposte in questione, per eseguire progetti pilota e di prima applicazione commerciale o attività di networking.</p> 
<p>FS: Sì. Le condizioni e le tematiche variano in base al singolo programma nazionale/regionale, è quindi necessario consultare i programmi operativi di ogni Stato membro o regione per i dettagli.</p> 

<p class="titoloPasso">Ente pubblico - agenzia locale, regionale, governativa nazionale, di sviluppo regionale/locale e/o di innovazione, organismo intermedio (che agisce sotto la responsabilità di un'autorità di gestione o di certificazione che svolge mansioni per conto di questa autorità), o qualsiasi altro organismo di diritto pubblico</p> 
<p>7° PQ: Sì. Gli enti pubblici che svolgono attività di ricerca possono partecipare ai progetti finanziati dai programmi "Cooperazione" del 7° PQ e "Persone" del 7° PQ , in particolare nell'ambito di partenariati pubblico-privati istituiti in alcuni settori chiave, per svolgere attività di ricerca multinazionali  su larga scala in campi di particolare interesse per la competitività industriale europea e di elevata visibilità sociale. Questi partenariati vengono costituiti attraverso Imprese comuni e Iniziative tecnologiche congiunte (ITC). Gli enti pubblici sono inoltre partecipanti chiave alle ERA-NET.</p> 
<p>I ministeri e le agenzie nazionali responsabili della ricerca sono in special modo incoraggiati a partecipare alle azioni "Infrastrutture per la ricerca", "Regioni della conoscenza" e "Sostegno allo sviluppo coerente delle politiche di ricerca" del programma "Capacità" del 7° PQ. Le autorità regionali sono anche partecipanti chiave ai distretti basati sulla ricerca nell'ambito dell'azione "Regioni della conoscenza".</p>
<p>Infine, le autorità nazionali e regionali svolgono un ruolo importante nella verifica dei progetti a sostegno degli enti di ricerca che vengono finanziati nelle regioni di convergenza attraverso l'azione "Potenziale di ricerca" del programma "Capacità" del 7° PQ.</p>
 
<p><a href="${f:url('regoleIscrizione?page=passo2')}">Vai al Passo 2: Chi altro è convolto nel progetto?</a></p>

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
