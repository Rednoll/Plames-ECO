package enterprises.inwaiders.plames.eco.web.security;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import enterprises.inwaiders.plames.eco.domain.credential.PlamesCredential;
import enterprises.inwaiders.plames.eco.domain.user.User;

@Controller
public class RegisterPageController {
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@GetMapping("/register")
	public String mainPage(Model model) {
		
		return "register";
	}
	
	@PostMapping(value = "/register", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<Boolean> register(UserRegisterForm userData) {
		
		User user = User.create();
			user.setNickname(userData.nickname);
	
			PlamesCredential credential = PlamesCredential.create();
				credential.setLogin(userData.login);
				credential.setPassword(encoder.encode(userData.pass).getBytes());
				
			user.getCredentials().setMain(credential);
			
			user.getEmailsStorage().setPriorityEmail(userData.email);
			
		user.save();
				
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
