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
	public static final String MESSAGE_INSCRIPTION_REUSSI = "Votre compte a été créé avec succès! Un email de confirmation vous a été envoyé";

	/**
	 * cette methode doit etre enrichie au fur et a mesure pour le traitement des
	 * messages de contraintes
	 * 
	 * @param message
	 * @return message
	 */
	public static String contrainteMessage(String message, String search) {

		String messageContrainte = "";
		if (StringUtils.contains(message, search))
			switch (search) {
			case "SQL [n/a]; constraint":
				messageContrainte = MESSAGE_EMAIL_EXISTE;
				break;
			default:
				messageContrainte = message;
				break;
			}
		return messageContrainte;
	}

}
