package enterprises.inwaiders.plames.eco.dao.user;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enterprises.inwaiders.plames.eco.domain.user.User;

@Service
public class UserRepositoryInjector {

	@Autowired
	private UserRepository repository;

	@PostConstruct
	private void inject() {
		
		User.setRepository(repository);
	}
}
