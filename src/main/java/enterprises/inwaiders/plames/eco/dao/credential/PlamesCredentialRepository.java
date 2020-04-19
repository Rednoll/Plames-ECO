package enterprises.inwaiders.plames.eco.dao.credential;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import enterprises.inwaiders.plames.eco.domain.credential.PlamesCredential;

@Repository
public interface PlamesCredentialRepository extends JpaRepository<PlamesCredential, Long>{

}
