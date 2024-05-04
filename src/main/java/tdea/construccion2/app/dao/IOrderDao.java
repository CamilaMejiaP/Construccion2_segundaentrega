package tdea.construccion2.app.dao;

import tdea.construccion2.app.dto.OrderDto;

public interface IOrderDao {
	public int createOrder(OrderDto orderdto) throws Exception;
	public void cancelOrder(int id) throws Exception;
	public OrderDto findOrderById(int id) throws Exception;
	public boolean existOrder(int id) throws Exception;
}
