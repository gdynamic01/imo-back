package imo.com.model.moteurElectrique;

import java.io.Serializable;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import imo.com.model.mobileMoteur.MobileMoteur;

@Entity
@Table(name = "imo_mobile_moteur_electrique")
@Inheritance(strategy = InheritanceType.JOINED)
public class MobileMoteurElectrique extends MobileMoteur implements Serializable {

	// ** Serial ID */
	private static final long serialVersionUID = -716142150922491844L;

	/** batterie*/
	@Column(name = "batterie", nullable = false)
	private String batterie;

	/** duree*/
	@Column(name = "duree_batterie", nullable = false)
	private LocalTime dureeBaterie;

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
	 * @return the dureebaterie
	 */
	public LocalTime getDureebaterie() {
		return dureeBaterie;
	}

	/**
	 * @param dureebaterie the dureebaterie to set
	 */
	public void setDureebaterie(LocalTime dureebaterie) {
		this.dureeBaterie = dureebaterie;
	}

}
