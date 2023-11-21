package com.github.peacetrue.beans.properties.username;

/**
 * @author peace
 **/
public interface UsernameCapable {

    String PROPERTY_USERNAME = "username";
    /** path variable in url. eg: /users/{username}/exists */
    String PATH_VAR_USERNAME = "/{username}";

    String getUsername();
}
