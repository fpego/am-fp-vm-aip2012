package project.controller.admin;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

import project.meta.ProgettoMeta;
import project.model.Progetto;
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
        RequestMap input = new RequestMap(request);
        Progetto progetto = service.getOrNull(asKey(meta.key));
        
        
        requestScope("p", progetto);
        return forward("progetto.jsp");
    }
}
