package tdea.construccion2.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tdea.construccion2.app.dto.PersonDto;
import tdea.construccion2.app.dto.SessionDto;
import tdea.construccion2.app.models.Session;
import tdea.construccion2.app.repository.ISessionRepository;

@Service
public class LoginDao implements ILoginDao{
	
	@Autowired
	private ISessionRepository sessionRepository;

	@Override
	public SessionDto login(PersonDto personDto) throws Exception {
		Session session = new Session();
		session.setUserName(personDto.getUsername());
		session.setUserRoll(personDto.getRoleId());
		sessionRepository.save(session);
		return new SessionDto(session);
	}

	@Override
	public void logout(long sessionId) throws Exception {
		
	}

	@Override
	public SessionDto findSessionById(long sessionId)throws Exception {
		return null;		
	}

}
