package project.controller.tuttiProgetti;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import project.model.Progetto;

public class PerAnnoInizioController extends Controller {

    @Override
    public Navigation run() throws Exception {
        String myvar = "secret";
        requestScope("myvar", myvar);
        Progetto p = new Progetto();
        p.setTitoloProgetto("titolo");
        p.setNomePartnerLeader("abc");
        requestScope("p", p);
        return forward("perAnnoInizio.jsp");
    }
}
