package imo.com.model.enums;

public enum SanitaireEnum {

    /** Exterieur*/
    EXTERIEUR("Exterieur"), //
    
    /** Interieur */
    INTERIEUR("Interieur");

    private String libelle;

    private SanitaireEnum(String libelle) {
        this.libelle = libelle;
    }

    /**
     * @return the libelle
     */
    public String getLibelle() {
        return libelle;
    }
}
