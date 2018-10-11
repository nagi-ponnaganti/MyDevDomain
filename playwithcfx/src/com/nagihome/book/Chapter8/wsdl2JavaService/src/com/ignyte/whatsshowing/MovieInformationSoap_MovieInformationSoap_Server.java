
package com.ignyte.whatsshowing;

import javax.xml.ws.Endpoint;

/**
 * This class was generated by Apache CXF 2.2.2
 * Wed Oct 28 16:41:36 IST 2009
 * Generated source version: 2.2.2
 * 
 */
 
public class MovieInformationSoap_MovieInformationSoap_Server{

    protected MovieInformationSoap_MovieInformationSoap_Server() throws Exception {
        System.out.println("Starting Server");
        Object implementor = new MovieInformationSoapImpl();
        String address = "http://www.ignyte.com/webservices/ignyte.whatsshowing.webservice/moviefunctions.asmx";
        Endpoint.publish(address, implementor);
    }
    
    public static void main(String args[]) throws Exception { 
        new MovieInformationSoap_MovieInformationSoap_Server();
        System.out.println("Server ready..."); 
        
        Thread.sleep(5 * 60 * 1000); 
        System.out.println("Server exiting");
        System.exit(0);
    }
}
