package com.github.peacetrue.beans;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author peace
 *
 **/
class BeanTest {

    /** 总共 22 个属性 */
    @Test
    void propertyCount() {
        String prefix = "com.github.peacetrue.beans.properties";
        Reflections reflections = new Reflections(prefix, new SubTypesScanner(false));
        Set<String> allTypes = reflections.getAllTypes();
        Assertions.assertEquals(22 * 3, allTypes.size());
    }

    /** 总共 6 个 Bean */
    @Test
    void beanCount() {
        String prefix = "com.github.peacetrue.beans";
        Reflections reflections = new Reflections(prefix, new SubTypesScanner(false));
        Set<String> allTypes = reflections.getAllTypes();
        int fromIndex = (prefix + ".?").length();
        allTypes = allTypes.stream()
                .filter(name -> !name.equals(BeanTest.class.getName()))
                .map(name -> name.substring(0, name.indexOf('.', fromIndex)))
                .filter(name -> !name.endsWith("properties") && !name.endsWith("annotations"))
                .collect(Collectors.toSet());
        Assertions.assertEquals(6, allTypes.size());
    }
}
