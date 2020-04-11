/**
 * 
 */
package imo.com.logic.utilisateur;

/**
 * @author balde
 *
 */
public class UtilisateurConnecterContextHolder {

	/** context threadLocal */
	private static ThreadLocal<String> CONTEXT = new ThreadLocal<>();

	/**
	 * sauvegarde user
	 * @param dto user
	 */
	public static void setUserDto(String dto) {
		CONTEXT.set(dto);
	}

	/**
	 * recupere user
	 * @return user
	 */
	public static String getUserDto() {
		return CONTEXT.get();
	}

	/** vide le context threadLocal pour eviter une fuite memoire */
	public static void clear() {
		CONTEXT.remove();
	}

}
