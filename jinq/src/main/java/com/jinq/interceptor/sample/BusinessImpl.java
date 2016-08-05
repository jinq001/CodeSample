package com.jinq.interceptor.sample;

import com.jinq.interceptor.InterceptProxy;
import com.jinq.interceptor.annotation.CouldDebugOut;

public class BusinessImpl implements BusinessInterface {

	@Override
	@CouldDebugOut
	public void doSomeThing() {

		System.out.println("do something impl");
		doParam("adfsdf");
		 System.out.println("class="+Thread.currentThread() .getStackTrace()[1].getClassName()+" method==="+Thread.currentThread() .getStackTrace()[1].getMethodName());
		 System.out.println("parent class="+Thread.currentThread() .getStackTrace()[2].getClassName()+" method==="+Thread.currentThread() .getStackTrace()[2].getMethodName());
		 
	}
	
	@CouldDebugOut
	public void doParam(String name){
		InterceptProxy.printClassMethod(-1, name);
	}
	public void doNoDebug(){
		System.out.println("do nodebug impl");
		System.out.println("method==="+Thread.currentThread() .getStackTrace()[1].getMethodName());
	}

}
