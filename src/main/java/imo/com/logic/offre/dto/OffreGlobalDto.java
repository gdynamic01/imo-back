/**
 * 
 */
package imo.com.logic.offre.dto;

/**
 * @author balde
 *
 */
public class OffreGlobalDto {

	/** mobileDto */
	private MobileDto mobile;

	/** immobilierDto */
	private ImmobilierDto immobilier;

	/** email utilisateur */
	private String email;

	/**
	 * @return the mobileDto
	 */
	public MobileDto getMobile() {
		return mobile;
	}

	/**
	 * @param mobileDto the mobile to set
	 */
	public void setMobile(MobileDto mobileDto) {
		this.mobile = mobileDto;
	}

	/**
	 * @return the immobilier
	 */
	public ImmobilierDto getImmobilier() {
		return immobilier;
	}

	/**
	 * @param immobilierDto the immobilier to set
	 */
	public void setImmobilier(ImmobilierDto immobilierDto) {
		this.immobilier = immobilierDto;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}
