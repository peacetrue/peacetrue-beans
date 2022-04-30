package com.github.peacetrue.beans.modify;

import com.github.peacetrue.beans.properties.modifiedtime.ModifiedTimeCapable;
import com.github.peacetrue.beans.properties.modifierid.ModifierIdCapable;

/**
 * @author peace
 **/
public interface ModifyCapable<T, S> extends ModifierIdCapable<T>, ModifiedTimeCapable<S> {
}
