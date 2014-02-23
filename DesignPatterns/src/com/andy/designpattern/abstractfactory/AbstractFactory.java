package com.andy.designpattern.abstractfactory;
/**
 * 抽象工厂用于设计一系列的操作，例如换皮肤，与普通工厂相比是可以产生一系列的产品，普通工厂
 * 在产生产品系列的时候会产生很多工厂，工厂泛滥。
 * 抽象工厂在产生新的产品的时候会有大的改动。
 * @author Andy
 * @date Feb 23, 2014
 * @time 11:12:47 AM
 */
public abstract class AbstractFactory {

	/*
	 * 这里的Vehicle、Weapon、Food也是接口或者抽象类
	 */
	abstract Vehicle createVehicle();
	abstract Weapon createWeapon();
	abstract Food createFood();
}
