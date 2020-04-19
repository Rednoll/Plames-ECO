package enterprises.inwaiders.plames.eco.web.security;

public class UserRegisterForm {

	public String nickname = null;
	public String login = null;
	public String email = null;
	public String pass = null;

	public void setNickname(String name) {
		
		this.nickname = name;
	}
	
	public void setLogin(String login) {
		
		this.login = login;
	}
	
	public void setEmail(String email) {
		
		this.email = email;
	}
	
	public void setPass(String pass) {
		
		this.pass = pass;
	}
}
