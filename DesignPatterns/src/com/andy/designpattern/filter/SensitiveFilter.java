package com.andy.designpattern.filter;

public class SensitiveFilter implements Filter {

	@Override
	public String doFilter(String str) {
		/**
		 * process sensitive words
		 */
		String r = str.replace("被就业", "就业").replace("敏感", "");
		return r;
	}

}
