package project.controller.admin;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

import project.service.PartnerProgettoService;

/**
 * Rimuove il collegamento tra un progetto e il partner
 * @author Francesco
 *
 */
public class RemoveLinkController extends Controller {
    
    private PartnerProgettoService service = new PartnerProgettoService();

    @Override
    public Navigation run() throws Exception {
        RequestMap input = new RequestMap(request);
        String key = (String) input.get("project");
        service.eliminaCollegamento(asKey("partner"), asKey("project"));
        return forward(basePath + "progetto?key="+key);
    }
}
