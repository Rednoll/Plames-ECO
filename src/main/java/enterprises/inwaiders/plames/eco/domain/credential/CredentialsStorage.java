package enterprises.inwaiders.plames.eco.domain.credential;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.OneToMany;

import org.springframework.transaction.support.TransactionSynchronizationManager;

import enterprises.inwaiders.plames.eco.dto.credential.CredentialDto;
import enterprises.inwaiders.plames.eco.dto.credential.CredentialsStorageDto;

@Embeddable
public class CredentialsStorage {

	@OneToMany(cascade = CascadeType.ALL)
	private Set<Credential> credentials = new HashSet<>();

	public void loadFromDto(CredentialsStorageDto dto) {
		
		for(CredentialDto credDto : dto.credentials) {
			
			Credential cred = Credential.findById(credDto.id);
				cred.loadFromDto(credDto);
				
			credentials.add(cred);
		}
	}
	
	public CredentialsStorageDto toDto() {
		
		CredentialsStorageDto dto = new CredentialsStorageDto();
			this.toDto(dto);
		
		return dto;
	}
	
	public void toDto(CredentialsStorageDto dto) {
		
		dto.credentials = new HashSet<>();
	
		for(Credential cred : credentials) {
			
			dto.credentials.add(cred.toDto());
		}
	}
	
	public void addCredential(Credential cred) {
		
		credentials.add(cred);
	}
	
	public <T extends Credential> T getCredential(Class<T> clazz) {
	
		for(Credential cred : credentials) {
			
			if(clazz.isAssignableFrom(cred.getClass())) {
				
				return (T) cred;
			}
		}
		
		return null;
	}
	
	public Set<Credential> getCredentials() {
	
		return this.credentials;
	}
}
