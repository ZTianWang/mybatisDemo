package com.wnwn.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.wnwn.dao.UserDao;
import com.wnwn.po.UserInfo;

/**
 * 通过Dao做数据库操作
 * @author apple
 *
 */
public class UserTestByDao {
	
	UserDao dao = null;
	
	@Before
	public void testBefore() {
		dao = new UserDao();
	}
	
	@Test
	public void selectUser(){
		
		UserInfo userInfo = new UserInfo();
		userInfo.setUserName("nima");
		
		/*将po传入dao
		 * 若查询全部记录则第二个参数传null*/
		List<Object> list = dao.selectUserList("com.wnwn.mapper.selectUserDynamic",userInfo);
//		List<Object> list = dao.getList("com.wnwn.mapper.selectUserByDao",userInfo);
		
		for (Object o : list) {
			UserInfo user = (UserInfo)o;
			System.out.println(user);
		}
	}
	
	@Test
	public void addUser() {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserName("请问");
		userInfo.setUserSex("女");
		
		int i = dao.addUser("com.wnwn.mapper.addUser", userInfo);
		if (i > 0) {
			System.out.println("成功");
		}else {
			System.out.println("失败");
		}
	}
	
	@Test
	public void updateUser() {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId(3);
		userInfo.setUserName("nima");
		userInfo.setUserSex("nan");
		
		int i = dao.addUser("com.wnwn.mapper.updateUser", userInfo);
		if (i > 0) {
			System.out.println("成功");
		}else {
			System.out.println("失败");
		}
	}
	
	@Test
	public void deleteUser() {
		int i = dao.addUser("com.wnwn.mapper.deleteUser", 5);
		if (i > 0) {
			System.out.println("成功");
		}else {
			System.out.println("失败");
		}
	}

}
