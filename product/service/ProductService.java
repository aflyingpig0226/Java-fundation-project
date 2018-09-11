package product.service;

import java.util.List;

import product.pojo.Product;

public interface ProductService {
	
	/**
	 * 查询所有商品 
	 * 参数 ：无
	 * 返回类型 list
	 * @throws Exception 
	 */
	public List<Product> getAllProducts() throws Exception;
	
	/**
	 * 按类别查询商品
	 * 参数 ： categoryName
	 * 返回类型 list
	 */
	public List<Product> getProductByCategoryName(String categoryName) throws Exception;
	
	/**
	 * 按价格查询商品
	 * 参数  minPrice, maxPrice
	 * 返回类型 list
	 */
	public List<Product> getProductsByPrice(float minPrice, float maxPrice) throws Exception;
	
	/**
	 * 根据id查询商品
	 * 参数： id
	 * 返回类型  product
	 */
	public Product getProductById(String pid) throws Exception;
	/**
	 * 根据商品信息添加商品到数据库
	 * 参数 ：string productInfo
	 * 返回类型  boolean
	 */
	
	/**
	 * 修改商品名称
	 * 参数： id, name
	 * 返回类型 boolean
	 */
	public boolean changeProductName(String pid, String pname) throws Exception;
	
	/**
	 * 修改商品价格
	 * 参数 id， price
	 * 返回类型 boolean
	 */
	public boolean changeProductPrice(String pid, float price) throws Exception;
	
	/**
	 * 修改商品数量
	 * 参数 id, num
	 * 返回类型 boolean
	 */
	public boolean changeProductNum(String pid, int num) throws Exception;

}
