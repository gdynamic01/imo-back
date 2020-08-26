/**
 * 
 */
package imo.com.repo.utilisateur;

import org.springframework.data.jpa.repository.JpaRepository;
import imo.com.model.utilisateur.AppUser;

/**
 * @author mbalde
 *
 */
public interface UserBaseRepository<T extends AppUser> extends JpaRepository<T, Long>{

}
