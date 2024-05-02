package tdea.construccion2.app.validators;

import org.springframework.stereotype.Component;

@Component
public class BillInputsValidator extends InputsValidator {
	
	public void PetValidator(String PetName) throws Exception {
        super.stringValidator(PetName, "nombre  de mascota");
    }
	public void OwnerValidator(String OwnerName) throws Exception {
        super.stringValidator(OwnerName, " dueño de mascota");
    }
	public void productNameValidator(String productName) throws Exception {
        super.stringValidator(productName, "Nombre del producto");
    }
	public double priceValidator(double price) throws Exception {
        return super.doubleValidator(price, "precio");
    }
	public int amountValidator(int amount) throws Exception {
        return super.integerValidator(amount, "cantidad");
    }
	
}
