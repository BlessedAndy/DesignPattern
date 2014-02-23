package com.andy.designpattern.proxy;

public class Client {
	public static void main(String[] args) throws Exception {
		/*
		 * 被代理对象
		 */
		Tank t = new Tank();
		
		/*
		 * 聚合比继承的好处是：
	
		TankTimeProxy ttp = new TankTimeProxy(t);
		TankLogProxy tlp = new TankLogProxy(ttp);
		
		tlp.move();*/
		/*
		Moveable m = (Moveable) MyProxy.newProxyInstance(Moveable.class);
		m.move();*/
		
		/*
		 * 代理逻辑处理
		 */
		InvocationHandler h = new TimeHandler(t);
		
		Moveable m = (Moveable)Proxy.newProxyInstance(Moveable.class, h);
		
		m.move();
	}
}
//可以对任意的对象、任意的接口方法，实现任意的代理