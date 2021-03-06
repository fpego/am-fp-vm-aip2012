package project.model;

import java.io.Serializable;

import com.google.appengine.api.datastore.Key;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.InverseModelListRef;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;
import org.slim3.datastore.Sort;

@Model(schemaVersion = 1)
public class Documento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;
    
    /**
     * Relazione con il progetto
     */
    private ModelRef<Progetto> progettoRef = 
            new ModelRef<Progetto>(Progetto.class);
    
    private String fileName;

    private int length;

    /**
     * Relazione con i frammenti del documento
     */
    @Attribute(persistent = false)
    private org.slim3.datastore.InverseModelListRef<DocumentoFragment, Documento> fragmentListRef =
        new org.slim3.datastore.InverseModelListRef<DocumentoFragment, Documento>(
                DocumentoFragment.class,
            "uploadDataRef",
            this,
            new Sort("index"));

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
    
    public InverseModelListRef<DocumentoFragment, Documento> getFragmentListRef() {
        return fragmentListRef;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Documento other = (Documento) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }

    public ModelRef<Progetto> getProgettoRef() {
        return progettoRef;
    }

}
