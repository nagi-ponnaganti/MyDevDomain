/**
 * 
 */
package com.nagihome.jsfdemo.events;

import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

/**
 * @author nageswararao
 *
 */
public class LocaleChangeListener implements ValueChangeListener {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.faces.event.ValueChangeListener#processValueChange(javax.faces.
	 * event.ValueChangeEvent)
	 */
	@Override
	public void processValueChange(ValueChangeEvent event) throws AbortProcessingException {

		CountryData countryData = (CountryData) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("countryData");
		countryData.setCoutrySelected(event.getNewValue().toString());
	}

}
