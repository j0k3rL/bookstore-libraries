package com.bookstore.libraries.interceptor;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.apache.log4j.Logger;

import com.bookstore.libraries.interceptor.annotation.LogIntercept;

@Priority(Interceptor.Priority.APPLICATION)
@Interceptor @LogIntercept
public class LogInterceptor {

	@AroundInvoke
	public Object intercept(InvocationContext context) throws Exception {

		Logger logger = Logger.getLogger(context.getTarget().getClass());

		String methodName = context.getMethod().getName();
		String className = context.getTarget().getClass().getName();

		logger.debug("Calling Method: " + className + "." + methodName);
		long timeBefore = System.currentTimeMillis();

		try {
			return context.proceed();
		} catch (Exception e) {
			logger.error("Error on calling method " + className + "." + methodName, e);
			throw e;
		} finally {
			long timeAfter = System.currentTimeMillis();
			logger.info("Method " + className + "." + methodName + " called in " + (timeAfter - timeBefore) + "ms");
		}
	}
}