package imo.com.logic.utilisateur.physique.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import imo.com.logic.IGeneriqueMapper;
import imo.com.logic.utilisateur.physique.dto.UserPhysiqueDto;
import imo.com.model.utilisateur.UserPhysiqueEntity;

/**
 * Mapper for user physique
 * 
 * @author mbalde
 *
 */
@Component
public class UserPhysiqueMapper implements IGeneriqueMapper<UserPhysiqueDto, UserPhysiqueEntity> {

    @Autowired
    ModelMapper modelMapper;

    @Override
    public UserPhysiqueDto asObjectDto(UserPhysiqueEntity in) {
        return modelMapper.map(in, UserPhysiqueDto.class);
    }

    @Override
    public UserPhysiqueEntity asObjectEntity(UserPhysiqueDto in) {
        return modelMapper.map(in, UserPhysiqueEntity.class);
    }

}
