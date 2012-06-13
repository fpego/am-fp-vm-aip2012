package project.controller.admin;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

/**
 * Rimuove il collegamento tra un progetto e il partner
 * @author Francesco
 *
 */
public class RemoveLinkController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return forward("removeLink.jsp");
    }
}
