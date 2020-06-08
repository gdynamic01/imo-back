package imo.com.logic.offre.dto;

import imo.com.model.enums.SanitaireEnum;
import imo.com.model.enums.TypeBienImmobilierEnum;

import javax.persistence.Column;
import java.util.Date;

public class ImmobilierDto extends OffreDto {

	/** surface de l'offre */
	private Double surface;

	/**
	 * @return the surface
	 */

	// les champs à completer
	public Date date_debut;
	public Date date_fin;
	public int nbre_pieces;
	public boolean piscine;

	//public String type_location;
	private TypeBienImmobilierEnum type_de_Bien;
	public SanitaireEnum sanitaire;
	public Boolean eau;
	public String autre_service;
	public Boolean service_menage;

	public String zone_geographique;

	public Boolean parking;
	public Boolean electricite;

	public Boolean getService_menage() {
		return service_menage;
	}

	public void setService_menage(Boolean service_menage) {
		this.service_menage = service_menage;
	}

	public void setEau(Boolean eau) {
		this.eau = eau;
	}

	public void setElectricite(Boolean electricite) {
		this.electricite = electricite;
	}
	public Boolean getEau() {
		return eau;
	}
	public Boolean getElectricite() {
		return electricite;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
	public void setNbre_pices(int nbre_pices) {
		this.nbre_pieces = nbre_pices;
	}

	public void setPiscine(boolean piscine) {
		this.piscine = piscine;
	}

	public SanitaireEnum getSanitaire() {
		return sanitaire;
	}

	public void setSanitaire(SanitaireEnum sanitaire) {
		this.sanitaire = sanitaire;
	}

	public void setAutre_service(String autre_service) {
		this.autre_service = autre_service;
	}

	public void setZone_geographique(String zone_geographique) {
		this.zone_geographique = zone_geographique;
	}

	public void setParking(Boolean parking) {
		this.parking = parking;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public int getNbre_pieces() {
		return nbre_pieces;
	}

	public boolean isPiscine() {
		return piscine;
	}
	
	public String getAutre_service() {
		return autre_service;
	}

	public String getZone_geographique() {
		return zone_geographique;
	}

	public Boolean getParking() {
		return parking;
	}

	public Double getSurface() {
		return surface;
	}

	public TypeBienImmobilierEnum getType_de_Bien() {
		return type_de_Bien;
	}

	public void setNbre_pieces(int nbre_pieces) {
		this.nbre_pieces = nbre_pieces;
	}

	public void setType_de_Bien(TypeBienImmobilierEnum type_de_Bien) {
		this.type_de_Bien = type_de_Bien;
	}

	/**
	 * @param surface the surface to set
	 */
	public void setSurface(Double surface) {
		this.surface = surface;
	}

}
