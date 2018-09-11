package product.service;

import java.util.List;

import product.dao.ProductDao;
import product.dao.ProductDaoIMP;
import product.pojo.Product;

public class ProductServiceIMP implements ProductService{
	
	ProductDao productDao = new ProductDaoIMP();
	@Override
	public List<Product> getAllProducts() throws Exception {
		List<Product> allProduct = productDao.getAllProduct();
		return allProduct;
	}

	@Override
	public List<Product> getProductByCategoryName(String categoryName) throws Exception{
		List<Product> productByCategoryName = productDao.getProductByCategoryName(categoryName);
		if (productByCategoryName == null) {
			return null;
		}
		return productByCategoryName;
	}

	@Override
	public List<Product> getProductsByPrice(float minPrice, float maxPrice) throws Exception{
		List<Product> productByPrice = productDao.getProductByPrice(minPrice, maxPrice);
		if (productByPrice == null) {
			return null;
		}
		return productByPrice;
	}

	@Override
	public Product getProductById(String pid) throws Exception{
		Product productById = productDao.getProductById(pid);
		if (productById == null) {
			return null;
		}
		return productById;
	}

	@Override
	public boolean changeProductName(String pid, String pname) throws Exception{
		Product productById = productDao.getProductById(pid);
		if (productById != null) {
			productById.setPname(pname);
			return true;
		}
		return false;
	}

	@Override
	public boolean changeProductPrice(String pid, float price) throws Exception{
		Product productById = productDao.getProductById(pid);
		if (productById != null) {
			productById.setPrice(price);
			return true;
		}
		return false;
	}

	@Override
	public boolean changeProductNum(String pid, int num) throws Exception{
		Product productById = productDao.getProductById(pid);
		if (productById != null) {
			productById.setNum(num);
			return true;
		}
		return false;
	}

}
