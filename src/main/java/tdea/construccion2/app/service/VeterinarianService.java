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
	@Autowired
	private PersonDao personDao;

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
		if(orderDao.existOrder(id)) {
		   OrderDto orderDto = orderDao.findOrderById(id);
	        if (!orderDto.getIs_canceled()) {
	        	orderDto.setIs_canceled(true);
	        	orderDao.cancelOrder(id);
	        }else {
	        	throw new Exception("la orden ya ha sido cancelada anteriormente");
	        }
		}else {
			throw new Exception("la orden no pudo ser cancelada porque no existe");
		}
		System.out.println("se ha cancelado la orden #" + id);
	}

	@Override
	public void createPet(PetDto petDto) throws Exception {
		this.validateSessionAndUser();
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
		PersonDto personDto = new PersonDto(sessionDto.getUserName(), "");
		personDto = personDao.findUserByUserName(personDto.getUsername());
		if (personDto == null) {
			throw new Exception("no hay un usuario valido");
		}
		if(personDto.getRoleId() != 3) {
			throw new Exception("No tiene permiso para realizar esta accion");
		}
	}

	@Override
	public void CreateClinicHistory(ClinicHistoryDto clinichistorydto) throws Exception {
		this.validateSessionAndUser();
		clinicHistoryDao.CreateClinicHistory(clinichistorydto);
		System.out.println("se ha creado la historia clinica de la mascota");
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
		ClinicHistoryDto clinicHistoryDto = null; 

	    if (clinicHistoryDao.existClinicHistory(id)) {
			clinicHistoryDto  = clinicHistoryDao.findClinicHistoryById(id);
	    } else {
	        throw new Exception("La historia clinica no existe");
	    }

	    return clinicHistoryDto.toString();
	}

	@Override
	public String seeOrder(int id) throws Exception {
		this.validateSessionAndUser();
		OrderDto orderDto = null; 
	
	    if (orderDao.existOrder(id)) {
	        orderDto = orderDao.findOrderById(id);
	    } else {
	        throw new Exception("La orden no existe");
	    }

	    return orderDto.toString();
	}

}
