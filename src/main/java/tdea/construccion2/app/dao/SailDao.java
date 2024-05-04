package tdea.construccion2.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tdea.construccion2.app.dto.BillDto;
import tdea.construccion2.app.models.Bill;
import tdea.construccion2.app.repository.ISailRepository;

@Service
public class SailDao implements ISailDao {
	
	@Autowired
	private ISailRepository sailRepository;

	@Override
	public BillDto createSale(BillDto billDto) throws Exception {
		Bill bill= new Bill();
		bill.setProductName(billDto.getProductName());
		bill.setValue(billDto.getValue());
		bill.setAmount(billDto.getAmount());
		bill.setOrderId(billDto.getOrderId());
		bill.setPetId(billDto.getPetId());
		bill.setOwnerId(bill.getOwnerId());
		sailRepository.save(bill);
		return new BillDto(bill);
		
	}
	

	
}
