/**
 * 
 */
package imo.com.repo.utilisateur;

import javax.transaction.Transactional;

import imo.com.model.utilisateur.User;

/**
 * @author mbalde
 *
 */
@Transactional
public interface UserRepository extends UserBaseRepository<User>{

}
