package imo.com.model.immobilier;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Min;

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