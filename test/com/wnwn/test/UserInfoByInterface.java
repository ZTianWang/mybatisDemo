package com.wnwn.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wnwn.mapper.UserInfoMapper;
import com.wnwn.po.UserInfo;
import com.wnwn.utils.DBFactory;

public class UserInfoByInterface {

	SqlSession sqlSession = null;
	UserInfoMapper mapper = null;
	
	@Before
	public void testBefore() {
		sqlSession = DBFactory.getSqlSession();
		mapper = sqlSession.getMapper(UserInfoMapper.class);
	}
	
	@After
	public void testAfter() {
		sqlSession.close();
	}
	
	@Test
	public void selsctList() {
		UserInfo userInfo = new UserInfo();
		List<UserInfo> list = mapper.selectUser(userInfo);
		for (UserInfo user : list) {
			System.out.println(user);
		}
	}
	
	@Test
	public void selectOneUser() {
		UserInfo user = mapper.selectOneUser(2);
		System.out.println(user);
	}
	
	@Test
	public void addUser() {
		UserInfo user = new UserInfo();
		user.setUserName("ssss");
		user.setUserSex("1");
		try {
			int count = mapper.addUser(user);
			if (count > 0) {
				sqlSession.commit();
				System.out.println("成功");
				selsctList();
			}
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}
	}
	
	@Test
	public void updateUser() {
		UserInfo user = new UserInfo();
		user.setUserId(4);
		user.setUserName("阿萨德");
		user.setUserSex("2");
		try {
			int count = mapper.updateUser(user);
			if (count > 0) {
				sqlSession.commit();
				System.out.println("成功");
				selsctList();
			}
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}
	}
	
	@Test
	public void deleteUser() {
		try {
			int count = mapper.deleteUser(7);
			if (count > 0) {
				sqlSession.commit();
				System.out.println("成功");
				selsctList();
			}
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}
	}
	
}
