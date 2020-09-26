package imo.com.model.immobilier;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Min;

import imo.com.model.enums.SanitaireEnum;
import imo.com.model.enums.TypeBienImmobilierEnum;
import imo.com.model.offre.OffreEntity;

@Entity
@Table(name = "imo_immobilier")
@PrimaryKeyJoinColumn(name = "id")
public class ImmobilierEntity extends OffreEntity implements Serializable {

	/** Serial ID */
	private static final long serialVersionUID = -716142150922491844L;

	/** surface de l'offre */
	@Column(name = "surface", nullable = false)
	@Min(value = 9)
	private Double surface;

	/** nombre de pièces */
	@Column(name = "nombre_pieces", nullable = false)
	public Integer nbrePieces;
	
	/** piscine */
	@Column(name = "piscine")
	public Boolean piscine;

	@Enumerated(EnumType.STRING)
	@Column(name = "type_de_Bien", nullable=false)
	private TypeBienImmobilierEnum typeDeBien;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	public SanitaireEnum sanitaire;
	
	@Column(name = "autre_service")
	public String autreService;
	
	@Column(name = "service_menage")
	public Boolean serviceMenage;
	
	@Column(name = "zone_geographique")
	public String zoneGeographique;
	
	@Column(name = "parking")
	public Boolean parking;
	
	public Boolean electricite;
	@Column(name = "eau", nullable = false)
	public Boolean eau;

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

	public void setPiscine(Boolean piscine) {
		this.piscine = piscine;
	}

	public void setParking(Boolean parking) {
		this.parking = parking;
	}

	public Boolean isPiscine() {
		return piscine;
	}

	public SanitaireEnum getSanitaire() {
		return sanitaire;
	}

	public void setSanitaire(SanitaireEnum sanitaire) {
		this.sanitaire = sanitaire;
	}

	public Boolean getParking() {
		return parking;
	}

	/**
	 * @return the surface
	 */
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
}