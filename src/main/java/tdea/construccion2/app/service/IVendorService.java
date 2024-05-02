package tdea.construccion2.app.service;


import tdea.construccion2.app.dto.BillDto;

public interface IVendorService {
	public void createSale(BillDto billDto)throws Exception;
	public String seeOrderById(int id) throws Exception;
}
