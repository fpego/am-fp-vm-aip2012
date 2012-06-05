package project.controller.regoleIscrizione;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class FaqController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return forward("faq.jsp");
    }
}
