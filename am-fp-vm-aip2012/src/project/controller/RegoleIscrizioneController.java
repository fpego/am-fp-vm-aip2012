package project.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

public class RegoleIscrizioneController extends Controller {

    @Override
    public Navigation run() throws Exception {
        RequestMap input = new RequestMap(request);
        String page = (String) input.get("page");
        if (page != null){
            if(page.equals("bandi")){
                return forward("regoleIscrizione/bandi.jsp");
            }
            if(page.equals("faq")){
                return forward("regoleIscrizione/faq.jsp");
            }
        }
        return forward("regoleIscrizione.jsp");
    }
}
