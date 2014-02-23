package com.andy.designpattern.factory;

public class PlaneFactory implements Factory {

	@Override
	public Vehicle create() {
		return new Plane();
	}
}
