package imo.com.model.immobilier;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Min;

import imo.com.model.enums.SanitaireEnum;
import imo.com.model.enums.TypeBienImmobilierEnum;
import imo.com.model.enums.TypeServiceOffre;
import imo.com.model.offre.OffreEntity;

@Entity
@Table(name = "imo_immobilier")
@PrimaryKeyJoinColumn(name = "id")
public class ImmobilierEntity extends OffreEntity implements Serializable {

	/** Serial ID */
	private static final long serialVersionUID = -716142150922491844L;

	/** surface */
	/** surface de l'offre */
	@Column(name = "surface", nullable = false)
	@Min(value = 9)
	private Double surface;

	// les champs à completer
	@Column(name = "date_debut", nullable = false)
	public Date date_debut;
	@Column(name = "date_fin", nullable = false)
	public Date date_fin;
	@Column(name = "nombre_pieces", nullable = false)
	public int nbre_pieces;
	@Column(name = "piscine", nullable =true)
	public boolean piscine;

	@Enumerated(EnumType.STRING)
	@Column(name = "type_de_Bien")
	private TypeBienImmobilierEnum type_de_Bien;

	//@Column(name = "type_de_Bien", nullable = false)
	//public String type_de_bien;
	@Enumerated(EnumType.STRING)
	public SanitaireEnum sanitaire;
	@Column(name = "autre_service", nullable = true)
	public String autre_service;
	@Column(name = "service_menage", nullable = true)
	public Boolean service_menage;
	@Column(name = "zone_geographique", nullable = false)
	public String zone_geographique;
	@Column(name = "parking", nullable = false)
	public Boolean parking;
	@Column(name = "electricite", nullable = false)
	public Boolean electricite;
	@Column(name = "eau", nullable = false)
	public Boolean eau;

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

	public void setNbre_pieces(int nbre_pices) {
		this.nbre_pieces = nbre_pices;
	}

	public void setPiscine(boolean piscine) {
		this.piscine = piscine;
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

	public TypeBienImmobilierEnum getType_de_Bien() {
		return type_de_Bien;
	}

	public void setType_de_Bien(TypeBienImmobilierEnum type_de_Bien) {
		this.type_de_Bien = type_de_Bien;
	}

	public SanitaireEnum getSanitaire() {
		return sanitaire;
	}

	public void setSanitaire(SanitaireEnum sanitaire) {
		this.sanitaire = sanitaire;
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
}