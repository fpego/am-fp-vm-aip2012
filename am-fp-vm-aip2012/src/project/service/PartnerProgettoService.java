package project.service;

import java.util.List;

import com.google.appengine.api.datastore.Key;

import project.meta.PartnerMeta;
import project.meta.PartnerProgettoMeta;
import project.meta.ProgettoMeta;
import project.model.Partner;
import project.model.PartnerProgetto;

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
        //TODO IMPLEMENT!!
        return null;
    }
    
    public List<Partner> getPartnerByProgetto(Key progetto){
        //TODO IMPLEMENT!!
        return null;
    }
}
