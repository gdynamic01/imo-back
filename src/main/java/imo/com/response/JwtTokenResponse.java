/**
 * 
 */
package imo.com.response;

/**
 * @author balde
 *
 */
public class JwtTokenResponse {

	private String token;

	private String messageResponse;

	/** code http */
	private int statut;

	public JwtTokenResponse(String token, String messageResponse, int status) {
		this.token = token;
		this.messageResponse = messageResponse;
		this.statut = status;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the messageResponse
	 */
	public String getMessageResponse() {
		return messageResponse;
	}

	/**
	 * @param messageResponse the messageResponse to set
	 */
	public void setMessageResponse(String messageResponse) {
		this.messageResponse = messageResponse;
	}

	/**
	 * @return the statut
	 */
	public int getStatut() {
		return statut;
	}

	/**
	 * @param statut the statut to set
	 */
	public void setStatut(int statut) {
		this.statut = statut;
	}

}
