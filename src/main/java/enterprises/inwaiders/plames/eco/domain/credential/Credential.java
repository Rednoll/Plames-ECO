package enterprises.inwaiders.plames.eco.domain.credential;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import enterprises.inwaiders.plames.eco.dao.user.CredentialRepository;
import enterprises.inwaiders.plames.eco.dto.credential.CredentialDto;

@Entity(name = "Credential")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Credential<DTO extends CredentialDto> {
	
	protected static CredentialRepository repository;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	public void loadFromDto(DTO dto) {
		
	}
	
	public abstract DTO toDto();
	
	public void toDto(CredentialDto dto) {
		
		dto.id = id;
	}
	
	public Long getId() {
		
		return this.id;
	}
	
	public void save() {
		
		repository.save(this);
	}
	
	public static Credential findById(Long id) {
		
		return repository.getOne(id);
	}
	
	public static void setRepository(CredentialRepository rep) {
		
		repository = rep;
	}
}
