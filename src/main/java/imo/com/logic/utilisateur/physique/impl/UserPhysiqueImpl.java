/**
 * 
 */
package imo.com.logic.utilisateur.physique.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import imo.com.general.ConstantesUtils;
import imo.com.logic.utilisateur.CheckFieldsUser;
import imo.com.logic.utilisateur.FonctialiterCommunes;
import imo.com.logic.utilisateur.physique.IUserPhysique;
import imo.com.logic.utilisateur.physique.dto.UserPhysiqueDto;
import imo.com.logic.utilisateur.physique.mapper.UserPhysiqueMapper;
import imo.com.model.utilisateur.Role;
import imo.com.model.utilisateur.UserPhysiqueEntity;
import imo.com.repo.utilisateur.RoleRepository;
import imo.com.repo.utilisateur.physique.UserPhysiqueRepository;
import imo.com.response.ImoResponse;

/**
 * @author mbalde
 *
 */
@Component
public class UserPhysiqueImpl implements IUserPhysique {

	/** mapper userPhysique */
	@Inject
	private UserPhysiqueMapper mapper;

	/** role repo */
	@Inject
	private RoleRepository roleRepository;

	/** userPhysique repo */
	@Inject
	private UserPhysiqueRepository userPhysiqueRepo;

	@Override
	public ImoResponse<UserPhysiqueDto> registration(UserPhysiqueDto dto) {

		CheckFieldsUser checkUser = new CheckFieldsUser();
		List<UserPhysiqueDto> results = new ArrayList<>();
		ImoResponse<UserPhysiqueDto> imoResponse = new ImoResponse<>();
		if (checkUser.checkObjectDto(dto, imoResponse))
			FonctialiterCommunes.setImoResponse(imoResponse, HttpStatus.BAD_REQUEST.value(),
					ConstantesUtils.MESSAGE_ERREUR_FORMULAIRE_INSCRIPTION, results);
		else {
			UserPhysiqueEntity entity = this.mapper.asObjectEntity(dto);
			List<Role> roles = new ArrayList<>();
			if (dto.getRoles() != null && !dto.getRoles().isEmpty())
				roles = roleRepository.findByRoleEnumIn(dto.getRoles());
			entity.setRoles(roles);
			try {
				this.userPhysiqueRepo.save(entity);
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
