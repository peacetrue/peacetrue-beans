package com.github.peacetrue.beans.properties.modifierid;

/**
 * @param <T> the type of modifierId
 * @author peace
 **/
public interface ModifierIdCapable<T> {

    String PROPERTY_MODIFIER_ID = "modifierId";

    T getModifierId();
}
