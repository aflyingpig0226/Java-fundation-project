package order.pojo;

public class Order {
	
	private String oid;
	private String uname;
	private String pname;
	private float price;
	private int num;
	private float amount;
	private String phone;
	private String address;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String oid, String uname, String pname, int num, float price, String phone, String address) {
		super();
		this.oid = oid;
		this.uname = uname;
		this.pname = pname;
		this.num = num;
		this.amount = price * num;
		this.phone = phone;
		this.address = address;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	public void setAount() {
		this.amount = price * num;
	}
	public float getAmount() {
		return amount;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "[oid=" + oid + ", uname=" + uname + ", pname=" + pname + ", num=" + num + ", amount=" + amount
				+ ", phone=" + phone + ", address=" + address + "]";
	}
	
}
