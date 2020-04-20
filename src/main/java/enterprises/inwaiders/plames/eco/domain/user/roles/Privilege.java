package enterprises.inwaiders.plames.eco.domain.user.roles;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Privilege")
@Table(name = "Privilege")
public class Privilege {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	public Long getId() {
		
		return this.id;
	}
}
