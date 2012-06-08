package project.service;

import java.util.List;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.ModelQuery;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;

import project.meta.PartnerMeta;
import project.model.Partner;
import project.model.PartnerProgetto;
import project.model.Progetto;

/**
 * Classe di servizio per la creazione, memorizzazione, gestione e
 * recupero dei partners.
 * @author Aury
 *
 */
public class PartnerService {

    private PartnerMeta metaP = PartnerMeta.get();
    
    
    /**
     * Crea un nuovo Partner, col nome passato per parametro,
     * e lo inserisce nel Datastore tramite transazione.
     * @param nome Il nome del Partner
     * @return il partner appena creato
     */
    public Partner createPartner(String nome){
        Transaction tx = Datastore.beginTransaction();
        Partner p = new Partner();
        p.setNome(nome);
        Datastore.put(tx,p);
        tx.commit(); 
        return p;
    }
    
    /**
     * Inserisce nel datastore il partner passato per parametro
     * @param p il Partner da inserire
     * @return il partner inserito
     */
    public Partner insertPartner(Partner p){
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(p);
        tx.commit();
        return p;
    }
    
    /**
     * Restituisce il partner identificato dalla chiave, oppure null
     * @param la chiave del partner da cercare nel Datastore
     * @return null oppure il Partner
     */
    public Partner getOrNull(Key key){
        return (key != null) ? Datastore.getOrNull(metaP, key) : null;
    }
    
    /**
     * Restituisce una lista contenente tutti i partners
     * ordinata per nome.
     * @return una classe List<Partner>
     */
    public List<Partner> getAllPartnersList(){
        ModelQuery<Partner> query = Datastore.query(metaP);
        query.sort(metaP.nome.asc);
        return query.asList();
    }
    
    /**
     * Ritorna la lista di tutti i partner che sono leader di qualche progetto
     * @return
     */
    public List<Partner> getAllPartnersLeaderList() {
        //TODO IMPLEMENT!
        return null;
    }
    
    /**
     * Associa progetto e partner creando una istanza della
     * entità PartnerProgetto (per la relazione M-M) e salva tutto
     * nel datastore tramite transazione.
     * @param partner L'entità partner da associare al progetto
     * @param progetto L'entità progetto da associare al partner
     */
    public void setProject(Partner partner, Progetto progetto){
        Transaction tx = Datastore.beginTransaction();
        PartnerProgetto pp = new PartnerProgetto();
        pp.getPartnerRef().setModel(partner);
        pp.getProgettoRef().setModel(progetto);
        partner.getPartnerProgettoListRef().getModelList().add(pp);
        progetto.getPartnerProgettoListRef().getModelList().add(pp);
        Datastore.put(tx, partner, progetto,pp);
        tx.commit();
    }

    public Partner getPartnerByName(String partnerName) {
        return Datastore.query(metaP).filter(metaP.nome.equal(partnerName)).asSingle();
    }


}
