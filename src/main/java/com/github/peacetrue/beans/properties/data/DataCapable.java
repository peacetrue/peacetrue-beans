package com.github.peacetrue.beans.properties.data;

/**
 * @param <T> the type of data
 * @author peace
 **/
public interface DataCapable<T> {

    String PROPERTY_DATA = "data";

    T getData();
}
