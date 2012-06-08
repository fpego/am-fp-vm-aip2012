package project.model;

import java.io.Serializable;

import com.google.appengine.api.datastore.Key;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.InverseModelListRef;
import org.slim3.datastore.Model;

import project.meta.PartnerProgettoMeta;
import project.meta.RicercatoreProgettoMeta;

@Model(schemaVersion = 1)
public class Progetto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;
    
    private String titoloProgetto;
    private String nomePartnerLeader;
    private String tema;
    private int annoInizio;
    private int annoFine;
    private int durata;
    
    @Attribute(lob=true)
    private String presentazione;
    @Attribute(lob=true)
    private String risultati;
    
    @Attribute(persistent=false)
    private InverseModelListRef<PartnerProgetto, Progetto> partnerProgettoListRef =
            new InverseModelListRef<PartnerProgetto, Progetto>
    (PartnerProgetto.class, PartnerProgettoMeta.get().progettoRef.getName(), this);
    
    @Attribute(persistent=false)
    private InverseModelListRef<RicercatoreProgetto, Progetto> ricercatoreProgettoListRef =
        new InverseModelListRef<RicercatoreProgetto, Progetto>
    (RicercatoreProgetto.class, RicercatoreProgettoMeta.get().progettoRef.getName(), this);

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
        Progetto other = (Progetto) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }

    public String getTitoloProgetto() {
        return titoloProgetto;
    }

    public void setTitoloProgetto(String titoloProgetto) {
        this.titoloProgetto = titoloProgetto;
    }

    public String getNomePartnerLeader() {
        return nomePartnerLeader;
    }

    public void setNomePartnerLeader(String nomePartnerLeader) {
        this.nomePartnerLeader = nomePartnerLeader;
    }
    
    public InverseModelListRef<PartnerProgetto, Progetto> getPartnerProgettoListRef(){
        return partnerProgettoListRef;
    }

    public InverseModelListRef<RicercatoreProgetto, Progetto> getRicercatoreProgettoListRef() {
        return ricercatoreProgettoListRef;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public int getAnnoInizio() {
        return annoInizio;
    }

    public void setAnnoInizio(int annoInizio) {
        this.annoInizio = annoInizio;
    }

    public int getAnnoFine() {
        return annoFine;
    }

    public void setAnnoFine(int annoFine) {
        this.annoFine = annoFine;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public String getRisultati() {
        return risultati;
    }

    public void setRisultati(String risultati) {
        this.risultati = risultati;
    }

    public String getPresentazione() {
        return presentazione;
    }

    public void setPresentazione(String presentazione) {
        this.presentazione = presentazione;
    }

}
