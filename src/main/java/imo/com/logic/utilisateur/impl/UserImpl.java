/**
 * 
 */
package imo.com.logic.utilisateur.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import imo.com.logic.adresse.mapper.AdresseMapper;
import imo.com.logic.utilisateur.dto.AdresseDto;
import imo.com.model.pays.PaysEntity;
import imo.com.repo.adresse.PaysRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.transaction.annotation.Transactional;

import imo.com.general.ConstantesUtils;
import imo.com.general.config.JwtTokenUtil;
import imo.com.general.config.UsersDetailsServicesImpl;
import imo.com.logic.FonctialiterCommunes;
import imo.com.logic.utilisateur.CheckFieldsUser;
import imo.com.logic.utilisateur.IUser;
import imo.com.logic.utilisateur.dto.UserDto;
import imo.com.logic.utilisateur.dto.UserMoralDto;
import imo.com.logic.utilisateur.dto.UserPhysiqueDto;
import imo.com.logic.utilisateur.mapper.UserMapper;
import imo.com.logic.utilisateur.mapper.UserMoralMapper;
import imo.com.model.utilisateur.AppUser;
import imo.com.model.utilisateur.Role;
import imo.com.model.utilisateur.RoleUserEnum;
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
 */
@Service
public class UserImpl implements IUser {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserImpl.class);
	private final AuthenticationManager authenticationManager;
	private final UsersDetailsServicesImpl userDetailsService;
	private final JwtTokenUtil jwtTokenUtil;
	private final BCryptPasswordEncoder bcrypte;
	private final UserMoralMapper mapperProfessionnel;
	private final RoleRepository roleRepository;
	private final UserMoralRepository userMoralrepo;
	private final UserRepository userRepo;
	private final UserMapper mapperParticulier;
	private final PaysRepository paysRepository;
	private final AdresseMapper adresseMapper;
	private final UserPhysiqueRepository userPhysiqueRepo;

	@Autowired
	public UserImpl(AuthenticationManager authenticationManager, UsersDetailsServicesImpl userDetailsService,
			JwtTokenUtil jwtTokenUtil, BCryptPasswordEncoder bcrypte, UserMoralMapper mapperProfessionnel,
			RoleRepository roleRepository, UserMoralRepository userMoralrepo, UserRepository userRepo,
			UserMapper mapperParticulier, PaysRepository paysRepository, AdresseMapper adresseMapper,
			UserPhysiqueRepository userPhysiqueRepo) {
		this.authenticationManager = authenticationManager;
		this.userDetailsService = userDetailsService;
		this.jwtTokenUtil = jwtTokenUtil;
		this.bcrypte = bcrypte;
		this.mapperProfessionnel = mapperProfessionnel;
		this.roleRepository = roleRepository;
		this.userMoralrepo = userMoralrepo;
		this.userRepo = userRepo;
		this.mapperParticulier = mapperParticulier;
		this.paysRepository = paysRepository;
		this.adresseMapper = adresseMapper;
		this.userPhysiqueRepo = userPhysiqueRepo;
	}

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

	@Override
	@Transactional
	public ImoResponse<UserMoralDto> registration(UserMoralDto dto) throws UnexpectedRollbackException {

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
				this.userMoralrepo.saveAndFlush(entity);
				createPays(dto.getAdresse());
				FonctialiterCommunes.setImoResponse(imoResponse, HttpStatus.OK.value(),
						ConstantesUtils.MESSAGE_INSCRIPTION_REUSSI, null);
			} catch (Exception e) {
				LOGGER.warn("---------- [ Erreur lors de la creation du professionel ] :" + e.getCause().getCause());
				FonctialiterCommunes.messageErreur = ConstantesUtils
						.contrainteMessage(e.getCause().getCause().getMessage());
				FonctialiterCommunes.setImoResponse(imoResponse, HttpStatus.INTERNAL_SERVER_ERROR.value(),
						ConstantesUtils.contrainteMessage(e.getCause().getCause().getMessage()), null);
			}
		}

		return imoResponse;
	}

	@Override
	@Transactional
	public ImoResponse<UserPhysiqueDto> registration(UserPhysiqueDto dto) throws UnexpectedRollbackException {

		CheckFieldsUser checkUser = new CheckFieldsUser();
		ImoResponse<UserPhysiqueDto> imoResponse = new ImoResponse<>();
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
				this.userPhysiqueRepo.saveAndFlush(entity);
				createPays(dto.getAdresse());
				FonctialiterCommunes.setImoResponse(imoResponse, HttpStatus.OK.value(),
						ConstantesUtils.MESSAGE_INSCRIPTION_REUSSI, null);
				LOGGER.info("---------- [ creation de l'utilisateur ] :" + dto.getEmail() + " avec succès");
			} catch (Exception e) {
				LOGGER.warn("---------- [ Erreur lors de la creation du particulier ] :" + e.getCause().getCause());
				FonctialiterCommunes.messageErreur = ConstantesUtils
						.contrainteMessage(e.getCause().getCause().getMessage());
				FonctialiterCommunes.setImoResponse(imoResponse, HttpStatus.INTERNAL_SERVER_ERROR.value(),
						ConstantesUtils.contrainteMessage(e.getCause().getCause().getMessage()), null);
			}
		}
		return imoResponse;
	}

	@Override
	public ImoResponse<String> getEmail(String email) {
		ImoResponse<String> imoEmails = new ImoResponse<>();
		this.setResponseByEmail(email, imoEmails, null, "");
		return imoEmails;
	}

	private void authenticate(String email, String password) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
		} catch (BadCredentialsException e) {
			throw new BadCredentialsException("INVALID_CREDENTIALS", e);
		}
	}

	@Override
	public ImoResponse<RoleUserEnum> getRolesByEmail(String email) {
		ImoResponse<RoleUserEnum> imoRoles = new ImoResponse<>();
		this.setResponseByEmail(email, null, imoRoles, "roles");
		return imoRoles;
	}

	private void setResponseByEmail(String email, ImoResponse<String> imoEmails, ImoResponse<RoleUserEnum> imoRoles,
			String typeResult) {
		AppUser user = userRepo.findByEmail(email);
		int codeStatus = user != null ? HttpStatus.OK.value() : HttpStatus.NO_CONTENT.value();
		if (user != null) {
			switch (typeResult) {
			case "roles":
				List<RoleUserEnum> roles = user.getRoles().stream().map(roleEnum -> {
					return roleEnum.getRoleEnum();
				}).collect(Collectors.toList());
				FonctialiterCommunes.setImoResponse(imoRoles, codeStatus, null, roles);
				break;
			default:
				List<String> emails = new ArrayList<>();
				emails.add(user.getEmail());
				FonctialiterCommunes.setImoResponse(imoEmails, codeStatus, null, emails);
			}
		} else {
			if (imoRoles != null) {
				FonctialiterCommunes.setImoResponse(imoRoles, codeStatus, null, null);
			} else {
				FonctialiterCommunes.setImoResponse(imoEmails, codeStatus, null, null);
			}
		}

	}

	private void createPays(AdresseDto dto) {
		PaysEntity paysEntity = paysRepository.findByNomPays(dto.getPays());
		if (paysEntity == null) {
			// creation Pays d'offre
			FonctialiterCommunes.createPaysAndVille(dto, paysRepository, adresseMapper);
		}
	}

}
