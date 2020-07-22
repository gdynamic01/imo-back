package imo.com.model.offre;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import imo.com.model.AbstractEntity;
import imo.com.model.adresse.Adresse;
import imo.com.model.enums.TypeOffreEnum;
import imo.com.model.enums.TypeServiceOffre;
import imo.com.model.photo.PhotosEntity;
import imo.com.model.utilisateur.AppUser;

/**
 * @author rahime
 *
 */
@Entity
@Table(name = "imo_offre")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class OffreEntity extends AbstractEntity implements Serializable {

	/** Serial ID */
	private static final long serialVersionUID = -716142150922491844L;

	/** titre de l'offre */
	@Column(name = "titre", nullable = false)
	private String titre;

	/** Description de l'offre */
	@Column(name = "description")
	private String description;

	/** adresse de l'offre */
	@Embedded
	private Adresse adresse;

	/** Prix de l'offre */
	@Column(name = "prix", nullable = false)
	private Double prix = 0.0;
	
	/** Date debut location */
	@Column(name = "date_debut", nullable = false)
	public LocalDate dateDebut = LocalDate.now();
	
	/** Date fin location */
	@Column(name = "date_fin", nullable = false)
	public LocalDate dateFin = LocalDate.now();

	/** user concerné */
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "users_id", nullable = false)
	private AppUser user;

	/** type d'offre */
	@Column(name = "type_offre", nullable = false)
	@Enumerated(EnumType.STRING)
	private TypeOffreEnum typeOffre;

	@Enumerated(EnumType.STRING)
	@Column(name = "type_service_offre")
	private TypeServiceOffre typeServiceOffre;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "offre_id", referencedColumnName = "id", nullable = true)
	private List<PhotosEntity> photosOffres = new ArrayList<>();

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
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
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
	 * @return the user
	 */
	@JsonIgnore
	public AppUser getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	@JsonIgnore
	public void setUser(AppUser user) {
		this.user = user;
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
	 * @return the photosOffre
	 */
	public List<PhotosEntity> getPhotosOffre() {
		return photosOffres;
	}

	/**
	 * @param photosOffre the photosOffre to set
	 */
	public void setPhotosOffre(List<PhotosEntity> photosOffre) {
		this.photosOffres = photosOffre;
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
	 * @return the photosOffres
	 */
	public List<PhotosEntity> getPhotosOffres() {
		return photosOffres;
	}

	/**
	 * @param photosOffres the photosOffres to set
	 */
	public void setPhotosOffres(List<PhotosEntity> photosOffres) {
		this.photosOffres = photosOffres;
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

}
