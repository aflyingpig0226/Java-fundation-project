package user.dao;

import java.util.List;

import user.pojo.User;

public interface UserDAO {
	
	/**
	 * ����һ���û�
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	public boolean addUser(User user) throws Exception;
	
	/**
	 * ɾ��һ���û�
	 * @throws Exception 
	 */
	public boolean removeUser(String account) throws Exception;
	
	/**
	 * �޸�һ���û�
	 * @throws Exception 
	 */
	
	public boolean updateUser(User user) throws Exception;
	
	/**
	 * �����û�
	 * @throws Exception 
	 */
	
	public User getUserByAccount(String account) throws Exception;
	
	public List<User> getUserByAgeRange(int maxage, int minage) throws Exception;
	
	public List<User> getUserByVipRange(int maxvip, int minvip) throws Exception;
	
	public List<User> getUserByname(String name) throws Exception;
	
}
