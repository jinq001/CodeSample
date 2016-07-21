package com.jinq.interceptor.sample;

import com.jinq.interceptor.annotation.CouldDebugOut;

@CouldDebugOut
public class BusinessImpl implements BusinessInterface {

	@Override
	public void doSomeThing() {

		System.out.println("do something impl");
	}

}
