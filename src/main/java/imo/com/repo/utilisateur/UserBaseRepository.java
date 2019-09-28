/**
 * 
 */
package imo.com.repo.utilisateur;

import org.springframework.data.repository.CrudRepository;

import imo.com.model.utilisateur.User;

/**
 * @author mbalde
 *
 */
public interface UserBaseRepository<T extends User> extends CrudRepository<T, Long>{

}
