package imo.com.resource.apiImpl.utilisateur;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import imo.com.logic.utilisateur.moral.IUserMoral;
import imo.com.logic.utilisateur.moral.dto.UserMoralDto;
import imo.com.resource.api.user.IUserMoralApi;
import imo.com.response.ImoResponse;

/**
 * 
 * @author mbalde
 *
 */
@Controller
public class UserMoralController implements IUserMoralApi {

    /** inject promotteur */
    @Inject
    private IUserMoral iUserMoral;

    @Override
    public ResponseEntity<ImoResponse<UserMoralDto>> creationCompte(UserMoralDto userMoralDto) {
        ImoResponse<UserMoralDto> imoResponse = this.iUserMoral.registration(userMoralDto);
        return new ResponseEntity<>(imoResponse, HttpStatus.valueOf(imoResponse.getStatut()));
    }

}
