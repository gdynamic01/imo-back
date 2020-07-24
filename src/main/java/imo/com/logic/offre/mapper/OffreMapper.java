package imo.com.logic.offre.mapper;

import imo.com.logic.IGeneriqueMapper;
import imo.com.logic.offre.dto.OffreDto;
import imo.com.model.offre.OffreEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OffreMapper  implements IGeneriqueMapper<OffreDto, OffreEntity> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public OffreDto asObjectDto(OffreEntity in) {
        return  modelMapper.map(in, OffreDto.class);
    }

    @Override
    public OffreEntity asObjectEntity(OffreDto in) {
        return modelMapper.map(in, OffreEntity.class);
    }
}
