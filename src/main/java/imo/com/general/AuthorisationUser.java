package imo.com.general;

/**
 * 
 * @author mbalde
 *
 */
public abstract class AuthorisationUser {

    /** role admin */
    public static final String ADMIN = "hasRole('ROLE_ADMIN')";

    /** role professionnel ou particulier */
    public static final String PROF_OR_PAR = "hasRole('ROLE_PROF') or hasRole('ROLE_PAR')";

}