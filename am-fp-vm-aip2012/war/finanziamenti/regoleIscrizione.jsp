<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="/common/meta-head.jsp" />
<script type="text/javascript" src="js/mostra.js"></script>
<title>Progetti UE - Regole d'iscrizione - Bandi</title>
</head>
<body>
<jsp:include page="/common/header.jsp" />
<section id="middle">
	<div id="container">
		<div id="content">
<!-- CONTENT START -->

<h1>Finanziamenti -> Regole d'iscrizione</h1>

<h3><a href="#"  onclick="visualizza('passo1'); return false">Passo 1 - Possiedo i requisiti per un dato programma o una data fonte di finanziamento?</a></h3>

<div id="passo1" style="display:none">
<p class="titoloPasso"><a href="#"  onclick="visualizza('ref1'); return false">Imprese (micro, piccola, media, grande impresa – con/senza scopo di lucro, partenariato pubblico-privato, fornitore di servizi, 
coordinatore di progetti, ecc.) eccetto gli istituti di ricerca</a></p>
<div id="ref1" style="display:none">
	<p>Sì. Le imprese possono partecipare a quasi tutte le attività del 7° PQ e sono incoraggiate a farlo. Inoltre, il programma 
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
</div>

<p class="titoloPasso"><a href="#"  onclick="visualizza('ref2'); return false">Istituto di ricerca/università, inclusi gli istituti di ricerca privati</a></p>
<div id="ref2" style="display:none"> 
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
	
</div>

<p class="titoloPasso"><a href="#"  onclick="visualizza('ref3'); return false">ONG/associazione di categoria o di ricerca/camera di commercio</a></p>
<div id="ref3" style="display:none">
	<p>7° PQ: Sì, se il proponente svolge attività pertinenti a un dato invito a presentare proposte.</p> 
	<p>CIP: Sì, se specificato nell'invito a presentare proposte in questione, per eseguire progetti pilota e di prima applicazione commerciale o attività di networking.</p> 
	<p>FS: Sì. Le condizioni e le tematiche variano in base al singolo programma nazionale/regionale, è quindi necessario consultare i programmi operativi di ogni Stato membro o regione per i dettagli.</p> 
</div>
<p class="titoloPasso"><a href="#"  onclick="visualizza('ref7'); return false">Ente pubblico - agenzia locale, regionale, governativa nazionale, di sviluppo regionale/locale e/o di innovazione, organismo intermedio (che agisce sotto la responsabilità di un'autorità di gestione o di certificazione che svolge mansioni per conto di questa autorità), o qualsiasi altro organismo di diritto pubblico</a></p> 
<div id="ref7" style="display:none">
	<p>7° PQ: Sì. Gli enti pubblici che svolgono attività di ricerca possono partecipare ai progetti finanziati dai programmi "Cooperazione" del 7° PQ e "Persone" del 7° PQ , in particolare nell'ambito di partenariati pubblico-privati istituiti in alcuni settori chiave, per svolgere attività di ricerca multinazionali  su larga scala in campi di particolare interesse per la competitività industriale europea e di elevata visibilità sociale. Questi partenariati vengono costituiti attraverso Imprese comuni e Iniziative tecnologiche congiunte (ITC). Gli enti pubblici sono inoltre partecipanti chiave alle ERA-NET.</p> 
	<p>I ministeri e le agenzie nazionali responsabili della ricerca sono in special modo incoraggiati a partecipare alle azioni "Infrastrutture per la ricerca", "Regioni della conoscenza" e "Sostegno allo sviluppo coerente delle politiche di ricerca" del programma "Capacità" del 7° PQ. Le autorità regionali sono anche partecipanti chiave ai distretti basati sulla ricerca nell'ambito dell'azione "Regioni della conoscenza".</p>
	<p>Infine, le autorità nazionali e regionali svolgono un ruolo importante nella verifica dei progetti a sostegno degli enti di ricerca che vengono finanziati nelle regioni di convergenza attraverso l'azione "Potenziale di ricerca" del programma "Capacità" del 7° PQ.</p>
</div>	


</div>
<h3><a href="#"  onclick="visualizza('passo2'); return false">Passo 2 - Chi altro è convolto nel progetto?</a></h3>
<div id="passo2" style="display:none">
<p class="titoloPasso"><a href="#"  onclick="visualizza('ref4'); return false">Nessuno (a parte il contraente/beneficiario principale)</a></p>
<div id="ref4" style="display:none">
<p> 7° PQ: Sì per il programma "Idee" del 7° PQ (ricerca di base) e per alcune azioni Marie Curie del programma "Persone" del 7° PQ o parte del programma "Capacità" del 7° PQ (Potenziale di ricerca). Questa opzione può anche interessare i contratti di servizi/di esperti.</p>
<p>CIP: Sì per gli Strumenti finanziari comunitari per le PMI e per i contratti di servizi e di esperti. Questa opzione è possibile anche per i progetti pilota e di prima applicazione commerciale, se l'invito a presentare proposte pertinente lo consente.</p>
<p>FS: Sì. Una singola persona, impresa od organizzazione può ottenere sostegno dai FS. Le condizioni e le tematiche variano in base al singolo programma nazionale/regionale, è quindi necessario consultare i programmi operativi del proprio Stato membro o della propria regione per i dettagli.</p>
</div>

<p class="titoloPasso"><a href="#"  onclick="visualizza('ref5'); return false">Solo i partner della mia regione o del mio paese</a></p>
<div id="ref5" style="display:none">
<p>7° PQ: Sì. I partenariati transnazionali composti da almeno 3 diversi Stati membri dell'UE/del SEE/paesi associati sono la norma nell'ambito del 7° PQ, tranne che per i programmi "Idee" del 7° PQ e "Persone" del 7° PQ (nelle Reti per la formazione iniziale con 3 o più partner, sono richiesti almeno 3 diversi Stati membri dell'UE/del SEE/paesi associati). Le Imprese comuni e le ITC possono avere regole specifiche per quanto riguarda la partecipazione di entità provenienti da Stati non membri dell'UE.</p>
<p>CIP: Forse. I partenariati transnazionali fra i paesi dell'UE rappresentano la regola generale per i progetti e le reti. Eccezione: gli "Strumenti finanziari" non richiedono la partecipazione di ulteriori partner al progetto finanziato.</p>
<p>FS: Forse. Vi è una netta differenza fra, da un lato, i programmi degli obiettivi "Convergenza" e "Competitività regionale", e dall'altro lato, i programmi dell'obiettivo "Cooperazione territoriale europea".</p>
<p>I programmi operativi dei primi due obiettivi coprono una sola regione o diverse regioni di un unico Stato membro. Potete collaborare con partner al di fuori della zona prevista dal vostro programma nazionale o regionale finanziato dai FS. Tuttavia, solo voi riceverete i fondi per il progetto dal programma dei FS, mentre i partner al di fuori della zona interessata dal programma (nelle regioni UE limitrofe) non riceveranno in generale un cofinanziamento da tale programma. Essi potranno ricevere finanziamenti dai FS nell'ambito del programma che interessa la loro regione.</p>
<p>Occorre tuttavia notare che la cooperazione al di fuori della zona interessata dal programma rappresenta un'eccezione nell'ambito degli obiettivi "Convergenza" e "Competitività regionale e occupazione"; di fatto, solo alcuni programmi scelgono di destinare parte del loro bilancio ad azioni di cooperazione interregionale che prevedono almeno un'autorità regionale o locale di un altro Stato membro.</p>
<p>I finanziamenti ai progetti congiunti fra partner di almeno due Stati membri sono disponibili grazie ai programmi di cooperazione territoriale dell'UE a titolo del FESR (vedere Allegato 3), nell'ambito dei quali gli attori pubblici cooperano su base bilaterale oltre frontiera (cooperazione transfrontaliera) o su base multilaterale in regioni più estese (cooperazione transnazionale). Infine, i progetti congiunti fra partner di regioni diverse in tutta la Comunità europea sono coperti dal programma per la cooperazione interregionale ("INTERREG IV C" su innovazione, economia della conoscenza, ambiente e prevenzione dei rischi) oppure dal programma per le reti di cooperazione e lo scambio di esperienze in materia di sviluppo urbano integrato (URBACT). Vedere il Passo 6 successivo per ulteriori informazioni.</p>
<p>Nel quadro dei programmi di cooperazione transfrontaliera, le spese sostenute dai partner situati esternamente alla zona interessata dal programma possono essere ammesse entro un certo limite e in casi debitamente giustificati, qualora gli obiettivi del progetto risultino difficilmente conseguibili senza la partecipazione di tali partner.</p>
<p>I partner del SEE , non Stati membri dell'UE, non possono ricevere finanziamenti dai Fondi strutturali, ma possono partecipare alle reti o ai progetti di cooperazione a proprie spese.</p>
<p>Per le zone rurali, il FEASR (Fondo europeo agricolo per lo sviluppo rurale) sostiene anche i partenariati transnazionali, i quali seguono per lo più l'approccio dal basso verso l'alto dell'iniziativa "Leader". Il nuovo periodo di programmazione pone una forte enfasi sulla creazione di reti fra i gruppi d'azione locali. Un ulteriore scambio di esperienze, di risultati e di buone prassi è previsto nel quadro della rete europea per lo sviluppo rurale.</p>
</div>

<p class="titoloPasso"><a href="#"  onclick="visualizza('ref6'); return false">Partner di Stati non membri dell'UE</a></p>
<div id="ref6" style="display:none">
	<p>7° PQ: Sì per le azioni di cooperazione internazionale che riguardano i temi, nell'ambito del programma "Cooperazione" del 7° PQ, a condizione che partecipino anche partner di almeno 3 diversi Stati membri dell'UE/del SEE. Le Imprese comuni e le ITC possono avere regole specifiche per quanto riguarda la partecipazione di entità provenienti da Stati non membri dell'UE. Nel quadro del programma "Persone" del 7° PQ la dimensione internazionale contribuisce alla formazione permanente e allo sviluppo della carriera dei ricercatori dell'UE, attirando talenti extraeuropei nel campo della ricerca e promuovendo una collaborazione reciprocamente vantaggiosa con gli attori extraeuropei che operano nel campo della ricerca. Le attività "INCO" previste dal programma "Capacità" del 7° PQ sono appositamente concepite per la cooperazione internazionale e anche le azioni della parte "Infrastrutture per la ricerca" sono aperte alla cooperazione internazionale. Per ulteriori dettagli vedere: http://cordis.europa.eu/fp7/public_it.html. La partecipazione di partner provenienti da Stati non membri dell'UE è altresì possibile nell'ambito dell'area tematica "Ricerca a favore delle PMI" del programma "Capacità" del 7° PQ.</p>
	<p>CIP: Sì per alcuni paesi.</p>
	<p>Ai sensi dell'articolo 4 della decisione che istituisce il CIP, la partecipazione al CIP è aperta ai paesi del SEE, ai paesi candidati e dei Balcani occidentali, nonché ad altri paesi terzi, qualora consentito dagli accordi e dalle procedure.</p>
	<p>Per un elenco dei paesi che partecipano al CIP.</p>
	<p>FS: No, per i programmi degli obiettivi "Convergenza" e "Competitività regionale e occupazione".</p>
	<p>Nel quadro dei programmi dell'obiettivo "Cooperazione territoriale europea", il FESR può finanziare le spese sostenute per l'esecuzione di progetti sul territorio di paesi non appartenenti alla Comunità europea entro un limite del 10 % dell'importo del proprio contributo al programma operativo, qualora i progetti apportino benefici alle regioni della Comunità.</p>
	
</div>
</div>


<h3><a href="#"  onclick="visualizza('passo3'); return false">Passo 3 - Come candidarsi al programma di finanziamento?</a></h3>
<div id="passo3" style="display:none">
	<p>Iscrive il tuo progetto, vai a <a href="${f:url('/creaProgetto')}">Crea un progetto</a>, scrivi i tuoi dati, poi noi ti cotattaremo.
	Ricorda che devi avere almeno 5 partners.</p>
	<p>La durata deve essere un numero di anni intero, compreso tra 2 e 10.</p>
</div>
<!-- CONTENT END -->
		</div>
	</div>
<aside id="sideLeft">
<!-- LEFT MENU START -->
<jsp:include page="/common/leftMenu_finanziamenti.jsp" />
<!-- LEFT MENU END -->
</aside>
</section>
<jsp:include page="/common/footer.jsp" />

</body>
</html>
