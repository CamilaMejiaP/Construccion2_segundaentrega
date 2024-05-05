package tdea.construccion2.app.controller;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tdea.construccion2.app.dto.ClinicHistoryDto;
import tdea.construccion2.app.dto.OrderDto;
import tdea.construccion2.app.dto.PetDto;
import tdea.construccion2.app.service.LoginService;
import tdea.construccion2.app.service.VeterinarianService;
import tdea.construccion2.app.validators.ClinicHistoryInputsValidator;
import tdea.construccion2.app.validators.OrderInputsValidator;
import tdea.construccion2.app.validators.PetInputsValidator;

@Component
public class VeterinarianController {
	
	private static Scanner scanner = new Scanner(System.in);
	@Autowired
	private ClinicHistoryInputsValidator clinicHistoryInputsValidator;
	@Autowired
	private OrderInputsValidator orderInputsValidator;
	@Autowired
	private PetInputsValidator petInputsValidator;
	@Autowired
	private VeterinarianService veterinarianService;
	
	private final String MENU = "ingrese\n1.Para registrar una mascota\n2.Para registrar una historia clinica\n3.Para consultar una historia clinica\n4.Para anular una orden\n5.Para cerrar sesion";
	

	private boolean validateProcedure(String optionProcedure) throws Exception {
	    if(optionProcedure.equals("vacunacion") || optionProcedure.equals("vaccination")) {
	        return true;
	    }
	    return false;
	}

	private void generateHistory() throws Exception {
		
		
		System.out.print("Ingrese el id del veterinario: ");
		long veterinarianId = scanner.nextInt();
		clinicHistoryInputsValidator.veterinarianValidator(veterinarianId);
		
		System.out.print("Ingrese 1.para recetar medicamentos, 2.no recetar medicamentos: ");
		int optionMedication = scanner.nextInt();
		scanner.nextLine();
		clinicHistoryInputsValidator.validatePrescribeMedications(optionMedication);
		
		String medications = null;
		String dosis = null;
		Integer orderId = null;
		
		if(optionMedication == 1) {
			System.out.print("Ingrese el nombre del medicamento/s:");
			medications = scanner.nextLine();
			clinicHistoryInputsValidator.medicinesValidator(medications);
			
			System.out.print("Ingrese la dosis:");
			dosis = scanner.nextLine();
			clinicHistoryInputsValidator.medicinesValidator(dosis);
			
			System.out.print("Ingrese el id de la mascota: ");
			int petId = scanner.nextInt();
			scanner.nextLine();
			orderInputsValidator.PetValidator(petId);
			
			System.out.println("Ingrese el id del dueño");
			Long ownerId = scanner.nextLong();
			scanner.nextLine();
			orderInputsValidator.idOwnerValidator(ownerId);		
			
			String dosisMedications = "medications: " + medications + "dosis:"+ dosis;
			
			OrderDto orderDto = new OrderDto(petId,veterinarianId,ownerId,dosisMedications,false);	
			orderId = veterinarianService.createOrder(orderDto);
		}
		
		System.out.print("Ingrese el tipo de procedimiento: ");
		String optionProcedure = scanner.nextLine();
		clinicHistoryInputsValidator.proceduresValidator(optionProcedure);
		String vaccionationHistory = "N/A";
		boolean procedure = this.validateProcedure(optionProcedure);
		if(procedure) {
			System.out.print("Ingrese la historia de vacunacion: ");
			vaccionationHistory = scanner.nextLine();
			clinicHistoryInputsValidator.vaccionationHistoryValidator(vaccionationHistory);
		}
	
		System.out.print("Ingrese la razon de consulta: ");
		String reason = scanner.nextLine();
		clinicHistoryInputsValidator.reasonForConsultationValidator(reason);

		System.out.print("Ingrese sintomas: ");
		String symptoms = scanner.nextLine();
		clinicHistoryInputsValidator.symptomsValidator(symptoms);
		
		System.out.print("Ingrese diagnostico: ");
		String diagnostic = scanner.nextLine();
		clinicHistoryInputsValidator.symptomsValidator(diagnostic);
		
		System.out.print("medicamentos a los que presenta alergia: ");
		String allergies = scanner.nextLine();
		clinicHistoryInputsValidator.allergiesValidator(allergies);
		
		System.out.print("detalles del procedimiento: ");
		String detailsProcedures = scanner.nextLine();
		clinicHistoryInputsValidator.detailsProceduresValidator(detailsProcedures);
		
		ClinicHistoryDto clinicHistoryDto = new ClinicHistoryDto(veterinarianId,reason, symptoms,optionProcedure,diagnostic,medications, dosis,orderId, vaccionationHistory, detailsProcedures,0);
		veterinarianService.CreateClinicHistory(clinicHistoryDto);
	
	}
	
private void updatedHistory() throws Exception {
		
		System.out.print("Ingrese el id de la historia clinica");
		int historyClinicId = scanner.nextInt();
		clinicHistoryInputsValidator.veterinarianValidator(historyClinicId);
		
		
		System.out.print("Ingrese el id del veterinario: ");
		long veterinarianId = scanner.nextInt();
		clinicHistoryInputsValidator.veterinarianValidator(veterinarianId);
		
		System.out.print("Ingrese 1.para recetar medicamentos, 2.no recetar medicamentos: ");
		int optionMedication = scanner.nextInt();
		scanner.nextLine();
		clinicHistoryInputsValidator.validatePrescribeMedications(optionMedication);
		
		String medications = null;
		String dosis = null;
		Integer orderId = 0;
		
		if(optionMedication == 1) {
			System.out.print("Ingrese el nombre del medicamento/s:");
			medications = scanner.nextLine();
			clinicHistoryInputsValidator.medicinesValidator(medications);
			
			System.out.print("Ingrese la dosis:");
			dosis = scanner.nextLine();
			clinicHistoryInputsValidator.medicinesValidator(dosis);
			
			System.out.print("Ingrese el id de la mascota: ");
			int petId = scanner.nextInt();
			scanner.nextLine();
			orderInputsValidator.PetValidator(petId);
			
			System.out.println("Ingrese el id del dueño");
			Long ownerId = scanner.nextLong();
			scanner.nextLine();
			orderInputsValidator.idOwnerValidator(ownerId);		
			
			String dosisMedications = "medications: " + medications + "dosis:"+ dosis;
			
			OrderDto orderDto = new OrderDto(petId,veterinarianId,ownerId,dosisMedications,false);	
			orderId = veterinarianService.createOrder(orderDto);
		}
		
		System.out.print("Ingrese el tipo de procedimiento: ");
		String optionProcedure = scanner.nextLine();
		clinicHistoryInputsValidator.proceduresValidator(optionProcedure);
		String vaccionationHistory = "N/A";
		boolean procedure = this.validateProcedure(optionProcedure);
		if(procedure) {
			System.out.print("Ingrese la historia de vacunacion: ");
			vaccionationHistory = scanner.nextLine();
			clinicHistoryInputsValidator.vaccionationHistoryValidator(vaccionationHistory);
		}
	
		System.out.print("Ingrese la razon de consulta: ");
		String reason = scanner.nextLine();
		clinicHistoryInputsValidator.reasonForConsultationValidator(reason);

		System.out.print("Ingrese sintomas: ");
		String symptoms = scanner.nextLine();
		clinicHistoryInputsValidator.symptomsValidator(symptoms);
		
		System.out.print("Ingrese diagnostico: ");
		String diagnostic = scanner.nextLine();
		clinicHistoryInputsValidator.symptomsValidator(diagnostic);
		
		System.out.print("medicamentos a los que presenta alergia: ");
		String allergies = scanner.nextLine();
		clinicHistoryInputsValidator.allergiesValidator(allergies);
		
		System.out.print("detalles del procedimiento: ");
		String detailsProcedures = scanner.nextLine();
		clinicHistoryInputsValidator.detailsProceduresValidator(detailsProcedures);
		
		ClinicHistoryDto clinicHistoryDto = new ClinicHistoryDto(historyClinicId,veterinarianId,reason, symptoms,optionProcedure,diagnostic,medications, dosis,orderId, vaccionationHistory, detailsProcedures,0);
		veterinarianService.UpdateClinicHistory(clinicHistoryDto);
	
	}
	private void searchHistory() throws Exception {
		System.out.println("Ingrese 1.para recetar medicamentos, 2.no recetar medicamentos");
		int optionMedication = scanner.nextInt();
		clinicHistoryInputsValidator.validatePrescribeMedications(optionMedication);
		
		
	}
	private void searchOrder() throws Exception {
		
		System.out.println("Ingrese el id de la orden");
		int orderId = scanner.nextInt();
		scanner.nextLine();
		orderInputsValidator.orderIdValidator(orderId);		
		System.out.println(veterinarianService.seeOrder(orderId));
	}
	private void createPet() throws Exception {
		System.out.println("ingrese el nombre de la mascota");
		String petName = scanner.nextLine();
		petInputsValidator.nameValidator(petName);

		System.out.println("ingrese la edad de la mascota");
		int age = scanner.nextInt();
		scanner.nextLine();
		petInputsValidator.ageValidator(age);
		
		System.out.println("ingrese la especie de la mascota");
		String species = scanner.nextLine();
		petInputsValidator.speciesValidator(species);
		
		System.out.println("ingrese  de raza");
		String breed = scanner.nextLine();
		petInputsValidator.raceValidator(breed);
		
		System.out.println("ingrese  la caracteristica");
		String characteristics = scanner.nextLine();
		petInputsValidator.characteristicsValidator(characteristics);
		
		System.out.println("ingrese  el peso");
		int weight = scanner.nextInt();
		scanner.nextLine();
		petInputsValidator.weightValidator(weight);
		
		System.out.println("Ingrese el id del dueño");
		Long ownerId = scanner.nextLong();
		scanner.nextLine();
		petInputsValidator.idOwnerValidator(ownerId);	
		
		PetDto petDto = new PetDto(petName,age,species,breed,characteristics,weight,ownerId);
		veterinarianService.createPet(petDto);
	}
	private void cancelOrder() throws Exception {
		System.out.println("ingrese el id de la orden");
		int orderId = scanner.nextInt();
		orderInputsValidator.orderIdValidator(orderId);		
		veterinarianService.cancelOrder(orderId);
		System.out.println("se ha cancelado la orden #" + orderId );
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
				createPet();
				return true;
			}
			case "2": {
				generateHistory();
				return true;
			}
			case "3": {
				searchHistory();
				return true;
			}
			case "4": {
				searchOrder();
				return true;
			}
			case "5": {
				cancelOrder();
				return true;
			}
			case "6": {
				updatedHistory();
				return true;
			}
			case "7": {
				return false;
			}
			default :{
				System.out.println("ingrese una opcion valida");
				return true;
			}
		}
	}
	public ClinicHistoryInputsValidator getClinicHistoryInputsValidator() {
		return clinicHistoryInputsValidator;
	}
	public void setClinicHistoryInputsValidator(ClinicHistoryInputsValidator clinicHistoryInputsValidator) {
		this.clinicHistoryInputsValidator = clinicHistoryInputsValidator;
	}
	public OrderInputsValidator getOrderInputsValidator() {
		return orderInputsValidator;
	}
	public void setOrderInputsValidator(OrderInputsValidator orderInputsValidator) {
		this.orderInputsValidator = orderInputsValidator;
	}
	public PetInputsValidator getPetInputsValidator() {
		return petInputsValidator;
	}
	public void setPetInputsValidator(PetInputsValidator petInputsValidator) {
		this.petInputsValidator = petInputsValidator;
	}
	public VeterinarianService getVeterinarianService() {
		return veterinarianService;
	}
	public void setVeterinarianService(VeterinarianService veterinarianService) {
		this.veterinarianService = veterinarianService;
	}
	
	
}
