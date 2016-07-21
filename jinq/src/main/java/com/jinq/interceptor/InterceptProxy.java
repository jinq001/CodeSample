package com.jinq.interceptor;

public class InterceptProxy {
		public static  Object getProxyObj(Object o){
			 
			DynamicProxyHandler cglibProxy=new DynamicProxyHandler();
			Object hw=cglibProxy.createProxy(o);
			return  hw;
		}
}
