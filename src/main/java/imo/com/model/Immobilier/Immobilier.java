package imo.com.model.Immobilier;

import imo.com.model.AbstractEntity;
import imo.com.model.adresse.Adresse;
import imo.com.model.offre.Offre;
import imo.com.model.typeImmobilier.TypeImobilierEnum;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "imo_immobilier")
@Inheritance(strategy = InheritanceType.JOINED)
public class Immobilier extends Offre  implements Serializable{

        /** Serial ID */
        private static final long serialVersionUID = -716142150922491844L;
        /** surface */
        /** surface de l'offre */
        @Column(name = "surface", nullable = false, unique = true)
        private Double surface;

        /** type immobilier */
        @Column(name = "type_immobiler", nullable = false)
        @Enumerated(EnumType.STRING)
        private TypeImobilierEnum typeImobilier;

        public static long getSerialVersionUID() {
                return serialVersionUID;
        }

        public Double getSurface() {
                return surface;
        }

        public void setSurface(Double surface) {
                this.surface = surface;
        }

        public TypeImobilierEnum getTypeImobilier() {
                return typeImobilier;
        }

        public void setTypeImobilier(TypeImobilierEnum typeImobilier) {
                this.typeImobilier = typeImobilier;
        }
}
