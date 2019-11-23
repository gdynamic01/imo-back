package imo.com.model.mobileMoteur;

import imo.com.model.TypeMobile.TypeMobileEnum;
import imo.com.model.TypeMobileMoteurEnum;
import imo.com.model.adresse.Adresse;
import imo.com.model.mobile.Mobile;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;



/**
 * @author rahime
 *
 */

@Entity
@Table(name = "imo_mobileMoteur")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class MobileMoteur  extends Mobile implements Serializable {

    /** Serial ID */
    private static final long serialVersionUID = -716142150922491844L;
    /** Kilometrage */
    @Column(name = "kilometrage", nullable = false)
    private Double kilometrage;

    /** Nombre de roue */
    @Column(name = "nombre_roue", nullable = false)
    private Double nbreRoue;

    /** Description de l'offre */
    @Column(name = "model", nullable = false, unique = true)
    private String model;
    /** date publication de l'offre */
    @Column(name = "nombre_porte", nullable = false, unique = true)
    private Double nombrePorte;


    /** date mise en circulation du vehicule */
    @Column(name = "date_mise_en_circulation", nullable = false)
    private Date dateMiseCircualtion;

    /** type_moteur */
    @Column(name = "type_moteur", nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeMobileMoteurEnum typeMobile;

    public Double getKilometrage() {
        return kilometrage;
    }

    public Double getNbreRoue() {
        return nbreRoue;
    }

    public String getModel() {
        return model;
    }

    public Double getNombrePorte() {
        return nombrePorte;
    }

    public Date getDateMiseCircualtion() {
        return dateMiseCircualtion;
    }

    public void setKilometrage(Double kilometrage) {
        this.kilometrage = kilometrage;
    }

    public void setNbreRoue(Double nbreRoue) {
        this.nbreRoue = nbreRoue;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setNombrePorte(Double nombrePorte) {
        this.nombrePorte = nombrePorte;
    }

    public void setDateMiseCircualtion(Date dateMiseCircualtion) {
        this.dateMiseCircualtion = dateMiseCircualtion;
    }
}

