package project.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class ProgettoController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return forward("progetto.jsp");
    }
}
