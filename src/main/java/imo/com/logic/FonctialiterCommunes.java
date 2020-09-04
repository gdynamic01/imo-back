/**
 * 
 */
package imo.com.logic;

import java.util.List;

import imo.com.logic.offre.dto.OffreDto;
import imo.com.response.ImoResponse;

/**
 * Cette classe gère les methodes communes du projet
 * 
 * @author mbalde
 */
public abstract class FonctialiterCommunes {

	public static String messageErreur = "";

	/**
	 * @param imo     objet response
	 * @param status  httpStatus
	 * @param message erreur
	 * @param list    resultat
	 */
	public static <D> void setImoResponse(ImoResponse<D> imo, int status, String message, List<D> list) {
		imo.setStatut(status);
		imo.setMessageResponse(message);
		imo.setResult(list);
		if (list != null && list.get(0) instanceof OffreDto) {
			long nbOffreProfessionnel = list.stream().filter(offre -> offre != null
					&& !"String".equals(offre.getClass().getSimpleName()) && ((OffreDto) offre).isImmobilier()).count();
			long nbOffreParticulier = list.stream().filter(offre -> offre != null
					&& !"String".equals(offre.getClass().getSimpleName()) && ((OffreDto) offre).isMobile()).count();
			imo.setNbOffre(list != null ? list.size() : 0);
			imo.setNbOffreParticulier(nbOffreParticulier);
			imo.setNbOffreProfessionnel(nbOffreProfessionnel);
		}
	}

}
