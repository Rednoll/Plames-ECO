package enterprises.inwaiders.plames.eco.domain.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import enterprises.inwaiders.plames.eco.domain.user.User;

@Service
@Transactional
public class PlamesUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
	
		User user = User.findByCredentialsMainLogin(login);
		
		if(user == null) {
			
			throw new UsernameNotFoundException("User with login: "+login+" not found!");
		}
		
		return user.getUserDetails();
	}
}
