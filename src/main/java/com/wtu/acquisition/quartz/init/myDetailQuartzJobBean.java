package com.wtu.acquisition.quartz.init;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class myDetailQuartzJobBean extends QuartzJobBean implements Serializable{
	/**
	 * 
	 */
	private static Logger Log = LoggerFactory.getLogger(myDetailQuartzJobBean.class);
	private static final long serialVersionUID = 5371073376955828740L;
	private String targetObject;
	private String targeMethod;
	private ApplicationContext ctx;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		Object targetObject = this.ctx.getBean(this.targetObject);
		Method m = null;
		try {
			m = targetObject.getClass().getMethod(this.targeMethod, new Class[] { JobExecutionContext.class });
			m.invoke(targetObject, new Object[] { context });
		} catch (NoSuchMethodException | SecurityException e1) {
			Log.error("错误....", e1);
		}
		catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			Log.error("错误....", e);
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
