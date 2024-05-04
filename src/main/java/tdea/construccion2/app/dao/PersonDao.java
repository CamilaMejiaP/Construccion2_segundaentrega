package tdea.construccion2.app.dao;

import java.util.Optional;

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
	public PersonDto createPerson(PersonDto personDto) throws Exception {
		Person person = new Person();
		person.setId(personDto.getId());
		person.setName(personDto.getName());
		person.setUsername(personDto.getUsername());
		person.setAge(personDto.getAge());
		person.setPassword(personDto.getPassword());
		person.setRoleId(personDto.getRoleId());
		personRepository.save(person);
		return new PersonDto(person);		
	}

	@Override
	public boolean findUserExistById(long id) throws Exception {	
		 return personRepository.existsById(id);	
	}

	@Override
	public PersonDto findUserById(Long id) throws Exception {
	    Optional<Person> optionalPerson = personRepository.findById(id);
	    
	    if (optionalPerson.isPresent()) {
	        Person person = optionalPerson.get();
	        return new PersonDto(person);
	    } else {
	        return null;
	    }
	}
	@Override
	public PersonDto findUserByUserName(String username) throws Exception {
		Person person = personRepository.findByUsername(username);
		if(person == null) {
			return null;
		}
		return new PersonDto(person);
	}

	public IPersonRepository getPersonRepository() {
		return personRepository;
	}

	public void setPersonRepository(IPersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
}
