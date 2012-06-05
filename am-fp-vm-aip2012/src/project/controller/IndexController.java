package project.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

import project.model.Progetto;

public class IndexController extends Controller {

    @Override
    public Navigation run() throws Exception {
        String myvar = "secret";
        
        Progetto p = new Progetto();
        p.setTitoloProgetto("titolo");
        p.setNomePartnerLeader("abc");
        requestScope("p", p);
        
        RequestMap input = new RequestMap(request);
        String param = (String) input.get("param");
        if (param != null){
            if(param.equals("1")){
                myvar = "ohohoh!";
            }
            
        }
        
        requestScope("myvar", myvar);
        return forward("index.jsp");
    }
}
