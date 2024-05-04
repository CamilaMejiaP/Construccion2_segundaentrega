package tdea.construccion2.app.dao;

import tdea.construccion2.app.dto.PersonDto;

public interface IPersonDao {
	public PersonDto createPerson(PersonDto personDto) throws Exception;
	public boolean findUserExistById(long id)throws Exception;
	public PersonDto findUserById(Long id) throws Exception;
	public PersonDto findUserByUserName(String username) throws Exception;
}
