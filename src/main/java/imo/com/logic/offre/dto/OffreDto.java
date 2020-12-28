package imo.com.logic.offre.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
import imo.com.logic.photos.dto.PhotosDto;
import imo.com.logic.utilisateur.dto.AdresseDto;
import imo.com.model.enums.TypeOffreEnum;
import imo.com.model.enums.TypeServiceOffre;

public abstract class OffreDto {

	/** titre de l'offre */
	private String titre;

	/** Description de l'offre */
	private String description;

	/** adresse de l'offre */
	private AdresseDto adresse;

	/** Prix de l'offre */
	private Double prix = 0.0;

	/** date publication */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = ISO.DATE_TIME)
	private LocalDateTime createAt = LocalDateTime.now();

	/** date mise a jour publication */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = ISO.DATE_TIME)
	private LocalDateTime updateAt = LocalDateTime.now();;

	/** type d'offre */
	private TypeOffreEnum typeOffre;

	/** type offre */
	private TypeServiceOffre typeServiceOffre;

	/** Liste photos */
	private List<PhotosDto> photosOffres = new ArrayList<>();

	/** type annonce [particulier ou professionnel] */
	private String typeAnnonce;

	/** Symbole monetaire */
	private String SymboleMonetaire;
	
	/** date debut */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = ISO.DATE_TIME)
	protected LocalDateTime dateDebut = LocalDateTime.now();
	
	/** date de fin */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = ISO.DATE_TIME)
	protected LocalDateTime dateFin = LocalDateTime.now();
	
	/** nombre de jour ecoulé apres la publication de l'annonce */
	private long nombreDeJour;
	
	/** offre immobilier */
	private boolean isImmobilier = false;
	
	/** offre mobile */
	private boolean isMobile = false;
	
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
	 * @return the createAt
	 */
	public LocalDateTime getCreateAt() {
		return createAt;
	}

	/**
	 * @param createAt the createAt to set
	 */
	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	/**
	 * @return the updateAt
	 */
	public LocalDateTime getUpdateAt() {
		return updateAt;
	}

	/**
	 * @param updateAt the updateAt to set
	 */
	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}

	/**
	 * @return the photosOffres
	 */
	public List<PhotosDto> getPhotosOffres() {
		return photosOffres;
	}

	/**
	 * @param photosOffres the photosOffres to set
	 */
	public void setPhotosOffres(List<PhotosDto> photosOffres) {
		this.photosOffres = photosOffres;
	}

	/**
	 * @return the typeAnnonce
	 */
	public String getTypeAnnonce() {
		return typeAnnonce;
	}

	/**
	 * @param typeAnnonce the typeAnnonce to set
	 */
	public void setTypeAnnonce(String typeAnnonce) {
		this.typeAnnonce = typeAnnonce;
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
	 * @return the symboleMonetaire
	 */
	public String getSymboleMonetaire() {
		return SymboleMonetaire;
	}

	/**
	 * @param symboleMonetaire the symboleMonetaire to set
	 */
	public void setSymboleMonetaire(String symboleMonetaire) {
		SymboleMonetaire = symboleMonetaire;
	}

	/**
	 * @return the dateDebut
	 */
	public LocalDateTime getDateDebut() {
		return dateDebut;
	}

	/**
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(LocalDateTime dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * @return the dateFin
	 */
	public LocalDateTime getDateFin() {
		return dateFin;
	}

	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(LocalDateTime dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * @return the nombreDeJour
	 */
	public long getNombreDeJour() {
		return nombreDeJour;
	}

	/**
	 * @param nombreDeJour the nombreDeJour to set
	 */
	public void setNombreDeJour(long nombreDeJour) {
		this.nombreDeJour = nombreDeJour;
	}

	/**
	 * @return the isImmobilier
	 */
	public boolean isImmobilier() {
		return isImmobilier;
	}

	/**
	 * @param isImmobilier the isImmobilier to set
	 */
	public void setImmobilier(boolean isImmobilier) {
		this.isImmobilier = isImmobilier;
	}

	/**
	 * @return the isMobile
	 */
	public boolean isMobile() {
		return isMobile;
	}

	/**
	 * @param isMobile the isMobile to set
	 */
	public void setMobile(boolean isMobile) {
		this.isMobile = isMobile;
	}
}
