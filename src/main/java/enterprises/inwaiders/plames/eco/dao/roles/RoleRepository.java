package enterprises.inwaiders.plames.eco.dao.roles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import enterprises.inwaiders.plames.eco.domain.roles.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

	public Role findByName(String name);
}
