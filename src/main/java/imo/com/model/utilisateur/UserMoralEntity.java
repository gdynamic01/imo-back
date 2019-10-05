/**
 * 
 */
package imo.com.model.utilisateur;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Entity entreprise ou promotteur
 * 
 * @author mbalde
 *
 */
@Entity
@Table(name = "user_moral")
@PrimaryKeyJoinColumn(name = "id")
public class UserMoralEntity extends User implements Serializable {

	/** Serial ID */
	private static final long serialVersionUID = -2506000331138240803L;

	/** carte d'identité entreprise */
	@Column(name = "kbis")
	private String kbis;

	/** nom de l'entreprise */
	@Column(name = "raison_social")
	private String raisonSocial;

	/** le numero d'identification */
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
