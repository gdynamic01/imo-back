/**
 * 
 */
package imo.com.logic.utilisateur.moral.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import imo.com.general.ConstantesUtils;
import imo.com.logic.utilisateur.CheckFieldsUser;
import imo.com.logic.utilisateur.FonctialiterCommunes;
import imo.com.logic.utilisateur.moral.IUserMoral;
import imo.com.logic.utilisateur.moral.dto.UserMoralDto;
import imo.com.logic.utilisateur.moral.mapper.UserMoralMapper;
import imo.com.model.utilisateur.Role;
import imo.com.model.utilisateur.UserMoralEntity;
import imo.com.repo.utilisateur.RoleRepository;
import imo.com.repo.utilisateur.moral.UserMoralRepository;
import imo.com.response.ImoResponse;

/**
 * @author mbalde
 *
 */
@Component
public class UserMoralImpl implements IUserMoral {

	/** mapper userMoral */
	@Inject
	private UserMoralMapper mapper;

	/** role repo */
	@Inject
	private RoleRepository roleRepository;

	/** repo userMoral */
	@Inject
	private UserMoralRepository userMoralrepo;

	@Override
	public ImoResponse<UserMoralDto> registration(UserMoralDto dto) {

		CheckFieldsUser checkUser = new CheckFieldsUser();
		List<UserMoralDto> results = new ArrayList<>();
		ImoResponse<UserMoralDto> imoResponse = new ImoResponse<>();
		if (checkUser.checkObjectDto(dto, imoResponse))
			FonctialiterCommunes.setImoResponse(imoResponse, HttpStatus.BAD_REQUEST.value(),
					ConstantesUtils.MESSAGE_ERREUR_FORMULAIRE_INSCRIPTION, results);
		else {
			UserMoralEntity entity = this.mapper.asObjectEntity(dto);
			List<Role> roles = new ArrayList<>();
			if (dto.getRoles() != null && !dto.getRoles().isEmpty())
				roles = roleRepository.findByRoleEnumIn(dto.getRoles());
			entity.setRoles(roles);
			try {
				this.userMoralrepo.save(entity);
				FonctialiterCommunes.setImoResponse(imoResponse, HttpStatus.OK.value(),
						ConstantesUtils.MESSAGE_INSCRIPTION_REUSSI, results);
			} catch (Exception e) {
				FonctialiterCommunes.setImoResponse(imoResponse, HttpStatus.INTERNAL_SERVER_ERROR.value(),
						ConstantesUtils.contrainteMessage(e.getCause().getCause().getMessage()), results);
			}
		}

		return imoResponse;
	}

}
