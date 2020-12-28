package imo.com.logic.offre.dto;

import imo.com.model.enums.SanitaireEnum;
import imo.com.model.enums.TypeBienImmobilierEnum;

public class ImmobilierDto extends OffreDto {

	/** surface de l'offre */
	private Double surface;
	
	/** Nombre de piece */
	public Integer nbrePieces;
	
	/** piscine */
	public Boolean piscine;
	
	/** type de bien */
	private TypeBienImmobilierEnum typeDeBien;
	
	/** sanitaire */
	public SanitaireEnum sanitaire;
	
	/** eau */
	public Boolean eau;
	
	/** autreService */
	public String autreService;
	
	/** serviceMenage */
	public Boolean serviceMenage;
	
	/** zoneGeographique */
	public String zoneGeographique;
	
	/** parking */
	public Boolean parking;
	
	/** electricite */
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

	public Integer getNbrePieces() {
		return nbrePieces;
	}

	public void setNbrePieces(Integer nbrePieces) {
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
