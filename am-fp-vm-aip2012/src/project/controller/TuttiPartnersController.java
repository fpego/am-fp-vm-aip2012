package project.controller;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

import project.model.Partner;
import project.service.PartnerService;

public class TuttiPartnersController extends Controller {

    private PartnerService service = new PartnerService();
    
    
    @SuppressWarnings("unused")
    private void insertParterTest(){
        Partner p = new Partner();
        p.setNome("IBM");
        service.insertPartner(p);
    }
    
    @Override
    public Navigation run() throws Exception {
        //insertParterTest();
        RequestMap input = new RequestMap(request);
        String page = (String) input.get("page");
        List<Partner> partnerList = service.getAllPartnersList();
        
        if (page != null){
            if(page.equals("leader")){
                partnerList = service.getAllPartnersLeaderList();
                requestScope("partnerList", partnerList);
                return forward("tuttiPartners/leader.jsp");
            }
        }
        
        requestScope("partnerList", partnerList);
        return forward("tuttiPartners.jsp");
    }
}
