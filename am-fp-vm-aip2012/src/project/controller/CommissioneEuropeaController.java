package project.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class CommissioneEuropeaController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return forward("commissioneEuropea.jsp");
    }
}
