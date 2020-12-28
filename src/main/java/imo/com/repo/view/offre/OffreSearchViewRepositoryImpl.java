/**
 * 
 */
package imo.com.repo.view.offre;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;

import imo.com.model.enums.TypeServiceOffre;
import imo.com.model.view.OffreSearchView;

/**
 * @author mbalde
 *
 */

@Service
public class OffreSearchViewRepositoryImpl implements IOffreSearchViewRepositoryCustom {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<OffreSearchView> getOffres(TypeServiceOffre typesServices, String ville, String pays,
			LocalDateTime dateDebut, LocalDateTime dateFin, String categories) {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<OffreSearchView> cq = cb.createQuery(OffreSearchView.class);
		
		Root<OffreSearchView> offreSearchView = cq.from(OffreSearchView.class);
		List<Predicate> predicates = new ArrayList<>();
		
		if(typesServices != null) {
			predicates.add(cb.equal(offreSearchView.get("typeServiceOffre"), typesServices));
		}
		if(ville != null) {
			predicates.add(cb.equal(offreSearchView.get("adresse").get("ville"), ville));
		}
		if(pays != null) {
			predicates.add(cb.equal(offreSearchView.get("adresse").get("pays"), pays));
		}
		if(dateDebut != null &&  dateFin != null) {
			predicates.add(cb.between(offreSearchView.get("dateDebut"), dateDebut, dateFin));
		}
		else if(dateDebut != null && dateFin == null) {
			predicates.add(cb.equal(offreSearchView.get("dateDebut"), dateDebut));
		}
		else if(dateDebut == null &&  dateFin != null) {
			predicates.add(cb.equal(offreSearchView.get("dateFin"), dateFin));
		}
		if(categories != null && !categories.isEmpty()) {
			List<String> categoriesTables = Arrays.asList(categories.split("_"));
			Predicate typeDebienImmobiliers = cb.in(offreSearchView.get("typeBienMobile")).value(categoriesTables);
			Predicate typeBienMobiles = cb.in(offreSearchView.get("typeDebienImmobilier")).value(categoriesTables);
			predicates.add(cb.or(typeDebienImmobiliers, typeBienMobiles));
		}
		
		cq.where(predicates.toArray(new Predicate[0]));
		 
	    return em.createQuery(cq).getResultList();
	}

}
