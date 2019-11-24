package imo.com.model.offre;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import imo.com.model.AbstractEntity;
import imo.com.model.adresse.Adresse;
import imo.com.model.utilisateur.AppUser;

/**
 * @author rahime
 *
 */
@Entity
@Table(name = "imo_offre")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Offre extends AbstractEntity implements Serializable {

	/** Serial ID */
	private static final long serialVersionUID = -716142150922491844L;

	/** titre de l'offre */
	@Column(name = "titre", nullable = false)
	private String titre;

	/** Description de l'offre */
	@Column(name = "description", nullable = false)
	private String description;

	/** date publication de l'offre */
	@Column(name = "date_publication", nullable = false)
	private Date datePublication;

	/** date mise à jour de l'offre */
	@Column(name = "date_mise_a_jour", nullable = false)
	private Date dateMiseAjour;

	/** adresse de l'offre */
	@Embedded
	private Adresse adresse;

	/** Prix de l'offre */
	@Column(name = "prix", nullable = false)
	private Double prix;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "users_id", nullable = false)
	@JsonIgnore
	private AppUser user;

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
	 * @return the datePublication
	 */
	public Date getDatePublication() {
		return datePublication;
	}

	/**
	 * @param datePublication the datePublication to set
	 */
	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}

	/**
	 * @return the dateMiseAjour
	 */
	public Date getDateMiseAjour() {
		return dateMiseAjour;
	}

	/**
	 * @param dateMiseAjour the dateMiseAjour to set
	 */
	public void setDateMiseAjour(Date dateMiseAjour) {
		this.dateMiseAjour = dateMiseAjour;
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

}
