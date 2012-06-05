package project.controller.tuttiPartners;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class LeaderController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return forward("leader.jsp");
    }
}
