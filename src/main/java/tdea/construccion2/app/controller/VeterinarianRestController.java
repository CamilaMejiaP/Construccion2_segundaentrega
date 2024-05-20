package tdea.construccion2.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tdea.construccion2.app.controller.request.CreateHistoryRequest;
import tdea.construccion2.app.controller.request.CreatePetRequest;
import tdea.construccion2.app.controller.response.GeneralApiResponse;
import tdea.construccion2.app.dto.ClinicHistoryDto;
import tdea.construccion2.app.dto.OrderDto;
import tdea.construccion2.app.dto.PetDto;
import tdea.construccion2.app.service.VeterinarianService;
import tdea.construccion2.app.validators.ClinicHistoryInputsValidator;
import tdea.construccion2.app.validators.OrderInputsValidator;
import tdea.construccion2.app.validators.PetInputsValidator;

@RestController
@RequestMapping("/api")
public class VeterinarianRestController {
	@Autowired
	private ClinicHistoryInputsValidator clinicHistoryInputsValidator;
	@Autowired
	private OrderInputsValidator orderInputsValidator;
	@Autowired
	private PetInputsValidator petInputsValidator;
	@Autowired
	private VeterinarianService veterinarianService;
	
	private boolean validateProcedure(String optionProcedure) throws Exception {
	    if(optionProcedure.equals("vacunacion") || optionProcedure.equals("vaccination")) {
	        return true;
	    }
	    return false;
	}
	
	@PostMapping("/history")
	public ResponseEntity<GeneralApiResponse> generateHistory(@RequestBody CreateHistoryRequest request){
		GeneralApiResponse response = new GeneralApiResponse();
		try {
			clinicHistoryInputsValidator.veterinarianValidator(request.getVeterinarianId());
			boolean medicationValue = request.isOptionMedication() ? true : false;
			
			String medications = null;
			String dosis = null;
			Integer orderId = null;
			
			if(medicationValue) {
				clinicHistoryInputsValidator.medicinesValidator(medications);
				clinicHistoryInputsValidator.medicinesValidator(dosis);
				orderInputsValidator.PetValidator(request.getPetId());
				orderInputsValidator.idOwnerValidator(request.getOwnerId());				
				String dosisMedications = "medications: " + medications + "dosis:"+ dosis;			
				OrderDto orderDto = new OrderDto(request.getPetId(),request.getVeterinarianId(),request.getOwnerId(),dosisMedications,false);	
				orderId = veterinarianService.createOrder(orderDto);
			}
			clinicHistoryInputsValidator.proceduresValidator(request.getOptionProcedure());
			String vaccionationHistory = "N/A";
			boolean procedure = this.validateProcedure(request.getOptionProcedure());
			if(procedure) {
				clinicHistoryInputsValidator.vaccionationHistoryValidator(vaccionationHistory);
			}
			clinicHistoryInputsValidator.reasonForConsultationValidator(request.getReason());
			clinicHistoryInputsValidator.symptomsValidator(request.getSymptoms());
			clinicHistoryInputsValidator.detailsProceduresValidator(request.getDetails());
			ClinicHistoryDto clinicHistoryDto = new ClinicHistoryDto(request.getVeterinarianId(),request.getReason(), request.getSymptoms(),request.getProcedure(),request.getDiagnostic(),medications,dosis,orderId, request.getVaccionationHistory(), request.getDetails(),0);
			veterinarianService.CreateClinicHistory(clinicHistoryDto);
			response.setMessage("Historia Clinica Registrada");
			return ResponseEntity.ok().body(response);
			}catch(Exception e) {
				response.setMessage(e.getMessage());
				return ResponseEntity.internalServerError().body(response);
			}
		
		}
	@PutMapping("/history")
	public ResponseEntity<GeneralApiResponse> updatedHistory(@RequestBody CreateHistoryRequest request)
	{
		GeneralApiResponse response = new GeneralApiResponse();
		try {
			clinicHistoryInputsValidator.veterinarianValidator(request.getId());
			clinicHistoryInputsValidator.veterinarianValidator(request.getVeterinarianId());
			boolean medicationValue = request.isOptionMedication() ? true : false;
			
			String medications = null;
			String dosis = null;
			Integer orderId = 0;
			
			if(medicationValue) {
				clinicHistoryInputsValidator.medicinesValidator(medications);
				clinicHistoryInputsValidator.medicinesValidator(dosis);
				orderInputsValidator.PetValidator(request.getPetId());
				orderInputsValidator.idOwnerValidator(request.getOwnerId());		
				
				String dosisMedications = "medications: " + medications + "dosis:"+ dosis;			
				OrderDto orderDto = new OrderDto(request.getPetId(),request.getVeterinarianId(),request.getOwnerId(),dosisMedications,false);	
				orderId = veterinarianService.createOrder(orderDto);
			}
			clinicHistoryInputsValidator.proceduresValidator(request.getOptionProcedure());
			String vaccionationHistory = "N/A";
			boolean procedure = this.validateProcedure(request.getOptionProcedure());
			if(procedure) {
				clinicHistoryInputsValidator.vaccionationHistoryValidator(vaccionationHistory);
			}
			clinicHistoryInputsValidator.reasonForConsultationValidator(request.getReason());
			clinicHistoryInputsValidator.symptomsValidator(request.getSymptoms());
			clinicHistoryInputsValidator.detailsProceduresValidator(request.getDetails());
			ClinicHistoryDto clinicHistoryDto = new ClinicHistoryDto(request.getVeterinarianId(),request.getReason(), request.getSymptoms(),request.getProcedure(),request.getDiagnostic(),medications,dosis,orderId, request.getVaccionationHistory(), request.getDetails(),0);
			veterinarianService.UpdateClinicHistory(clinicHistoryDto);
			response.setMessage("Historia Clinica Actualizada");
			return ResponseEntity.ok().body(response);
			}catch(Exception e) {
				response.setMessage(e.getMessage());
				return ResponseEntity.internalServerError().body(response);
			}
		
		}
	@GetMapping("/search/order/{id}")
	public ResponseEntity<GeneralApiResponse> searchOrder(@PathVariable int id) {
			GeneralApiResponse response = new GeneralApiResponse();
			try {
				orderInputsValidator.orderIdValidator(id);	
				String orderDetails = veterinarianService.seeOrder(id);
				response.setStatus(true);
				response.setMessage("ver orden");
				response.setBody(orderDetails);
				return ResponseEntity.ok().body(response);
			}catch(Exception e) {
				response.setStatus(false);
				response.setMessage(e.getMessage());
				return ResponseEntity.internalServerError().body(response);
				
			}
		}
	@PostMapping("/pet")
	public ResponseEntity<GeneralApiResponse> createPet(@RequestBody CreatePetRequest request) {
		GeneralApiResponse response = new GeneralApiResponse();
		try {
			petInputsValidator.nameValidator(request.getName());
			petInputsValidator.ageValidator(request.getAge());
			petInputsValidator.speciesValidator(request.getSpecies());
			petInputsValidator.raceValidator(request.getBreed());
			petInputsValidator.characteristicsValidator(request.getCharacteristics());
			petInputsValidator.idOwnerValidator(request.getOwnerId());			
			PetDto petDto = new PetDto(request.getName(),request.getAge(),request.getSpecies(),request.getBreed(),request.getCharacteristics(),request.getWeight(),request.getOwnerId());
			veterinarianService.createPet(petDto);
			response.setStatus(true);
			response.setMessage("Mascota creada");
			return ResponseEntity.ok().body(response);
		}catch(Exception e) {
			response.setStatus(false);
			response.setMessage(e.getMessage());
			return ResponseEntity.internalServerError().body(response);
			
		}
	}
	@GetMapping("/order/cancel/{id}")
	public ResponseEntity<GeneralApiResponse> cancelOrder(@PathVariable int id) {
		GeneralApiResponse response = new GeneralApiResponse();
		try {
			orderInputsValidator.orderIdValidator(id);		
			veterinarianService.cancelOrder(id);
			response.setStatus(true);
			response.setMessage("se ha cancelado la orden #" + id);
			return ResponseEntity.ok().body(response);
		}catch(Exception e) {
			response.setStatus(false);
			response.setMessage(e.getMessage());
			return ResponseEntity.internalServerError().body(response);
			
		}
	}

}
