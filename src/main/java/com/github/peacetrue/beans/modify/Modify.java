package com.github.peacetrue.beans.modify;

import com.github.peacetrue.beans.properties.modifiedtime.ModifiedTime;
import com.github.peacetrue.beans.properties.modifierid.ModifierId;

/**
 * @author peace
 **/
public interface Modify<T, S> extends
        ModifyCapable<T, S>, ModifyAware<T, S>,
        ModifierId<T>, ModifiedTime<S> {
}
