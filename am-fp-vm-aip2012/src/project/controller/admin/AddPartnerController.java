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
                String nome = (String) input.get("nomePartner");
                String chiSiamo = (String) input.get("chiSiamoPartner");
                String indirizzo = (String) input.get("indirizzoPartner");
                String telefono = (String) input.get("telefonoPartner");
                String email = (String) input.get("emailPartner");
                String sitoWeb = (String) input.get("sitoWebPartner");
                if(service.validate(request, meta)){
                    // si aggiunge il partner!
                    service.createPartner(nome, chiSiamo, email, indirizzo, telefono, sitoWeb);
                }
            }else if (a.equals("2")){
                // si cancella il partner!
                service.elimina(asKey(meta.key));
            }
            //redirigo a questa stessa pagina per rimuovere il reference al key dall'url
            return redirect("addPartner");
        }
        
        requestScope("pList", service.getAllPartnersList());
        return forward("addPartner.jsp");
    }
}
