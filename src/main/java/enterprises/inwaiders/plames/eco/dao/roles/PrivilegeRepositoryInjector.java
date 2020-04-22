package enterprises.inwaiders.plames.eco.dao.roles;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enterprises.inwaiders.plames.eco.domain.roles.Privilege;

@Service
public class PrivilegeRepositoryInjector {

	@Autowired
	private PrivilegeRepository repository;

	@PostConstruct
	private void inject() {
		
		Privilege.setRepository(repository);
	}
}
