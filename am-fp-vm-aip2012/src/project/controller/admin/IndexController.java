package project.controller.admin;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import project.service.PartnerService;
import project.service.ProgettoService;

/**
 * Pagina principale dell'amministrazione
 * @author Francesco
 *
 */
public class IndexController extends Controller {

    private ProgettoService service = new ProgettoService();
    private PartnerService  paService = new PartnerService();
    @Override
    public Navigation run() throws Exception {
        requestScope("projectList", service.getProgettoList());
        requestScope("partnerList", paService.getAllPartnersList());
        return forward("index.jsp");
    }
}
