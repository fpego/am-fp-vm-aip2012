package project.controller;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

import project.model.Progetto;
import project.service.ProgettoService;


/**
 * Da questa pagina si può raffinare la ricerca del progetto al quale si è interessati 
 *
 */
public class TuttiProgettiController extends Controller {

    private ProgettoService service = new ProgettoService();
    
    @SuppressWarnings("unused")
    private void insertProgettoTest(){
        Progetto p = new Progetto();
        p.setNomePartnerLeader("Team Rocket2");
        p.setTitoloProgetto("Pokemon");
        p.setTema("NintendoGame");
        p.setAnnoInizio(2008);
        p.setAnnoFine(2013);
        p.setDurata(5);
        p.setPresentazione("Ciao a tutti");
        p.setRisultati("Giocare a pokemon è bello!");
        service.insertProgetto(p);
    }
    
    @Override
    public Navigation run() throws Exception {
        
        //insertProgettoTest();
        
        RequestMap input = new RequestMap(request);
        String page = (String) input.get("page");
        List<Progetto> projectList = service.getProgettoList();
        requestScope("projectList", projectList);

        if (page != null){
            if(page.equals("perAnnoInizio")){
                projectList = service.getProgettoListOrderByStartYearAsc();
                requestScope("projectList", projectList);
                return forward("tuttiProgetti/perAnnoInizio.jsp");
            }
            if(page.equals("perAnnoFine")){
                projectList = service.getProgettoListOrderByEndYearAsc();
                requestScope("projectList", projectList);
                return forward("tuttiProgetti/perAnnoFine.jsp");
            }
            if(page.equals("perTema")){
                
                return forward("tuttiProgetti/perTema.jsp");
            }
        }
        return forward("tuttiProgetti.jsp");
    }
}
