package com.github.peacetrue.beans.operator;


import com.github.peacetrue.beans.properties.operatorid.OperatorIdAware;
import com.github.peacetrue.beans.properties.operatorname.OperatorNameAware;

/**
 * @author peace
 **/
public interface OperatorAware<T> extends OperatorIdAware<T>, OperatorNameAware {
}
