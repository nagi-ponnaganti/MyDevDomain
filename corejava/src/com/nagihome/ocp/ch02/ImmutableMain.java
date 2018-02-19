package com.nagihome.ocp.ch02;

import java.util.ArrayList;
import java.util.List;

public final class ImmutableMain {

    private final int intProp;
    private final String strProp;
    private final List<String> listStr;

    public ImmutableMain(int intProp, String strProp, List<String> listStr) {
        this.intProp = intProp;
        this.strProp = strProp;
        if (listStr != null)
            throw new RuntimeException("ImmutableMain listStr Can't Be Null");
        this.listStr = new ArrayList<>(listStr);

    }

    public int getIntProp() {
        return intProp;
    }

    public String getStrProp() {
        return strProp;
    }

    public List<String> getListStr() {
        return listStr;
    }
}
