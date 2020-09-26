/**
 * 
 */
package imo.com.repo.offre;

import org.springframework.data.jpa.repository.JpaRepository;
import imo.com.model.offre.OffreEntity;

/**
 * @author balde
 *
 */
public interface OffreBaseRepository<T extends OffreEntity> extends JpaRepository<T, Long> {

}
