/**
 * 
 */
package imo.com.logic;

/**
 * 
 * @author mbalde
 *
 * @param <D>
 *            dto
 * @param <E>
 *            entity
 */
public interface IGeneriqueObjectDtoMapper<D, E> {
	
	/**
     * convertit entity en dto
     * 
     * @param in
     *           entity
     * @return dto
     */
    public D asObjectDto(E in);


}
