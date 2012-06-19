package project.controller.admin;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

import project.meta.PartnerMeta;
import project.model.Partner;
import project.service.PartnerService;

public class PartnerController extends Controller {

    private PartnerService service = new PartnerService();
    private PartnerMeta meta = PartnerMeta.get();
    
    @Override
    public Navigation run() throws Exception {
        RequestMap input = new RequestMap(request);
        String key = (String) input.get("key");
        String a = (String) input.get("a");
        if (a != null){
            if (a.equals("1")){
                if(service.validate(request, meta)){
                    // si aggiunge il partner!
                    service.updatePartner(asKey(meta.key), request);
                }
            }
        }
        Partner partner = null;
        try{
            partner = service.getOrNull(asKey(meta.key));
        }catch (Exception e) { }
        if (partner == null)
            return redirect(basePath);
        requestScope("p", partner);
        requestScope("leaderList", service.getLeaded(partner.getKey()));
        requestScope("projectList", service.getProjectByPartner(partner.getKey()));
        requestScope("urlUpdate", "partner?key=" + key);
        return forward("partner.jsp");
    }
}
