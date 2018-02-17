package com.nagihome.javafx.chapter02;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Monitor {

    private static final String DEFAULT_SCREEN_TYPE = "flat";
    private StringProperty screenType;

    public String getScreenType() {
        return (screenType == null) ? DEFAULT_SCREEN_TYPE : screenType.get();
    }

    public StringProperty screenTypeProperty() {
        return (screenType == null) ? new SimpleStringProperty(this, "screenType", DEFAULT_SCREEN_TYPE) : screenType;
    }

    public void setScreenType(String newScreenType) {
        if (screenType != null && !screenType.get().equals(DEFAULT_SCREEN_TYPE))
            screenType.set(newScreenType);
    }

}
