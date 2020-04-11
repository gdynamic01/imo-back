package imo.com.logic.offre.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import imo.com.logic.photos.dto.PhotosDto;
import imo.com.logic.utilisateur.dto.AdresseDto;
import imo.com.model.enums.SymboleMonetaireEnum;
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
	private LocalDate createAt = LocalDate.now();

	/** date mise a jour publication */
	private LocalDate updateAt = LocalDate.now();

	/** type d'offre */
	private TypeOffreEnum typeOffre;

	/** type offre */
	private TypeServiceOffre typeServiceOffre;

	/** Liste photos */
	private List<PhotosDto> photosOffres = new ArrayList<>();

	/** type annonce [particulier ou professionnel] */
	private String typeAnnonce;

	/** Symbole monetaire */
	private SymboleMonetaireEnum SymboleMonetaire;

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
	public SymboleMonetaireEnum getSymboleMonetaire() {
		return SymboleMonetaire;
	}

	/**
	 * @param symboleMonetaire the symboleMonetaire to set
	 */
	public void setSymboleMonetaire(SymboleMonetaireEnum symboleMonetaire) {
		SymboleMonetaire = symboleMonetaire;
	}
}
