/**
 * 
 */
package imo.com.repo.view.offre;

import java.time.LocalDateTime;
import java.util.List;

import imo.com.model.enums.TypeServiceOffre;
import imo.com.model.view.OffreSearchView;

/**
 * @author mbalde
 *
 */
public interface IOffreSearchViewRepositoryCustom {
	List<OffreSearchView> getOffres(TypeServiceOffre typesServices, String ville,
			String pays, LocalDateTime dateDebut, LocalDateTime dateFin, String categories);
}
