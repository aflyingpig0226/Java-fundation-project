package menu;

import org.junit.Test;

import database.VipConstant;
import user.dao.UserDaoIMP;
import user.pojo.User;
import user.service.UserServieIMP;

public class UserTest {
	
	@Test
	public void testAddUser() throws Exception {
		User user1 = new User("ruibaba", "shirui", "123456", 21, VipConstant.VIPLEVEL1, "123456789", "四川");
		User user2 = new User("dapangzi", "chenxing", "123456", 21, VipConstant.VIPLEVEL2, "123456789", "四川");
		User user3 = new User("zhujiejie", "chenshu", "123456", 21, VipConstant.VIPLEVEL3, "123456789", "四川");
		User user4 = new User("dengwugui", "dengbo", "123456", 21, VipConstant.VIPLEVEL2, "123456789", "四川");
		User user5 = new User("dengwugui", "shirui", "123456", 21, VipConstant.VIPLEVEL2, "123456789", "四川");
		
		UserDaoIMP userDaoIMP = new UserDaoIMP();
		userDaoIMP.addUser(user4);
		userDaoIMP.addUser(user1);
		userDaoIMP.addUser(user2);
		userDaoIMP.addUser(user3);
		userDaoIMP.addUser(user5);
		
		UserServieIMP userServieIMP = new UserServieIMP();
		boolean login = userServieIMP.login("ruibaba", "123456");
		System.out.println(login);

	}
}
