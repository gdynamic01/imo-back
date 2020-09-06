package imo.com.model.ville;

import imo.com.model.AbstractEntity;
import imo.com.model.pays.PaysEntity;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "imo_ville")
public class VilleEntity extends AbstractEntity implements Serializable {

	/** Serial ID */
	private static final long serialVersionUID = 8616919680962235256L;

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
