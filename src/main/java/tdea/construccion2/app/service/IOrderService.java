package tdea.construccion2.app.service;

import tdea.construccion2.app.dto.OrderDto;

public interface IOrderService {
	public int createOrder(OrderDto orderdto) throws Exception;
	public void cancelOrder(int id) throws Exception;
	public String seeOrder(int id) throws Exception;
}
