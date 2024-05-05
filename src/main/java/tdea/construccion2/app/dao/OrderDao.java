package tdea.construccion2.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tdea.construccion2.app.dto.OrderDto;
import tdea.construccion2.app.models.Order;
import tdea.construccion2.app.repository.IOrderRepository;

@Service
public class OrderDao implements IOrderDao {
	
	@Autowired
	private IOrderRepository orderRepository;
	@Override
	public int createOrder(OrderDto orderdto) throws Exception {
		Order order = new Order();
		order.setMedicine(orderdto.getMedicine());
		order.setOwnerId(orderdto.getOwnerId());
		order.setPetId(orderdto.getPetId());
		order.setVeterinarianID(orderdto.getVeterinarianID());
		Order savedOrder = orderRepository.save(order);
		return savedOrder.getId();		
	}

	@Override
	public void cancelOrder(int id) throws Exception {
		 Order order = orderRepository.findById(id);
		 order.setIs_canceled(true);
         orderRepository.save(order);	
	}

	@Override
	public OrderDto findOrderById(int id) throws Exception {
	   Order order = orderRepository.findById(id);
	    if (order == null) {
	       return null;
	    } 
	    return new OrderDto(order);
	}

	@Override
	public boolean existOrder(int id) throws Exception {
		return orderRepository.existsById(id);
	}
	
	
	
}
