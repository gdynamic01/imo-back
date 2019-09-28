/**
 * 
 */
package imo.com.repo.utilisateur.physique;

import javax.transaction.Transactional;

import imo.com.model.utilisateur.UserPhysiqueEntity;
import imo.com.repo.utilisateur.UserBaseRepository;

/**
 * @author mbalde
 *
 */
@Transactional
public interface UserPhysiqueRepository extends UserBaseRepository<UserPhysiqueEntity> {

}
