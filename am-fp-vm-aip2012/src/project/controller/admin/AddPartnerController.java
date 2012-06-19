package project.controller.admin;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

import project.meta.PartnerMeta;
import project.service.PartnerService;

public class AddPartnerController extends Controller {

    private PartnerService service = new PartnerService();
    private PartnerMeta meta = PartnerMeta.get();
    
    @Override
    public Navigation run() throws Exception {
        RequestMap input = new RequestMap(request);
        String a = (String) input.get("a");
        
        if (a != null){
            if (a.equals("1")){
             
                    // si aggiunge il partner!
                    service.createPartner(request);
              
            }else if (a.equals("2")){
                // si cancella il partner!
                service.elimina(asKey(meta.key));
            }else if (a.equals("3")){
                //si modifica il partner
                requestScope("p", service.getOrNull(asKey(meta.key)));
                return forward("updatePartner.jsp");
            }
            //redirigo a questa stessa pagina per rimuovere il reference al key dall'url
            return redirect("addPartner");
        }
        
        requestScope("pList", service.getAllPartnersList());
        return forward("addPartner.jsp");
    }
}
