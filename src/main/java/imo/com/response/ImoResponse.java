/**
 * 
 */
package imo.com.response;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mbalde
 *
 */
public class ImoResponse<T> {

    /** champs obligatoires */
    private String[] champsObligatoires;

    /** message reponse */
    private String messageResponse;

    /** resultat de la reponse */
    private List<T> result = new ArrayList<>();

    /** code http */
    private int statut;

    /**
     * @return the champsObligatoires
     */
    public String[] getChampsObligatoires() {
        return champsObligatoires;
    }

    /**
     * @return the messageResponse
     */
    public String getMessageResponse() {
        return messageResponse;
    }

    /**
     * @return the result
     */
    public List<T> getResult() {
        return result;
    }

    /**
     * @return the codeResultat
     */
    public int getStatut() {
        return statut;
    }

    /**
     * @param champsObligatoires
     *                           the champsObligatoires to set
     */
    public void setChampsObligatoires(String[] champsObligatoires) {
        this.champsObligatoires = champsObligatoires;
    }

    /**
     * @param messageResponse
     *                        the messageResponse to set
     */
    public void setMessageResponse(String messageResponse) {
        this.messageResponse = messageResponse;
    }

    /**
     * @param result
     *               the result to set
     */
    public void setResult(List<T> result) {
        this.result = result;
    }

    /**
     * @param codeResultat
     *                     the codeResultat to set
     */
    public void setStatut(int codeResultat) {
        this.statut = codeResultat;
    }

}
