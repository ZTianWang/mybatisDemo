package com.wnwn.test;



import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.wnwn.po.UserInfo;
import com.wnwn.utils.DBFactory;

public class UserSelectTest {

	@Test
	/*通过列表查询多条记录*/
	public void selectAll() {
		/*获取SqlSession*/
		SqlSession session = null;
		try {
			/*从SqlSessionFactory中获取SqlSession*/
			session = DBFactory.getFactory().openSession();
			/*参数为userinfo.xml中的<select>id*/
			List<UserInfo> list = session.selectList("com.wnwn.mapper.selectUser");
			if (list != null && list.size() > 0) {
				for (UserInfo userInfo : list) {
					System.out.println(userInfo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	@Test
	/*查询单个记录*/
	public void selectOne() {
		SqlSession session = null;
		try {
			session = DBFactory.getFactory().openSession();
			/*selectOne的第二个参数为查询条件*/
			UserInfo user = session.selectOne("com.wnwn.mapper.selectOneUser", 2);
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
}
