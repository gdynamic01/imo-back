/**
 * 
 */
package imo.com.repo.view.offre;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import imo.com.model.view.OffreSearchView;

/**
 * @author mbalde
 *
 */
public interface IOffreSearchViewRepository extends JpaRepository<OffreSearchView, Long> {

	Optional<OffreSearchView> findByCodeOffre(String codeOffre);
}
