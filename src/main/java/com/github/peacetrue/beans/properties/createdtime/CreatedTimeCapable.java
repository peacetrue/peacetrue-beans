package com.github.peacetrue.beans.properties.createdtime;

/**
 * @param <T> the type of createdTime
 * @author peace
 **/
public interface CreatedTimeCapable<T> {

    String PROPERTY_CREATED_TIME = "createdTime";

    T getCreatedTime();
}
