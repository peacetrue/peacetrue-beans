package com.github.peacetrue.beans.properties.id;

/**
 * @param <T> the type of id
 * @author peace
 **/
public interface IdCapable<T> {

    String PROPERTY_ID = "id";

    T getId();
}
