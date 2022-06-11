package com.example.demo.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DbUtil {
	//private static Connection connection = null;

	
	private static SqlSessionFactory sqlSessionFactory = null;

	static {
		try {
			// add mybatis config file，and create an instance of SqlSessionFactory
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			//build a factory for the connection
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}

	public static void closeSqlSession(SqlSession sqlSession){
		if (sqlSession != null) {
			sqlSession.close();
		}
	}
	
}