package project.controller.commissioneEuropea;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class ContattiController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return forward("contatti.jsp");
    }
}
