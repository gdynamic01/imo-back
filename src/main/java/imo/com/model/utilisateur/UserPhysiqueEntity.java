/**
 * 
 */
package imo.com.model.utilisateur;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * L'entity client
 * 
 * @author mbalde
 *
 */
@Entity
@Table(name = "user_physique")
@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue("Client")
public class UserPhysiqueEntity extends User implements Serializable {

	/** Serial ID */
	private static final long serialVersionUID = -5056368843553954261L;

	/** Sexe **/
	@Column(name = "sexe", nullable = false)
	@Enumerated(EnumType.STRING)
	private SexeEnum sexe;

	/**
	 * @return the sexe
	 */
	public SexeEnum getSexe() {
		return sexe;
	}

	/**
	 * @param sexe
	 *             the sexe to set
	 */
	public void setSexe(SexeEnum sexe) {
		this.sexe = sexe;
	}
}
