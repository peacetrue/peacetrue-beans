package com.github.peacetrue.beans.properties.serialnumber;

/**
 * @param <T> the type of serialNumber
 * @author peace
 **/
public interface SerialNumberCapable<T> {

    String PROPERTY_SERIAL_NUMBER = "serialNumber";

    T getSerialNumber();
}
