package project.controller.admin;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import project.meta.DocumentoMeta;
import project.service.DocumentoService;

public class DeleteController extends Controller {

    private DocumentoService service = new DocumentoService();
    private DocumentoMeta meta = DocumentoMeta.get();
    
    @Override
    public Navigation run() throws Exception {
        service.delete(asKey(meta.key));
        return redirect(basePath);
    }
}
