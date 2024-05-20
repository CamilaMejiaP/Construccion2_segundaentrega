package tdea.construccion2.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tdea.construccion2.app.controller.request.CreateUserRequest;
import tdea.construccion2.app.controller.response.CreateUserResponse;
import tdea.construccion2.app.dto.PersonDto;
import tdea.construccion2.app.service.AdminService;
import tdea.construccion2.app.validators.PersonInputsValidator;

@RestController
@RequestMapping("/api")
public class AdminRestController {
	
	@Autowired
	private PersonInputsValidator personInputValidator;
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/user")
	public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest request){
		CreateUserResponse response = new CreateUserResponse();
		Long id;
		try {
			id = personInputValidator.idValidator(request.getId());		
			personInputValidator.fullNameValidator(request.getFullName());
			personInputValidator.passwordValidator(request.getPassword());
			personInputValidator.rolValidator(request.getRole());

		}catch(Exception e) {
			return ResponseEntity.badRequest().body(response);
		}
		try {
			PersonDto personDto = new PersonDto(id, Integer.parseInt(request.getAge()), Integer.parseInt(request.getRole()), request.getFullName(), request.getUsername(), request.getPassword());
			adminService.createUser(personDto);
			response.setMessage("usuario creado");
			response.setId(Long.toString(request.getId()));
			return ResponseEntity.ok().body(response);
		}catch(Exception e) {
			response.setMessage(e.getMessage());
			return ResponseEntity.internalServerError().body(response);
		}
		
	}

}
