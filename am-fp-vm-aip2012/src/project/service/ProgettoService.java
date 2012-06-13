package project.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slim3.controller.upload.FileItem;
import org.slim3.controller.validator.Validators;
import org.slim3.datastore.Datastore;
import org.slim3.util.RequestMap;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;

import project.meta.ProgettoMeta;
import project.model.Documento;
import project.model.Partner;
import project.model.PartnerProgetto;
import project.model.Progetto;


/**
 *  Classe di servizio per il progetto
 *  @author Francesco
 *  
 */
public class ProgettoService {
    private ProgettoMeta p = ProgettoMeta.get();
    private PartnerService pService = new PartnerService();
    private PartnerProgettoService ppService = new PartnerProgettoService();
    private DocumentoService docService = new DocumentoService();
    
    /**
     *  Preleva il progetto
     * @param key chiave 
     * @param version versione del progetto
     * @return il progetto trovato con la chiave passata
     */
    public Progetto get(Key key, Long version) {
        return Datastore.get(p, key, version);
    }
    
    /**
     *  Preleva il progetto o ritorna NULL se non lo trova
     * @param key chiave della ricetta
     * @return la ricetta trovata
     */
    public Progetto getOrNull(Key key) {
        return (key != null) ? Datastore.getOrNull(p, key) : null;
    }
    
    
    /**
     * Ritorna una lista di progetti
     */
    public List<Progetto> getProgettoList() {
        return Datastore.query(p).sort(p.key.asc).asList();
    }
    
    /**
     * Ritorna la lista di documenti legati al progetto passato per chiave
     * @param la chiave del progetto
     * @return la lista di documenti associati
     */
    public List<Documento> getProjectFiles(Key key){
        return Datastore.getOrNull(p, key).getDocumentoListRef().getModelList();
    }
    
    /**
     * Ritorna una lista di progetti ordinati in base all'anno d'inizio in ordine crescente
     */
    public List<Progetto> getProgettoListOrderByStartYearAsc() {
        return Datastore.query(p).sort(p.annoInizio.asc).asList();
    }
    
    /**
     * Ritorna la lista di anni nei quali è cominciato un progetto
     * @return
     */
    public List<Integer> getAnniInizioList(){
        List<Progetto> progetti = this.getProgettoListOrderByStartYearAsc();
        List<Integer> anni = new ArrayList<Integer>();
        int year;
        for (Progetto p: progetti){
            year = p.getAnnoInizio();
            if (!anni.contains(year)){
                anni.add(year);
            }
        }
        return anni;
    }
    
    /**
     * Ritorna l'elenco degli anni nei quali è finito un progetto.
     * @return
     */
    public List<Integer> getAnniFineList(){
        List<Progetto> progetti = this.getProgettoListOrderByEndYearAsc();
        List<Integer> anni = new ArrayList<Integer>();
        int year;
        for (Progetto p: progetti){
            year = p.getAnnoFine();
            if (!anni.contains(year)){
                anni.add(year);
            }
        }
        return anni;
    }
    
    /**
     * Ritorna una lista di progetti ordinati in base all'anno di fine in ordine crescente
     */
    public List<Progetto> getProgettoListOrderByEndYearAsc() {
        return Datastore.query(p).sort(p.annoFine.asc).asList();
    }
    
    /**
     * Ritorna una lista di progetti filtrati in base al tema
     * @param la stringa che definisce il tema da cercare nel progetto
     */
    public List<Progetto> getProgettoListByTema(String tema) {
        return (tema != null) ? Datastore.query(p).filter(p.tema.equal(tema)).sort(p.key.asc).asList() : null;
    }
    
    public List<String> getListOfTemaFromProjects(){
        List<String> tema = new ArrayList<String>();
        List<Progetto> p = this.getProgettoList();
        String tmp;
        for (int i = 0; i < p.size(); i++){
            tmp = p.get(i).getTema();
            if (!tema.contains(tmp)){
                tema.add(tmp);
            }
        }
        return tema;
    }
    
    /**
     * Restituisce il Partner leader del progetto la cui
     * chiave è passata come parametro.
     * @param progettoKey La Key del progetto
     * @return Il singolo Partner leader del progetto.
     * Restituisce null se non viene trovato il Partner.
     */
    public Partner getLeader(Key progettoKey){
        Progetto progetto = Datastore.get(p,progettoKey);
        Partner p = null;
        try{
            p = progetto.getLeaderRef().getModel();
        }catch (Exception e) {
            p = null;
        }
        return p;
    }
    
    /**
     * Inserisco il progetto con i parametri dati stile MAP
     * @param input mappa contenente tutti i dati del progetto
     * @return restituisce il progetto appena inserito
     */
    public Progetto insertProgetto(Map<String, Object> input) {
        Progetto progetto = new Progetto();
        int durata = 2;
        int numPartner = 0;
        int year = Calendar.getInstance().get(Calendar.YEAR);
        
        try{ durata = Integer.parseInt((String) input.get("durata"));
        }catch (Exception e) { return null;  }
        try{ numPartner = Integer.parseInt((String) input.get("numPartner"));
        }catch (Exception e) { return null;  }
       
        progetto.setAnnoInizio(year);
        progetto.setAnnoFine(year + durata);
        progetto.setDurata(durata);
        progetto.setTitoloProgetto((String) input.get("titoloProgetto"));
        progetto.setPresentazione((String) input.get("presentazione"));
        progetto.setTema((String) input.get("tema"));
        
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(progetto);
        tx.commit();
        // DOPO aver inserito il progetto faccio le relazioni con i vari partner, altrimenti non avrei la key del progetto per creare le relazioni
        String partnerName;
        Partner partner;
        
        //Prendo il partner leader
        partnerName = (String) input.get("partner1");
        partner = pService.getPartnerByName(partnerName);
        if (partner == null){
            partner = pService.createPartner(partnerName);
        }
        // crea il collegamento tra partner e progetto e lo setta anche come leader.
        pService.setLeader(partner, progetto);
        //ppService.creaCollegamentoLeader(partner.getKey(), progetto.getKey());
        
        // sono già sicuro che i partner sono almeno 5, sono stati validati precedentemente
        for (int i = 2; i <= numPartner; i++){
            partnerName = (String) input.get("partner"+ i);
            if (partnerName.equals("")){
                continue;
            }
            partner = pService.getPartnerByName(partnerName);
            if (partner == null){
                //devo prima aggiungere questo nuovo partner
                partner = pService.createPartner(partnerName);
            }
            ppService.creaCollegamento(partner.getKey(), progetto.getKey());
        }
        return progetto;
    }
    
    /**
     * Inserisco il progetto passato per parametro nel db
     * @param il progetto da inserire
     * @return il progetto inserito
     */
    public Progetto insertProgetto(Progetto p){
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(p);
        tx.commit();
        return p;
    }
    
    /**
     * Ritorna la lista di partner associati ad un progetto identificato da una chiave
     * @param key - la chiave del progetto
     * @return lista di partner associati
     */
    public List<Partner> getPartnerList(Key key){
        Progetto p = Datastore.getOrNull(Progetto.class, key);
        if (p == null){
            return null;
        }
        List<Partner> partners = new ArrayList<Partner>();
        for (PartnerProgetto pp: p.getPartnerProgettoListRef().getModelList()){
            try{
                partners.add(pp.getPartnerRef().getModel());
            }catch (Exception e) {  }
        }
        
        return partners;
    }

    
    /**
     * Data la chiave di un progetto già esistente, gli carico sopra un file.
     * @param key
     * @return
     */
    public Documento uploadFile(Key key, FileItem formFile){
        Progetto p = this.getOrNull(key);
        if (p == null){
            return null;
        }
        Documento d = docService.upload(formFile);
        Transaction tx = Datastore.beginTransaction();
        d.getProgettoRef().setModel(p);
        Datastore.put(p);
        tx.commit();
        tx = Datastore.beginTransaction();
        Datastore.put(d);
        tx.commit();
        return d;
    }
    
    
    /**
     * Valida il form di upload di un nuovo progetto.
     * Sono richiesti TUTTI i campi, il numero di partner inseriti deve essere almeno 5 e la durata deve essere compresa tra 2 e 10 anni.
     * 
     * @param request
     * @param meta
     * @return
     */
    public boolean validate(HttpServletRequest request, ProgettoMeta meta) {
        boolean partnerOk = true;
        boolean durataOk = false;
        int durata = 0;
        String partner = null;
        Validators v = new Validators(request);
        
        v.add(p.tema, v.required());
        v.add(p.titoloProgetto, v.required());
        v.add(p.durata, v.integerType());
        v.add(p.durata, v.required());
        
        try{ 
            durata = Integer.parseInt((String) request.getParameter("durata"));
            if (durata >= 2 && durata <= 10)
                durataOk = true;
        }catch (Exception e) { 
            durataOk = false; 
        }
        // controllo che tutti i 5 partner (almeno quelli obbligati) sono diversi da null, se mi aggiunge campi che non usa me ne frego altamente
        try{
            for (int i = 1; i <= 5; i++){
                partner = (String) request.getParameter("partner"+i);
                if (partner.equals("")){
                    partnerOk = false;
                    break;
                }
            }
        }catch (Exception e) {
            partnerOk = false;
        }
        
        return v.validate() && partnerOk && durataOk;
    }

    /**
     * Ritorna la lista di progetti che iniziano nell'anno specificato
     * @param startYear - l'anno di inizio del progetto
     * @return
     */
    public List<Progetto> getProgettoFromStartYear(int startYear) {
        List<Progetto> progetti = Datastore.query(p).asList();
        List<Progetto> progettiOk = new ArrayList<Progetto>();
        for (Progetto p: progetti){
            if (p.getAnnoInizio() == startYear){
                progettiOk.add(p);
            }
        }
        return progettiOk;
    }

    /**
     * Ritorna la lista di progetti che finiscono nell'anno specificato
     * @param endYear
     * @return
     */
    public List<Progetto> getProgettoFromEndYear(int endYear) {
        List<Progetto> progetti = Datastore.query(p).asList();
        List<Progetto> progettiOk = new ArrayList<Progetto>();
        for (Progetto p: progetti){
            if (p.getAnnoFine() == endYear){
                progettiOk.add(p);
            }
        }
        return progettiOk;
    }

    /**
     * Data la chiave di un progetto, aggiorno i suoi campi.
     * Non ci sono qui i campi dei partner! Solo quelli propri del progetto.
     * 
     * @param asKey - la chiave del progetto
     * @param requestMap - mappa dell'input del form
     * @throws Exception 
     */
    public Progetto updateProgetto(Key key, Map<String, Object> input) throws Exception {
        Progetto progetto = this.getOrNull(key);
        if (progetto == null){
            throw new Exception("The project cannot be null!" + key);
        }
        // ogni modifica è dentro ad un blocco try diverso, così da poter aggiornare solamente i campi effettivamente presenti nel form
        try{ 
            int durata = Integer.parseInt((String) input.get("durata"));
            // devo inserire qui il controllo della durata, non l'ho fatto precedentemente.
            if (durata >= 2){
                progetto.setDurata(durata);
                progetto.setAnnoFine(progetto.getAnnoInizio() + durata);
            }
        }catch (Exception e) { }
        try{
            progetto.setTitoloProgetto((String) input.get("titoloProgetto"));
        }catch (Exception e) { }
        try{
            progetto.setPresentazione((String) input.get("presentazione"));
        }catch (Exception e) { }
        try{
            progetto.setTema((String) input.get("tema"));
        }catch (Exception e) { }
        try{
            progetto.setRisultati((String) input.get("risultati"));
        }catch (Exception e) { }
        
        
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(progetto);
        tx.commit();

        return progetto;
    }

}
