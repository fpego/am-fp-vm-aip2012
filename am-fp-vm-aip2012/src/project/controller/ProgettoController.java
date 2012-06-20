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
        String origin = (String) input.get("origin");
        String page = (String) input.get("page");
        String urlProgetto = "progetto?key=" + KeyFactory.keyToString(progetto.getKey()) + "&origin=" + origin;
        String urlRisultati = urlProgetto + "&page=risultati";
        String urlDocumentazione = urlProgetto + "&page=doc";
        String urlEsplora = urlProgetto + "&page=esplora";
        String urlIndietro = null;
        if (origin != null){
            if (origin.equals("tP")){
                urlIndietro = "tuttiProgetti";
            }else if (origin.equals("aI")){
                urlIndietro = "tuttiProgetti?page=perAnnoInizio";
            }else if (origin.equals("aF")){
                urlIndietro = "tuttiProgetti?page=perAnnoFine";
            }else if (origin.equals("pT")){
                urlIndietro = "tuttiProgetti?page=perTema&tema=" + (String) input.get("tema");
            }else if (origin.equals("pA")){ //arrivo dai partner
                urlIndietro = "javascript:history.go(-1);";
            }else{
                urlIndietro = "index";
            }
        }else{
            urlIndietro = "index";
        }
        
        requestScope("p", progetto);
        requestScope("urlProgetto", urlProgetto);
        requestScope("urlRisultati", urlRisultati);
        requestScope("urlDocumentazione", urlDocumentazione);
        requestScope("urlEsplora", urlEsplora);
        requestScope("urlIndietro", urlIndietro);
        
        if (page != null){
            if (page.equals("risultati")){
                return forward("progetto/risultati.jsp");
            }
            if (page.equals("doc")){
                requestScope("documenti", service.getProjectFiles(progetto.getKey()));
                return forward("progetto/documentazione.jsp");
            }
            if (page.equals("esplora")){
                requestScope("pLeader", service.getLeader(asKey(meta.key)));
                requestScope("partners", service.getPartnerList(asKey(meta.key)));
                return forward("progetto/esplora.jsp");
            }
        }
        return forward("progetto.jsp");
    }
}
