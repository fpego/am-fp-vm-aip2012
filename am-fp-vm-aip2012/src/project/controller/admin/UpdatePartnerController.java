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
        String key = (String) input.get("key");
        if (a != null && a.equals("1")){
            String nome = (String) input.get("nome");
            String chiSiamo = (String) input.get("chiSiamo");
            String indirizzo = (String) input.get("indirizzo");
            String telefono = (String) input.get("telefono");
            String email = (String) input.get("email");
            String sitoWeb = (String) input.get("sitoWeb");
            service.updatePartner(asKey(meta.key), nome, chiSiamo, indirizzo, telefono, email, sitoWeb);
        }
        return redirect(basePath + "addPartner?key="+key+"&a=3");
    }

}
