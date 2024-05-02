package tdea.construccion2.app.validators;

import org.springframework.stereotype.Component;

@Component
public class PetInputsValidator extends InputsValidator{
	
	public void nameValidator(String name) throws Exception {
        super.stringValidator(name, " Nombre de mascota incorrecto");
    }
	public long idOwnerValidator(Long idOwner) throws Exception {
        return super.longValidator(idOwner, " identificacion del dueño");
    }
	public int ageValidator(int age) throws Exception{
		   return super.integerValidator(age, "Ingrese edad de la mascota");
	}
	public void speciesValidator(String species) throws Exception {
        super.stringValidator(species, "Especie a la que pertenece");
    }
	public void raceValidator(String race) throws Exception {
        super.stringValidator(race, "Raza");
    }
	public void characteristicsValidator(String characteristics) throws Exception {
        super.stringValidator(characteristics, "Ingrese caracteristicas");
    }
	public int weightValidator(int weight) throws Exception {
        return super.integerValidator(weight, "Ingrese peso de la mascota");
    }
}
