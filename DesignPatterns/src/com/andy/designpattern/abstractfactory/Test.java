package com.andy.designpattern.abstractfactory;
/**
 * 抽象工厂用于一些列的操作，例如换皮肤
 * @author Andy
 * @date Feb 23, 2014
 * @time 11:11:59 AM
 */
public class Test {

	public static void main(String[] args) {
		
			AbstractFactory fac = new DefaultFactory();
			Vehicle v = fac.createVehicle();
			v.run();
			Food f = fac.createFood();
			f.printName();
			Weapon w = fac.createWeapon();
			w.shoot();
		
	}

}
