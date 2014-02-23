/**
 * 在javaweb中使用的是interface，这里使用class来模拟
 */
package com.andy.designpattern.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Andy
 * 让FilterChain实现Filter接口，就可以保证FilterChain中可以添加其他FilterChain
 */
public class FilterChain implements Filter{
	List<Filter> filters = new ArrayList<Filter>();
	
	/**
	 * 返回值是自己，这样就可以每次加完新的Filter返回一个新的FilterChain,
	 * 方便Client Programmer使用链式编程。
	 * @param f
	 * @return
	 */
	public FilterChain addFilter(Filter f){
		filters.add(f);
		return this;
	}
	
	public void removeFilter(Filter f){
		filters.remove(f);
	}
	
	public String doFilter(String str){
		
		for(Filter f : filters){
			str = f.doFilter(str);
		}
		
		return str;
	}
}
