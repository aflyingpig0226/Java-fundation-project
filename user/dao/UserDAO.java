package user.dao;

import java.util.List;

import user.pojo.User;

public interface UserDAO {
	
	/**
	 * 增加一个用户
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	public boolean addUser(User user) throws Exception;
	
	/**
	 * 删除一个用户
	 * @throws Exception 
	 */
	public boolean removeUser(String account) throws Exception;
	
	/**
	 * 修改一个用户
	 * @throws Exception 
	 */
	
	public boolean updateUser(User user) throws Exception;
	
	/**
	 * 查找用户
	 * @throws Exception 
	 */
	
	public User getUserByAccount(String account) throws Exception;
	
	public List<User> getUserByAgeRange(int maxage, int minage) throws Exception;
	
	public List<User> getUserByVipRange(int maxvip, int minvip) throws Exception;
	
	public List<User> getUserByname(String name) throws Exception;
	
}
