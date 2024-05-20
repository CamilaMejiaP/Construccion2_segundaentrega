package tdea.construccion2.app.validators;

import org.springframework.stereotype.Component;

@Component
public class PersonInputsValidator extends InputsValidator {
	
    public void fullNameValidator(String fullname) throws Exception {
        super.stringValidator(fullname, "Nombre de usuario");
    }
    public long idValidator(long number) throws Exception {
        return super.longValidator(number, "Cedula");
    }
   public int ageValidator(int age) throws Exception{
	   return super.integerValidator(age, "Ingrese edad del usuario");
   }
   public void passwordValidator(String password) throws Exception{
	   super.stringValidator(password, "Es clave valida");
   }
   public int intValidator(int number) throws Exception{
	   return super.integerValidator(number, "Es id valida");
   }
   public void rolValidator(String number) throws Exception{
	   super.stringValidator(number, "el rol no es valido");
   }
}


 