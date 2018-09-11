package car.service;

import java.util.List;

import car.pojo.Car;
import product.pojo.Product;

public interface CarService {
	
	public boolean addProduct(String uaccount, String pid, int num) throws Exception;

	public boolean removeProduct(String uaccount, String pid) throws Exception;
	
	public List<Car> getAllProductFromCar() throws Exception;
	
	public Product getAProduct(String pid) throws Exception;
	
	public boolean changeProductInCar(String uaccount, String pid, int num) throws Exception;
	
	public Car getCarbyUaccount(String uaccount) throws Exception;
}
