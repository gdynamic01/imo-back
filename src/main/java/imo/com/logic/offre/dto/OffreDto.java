package imo.com.logic.offre.dto;

import imo.com.model.adresse.Adresse;

import javax.persistence.Column;
import javax.persistence.Embedded;
import java.util.Date;

public class OffreDto {


    /** Serial ID */
    private static final long serialVersionUID = -716142150922491844L;
    /** titre */
    private String titre;
    /** description */
    private String description;
    /** date de publication */
    private Date datePublication;
    /** date mise à jour */
    private Date dateMaj;
    /** adresse*/
    private Adresse adresse;
    /** prix */
    private Double prix;

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public void setDateMaj(Date dateMaj) {
        this.dateMaj = dateMaj;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public Date getDateMaj() {
        return dateMaj;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public Double getPrix() {
        return prix;
    }
}
