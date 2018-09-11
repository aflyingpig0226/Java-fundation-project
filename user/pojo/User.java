package user.pojo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable{
	
	private String account;
	private String name;
	private String password;
	private int age;
	private int viplevel;
	private String phone;
	private String addr;
	
	@Override
	public String toString() {
		return "[account=" + account + ", name=" + name + ", password=" + password + ", age=" + age + ", viplevel="
				+ viplevel + ", phone=" + phone + ", addr=" + addr + "]";
	}
	
	public User() {
		super();
	}
	
	public User(String account, String name, String password, int age, int viplevel, String phone, String addr) {
		super();
		this.account = account;
		this.name = name;
		this.password = password;
		this.age = age;
		this.viplevel = viplevel;
		this.phone = phone;
		this.addr = addr;
	}
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getViplevel() {
		return viplevel;
	}
	public void setViplevel(int viplevel) {
		this.viplevel = viplevel;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
}
