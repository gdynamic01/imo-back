package imo.com.model.TypeMobile;

public enum TypeMobileEnum {


    /** Maison */
    VOITURE("Voiture"), //
    /** Terrain */
    VELO("Velo"), //
    /** Appartement */
    MOTO("Moto");

    /** Libelle enum */
    private String libelle;

    private TypeMobileEnum(String libelle) {
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
