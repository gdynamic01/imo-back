/**
 * 
 */
package imo.com.resource.api.user;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import imo.com.logic.utilisateur.moral.dto.UserMoralDto;
import imo.com.response.ImoResponse;

/**
 * @author mbalde
 *
 */
@RequestMapping(path = "/immo")
public interface IUserMoralApi {

    /**
     * @param userMoralDto
     * @return responseEntity
     */
    @PostMapping(path = "/inscription/professionnel", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ImoResponse<UserMoralDto>> creationCompte(@RequestBody UserMoralDto userMoralDto);
}
