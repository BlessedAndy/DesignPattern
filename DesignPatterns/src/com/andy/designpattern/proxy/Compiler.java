package com.andy.designpattern.proxy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

/**
 * 使用JDK 1.6 API 实现动态编译
 * @author Andy
 * @date Feb 11, 2014
 * @time 11:47:45 PM
 */
public class Compiler {

	public static void main(String[] args) throws Exception {
		
		String rt = "\r\n";
		String src = "package com.andy.designpattern.proxy;" + rt + 
				rt +
				"public class DynamicTank implements Moveable {" + rt + 
				"	private Moveable m;" + rt + 
				rt +
				"	public DynamicTank(Moveable m) {" + rt + 
				"		this.m = m;" + rt + 
				"	}" + rt + 
				rt +
				"	@Override" + rt + 
				"	public void move() {" + rt + 
				"       System.out.println(\"starting...\");" + rt +
				"		long start = currentTime();" + rt + 
				"       System.out.println(\"start time\" + start);" + rt +
				"		m.move();// 在Tank3 中调用Tank的move（）方法" + rt + 
				"		long end = currentTime();" + rt + 
				"		System.out.println(\"time : \" + (end - start));" + rt +
				"       System.out.println(\"ending...\");" + rt +
				"	}" + rt + 
				rt +
				"	private long currentTime() {" + rt + 
				"		long time = System.currentTimeMillis();" + rt + 
				"		return time;" + rt + 
				"	}" + rt + 
				"}" ;
	
		/*
		 * 拿到当前根路径, 然后组合成文件名
		 */
		String fileName = System.getProperty("user.dir") + 
				"/src/com/andy/designpattern/proxy/DynamicTank.java" ;
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
		//compile
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		System.out.println(compiler.getClass().getName());
		StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
		Iterable units = fileMgr.getJavaFileObjects(fileName);
		CompilationTask ct = compiler.getTask(null, fileMgr, null, null, null, units);
		ct.call();
		fileMgr.close();
		
		//load into memory and create an instance
		/*
		 * ClassLoader 回去java默认存放class文件的目录下load，但是本例没有把
		 * class文件放在bin目录下，所以使用URLClassLoader
		 */
		URL[] urls = new URL[] {new URL("file:/" + System.getProperty("user.dir" + "/src"))};
		URLClassLoader ul = new URLClassLoader(urls);
		Class c = ul.loadClass("com.andy.designpattern.proxy.DynamicTank");
		System.out.println(c);
		Constructor ctr = c.getConstructor(Moveable.class);
		Moveable m = (Moveable)ctr.newInstance(new Tank());
		m.move();
	}
	
}
