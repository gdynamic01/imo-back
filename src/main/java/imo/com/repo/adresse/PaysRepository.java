/**
 * 
 */
package imo.com.repo.adresse;

import org.springframework.data.jpa.repository.JpaRepository;

import imo.com.model.pays.PaysEntity;

/**
 * @author mbalde
 *
 */
public interface PaysRepository extends JpaRepository<PaysEntity, Long>{
	
	public PaysEntity findByNomPays(String nomPays);
}
