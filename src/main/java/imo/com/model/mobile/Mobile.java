package imo.com.model.mobile;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import imo.com.model.TypeMobile.TypeMobileEnum;
import imo.com.model.offre.Offre;

/**
 * @author rahime
 *
 */
@Entity
@Table(name = "imo_mobile")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Mobile extends Offre implements Serializable {

	/** Serial ID */
	private static final long serialVersionUID = -716142150922491844L;

	/** type mobile */
	@Column(name = "type_mobile", nullable = false)
	@Enumerated(EnumType.STRING)
	private TypeMobileEnum typeMobile;

	/** moteur*/
	@Column(name = "motoriser", nullable = false)
	private Boolean motoriser;

	/**
	 * @return the typeMobile
	 */
	public TypeMobileEnum getTypeMobile() {
		return typeMobile;
	}

	/**
	 * @param typeMobile the typeMobile to set
	 */
	public void setTypeMobile(TypeMobileEnum typeMobile) {
		this.typeMobile = typeMobile;
	}

	/**
	 * @return the motoriser
	 */
	public Boolean getMotoriser() {
		return motoriser;
	}

	/**
	 * @param motoriser the motoriser to set
	 */
	public void setMotoriser(Boolean motoriser) {
		this.motoriser = motoriser;
	}

}
