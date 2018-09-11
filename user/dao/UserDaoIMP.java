package user.dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import database.DatabasePathConstant;
import database.FileOperationUtil;
import user.pojo.User;

public class UserDaoIMP implements UserDAO{
	
	FileOperationUtil<User> tools = new FileOperationUtil<User>();
	@Override
	public boolean addUser(User user) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(DatabasePathConstant.USER_PATH));
		String string = bufferedReader.readLine();
		bufferedReader.close();
		if (string == null) {
			HashMap<String, User> hashMap = new HashMap<>();
			hashMap.put(user.getAccount(), user);
			tools.writeinfo(hashMap, DatabasePathConstant.USER_PATH);
		}else {
			HashMap<String, User> readinfo = tools.readinfo(DatabasePathConstant.USER_PATH);
			readinfo.put(user.getAccount(), user);
			tools.writeinfo(readinfo, DatabasePathConstant.USER_PATH);
		}
		
		HashMap<String, User> readInfo = tools.readinfo(DatabasePathConstant.USER_PATH);
		readInfo.put(user.getAccount(), user);
		tools.writeinfo(readInfo, DatabasePathConstant.USER_PATH);
		return true;
	}

	@Override
	public boolean removeUser(String account) throws Exception {

		HashMap<String, User> readInfo = tools.readinfo(DatabasePathConstant.USER_PATH);
		User remove = readInfo.remove(account);
		if (remove == null) {
			return false;
		}
		
		tools.writeinfo(readInfo, DatabasePathConstant.USER_PATH);
		return true;
	}

	@Override
	public boolean updateUser(User user) throws Exception {
		HashMap<String, User> readInfo = tools.readinfo(DatabasePathConstant.USER_PATH);
		readInfo.put(user.getAccount(), user);
		tools.writeinfo(readInfo, DatabasePathConstant.USER_PATH);
		return true;
	}

	@Override
	public User getUserByAccount(String account) throws Exception {
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(DatabasePathConstant.USER_PATH));
		@SuppressWarnings("unchecked")
		HashMap<String, User> hashMap = (HashMap<String, User>) objectInputStream.readObject();
		objectInputStream.close();
		if (hashMap.containsKey(account)) {
			return hashMap.get(account);
		}else {
			return null;
		}
	}

	@Override
	public List<User> getUserByAgeRange(int maxage, int minage) throws Exception {
		ArrayList<User> arrayList = new ArrayList<User>();
		HashMap<String, User> readInfo = tools.readinfo(DatabasePathConstant.USER_PATH);
		Collection<User> values = readInfo.values();
		for(User tmp:values) {
			if (tmp.getAge()>=minage && tmp.getAge()<=maxage) {
				arrayList.add(tmp);
			}
		}
		return arrayList;
	}

	@Override
	public List<User> getUserByVipRange(int maxvip, int minvip) throws Exception {
		ArrayList<User> arrayList = new ArrayList<User>();
		HashMap<String, User> readInfo = tools.readinfo(DatabasePathConstant.USER_PATH);
		Collection<User> values = readInfo.values();
		for(User tmp:values) {
			if (tmp.getAge()>=minvip && tmp.getAge()<=maxvip) {
				arrayList.add(tmp);
			}
		}
		return arrayList;
	}

	@Override
	public List<User> getUserByname(String name) throws Exception {
		ArrayList<User> arrayList = new ArrayList<User>();
		HashMap<String, User> readInfo = tools.readinfo(DatabasePathConstant.USER_PATH);
		Collection<User> values = readInfo.values();
		for(User tmp:values) {
			if (tmp.getName().contains(name)) {
				arrayList.add(tmp);
			}
		}
		return arrayList;
	}

}
