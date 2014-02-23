package com.andy.designpattern.proxy.test;

import com.andy.designpattern.proxy.InvocationHandler;
import com.andy.designpattern.proxy.Proxy;

public class Client {
	public static void main(String[] args) throws Exception {
		UserMgr mgr = new UserMgrImpl();
		InvocationHandler h = new TransactionHandler(mgr);
		// TimeHandler h2 = new TimeHandler(h);
		UserMgr u = (UserMgr) Proxy.newProxyInstance(UserMgr.class, h);
		u.addUser();
	}
}
