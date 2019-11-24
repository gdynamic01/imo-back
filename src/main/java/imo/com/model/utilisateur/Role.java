/**
 * 
 */
package imo.com.model.utilisateur;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import imo.com.model.AbstractEntity;

/**
 * @author mbalde
 *
 */
@Entity
@Table(name = "imo_role")
public class Role extends AbstractEntity implements Serializable {

	/** Serial ID */
	private static final long serialVersionUID = -6488120240535583232L;

	@Enumerated(EnumType.STRING)
	@Column(name = "role", nullable = false, unique = true)
	private RoleUserEnum roleEnum;

	/** liste user */
	@ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
	private Collection<AppUser> user;

	/**
	 * @return the role
	 */
	public RoleUserEnum getRoleEnum() {
		return roleEnum;
	}

	/**
	 * @return the user
	 */
	public Collection<AppUser> getUser() {
		return user;
	}

	/**
	 * @param role the role to set
	 */
	public void setRoleEnum(RoleUserEnum role) {
		this.roleEnum = role;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(Collection<AppUser> user) {
		this.user = user;
	}

}
