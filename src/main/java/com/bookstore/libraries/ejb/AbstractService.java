package com.bookstore.libraries.ejb;

import javax.annotation.PostConstruct;
import javax.interceptor.Interceptors;

import org.apache.log4j.Logger;

import com.bookstore.libraries.interceptor.LogInterceptor;

@Interceptors({ LogInterceptor.class })
public abstract class AbstractService {

	protected static Logger logger;

	@PostConstruct
	private void init() {
		logger = Logger.getLogger(this.getClass());
	}
}