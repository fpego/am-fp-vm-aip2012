package project.service;

import java.util.List;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;

import project.meta.ProgettoMeta;
import project.model.Progetto;


/**
 *  Classe di servizio per il progetto
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
}
