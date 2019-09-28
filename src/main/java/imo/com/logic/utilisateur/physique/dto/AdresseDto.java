/**
 * 
 */
package imo.com.logic.utilisateur.physique.dto;

/**
 * @author mbalde
 *
 */
public class AdresseDto {

	/** le code postal */
	private String codePostal;

	/** complement adresse */
	private String complementAdresse;

	/** libelle de la voie */
	private String libelleRue;

	/** numero de la rue */
	private String numeroRue;

	/** pays */
	private String pays;

	/** ville */
	private String ville;

	/**
	 * @return the codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * @return the complementAdresse
	 */
	public String getComplementAdresse() {
		return complementAdresse;
	}

	/**
	 * @return the libelleRue
	 */
	public String getLibelleRue() {
		return libelleRue;
	}

	/**
	 * @return the numeroRue
	 */
	public String getNumeroRue() {
		return numeroRue;
	}

	/**
	 * @return the pays
	 */
	public String getPays() {
		return pays;
	}

	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * @param complementAdresse the complementAdresse to set
	 */
	public void setComplementAdresse(String complementAdresse) {
		this.complementAdresse = complementAdresse;
	}

	/**
	 * @param libelleRue the libelleRue to set
	 */
	public void setLibelleRue(String libelleRue) {
		this.libelleRue = libelleRue;
	}

	/**
	 * @param numeroRue the numeroRue to set
	 */
	public void setNumeroRue(String numeroRue) {
		this.numeroRue = numeroRue;
	}

	/**
	 * @param pays the pays to set
	 */
	public void setPays(String pays) {
		this.pays = pays;
	}

	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
}
