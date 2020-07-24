/**
 * 
 */
package imo.com.repo.utilisateur;

import imo.com.model.utilisateur.AppUser;

/**
 * @author mbalde
 *
 */
public interface UserRepository extends UserBaseRepository<AppUser> {

	/**
	 * Renvoie l'utilisateur actif
	 * @param email de l'utilisateur
	 * @return user
	 */
	public AppUser findByEnabledTrueAndEmail(String email);

	public AppUser findByEmail(String email);



}
