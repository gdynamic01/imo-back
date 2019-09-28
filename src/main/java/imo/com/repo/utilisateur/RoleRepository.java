/**
 * 
 */
package imo.com.repo.utilisateur;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import imo.com.model.utilisateur.Role;
import imo.com.model.utilisateur.RoleUserEnum;

/**
 * @author mbalde
 *
 */
public interface RoleRepository extends CrudRepository<Role, Long> {

    /**
     * @param role
     * @return Role
     */
    Role findByRoleEnum(RoleUserEnum role);

    List<Role> findByRoleEnumIn(List<RoleUserEnum> roleEnum);
}
