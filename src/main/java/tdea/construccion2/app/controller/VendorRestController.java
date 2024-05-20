package tdea.construccion2.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tdea.construccion2.app.controller.request.CreateSailRequest;
import tdea.construccion2.app.controller.response.GeneralApiResponse;
import tdea.construccion2.app.dto.BillDto;
import tdea.construccion2.app.service.VendorService;
import tdea.construccion2.app.validators.BillInputsValidator;
import tdea.construccion2.app.validators.OrderInputsValidator;

@RestController
@RequestMapping("/api")
public class VendorRestController {
	@Autowired
	private OrderInputsValidator orderValidator;
	@Autowired
	private BillInputsValidator billValidator;
	@Autowired
	private VendorService vendorService;
	
	@PostMapping("/sale")
	public ResponseEntity<GeneralApiResponse> createSail(@RequestBody CreateSailRequest request){	
		GeneralApiResponse response = new GeneralApiResponse();
		try {
		orderValidator.PetValidator(request.getPetId());	
		orderValidator.idOwnerValidator(request.getOwnerId());				
		orderValidator.orderIdValidator(request.getOrderId());	
		billValidator.productNameValidator(request.getProductName());	
		billValidator.priceValidator(request.getValue());	
		billValidator.amountValidator(request.getAmount());	
		
		}catch(Exception e) {
			response.setStatus(false);
			response.setMessage(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		try {
			BillDto billDto = new BillDto(request.getPetId(),request.getOwnerId(),request.getOrderId(),request.getProductName(),request.getValue(),request.getAmount());
			vendorService.createSale(billDto);
			response.setStatus(true);
			response.setMessage("venta creada");
			return ResponseEntity.ok().body(response);
		}catch(Exception e) {
			response.setStatus(false);
			response.setMessage(e.getMessage());
			return ResponseEntity.internalServerError().body(response);
		}
	}
	@GetMapping("/view/sail/{id}")
	 public ResponseEntity<GeneralApiResponse> viewSail(@PathVariable int id) {
		GeneralApiResponse response = new GeneralApiResponse();
		try {
			orderValidator.orderIdValidator(id);	
			String saildetails = vendorService.seeOrderById(id);
			response.setStatus(true);
			response.setMessage("ver venta");
			response.setBody(saildetails);
			return ResponseEntity.ok().body(response);
		}catch(Exception e) {
			response.setStatus(false);
			response.setMessage(e.getMessage());
			return ResponseEntity.internalServerError().body(response);
			
		}
		
    }
	
}
