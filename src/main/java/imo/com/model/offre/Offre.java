package imo.com.model.offre;

import imo.com.model.AbstractEntity;
import imo.com.model.adresse.Adresse;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * @author rahime
 *
 */
@Entity
@Table(name = "imo_offre")
@Inheritance(strategy = InheritanceType.JOINED)
public  abstract class Offre  extends AbstractEntity implements Serializable {

    /** Serial ID */
    private static final long serialVersionUID = -716142150922491844L;
    /** titre */
    /** titre de l'offre */
    @Column(name = "titre", nullable = false, unique = true)
    private String titre;

    /** Description de l'offre */
    @Column(name = "description", nullable = false, unique = true)
    private String description;
    /** date publication de l'offre */
    @Column(name = "date_publication", nullable = false, unique = true)
    private Date datePublication;

    /** date mise à jour de l'offre */
    @Column(name = "date_mise_a_jour", nullable = false, unique = true)
    private Date dateMaj;

    /** adresse de l'offre */
    @Embedded
    private Adresse adresse;

    /** Prix de l'offre */
    @Column(name = "prix", nullable = false)
    private Double prix;

}
