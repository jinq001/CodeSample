package com.jinq.interceptor;

public class InterceptProxy {
		public static  Object getProxyObj(Object o){
			 
			DynamicProxyHandler cglibProxy=new DynamicProxyHandler();
			Object hw=cglibProxy.createProxy(o);
			return  hw;
		}
		public static <T> T getRealObj(Class<T> o){
			T cls;
			try {
				cls = o.newInstance();
			
			DynamicProxyHandler cglibProxy=new DynamicProxyHandler();
			T hw=(T)cglibProxy.createProxy(cls);
			return hw;
			} catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
}
