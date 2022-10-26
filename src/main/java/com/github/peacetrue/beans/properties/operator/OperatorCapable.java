package com.github.peacetrue.beans.properties.operator;


/**
 * @author peace
 **/
public interface OperatorCapable<T> {

    String PROPERTY_OPERATOR = "operator";

    com.github.peacetrue.beans.operator.OperatorCapable<T> getOperator();

}
