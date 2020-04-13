package enterprises.inwaiders.plames.eco.domain.user;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import enterprises.inwaiders.plames.eco.dao.user.UserRepository;
import enterprises.inwaiders.plames.eco.domain.credential.Credential;
import enterprises.inwaiders.plames.eco.domain.credential.CredentialsStorage;
import enterprises.inwaiders.plames.eco.dto.user.UserDto;

@Entity(name = "User")
@Table(name = "users")
public class User {

	private static UserRepository repository;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "nickname")
	private String nickname = null;

	@Embedded
	private CredentialsStorage credentials = new CredentialsStorage();

	public void loadFromDto(UserDto dto) {
		
		this.nickname = dto.nickname;
		this.credentials.loadFromDto(dto.credentials);
	}
	
	public UserDto toDto() {
		
		UserDto dto = new UserDto();
			this.toDto(dto);
		
		return dto;
	}
	
	public void toDto(UserDto dto) {
		
		dto.id = id;
		dto.nickname = nickname;
		dto.credentials = credentials.toDto();
	}
	
	public void setNickname(String name) {
		
		this.nickname = name;
	}
	
	public String getNickname() {
		
		return this.nickname;
	}
	
	public void addCredential(Credential cred) {
		
		this.credentials.addCredential(cred);
	}
	
	public CredentialsStorage getCredentials() {
	
		return this.credentials;
	}
	
	public Long getId() {
		
		return this.id;
	}
	
	public void save() {
		
		repository.save(this);
	}
	
	public static User create() {
		
		User user = new User();
		
		user = repository.save(user);
		
		return user;
	}
	
	public static User findById(Long id) {
		
		return repository.getOne(id);
	}
	
	public static User findByNickname(String nickname) {
		
		return repository.findByNickname(nickname);
	}
	
	public static void setRepository(UserRepository rep) {
		
		repository = rep;
	}
}