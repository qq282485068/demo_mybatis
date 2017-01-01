package com.hqu.model;

import java.util.Date;

import com.hqu.enums.SexEnum;

/**
 * 
 * @author jerome_s@qq.com
 */
/**
 * 
 * @author jerome_s@qq.com
 */
public class User {
	private long id;
	private String user_name;
	private int age;
	private SexEnum sex;
	private Date birthday;
	private double score;

	public User() {
	}

	public User(String user_name, int age, SexEnum sex, Date birthday, double score) {
		super();
		this.user_name = user_name;
		this.age = age;
		this.sex = sex;
		this.birthday = birthday;
		this.score = score;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public SexEnum getSex() {
		return sex;
	}

	public void setSex(SexEnum sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", user_name=" + user_name + ", age=" + age + ", sex=" + sex + ", birthday="
				+ birthday + "]";
	}
}
