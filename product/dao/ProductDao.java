package product.dao;

import java.util.List;

import product.pojo.Product;

public interface ProductDao {

	public List<Product> getAllProduct() throws Exception;
	
	public List<Product> getProductByCategoryName(String categoryname) throws Exception;
	
	public List<Product> getProductByPrice(float minprice, float maxprice) throws Exception;
	
	public Product getProductById(String pid) throws Exception;
	
	public boolean addProduct(Product product) throws Exception;
	
	public boolean updateProduct(Product product) throws Exception;

}
