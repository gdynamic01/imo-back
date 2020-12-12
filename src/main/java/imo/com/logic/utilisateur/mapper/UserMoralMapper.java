/**
 * 
 */
package imo.com.logic.utilisateur.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import imo.com.logic.IGeneriqueMapper;
import imo.com.logic.utilisateur.dto.UserMoralDto;
import imo.com.model.utilisateur.UserMoralEntity;

/**
 * @author mbalde
 *
 */
@Component
public class UserMoralMapper implements IGeneriqueMapper<UserMoralDto, UserMoralEntity> {


    private final  ModelMapper modelMapper;

    @Autowired
    public UserMoralMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public UserMoralDto asObjectDto(UserMoralEntity in) {
        return modelMapper.map(in, UserMoralDto.class);
    }

    @Override
    public UserMoralEntity asObjectEntity(UserMoralDto in) {
        return modelMapper.map(in, UserMoralEntity.class);
    }

}
