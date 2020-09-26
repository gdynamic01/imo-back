package imo.com.model.ville;

import imo.com.model.AbstractEntity;
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
}
