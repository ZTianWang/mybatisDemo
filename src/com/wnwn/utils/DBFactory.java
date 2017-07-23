package com.wnwn.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*整个项目只有一个*/
public class DBFactory {

	public static SqlSessionFactory sqlSessionFactory = null;
	
	static{
		/*加载配置文件mybatis-config.xml*/
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			/*第二个参数：指定需要连接的数据库配置environment的id
			 * 一个sqlSessionFactory对应一个environment*/
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream,"mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static SqlSessionFactory getFactory() {
		
		return sqlSessionFactory;
	}
	
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
	
}
