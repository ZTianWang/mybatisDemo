package com.wnwn.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.wnwn.utils.DBFactory;

public class UserDao {

	/*先获取SqlSession*/
	private SqlSession sqlSession = DBFactory.getSqlSession();
	
	/**
	 * 查询记录
	 * @param name  通过命名空间找到对应sql语句
	 * @param obj  添加的对象
	 * @return  返回记录列表
	 */
	public List<Object> selectUserList(String name,Object obj) {
		List<Object> list = sqlSession.selectList(name, obj);
		return list;
	}
	
	/**
	 * 添加数据
	 * @return  返回影响行数
	 */
	public int addUser(String name,Object obj) {
		/*存在事务处理，需写try,catch*/
		try {
			/*得到影响行数*/
			int i = sqlSession.insert(name, obj);
			if (i>0) {
				/*提交事务
				 * 增删改操作必须得有*/
				sqlSession.commit();
			}
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			/*回滚事务*/
			sqlSession.rollback();
		}finally {
			sqlSession.close();
		}
		return 0;
	}
	
	public int updateUser(String name,Object obj) {
		try {
			int i = sqlSession.update(name, obj);
			if (i>0) {
				sqlSession.commit();
			}
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}finally {
			sqlSession.close();
		}
		return 0;
	}
	
	public int deleteUser(String name,Object obj) {
		try {
			int i = sqlSession.delete(name, obj);
			if (i>0) {
				sqlSession.commit();
			}
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}finally {
			sqlSession.close();
		}
		return 0;
	}
	
}
