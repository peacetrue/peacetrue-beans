package com.github.peacetrue.beans.operator;

import lombok.*;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author peace
 **/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OperatorImpl<T> implements Operator<T> {

    private T id;
    private String name;

}
