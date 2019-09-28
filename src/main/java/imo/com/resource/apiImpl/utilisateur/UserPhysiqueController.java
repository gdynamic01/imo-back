package imo.com.resource.apiImpl.utilisateur;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import imo.com.logic.utilisateur.physique.IUserPhysique;
import imo.com.logic.utilisateur.physique.dto.UserPhysiqueDto;
import imo.com.resource.api.user.IUserPhysiqueApi;
import imo.com.response.ImoResponse;

/**
 * @author mbalde
 *
 */
@Controller
public class UserPhysiqueController implements IUserPhysiqueApi {

    /** interface userPhysique */
    @Inject
    private IUserPhysique iuserPhysque;

    @Override
    public ResponseEntity<ImoResponse<UserPhysiqueDto>> creationCompte(UserPhysiqueDto userPhysiqueDto) {

        ImoResponse<UserPhysiqueDto> imoResponse = this.iuserPhysque.registration(userPhysiqueDto);
        return new ResponseEntity<>(imoResponse, HttpStatus.valueOf(imoResponse.getStatut()));
    }

}
