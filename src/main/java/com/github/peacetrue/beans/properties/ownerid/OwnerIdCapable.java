package com.github.peacetrue.beans.properties.ownerid;

/**
 * @param <T> the type of ownerId
 * @author peace
 **/
public interface OwnerIdCapable<T> {

    String PROPERTY_OWNER_ID = "ownerId";

    T getOwnerId();
}
