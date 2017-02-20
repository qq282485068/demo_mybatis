package com.hqu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hqu.enums.SexEnum;
import com.hqu.model.User;
import com.hqu.util.MyBatisUtil;

/**
 * MyBatis增删改查例子
 * 
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
	public void insertUserTest() {
		User user = new User("苏志达", 26, SexEnum.MAN, new Date(), 88.323d);

		int insertResult = sqlSession.insert("UserMapper.insertUser", user);
		System.out.println("insertResult = " + insertResult);
		System.out.println("user id = " + user.getId());
	}

	@Test
	public void insertUsersTest() {
		List<User> users = new ArrayList<>();
		users.add(new User("jerome", 26, SexEnum.MAN, new Date(), 99.3d));
		users.add(new User("jelly", 25, SexEnum.WOMAN, new Date(), 88.2d));

		int insertResult = sqlSession.insert("UserMapper.insertUsers", users);
		System.out.println("insertResult = " + insertResult);
	}

	@Test
	public void updateUserByMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("id", 1);
		map.put("user_name", "jerome100");

		int updateResult = sqlSession.update("UserMapper.updateUserByMap", map);
		System.out.println("updateResult = " + updateResult);
	}
	
	/**
	 * 批量更新 需要在数据库连接url追加 &allowMultiQueries=true 表示 可以允许一次执行多条sql(通过分号分割)
	 * 
	 * @author jerome_s@qq.com
	 */
	@Test
	public void updateUsersByUsers() {
		List<User> users = new ArrayList<>();
		users.add(new User("jerome", 26, SexEnum.MAN, new Date(), 80.3d));
		users.add(new User("jelly", 25, SexEnum.WOMAN, new Date(), 80.2d));
		
		int updatesResult = sqlSession.update("UserMapper.updateUsersByUsers", users);
		System.out.println("updatesResult = " + updatesResult);
	}
	
	@Test
	public void deleteUserByIdTest() {
		int deleteResult = sqlSession.delete("UserMapper.deleteUserById", 2);
		System.out.println("deleteResult = " + deleteResult);
	}
	
	@Test
	public void selectOneUserByIdTest() {
		User user = sqlSession.selectOne("UserMapper.selectOneUserById", 1l);
		System.out.println("user = " + user.toString());
	}
	
	@Test
	public void selectUsersByIdsTest() {
		Map<String, Object> map = new HashMap<>();
		String ids = "1,2,3,4";
		map.put("ids", ids.split(",")); // 传入数组，防止mapper$的SQL注入攻击
		
		List<User> users = sqlSession.selectList("UserMapper.selectUsersByIds", map);
		for (User u : users) {
			System.out.println(u.toString());
		}
	}
	
	@Test
	public void selectUsersByMapTest() {
		Map<String, Object> map = new HashMap<>();
		// map.put("id", "1");
		map.put("user_name", "jerome");
		
		List<User> users = sqlSession.selectList("UserMapper.selectUsersByMap", map);
		for (User u : users) {
			System.out.println(u.toString());
		}
	}
	
	@Test
	public void selectUsers4EnumTest() {
		List<User> users = sqlSession.selectList("UserMapper.selectUsers4Enum");
		for (User u : users) {
			System.out.println(u.toString());
		}
	}

	/**
	 * 调用存储过程
	 * 
	 * @author jerome_s@qq.com
	 */
	@Test
	public void callProcedureTest() {
		// sql脚本 p_test.sql
		
		Map<String, Object> map = new HashMap<>();
		map.put("p_user_id", 1L);
		sqlSession.selectOne("UserMapper.callProcedureTest", map);
		
		// 取得存储过程的返回值
		System.out.println("p_result = " + map.get("p_result"));
		
	}

}
