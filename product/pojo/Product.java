package product.pojo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Product implements Serializable{
	private String pid;
	private String pname;
	private float price;
	private int num;
	private String categoryName;
	
	public Product(String pid, String pname, float price, int num, String categoryName) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.num = num;
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "[pid=" + pid + ", pname=" + pname + ", price=" + price + ", num=" + num + ", categoryName="
				+ categoryName + "]";
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
