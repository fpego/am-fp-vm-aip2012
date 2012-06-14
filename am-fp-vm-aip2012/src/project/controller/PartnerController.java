package project.controller;

import java.util.List;

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
        if (page != null && page.equals("ajax")){
            String name = (String) input.get("term");
            List<Partner> partnerList = service.getPartnersByStartName(name);
            String out = "[ ";
            for (Partner p: partnerList){
                out += "\""+p.getNome()+"\",";
            }
            if (out.length() > 2)
                out = (String) out.subSequence(0, out.length()-1);
            out += "]";
            requestScope("ajax", out);
            return forward("ajax.jsp");
        }
        
        Partner partner = service.getOrNull(asKey(meta.key));
        if (partner == null){
            return redirect("tuttiPartner.jsp");
        }
        
        String origin = (String) input.get("origin");
        String urlIndietro = "index";
        if (origin != null){
            if (origin.equals("tP")){
                urlIndietro = "tuttiPartners";
            }else if (origin.equals("pL")){
                urlIndietro = "tuttiPartners?page=leader";
            }else if (origin.equals("project")){
                //per tornare alla pagina del progetto uso js
                urlIndietro = "javascript:history.go(-1);";
            }
        }
        
        requestScope("partner", partner);
        requestScope("leaderList", service.getLeaded(partner.getKey()));
        requestScope("projectList", service.getProjectByPartner(partner.getKey()));
        requestScope("urlIndietro", urlIndietro);
        return forward("partner.jsp");
    }
}
