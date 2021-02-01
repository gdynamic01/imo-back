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
public interface IGeneriqueObjectEntityMapper<D, E> {
	
	/**
     * convertit dto en entity
     * 
     * @param in
     *           dto
     * @return entity
     */
    public E asObjectEntity(D in);

}
