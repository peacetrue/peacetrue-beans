package com.github.peacetrue.beans.properties.operatorid;


/**
 * @param <T> the type of operatorId
 * @author peace
 **/
public interface OperatorIdCapable<T> {

    String PROPERTY_OPERATOR_ID = "operatorId";

    T getOperatorId();
}
