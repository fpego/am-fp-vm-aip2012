package project.controller.admin;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

import project.meta.PartnerMeta;
import project.service.PartnerService;

public class UpdatePartnerController extends Controller{

    private PartnerService service = new PartnerService();
    private PartnerMeta meta = PartnerMeta.get();
    
    @Override
    protected Navigation run() throws Exception {
        RequestMap input = new RequestMap(request);
        String a = (String) input.get("a");
                
        if (a != null && a.equals("1")){
            String chiSiamo = (String) input.get("chiSiamoPartner");
            String indirizzo = (String) input.get("indirizzoPartner");
            String telefono = (String) input.get("telefonoPartner");
            String email = (String) input.get("emailPartner");
            String sitoWeb = (String) input.get("sitoWebPartner");
            
            if(service.validate(request, meta)){        
                service.updatePartner(asKey(meta.key), chiSiamo, indirizzo, telefono,
                email, sitoWeb);
            }
        }
        return redirect(basePath + "addPartner");
    }

}
