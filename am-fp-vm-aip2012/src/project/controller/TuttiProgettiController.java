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
        List<Progetto> projectList = null;
        if (page != null){
            if (page.equals("tuttiAnniInizio")){
                List<Integer> yearList = service.getAnniInizioList();
                requestScope("yearList", yearList);
                return forward("tuttiProgetti/tuttiAnniInizio.jsp");
            }else if (page.equals("tuttiAnniFine")){
                List<Integer> yearList = service.getAnniFineList();
                requestScope("yearList", yearList);
                return forward("tuttiProgetti/tuttiAnniFine.jsp");
            }else if(page.equals("perAnnoInizio")){
                int startYear = 0;
                try{
                    startYear = Integer.parseInt((String)input.get("anno"));
                }catch (Exception e) {
                    return redirect("tuttiProgetti?page=tuttiAnniInizio");
                }
                projectList = service.getProgettoFromStartYear(startYear);
                requestScope("projectList", projectList);
                requestScope("startYear", startYear);
                requestScope("urlIndietro", "tuttiProgetti?page=tuttiAnniInizio");
                return forward("tuttiProgetti/perAnnoInizio.jsp");
            }else if(page.equals("perAnnoFine")){
                int endYear = 0;
                try{
                    endYear = Integer.parseInt((String)input.get("anno"));
                }catch (Exception e) {
                    return redirect("tuttiProgetti?page=tuttiAnniFine");
                }
                projectList = service.getProgettoFromEndYear(endYear);
                requestScope("projectList", projectList);
                requestScope("endYear", endYear);
                requestScope("urlIndietro", "tuttiProgetti?page=tuttiAnniFine");
                return forward("tuttiProgetti/perAnnoFine.jsp");
            }else if(page.equals("tuttiTemi")){
                List<String> temi = service.getListOfTemaFromProjects();
                requestScope("temiList", temi);
                return forward("tuttiProgetti/tuttiTemi.jsp");
            }else if(page.equals("perTema")){
                String tema = (String) input.get("tema");
                projectList = service.getProgettoListByTema(tema);
                requestScope("projectList", projectList);
                requestScope("tema", tema);
                requestScope("urlIndietro", "tuttiProgetti?page=tuttiTemi");
                return forward("tuttiProgetti/perTema.jsp");
            }
        }
        
        projectList = service.getProgettoList();
        requestScope("projectList", projectList);
        return forward("tuttiProgetti.jsp");
    }
}
