package com.andy.designpattern.proxy;

import java.lang.reflect.Method;

/**
 * 动态获取方法
 * @author Andy
 * @date Feb 12, 2014
 * @time 11:23:15 AM
 */
public class MethodsTest {

	public static void main(String[] args) {
		Method[] methods = Moveable.class.getMethods();
		for(Method m : methods){
			System.out.println(m.getName());
		}
	}
}
