/**
 * 
 */
package imo.com.logic.offre.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import imo.com.logic.utilisateur.dto.AdresseDto;
import imo.com.model.enums.SanitaireEnum;
import imo.com.model.enums.TypeBienImmobilierEnum;
import imo.com.model.enums.TypeBienMobileEnum;
import imo.com.model.enums.TypeMobileMoteurEnum;
import imo.com.model.enums.TypeOffreEnum;
import imo.com.model.enums.TypeServiceOffre;

/**
 * @author mbalde
 *
 */
public class OffreSearchViewDto {
	
	private Long id;
	
	private LocalDate createAt = LocalDate.now();

	private LocalDate updateAt = LocalDate.now();
	
	private TypeBienImmobilierEnum typeDebienImmobilier;
	
	private AdresseDto adresse;
	
	private Double prix = 0.0;
	
	public LocalDate dateDebut = LocalDate.now();
	
	public LocalDate dateFin = LocalDate.now();
	
	private TypeOffreEnum typeOffre;
	
	private TypeServiceOffre typeServiceOffre;
	
	private String titre;
	
	private String description;
	
	private Double surface;

	public Integer nbrePieces;
	
	public Boolean piscine;
	
	public SanitaireEnum sanitaire;
	
	public String autreService;
	
	public Boolean serviceMenage;
	
	public Boolean parking;
	
	public Boolean electricite;
	
	public Boolean eau;
	
	private Boolean motoriser;

	private Integer kilometrage;

	private Integer nbRoue;

	private String model;

	private Integer nbPorte;
	
	private LocalDate dateMiseEnCircualtion;

	private TypeMobileMoteurEnum typeMobileMoteur;

	private String batterie;

	private LocalTime dureeBaterie;
	
	private TypeBienMobileEnum typeBienMobile;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the createAt
	 */
	public LocalDate getCreateAt() {
		return createAt;
	}

	/**
	 * @param createAt the createAt to set
	 */
	public void setCreateAt(LocalDate createAt) {
		this.createAt = createAt;
	}

	/**
	 * @return the updateAt
	 */
	public LocalDate getUpdateAt() {
		return updateAt;
	}

	/**
	 * @param updateAt the updateAt to set
	 */
	public void setUpdateAt(LocalDate updateAt) {
		this.updateAt = updateAt;
	}

	/**
	 * @return the typeDebienImmobilier
	 */
	public TypeBienImmobilierEnum getTypeDebienImmobilier() {
		return typeDebienImmobilier;
	}

	/**
	 * @param typeDebienImmobilier the typeDebienImmobilier to set
	 */
	public void setTypeDebienImmobilier(TypeBienImmobilierEnum typeDebienImmobilier) {
		this.typeDebienImmobilier = typeDebienImmobilier;
	}

	/**
	 * @return the adresse
	 */
	public AdresseDto getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(AdresseDto adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the prix
	 */
	public Double getPrix() {
		return prix;
	}

	/**
	 * @param prix the prix to set
	 */
	public void setPrix(Double prix) {
		this.prix = prix;
	}

	/**
	 * @return the dateDebut
	 */
	public LocalDate getDateDebut() {
		return dateDebut;
	}

	/**
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * @return the dateFin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}

	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * @return the typeOffre
	 */
	public TypeOffreEnum getTypeOffre() {
		return typeOffre;
	}

	/**
	 * @param typeOffre the typeOffre to set
	 */
	public void setTypeOffre(TypeOffreEnum typeOffre) {
		this.typeOffre = typeOffre;
	}

	/**
	 * @return the typeServiceOffre
	 */
	public TypeServiceOffre getTypeServiceOffre() {
		return typeServiceOffre;
	}

	/**
	 * @param typeServiceOffre the typeServiceOffre to set
	 */
	public void setTypeServiceOffre(TypeServiceOffre typeServiceOffre) {
		this.typeServiceOffre = typeServiceOffre;
	}

	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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

	/**
	 * @return the nbrePieces
	 */
	public Integer getNbrePieces() {
		return nbrePieces;
	}

	/**
	 * @param nbrePieces the nbrePieces to set
	 */
	public void setNbrePieces(Integer nbrePieces) {
		this.nbrePieces = nbrePieces;
	}

	/**
	 * @return the piscine
	 */
	public Boolean getPiscine() {
		return piscine;
	}

	/**
	 * @param piscine the piscine to set
	 */
	public void setPiscine(Boolean piscine) {
		this.piscine = piscine;
	}

	/**
	 * @return the sanitaire
	 */
	public SanitaireEnum getSanitaire() {
		return sanitaire;
	}

	/**
	 * @param sanitaire the sanitaire to set
	 */
	public void setSanitaire(SanitaireEnum sanitaire) {
		this.sanitaire = sanitaire;
	}

	/**
	 * @return the autreService
	 */
	public String getAutreService() {
		return autreService;
	}

	/**
	 * @param autreService the autreService to set
	 */
	public void setAutreService(String autreService) {
		this.autreService = autreService;
	}

	/**
	 * @return the serviceMenage
	 */
	public Boolean getServiceMenage() {
		return serviceMenage;
	}

	/**
	 * @param serviceMenage the serviceMenage to set
	 */
	public void setServiceMenage(Boolean serviceMenage) {
		this.serviceMenage = serviceMenage;
	}

	/**
	 * @return the parking
	 */
	public Boolean getParking() {
		return parking;
	}

	/**
	 * @param parking the parking to set
	 */
	public void setParking(Boolean parking) {
		this.parking = parking;
	}

	/**
	 * @return the electricite
	 */
	public Boolean getElectricite() {
		return electricite;
	}

	/**
	 * @param electricite the electricite to set
	 */
	public void setElectricite(Boolean electricite) {
		this.electricite = electricite;
	}

	/**
	 * @return the eau
	 */
	public Boolean getEau() {
		return eau;
	}

	/**
	 * @param eau the eau to set
	 */
	public void setEau(Boolean eau) {
		this.eau = eau;
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

	/**
	 * @return the kilometrage
	 */
	public Integer getKilometrage() {
		return kilometrage;
	}

	/**
	 * @param kilometrage the kilometrage to set
	 */
	public void setKilometrage(Integer kilometrage) {
		this.kilometrage = kilometrage;
	}

	/**
	 * @return the nbRoue
	 */
	public Integer getNbRoue() {
		return nbRoue;
	}

	/**
	 * @param nbRoue the nbRoue to set
	 */
	public void setNbRoue(Integer nbRoue) {
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
	public Integer getNbPorte() {
		return nbPorte;
	}

	/**
	 * @param nbPorte the nbPorte to set
	 */
	public void setNbPorte(Integer nbPorte) {
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

	/**
	 * @return the typeBienMobile
	 */
	public TypeBienMobileEnum getTypeBienMobile() {
		return typeBienMobile;
	}

	/**
	 * @param typeBienMobile the typeBienMobile to set
	 */
	public void setTypeBienMobile(TypeBienMobileEnum typeBienMobile) {
		this.typeBienMobile = typeBienMobile;
	}
}
