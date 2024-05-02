package tdea.construccion2.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tdea.construccion2.app.dao.LoginDao;
import tdea.construccion2.app.dao.OrderDao;
import tdea.construccion2.app.dao.PersonDao;
import tdea.construccion2.app.dao.SailDao;
import tdea.construccion2.app.dto.BillDto;
import tdea.construccion2.app.dto.PersonDto;
import tdea.construccion2.app.dto.SessionDto;

@Service
public class VendorService implements IVendorService{
	
	@Autowired
	private PersonDao personDao;
	@Autowired
	private LoginDao loginDao;
	@Autowired
	private SailDao sailDao;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private LoginService loginService;

	
	private void validateSessionAndUser() throws Exception {
		SessionDto sessionDto = loginDao.findSessionById(loginService.getSessionId());
		if (sessionDto == null) {
			throw new Exception("no hay una sesion valida");
		}
		PersonDto personDto = new PersonDto(sessionDto.getUserName(), "");
		personDto = personDao.findUserByUserName(personDto);
		if (personDto == null) {
			throw new Exception("no hay un usuario valido");
		}
	}
	
	public void createSale(BillDto billDto) throws Exception {
		this.validateSessionAndUser();
		sailDao.createSale(billDto);
		System.out.println("se ha creado la venta");		
	}

	@Override
	public String seeOrderById(int id) throws Exception {
		this.validateSessionAndUser();
		return orderDao.seeOrder(id);
	}

	public PersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	public LoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	public SailDao getSailDao() {
		return sailDao;
	}

	public void setSailDao(SailDao sailDao) {
		this.sailDao = sailDao;
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
}
