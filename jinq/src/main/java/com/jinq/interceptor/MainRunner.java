package com.jinq.interceptor;

import com.jinq.interceptor.sample.BusinessImpl;
import com.jinq.interceptor.sample.BusinessInterface;

public class MainRunner {
	public static void main(String args[]) {
		DynamicProxyHandler handler = new DynamicProxyHandler();
		BusinessImpl business =InterceptProxy.getRealObj(BusinessImpl.class);
		business.doSomeThing(); 
		business.doNoDebug();
	}
}

