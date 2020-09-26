/**
 * 
 */
package imo.com.repo.view.offre;

import java.time.LocalDate;
import java.util.List;

import imo.com.model.enums.TypeServiceOffre;
import imo.com.model.view.OffreSearchView;

/**
 * @author mbalde
 *
 */
public interface IOffreSearchViewRepositoryCustom {
	List<OffreSearchView> getOffres(TypeServiceOffre typesServices, String ville,
			String pays, LocalDate dateDebut, LocalDate dateFin, String categories);
}
