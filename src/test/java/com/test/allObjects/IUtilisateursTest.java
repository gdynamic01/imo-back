package com.test.allObjects;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import imo.com.model.adresse.Adresse;
import imo.com.model.enums.SanitaireEnum;
import imo.com.model.enums.TypeBienImmobilierEnum;
import imo.com.model.enums.TypeOffreEnum;
import imo.com.model.enums.TypeServiceOffre;
import imo.com.model.enums.TypeUtilisateurEnum;
import imo.com.model.immobilier.ImmobilierEntity;
import imo.com.model.info.RepresentantLegal;
import imo.com.model.mobile.MobileEntity;
import imo.com.model.photo.PhotosEntity;
import imo.com.model.utilisateur.AppUser;
import imo.com.model.utilisateur.Role;
import imo.com.model.utilisateur.RoleUserEnum;
import imo.com.model.utilisateur.SexeEnum;
import imo.com.model.utilisateur.UserMoralEntity;
import imo.com.model.utilisateur.UserPhysiqueEntity;
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

	default ImmobilierEntity creationImmobilier(UserRepository userRepo) {

		AppUser user = userRepo.findByEmail(emailProfessionnel);

		ImmobilierEntity entity = new ImmobilierEntity();
		entity.setDescription("Immo-description");
		entity.setCreateAt(LocalDate.now());
		entity.setDateDebut(LocalDate.now());
		entity.setDateFin(LocalDate.now());
		entity.setAdresse(createAdresse(new Adresse()));
		entity.setEau(true);
		entity.setElectricite(true);
		entity.setNbrePieces(4);
		entity.setParking(false);
		entity.setPiscine(false);
		entity.setPrix(123.34);
		entity.setSanitaire(SanitaireEnum.INTERIEUR);
		entity.setServiceMenage(false);
		entity.setSurface(23.4);
		entity.setTitre("immo 1");
		entity.setTypeDeBien(TypeBienImmobilierEnum.APPARTEMENT);
		entity.setTypeOffre(TypeOffreEnum.IMMOBILIER);
		entity.setTypeServiceOffre(TypeServiceOffre.LOCATION);
		entity.setUpdateAt(LocalDate.now());
		entity.setUser(user);

		return entity;
	}
	
	default MobileEntity creationMobile(UserRepository userRepo) {

		AppUser user = userRepo.findByEmail(emailProfessionnel);

		MobileEntity entity = new MobileEntity();
		entity.setDescription("mobile-description");
		entity.setCreateAt(LocalDate.now());
		entity.setDateDebut(LocalDate.now());
		entity.setDateFin(LocalDate.now());
		entity.setAdresse(createAdresse(new Adresse()));
		entity.setPrix(123.34);
		entity.setTitre("mobile 1");
		entity.setTypeOffre(TypeOffreEnum.IMMOBILIER);
		entity.setTypeServiceOffre(TypeServiceOffre.LOCATION);
		entity.setUpdateAt(LocalDate.now());
		entity.setUser(user);
		
		PhotosEntity photo_1 = new PhotosEntity();
		photo_1.setPathPhotos("c:/monDossier/tof1.png");
		
		PhotosEntity photo_2 = new PhotosEntity();
		photo_2.setPathPhotos("c:/monDossier/tof2.png");
		
		List<PhotosEntity> photos = new ArrayList<>();
		photos.add(photo_1);
		photos.add(photo_2);
		
		entity.setPhotosOffres(photos);

		return entity;
	}

	// creation adresse
	default Adresse createAdresse(Adresse adresse) {
		adresse.setPays("Guinee");
		adresse.setVille("Conakry");
		return adresse;
	}
}
