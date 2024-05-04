package tdea.construccion2.app.dao;

import tdea.construccion2.app.dto.BillDto;

public interface ISailDao {
	public BillDto createSale(BillDto billDto)throws Exception;
}
