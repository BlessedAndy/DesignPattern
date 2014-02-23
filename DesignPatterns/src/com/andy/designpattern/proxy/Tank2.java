package com.andy.designpattern.proxy;

import java.util.concurrent.TimeUnit;
/**
 * 用继承实现代理，覆盖父类方法，并在方法中调用父类方法，在调用父类方法的前后加上需要的逻辑。
 * @author Andy
 * @date Feb 11, 2014
 * @time 4:23:20 PM
 */
public class Tank2 extends Tank {

	@Override
	public void move() {
		long start = System.currentTimeMillis();
		/*
		 * 从某种角度讲，这种也是代理，因为对move的调用都是调用父类的move
		 */
		super.move();
		long end = System.currentTimeMillis();
		System.out.println("Running time : "+(end-start));
	}

	
}
