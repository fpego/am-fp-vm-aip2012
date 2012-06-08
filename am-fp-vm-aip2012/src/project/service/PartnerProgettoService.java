package project.service;

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
    
    public List<Partner> getPartnerByProgetto(Key progetto){
        //TODO IMPLEMENT!!
        return null;
    }
}
