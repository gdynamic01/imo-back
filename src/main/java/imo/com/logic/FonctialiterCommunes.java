/**
 * 
 */
package imo.com.logic;

import java.util.List;

import imo.com.response.ImoResponse;

/**
 * Cette classe gère les methodes communes du projet
 * 
 * @author mbalde
 *
 */
public abstract class FonctialiterCommunes {
	
	public static String messageErreur = "";

    /**
     * @param imo
     *                objet response
     * @param status
     *                httpStatus
     * @param message
     *                erreur
     * @param list
     *                resultat
     */
    public static <D> void setImoResponse(ImoResponse<D> imo, int status, String message, List<D> list) {
        imo.setStatut(status);
        imo.setMessageResponse(message);
        imo.setResult(list);
    }

}
