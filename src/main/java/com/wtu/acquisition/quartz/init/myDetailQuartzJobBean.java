package com.wtu.acquisition.quartz.init;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class myDetailQuartzJobBean extends QuartzJobBean {
	private String targetObject;
	private String targeMethod;
	private ApplicationContext ctx;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		Object targetObject = this.ctx.getBean(this.targetObject);
		Method m = null;
		try {
			m = targetObject.getClass().getMethod(this.targeMethod, new Class[] { JobExecutionContext.class });
		} catch (NoSuchMethodException | SecurityException e1) {
			e1.printStackTrace();
		}
		try {
			m.invoke(targetObject, new Object[] { context });
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public void setTargetObject(String targetObject) {
		this.targetObject = targetObject;
	}

	public void setTargeMethod(String targeMethod) {
		this.targeMethod = targeMethod;
	}

	public void setCtx(ApplicationContext ctx) {
		this.ctx = ctx;
	}
}
