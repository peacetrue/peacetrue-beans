package com.github.peacetrue.beans.properties.operator;

/**
 * @author peace
 **/
public interface Operator<T> extends OperatorCapable<T>, OperatorAware<T> {
    static <S extends OperatorCapable<U>, T extends OperatorAware<U>, U> T setOperator(S source, T target) {
        target.setOperator(source.getOperator());
        return target;
    }
}
