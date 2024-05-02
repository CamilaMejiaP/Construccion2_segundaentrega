package tdea.construccion2.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tdea.construccion2.app.dao.ClinicHistoryDao;
import tdea.construccion2.app.dao.LoginDao;
import tdea.construccion2.app.dao.OrderDao;
import tdea.construccion2.app.dao.PersonDao;
import tdea.construccion2.app.dao.PetDao;
import tdea.construccion2.app.dto.ClinicHistoryDto;
import tdea.construccion2.app.dto.OrderDto;
import tdea.construccion2.app.dto.PersonDto;
import tdea.construccion2.app.dto.PetDto;
import tdea.construccion2.app.dto.SessionDto;

@Service
public class VeterinarianService implements IClinicHistoryService, IPetService, IOrderService {
	
	@Autowired
	private LoginDao loginDao;
	@Autowired
	private PetDao petDao;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private ClinicHistoryDao clinicHistoryDao;
	@Autowired
	private LoginService loginService;

	@Override
	public int createOrder(OrderDto orderdto) throws Exception {
		this.validateSessionAndUser();
		int orderId = orderDao.createOrder(orderdto);
		System.out.println("se ha creado la orden");
		return orderId;
	}

	@Override
	public void cancelOrder(int id) throws Exception {
		this.validateSessionAndUser();
		orderDao.cancelOrder(id);
		System.out.println("se ha cancelado la orden #" + id);
	}

	@Override
	public void createPet(PetDto petDto) throws Exception {
		this.validateSessionAndUser();
		PersonDao personDao = new PersonDao();
		boolean ownerExist = personDao.findUserExistById(petDto.getOwnerId()); 
		if(!ownerExist) {
			throw new Exception("el dueño no existe");
		}
		petDao.createPet(petDto);
		System.out.println("se ha creado la mascota");
	}
	
	private void validateSessionAndUser() throws Exception {
		SessionDto sessionDto = loginDao.findSessionById(loginService.getSessionId());
		if (sessionDto == null) {
			throw new Exception("no hay una sesion valida");
		}
		PersonDao personDao = new PersonDao();
		PersonDto personDto = new PersonDto(sessionDto.getUserName(), "");
		personDto = personDao.findUserByUserName(personDto);
		if (personDto == null) {
			throw new Exception("no hay un usuario valido");
		}
	}

	@Override
	public void CreateClinicHistory(ClinicHistoryDto clinichistorydto) throws Exception {
		this.validateSessionAndUser();
		clinicHistoryDao.CreateClinicHistory(clinichistorydto);
		System.out.println("se ha creao la historia clinica de la mascota");
	}

	@Override
	public void UpdateClinicHistory(ClinicHistoryDto clinichistorydto) throws Exception {
		this.validateSessionAndUser();
		boolean existClinicHistory = clinicHistoryDao.existClinicHistory(clinichistorydto.getId());
		if(existClinicHistory) {
			clinicHistoryDao.UpdateClinicHistory(clinichistorydto);
			System.out.println("se ha creao la historia clinica de la mascota");
		}else {
			throw new Exception(" la historia clinica no existe");
		}
		
	}

	@Override
	public String getHistoryClinicDetails(int id) throws Exception {
		this.validateSessionAndUser();
		return clinicHistoryDao.getHistoryClinicDetails(id);
	}

	@Override
	public String seeOrder(int id) throws Exception {
		this.validateSessionAndUser();
		return orderDao.seeOrder(id);
	}

}
