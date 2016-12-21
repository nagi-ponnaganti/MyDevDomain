package com.nagihome.ws.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nagihome.ws.service.SampleWebService;

public class SampleWSClient {

	
	@SuppressWarnings("resource")
	public SampleWSClient() {
		
		ClassPathXmlApplicationContext classPathXmlAppContext = new ClassPathXmlApplicationContext("classpath:com/nagihome/ws/client/beans.xml");
		classPathXmlAppContext.start();
		
		SampleWebService sampleWebService = (SampleWebService)classPathXmlAppContext.getBean("client");
		
		System.out.println(sampleWebService.getDataFromWebService().getName());
		System.out.println(sampleWebService.getDataFromWebService().getDescription());
		System.out.println(sampleWebService.getDataFromWebService().getAge());
		
	}
	
	public static void main(String[] args){
		new SampleWSClient();
	}
}
