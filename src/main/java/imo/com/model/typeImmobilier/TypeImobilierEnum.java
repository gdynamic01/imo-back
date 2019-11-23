package imo.com.model.typeImmobilier;

public enum TypeImobilierEnum {

    /** Maison */
    APPARTEMENT("Appartement"), //
    /** Terrain */
    MAISON("Maison"), //
    /** Appartement */
    TERRAIN("Terrain");

    /** Libelle enum */
    private String libelle;

    private TypeImobilierEnum(String libelle) {
        this.libelle = libelle;
    }
    /**
     * retourne le libelle
     * @return libelle
     */
    public String getLibelle() {
        return this.libelle;
    }
}
