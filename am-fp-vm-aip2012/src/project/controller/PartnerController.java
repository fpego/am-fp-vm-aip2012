package project.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

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
        Partner partner = service.getOrNull(asKey(meta.key));
        if (partner == null){
            return redirect("tuttiPartner.jsp");
        }
        
        requestScope("partner", partner);
        return forward("partner.jsp");
    }
}
