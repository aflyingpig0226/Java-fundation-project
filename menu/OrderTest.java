package menu;

import org.junit.Test;

import order.pojo.Order;
import order.service.OrderServiceIMP;

public class OrderTest {
	@Test
	public void test() throws Exception {
		
		OrderServiceIMP orderServiceIMP = new OrderServiceIMP();
//		List<Order> allOrder = orderServiceIMP.getAllOrder();
//		for(Order tmp:allOrder) {
//			System.out.println(tmp);
//		}
		Order orderByOid = orderServiceIMP.getOrderByOid("1");
		System.out.println(orderByOid);
		
	
	}
}
