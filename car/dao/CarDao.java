package car.dao;

import java.util.List;

import car.pojo.Car;
import product.pojo.Product;

public interface CarDao {
	
	/**
	 * �����Ʒ
	 * ���� uaccount, pid, price
	 * boolean
	 */
	public boolean addProduct(String uaccount, String pid, int num) throws Exception;
	
	/**
	 * ɾ����Ʒ
	 * ���� pid
	 * ����ֵΪ boolean
	 */
	public boolean removeProduct(String uaccount, String pid) throws Exception;
	
	/**
	 * �鿴���ﳵ
	 * ���� ��
	 * ����ֵlist
	 */
	public List<Car> getAllProductFromCar() throws Exception;
	
	/**
	 * �鿴ĳһ��Ʒ
	 * ���� pid
	 * ����ֵproduct
	 */
	public Product getAProduct(String pid) throws Exception;
	/**
	 * �޸Ĺ��ﳵ��Ʒ����
	 * ���� pid num
	 * ����ֵΪ boolean
	 */
	public boolean changeProductInCar(String uaccount, String pid, int num) throws Exception;
	
	
}
