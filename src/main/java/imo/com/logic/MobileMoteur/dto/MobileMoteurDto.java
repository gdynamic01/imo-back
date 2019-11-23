package imo.com.logic.MobileMoteur.dto;

import imo.com.logic.Mobile.dtd.MobileDto;
import imo.com.model.TypeMobileMoteurEnum;
import imo.com.model.mobile.Mobile;

import java.util.Date;

public class MobileMoteurDto  extends MobileDto {

    /** Serial ID */

    /** Kilometrage */

    private Double kilometrage;
    /** Nombre de roue */
    private Double nbreRoue;

    /** Description de l'offre */
    private String model;
    /** date publication de l'offre */
    private Double nombrePorte;
    /** date mise en circulation du vehicule */
    private Date dateMiseCircualtion;
    /** type_moteur */
    private TypeMobileMoteurEnum typeMobileMoteur;

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


    public TypeMobileMoteurEnum getTypeMobileMoteur() {
        return typeMobileMoteur;
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

    public void setTypeMobileMoteur(TypeMobileMoteurEnum typeMobile) {
        this.typeMobileMoteur = typeMobile;
    }
}
