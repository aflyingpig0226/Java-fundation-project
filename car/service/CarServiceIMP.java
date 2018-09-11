package car.service;

import java.util.List;

import car.dao.CarDao;
import car.dao.CarDaoIMP;
import car.pojo.Car;
import product.pojo.Product;

public class CarServiceIMP implements CarService{

	CarDao carDao = new CarDaoIMP();
	@Override
	public boolean addProduct(String uaccount, String pid, int num) throws Exception {
		boolean addProduct = carDao.addProduct(uaccount, pid, num);
		return addProduct;
	}

	@Override
	public boolean removeProduct(String uaccount, String pid) throws Exception {
		boolean removeProduct = carDao.removeProduct(uaccount, pid);
		return removeProduct;
	}

	@Override
	public List<Car> getAllProductFromCar() throws Exception {
		List<Car> allProductFromCar = carDao.getAllProductFromCar();
		return allProductFromCar;
	}

	@Override
	public Product getAProduct(String pid) throws Exception {
		Product aProduct = carDao.getAProduct(pid);
		if (aProduct != null) {
			return aProduct;
		}
		return null;
	}

	@Override
	public boolean changeProductInCar(String uaccount, String pid, int num) throws Exception {
		boolean changeProductInCar = carDao.changeProductInCar(uaccount, pid, num);
		return changeProductInCar;
	}

	@Override
	public Car getCarbyUaccount(String uaccount) throws Exception {
		List<Car> allProductFromCar = carDao.getAllProductFromCar();
		for(Car tmp:allProductFromCar) {
			if (tmp.getUaccount().equals(uaccount)) {
				return tmp;
			}
		}
		return null;
	}
	


}
