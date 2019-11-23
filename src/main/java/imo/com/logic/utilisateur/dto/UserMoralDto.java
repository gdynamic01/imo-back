/**
 * 
 */
package imo.com.logic.utilisateur.dto;

/**
 * @author mbalde
 *
 */
public class UserMoralDto extends UserDto {

	/** kbis */
	private String kbis;

	/** raison social */
	private String raisonSocial;

	/** siret */
	private String siret;

	/**
	 * @return the kbis
	 */
	public String getKbis() {
		return kbis;
	}

	/**
	 * @return the raisonSocial
	 */
	public String getRaisonSocial() {
		return raisonSocial;
	}

	/**
	 * @return the siret
	 */
	public String getSiret() {
		return siret;
	}

	/**
	 * @param kbis
	 *             the kbis to set
	 */
	public void setKbis(String kbis) {
		this.kbis = kbis;
	}

	/**
	 * @param raisonSocial
	 *                     the raisonSocial to set
	 */
	public void setRaisonSocial(String raisonSocial) {
		this.raisonSocial = raisonSocial;
	}

	/**
	 * @param siret
	 *              the siret to set
	 */
	public void setSiret(String siret) {
		this.siret = siret;
	}

}
