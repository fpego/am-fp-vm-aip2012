package project.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

import com.google.appengine.api.datastore.KeyFactory;

import project.meta.ProgettoMeta;
import project.model.Progetto;
import project.service.ProgettoService;

public class ProgettoController extends Controller {
    
    private ProgettoService service = new ProgettoService();
    private ProgettoMeta meta = ProgettoMeta.get();
    
    @Override
    public Navigation run() throws Exception {
        RequestMap input = new RequestMap(request);
        Progetto progetto = service.getOrNull(asKey(meta.key));
        if (progetto == null){
            return redirect("tuttiProgetti.jsp");
        }
        String page = (String) input.get("page");
        String urlProgetto = "progetto?key=" + KeyFactory.keyToString(progetto.getKey());
        String urlRisultati = urlProgetto + "&page=risultati";
        String urlDocumentazione = urlProgetto + "&page=doc";
        String urlEsplora = urlProgetto + "&page=esplora";
        
        requestScope("p", progetto);
        requestScope("urlProgetto", urlProgetto);
        requestScope("urlRisultati", urlRisultati);
        requestScope("urlDocumentazione", urlDocumentazione);
        requestScope("urlEsplora", urlEsplora);
        
        if (page != null){
            if (page.equals("risultati")){
                return forward("progetto/risultati.jsp");
            }
            if (page.equals("doc")){
                return forward("progetto/documentazione.jsp");
            }
            if (page.equals("esplora")){
                return forward("progetto/esplora.jsp");
            }
        }
        return forward("progetto.jsp");
    }
}
