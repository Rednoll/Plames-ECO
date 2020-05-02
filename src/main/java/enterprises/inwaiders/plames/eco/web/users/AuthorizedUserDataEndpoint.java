package enterprises.inwaiders.plames.eco.web.users;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import enterprises.inwaiders.plames.eco.domain.credential.Credential;
import enterprises.inwaiders.plames.eco.domain.user.User;
import enterprises.inwaiders.plames.eco.dto.credential.CredentialLabelDto;

@RestController
@RequestMapping("/authorized/user")
public class AuthorizedUserDataEndpoint {
	
	@GetMapping("/credential_labels")
	public ResponseEntity<List<CredentialLabelDto>> getCredentialLabels(Principal principal) {
		
		if(principal == null) return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		
		List<CredentialLabelDto> dtos = new ArrayList<>();
		
		User user = User.findByCredentialsMainLogin(principal.getName());
		
		Set<Credential> credentials = user.getCredentials().getAll();
		
		for(Credential cred : credentials) {
			
			CredentialLabelDto dto = new CredentialLabelDto();
				dto.id = cred.getId();
				dto.displayId = cred.getDisplayId();
			
			dtos.add(dto);
		}
		
		return ResponseEntity.ok().body(dtos);
	}
	
	@GetMapping("/product_key")
	public ResponseEntity<UUID> getProductKey(Principal principal) {
		
		if(principal == null) return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		
		User user = User.findByCredentialsMainLogin(principal.getName());
		
		return ResponseEntity.ok().body(user.getProductKey());
	}
}
