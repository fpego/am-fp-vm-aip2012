package project.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

import project.meta.PartnerMeta;
import project.model.Partner;
import project.service.PartnerService;


public class PartnerController extends Controller {
    
    private PartnerService service = new PartnerService();
    private PartnerMeta meta = PartnerMeta.get();

    /**
     * Dalla chiave passata per parametro alla pagina estrapolo il partner. 
     * Se lo trovo bene, lo mostro, altrimenti redirigo alla pagina di tutti i partner
     */
    @Override
    public Navigation run() throws Exception {
        RequestMap input = new RequestMap(request);
        String page = (String) input.get("page");
        if (page.equals("ajax")){
            //TODO girare ad una pagina che mostra il json generato
            
            return null;
        }
        Partner partner = service.getOrNull(asKey(meta.key));
        if (partner == null){
            return redirect("tuttiPartner.jsp");
        }
        
        requestScope("partner", partner);
        return forward("partner.jsp");
    }
}
