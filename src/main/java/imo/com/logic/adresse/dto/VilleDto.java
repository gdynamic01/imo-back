/**
 * 
 */
package imo.com.logic.adresse.dto;

/**
 * @author mbalde
 *
 */
public class VilleDto {
	
	private String nomVille;
	
	private int codePostal;
	
	/**
	 * @return the nomVille
	 */
	public String getNomVille() {
		return nomVille;
	}
	/**
	 * @param nomVille the nomVille to set
	 */
	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}
	/**
	 * @return the codePostal
	 */
	public int getCodePostal() {
		return codePostal;
	}
	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
}
