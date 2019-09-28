/**
 * 
 */
package imo.com.general;

import imo.com.response.ImoResponse;

/**
 * @author mbalde
 *
 */
public interface IFonctionaliteCommune {

    /**
     * 
     * @param <D>
     *                    object response
     * @param dto
     * @param imoResponse
     * @return boolean
     */
    public <D> boolean checkObjectDto(Object dto, ImoResponse<D> imoResponse);

}
