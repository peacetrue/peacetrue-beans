package com.github.peacetrue.beans.modify;

import com.github.peacetrue.beans.properties.modifiedtime.ModifiedTimeAware;
import com.github.peacetrue.beans.properties.modifierid.ModifierIdAware;

/**
 * @author peace
 **/
public interface ModifyAware<T, S> extends ModifierIdAware<T>, ModifiedTimeAware<S> {
}
