/**
 * 
 */
package imo.com.logic.adresse.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import imo.com.logic.FonctialiterCommunes;
import imo.com.logic.adresse.IAdresse;
import imo.com.logic.adresse.dto.PaysDto;
import imo.com.logic.adresse.mapper.AdresseMapper;
import imo.com.model.pays.PaysEntity;
import imo.com.repo.adresse.PaysRepository;
import imo.com.response.ImoResponse;

/**
 * @author mbalde
 *
 */
@Service
@Transactional
public class AdresseImpl implements IAdresse {
	
	@Autowired
	private PaysRepository paysRepository;
	
	@Autowired
	private AdresseMapper adresseMapper;

	@Override
	public ImoResponse<PaysDto> getListPays() {
		
		ImoResponse<PaysDto> response = new ImoResponse<>();
		
		List<PaysEntity> entities = paysRepository.findAll();
		if(!entities.isEmpty()) {
			List<PaysDto> pays = entities.stream().map(adresseMapper::asObjectDto).collect(Collectors.toList());
			FonctialiterCommunes.setImoResponse(response, HttpStatus.OK.value(), null, pays);
		} else {
			FonctialiterCommunes.setImoResponse(response, HttpStatus.NO_CONTENT.value(), null, null);
		}
		return response;
	}

}
