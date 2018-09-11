package car.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import car.pojo.Car;
import database.DatabasePathConstant;
import database.FileOperationUtil;
import product.dao.ProductDao;
import product.dao.ProductDaoIMP;
import product.pojo.Product;

public class CarDaoIMP implements CarDao{
	
	FileOperationUtil<Car> tools = new FileOperationUtil<Car>();
	ProductDao productdao = new ProductDaoIMP();
	@Override
	public boolean addProduct(String uaccount, String pid, int num) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(DatabasePathConstant.CAR_PATH)));
		String string = bufferedReader.readLine();
		bufferedReader.close();
		Product productById = productdao.getProductById(pid);
		Car car = new Car();
		car.setUaccount(uaccount);
		car.setPid(pid);
		float price = productById.getPrice();
		car.setPrice(price);
		car.setNum(num);
		if (string == null) {
			HashMap<String, Car> hashMap = new HashMap<>();
			hashMap.put(pid, car);
			tools.writeinfo(hashMap, DatabasePathConstant.CAR_PATH);
		}else {
			HashMap<String, Car> readinfoProduct = tools.readinfo(DatabasePathConstant.CAR_PATH);
			readinfoProduct.put(pid, car);
			tools.writeinfo(readinfoProduct, DatabasePathConstant.CAR_PATH);
		}
		return true;
	}

	@Override
	public boolean removeProduct(String uaccount, String pid) throws Exception {
		HashMap<String, Car> readinfo = tools.readinfo(DatabasePathConstant.CAR_PATH);
		if (readinfo.containsKey(pid)) {
			if (readinfo.get(pid).getUaccount().equals(uaccount)) {
				readinfo.remove(pid);
				tools.writeinfo(readinfo, DatabasePathConstant.CAR_PATH);
				return true;
			}
		}
		return false;
	}

	@Override
	public ArrayList<Car> getAllProductFromCar() throws Exception {
		HashMap<String, Car> readinfo = tools.readinfo(DatabasePathConstant.CAR_PATH);
		ArrayList<Car> arrayList = new ArrayList<>();
		Collection<Car> values = readinfo.values();
		for(Car tmp:values) {
			arrayList.add(tmp);
		}
		return arrayList;
	}

	@Override
	public Product getAProduct(String pid) throws Exception {
		Product productById = productdao.getProductById(pid);
		if (productById == null) {
			return null;
		}
		return productById;
	}

	@Override
	public boolean changeProductInCar(String uaccount, String pid, int num) throws Exception {
		HashMap<String, Car> readinfo = tools.readinfo(DatabasePathConstant.CAR_PATH);
		if (readinfo.containsKey(pid)) {
			if (readinfo.get(pid).getUaccount().equals(uaccount)) {
				readinfo.get(pid).setNum(num);
				tools.writeinfo(readinfo, DatabasePathConstant.CAR_PATH);
				return true;
			}
		}
		return false;
	}

}
