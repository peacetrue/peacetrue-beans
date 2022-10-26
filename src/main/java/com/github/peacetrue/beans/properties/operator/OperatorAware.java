package com.github.peacetrue.beans.properties.operator;


/**
 * @author peace
 **/
public interface OperatorAware<T> {

    void setOperator(com.github.peacetrue.beans.operator.OperatorCapable<T> operator);

}
