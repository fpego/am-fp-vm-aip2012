package project.controller.regoleIscrizione;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class BandiController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return forward("bandi.jsp");
    }
}
