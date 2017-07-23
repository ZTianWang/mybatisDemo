package com.wnwn.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wnwn.mapper.UserInfoMapper;
import com.wnwn.po.UserInfo;
import com.wnwn.utils.DBFactory;

public class MultiparamPassing {

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
	public void selsctListByConstant() {
		List<UserInfo> list = mapper.selectUserByConstant("张三","男");
		for (UserInfo user : list) {
			System.out.println(user);
		}
	}
	
	@Test
	public void selsctListByEntity() {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserName("王五");
		userInfo.setUserSex("男");
		List<UserInfo> list = mapper.selectUserByEntity(userInfo);
		for (UserInfo user : list) {
			System.out.println(user);
		}
	}
	
	@Test
	public void selsctListByMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "我去");
		map.put("sex", "男");
		List<UserInfo> list = mapper.selectUserByMap(map);
		for (UserInfo user : list) {
			System.out.println(user);
		}
	}
	
}
