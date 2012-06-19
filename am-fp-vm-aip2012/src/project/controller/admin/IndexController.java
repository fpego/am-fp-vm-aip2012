package project.controller.admin;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import project.service.ProgettoService;

/**
 * Pagina principale dell'amministrazione
 * @author Francesco
 *
 */
public class IndexController extends Controller {

    private ProgettoService service = new ProgettoService();
    
    @Override
    public Navigation run() throws Exception {
        requestScope("projectList", service.getProgettoList());
        return forward("index.jsp");
    }
}
