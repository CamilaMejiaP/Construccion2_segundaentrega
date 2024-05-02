package tdea.construccion2.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tdea.construccion2.app.dto.PersonDto;
import tdea.construccion2.app.models.Person;
import tdea.construccion2.app.repository.IPersonRepository;

@Service
public class PersonDao implements IPersonDao {

	@Autowired
	private IPersonRepository personRepository;
	
	@Override
	public void createPerson(PersonDto personDto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean findUserExistById(long id) throws Exception {
		return false;
		
	}

	@Override
	public PersonDto findUserById(PersonDto personDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public PersonDto findUserByUserName(PersonDto personDto) throws Exception {
		Person person = personRepository.findByUsername(personDto.getUsername());
		if(person == null) {
			return null;
		}
		return new PersonDto(person);
	}
	
	@Override
	public boolean existUserByUserName(PersonDto personDto) throws Exception {
		return false;
	
	}

	public IPersonRepository getPersonRepository() {
		return personRepository;
	}

	public void setPersonRepository(IPersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
}
