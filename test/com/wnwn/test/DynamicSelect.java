package com.wnwn.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wnwn.mapper.UserInfoMapper;
import com.wnwn.po.UserInfo;
import com.wnwn.utils.DBFactory;

public class DynamicSelect {

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
//		userInfo.setUserId(10);
//		userInfo.setUserName("张三");
		List<UserInfo> list = mapper.selectUserDynamic(userInfo);
		for (UserInfo user : list) {
			System.out.println(user);
		}
	}
	
	@Test
	public void selsctList1() {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId(10);
		userInfo.setUserName("张三");
		
		List<UserInfo> list = mapper.selectUserDynamic1(userInfo);
		for (UserInfo user : list) {
			System.out.println(user);
		}
	}
	
	@Test
	public void selsctList2() {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId(10);
		userInfo.setUserName("张三");
		List<UserInfo> list = mapper.selectUserDynamic2(userInfo);
		for (UserInfo user : list) {
			System.out.println(user);
		}
	}
	
	@Test
	public void updateUser() {
		UserInfo user = new UserInfo();
		user.setUserId(4);
//		user.setUserName("阿萨德");
		user.setUserSex("男");
		try {
			int count = mapper.updateUserDynamic(user);
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
	public void selsctByIds() {
		UserInfo userInfo = new UserInfo();
		List<Integer> ids= new ArrayList<>();
		ids.add(3);
		ids.add(4);
		userInfo.setUserIds(ids);
		
		List<UserInfo> list = mapper.selectByIdList(userInfo);
		for (UserInfo user : list) {
			System.out.println(user);
		}
	}
	
}
