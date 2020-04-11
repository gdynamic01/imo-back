/**
 * 
 */
package imo.com.logic.offre.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import imo.com.logic.IGeneriqueMapper;
import imo.com.logic.offre.dto.MobileDto;
import imo.com.model.mobile.MobileEntity;

/**
 * @author balde
 *
 */
@Component
public class MobileMapper implements IGeneriqueMapper<MobileDto, MobileEntity> {

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public MobileDto asObjectDto(MobileEntity in) {
		return modelMapper.map(in, MobileDto.class);
	}

	@Override
	public MobileEntity asObjectEntity(MobileDto in) {
		return modelMapper.map(in, MobileEntity.class);
	}

}
