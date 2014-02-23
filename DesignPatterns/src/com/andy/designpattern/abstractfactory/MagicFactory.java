package com.andy.designpattern.abstractfactory;

public class MagicFactory extends AbstractFactory{

	@Override
	Vehicle createVehicle() {
		return new Car();
	}

	@Override
	Weapon createWeapon() {
		return new MagicStick();
	}

	@Override
	Food createFood() {
		// TODO Auto-generated method stub
		return null;
	}
}
