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
	private MobileDto mobileDto;

	/** immobilierDto */
	private ImmobilierDto immobilierDto;

	/** email utilisateur */
	private String email;

	/**
	 * @return the mobileDto
	 */
	public MobileDto getMobileDto() {
		return mobileDto;
	}

	/**
	 * @param mobileDto the mobileDto to set
	 */
	public void setMobileDto(MobileDto mobileDto) {
		this.mobileDto = mobileDto;
	}

	/**
	 * @return the immobilierDto
	 */
	public ImmobilierDto getImmobilierDto() {
		return immobilierDto;
	}

	/**
	 * @param immobilierDto the immobilierDto to set
	 */
	public void setImmobilierDto(ImmobilierDto immobilierDto) {
		this.immobilierDto = immobilierDto;
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
