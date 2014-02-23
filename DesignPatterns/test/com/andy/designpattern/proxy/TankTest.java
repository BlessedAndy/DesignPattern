package com.andy.designpattern.proxy;

import static org.junit.Assert.*;

import org.junit.Test;

public class TankTest {

	@Test
	public final void test() {
		Tank tank = new Tank();
		long start = System.currentTimeMillis();
		tank.move();
		long end = System.currentTimeMillis();
		/*
		 * 在方法体外测试发现和在方法体内测试结果一样。
		 */
		System.out.println("Test time : "+(end-start));
	}

}
