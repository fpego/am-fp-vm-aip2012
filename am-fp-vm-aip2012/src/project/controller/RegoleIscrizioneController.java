package project.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

public class RegoleIscrizioneController extends Controller{

    @Override
    protected Navigation run() throws Exception {
        RequestMap input = new RequestMap(request);
        String page = (String) input.get("page");
        if (page != null){
            if(page.equals("passo1")){
                return forward("finanziamenti/passo1.jsp");
            }
            if(page.equals("passo2")){
                return forward("finanziamenti/passo2.jsp");
            }
            if(page.equals("passo3")){
                return forward("finanziamenti/passo3.jsp");
            }
           
        }
        return forward("finanziamenti/regoleIscrizione.jsp");
    }

}
