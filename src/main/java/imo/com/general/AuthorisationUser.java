package imo.com.general;

/**
 * 
 * @author mbalde
 *
 */
public abstract class AuthorisationUser {

	/** role admin */
	public static final String ADMIN = "hasRole('ADMIN')";

	/** role professionnel ou particulier */
	public static final String PROF_OR_PAR = "hasRole('ROLE_USER_MORAL') or hasRole('ROLE_USER_PHYSIQUE')";
	
	/** role particulier ou admin */
	public static final String PART_OR_ADMIN = "hasRole('ROLE_USER_PHYSIQUE') or hasRole('ROLE_ADMIN')";
	
	/** role professionnel ou admin */
	public static final String PROF_OR_ADMIN = "hasRole('ROLE_USER_MORAL') or hasRole('ROLE_ADMIN')";
	
	public static final String PROF_OR_PAR_OR_ADMIN = "hasRole('ROLE_USER_MORAL') or hasRole('ROLE_USER_PHYSIQUE') or hasRole('ROLE_ADMIN')";
}
