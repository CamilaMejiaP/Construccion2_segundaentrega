package tdea.construccion2.app.dao;

import org.springframework.stereotype.Service;
import tdea.construccion2.app.dto.OrderDto;

@Service
public class OrderDao implements IOrderDao {
	
	@Override
	public int createOrder(OrderDto orderdto)  throws Exception {
		return 0;
		
	}

	@Override
	public void cancelOrder(int id) throws Exception{
		
	  
	}

	@Override
	public String seeOrder(int id) throws Exception {
		return null;
		
	}
	
}
