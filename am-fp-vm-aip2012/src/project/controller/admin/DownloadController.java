package project.controller.admin;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import project.meta.DocumentoMeta;
import project.model.Documento;
import project.service.DocumentoService;

public class DownloadController extends Controller {

    private DocumentoService service = new DocumentoService();
    private DocumentoMeta meta = DocumentoMeta.get();
    
    @Override
    public Navigation run() throws Exception {
            Documento data =
                service.getData(asKey(meta.key), asLong(meta.version));
            byte[] bytes = service.getBytes(data);
            download(data.getFileName(), bytes);
            return null;
    }
}
