package tdea.construccion2.app.validators;

import org.springframework.stereotype.Component;

@Component
public class ClinicHistoryInputsValidator extends InputsValidator {
	
    public void veterinarianValidator(long veterinarianId) throws Exception {
        super.longValidator(veterinarianId, "id de veterinario");
    }
    public void reasonForConsultationValidator(String reasonForConsultation) throws Exception {
        super.stringValidator(reasonForConsultation, "Motivo de consulta");
    }
    public void symptomsValidator(String symptoms) throws Exception {
        super.stringValidator(symptoms, "Sintomas");
    }
    public void proceduresValidator(String procedures) throws Exception {
        super.stringValidator(procedures, " procedimiento");
    }
    public void medicinesValidator(String medicines) throws Exception {
        super.stringValidator(medicines, "Medicinas");
    }
    public int idOrderValidator(int idOrder) throws Exception {
        return super.integerValidator(idOrder, "Orden");
    }
    public int validatePrescribeMedications(int prescribeMedicamentos) throws Exception {
        return super.integerValidator(prescribeMedicamentos,"Prescribir medicamentos");
    }
    public void vaccionationHistoryValidator(String vaccionationHistory) throws Exception {
        super.stringValidator(vaccionationHistory, " procedimiento");
    }
    public void allergiesValidator(String allergies) throws Exception {
        super.stringValidator(allergies, " alergias");
    }
    public void detailsProceduresValidator(String detailsProcedures) throws Exception {
        super.stringValidator(detailsProcedures, " procedimiento");
    }
    
}
