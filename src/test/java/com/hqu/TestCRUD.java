package com.hqu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hqu.model.User;
import com.hqu.util.MyBatisUtil;

/**
 * MyBatis增删改查例子
 * @author jerome_s@qq.com
 * @date 2015年11月27日 下午6:24:35 
 * @see 参考：http://blog.csdn.net/jerome_s/article/details/46340043
 * @see mybatis官方文档：http://mybatis.org/mybatis-3/zh/getting-started.html
 */
public class TestCRUD {

	SqlSession sqlSession = null;

	@Before
	public void before() throws IOException {
		sqlSession = MyBatisUtil.getSqlSessionFactory().openSession(true);
	}

	@After
	public void after() {
		// 你应该把这个关闭操作放到 finally 块中以确保每次都能执行关闭(就是每次使用完记得关闭)
		sqlSession.close(); // 释放资源
	}

	@Test
	public void testInsertUser() {
		User user = new User();
		user.setUsername("jerome");
		user.setSex("boy");
		user.setAddress("深圳");
		user.setScore(12f);

		int insertResult = sqlSession.insert("UserMapper.insertUser", user);
		System.out.println("insertResult = " + insertResult);
	}
	
	@Test
	public void testInsertUsers() {
		List<User> users = new ArrayList<>();
		
		User user1 = new User();
		user1.setUsername("jerome1");
		user1.setSex("boy");
		user1.setAddress("深圳");
		user1.setScore(12f);
		
		User user2 = new User();
		user2.setUsername("jerome2");
		user2.setSex("boy");
		user2.setAddress("深圳");
		user2.setScore(12f);
		
		users.add(user1);
		users.add(user2);
		
		int insertResult = sqlSession.insert("UserMapper.insertUsers", users);
		System.out.println("insertResult = " + insertResult);
	}
	
	@Test
	public void testInsertUsersMax() {
		List<User> users = new ArrayList<>();
		User user = null;
		for(int i = 0; i<100000; i ++){
			user = new User();
			user.setUsername("jerome" + i);
			user.setSex("boy");
			user.setAddress("深圳");
			user.setScore(i);
			users.add(user);
		}
		
		System.out.println("start insert ... ");
		long currtTime = new Date().getTime();
		int insertResult = sqlSession.insert("UserMapper.insertUsers", users);
		System.out.println("insertResult = " + insertResult);
		System.out.println("use time = " + (new Date().getTime() - currtTime));
	}
	
	@Test
	public void testDeleteUserById() {
		int deleteResult = sqlSession.delete("UserMapper.deleteUserById", 2);
		System.out.println("deleteResult = " + deleteResult);
	}
	
	@Test
	public void testUpdateUserById() {
		
		User user = new User();
		user.setId(2);
		user.setUsername("jerome");
		user.setSex("boy1");
		user.setAddress("深圳");
		user.setScore(12f);
		
		int updateResult = sqlSession.update("UserMapper.testUpdateUserById", user);
		System.out.println("deleteResult = " + updateResult);
	}
	
	/**
	 * 批量更新 需要在数据库连接url追加 &allowMultiQueries=true
	 * 表示 可以允许一次执行多条sql(通过分号分割)
	 * @author jerome_s@qq.com
	 */
	@Test
	public void testUpdateUsersById() {
		List<User> users = new ArrayList<>();
		
		User user1 = new User();
		user1.setId(5);
		user1.setUsername("jerome1");
		user1.setSex("boy");
		user1.setAddress("深圳");
		user1.setScore(12f);
		
		User user2 = new User();
		user2.setId(6);
		user2.setUsername("jerome2");
		user2.setSex("boy");
		user2.setAddress("深圳");
		user2.setScore(12f);
		
		users.add(user1);
		users.add(user2);
		
		int updatesResult = sqlSession.update("UserMapper.testUpdateUsersById", users);
		System.out.println("updatesResult = " + updatesResult);
	}
	
	@Test
	public void testSelectOne() {
		// 通过sqlSession操作数据库
		// 第一个参数: test是userMapper.xml的命名控件; findUserByNameuserMapper.xml定义的statement的id
		// 第二个参数: 输入参数
		User user1 = new User();
		user1.setUsername("jerome1");
		User user = sqlSession.selectOne("UserMapper.findUserByName", user1);
		System.out.println("user = " + user);
	}
	
	@Test
	public void testSelectList() {
		User user1 = new User();
		user1.setUsername("jerome1");
		List<User> users = sqlSession.selectList("UserMapper.findUserByName", user1);
		for (User user : users) {
			System.out.println("user.toString() = " + user.toString());
		}
	}
	
}
