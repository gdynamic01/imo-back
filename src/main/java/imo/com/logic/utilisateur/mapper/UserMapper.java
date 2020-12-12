package imo.com.logic.utilisateur.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import imo.com.logic.IGeneriqueMapper;
import imo.com.logic.utilisateur.dto.UserPhysiqueDto;
import imo.com.model.utilisateur.UserPhysiqueEntity;

/**
 * Mapper for user physique
 * 
 * @author mbalde
 *
 */
@Component
public class UserMapper implements IGeneriqueMapper<UserPhysiqueDto, UserPhysiqueEntity> {


	private final ModelMapper modelMapper;

	@Autowired
	public UserMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@Override
	public UserPhysiqueDto asObjectDto(UserPhysiqueEntity in) {
		return modelMapper.map(in, UserPhysiqueDto.class);
	}

	@Override
	public UserPhysiqueEntity asObjectEntity(UserPhysiqueDto in) {
		return modelMapper.map(in, UserPhysiqueEntity.class);
	}

}
