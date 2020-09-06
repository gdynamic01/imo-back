package imo.com.model.pays;


import imo.com.model.AbstractEntity;
import imo.com.model.ville.VilleEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "imo_pays")
public class PaysEntity extends AbstractEntity implements Serializable {


    /** Serial ID */
    private static final long serialVersionUID = -716142150922491844L;

    /** model */
    @Column(name = "nom_pays")
    private String nomPays;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "pays_id", referencedColumnName = "id", nullable = true)
    private List<VilleEntity> billes = new ArrayList<>();


    public String getNomPays() {
        return nomPays;
    }

    public void setNomPays(String nomPays) {
        this.nomPays = nomPays;
    }
}
