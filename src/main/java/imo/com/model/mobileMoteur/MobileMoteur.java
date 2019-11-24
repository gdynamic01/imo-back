package imo.com.model.mobileMoteur;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import imo.com.model.TypeMobileMoteurEnum;
import imo.com.model.mobile.Mobile;

/**
 * @author rahime
 *
 */

@Entity
@Table(name = "imo_mobile_moteur")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class MobileMoteur extends Mobile implements Serializable {

	/** Serial ID */
	private static final long serialVersionUID = -716142150922491844L;

	/** Kilometrage */
	@Column(name = "kilometrage", nullable = false)
	private Double kilometrage;

	/** Nombre de roue */
	@Column(name = "nombre_roue", nullable = false)
	private Double nbRoue;

	/** model */
	@Column(name = "model", nullable = false)
	private String model;

	/** date publication de l'offre */
	@Column(name = "nombre_porte", nullable = false)
	private Double nbPorte;

	/** date mise en circulation du vehicule */
	@Column(name = "date_mise_en_circulation", nullable = false)
	private Date dateMiseCircualtion;

	/** type_moteur */
	@Column(name = "type_moteur", nullable = false)
	@Enumerated(EnumType.STRING)
	private TypeMobileMoteurEnum typeMobileMoteur;

	/**
	 * @return the kilometrage
	 */
	public Double getKilometrage() {
		return kilometrage;
	}

	/**
	 * @param kilometrage the kilometrage to set
	 */
	public void setKilometrage(Double kilometrage) {
		this.kilometrage = kilometrage;
	}

	/**
	 * @return the nbRoue
	 */
	public Double getNbRoue() {
		return nbRoue;
	}

	/**
	 * @param nbRoue the nbRoue to set
	 */
	public void setNbRoue(Double nbRoue) {
		this.nbRoue = nbRoue;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the nbPorte
	 */
	public Double getNbPorte() {
		return nbPorte;
	}

	/**
	 * @param nbPorte the nbPorte to set
	 */
	public void setNbPorte(Double nbPorte) {
		this.nbPorte = nbPorte;
	}

	/**
	 * @return the dateMiseCircualtion
	 */
	public Date getDateMiseCircualtion() {
		return dateMiseCircualtion;
	}

	/**
	 * @param dateMiseCircualtion the dateMiseCircualtion to set
	 */
	public void setDateMiseCircualtion(Date dateMiseCircualtion) {
		this.dateMiseCircualtion = dateMiseCircualtion;
	}

	/**
	 * @return the typeMobileMoteur
	 */
	public TypeMobileMoteurEnum getTypeMobileMoteur() {
		return typeMobileMoteur;
	}

	/**
	 * @param typeMobileMoteur the typeMobileMoteur to set
	 */
	public void setTypeMobileMoteur(TypeMobileMoteurEnum typeMobileMoteur) {
		this.typeMobileMoteur = typeMobileMoteur;
	}

	/**
	 * @param typeMobile the typeMobile to set
	 */
	public void setTypeMobile(TypeMobileMoteurEnum typeMobile) {
		this.typeMobileMoteur = typeMobile;
	}

}
