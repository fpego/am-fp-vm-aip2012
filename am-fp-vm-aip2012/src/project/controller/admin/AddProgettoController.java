package project.controller.admin;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

import project.meta.ProgettoMeta;
import project.service.ProgettoService;

public class AddProgettoController extends Controller {

    private ProgettoService service = new ProgettoService();
    private ProgettoMeta meta = ProgettoMeta.get();
    
    @Override
    public Navigation run() throws Exception {
        RequestMap input = new RequestMap(request);
        String a = (String) input.get("a");
        if (a != null && a.equals("1")){
         // stiamo uplodando un nuovo progetto! Validiamo l'input
            if (service.validate(request,meta)) {
                service.insertProgetto(input);
                return forward(basePath);
            }
        }
        return forward("addProgetto.jsp");
    }
}
