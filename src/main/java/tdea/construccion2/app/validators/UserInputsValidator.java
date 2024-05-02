package tdea.construccion2.app.validators;

import org.springframework.stereotype.Component;

@Component
public class UserInputsValidator extends InputsValidator{
	
	public long idOwnerValidator(Long idOwner) throws Exception {
        return super.longValidator(idOwner, " identificacion del dueño");
    }
	public void fullNameValidator(String fullName) throws Exception {
		super.stringValidator(fullName, "nombre de usuario");
	}

	public int ageValidator(int age) throws Exception{
		   return super.integerValidator(age, "Ingrese edad del usuario");
	}
	public int idRolValidator(int rolId) throws Exception {
		return super.integerValidator(rolId, "id del rol que pertenece");
	}
	
	public void userNameValidator(String userName) throws Exception {
		super.stringValidator(userName, "usuario");
	}
	
	public void passwordValidator(String password) throws Exception {
		super.stringValidator(password, "constraseña de usuario");
	}

}
