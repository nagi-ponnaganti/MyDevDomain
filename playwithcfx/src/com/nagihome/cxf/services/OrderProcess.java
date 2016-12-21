/**
 * 
 */
package com.nagihome.cxf.services;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author nageswararao
 *
 */
@WebService
public interface OrderProcess {
	
	@WebMethod
	String processOrder(Order order);
	
}
