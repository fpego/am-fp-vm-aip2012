package project.controller.progetto;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class EsploraController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return forward("esplora.jsp");
    }
}
