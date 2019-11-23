package imo.com.model.mobile;

import imo.com.model.TypeMobile.TypeMobileEnum;
import imo.com.model.offre.Offre;
import imo.com.model.typeImmobilier.TypeImobilierEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * @author rahime
 *
 */
@Entity
@Table(name = "imo_mobile")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract  class Mobile extends Offre  implements Serializable {

    /** Serial ID */
    private static final long serialVersionUID = -716142150922491844L;
    /** type */
    /** type mobile */
    @Column(name = "type_mobile", nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeMobileEnum typeMobile;


    /** moteur*/
    @Column(name = "motoriser", nullable = false)
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

