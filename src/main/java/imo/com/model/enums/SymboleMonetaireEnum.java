/**
 * 
 */
package imo.com.model.enums;

/**
 * @author balde
 *
 */
public enum SymboleMonetaireEnum {

	GNF("Franc Guinéen"), //
	EUR("Euro"), //
	DOLLAR_US("Dollar us"), //
	FCA("Franc CFA");

	private String libelle;

	private SymboleMonetaireEnum(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

}
