package project.controller.tuttiProgetti;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class PerAnnoInizioController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return forward("perAnnoInizio.jsp");
    }
}
