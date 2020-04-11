/**
 * 
 */
package imo.com.repo.offre;

import org.springframework.data.repository.CrudRepository;

import imo.com.model.offre.OffreEntity;

/**
 * @author balde
 *
 */
public interface OffreBaseRepository<T extends OffreEntity> extends CrudRepository<T, Long> {

}
