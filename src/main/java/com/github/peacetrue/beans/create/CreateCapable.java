package com.github.peacetrue.beans.create;

import com.github.peacetrue.beans.properties.createdtime.CreatedTimeCapable;
import com.github.peacetrue.beans.properties.creatorid.CreatorIdCapable;

/**
 * @author peace
 **/
public interface CreateCapable<T, S> extends CreatorIdCapable<T>, CreatedTimeCapable<S> {
}
