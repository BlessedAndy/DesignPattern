package com.andy.designpattern.proxy;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;

/**
 * 这里字符串就是 TankTimeProxy.java
 * 这个例子是整个 模拟 JDK动态代理的一个半成品, 体现中间过程, 较完整的可参考  同包下的Proxy.java
 * @author Andy
 * @date Feb 11, 2014
 * @time 11:35:31 PM
 */
public class MyProxy {

	public static Object newProxyInstance(Class intfac) throws Exception{//将接口穿进去就会动态实现任何接口
		/*
		 * 实现动态编译：JDK 1.6 Compiler API, CGlib, ASM
		 */
		String rt = "\r\n";
		StringBuilder methodStr = new StringBuilder();
		Method[] methods = intfac.getMethods();
		for(Method m : methods){
			methodStr.append(rt +
					"	@Override" + rt +
					"	public void "+m.getName()+"() {" + rt +
					"		long start = System.currentTimeMillis();" + rt +
					"		System.out.println(\"start time : \" + start); " + rt +
					"		m."+m.getName()+"();//在Tank3 中调用Tank的move（）方法" + rt +
					"		long end = System.currentTimeMillis();" + rt +
					"		System.out.println(\"time : \"+(end-start)); " + rt +
					"}" + rt +
					rt);
		}
		
		String src = 
		"package com.andy.designpattern.proxy;" + rt +
		rt +
		"public class DynamicTank implements " + intfac.getSimpleName() +"{" + rt +

		"	private " + intfac.getSimpleName() +" m;" + rt +
		rt +
		"	public DynamicTank(" + intfac.getSimpleName() +" m){" + rt +
		"		this.m = m;" + rt +
		"	}" + rt +
		
		methodStr.toString()

		+ rt +
		"}";
		
		/*
		 * 拿到当前根路径, 然后组合成文件名
		 */
		String fileName = 
//				System.getProperty("user.dir")+
				 "E:/CodeTest/com/andy/designpattern/proxy/DynamicTank.java";
		/*
		 * 将代码输出到文件中去
		 */
		File f = new File(fileName);
		FileWriter fw = new FileWriter(f);
		fw.write(src);
		fw.flush();
		fw.close();

		/*
		 * 对文件编译, JDK 1.6 提供的java默认编译器功能
		 */
		// compile
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		System.out.println(compiler.getClass().getName());
		StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null,
				null, null);
		Iterable units = fileMgr.getJavaFileObjects(fileName);
		CompilationTask ct = compiler.getTask(null, fileMgr, null, null, null,
				units);
		ct.call();
		fileMgr.close();

		// load into memory and create an instance
		/*
		 * ClassLoader 回去java默认存放class文件的目录下load，但是本例没有把
		 * class文件放在bin目录下，所以使用URLClassLoader
		 */
		URL[] urls = new URL[] { new URL("file:/E:/CodeTest/")};
//				 System.getProperty("user.dir" + "/src")) };
		URLClassLoader ul = new URLClassLoader(urls);
		Class c = ul.loadClass("com.andy.designpattern.proxy.DynamicTank");
		System.out.println(c);
		Constructor ctr = c.getConstructor(Moveable.class);
		Object m = ctr.newInstance(new Tank());
		
		return m;
	}
}
