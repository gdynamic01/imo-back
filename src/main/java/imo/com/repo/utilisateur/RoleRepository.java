/**
 * 
 */
package imo.com.repo.utilisateur;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import imo.com.model.utilisateur.Role;
import imo.com.model.utilisateur.RoleUserEnum;

/**
 * @author mbalde
 *
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

	/**
	 * @param role
	 * @return Role
	 */
	Role findByRoleEnum(RoleUserEnum role);

	/**
	 * @param roleEnum
	 * @return liste role
	 */
	List<Role> findByRoleEnumIn(List<RoleUserEnum> roleEnum);
}
