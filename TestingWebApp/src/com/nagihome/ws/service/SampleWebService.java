package com.nagihome.ws.service;

import javax.jws.WebService;

@WebService
public interface SampleWebService {
	public com.nagihome.ws.domain.Person getDataFromWebService();
}
