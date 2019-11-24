package imo.com.model.Immobilier;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import imo.com.model.offre.Offre;
import imo.com.model.typeImmobilier.TypeImobilierEnum;

@Entity
@Table(name = "imo_immobilier")
@Inheritance(strategy = InheritanceType.JOINED)
public class Immobilier extends Offre implements Serializable {

	/** Serial ID */
	private static final long serialVersionUID = -716142150922491844L;

	/** surface */
	/** surface de l'offre */
	@Column(name = "surface", nullable = false)
	private Double surface;

	/** type immobilier */
	@Column(name = "type_immobiler", nullable = false)
	@Enumerated(EnumType.STRING)
	private TypeImobilierEnum typeImobilier;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Double getSurface() {
		return surface;
	}

	public void setSurface(Double surface) {
		this.surface = surface;
	}

	public TypeImobilierEnum getTypeImobilier() {
		return typeImobilier;
	}

	public void setTypeImobilier(TypeImobilierEnum typeImobilier) {
		this.typeImobilier = typeImobilier;
	}
}