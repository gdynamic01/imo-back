/**
 * 
 */
package imo.com.logic.adresse.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mbalde
 *
 */
public class PaysDto {
	
	private String nomPays;
	
	private List<VilleDto> villes = new ArrayList<VilleDto>();
	
	/**
	 * @return the nomPays
	 */
	public String getNomPays() {
		return nomPays;
	}
	/**
	 * @param nomPays the nomPays to set
	 */
	public void setNomPays(String nomPays) {
		this.nomPays = nomPays;
	}
	/**
	 * @return the villes
	 */
	public List<VilleDto> getVilles() {
		return villes;
	}
	/**
	 * @param villes the villes to set
	 */
	public void setVilles(List<VilleDto> villes) {
		this.villes = villes;
	}
}
