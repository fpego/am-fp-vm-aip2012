package project.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

public class TuttiPartnersController extends Controller {

    @Override
    public Navigation run() throws Exception {
        RequestMap input = new RequestMap(request);
        String page = (String) input.get("page");
        if (page != null){
            if(page.equals("leader")){
                return forward("tuttiPartners/leader.jsp");
            }
        }
        return forward("tuttiPartners.jsp");
    }
}
