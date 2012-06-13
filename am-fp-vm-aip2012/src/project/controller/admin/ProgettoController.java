package project.controller.admin;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

import project.meta.ProgettoMeta;
import project.service.ProgettoService;

/**
 * Pagina di admin del progetto
 * Permette di editare i campi, creare nuove connessioni con i partner e uplodare file.
 * 
 * @author Francesco
 *
 */
public class ProgettoController extends Controller {

    private ProgettoService service = new ProgettoService();
    private ProgettoMeta meta = ProgettoMeta.get();
    
    @Override
    public Navigation run() throws Exception {
        // passo il progetto e la lista di documenti legati al progetto.
        RequestMap input = new RequestMap(request);
        String key = (String) input.get("key");
        requestScope("p", service.getOrNull(asKey(meta.key)));
        requestScope("partnerLeader", service.getLeader(asKey(meta.key)));
        requestScope("partnerList", service.getPartnerList(asKey(meta.key)));
        requestScope("docList", service.getProjectFiles(asKey(meta.key)));
        requestScope("urlUpdate", "updateProgetto?key=" + key);
        return forward("progetto.jsp");
    }
}
