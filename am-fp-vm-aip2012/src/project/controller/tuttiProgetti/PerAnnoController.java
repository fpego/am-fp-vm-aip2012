package project.controller.tuttiProgetti;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class PerAnnoController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return forward("perAnno.jsp");
    }
}
