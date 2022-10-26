package com.github.peacetrue.beans.properties.operator;

import lombok.*;

/**
 * @author peace
 **/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OperatorImpl<T> implements Operator<T> {
    private com.github.peacetrue.beans.operator.OperatorCapable<T> operator;
}
