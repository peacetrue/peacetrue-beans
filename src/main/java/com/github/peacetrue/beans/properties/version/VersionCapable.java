package com.github.peacetrue.beans.properties.version;

/**
 * 获取版本接口。
 *
 * @author peace
 **/
public interface VersionCapable {

    /** 版本属性 */
    String PROPERTY_VERSION = "version";

    /**
     * 获取版本。
     *
     * @return 版本
     */
    Long getVersion();
}
