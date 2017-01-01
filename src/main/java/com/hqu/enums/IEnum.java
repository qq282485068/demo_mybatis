package com.hqu.enums;

/**
 * 
 * @ClassName: IEnum 
 * @Description: 本系统所有枚举实现的接口 规范key value 用于MyBatis枚举映射
 * @author jerome_s@qq.com
 * @date 2015年11月29日 下午9:29:35 
 *
 */
public interface IEnum {
	
	int getKey();
	void setKey(int key);

	String getValue();
	void setValue(String value);
}
