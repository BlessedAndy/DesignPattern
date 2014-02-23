package com.andy.designpattern.factory;

public class Test {

	@org.junit.Test
	public void test() {
		Car car = Car.getInstance();
		Car car1 = Car.getInstance();
		if (car == car1) {
			System.out.println("Only One Car !");
		}
		car.run();

		Vehicle vehicle = new Plane();
		vehicle.run();

		PlaneFactory planeFac = new PlaneFactory();
		Plane plane = (Plane) planeFac.create();
		plane.run();
	}

}
