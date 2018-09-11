package menu;

import java.util.List;

import org.junit.Test;

import product.dao.ProductDaoIMP;
import product.pojo.Product;

public class protest {
	
	@Test
	public void test() throws Exception {
		
		Product product1 = new Product("1", "xigua", 1.1f, 10, "fruit");
		Product product2 = new Product("2", "chengzi", 2.2f, 20, "fruit");
		Product product3 = new Product("3", "shuangmianjiao", 3.3f, 30, "tools");
		Product product4 = new Product("4", "paper", 4.4f, 40, "life");
		
		ProductDaoIMP productDaoIMP = new ProductDaoIMP();
		productDaoIMP.addProduct(product1);
		productDaoIMP.addProduct(product2);
		productDaoIMP.addProduct(product3);
		productDaoIMP.addProduct(product4);
	}
	
	@Test
	public void test1() throws Exception{
		ProductDaoIMP productDaoIMP = new ProductDaoIMP();
		List<Product> allProduct = productDaoIMP.getAllProduct();
		for(Product tmp:allProduct) {
			System.out.println(tmp);
		}
		
	}
}
