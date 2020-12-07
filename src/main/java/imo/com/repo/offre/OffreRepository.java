/**
 * 
 */
package imo.com.repo.offre;

import imo.com.model.offre.OffreEntity;

import java.util.Optional;

/**
 * @author mbalde
 */
public interface OffreRepository extends OffreBaseRepository<OffreEntity> {

	Optional<OffreEntity> findByCodeOffre(String codeOffre);

}
