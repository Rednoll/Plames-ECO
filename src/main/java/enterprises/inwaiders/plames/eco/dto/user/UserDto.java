package enterprises.inwaiders.plames.eco.dto.user;

import enterprises.inwaiders.plames.eco.dto.DtoBase;
import enterprises.inwaiders.plames.eco.dto.credential.CredentialsStorageDto;

public class UserDto extends DtoBase {

	public Long id;
	public String nickname;
	public CredentialsStorageDto credentials;
}
