package product.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import database.DatabasePathConstant;
import database.FileOperationUtil;
import product.pojo.Product;

public class ProductDaoIMP implements ProductDao{
	
	FileOperationUtil<Product> tools = new FileOperationUtil<Product>();
	@Override
	public List<Product> getAllProduct() throws Exception {
		ArrayList<Product> arrayList = new ArrayList<Product>();
		HashMap<String, Product> readInfoProduct = tools.readinfo(DatabasePathConstant.PRODUCT_PATH);
		Collection<Product> values = readInfoProduct.values();
		for(Product product:values) {
			arrayList.add(product);
		}
		return arrayList;
	}

	@Override
	public List<Product> getProductByCategoryName(String categoryname) throws Exception {
		ArrayList<Product> arrayList = new ArrayList<>();
		HashMap<String, Product> fileOperationProduct = tools.readinfo(DatabasePathConstant.PRODUCT_PATH);
		Collection<Product> values = fileOperationProduct.values();
		for(Product tmp:values) {
			if (tmp.getCategoryName().equals(categoryname)) {
				arrayList.add(tmp);
			}
		}
		return arrayList;
	}

	@Override
	public List<Product> getProductByPrice(float minprice, float maxprice) throws Exception {
		ArrayList<Product> arrayList = new ArrayList<Product>();
		HashMap<String, Product> readInfoProduct = new FileOperationUtil<Product>().readinfo(DatabasePathConstant.PRODUCT_PATH);
		Collection<Product> values = readInfoProduct.values();
		for(Product tmp:values) {
			if (tmp.getPrice()>=minprice && tmp.getPrice()<=maxprice) {
				arrayList.add(tmp);
			}
		}
		return arrayList;
	}

	@Override
	public Product getProductById(String pid) throws Exception {
		HashMap<String, Product> readInfoProduct = new FileOperationUtil<Product>().readinfo(DatabasePathConstant.PRODUCT_PATH);
		Collection<Product> values = readInfoProduct.values();
		for(Product tmp:values) {
			if (tmp.getPid().equals(pid)) {
				return tmp;
			}
		}
		return null;
	}

	@Override
	public boolean addProduct(Product product) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(DatabasePathConstant.PRODUCT_PATH)));
		String string = bufferedReader.readLine();
		bufferedReader.close();
		if (string == null) {
			HashMap<String, Product> hashMap = new HashMap<>();
			hashMap.put(product.getPid(), product);
			tools.writeinfo(hashMap, DatabasePathConstant.PRODUCT_PATH);
		}else {
			HashMap<String, Product> readinfoProduct = tools.readinfo(DatabasePathConstant.PRODUCT_PATH);
			readinfoProduct.put(product.getPid(), product);
			tools.writeinfo(readinfoProduct, DatabasePathConstant.PRODUCT_PATH);
		}
		return true;
	}

	@Override
	public boolean updateProduct(Product product) throws Exception {
		HashMap<String, Product> readInfoProduct = tools.readinfo(DatabasePathConstant.PRODUCT_PATH);
		readInfoProduct.put(product.getPid(), product);
		tools.writeinfo(readInfoProduct, DatabasePathConstant.PRODUCT_PATH);
		return true;
	}

}
