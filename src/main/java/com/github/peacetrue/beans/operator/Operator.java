package com.github.peacetrue.beans.operator;

import com.github.peacetrue.beans.properties.operatorid.OperatorId;
import com.github.peacetrue.beans.properties.operatorname.OperatorName;

/**
 * @author peace
 **/
public interface Operator<T> extends
        OperatorCapable<T>, OperatorAware<T>,
        OperatorId<T>, OperatorName {

    static <S extends OperatorCapable<U>, T extends OperatorAware<U>, U> T setOperator(S source, T target) {
        target.setOperatorId(source.getOperatorId());
        target.setOperatorName(source.getOperatorName());
        return target;
    }


}
