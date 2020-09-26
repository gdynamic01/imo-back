package com.test.allObjects;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import imo.com.model.adresse.Adresse;
import imo.com.model.enums.SanitaireEnum;
import imo.com.model.enums.TypeBienImmobilierEnum;
import imo.com.model.enums.TypeOffreEnum;
import imo.com.model.enums.TypeServiceOffre;
import imo.com.model.enums.TypeUtilisateurEnum;
import imo.com.model.immobilier.ImmobilierEntity;
import imo.com.model.mobile.MobileEntity;
import imo.com.model.pays.PaysEntity;
import imo.com.model.photo.PhotosEntity;
import imo.com.model.representant_legal.RepresentantLegal;
import imo.com.model.utilisateur.AppUser;
import imo.com.model.utilisateur.Role;
import imo.com.model.utilisateur.RoleUserEnum;
import imo.com.model.utilisateur.SexeEnum;
import imo.com.model.utilisateur.UserMoralEntity;
import imo.com.model.utilisateur.UserPhysiqueEntity;
import imo.com.model.ville.VilleEntity;
import imo.com.repo.adresse.PaysRepository;
import imo.com.repo.utilisateur.RoleRepository;
import imo.com.repo.utilisateur.UserRepository;

public interface IGeneralTest {

	static final String emailParticulier = "test2@yahoo.fr";

	static final String emailProfessionnel = "professionel@yahoo.fr";
	
	static final String emailParticulierNonActif = "fakeEmailNotActif@yahoo.fr";

	static final String emailBadCredential = "emailBadCredential@yahoo.fr";
	
	/**
	 * creation particulier
	 * 
	 * @return entity
	 */
	default UserPhysiqueEntity creationParticulier(UserRepository userRepo, RoleRepository roleRepository, BCryptPasswordEncoder bcryptPassword) {
		UserPhysiqueEntity entity = initUserPhysiqueEntity(roleRepository, true, emailParticulier, bcryptPassword);
		return userRepo.saveAndFlush(entity);
	}
	
	/**
	 * creation particulier inactif
	 * 
	 * @return entity
	 */
	default UserPhysiqueEntity creationParticulierNonActif(UserRepository userRepo, RoleRepository roleRepository, BCryptPasswordEncoder bcryptPassword) {
		UserPhysiqueEntity entity = initUserPhysiqueEntity(roleRepository, false, emailParticulierNonActif, bcryptPassword);
		return userRepo.saveAndFlush(entity);
	}

	/**
	 * creation professionnel
	 * 
	 * @return entity
	 */
	default UserMoralEntity creationProfessionnel(UserRepository userRepo, RoleRepository roleRepository, BCryptPasswordEncoder bcryptPassword) {
		UserMoralEntity entity = initUserMoralEntity(roleRepository, true, emailProfessionnel, bcryptPassword);
		return userRepo.saveAndFlush(entity);
	}
	
	/**
	 * 
	 * @param userRepo
	 * @param roleRepository
	 * @param bcryptPassword
	 * @return UserPhysiqueEntity
	 */
	default UserPhysiqueEntity creationParticulierAvecMotDePasseNonCrypter(UserRepository userRepo, RoleRepository roleRepository, BCryptPasswordEncoder bcryptPassword) {
		UserPhysiqueEntity entity = initUserPhysiqueEntity(roleRepository, true, emailBadCredential, bcryptPassword);
		entity.setPassword("badCredential");
		return userRepo.saveAndFlush(entity);
	}
	
	/**
	 * 
	 * @param roleRepository
	 * @param isActif
	 * @param email
	 * @param bcryptPassword
	 * @return UserMoralEntity
	 */
	default UserMoralEntity initUserMoralEntity(RoleRepository roleRepository, boolean isActif, String email, BCryptPasswordEncoder bcryptPassword) {
		UserMoralEntity professionnel = new UserMoralEntity();
		RepresentantLegal repr = new RepresentantLegal();
		List<RoleUserEnum> roles = new ArrayList<>();
		List<Role> role = new ArrayList<>();

		repr.setNom("BALDE");
		repr.setPrenom("Mamadou");
		repr.setSexe(SexeEnum.M);
		professionnel.setEmail(email);
		professionnel.setRepresentantLegal(repr);
		professionnel.setPassword(bcryptPassword.encode("testtest"));
		professionnel.setEnabled(isActif);
		professionnel.setSiret("215468L");
		roles.add(RoleUserEnum.ROLE_USER_MORAL);

		role = roleRepository.findByRoleEnumIn(roles);
		professionnel.setTypeUtilisateur(TypeUtilisateurEnum.ENTREPRISE);
		professionnel.setRoles(role);
		
		return professionnel;
	}
	
	/**
	 * 
	 * @param roleRepository
	 * @param isActif
	 * @param email
	 * @param bcryptPassword
	 * @return UserPhysiqueEntity
	 */
	default UserPhysiqueEntity initUserPhysiqueEntity(RoleRepository roleRepository, boolean isActif, String email, BCryptPasswordEncoder bcryptPassword) {
		UserPhysiqueEntity userPhysique = new UserPhysiqueEntity();
		RepresentantLegal repr = new RepresentantLegal();
		List<RoleUserEnum> roles = new ArrayList<>();
		List<Role> role = new ArrayList<>();
		repr.setNom("BAH");
		repr.setPrenom("Mata");
		repr.setSexe(SexeEnum.F);
		userPhysique.setRepresentantLegal(repr);
		userPhysique.setEmail(email);
		userPhysique.setEnabled(isActif);
		userPhysique.setPassword(bcryptPassword.encode("testtest"));
		roles.add(RoleUserEnum.ROLE_USER_PHYSIQUE);
		role = roleRepository.findByRoleEnumIn(roles);
		userPhysique.setTypeUtilisateur(TypeUtilisateurEnum.PARTICULIER);
		userPhysique.setRoles(role);
		
		return userPhysique;
	}

	/**
	 * 
	 * @param userRepo
	 * @return ImmobilierEntity
	 */
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
	
	/**
	 * 
	 * @param userRepo
	 * @return MobileEntity
	 */
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
	
	// create ville and pays
	default void createPays(PaysRepository paysRepository) {
		VilleEntity ville = new VilleEntity();
		ville.setCodePostal(94140);
		ville.setNomVille("AlfortVille");
		
		List<VilleEntity> villes = new ArrayList<>();
		villes.add(ville);
		
		PaysEntity pays = new PaysEntity();
		pays.setNomPays("France");
		pays.setVilles(villes);
		
		paysRepository.saveAndFlush(pays);
		
	}
}
