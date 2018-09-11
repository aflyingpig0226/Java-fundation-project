package user.service;

import user.pojo.User;

public interface UserService {
	
	/**
	 * 增加一个用户
	 * @throws Exception 
	 */
	public boolean addUser(User user) throws Exception;
	
	/**
	 * 删除一个用户
	 */
	public boolean removeUser(String account) throws Exception;
	
	/**
	 * 更新用户
	 */
	public boolean updateUser(String account, String name) throws Exception;
	
	/**
	 * login
	 */
	
	public boolean login(String account, String password) throws Exception;
	
	public boolean register(String account, String name, String password1, String password2, int age, String phone, String addr) throws Exception;
	
}
