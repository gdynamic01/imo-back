package imo.com.model.mobile;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import imo.com.model.enums.TypeMobileMoteurEnum;
import imo.com.model.offre.OffreEntity;

/**
 * @author rahime
 *
 */
@Entity
@Table(name = "imo_mobile")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "id")
public class MobileEntity extends OffreEntity implements Serializable {

	/** Serial ID */
	private static final long serialVersionUID = -716142150922491844L;

	/** moteur*/
	@Column(name = "motoriser")
	private Boolean motoriser;

	/** Kilometrage */
	@Column(name = "kilometrage")
	private int kilometrage;

	/** Nombre de roue */
	@Column(name = "nombre_roue")
	private int nbRoue = 0;

	/** model */
	@Column(name = "model")
	private String model;

	/** nombre de porte */
	@Column(name = "nombre_porte")
	private int nbPorte = 0;

	/** date mise en circulation du mobile */
	@Column(name = "date_mise_en_circulation", nullable = false)
	private LocalDate dateMiseEnCircualtion;

	/** type_moteur */
	@Column(name = "type_moteur", nullable = false)
	@Enumerated(EnumType.STRING)
	private TypeMobileMoteurEnum typeMobileMoteur;

	/** batterie*/
	@Column(name = "batterie")
	private String batterie;

	/** duree*/
	@Column(name = "duree_batterie")
	private LocalTime dureeBaterie;

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

	/**
	 * @return the kilometrage
	 */
	public int getKilometrage() {
		return kilometrage;
	}

	/**
	 * @param kilometrage the kilometrage to set
	 */
	public void setKilometrage(int kilometrage) {
		this.kilometrage = kilometrage;
	}

	/**
	 * @return the nbRoue
	 */
	public int getNbRoue() {
		return nbRoue;
	}

	/**
	 * @param nbRoue the nbRoue to set
	 */
	public void setNbRoue(int nbRoue) {
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
	public int getNbPorte() {
		return nbPorte;
	}

	/**
	 * @param nbPorte the nbPorte to set
	 */
	public void setNbPorte(int nbPorte) {
		this.nbPorte = nbPorte;
	}

	/**
	 * @return the dateMiseEnCircualtion
	 */
	public LocalDate getDateMiseEnCircualtion() {
		return dateMiseEnCircualtion;
	}

	/**
	 * @param dateMiseEnCircualtion the dateMiseEnCircualtion to set
	 */
	public void setDateMiseEnCircualtion(LocalDate dateMiseEnCircualtion) {
		this.dateMiseEnCircualtion = dateMiseEnCircualtion;
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
	 * @return the batterie
	 */
	public String getBatterie() {
		return batterie;
	}

	/**
	 * @param batterie the batterie to set
	 */
	public void setBatterie(String batterie) {
		this.batterie = batterie;
	}

	/**
	 * @return the dureeBaterie
	 */
	public LocalTime getDureeBaterie() {
		return dureeBaterie;
	}

	/**
	 * @param dureeBaterie the dureeBaterie to set
	 */
	public void setDureeBaterie(LocalTime dureeBaterie) {
		this.dureeBaterie = dureeBaterie;
	}
}
