/**
 * 
 */
package imo.com.repo.utilisateur;

import javax.transaction.Transactional;

import imo.com.model.utilisateur.AppUser;

/**
 * @author mbalde
 *
 */
@Transactional
public interface UserRepository extends UserBaseRepository<AppUser> {

	/**
	 * Renvoie l'utilisateur actif
	 * @param email de l'utilisateur
	 * @return user
	 */
	public AppUser findByEnabledTrueAndEmail(String email);

}
