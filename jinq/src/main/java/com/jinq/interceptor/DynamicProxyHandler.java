package com.jinq.interceptor;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.jinq.interceptor.annotation.CouldDebugOut;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class DynamicProxyHandler implements MethodInterceptor {
	private Object business; // 被代理对象
	private InterceptProxy interceptor = new InterceptProxy(); // 拦截器

	public Object createProxy(Object target) {
		this.business = target;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.business.getClass());// 设置代理目标
		enhancer.setCallback(this);// 设置回调
		enhancer.setClassLoader(target.getClass().getClassLoader());
		return enhancer.create();
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		Object result = null;
		// 调用之前
		boolean showDebug=false;
		showDebug=method.isAnnotationPresent(CouldDebugOut.class);
//		for(Annotation anno:method.getAnnotations()){
//			if(anno.toString().indexOf("CouldDebugOut")>0){
//				showDebug=true;
//				 break;
//			}
//		}
		doBefore(showDebug,method,args);
		// 调用原始对象的方法
		result = proxy.invokeSuper(obj, args);
		// 调用之后
		doAfter(showDebug);
		return result;
	}

	private void doBefore(boolean show,Method method,Object[] args) {
		if(show){
			System.out.println("enter="+method.getDeclaringClass().getName()+"   "+method.getName());
			for(Object o:args){
				System.out.print("        param="+o.toString());
			}
			System.out.println();
		}
	}

	private void doAfter(boolean show) {
		if(show){
			
//			System.out.println("after method invoke");
		}
	}
}
