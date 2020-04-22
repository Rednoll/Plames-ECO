package enterprises.inwaiders.plames.eco.domain.roles;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import enterprises.inwaiders.plames.eco.dao.roles.PrivilegeRepository;

@Entity(name = "Privilege")
@Table(name = "Privilege")
public class Privilege {

	private static PrivilegeRepository repository;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String name = null;
	
	public Privilege() {
		
	}
	
	public Privilege(String name) {
		this();
		
		this.name = name;
	}
	
	public String getName() {
		
		return this.name;
	}
	
	public Long getId() {
		
		return this.id;
	}
	
	public static void setRepository(PrivilegeRepository rep) {
		
		repository = rep;
	}
}
