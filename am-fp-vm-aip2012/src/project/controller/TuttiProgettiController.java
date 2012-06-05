package project.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

public class TuttiProgettiController extends Controller {

    @Override
    public Navigation run() throws Exception {
        RequestMap input = new RequestMap(request);
        String page = (String) input.get("page");
        if (page != null){
            if(page.equals("perAnnoInizio")){
                return forward("tuttiProgetti/perAnnoInizio.jsp");
            }
            if(page.equals("perAnnoFine")){
                return forward("tuttiProgetti/perAnnoFine.jsp");
            }
            if(page.equals("perTema")){
                return forward("tuttiProgetti/perTema.jsp");
            }
        }
        return forward("tuttiProgetti.jsp");
    }
}
