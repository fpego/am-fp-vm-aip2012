package project.service;

import org.slim3.datastore.Datastore;
import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;

import project.meta.PartnerMeta;
import project.meta.PartnerProgettoMeta;
import project.meta.ProgettoMeta;
import project.model.Partner;
import project.model.PartnerProgetto;
import project.model.Progetto;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class PartnerProgettoServiceTest extends AppEngineTestCase {

    private PartnerProgettoService service = new PartnerProgettoService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
    
    @Test
    public void test2() throws Exception {
        Partner p1 = new Partner();
        p1.setNome("IBM");
        Progetto pro = new Progetto();
        pro.setAnnoInizio(2012);
        pro.setTitoloProgetto("SuperCalc");
        p1.getLeaderOfListRef().getModelList().add(pro);
        pro.getLeaderRef().setModel(p1);
        Datastore.put(pro,p1);
        Partner fetchedPar = Datastore.get(PartnerMeta.get(),p1.getKey());
        assertTrue(fetchedPar != null);
        Progetto fetchedPr = Datastore.get(ProgettoMeta.get(), pro.getKey());
        assertTrue(fetchedPr != null);
        assertTrue(fetchedPr.getLeaderRef().getModel().equals(fetchedPar));
        assertTrue(fetchedPar.getLeaderOfListRef().getModelList().contains(fetchedPr));        
    }
    
    @Test
    public void testCollegamento() throws Exception{
        Partner partner = new Partner();
        Progetto progetto = new Progetto();
        Datastore.put(partner,progetto);
        service.creaCollegamento(partner.getKey(), progetto.getKey());
        PartnerProgetto pp = Datastore.query(PartnerProgettoMeta.get()).asSingle();
        assertTrue(pp.getProgettoRef().getModel().equals(progetto));
        assertTrue(pp.getPartnerRef().getModel().equals(partner));
    }
}
