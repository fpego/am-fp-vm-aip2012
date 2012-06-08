package project.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

public class CommissioneEuropeaController extends Controller {

    @Override
    public Navigation run() throws Exception {
        RequestMap input = new RequestMap(request);
        String page = (String) input.get("page");
        if (page != null){
          
            if(page.equals("visione")){
                return forward("commissioneEuropea/visione.jsp");
            }
            
            if(page.equals("storia")){
                return forward("commissioneEuropea/storia.jsp");
            }
           
            if(page.equals("contatti")){
                return forward("commissioneEuropea/contatti.jsp");
            }
        }
        return forward("commissioneEuropea.jsp");
    }
}
