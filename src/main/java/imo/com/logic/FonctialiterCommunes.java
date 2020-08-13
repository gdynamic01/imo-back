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
		long nbOffreProfessionnel = list != null ? list.stream().filter(offre -> offre != null
				&& !"String".equals(offre.getClass().getSimpleName()) && ((OffreDto) offre).isImmobilier()).count() : 0;
		long nbOffreParticulier = list != null ? list.stream().filter(offre -> offre != null
				&& !"String".equals(offre.getClass().getSimpleName()) && ((OffreDto) offre).isMobile()).count() : 0;
		imo.setNbOffre(list != null ? list.size() : 0);
		imo.setNbOffreParticulier(nbOffreParticulier);
		imo.setNbOffreProfessionnel(nbOffreProfessionnel);
	}

}
