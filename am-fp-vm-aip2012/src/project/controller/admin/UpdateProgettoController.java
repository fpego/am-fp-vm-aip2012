package project.controller.admin;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.upload.FileItem;
import org.slim3.util.RequestMap;

import project.meta.ProgettoMeta;
import project.service.ProgettoService;

public class UpdateProgettoController extends Controller {

    private ProgettoService service = new ProgettoService();
    private ProgettoMeta meta = ProgettoMeta.get();
    
    @Override
    public Navigation run() throws Exception {
        RequestMap input = new RequestMap(request);
        String a = (String) input.get("a");
        String key = (String) input.get("key");
        if (a != null){
            if (a.equals("1")){
                // aggiorno i campi del progetto
                service.updateProgetto(asKey(meta.key), new RequestMap(request));
            }else if (a.equals("2")){
                // upload di un file
                FileItem formFile = requestScope("formFile");
                service.uploadFile(asKey(meta.key), formFile);
            }else if (a.equals("3")){
                // aggiunta di un nuovo partner
                String nomePartner = (String) input.get("nomePartner");
                service.addPartnerToProgetto(asKey(meta.key), nomePartner);
            }else if (a.equals("4")){
                // elimino il progetto
                service.removeProgetto(asKey(meta.key));
                // devo redirigere alla home, non ho più il progetto al quale tornare
                return redirect(basePath);
            }
        }
        return redirect(basePath + "progetto?key=" + key);
    }
}
