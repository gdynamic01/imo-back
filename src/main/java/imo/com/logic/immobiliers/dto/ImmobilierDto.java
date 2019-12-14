package imo.com.logic.immobiliers.dto;

import imo.com.logic.offre.dto.OffreDto;

public class ImmobilierDto extends OffreDto {

	/** surface de l'offre */
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
