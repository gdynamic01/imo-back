/**
 * 
 */
package imo.com.general.config;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import imo.com.model.utilisateur.AppUser;
import imo.com.repo.utilisateur.UserRepository;

/**
 * @author balde
 *
 */

@Service
public class UsersDetailsServicesImpl implements UserDetailsService {

	@Autowired
	UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String email) {
		String tokens[] = email.split(" ");
		email = tokens.length == 1 ? email : tokens[tokens.length-1];
		AppUser user = this.repository.findByEnabledTrueAndEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("L'adresse " + email + " N'existe pas");
		}
		Collection<GrantedAuthority> authories = new ArrayList<>();
		user.getRoles().forEach(r -> {
			authories.add(new SimpleGrantedAuthority(r.getRoleEnum().name()));
		});
		return new User(user.getRepresentantLegal().getNom() + " " + user.getRepresentantLegal().getPrenom()+ " " +user.getEmail(),
				user.getPassword(), authories);
	}

}
