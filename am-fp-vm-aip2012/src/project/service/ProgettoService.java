package project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slim3.controller.validator.Validators;
import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;

import project.meta.ProgettoMeta;
import project.model.Documento;
import project.model.Progetto;


/**
 *  Classe di servizio per il progetto
 *  @author Francesco
 *  
 */
public class ProgettoService {
    private ProgettoMeta p = ProgettoMeta.get();
    
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
        try{ durata = Integer.parseInt((String) input.get("durata"));
        }catch (Exception e) { durata = 2;  }
        progetto.setAnnoInizio(2012);
        progetto.setAnnoFine(2012 + durata);
        progetto.setTitoloProgetto((String) input.get("titolo"));
        progetto.setPresentazione((String) input.get("presentazione"));
        progetto.setNomePartnerLeader((String) input.get("partner1"));
        //TODO aggiungere anche gli altri campi
        
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(progetto);
        tx.commit();
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
     * @param request
     * @param meta
     * @return
     */
    public boolean validate(HttpServletRequest request, ProgettoMeta meta) {
        
        Validators v = new Validators(request);
        v.add(p.tema, v.required());
        v.add(p.titoloProgetto, v.required());
        v.add(p.durata, v.integerType());
        v.add(p.durata, v.required());
        return v.validate();
    }

}
