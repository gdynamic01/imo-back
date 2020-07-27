package com.test.allObjects;

import java.util.ArrayList;
import java.util.List;

import imo.com.model.enums.TypeUtilisateurEnum;
import imo.com.model.info.RepresentantLegal;
import imo.com.model.utilisateur.Role;
import imo.com.model.utilisateur.RoleUserEnum;
import imo.com.model.utilisateur.SexeEnum;
import imo.com.model.utilisateur.*;
import imo.com.repo.utilisateur.RoleRepository;
import imo.com.repo.utilisateur.UserRepository;

public interface IUtilisateursTest {

	static final String emailParticulier = "test2@yahoo.fr";

	static final String emailProfessionnel = "professionel@yahoo.fr";

	/**
	 * creation particulier
	 * 
	 * @return entity
	 */
	default UserPhysiqueEntity creationParticulier(UserRepository userRepo, RoleRepository roleRepository) {

		UserPhysiqueEntity user = new UserPhysiqueEntity();
		RepresentantLegal repr = new RepresentantLegal();
		List<RoleUserEnum> roles = new ArrayList<>();
		List<Role> role = new ArrayList<>();
		repr.setNom("BAH");
		repr.setPrenom("Mata");
		repr.setSexe(SexeEnum.F);
		user.setRepresentantLegal(repr);
		user.setEmail(emailParticulier);
		user.setEnabled(true);
		user.setPassword("testtest");
		roles.add(RoleUserEnum.USER_PHYSIQUE);
		role = roleRepository.findByRoleEnumIn(roles);
		user.setTypeUtilisateur(TypeUtilisateurEnum.PARTICULIER);
		user.setRoles(role);

		return userRepo.save(user);
	}

	/**
	 * creation professionnel
	 * 
	 * @return entity
	 */
	default UserMoralEntity creationProfessionnel(UserRepository userRepo, RoleRepository roleRepository) {

		UserMoralEntity professionnel = new UserMoralEntity();
		RepresentantLegal repr = new RepresentantLegal();
		List<RoleUserEnum> roles = new ArrayList<>();
		List<Role> role = new ArrayList<>();

		repr.setNom("BALDE");
		repr.setPrenom("Mamadou");
		repr.setSexe(SexeEnum.M);
		professionnel.setEmail(emailProfessionnel);
		professionnel.setRepresentantLegal(repr);
		professionnel.setPassword("testtest");
		professionnel.setEnabled(true);
		professionnel.setSiret("215468L");
		roles.add(RoleUserEnum.USER_MORAL);

		role = roleRepository.findByRoleEnumIn(roles);
		professionnel.setTypeUtilisateur(TypeUtilisateurEnum.PARTICULIER);
		professionnel.setRoles(role);

		return userRepo.save(professionnel);
	}
}
