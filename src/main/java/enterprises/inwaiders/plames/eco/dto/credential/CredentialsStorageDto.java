package enterprises.inwaiders.plames.eco.dto.credential;

import java.util.Set;

import enterprises.inwaiders.plames.eco.dto.DtoBase;

public class CredentialsStorageDto extends DtoBase {
	
	public PlamesCredentialDto main;
	public Set<CredentialDto> credentials;
}
