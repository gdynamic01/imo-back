/**
 * 
 */
package imo.com.logic.offre.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import imo.com.logic.IGeneriqueMapper;
import imo.com.logic.offre.dto.ImmobilierDto;
import imo.com.model.immobilier.ImmobilierEntity;

/**
 * @author balde
 *
 */
@Component
public class ImmobilierMapper implements IGeneriqueMapper<ImmobilierDto, ImmobilierEntity> {


	private final ModelMapper modelMapper;

	@Autowired
	public ImmobilierMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@Override
	public ImmobilierDto asObjectDto(ImmobilierEntity in) {
		return this.modelMapper.map(in, ImmobilierDto.class);
	}

	@Override
	public ImmobilierEntity asObjectEntity(ImmobilierDto in) {
		return this.modelMapper.map(in, ImmobilierEntity.class);

	}

}
