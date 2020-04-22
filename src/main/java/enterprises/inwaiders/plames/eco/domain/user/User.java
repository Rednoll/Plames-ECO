package enterprises.inwaiders.plames.eco.domain.user;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.AssociationOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import enterprises.inwaiders.plames.eco.dao.user.UserRepository;
import enterprises.inwaiders.plames.eco.domain.credential.Credential;
import enterprises.inwaiders.plames.eco.domain.credential.CredentialsStorage;
import enterprises.inwaiders.plames.eco.domain.credential.PlamesCredential;
import enterprises.inwaiders.plames.eco.domain.roles.Privilege;
import enterprises.inwaiders.plames.eco.domain.roles.Role;
import enterprises.inwaiders.plames.eco.domain.roles.additionals.RolesStorage;
import enterprises.inwaiders.plames.eco.domain.user.additionals.EmailsStorage;
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
	@AssociationOverride(name = "roles", joinTable = @JoinTable(name = "users_roles_mtm", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id")))
	private RolesStorage roles = new RolesStorage();
	
	@Embedded
	private CredentialsStorage credentials = new CredentialsStorage();

	@Embedded
	private EmailsStorage emails = new EmailsStorage();
	
	public User() {
		
	}
	
	@PostConstruct
	private void postConstruct() {
		
		if(roles.isEmpty()) {
			
			roles.add(Role.findByName("USER"));
		}
	}
	
	public UserDetails getUserDetails() {
		
		List<GrantedAuthority> grantedAuthority = getGrantedAuthority();
		
		PlamesCredential credential = credentials.getMain();
		
		UserDetails user = new org.springframework.security.core.userdetails.User(credential.getLogin(), new String(credential.getPassword()), grantedAuthority);
	
		return user;
	}
	
	private List<GrantedAuthority> getGrantedAuthority() {
		
		List<GrantedAuthority> result = new ArrayList<>();
		
		for(Role role : roles) {
			
			for(Privilege privilege : role.getPrivileges()) {
				
				result.add(new SimpleGrantedAuthority(privilege.getName()));
			}
			
			result.add(new SimpleGrantedAuthority("ROLE_"+role.getName()));
		}
		
		return result;
	}
	
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
//		dto.credentials = credentials.toDto();
	}
	
	public void setNickname(String name) {
		
		this.nickname = name;
	}
	
	public String getNickname() {
		
		return this.nickname;
	}
	
	public EmailsStorage getEmailsStorage() {
		
		return this.emails;
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
	
	public static User findByCredentialsMainLogin(String login) {
		
		return repository.findByCredentialsMainLogin(login);
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