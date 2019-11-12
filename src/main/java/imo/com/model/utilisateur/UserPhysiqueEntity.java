/**
 * 
 */
package imo.com.model.utilisateur;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * L'entity client
 * 
 * @author mbalde
 *
 */
@Entity
@Table(name = "user_physique")
@PrimaryKeyJoinColumn(name = "id")
public class UserPhysiqueEntity extends AppUser implements Serializable {

	/** Serial ID */
	private static final long serialVersionUID = -5056368843553954261L;

}
