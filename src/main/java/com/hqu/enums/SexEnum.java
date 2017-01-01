package com.hqu.enums;

/**
 * 性别枚举
 * 
 * @author jerome_s@qq.com
 */
public enum SexEnum implements IEnum {

	MAN(1, "男"), WOMAN(2, "女");

	private int key;
	private String value;

	private SexEnum(int key, String value) {
		this.key = key;
		this.value = value;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
