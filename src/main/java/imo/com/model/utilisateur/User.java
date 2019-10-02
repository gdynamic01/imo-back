/**
 * 
 */
package imo.com.model.utilisateur;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
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

import imo.com.model.AbstractEntity;
import imo.com.model.typeutilisateur.TypeUtilisateurEnum;

/**
 * @author mbalde
 *
 */
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "user_type")
public abstract class User extends AbstractEntity implements Serializable {

    /** Serial ID */
    private static final long serialVersionUID = -716142150922491844L;

    /** email utilisateur */
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    /** activation et desactivation */
    @Column(name = "enabled")
    private boolean enabled = true;

    /** mot de passe utilisateur */
    @Column(name = "password", nullable = false)
    private String password;

    /** liste des roles */
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    /** type utilisateur */
    @Column(name = "type_user", nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeUtilisateurEnum typeUtilisateur;

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
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
    public void setPassword(String password) {
        this.password = password;
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
