package order.dao;

import java.util.List;

import order.pojo.Order;

public interface OrderDao {
	
	public List<Order> getAllOrder() throws Exception;
	
	public Order getOrderByOid(String oid) throws Exception;
	
	public boolean changeOrder(String oid, Order order) throws Exception;
	
}
