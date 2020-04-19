package enterprises.inwaiders.plames.eco.domain.credential;

import java.util.Arrays;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import enterprises.inwaiders.plames.eco.dao.credential.PlamesCredentialRepository;
import enterprises.inwaiders.plames.eco.dto.credential.PlamesCredentialDto;

@Entity(name = "PlamesCredential")
@Table(name = "plames_credentials")
public class PlamesCredential extends Credential<PlamesCredentialDto> {
	
	private static PlamesCredentialRepository repository;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "login")
	private String login = null;
	
	@Column(name = "password")
	private byte[] password = null;
	
	public void loadFromDto(PlamesCredentialDto dto) {
		
		this.login = dto.login;
		this.password = dto.password;
	}
	
	public PlamesCredentialDto toDto() {
		
		PlamesCredentialDto dto = new PlamesCredentialDto();
			this.toDto(dto);
		
		return dto;
	}
	
	public void toDto(PlamesCredentialDto dto) {
	
		super.toDto(dto);
		
		dto.login = this.login;
		dto.password = this.password;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Objects.hash(login);
		result = prime * result + Arrays.hashCode(password);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlamesCredential other = (PlamesCredential) obj;
		return Objects.equals(login, other.login) && Arrays.equals(password, other.password);
	}

	public void setLogin(String login) {
		
		this.login = login;
	}
	
	public String getLogin() {
		
		return this.login;
	}
	
	public void setPassword(byte[] password) {
		
		this.password = password;
	}
	
	public byte[] getPassword() {
		
		return this.password;
	}
	
	public void save() {
		
		repository.save(this);
	}
	
	public Long getId() {
		
		return this.id;
	}
	
	public static PlamesCredential create() {
		
		PlamesCredential cred = new PlamesCredential();
		
		cred = repository.saveAndFlush(cred);
		
		return cred;
	}
	
	public static void setRepository(PlamesCredentialRepository rep) {
		
		repository = rep;
	}
}
