package com.andy.spring.factory;

import java.util.Properties;

public abstract class Test {

	public static void main(String[] args) throws Exception {
		
		ClassPathXmlApplicationContext cpac = new ClassPathXmlApplicationContext("");
		Car car = (Car) cpac.getBean("car");
		Train train = (Train) cpac.getBean("train");
		car.run();
		train.run();
		
		//properties 配置文件的方式。
		/*Properties pros = new Properties();
		pros.load(Test.class.getClassLoader().getResourceAsStream("com/andy/spring/factory/bean.properties"));

		String vehicleType = pros.getProperty("VehicleType");
		Object o = Class.forName(vehicleType).newInstance();
		Vehicle v = (Vehicle)o;
		v.run();*/
		
	}

}
