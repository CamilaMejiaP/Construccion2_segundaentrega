package tdea.construccion2.app.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tdea.construccion2.app.dao.LoginDao;
import tdea.construccion2.app.dao.PersonDao;
import tdea.construccion2.app.dto.PersonDto;
import tdea.construccion2.app.dto.SessionDto;

@Service
public class AdminService implements IAdminService,ILoginService{
	List<Integer> roles = Arrays.asList(1,2,3);
	
	private long sessionId = 0L;
	@Autowired
	private PersonDao personDao; 
	@Autowired
	private LoginDao loginDao;
	
	@Override
	public void createUser(PersonDto personDto) throws Exception {
		if (!roles.contains(personDto.getRoleId())) {
			throw new Exception("el rol no es valido");
		}
		if (personDao.findUserExistById(personDto.getId())) {
			throw new Exception("ya existe un usuario con esa cedula");
		}
		if (personDao.findUserByUserName(personDto.getUsername()) != null) {
			throw new Exception("ya existe el usuario");
		}
		personDao.createPerson(personDto);
		System.out.println("se ha creado el usuario");
	}


	@Override
	public void setSesionID(long sesionId) {
		sessionId = sesionId;
	}

	@Override
	public void login(PersonDto personDto) throws Exception {
		PersonDto personDtoValidate = personDao.findUserByUserName(personDto.getUsername());
		if (personDtoValidate == null) {
			throw new Exception("usuario no valido");
		}
		if (!personDto.getPassword().equals(personDtoValidate.getPassword())) {
			throw new Exception("usuario o contraseña incorrectos");
		}
		personDto.setRoleId(personDtoValidate.getRoleId());
		SessionDto sesionDto = loginDao.login(personDtoValidate);
		setSesionID(sesionDto.getId());
		System.out.println("se inicia la sesion " + sessionId);
	}

	@Override
	public void logout() throws Exception {
		loginDao.logout(sessionId);
		setSesionID(0);
	}
}
