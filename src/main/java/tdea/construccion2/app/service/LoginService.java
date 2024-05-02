package tdea.construccion2.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tdea.construccion2.app.dao.LoginDao;
import tdea.construccion2.app.dao.PersonDao;
import tdea.construccion2.app.dto.PersonDto;
import tdea.construccion2.app.dto.SessionDto;

@Service
public class LoginService implements ILoginService {

	@Autowired
	private PersonDao personDao;
	
	@Autowired
	private LoginDao loginDao;
	
	private long sessionId = 0L;
	
	
	@Override
	public void setSesionID(long sesionId) {
		sessionId = sesionId;		
	}

	public long getSessionId() {
		return sessionId;
	}


	@Override
	public void login(PersonDto personDto) throws Exception {
		PersonDto personDtoValidate = personDao.findUserByUserName(personDto);
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
		LoginDao loginDao = new LoginDao();
		loginDao.logout(sessionId);
		setSesionID(0);
		
	}

}
