package project.controller.progetto;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class RisultatiController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return forward("risultati.jsp");
    }
}
