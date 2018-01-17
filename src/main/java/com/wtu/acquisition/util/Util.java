package com.wtu.acquisition.util;

import org.springframework.context.ApplicationContext;

public class Util {
    private static ApplicationContext applicationContext;

	public static void setApplicationContext(ApplicationContext applicationContext) {
		Util.applicationContext = applicationContext;
	}
	//得到bean
    public static Object getBeanByName(String name) {
    	return applicationContext.getBean(name);
    }
}
