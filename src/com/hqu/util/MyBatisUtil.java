package com.hqu.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory sqlSessionFactory;

	static {
		try {
			Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
			
			// 创建会话工厂
			// SqlSessionFactoryBuilder 这个类可以被实例化、使用和丢弃，一旦创建了 SqlSessionFactory，就不再需要它了。
			// 因此 SqlSessionFactoryBuilder 实例的最佳范围是方法范围（也就是局部方法变量）
			// SqlSessionFactory 一旦被创建就应该在应用的运行期间一直存在，没有任何理由对它进行清除或重建。
			// 使用 SqlSessionFactory 的最佳实践是在应用运行期间不要重复创建多次，多次重建 SqlSessionFactory 被视为一种代码“坏味道（bad smell）”。
			// 因此 SqlSessionFactory 的最佳范围是应用范围。有很多方法可以做到，最简单的就是使用单例模式或者静态单例模式。
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
			// 每个线程都应该有它自己的 SqlSession 实例。SqlSession 的实例不是线程安全的，因此是不能被共享的，所以它的最佳的范围是请求或方法范围。
			// 从会话工厂中的到会话，在每次需要使用的地方调用
			// sqlSession = sqlSessionFactory.openSession(); 
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	
}
