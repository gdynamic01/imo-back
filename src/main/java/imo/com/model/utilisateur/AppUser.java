
package imo.com.model.utilisateur;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import imo.com.model.AbstractEntity;
import imo.com.model.adresse.Adresse;
import imo.com.model.enums.TypeUtilisateurEnum;
import imo.com.model.info.RepresentantLegal;

/**
 * @author mbalde
 *
 */
@Entity
@Table(name = "imo_users")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AppUser extends AbstractEntity implements Serializable {

	/** Serial ID */
	private static final long serialVersionUID = -716142150922491844L;

	/** adresse */
	@Embedded
	private Adresse adresse;

	/** email utilisateur */
	@Column(name = "email", nullable = false, unique = true)
	private String email;

	/** activation et desactivation */
	@Column(name = "enabled")
	private boolean enabled = false;

	/** mot de passe utilisateur */
	@Column(name = "password", nullable = false)
	@JsonIgnore
	private String password;

	/** representant legal */
	@Embedded
	private RepresentantLegal representantLegal;

	/** liste des roles */
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "imo_user_roles", joinColumns = @JoinColumn(
					name = "user_id", referencedColumnName = "id", nullable = false
			), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
	)
	private Collection<Role> roles;

	/** type utilisateur */
	@Column(name = "type_user", nullable = false)
	@Enumerated(EnumType.STRING)
	private TypeUtilisateurEnum typeUtilisateur;

	/**
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the password
	 */
	@JsonIgnore
	public String getPassword() {
		return password;
	}

	/**
	 * @return the representantLegal
	 */
	public RepresentantLegal getRepresentantLegal() {
		return representantLegal;
	}

	/**
	 * @return the roles
	 */
	public Collection<Role> getRoles() {
		return roles;
	}

	/**
	 * @return the typeUtilisateur
	 */
	public TypeUtilisateurEnum getTypeUtilisateur() {
		return typeUtilisateur;
	}

	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	/**
	 * @param email
	 *              the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param enabled
	 *                the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @param password
	 *                 the password to set
	 */
	@JsonIgnore
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param representantLegal the representantLegal to set
	 */
	public void setRepresentantLegal(RepresentantLegal representantLegal) {
		this.representantLegal = representantLegal;
	}

	/**
	 * @param roles
	 *              the roles to set
	 */
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	/**
	 * @param typeUtilisateur
	 *                        the typeUtilisateur to set
	 */
	public void setTypeUtilisateur(TypeUtilisateurEnum typeUtilisateur) {
		this.typeUtilisateur = typeUtilisateur;
	}
}
