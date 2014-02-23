package com.andy.spring.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ClassPathXmlApplicationContext implements BeanFactory{
	
	private Map<String,Object> container = new HashMap<String,Object>();

	public ClassPathXmlApplicationContext(String fileName) throws Exception{
		SAXReader reader = new SAXReader();
//		Document document = reader.read(this.getClass().getClassLoader().getResourceAsStream(fileName));
		Document document = reader.read("src/com/andy/spring/factory/applicationContext.xml");
		Element root = document.getRootElement();
		System.out.println(root);

		List list = document.selectNodes("//beans/bean");

		for(int i=0;i<list.size();i++){
			Element bean = (Element) list.get(i);
			String name = bean.attributeValue("name");
			String clazz = bean.attributeValue("class");
			Object o = Class.forName(clazz).newInstance();
			container.put(name, o);
		}

	}
	@Override
	public Object getBean(String name){
		return container.get(name);
	}

}
