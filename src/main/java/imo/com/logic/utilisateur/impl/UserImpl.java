/**
 * 
 */
package imo.com.logic.utilisateur.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import imo.com.general.ConstantesUtils;
import imo.com.general.config.JwtTokenUtil;
import imo.com.general.config.UsersDetailsServicesImpl;
import imo.com.logic.FonctialiterCommunes;
import imo.com.logic.utilisateur.CheckFieldsUser;
import imo.com.logic.utilisateur.IUser;
import imo.com.logic.utilisateur.dto.UserDto;
import imo.com.logic.utilisateur.dto.UserMoralDto;
import imo.com.logic.utilisateur.mapper.UserMapper;
import imo.com.logic.utilisateur.mapper.UserMoralMapper;
import imo.com.model.utilisateur.AppUser;
import imo.com.model.utilisateur.Role;
import imo.com.model.utilisateur.UserMoralEntity;
import imo.com.model.utilisateur.UserPhysiqueEntity;
import imo.com.repo.utilisateur.RoleRepository;
import imo.com.repo.utilisateur.UserRepository;
import imo.com.repo.utilisateur.moral.UserMoralRepository;
import imo.com.repo.utilisateur.physique.UserPhysiqueRepository;
import imo.com.response.ImoResponse;
import imo.com.response.JwtTokenResponse;

/**
 * @author balde
 *
 */
@Component
@Transactional
public class UserImpl implements IUser {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserImpl.class);

	@Autowired
	private AuthenticationManager authenticationManager;

	/** info utilisateur connecté */
	@Autowired
	private UsersDetailsServicesImpl userDetailsService;

	/** gestion du token (generation, durée de vie ...) */
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	/** algo de crypto */
	@Inject
	private BCryptPasswordEncoder bcrypte;

	/** mapper userMoral */
	@Inject
	private UserMoralMapper mapperProfessionnel;

	/** role repo */
	@Inject
	private RoleRepository roleRepository;

	/** repo userMoral */
	@Inject
	private UserMoralRepository userMoralrepo;

	@Inject
	private UserRepository userRepo;

	/** mapper userPhysique */
	@Inject
	private UserMapper mapperParticulier;

	/** userPhysique repo */
	@Inject
	private UserPhysiqueRepository userPhysiqueRepo;

	@Override
	public ResponseEntity<JwtTokenResponse> authentification(UserDto userDto) {

		AppUser user = this.userRepo.findByEmail(userDto.getEmail());
		if (user != null && !user.isEnabled()) {
			return new ResponseEntity<>(
					new JwtTokenResponse(null, "Votre compte n'est pas activé !!!", HttpStatus.UNAUTHORIZED.value()),
					HttpStatus.UNAUTHORIZED);
		}
		authenticate(userDto.getEmail(), userDto.getPassword());
		final UserDetails userDetails = userDetailsService.loadUserByUsername(userDto.getEmail());

		final String token = jwtTokenUtil.generateToken(userDetails);
		return new ResponseEntity<>(new JwtTokenResponse(token, "Vous êtes connecté", HttpStatus.OK.value()),
				HttpStatus.OK);

	}

	private void authenticate(String email, String password) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
		}
		catch (DisabledException e) {
			throw new DisabledException("USER_DISABLED", e);
		}
		catch (BadCredentialsException e) {
			throw new BadCredentialsException("INVALID_CREDENTIALS", e);
		}
	}

	@Override
	public ImoResponse<UserMoralDto> registration(UserMoralDto dto) {

		CheckFieldsUser checkUser = new CheckFieldsUser();
		ImoResponse<UserMoralDto> imoResponse = new ImoResponse<>();
		if (checkUser.checkObjectDto(dto, imoResponse))
			FonctialiterCommunes.setImoResponse(imoResponse, HttpStatus.BAD_REQUEST.value(),
					ConstantesUtils.MESSAGE_ERREUR_FORMULAIRE_INSCRIPTION, null);
		else {
			UserMoralEntity entity = this.mapperProfessionnel.asObjectEntity(dto);
			List<Role> roles = new ArrayList<>();
			if (dto.getRoles() != null && !dto.getRoles().isEmpty()) {
				roles = roleRepository.findByRoleEnumIn(dto.getRoles());
			}
			entity.setRoles(roles);
			try {
				entity.setPassword(this.bcrypte.encode(entity.getPassword()));
				this.userMoralrepo.save(entity);
				FonctialiterCommunes.setImoResponse(imoResponse, HttpStatus.OK.value(),
						ConstantesUtils.MESSAGE_INSCRIPTION_REUSSI, null);
			}
			catch (Exception e) {
				FonctialiterCommunes.setImoResponse(imoResponse, HttpStatus.INTERNAL_SERVER_ERROR.value(),
						ConstantesUtils.contrainteMessage(e.getCause().getCause().getMessage()), null);
			}
		}

		return imoResponse;
	}

	@Override
	public ImoResponse<UserDto> registration(UserDto dto) {

		CheckFieldsUser checkUser = new CheckFieldsUser();
		ImoResponse<UserDto> imoResponse = new ImoResponse<>();
		if (checkUser.checkObjectDto(dto, imoResponse))
			FonctialiterCommunes.setImoResponse(imoResponse, HttpStatus.BAD_REQUEST.value(),
					ConstantesUtils.MESSAGE_ERREUR_FORMULAIRE_INSCRIPTION, null);
		else {
			UserPhysiqueEntity entity = this.mapperParticulier.asObjectEntity(dto);
			List<Role> roles = new ArrayList<>();
			if (dto.getRoles() != null && !dto.getRoles().isEmpty())
				roles = roleRepository.findByRoleEnumIn(dto.getRoles());
			entity.setRoles(roles);
			try {
				entity.setPassword(this.bcrypte.encode(entity.getPassword()));
				this.userPhysiqueRepo.save(entity);
				FonctialiterCommunes.setImoResponse(imoResponse, HttpStatus.OK.value(),
						ConstantesUtils.MESSAGE_INSCRIPTION_REUSSI, null);
			}
			catch (Exception e) {
				FonctialiterCommunes.setImoResponse(imoResponse, HttpStatus.INTERNAL_SERVER_ERROR.value(),
						ConstantesUtils.contrainteMessage(e.getCause().getCause().getMessage()), null);
			}
		}
		return imoResponse;
	}

}
