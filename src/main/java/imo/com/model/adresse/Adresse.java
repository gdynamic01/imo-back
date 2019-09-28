/**
 * 
 */
package imo.com.model.adresse;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author mbalde
 *
 */
@Embeddable
public class Adresse implements Serializable{

	/** Serial ID */
	private static final long serialVersionUID = -5048414399607886867L;

	/** le code postal */
	@Column(name = "code_postal")
	private String codePostal;

	/** complement adresse */
	@Column(name = "complement_adresse")
	private String complementAdresse;

	/** libelle de la voie */
	@Column(name = "libelle_rue")
	private String libelleRue;

	/** numero de la rue */
	@Column(name = "numero_rue")
	private String numeroRue;

	/** pays */
	@Column(name="pays", nullable = false)
	private String pays;

	/** ville */
	@Column(name="ville", nullable = false)
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
	 * @param libelleRue the libelleVoie to set
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
