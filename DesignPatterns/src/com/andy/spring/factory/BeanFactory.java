package com.andy.spring.factory;
/**
 * 模仿Spring里的BeanFactory
 * @author Andy
 * @date Feb 23, 2014
 * @time 11:19:56 AM
 */
public interface BeanFactory {

	Object getBean(String name);
}
