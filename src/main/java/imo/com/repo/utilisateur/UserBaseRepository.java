/**
 * 
 */
package imo.com.repo.utilisateur;

import org.springframework.data.repository.CrudRepository;

import imo.com.model.utilisateur.AppUser;

/**
 * @author mbalde
 *
 */
public interface UserBaseRepository<T extends AppUser> extends CrudRepository<T, Long>{

}
