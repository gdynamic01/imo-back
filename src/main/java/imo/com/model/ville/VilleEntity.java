package imo.com.model.ville;


import imo.com.model.AbstractEntity;
import imo.com.model.pays.PaysEntity;
import imo.com.model.utilisateur.AppUser;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "imo_ville")
public class VilleEntity extends AbstractEntity implements Serializable {


    @Column(name = "nom_ville", nullable = false)
    private String nomVille;

    @Column(name = "code_postal")
    private int codePostal;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "pays_id", nullable = false)
    private PaysEntity paysEntity;

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public String getNomVille() {
        return nomVille;
    }

    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }

    public PaysEntity getPaysEntity() {
        return paysEntity;
    }

    public void setPaysEntity(PaysEntity paysEntity) {
        this.paysEntity = paysEntity;
    }
}
