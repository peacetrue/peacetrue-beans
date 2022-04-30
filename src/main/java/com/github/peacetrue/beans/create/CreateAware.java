package com.github.peacetrue.beans.create;

import com.github.peacetrue.beans.properties.createdtime.CreatedTimeAware;
import com.github.peacetrue.beans.properties.creatorid.CreatorIdAware;

/**
 * @author peace
 **/
public interface CreateAware<T, S> extends CreatorIdAware<T>, CreatedTimeAware<S> {
}
