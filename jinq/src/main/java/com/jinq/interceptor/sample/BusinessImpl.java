package com.jinq.interceptor.sample;

import com.jinq.interceptor.annotation.CouldDebugOut;

public class BusinessImpl implements BusinessInterface {

	@Override
	@CouldDebugOut
	public void doSomeThing() {

		System.out.println("do something impl");
		doParam("adfsdf");
	}
	
	@CouldDebugOut
	public void doParam(String name){
		
	}
	public void doNoDebug(){
		System.out.println("do nodebug impl");
	}

}
