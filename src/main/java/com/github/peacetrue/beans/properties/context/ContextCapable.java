package com.github.peacetrue.beans.properties.context;

/**
 * @author peace
 **/
public interface ContextCapable<T> {

    String PROPERTY_CONTEXT = "context";

    T getContext();

}
