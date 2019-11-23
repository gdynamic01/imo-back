package imo.com.logic.Immobilier.dto;

import imo.com.logic.offre.dto.OffreDto;
import imo.com.model.typeImmobilier.TypeImobilierEnum;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class ImmobilierDto  extends OffreDto {

    /** surface de l'offre */
    private Double surface;

    /** type immobilier */
    private TypeImobilierEnum typeImobilier;

    public Double getSurface() {
        return surface;
    }

    public TypeImobilierEnum getTypeImobilier() {
        return typeImobilier;
    }

    public void setSurface(Double surface) {
        this.surface = surface;
    }

    public void setTypeImobilier(TypeImobilierEnum typeImobilier) {
        this.typeImobilier = typeImobilier;
    }
}
