package com.yxl.consumer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import javassist.expr.NewArray;

import com.yxl.provider.DemoService;
import com.yxl.util.SpringBeanHelper;

public class LogicThread implements Runnable{

	private static AtomicInteger ai = new AtomicInteger(1);
	
	@Override
	public void run() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DemoService demoService = (DemoService) SpringBeanHelper.getBean("demoService");
		String hello = demoService.sayHello("world"); 

		
		System.out.println(sdf.format(new Date()) + " = " + ai.getAndIncrement() + " : " + hello); 
	}

}
