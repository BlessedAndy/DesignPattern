package com.andy.designpattern.factory;
/**
 * 
 * @author Andy
 * @date Feb 22, 2014
 * @time 8:34:51 PM
 */
public class Car {
	
	private static Car car = new Car();
	
	Car() {
	}
	
	public static Car getInstance(){
		return car;
	}
	
	public void run(){
		System.out.println("冒着烟奔跑中...");
	}

}
