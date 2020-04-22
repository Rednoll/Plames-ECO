package enterprises.inwaiders.plames.eco.dao.roles;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enterprises.inwaiders.plames.eco.domain.roles.Role;

@Service
public class RoleRepositoryInjector {

	@Autowired
	private RoleRepository repository;

	@PostConstruct
	private void inject() {
		
		Role.setRepository(repository);
	}
}
