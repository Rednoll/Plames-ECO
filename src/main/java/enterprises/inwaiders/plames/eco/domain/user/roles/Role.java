package enterprises.inwaiders.plames.eco.domain.user.roles;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Role")
@Table(name = "Role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@---
	private Set<Privilege> privileges = new HashSet<>();
	
	public Long getId() {
		
		return this.id;
	}
}
