package tdea.construccion2.app.validators;

import org.springframework.stereotype.Component;

@Component
public class OrderInputsValidator extends InputsValidator{
	
	public int orderIdValidator(int orderId) throws Exception {
        return super.integerValidator(orderId, " id de orden");
    }
	public void PetValidator(int PetName) throws Exception {
        super.integerValidator(PetName, "id  de mascota");
    }
	public long idOwnerValidator(Long idOwner) throws Exception {
        return super.longValidator(idOwner, " identificacion del dueño");
    }
	public long personValidator(Long person) throws Exception {
		   return super.longValidator(person, " Identificacion del veterinario");
    }
	public void nameMedicationsValidator(String nameMedications) throws Exception {
        super.stringValidator(nameMedications, " Nombre de medicamentos");
    }
	

}
