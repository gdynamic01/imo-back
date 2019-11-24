package imo.com.logic.MobileMoteurElectrique.dto;

import imo.com.model.mobileMoteur.MobileMoteur;

import javax.persistence.Column;
import java.util.Timer;

public class MobileMoteurElectriqueDto extends MobileMoteur {

    /** batterie*/
    private String batterie;

    /** duree*/
    private Timer dureeBaterie;

    public String getBatterie() {
        return batterie;
    }

    public Timer getDureebaterie() {
        return dureeBaterie;
    }

    public void setBatterie(String batterie) {
        batterie = batterie;
    }

    public void setDureebaterie(Timer dureebaterie) {
        this.dureeBaterie = dureebaterie;
    }
}
