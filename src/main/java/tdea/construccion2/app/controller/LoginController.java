package tdea.construccion2.app.controller;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tdea.construccion2.app.dto.PersonDto;
import tdea.construccion2.app.service.LoginService;
import tdea.construccion2.app.validators.PersonInputsValidator;

@Component
public class LoginController{
	private static Scanner scanner = new Scanner(System.in);
	@Autowired
	private PersonInputsValidator personInputValidator;
	@Autowired
	private AdminController adminController;
	@Autowired
	private VendorController vendorController;
	@Autowired
	private VeterinarianController veterinarianController;
	@Autowired
	private LoginService loginService;
	
	
	public void login() throws Exception {
		System.out.println("ingrese su usuario");
		String username = scanner.nextLine();
		personInputValidator.fullNameValidator(username);
		System.out.println("ingrese su contraseña");
		String password = scanner.nextLine();
		personInputValidator.passwordValidator(password);
		PersonDto personDto = new PersonDto(username, password);
		loginService.login(personDto);
		loginRouter(personDto);
		loginService.logout();
	}
	private void loginRouter(PersonDto personDto) {
		
		if (personDto.getRoleId() == 1) {
			adminController.session();
		}else if(personDto.getRoleId() == 2) {
			vendorController.session();
		}else if(personDto.getRoleId() == 3) {
			veterinarianController.session();
		}
	
	}
	public PersonInputsValidator getPersonInputValidator() {
		return personInputValidator;
	}
	public void setPersonInputValidator(PersonInputsValidator personInputValidator) {
		this.personInputValidator = personInputValidator;
	}
	public AdminController getAdminController() {
		return adminController;
	}
	public void setAdminController(AdminController adminController) {
		this.adminController = adminController;
	}
	public VendorController getVendorController() {
		return vendorController;
	}
	public void setVendorController(VendorController vendorController) {
		this.vendorController = vendorController;
	}
	public VeterinarianController getVeterinarianController() {
		return veterinarianController;
	}
	public void setVeterinarianController(VeterinarianController veterinarianController) {
		this.veterinarianController = veterinarianController;
	}
	public LoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	
	
	
	
}