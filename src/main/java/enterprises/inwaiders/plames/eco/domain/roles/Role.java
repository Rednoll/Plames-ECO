package enterprises.inwaiders.plames.eco.domain.roles;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import enterprises.inwaiders.plames.eco.dao.roles.RoleRepository;

@Entity(name = "Role")
@Table(name = "Role")
public class Role {
	
	private static RoleRepository repository;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "name")
	private String name = null;
		
	@ManyToMany()
	@JoinTable(name = "roles_privileges_mtm", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "privilege_id"))
	private Set<Privilege> privileges = new HashSet<>();
	
	public Role() {
		
	}
	
	public Role(String name) {
		this();
		
		this.name = name;
	}
	
	public Set<Privilege> getPrivileges() {
	
		return this.privileges;
	}
	
	public String getName() {
		
		return this.name;
	}
	
	public Long getId() {
		
		return this.id;
	}
	
	public void save() {
		
		repository.save(this);
	}
	
	public static Role create(String name) {
		
		Role role = new Role(name);
		
		role = repository.save(role);
		
		return role;
	}
	
	public static Role findByName(String name) {
		
		return repository.findByName(name);
	}
	
	public static void setRepository(RoleRepository rep) {
		
		repository = rep;
	}
}
