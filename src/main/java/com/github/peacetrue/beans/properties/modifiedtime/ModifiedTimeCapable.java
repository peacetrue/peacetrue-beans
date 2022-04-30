package com.github.peacetrue.beans.properties.modifiedtime;

/**
 * @param <T> the type of modifiedTime
 * @author peace
 **/
public interface ModifiedTimeCapable<T> {

    String PROPERTY_MODIFIED_TIME = "modifiedTime";

    T getModifiedTime();
}
