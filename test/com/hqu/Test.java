package com.hqu;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;

import com.hqu.model.User;

public class Test {

	SqlSession sqlSession = null;

	@Before
	public void before() throws IOException {
	
		String resource = "SqlMapConfig.xml"; // mybatis的配置文件

		InputStream is = Resources.getResourceAsStream(resource);

		// 创建会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

		sqlSession = sqlSessionFactory.openSession(); // 从会话工厂中的到会话
	}

	@After
	public void after() {
		sqlSession.close(); // 释放资源
	}

	@org.junit.Test
	public void testSelect() {
		// 通过sqlSession操作数据库
		// 第一个参数：user.xml定义的statement的id
		// 第二个参数：输入参数
		User user = sqlSession.selectOne("test.findUserByName", "jelly");
		System.out.println(user);
	}
	
	@org.junit.Test
	public void testInsert() {

		User user = new User();
		user.setUsername("jelly");
		user.setSex("女");
		user.setAddress("深圳");
		user.setScore(12f);

		sqlSession.insert("test.insertUser", user);
		
		sqlSession.commit(); // 提交事务
	}

}
