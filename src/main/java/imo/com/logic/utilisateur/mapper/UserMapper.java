package imo.com.logic.utilisateur.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import imo.com.logic.IGeneriqueMapper;
import imo.com.logic.utilisateur.dto.UserDto;
import imo.com.model.utilisateur.UserPhysiqueEntity;

/**
 * Mapper for user physique
 * 
 * @author mbalde
 *
 */
@Component
public class UserMapper implements IGeneriqueMapper<UserDto, UserPhysiqueEntity> {

	@Autowired
	ModelMapper modelMapper;

	@Override
	public UserDto asObjectDto(UserPhysiqueEntity in) {
		return modelMapper.map(in, UserDto.class);
	}

	@Override
	public UserPhysiqueEntity asObjectEntity(UserDto in) {
		return modelMapper.map(in, UserPhysiqueEntity.class);
	}

}
