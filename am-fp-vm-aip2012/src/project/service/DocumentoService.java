package project.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slim3.controller.upload.FileItem;
import org.slim3.datastore.Datastore;
import org.slim3.util.ByteUtil;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;

import project.meta.DocumentoFragmentMeta;
import project.meta.DocumentoMeta;
import project.model.Documento;
import project.model.DocumentoFragment;


public class DocumentoService {

    private static final int FRAGMENT_SIZE = 900000;
    
    private DocumentoMeta d = DocumentoMeta.get();
    private DocumentoFragmentMeta f = DocumentoFragmentMeta.get();
    
    /**
     * Ritorna la lista di tutti i documenti
     * @return
     */
    public List<Documento> getDocumentoList(){
        return Datastore.query(d).asList();
    }
    
    /**
     * Salva nel db il file uplodato.
     * @param formFile
     * @return
     */
    public Documento upload(FileItem formFile){
        if (formFile == null) {
            return null;
        }
        List<Object> models = new ArrayList<Object>();
        Documento data = new Documento();
        models.add(data);
        data.setKey(Datastore.allocateId(d));
        data.setFileName(formFile.getShortFileName());
        data.setLength(formFile.getData().length);
        byte[] bytes = formFile.getData();
        byte[][] bytesArray = ByteUtil.split(bytes, FRAGMENT_SIZE);
        Iterator<Key> keys =
            Datastore
                .allocateIds(data.getKey(), f, bytesArray.length)
                .iterator();
        for (int i = 0; i < bytesArray.length; i++) {
            byte[] fragmentData = bytesArray[i];
            DocumentoFragment fragment = new DocumentoFragment();
            models.add(fragment);
            fragment.setKey(keys.next());
            fragment.setBytes(fragmentData);
            fragment.setIndex(i);
            fragment.getUploadDataRef().setModel(data);
        }
        Transaction tx = Datastore.beginTransaction();
        for (Object model : models) {
            Datastore.put(tx, model);
        }
        tx.commit();
        return data;
    }
    
    public Documento getData(Key key, Long version) {
        return Datastore.get(d, key, version);
    }

    public byte[] getBytes(Documento uploadedData) {
        if (uploadedData == null) {
            throw new NullPointerException("The uploadedData parameter must not be null.");
        }
        List<DocumentoFragment> fragmentList =
            uploadedData.getFragmentListRef().getModelList();
        byte[][] bytesArray = new byte[fragmentList.size()][0];
        for (int i = 0; i < fragmentList.size(); i++) {
            bytesArray[i] = fragmentList.get(i).getBytes();
        }
        return ByteUtil.join(bytesArray);
    }

    public void delete(Key key) {
        Transaction tx = Datastore.beginTransaction();
        List<Key> keys = new ArrayList<Key>();
        keys.add(key);
        keys.addAll(Datastore.query(f, key).asKeyList());
        Datastore.delete(tx, keys);
        tx.commit();
    }
}
