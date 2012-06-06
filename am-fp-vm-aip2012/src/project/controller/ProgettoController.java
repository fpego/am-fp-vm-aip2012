package project.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import project.meta.ProgettoMeta;
import project.model.Progetto;
import project.service.ProgettoService;

public class ProgettoController extends Controller {
    
    private ProgettoService service = new ProgettoService();
    private ProgettoMeta meta = ProgettoMeta.get();
    
    @Override
    public Navigation run() throws Exception {
        Progetto progetto = service.getOrNull(asKey(meta.key));
        if (progetto == null){
            return redirect("tuttiProgetti.jsp");
        }
        requestScope("p", progetto);
        return forward("progetto.jsp");
    }
}
