package tdea.construccion2.app.service;

import tdea.construccion2.app.dto.PersonDto;

public interface IAdminService {
	public void createUser(PersonDto personDto) throws Exception;
}
