package product.service;

import java.util.List;

import product.pojo.Product;

public interface ProductService {
	
	/**
	 * ��ѯ������Ʒ 
	 * ���� ����
	 * �������� list
	 * @throws Exception 
	 */
	public List<Product> getAllProducts() throws Exception;
	
	/**
	 * ������ѯ��Ʒ
	 * ���� �� categoryName
	 * �������� list
	 */
	public List<Product> getProductByCategoryName(String categoryName) throws Exception;
	
	/**
	 * ���۸��ѯ��Ʒ
	 * ����  minPrice, maxPrice
	 * �������� list
	 */
	public List<Product> getProductsByPrice(float minPrice, float maxPrice) throws Exception;
	
	/**
	 * ����id��ѯ��Ʒ
	 * ������ id
	 * ��������  product
	 */
	public Product getProductById(String pid) throws Exception;
	/**
	 * ������Ʒ��Ϣ�����Ʒ�����ݿ�
	 * ���� ��string productInfo
	 * ��������  boolean
	 */
	
	/**
	 * �޸���Ʒ����
	 * ������ id, name
	 * �������� boolean
	 */
	public boolean changeProductName(String pid, String pname) throws Exception;
	
	/**
	 * �޸���Ʒ�۸�
	 * ���� id�� price
	 * �������� boolean
	 */
	public boolean changeProductPrice(String pid, float price) throws Exception;
	
	/**
	 * �޸���Ʒ����
	 * ���� id, num
	 * �������� boolean
	 */
	public boolean changeProductNum(String pid, int num) throws Exception;

}
