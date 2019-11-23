package imo.com.logic.Mobile.dtd;

import imo.com.logic.offre.dto.OffreDto;
import imo.com.model.TypeMobile.TypeMobileEnum;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public abstract class MobileDto extends OffreDto {


    /** type */
    /** type mobile */
    private TypeMobileEnum typeMobile;

    /** moteur*/
    private Boolean motoriser;

    public TypeMobileEnum getTypeMobile() {
        return typeMobile;
    }

    public Boolean getMotoriser() {
        return motoriser;
    }

    public void setTypeMobile(TypeMobileEnum typeMobile) {
        this.typeMobile = typeMobile;
    }

    public void setMotoriser(Boolean motoriser) {
        this.motoriser = motoriser;
    }
}
