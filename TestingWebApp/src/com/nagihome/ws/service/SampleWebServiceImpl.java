package com.nagihome.ws.service;

import javax.jws.WebService;

import com.nagihome.ws.domain.Person;

@WebService(endpointInterface = "com.nagihome.ws.service.SampleWebService")
public class SampleWebServiceImpl implements SampleWebService {

	@Override
	public Person getDataFromWebService() {
		Person a = new Person();
		a.setAge(1);
		a.setDescription("Description from Server!");
		a.setName("Name from Server");
		return a;
	}
}