package enterprises.inwaiders.plames.eco.dao.user;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enterprises.inwaiders.plames.eco.domain.credential.Credential;

@Service
public class CredentialRepositoryInjector {

	@Autowired
	private CredentialRepository repository;
	
	@PostConstruct
	private void inject() {
		
		Credential.setRepository(repository);
	}
}
