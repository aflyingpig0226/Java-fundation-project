package order.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import car.pojo.Car;
import car.service.CarServiceIMP;
import database.DatabasePathConstant;
import database.FileOperationUtil;
import order.pojo.Order;
import product.pojo.Product;
import product.service.ProductServiceIMP;
import user.dao.UserDaoIMP;
import user.pojo.User;

public class OrderDaoIMP implements OrderDao{
	
	ProductServiceIMP productServiceIMP = new ProductServiceIMP();
	UserDaoIMP userDaoIMP = new UserDaoIMP();
	CarServiceIMP carserviceimp = new CarServiceIMP();
	FileOperationUtil<Order> fileOperationUtil = new FileOperationUtil<Order>();
	@Override
	public List<Order> getAllOrder() throws Exception {
		ArrayList<Order> arrayList = new ArrayList<>();
		List<Car> allProductFromCar = carserviceimp.getAllProductFromCar();	
		
		for(Car tmp:allProductFromCar) {
			String pid = tmp.getPid();
			User userByAccount = userDaoIMP.getUserByAccount(tmp.getUaccount());
			Product productById = productServiceIMP.getProductById(pid);
			Order order = new Order(pid, tmp.getUaccount(), productById.getPname(), tmp.getNum(), tmp.getPrice(), userByAccount.getPhone(), userByAccount.getAddr());
			arrayList.add(order);
		}
		return arrayList;
	}

	@Override
	public Order getOrderByOid(String oid) throws Exception {
		List<Order> allOrder = getAllOrder();
		for(Order tmp:allOrder) {
			if (tmp.getOid().equals(oid)) {
				return tmp;
			}
		}
		return null;
	}

	@Override
	public boolean changeOrder(String oid, Order order) throws Exception {
		HashMap<String, Order> readinfo = fileOperationUtil.readinfo(DatabasePathConstant.ORDER_PATH);
		if (readinfo.containsKey(oid)) {
			readinfo.put(oid, order);
			fileOperationUtil.writeinfo(readinfo, DatabasePathConstant.ORDER_PATH);
			return true;
		}
		return false;
	}

}
