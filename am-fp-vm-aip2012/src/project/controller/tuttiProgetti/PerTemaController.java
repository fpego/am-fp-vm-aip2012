package project.controller.tuttiProgetti;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class PerTemaController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return forward("perTema.jsp");
    }
}
