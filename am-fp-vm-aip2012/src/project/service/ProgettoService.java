package project.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slim3.controller.validator.Validators;
import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;

import project.meta.ProgettoMeta;
import project.model.Documento;
import project.model.Partner;
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
        progetto.setTitoloProgetto((String) input.get("titoloProgetto"));
        progetto.setPresentazione((String) input.get("presentazione"));
        
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(progetto);
        tx.commit();
        // DOPO aver inserito il progetto faccio le relazioni con i vari partner, altrimenti non avrei la key del progetto per creare le relazioni
        String partnerName;
        Partner partner;
        // sono già sicuro che i partner sono almeno 5, sono stati validati precedentemente
        for (int i = 1; i <= numPartner; i++){
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

}
