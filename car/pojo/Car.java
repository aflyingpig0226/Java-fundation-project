package car.pojo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Car implements Serializable{
	
	private String uaccount;
	private String pid;
	private float price;
	private int num;
	
	@Override
	public String toString() {
		return "[uaccount=" + uaccount + ", pid=" + pid + ", price=" + price + ", num=" + num + "]";
	}
	public String getUaccount() {
		return uaccount;
	}
	public Car(String uaccount, String pid, float price, int num) {
		super();
		this.uaccount = uaccount;
		this.pid = pid;
		this.price = price;
		this.num = num;
	}
	public Car() {
		super();
	}
	public void setUaccount(String uaccount) {
		this.uaccount = uaccount;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
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
	
}
