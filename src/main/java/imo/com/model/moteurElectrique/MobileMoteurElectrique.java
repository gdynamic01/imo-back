package imo.com.model.moteurElectrique;


import imo.com.model.mobileMoteur.MobileMoteur;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Timer;

@Entity
@Table(name = "imo_mobileMoteurElectrique")
@Inheritance(strategy = InheritanceType.JOINED)
public class MobileMoteurElectrique extends MobileMoteur implements Serializable {

   // ** Serial ID */
    private static final long serialVersionUID = -716142150922491844L;
    /** batterie*/
    @Column(name = "batterie", nullable = false)
    private String Batterie;

    /** duree*/
    @Column(name = "duree_batterie", nullable = false)
    private Timer dureebaterie;
}
