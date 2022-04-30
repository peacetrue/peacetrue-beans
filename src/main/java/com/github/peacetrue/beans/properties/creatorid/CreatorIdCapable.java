package com.github.peacetrue.beans.properties.creatorid;

/**
 * @param <T> the type of creatorId
 * @author peace
 **/
public interface CreatorIdCapable<T> {

    String PROPERTY_CREATOR_ID = "creatorId";

    T getCreatorId();
}
