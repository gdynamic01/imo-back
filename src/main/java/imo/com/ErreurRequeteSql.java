/**
 * 
 */
package imo.com;

/**
 * @author mbalde
 *
 */
public class ErreurRequeteSql extends Exception {

	/** message */
	private String message;

	/** statut */
	private int statut;

	/**
	 * 
	 * @param s message
	 * @param statut
	 */
	public ErreurRequeteSql(String s, int statut) {
		super(s);
		this.statut = statut;
	}

	/**
	 * @return the message
	 */
	@Override
	public String getMessage() {
		return message;
	}

	/**
	 * @return the statut
	 */
	public int getStatut() {
		return statut;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @param statut the statut to set
	 */
	public void setStatut(int statut) {
		this.statut = statut;
	}
}
