package enterprises.inwaiders.plames.eco.dao.credential;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enterprises.inwaiders.plames.eco.domain.credential.PlamesCredential;

@Service
public class PlamesCredentialRepositoryInjector {

	@Autowired
	private PlamesCredentialRepository repository;
	
	@PostConstruct
	private void inject() {
		
		PlamesCredential.setRepository(repository);
	}
}
