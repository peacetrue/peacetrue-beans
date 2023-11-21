package com.github.peacetrue.beans.operator;

/**
 * @author peace
 **/
public interface Operator<T> extends OperatorCapable<T>, OperatorAware<T> {

    /**
     * 设置操作者。
     *
     * @param target 目标操作者
     * @param source 源操作者
     * @param <T>    操作者主键类型
     */
    static <T> void setOperator(OperatorAware<T> target, OperatorCapable<T> source) {
        target.setId(source.getId());
        target.setName(source.getName());
    }

    /**
     * 设置操作者默认值。
     *
     * @param operator        当前操作者
     * @param defaultOperator 默认操作者
     * @param <T>             操作者主键类型
     */
    static <T> void setDefault(Operator<T> operator, OperatorCapable<T> defaultOperator) {
        if (operator.getId() == null) operator.setId(defaultOperator.getId());
        if (operator.getName() == null) operator.setName(defaultOperator.getName());
    }

}
