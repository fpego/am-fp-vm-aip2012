package project.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

import project.service.PartnerService;

public class TuttiPartnersController extends Controller {

    private PartnerService service = new PartnerService();
    
    @Override
    public Navigation run() throws Exception {
        RequestMap input = new RequestMap(request);
        String page = (String) input.get("page");
        
        if (page != null){
            if(page.equals("leader")){
                requestScope("partnerList", service.getAllPartnersLeaderList());
                return forward("tuttiPartners/leader.jsp");
            }
        }
        
        requestScope("partnerList", service.getAllPartnersList());
        return forward("tuttiPartners.jsp");
    }
}
