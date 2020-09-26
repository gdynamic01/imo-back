/**
 * 
 */
package imo.com.logic.adresse.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import imo.com.logic.IGeneriqueMapper;
import imo.com.logic.adresse.dto.PaysDto;
import imo.com.model.pays.PaysEntity;

/**
 * @author mbalde
 *
 */
@Component
public class AdresseMapper implements IGeneriqueMapper<PaysDto, PaysEntity> {
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public PaysDto asObjectDto(PaysEntity in) {
		return modelMapper.map(in, PaysDto.class);
	}

	@Override
	public PaysEntity asObjectEntity(PaysDto in) {
		return modelMapper.map(in, PaysEntity.class);
	}

}
