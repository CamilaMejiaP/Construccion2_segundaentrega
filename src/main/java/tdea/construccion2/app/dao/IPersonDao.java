package tdea.construccion2.app.dao;

import tdea.construccion2.app.dto.PersonDto;

public interface IPersonDao {
	public void createPerson(PersonDto personDto) throws Exception;
	public boolean findUserExistById(long id)throws Exception;
	public PersonDto findUserById(PersonDto personDto) throws Exception;
	public boolean existUserByUserName(PersonDto personDto) throws Exception;
	public PersonDto findUserByUserName(PersonDto personDto) throws Exception;
}
