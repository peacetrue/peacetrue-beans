package com.github.peacetrue.beans.createmodify;

import com.github.peacetrue.beans.properties.createdtime.CreatedTimeAware;
import com.github.peacetrue.beans.properties.creatorid.CreatorIdAware;
import com.github.peacetrue.beans.properties.modifiedtime.ModifiedTimeAware;
import com.github.peacetrue.beans.properties.modifierid.ModifierIdAware;

/**
 * @author peace
 **/
public interface CreateModifyAware<T, S> extends
        CreatorIdAware<T>, CreatedTimeAware<S>,
        ModifierIdAware<T>, ModifiedTimeAware<S> {
}
