/**
 * 
 */
package imo.com.repo.utilisateur.moral;

import javax.transaction.Transactional;

import imo.com.model.utilisateur.UserMoralEntity;
import imo.com.repo.utilisateur.UserBaseRepository;

/**
 * @author mbalde
 *
 */
@Transactional
public interface UserMoralRepository extends UserBaseRepository<UserMoralEntity>{

}
