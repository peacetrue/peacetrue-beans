package com.github.peacetrue.beans.createmodify;

import com.github.peacetrue.beans.properties.createdtime.CreatedTimeCapable;
import com.github.peacetrue.beans.properties.creatorid.CreatorIdCapable;
import com.github.peacetrue.beans.properties.modifiedtime.ModifiedTimeCapable;
import com.github.peacetrue.beans.properties.modifierid.ModifierIdCapable;

/**
 * @author peace
 **/
public interface CreateModifyCapable<T, S> extends
        CreatorIdCapable<T>, CreatedTimeCapable<S>,
        ModifierIdCapable<T>, ModifiedTimeCapable<S> {
}
