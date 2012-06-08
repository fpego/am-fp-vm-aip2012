package project.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

import project.meta.ProgettoMeta;
import project.service.ProgettoService;

public class ProgettoInsertController extends Controller {

    private ProgettoService service = new ProgettoService();
    private ProgettoMeta meta = ProgettoMeta.get();
    
    @Override
    public Navigation run() throws Exception {
        if (service.validate(request,meta)) {
            service.insertProgetto(new RequestMap(request));
            return redirect(basePath);
        }else{
            return redirect("index");
        }
    }
}
