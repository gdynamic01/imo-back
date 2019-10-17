/**
 * 
 */
package imo.com.general;

import org.apache.commons.lang3.StringUtils;

/**
 * @author mbalde
 *
 */
public abstract class ConstantesUtils {

	/** message email existe */
	public static final String MESSAGE_EMAIL_EXISTE = "Cet email existe dejà veuillez vous connecter";

	/** message erreur formulaire */
	public static final String MESSAGE_ERREUR_FORMULAIRE_INSCRIPTION = "Le formulaire contient des erreurs, veuillez contacter le service loumo@contact.fr";

	/** message inscription reussi */
	public static final String MESSAGE_INSCRIPTION_REUSSI = "<h6>ACTIVATION COMPTE</h6> <p><span>Votre compte a été créé avec succès!</span></p><p><strong>veuillez cliquer sur le lien figurant dans l’email de confirmation que nous venons de vous envoyer.</strong></p>";

	/**
	 * cette methode doit etre enrichie au fur et a mesure pour le traitement des
	 * messages de contraintes
	 * 
	 * @param message
	 * @return message
	 */
	public static String contrainteMessage(String message) {

		String messageContrainte = "";
		if (StringUtils.contains(message, "email_unique"))
			messageContrainte = MESSAGE_EMAIL_EXISTE;
		else
			messageContrainte = MESSAGE_ERREUR_FORMULAIRE_INSCRIPTION;

		return messageContrainte;
	}

}
