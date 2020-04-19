package enterprises.inwaiders.plames.eco.dao.user;

import org.springframework.data.jpa.repository.JpaRepository;

import enterprises.inwaiders.plames.eco.domain.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByNickname(String nickname);
	public User findByCredentialsMainLogin(String login);
}
