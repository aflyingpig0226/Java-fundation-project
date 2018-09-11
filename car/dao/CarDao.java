package car.dao;

import java.util.List;

import car.pojo.Car;
import product.pojo.Product;

public interface CarDao {
	
	/**
	 * 添加商品
	 * 参数 uaccount, pid, price
	 * boolean
	 */
	public boolean addProduct(String uaccount, String pid, int num) throws Exception;
	
	/**
	 * 删除商品
	 * 参数 pid
	 * 返回值为 boolean
	 */
	public boolean removeProduct(String uaccount, String pid) throws Exception;
	
	/**
	 * 查看购物车
	 * 参数 无
	 * 返回值list
	 */
	public List<Car> getAllProductFromCar() throws Exception;
	
	/**
	 * 查看某一商品
	 * 参数 pid
	 * 返回值product
	 */
	public Product getAProduct(String pid) throws Exception;
	/**
	 * 修改购物车商品数量
	 * 参数 pid num
	 * 返回值为 boolean
	 */
	public boolean changeProductInCar(String uaccount, String pid, int num) throws Exception;
	
	
}
