package tdea.construccion2.app.controller;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tdea.construccion2.app.dto.PersonDto;
import tdea.construccion2.app.service.AdminService;
import tdea.construccion2.app.validators.PersonInputsValidator;

@Component
public class AdminController {
	private static Scanner scanner = new Scanner(System.in);
	@Autowired
	private PersonInputsValidator personInputValidator;
	@Autowired
	private AdminService adminService;
	private final String MENU = "ingrese\n1.Para crear usuario\n2.Para cerrar Sesion";
	
	private void createUser() throws Exception {
		System.out.print("ingrese la edad: ");
		int age = scanner.nextInt();
		scanner.nextLine();
		personInputValidator.intValidator(age);
		
		System.out.print("ingrese el nombre completo: ");
		String fullname = scanner.nextLine();
		personInputValidator.fullNameValidator(fullname);
		
		System.out.print("ingrese la cedula del usuario: ");
		long id = personInputValidator.idValidator(scanner.nextLong());
		
		System.out.print("ingrese el id del rol: ");
		int role_id = scanner.nextInt();
		scanner.nextLine();
		personInputValidator.intValidator(role_id);;
		
		System.out.print("ingrese nombre de usuario: ");
		String username = scanner.nextLine();
		personInputValidator.fullNameValidator(username);
		
		System.out.print("ingrese la contraseña: ");
		String password = scanner.nextLine();
		personInputValidator.fullNameValidator(password);
		
		PersonDto personDto = new PersonDto(id, age, role_id, fullname, username, password);
		System.out.println("se cumplieron todas las validaciones");
		adminService.createUser(personDto);
	}
	
	public void session() {
		boolean runApp = true;
		while (runApp) {
			try {
				System.out.println(MENU);
				String option = scanner.nextLine();
				runApp=menu(option);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
	}
	
	private boolean menu(String option) throws Exception{
		switch (option) {
			case "1":{
				createUser();
				return true;
			}
			case "2": {
				return false;
			}
			default :{
				System.out.println("ingrese una opcion valida");
				return true;
			}
		}
	}

	public PersonInputsValidator getPersonInputValidator() {
		return personInputValidator;
	}

	public void setPersonInputValidator(PersonInputsValidator personInputValidator) {
		this.personInputValidator = personInputValidator;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	
}
