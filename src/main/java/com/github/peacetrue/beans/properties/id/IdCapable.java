package com.github.peacetrue.beans.properties.id;

import javax.annotation.Nullable;
import java.util.Objects;
import java.util.function.IntSupplier;

/**
 * @param <T> the type of id
 * @author peace
 **/
public interface IdCapable<T> {

    String PROPERTY_ID = "id";
    /** path variable in url. eg: /users/{id}/exists */
    String PATH_VAR_ID = "/{id}";

    T getId();

    /**
     * compare two {@link IdCapable} object are equals.
     *
     * @param self   the current this object
     * @param equals the equals to object
     * @return {@code true} if they are equals, otherwise {@code false}
     */
    static boolean equals(IdCapable<?> self, @Nullable Object equals) {
        return self == equals
                || (equals != null
                && self.getClass().equals(equals.getClass())
                && Objects.equals(self.getId(), ((IdCapable<?>) equals).getId()));
    }

    /**
     * get the {@link IdCapable} hashcode.
     *
     * @param self          the current this object
     * @param superHashcode super {@link Object#hashCode()}
     * @return hashcode from {@link #getId()} or {@link Object}
     */
    static int hashCode(IdCapable<?> self, IntSupplier superHashcode) {
        Object id = self.getId();
        return id == null ? superHashcode.getAsInt() : id.hashCode();
    }
}
