package order.service;

import java.util.List;

import order.pojo.Order;

public interface OrderService {
	
	public List<Order> getAllOrder() throws Exception;
	
	public Order getOrderByOid(String oid) throws Exception;
	
	public boolean changeOrder(String oid, String uname, int num, String phone, String address) throws Exception;
	
}
