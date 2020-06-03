package imo.com.logic.offre.dto;

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
	public int nbre_pices;
	public boolean piscine;

	public String type_location;

	public String sanitaire;

	public String autre_service;
	public String service_menage;

	public String zone_geographique;

	public Boolean parking;

	public String getService_menage() {
		return service_menage;
	}
	public void setService_menage(String service_menage) {
		this.service_menage = service_menage;
	}
	public void setEau(Boolean eau) {
		this.eau = eau;
	}

	public void setElectricite(Boolean electricite) {
		this.electricite = electricite;
	}

	@Column(name = "eau", nullable = false)
	public Boolean eau;

	public Boolean getEau() {
		return eau;
	}

	public Boolean getElectricite() {
		return electricite;
	}

	@Column(name = "electricite", nullable = false)
	public Boolean electricite;

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public void setNbre_pices(int nbre_pices) {
		this.nbre_pices = nbre_pices;
	}

	public void setPiscine(boolean piscine) {
		this.piscine = piscine;
	}

	public void setType_location(String type_location) {
		this.type_location = type_location;
	}

	public void setSanitaire(String sanitaire) {
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

	public int getNbre_pices() {
		return nbre_pices;
	}

	public boolean isPiscine() {
		return piscine;
	}

	public String getType_location() {
		return type_location;
	}

	public String getSanitaire() {
		return sanitaire;
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

	/**
	 * @param surface the surface to set
	 */
	public void setSurface(Double surface) {
		this.surface = surface;
	}

}
