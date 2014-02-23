package com.andy.designpattern.abstractfactory;
/**
 * 默认系列
 * @author Andy
 * @date Feb 22, 2014
 * @time 9:30:56 PM
 */
public class DefaultFactory extends AbstractFactory{

	@Override
	Vehicle createVehicle() {
		return new Car();
	}

	@Override
	Weapon createWeapon() {
		return new AK47();
	}

	@Override
	Food createFood() {
		return new Apple();
	}
}
