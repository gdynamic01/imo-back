package imo.com.logic.offre.dto;

import imo.com.model.enums.SanitaireEnum;
import imo.com.model.enums.TypeBienImmobilierEnum;

import java.time.LocalDate;

public class ImmobilierDto extends OffreDto {

	/** surface de l'offre */
	private Double surface;
	public int nbrePieces;
	public Boolean piscine;
	private TypeBienImmobilierEnum typeDeBien;
	public SanitaireEnum sanitaire;
	public Boolean eau;
	public String autreService;
	public Boolean serviceMenage;

	public String zoneGeographique;

	public Boolean parking;
	public Boolean electricite;

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

	public SanitaireEnum getSanitaire() {
		return sanitaire;
	}

	public void setSanitaire(SanitaireEnum sanitaire) {
		this.sanitaire = sanitaire;
	}

	public void setParking(Boolean parking) {
		this.parking = parking;
	}

	public Boolean isPiscine() {
		return piscine;
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

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public int getNbrePieces() {
		return nbrePieces;
	}

	public void setNbrePieces(int nbrePieces) {
		this.nbrePieces = nbrePieces;
	}

	public void setPiscine(Boolean piscine) {
		this.piscine = piscine;
	}

	public TypeBienImmobilierEnum getTypeDeBien() {
		return typeDeBien;
	}

	public void setTypeDeBien(TypeBienImmobilierEnum typeDeBien) {
		this.typeDeBien = typeDeBien;
	}

	public String getAutreService() {
		return autreService;
	}

	public void setAutreService(String autreService) {
		this.autreService = autreService;
	}

	public Boolean getServiceMenage() {
		return serviceMenage;
	}

	public void setServiceMenage(Boolean serviceMenage) {
		this.serviceMenage = serviceMenage;
	}

	public String getZoneGeographique() {
		return zoneGeographique;
	}

	public void setZoneGeographique(String zoneGeographique) {
		this.zoneGeographique = zoneGeographique;
	}

	public Boolean getPiscine() {
		return piscine;
	}

}
