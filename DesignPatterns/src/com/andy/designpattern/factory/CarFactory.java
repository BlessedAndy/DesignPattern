package com.andy.designpattern.factory;

public class CarFactory implements Factory {

	@Override
	public Vehicle create() {
		return (Vehicle) new Car();
	}

}
