package imo.com.logic.mobiles.dto;

import java.time.LocalTime;
import java.util.Date;

import imo.com.logic.offre.dto.OffreDto;
import imo.com.model.enums.TypeMobileMoteurEnum;

public class MobileDto extends OffreDto {

	/** moteur*/
	private Boolean motoriser;

	/** Kilometrage */
	private Double kilometrage;

	/** Nombre de roue */
	private Double nbRoue;

	/** model */
	private String model;

	/** date publication de l'offre */
	private Double nbPorte;

	/** date mise en circulation du vehicule */
	private Date dateMiseEnCircualtion;

	/** type_moteur */
	private TypeMobileMoteurEnum typeMobileMoteur;

	/** batterie*/
	private String batterie;

	/** duree*/
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
	 * @return the dateMiseEnCircualtion
	 */
	public Date getDateMiseEnCircualtion() {
		return dateMiseEnCircualtion;
	}

	/**
	 * @param dateMiseEnCircualtion the dateMiseEnCircualtion to set
	 */
	public void setDateMiseEnCircualtion(Date dateMiseEnCircualtion) {
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
