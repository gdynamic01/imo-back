package imo.com.model.enums;

public enum SanitaireEnum {

    /** Exterieur*/
    EXTERIEUR("Exterieur"), //
    
    /** Interieur */
    INTERIEUR("Interieur");

    @SuppressWarnings("unused")
	private String libelle;

    private SanitaireEnum(String libelle) {
        this.libelle = libelle;
    }
}
