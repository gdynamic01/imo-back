package imo.com.model.enums;

public enum TypeBienImmobilierEnum {

    /** Appartement */
    APPARTEMENT("Appartement"), //

    /** Maison */
    MAISON("Maison"), //

    /** Villa */
    VILLA("Villa"), //

    /** Moto */
    STUDIO("Studio"),

    /** Immeuble */
    IMMEUBLE("Immeuble"), //

    /** Bureau */
    BUREAU("Bureau"), //

    /** Salle evenement */
    SALLE("Salle"),

    /** Salle evenement */
    TERRAIN("Terrain");
	
    /** Libelle enum */
    private String libelle;

    private TypeBienImmobilierEnum(String libelle) {
        this.libelle = libelle;
    }

	public String getLibelle() {
		return libelle;
	}

}
