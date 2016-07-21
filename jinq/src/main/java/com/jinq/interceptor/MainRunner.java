package com.jinq.interceptor;

import com.jinq.interceptor.sample.BusinessImpl;
import com.jinq.interceptor.sample.BusinessInterface;

public class MainRunner {
	public static void main(String args[]) {
		DynamicProxyHandler handler = new DynamicProxyHandler();
		BusinessImpl business =(BusinessImpl)InterceptProxy.getProxyObj(new BusinessImpl());
		business.doSomeThing();
//		BusinessInterface businessProxy = (BusinessInterface) handler.bind(business);
//		businessProxy.doSomeThing();
	}
}
