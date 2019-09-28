/**
 * 
 */
package imo.com.model.utilisateur;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import imo.com.model.adresse.Adresse;
import imo.com.model.typeUtilisateur.RepresentantLegal;

/**
 * L'entity client
 * 
 * @author mbalde
 *
 */
@Entity
@Table(name = "user_physique")
@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue("Client")
public class UserPhysiqueEntity extends User implements Serializable {

    /** Serial ID */
    private static final long serialVersionUID = -5056368843553954261L;

    /** Adresse */
    @Embedded
    private Adresse adresse;

    /** representant legal (personne physique) */
    @Embedded
    private RepresentantLegal representantLegal;

    /** Sexe **/
    @Column(name = "sexe", nullable = false)
    @Enumerated(EnumType.STRING)
    private SexeEnum sexe;

    /**
     * @return the adresse
     */
    public Adresse getAdresse() {
        return adresse;
    }

    /**
     * @return the representantLegal
     */
    public RepresentantLegal getRepresentantLegal() {
        return representantLegal;
    }

    /**
     * @return the sexe
     */
    public SexeEnum getSexe() {
        return sexe;
    }

    /**
     * @param adresse
     *                the adresse to set
     */
    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    /**
     * @param representantLegal
     *                          the representantLegal to set
     */
    public void setRepresentantLegal(RepresentantLegal representantLegal) {
        this.representantLegal = representantLegal;
    }

    /**
     * @param sexe
     *             the sexe to set
     */
    public void setSexe(SexeEnum sexe) {
        this.sexe = sexe;
    }
}
