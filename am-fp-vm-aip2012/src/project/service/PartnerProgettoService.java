package project.service;

import java.util.ArrayList;
import java.util.List;

import org.slim3.datastore.Datastore;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;

import project.meta.PartnerMeta;
import project.meta.PartnerProgettoMeta;
import project.meta.ProgettoMeta;
import project.model.Partner;
import project.model.PartnerProgetto;
import project.model.Progetto;

/**
 * Classe di servizio per il collegamento tra Partner e Progetto
 * @author Francesco
 *
 */
public class PartnerProgettoService {
    private ProgettoMeta mProgetto = ProgettoMeta.get();
    private PartnerMeta mPartner = PartnerMeta.get();
    private PartnerProgettoMeta mPartnerProgetto = PartnerProgettoMeta.get();
    
    
    /**
     * Collega i progetti con i partner
     * @param partner
     * @param progetto
     */
    public PartnerProgetto creaCollegamento(Key partner, Key progetto){
        Partner p = Datastore.get(mPartner, partner);
        Progetto pr = Datastore.get(mProgetto, progetto);
        PartnerProgetto collegamento = new PartnerProgetto();
        collegamento.getPartnerRef().setModel(p);
        collegamento.getProgettoRef().setModel(pr);
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(collegamento);
        tx.commit();
        return collegamento;
    }
    
    /**
     * Collega il progetto con il partner LEADER
     * @param partner
     * @param progetto
     * @deprecated Usare {@link PartnerService#setLeader(Key, Key)}
     */
    public PartnerProgetto creaCollegamentoLeader(Key partner, Key progetto){
        
        Partner p = Datastore.get(mPartner, partner);
        Progetto pr = Datastore.get(mProgetto, progetto);
        PartnerProgetto collegamento = new PartnerProgetto();
        collegamento.getPartnerRef().setModel(p);
        collegamento.getProgettoRef().setModel(pr);
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(collegamento);
        tx.commit();
        return collegamento;
    }
    
    /**
     * Restituisce una lista di partners appartententi al
     * progetto dato.
     * @param progetto la Key del progetto
     * @return Una lista di Partners (eventualmente vuota)
     * @see PartnerProgettoService#getPartnerByProgetto(Progetto)
     */
    public List<Partner> getPartnerByProgetto(Key progetto){
       Progetto prg = Datastore.get(mProgetto, progetto);
       return this.getPartnerByProgetto(prg);
    }
    
    /**
     * Restituisce una lista di partners appartententi
     * al progetto dato.
     * @see PartnerProgettoService#getPartnerByProgetto(Key)
     * @param progetto Il Progetto associato
     * @return Una lista di Partner
     */
    public List<Partner> getPartnerByProgetto(Progetto progetto){
        List<Partner> partners = new ArrayList<Partner>();
        for(PartnerProgetto pp: progetto.getPartnerProgettoListRef().getModelList())
            partners.add(pp.getPartnerRef().getModel());
        return partners;
    }
    
    /**
     * Restituisce una lista di partners appartenenti
     * al progetto dato.
     * @param partner Il Partner associato
     * @return una lista di Progetti
     */
    public List<Progetto> getProgettoByPartner(Partner partner){
        List<Progetto> progetti = new ArrayList<Progetto>();
        for(PartnerProgetto pp: partner.getPartnerProgettoListRef().getModelList())
            progetti.add(pp.getProgettoRef().getModel());
        return progetti;
    }
    
    /**
     * Elimina solo il collegamento tra partner e progetto le cui chiavi
     * vengono fornite come parametri.
     * Se l'operazione ha successo e il collegamento viene eliminato,
     * il metodo ritorna true, false altrimenti.
     * @param partnerKey La Key del Partner
     * @param progettoKey La Key del Progetto
     * @return true se il collegamento viene eliminato, false se non viene trovato alcun
     * collegamento.
     */
    public boolean eliminaCollegamento(Key partnerKey, Key progettoKey){
        Partner partner = Datastore.get(mPartner, partnerKey);
        Progetto progetto = Datastore.get(mProgetto, progettoKey);
        for(PartnerProgetto pp: partner.getPartnerProgettoListRef().getModelList())
            if(pp.getProgettoRef().getModel().equals(progetto)){
                Datastore.delete(pp.getKey());
                return true;
            }
        return false;
    }
    
    /**
     * Elimina sia il collegamento tra Partner e Progetto, sia le due entità
     * (Partner e Progetto).
     * Restituisce true se l'operazione ha successo, false se non viene
     * trovato alcun collegamento.
     * Utilizza il metodo {@link PartnerProgettoService#eliminaCollegamento(Key, Key)}
     * @see PartnerProgettoService#eliminaCollegamento(Key, Key)
     * @param partnerKey La Key del Partner da eliminare insieme al collegamento
     * @param progettoKey La Key del Progetto da eliminare insieme al collegamento
     * @return true se l'operazione ha successo, false altrimenti.
     */
    public boolean eliminaTutto(Key partnerKey, Key progettoKey){
        if(eliminaCollegamento(partnerKey, progettoKey)){
            Datastore.delete(progettoKey,partnerKey);
            return true;
        }
        return false;
    }
}
