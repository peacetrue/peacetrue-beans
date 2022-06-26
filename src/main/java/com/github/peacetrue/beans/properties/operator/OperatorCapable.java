package com.github.peacetrue.beans.properties.operator;


/**
 * @author peace
 **/
public interface OperatorCapable {

    String PROPERTY_OPERATOR = "operator";

    com.github.peacetrue.beans.operator.Operator<?> getOperator();

}
