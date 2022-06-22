package com.github.peacetrue.beans.modify;

import com.github.peacetrue.beans.operator.OperatorCapable;
import com.github.peacetrue.beans.properties.modifiedtime.ModifiedTime;
import com.github.peacetrue.beans.properties.modifiedtime.ModifiedTimeAware;
import com.github.peacetrue.beans.properties.modifierid.ModifierId;
import com.github.peacetrue.beans.properties.modifierid.ModifierIdAware;

/**
 * @author peace
 **/
public interface Modify<T, S> extends
        ModifyCapable<T, S>, ModifyAware<T, S>,
        ModifierId<T>, ModifiedTime<S> {

    static <S extends OperatorCapable<U>, T extends ModifierIdAware<U> & ModifiedTimeAware<C>, U, C> T setModify(S source, T target, C now) {
        target.setModifierId(source.getId());
        target.setModifiedTime(now);
        return target;
    }
}
