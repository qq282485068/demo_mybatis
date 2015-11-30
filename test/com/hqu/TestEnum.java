package com.hqu;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;

/**
 * 
 * @ClassName: Test 
 * @Description:  枚举测试(有两种)
 * @author jerome_s@qq.com
 * @date 2015年11月27日 下午6:24:35 
 * @see 参考：http://blog.csdn.net/jerome_s/article/details/46340043
 * @see mybatis官方文档：http://mybatis.org/mybatis-3/zh/getting-started.html
 */
public class TestEnum {

	SqlSession sqlSession = null;

	@Before
	public void before() throws IOException {
	
//		String resource = "SqlMapConfig.xml"; // mybatis的配置文件
//		InputStream is = Resources.getResourceAsStream(resource);
//
//		// 创建会话工厂
//		//SqlSessionFactoryBuilder 这个类可以被实例化、使用和丢弃，一旦创建了 SqlSessionFactory，就不再需要它了。因此 SqlSessionFactoryBuilder 实例的最佳范围是方法范围（也就是局部方法变量）
//		//SqlSessionFactory 一旦被创建就应该在应用的运行期间一直存在，没有任何理由对它进行清除或重建。使用 SqlSessionFactory 的最佳实践是在应用运行期间不要重复创建多次，多次重建 SqlSessionFactory 被视为一种代码“坏味道（bad smell）”。因此 SqlSessionFactory 的最佳范围是应用范围。有很多方法可以做到，最简单的就是使用单例模式或者静态单例模式。
//		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
//		//每个线程都应该有它自己的 SqlSession 实例。SqlSession 的实例不是线程安全的，因此是不能被共享的，所以它的最佳的范围是请求或方法范围。
//		sqlSession = sqlSessionFactory.openSession(); // 从会话工厂中的到会话
	}

	@After
	public void after() {
//		// 你应该把这个关闭操作放到 finally 块中以确保每次都能执行关闭(就是每次使用完记得关闭)
//		sqlSession.close(); // 释放资源
	}

//	@org.junit.Test
//	public void testSelectOne() {
//		// 通过sqlSession操作数据库
//		// 第一个参数：test是userMapper.xml的命名控件; findUserByNameuserMapper.xml定义的statement的id
//		// 第二个参数：输入参数
//		User user = sqlSession.selectOne("test.findUserByName", "jelly");
//		System.out.println(user);
//	}
//	
//	@org.junit.Test
//	public void testInsert() {
//
//		User user = new User();
//		user.setUsername("jelly");
//		user.setSex("女");
//		user.setAddress("深圳");
//		user.setScore(12f);
//
//		sqlSession.insert("test.insertUser", user);
//		
//		sqlSession.commit(); // 提交事务
//	}

}
