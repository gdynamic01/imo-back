/**
 * 
 */
package imo.com.logic;

import java.util.ArrayList;
import java.util.List;

import imo.com.logic.adresse.dto.PaysDto;
import imo.com.logic.adresse.dto.VilleDto;
import imo.com.logic.adresse.mapper.AdresseMapper;
import imo.com.logic.offre.dto.OffreDto;
import imo.com.logic.utilisateur.dto.AdresseDto;
import imo.com.model.pays.PaysEntity;
import imo.com.repo.adresse.PaysRepository;
import imo.com.response.ImoResponse;

/**
 * Cette classe gère les methodes communes du projet
 * 
 * @author mbalde
 */
public abstract class FonctialiterCommunes {

	public static String messageErreur = "";

	/**
	 * @param imo     objet response
	 * @param status  httpStatus
	 * @param message erreur
	 * @param list    resultat
	 */
	public static <D> void setImoResponse(ImoResponse<D> imo, int status, String message, List<D> list) {
		imo.setStatus(status);
		imo.setMessageResponse(message);
		imo.setResult(list);
		if (list != null && !list.isEmpty() && list.get(0) instanceof OffreDto) {
			long nbOffreProfessionnel = list.stream().filter(offre -> offre != null
					&& !"String".equals(offre.getClass().getSimpleName()) && ((OffreDto) offre).isImmobilier()).count();
			long nbOffreParticulier = list.stream().filter(offre -> offre != null
					&& !"String".equals(offre.getClass().getSimpleName()) && ((OffreDto) offre).isMobile()).count();
			imo.setNbOffre(list != null ? list.size() : 0);
			imo.setNbOffreParticulier(nbOffreParticulier);
			imo.setNbOffreProfessionnel(nbOffreProfessionnel);
		}
	}

	public static void createPaysAndVille(AdresseDto adresseDto, PaysRepository paysRepository,
			AdresseMapper adresseMapper) {
		List<VilleDto> listVilleDto = new ArrayList<>();
		PaysDto paysDto = new PaysDto();
		VilleDto villeDto = new VilleDto();
		paysDto.setNomPays(adresseDto.getPays());
		villeDto.setCodePostal(adresseDto.getCodePostal());
		villeDto.setNomVille(adresseDto.getVille());
		listVilleDto.add(villeDto);
		paysDto.setVilles(listVilleDto);
		PaysEntity entity = adresseMapper.asObjectEntity(paysDto);
		paysRepository.saveAndFlush(entity);
	}

}
