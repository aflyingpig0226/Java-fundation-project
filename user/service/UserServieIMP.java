package user.service;

import java.util.HashMap;

import database.DatabasePathConstant;
import database.FileOperationUtil;
import database.VipConstant;
import user.dao.UserDAO;
import user.dao.UserDaoIMP;
import user.pojo.User;

public class UserServieIMP implements UserService{
	
	FileOperationUtil<User> tools = new FileOperationUtil<>();
	UserDAO userdao = new UserDaoIMP();
	@Override
	public boolean addUser(User user) throws Exception {
		boolean addUser = userdao.addUser(user);
		return addUser;
	}

	@Override
	public boolean removeUser(String account) throws Exception {
		boolean removeUser = userdao.removeUser(account);
		return removeUser;
	}

	@Override
	public boolean updateUser(String account, String name) throws Exception {
		User userByAccount = userdao.getUserByAccount(account);
		if (userByAccount == null) {
			return false;
		}
		userByAccount.setName(name);
		return true;
	}

	@Override
	public boolean login(String account, String password) throws Exception {
		HashMap<String, User> readinfo = tools.readinfo(DatabasePathConstant.USER_PATH);
		if (readinfo.containsKey(account)) {
			if (readinfo.get(account).getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean register(String account, String name, String password1, String password2, int age, String phone, String addr) throws Exception {
		HashMap<String, User> readinfo = tools.readinfo(DatabasePathConstant.USER_PATH);
		if (readinfo.containsKey(account)) {
			return false;
		}else {
			if (password1.equals(password2)) {
				User user = new User(account, name, password1, age, VipConstant.VIPLEVEL1, phone, addr);
				readinfo.put(user.getAccount(), user);
				tools.writeinfo(readinfo, DatabasePathConstant.USER_PATH);
			}
		}
		return true;
	}



}
