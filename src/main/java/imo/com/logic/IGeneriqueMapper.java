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
public interface IGeneriqueMapper<D, E> {

    /**
     * convertit entity en dto
     * 
     * @param in
     *           entity
     * @return dto
     */
    public D asObjectDto(E in);

    /**
     * convertit dto en entity
     * 
     * @param in
     *           dto
     * @return entity
     */
    public E asObjectEntity(D in);

}
