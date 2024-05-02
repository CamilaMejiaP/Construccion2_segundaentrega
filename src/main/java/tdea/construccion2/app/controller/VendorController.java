package tdea.construccion2.app.controller;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tdea.construccion2.app.dto.BillDto;
import tdea.construccion2.app.service.VendorService;
import tdea.construccion2.app.validators.BillInputsValidator;
import tdea.construccion2.app.validators.OrderInputsValidator;

@Component
public class VendorController {
	private static Scanner scanner = new Scanner(System.in);
	@Autowired
	private OrderInputsValidator orderValidator;
	@Autowired
	private BillInputsValidator billValidator;
	@Autowired
	private static VendorService vendorService;
	private final String MENU = "ingrese\n1.Para generar venta\\n2.Buscar orden\n4.Para cerrar Sesion";
	
	private void createSale() throws Exception {
		System.out.println("ingrese el id e la mascota");
		int petId = scanner.nextInt();
		orderValidator.PetValidator(petId);
		
		System.out.println("Ingrese el id del dueño");
		Long ownerId = scanner.nextLong();
		orderValidator.idOwnerValidator(ownerId);		
		
		System.out.println("ingrese el id de la orden");
		int orderId = scanner.nextInt();
		orderValidator.orderIdValidator(orderId);
		
		System.out.println("ingrese el nombre del producto");
		String productName = scanner.nextLine();
		billValidator.productNameValidator(productName);
		
		System.out.println("ingrese el valor del producto");
		Double value = scanner.nextDouble();
		billValidator.priceValidator(value);
		
		System.out.println("ingrese la cantidad del producto");
		int mount = scanner.nextInt();
		billValidator.amountValidator(mount);		
		
		BillDto billDto = new BillDto(petId,ownerId,orderId,productName,value,mount);
		vendorService.createSale(billDto);
	}
	
	private void searchOrder() throws Exception {
		System.out.println("Ingrese el id de la orden");
		int orderId = scanner.nextInt();
		orderValidator.orderIdValidator(orderId);		
		System.out.println(vendorService.seeOrderById(orderId));
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
				createSale();
				return true;
			}
			case "3": {
				searchOrder();
				return true;
			}
			case "4": {
				return false;
			}
			default :{
				System.out.println("ingrese una opcion valida");
				return true;
			}
		}
	}

	public OrderInputsValidator getOrderValidator() {
		return orderValidator;
	}

	public void setOrderValidator(OrderInputsValidator orderValidator) {
		this.orderValidator = orderValidator;
	}

	public BillInputsValidator getBillValidator() {
		return billValidator;
	}

	public void setBillValidator(BillInputsValidator billValidator) {
		this.billValidator = billValidator;
	}

	public static VendorService getVendorService() {
		return vendorService;
	}

	public static void setVendorService(VendorService vendorService) {
		VendorController.vendorService = vendorService;
	}
	
}
