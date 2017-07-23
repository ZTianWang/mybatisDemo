package com.wnwn.test;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wnwn.mapper.UserInfoWithAnnotateMapper;
import com.wnwn.po.UserInfo;
import com.wnwn.utils.DBFactory;

public class UserInfoWithAnnotate {

	SqlSession sqlSession = null;
	UserInfoWithAnnotateMapper mapper = null;
	
	@Before
	public void testBefore() {
		sqlSession = DBFactory.getSqlSession();
		mapper = sqlSession.getMapper(UserInfoWithAnnotateMapper.class);
	}
	
	@After
	public void testAfter() {
		sqlSession.close();
	}
	
	@Test
	public void selsctHashList() {
		List<HashMap> list = mapper.getUserHashListWA();
		for (HashMap map : list) {
			System.out.println("id:"+map.get("user_id")+" name:"+map.get("user_name")+" sex:"+map.get("user_sex"));
		}
	}
	
	@Test
	public void selsctUserList() {
		List<UserInfo> list = mapper.getUserListWA();
		for (UserInfo user : list) {
			System.out.println(user);
		}
	}
	
	@Test
	public void selectOneUser() {
		UserInfo user = mapper.selectOneUser(2,"王五");
		System.out.println(user);
	}
	
	@Test
	public void addUser() {
		UserInfo user = new UserInfo();
		user.setUserName("我去");
		user.setUserSex("男");
		try {
			int count = mapper.addUser(user);
			if (count > 0) {
				sqlSession.commit();
				System.out.println("成功");
				selsctUserList();
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
		user.setUserName("尼美");
		user.setUserSex("女");
		try {
			int count = mapper.updateUser(user);
			if (count > 0) {
				sqlSession.commit();
				System.out.println("成功");
				selsctUserList();
			}
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}
	}
	
	@Test
	public void deleteUser() {
		try {
			int count = mapper.deleteUser(8);
			if (count > 0) {
				sqlSession.commit();
				System.out.println("成功");
				selsctUserList();
			}
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}
	}
	
}
