/**
 * 
 */
package com.nagihome.jaxb.marshall;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

/**
 * @author nageswararao
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		Country india = new Country();
		india.setCapital("Delhi");
		india.setName("India");
		india.setPopulation(1234567890);
		india.setImportance(1);

		Country uk = new Country();
		uk.setCapital("London");
		uk.setImportance(2);
		uk.setName("United Kingdom");
		uk.setPopulation(123456);

		List<Country> countries = new ArrayList<Country>();
		countries.add(india);
		countries.add(uk);
		Countries countris = new Countries();
		countris.setCountries(countries);

		JAXBContext jaxbContext = JAXBContext.newInstance(Country.class, Countries.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(india, new File("country_india.xml"));
		marshaller.marshal(india, System.out);

		marshaller.marshal(countris, System.out);
		
		Countries countries02 = new Countries();
		marshaller.marshal(countries02, System.out);
		
		
	}
}
