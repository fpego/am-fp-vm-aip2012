package project.controller;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

import com.google.appengine.api.datastore.KeyFactory;

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
        String fwdPage = "partner.jsp"; // default fw page
        if (page != null){
            if (page.equals("ajax")){
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
            }else if (page.equals("chiSiamo")){
                fwdPage = "partner/chiSiamo.jsp";
            }else if (page.equals("contatti")){
                fwdPage = "partner/contatti.jsp";
            }else if (page.equals("eventi")){
                fwdPage = "partner/eventi.jsp";
            }
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
        String urlPresentazione = "partner?key=" + KeyFactory.keyToString(partner.getKey());
        String urlChiSiamo = urlPresentazione + "&page=chiSiamo";
        String urlContatti = urlPresentazione + "&page=contatti";
        String urlEventi = urlPresentazione + "&page=eventi";
        
        requestScope("urlIndietro", urlIndietro);
        requestScope("urlPresentazione", urlPresentazione);
        requestScope("urlChiSiamo", urlChiSiamo);
        requestScope("urlContatti", urlContatti);
        requestScope("urlEventi", urlEventi);
        requestScope("partner", partner);
        requestScope("leaderList", service.getLeaded(partner.getKey()));
        requestScope("projectList", service.getProjectByPartner(partner.getKey()));
        return forward(fwdPage);
    }
}
