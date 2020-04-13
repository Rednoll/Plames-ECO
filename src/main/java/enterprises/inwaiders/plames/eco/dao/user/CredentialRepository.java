package enterprises.inwaiders.plames.eco.dao.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import enterprises.inwaiders.plames.eco.domain.credential.Credential;

@Repository
public interface CredentialRepository extends JpaRepository<Credential, Long>{

}
