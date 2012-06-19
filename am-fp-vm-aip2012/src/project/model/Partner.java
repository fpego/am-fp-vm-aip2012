package project.model;

import java.io.Serializable;

import com.google.appengine.api.datastore.Key;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.InverseModelListRef;
import org.slim3.datastore.Model;

import project.meta.PartnerProgettoMeta;
import project.meta.ProgettoMeta;
import project.meta.RicercatoreMeta;

@Model(schemaVersion = 1)
public class Partner implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;
    
    private String nome;
    
    @Attribute(lob = true)
    private String chiSiamo;
    private String telefono;
    private String indirizzo;
    private String email;
    private String sitoWeb;
    
    @Attribute(persistent=false)
    private InverseModelListRef<PartnerProgetto, Partner> partnerProgettoListRef
    = new InverseModelListRef<PartnerProgetto, Partner>
    (PartnerProgetto.class, PartnerProgettoMeta.get().partnerRef.getName(), this);
    
    @Attribute(persistent=false)
    private InverseModelListRef<Ricercatore, Partner> ricercatoreListRef =
            new InverseModelListRef<Ricercatore, Partner>
    (Ricercatore.class, RicercatoreMeta.get().partnerRef.getName(), this);
    
    @Attribute(persistent=false)
    private InverseModelListRef<Progetto, Partner> leaderOfListRef =
            new InverseModelListRef<Progetto, Partner>
    (Progetto.class, ProgettoMeta.get().leaderRef.getName(), this);

    /**
     * Returns the key.
     *
     * @return the key
     */
    public Key getKey() {
        return key;
    }

    /**
     * Sets the key.
     *
     * @param key
     *            the key
     */
    public void setKey(Key key) {
        this.key = key;
    }

    /**
     * Returns the version.
     *
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * Sets the version.
     *
     * @param version
     *            the version
     */
    public void setVersion(Long version) {
        this.version = version;
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
        Partner other = (Partner) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public InverseModelListRef<PartnerProgetto, Partner> getPartnerProgettoListRef() {
        return partnerProgettoListRef;
    }
    
    public InverseModelListRef<Ricercatore, Partner> getRicercatoreListRef(){
        return ricercatoreListRef;
    }

    public InverseModelListRef<Progetto, Partner> getLeaderOfListRef() {
        return leaderOfListRef;
    }

    /**
     * @return the chiSiamo
     */
    public String getChiSiamo() {
        return chiSiamo;
    }

    /**
     * @param chiSiamo the chiSiamo to set
     */
    public void setChiSiamo(String chiSiamo) {
        this.chiSiamo = chiSiamo;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the indirizzo
     */
    public String getIndirizzo() {
        return indirizzo;
    }

    /**
     * @param indirizzo the indirizzo to set
     */
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the sitoWeb
     */
    public String getSitoWeb() {
        return sitoWeb;
    }

    /**
     * @param sitoWeb the sitoWeb to set
     */
    public void setSitoWeb(String sitoWeb) {
        this.sitoWeb = sitoWeb;
    }


}
