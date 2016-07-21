package com.jinq.interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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
		doBefore();
		// 调用原始对象的方法
		result = proxy.invokeSuper(obj, args);
		// 调用之后
		doAfter();
		return result;
	}

	private void doBefore() {
		System.out.println("before method invoke");
	}

	private void doAfter() {
		System.out.println("after method invoke");
	}
}
