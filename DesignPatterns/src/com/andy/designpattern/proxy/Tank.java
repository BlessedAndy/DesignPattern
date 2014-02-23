package com.andy.designpattern.proxy;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Tank implements Moveable {

	@Override
	public void move() {

	
		try {
			TimeUnit.MILLISECONDS.sleep(new Random().nextInt(10000));
//			Thread.sleep(new Random().nextInt(10000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
