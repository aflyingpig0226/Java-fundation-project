package order.service;

import java.util.List;

import database.FileOperationUtil;
import order.dao.OrderDaoIMP;
import order.pojo.Order;

public class OrderServiceIMP implements OrderService{
	
	FileOperationUtil<Order> tools = new FileOperationUtil<>();
	OrderDaoIMP orderDaoIMP = new OrderDaoIMP();
	@Override
	public List<Order> getAllOrder() throws Exception {
//		BufferedReader bufferedReader = new BufferedReader(new FileReader(DatabasePathConstant.ORDER_PATH));
//		String line = bufferedReader.readLine();
//		bufferedReader.close();
		List<Order> allOrder = orderDaoIMP.getAllOrder();
//		for (int i = 0; i < allOrder.size(); i++) {
//			Order order = allOrder.get(i);
//			if (line == null) {
//				HashMap<String, Order> hashMap = new HashMap<>();
//				hashMap.put(order.getOid(), order);
//				tools.writeinfo(hashMap, DatabasePathConstant.ORDER_PATH);
//			}else {
//				HashMap<String, Order> readinfo = tools.readinfo(DatabasePathConstant.ORDER_PATH);
//				readinfo.put(order.getOid(), order);
//				tools.writeinfo(readinfo, DatabasePathConstant.ORDER_PATH);
//			}
//		}
		return allOrder;
	}

	@Override
	public Order getOrderByOid(String oid) throws Exception {
		Order orderByOid = orderDaoIMP.getOrderByOid(oid);
		return orderByOid;
	}

	@Override
	public boolean changeOrder(String oid, String uname, int num, String phone, String address) throws Exception {
		Order orderByOid = getOrderByOid(oid);
		if (orderByOid != null) {
			orderByOid.setUname(uname);
			orderByOid.setNum(num);
			orderByOid.setPhone(phone);
			orderByOid.setAddress(address);
			return true;
		}else {
			return false;
		}
	}

}
