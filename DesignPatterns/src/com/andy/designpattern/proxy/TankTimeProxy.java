package com.andy.designpattern.proxy;
/**
 * 聚合方式实现代理，实现与被代理对象同样的接口，然后调用被代理对象的方法，在被代理对象的
 * 方法前后加上相应的逻辑。 这里就涉及到代理了，只不过是静态代理。
 * @author Andy
 * @date Feb 11, 2014
 * @time 4:15:21 PM
 */
public class TankTimeProxy implements Moveable{

	private Moveable m;
	
	public TankTimeProxy(Moveable m){
		this.m = m;
	}
	
	@Override
	public void move() {

		long start = currentTime();
		m.move();//在Tank3 中调用Tank的move（）方法
		long end = currentTime();
		System.out.println("Time : "+(end-start));
	}

	private long currentTime() {
		long time = System.currentTimeMillis();
		return time;
	}

}
