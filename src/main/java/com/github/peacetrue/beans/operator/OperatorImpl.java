package com.github.peacetrue.beans.operator;

import lombok.*;

/**
 * @author peace
 **/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class OperatorImpl<T> implements Operator<T> {

    private T id;
    private String name;

}
